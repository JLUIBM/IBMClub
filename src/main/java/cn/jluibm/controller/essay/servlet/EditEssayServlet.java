package cn.jluibm.controller.essay.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jluibm.model.entity.Essay;
import cn.jluibm.utils.ReflectionTools;

/**
 * Servlet implementation class EditEssayServlet
 */
@WebServlet("/cn/jluibm/controller/essay/servlet/editssay")
public class EditEssayServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public EditEssayServlet() 
    {
        super();
    }

    //href跳转到doGet 编辑或者写文章请求跳转到相应的jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		Pattern pattern = Pattern.compile("^[0-9]{1,5}$"); 
		//没有传index 跳到writeEssay.jsp
		if (request.getParameter("index") == null)
		{
			request.getRequestDispatcher("/WEB-INF/essayjsp/writeEssay.jsp").forward(request, response);
		}
		//index非法 跳到错误页
		else if(! pattern.matcher((CharSequence) request.getParameter("index")).matches())
		{
			//错误处理页
			response.sendRedirect(null);
		}
		//加载内容编辑 跳到editEssay.jsp
		else
		{
			int index = Integer.parseInt(request.getParameter("index"));
			HttpSession session = request.getSession();
			List<Essay> essayList = (List<Essay>) session.getAttribute("essayList");
			//取得具体文章
			Essay essay = (Essay) essayList.get(index);
			//存入session
			String title = (String) ReflectionTools.getter(essay, "title");
			String content = (String) ReflectionTools.getter(essay, "content");
			String state = (String) ReflectionTools.getter(essay, "state");
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("state", state);
			request.getRequestDispatcher("/WEB-INF/essayjsp/editEssay.jsp").forward(request, response);
	
		}
	}

	//接收写文章jsp的请求 进行校验 存库
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//TODO:获取form信息 标题和内容不能为空
		if (request.getAttribute("title") == null || request.getAttribute("content") == null)
		{
			//TODO:内容不变 返回jsp
			request.getRequestDispatcher("/WEB-INF/essayjsp/editEssay.jsp").forward(request, response);
			
		}
		
		//判断是编辑还是写文章 编辑则update 写则insert
		else
		{
			//TODO:提交数据库
			HttpSession session = request.getSession();
			Essay essay = new Essay();
			ReflectionTools.setter(essay, "title", request.getAttribute("title"));
			ReflectionTools.setter(essay, "author", session.getAttribute("essayAuthor"));
			ReflectionTools.setter(essay, "content", request.getAttribute("content"));
			ReflectionTools.setter(essay, "type", session.getAttribute("essayType"));
			ReflectionTools.setter(essay, "time", new Timestamp(System.currentTimeMillis()));
			ReflectionTools.setter(essay, "topic", request.getAttribute("topic"));
			
		}
	}

}
