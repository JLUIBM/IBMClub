package cn.jluibm.controller;

import cn.jluibm.model.dao.impl.EssayDao;
import cn.jluibm.model.entity.Essay;
import cn.jluibm.model.entity.User;
import cn.jluibm.utils.SQLTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 使用反射以"/essay?m=xxx"的形式访问EssayServlet
 * m为方法名称
 *
 * Have done
 * 1.分页显示文章列表
 * 2.查看文章
 * 3.编辑文章 使用wangEditor
 * 4.删除文章
 * 3,4需要管理员权限 默认permission为1时可以访问
 * 默认session中的User对象名称为user
 *
 * Want To Do:
 * 1.错误页面的地址更改
 *
 */
public class EssayServlet extends HttpServlet
{
    //DAO
    EssayDao essayDao = new EssayDao();

    //调用doPost
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    //反射调用其它方法
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        //1.获取参数为m的方法名称
        String methodName = request.getParameter("m");

        System.out.println("m: " +methodName);

        //2.获取方法
        try {
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            //3.执行方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            /**
             * 跳转错误页
             */
            response.sendRedirect(request.getContextPath() +"/index.jsp");
            return;
        }

    }

    /**
     * TODO:文章列表
     * 以分页的形式返回文章列表
     * 默认1页显示10篇文章
     * 按照topic属性分类
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getEssays(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String essayPageNoStr = request.getParameter("essayPageNo");
        String essayTitleStr = request.getParameter("essayTitle");
        int essayPageNo = 1;
        long totalEssayNumber = 0;
        int totalEssayPageNumber = 0;
        int pageSize = 10;
        String essayTitle = essayTitleStr;
        List<Essay> essayList = null;
        try {
            essayPageNo = Integer.parseInt(essayPageNoStr);
        }catch (NumberFormatException e){
            essayPageNo = 1;
        }
        if (essayPageNo <= 0)
        {
            essayPageNo = 1;
        }
        if (essayTitle == null)
        {
            String sql = "SELECT COUNT(*) FROM essays WHERE type = ?";
            totalEssayNumber = (long)essayDao.getSingleValue(sql, 1);
        }
        else
        {
            essayTitle = "%" +essayTitle +"%";
            String sql = "SELECT COUNT(*) FROM essays WHERE type = ? AND title LIKE ?";
            totalEssayNumber = (long)essayDao.getSingleValue(sql, 1 ,essayTitle);
        }
        totalEssayPageNumber = (int)totalEssayNumber / pageSize;
        if (totalEssayNumber % pageSize != 0)
        {
            totalEssayPageNumber += 1;
        }
        if (essayTitle == null)
        {
            String sql = SQLTools.QUERY_ESSAY +" WHERE type = ? LIMIT ?, ?";
            essayList = new ArrayList<>(essayDao.getForList(sql, 1,
                    (essayPageNo -1)*pageSize, pageSize));
        }
        else
        {
            String sql = SQLTools.QUERY_ESSAY +" WHERE type = ? AND title LIKE ? LIMIT ?, ?";
            essayList = new ArrayList<>(essayDao.getForList(sql, 1,
                    essayTitle, (essayPageNo -1)*pageSize, pageSize));
            essayTitle = essayTitleStr;

        }
        request.setAttribute("essayPageNo", essayPageNo);
        request.setAttribute("essayTitle", essayTitle);
        request.setAttribute("totalEssayPageNumber", totalEssayPageNumber);
        request.setAttribute("essayList", essayList);
        request.getRequestDispatcher("/WEB-INF/essay/essays.jsp").forward(request, response);
    }

    /**
     * TODO:查看文章
     * 根据文章的essayId返回文章的具体内容
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getEssay(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String essayIdStr = request.getParameter("essayId");
        int essayId = -1;
        if (essayIdStr != null)
        {
            try {
                essayId = Integer.parseInt(essayIdStr);
            }catch (NumberFormatException e){
                essayId = -1;
            }
        }

        Essay essay = null;
        if (essayId < 0)
        {
            /**
             * 跳转错误页
             */
            response.sendRedirect(request.getContextPath() +"/index.jsp");
            return;
        }
        //获取文章
        else
        {
            String sql = SQLTools.QUERY_ESSAY +" WHERE type = ? AND essay_id = ?";
            essay = essayDao.getSingleObject(sql, 1, essayId);
        }
        if (essay == null)
        {
            response.sendRedirect(request.getContextPath() +"/index.jsp");
            return;
        }
        request.setAttribute("essay", essay);
        request.getRequestDispatcher("/WEB-INF/essay/essay.jsp").forward(request, response);
    }

    /**
     * TODO:编辑文章
     * 检查用户是否为管理员
     * 根据参数内容是否为空判断新建还是编辑
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void editEssay(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int permission = user.getPermission();
        if (permission != 1)
        {
            /**
             * 跳转错误页
             */
            response.sendRedirect(request.getContextPath() +"/WEB-INF/index.jsp");
            return;
        }

        String essayIdStr = request.getParameter("essayId");
        if (essayIdStr == null)
        {
            request.getRequestDispatcher("/WEB-INF/admin/editEssay.jsp").forward(request, response);
        }
        int essayId = -1;
        try {
            essayId = Integer.parseInt(essayIdStr);
        }catch (NumberFormatException e){
            essayId = -1;
        }
        if (essayId < 0)
        {
            request.getRequestDispatcher("/WEB-INF/admin/editEssay.jsp").forward(request, response);
            return;
        }

        Essay essay = null;
        String sql = SQLTools.QUERY_ESSAY +" WHERE type = ? AND essay_Id = ?";
        essay = essayDao.getSingleObject(sql, 1, essayId);
        System.out.println("essayContent: " +essay.getContent());
        if (essay == null)
        {
            request.getRequestDispatcher("/WEB-INF/admin/editEssay.jsp").forward(request, response);
            return;
        }

        request.setAttribute("essay", essay);
        request.getRequestDispatcher("/WEB-INF/admin/editEssay.jsp").forward(request, response);
    }

    /**
     * TODO:保存文章
     * 1.检查用户是否为管理员
     * 2.根据essayId保存文章
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void saveEssay(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int permission = user.getPermission();
        if (permission != 1)
        {
            /**
             * 跳转错误页
             */
            response.sendRedirect(request.getContextPath() +"/WEB-INF/index.jsp");
        }

        String content = request.getParameter("essayContent");
        String title = request.getParameter("essayTitle");
        String topic = request.getParameter("essayTopic");
        String author = user.getUsername();
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());

        String essayIdStr = request.getParameter("essayId");
        int essayId = -1;
        try {
            essayId = Integer.parseInt(essayIdStr);
        }catch (NumberFormatException e){
            essayId = -1;
        }
        if (essayId < 0)
        {
            Essay essay = new Essay();
            essay.setTime(time);
            essay.setTopic(topic);
            essay.setType(1);
            essay.setContent(content);
            essay.setAuthor(author);
            essay.setTitle(title);
            essayDao.addObject(essay);
            request.setAttribute("essayMessage", "保存成功");
            request.getRequestDispatcher("/WEB-INF/essay/essayResult.jsp").forward(request, response);
            return;
        }
        else
        {
            String sql = "UPDATE essays SET title = ?, time = ?, " +
                    " topic = ?, content = ? WHERE essay_Id = ? AND type = ?";
            essayDao.update(sql, title, time, topic, content, essayId, 1);
            request.setAttribute("essayMessage", "修改成功");
            request.getRequestDispatcher("/WEB-INF/essay/essayResult.jsp").forward(request, response);
        }
    }
    /**
     * TODO:删除文章
     * 根据文章的essayId删除文章
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void removeEssay(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int permission = user.getPermission();
        if (permission != 1)
        {
            /**
             * 跳转错误页
             */
            response.sendRedirect("/WEB-INF/index.jsp");
            return;
        }

        String essayIdStr = request.getParameter("essayId");
        int essayId = -1;
        try {
            essayId = Integer.parseInt(essayIdStr);
        }catch (NumberFormatException e){
            e.printStackTrace();
            essayId = -1;
        }
        if (essayId < 0)
        {
            /**
             * 直接跳转
             */
            request.setAttribute("essayMessage", "文章无法删除或者已经删除!");
            request.getRequestDispatcher("/WEB-INF/essay/essayResult.jsp").forward(request, response);
        }

        essayDao.deleteObjectByKey(essayId);
        request.setAttribute("essayMessage", "删除成功!");
        request.getRequestDispatcher("/WEB-INF/essay/essayResult.jsp").forward(request, response);

    }

}
