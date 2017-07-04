package cn.jluibm.controller;

import cn.jluibm.model.dao.impl.UserDao;
import cn.jluibm.model.entity.User;
import cn.jluibm.utils.FormTools;
import cn.jluibm.utils.SQLTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by hyec on 2017/5/7.
 */
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        this.userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user;
        try {
            user = userForm(request);

            User checkUser = userDao.getSingleObject(
                    SQLTools.QUERY_USER + "where email=?", user.getEmail());

            if (checkUser != null) {
                throw new RegisterException("邮箱已存在");
            }

        } catch (RegisterException re) {
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("realname", request.getParameter("realname"));
            request.setAttribute("messages", re.getMessage());

            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

            return;
        }

        //TODO: 实现下列功能
        user.setUsername("test");
        user.setSex(false);
        user.setAcademy("2015");
        user.setDegree(0);
        user.setGrade(0);
        user.setPermission(0);
        user.setPhoneNum("000");
        user.setStudentNum("000");
        user.setSignupTime(new java.sql.Date(new Date().getTime()));
        user.setQq("");

        userDao.addObject(user);

        response.sendRedirect(request.getContextPath() + "/login?reg=success");

    }

    private static User userForm(HttpServletRequest request) throws RegisterException {
        User user = new User();

        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setRealname(request.getParameter("realname"));
        user.setPhoneNum(request.getParameter("phonenum"));

        if (!FormTools.checkEmail(user.getEmail())) {
            throw new RegisterException("邮箱非法");
        }

        if (!FormTools.checkText(user.getPassword(), 6, 20)) {
            throw new RegisterException("密码长度不合法");
        }

        if (!FormTools.checkText(user.getRealname(), 2, 10)) {
            throw new RegisterException("用户名长度不合法");
        }

        if (!FormTools.checkPhoneNum(user.getPhoneNum())) {
            throw new RegisterException("手机号不合法");
        }

        return user;
    }

    private static class RegisterException extends Exception {

        private static final long serialVersionUID = 1L;

        RegisterException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }

}

