package cn.jluibm.controller;

import java.io.IOException;
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
 * Servlet implementation class EssayDetail
 */
public class EssayDetailServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public EssayDetailServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//根据url传值的index找到essay位置在跳到jsp显示
		HttpSession session = request.getSession();
		//判断index合法性 为整形
		Pattern pattern = Pattern.compile("^[0-9]{1,5}$"); 
		if(! pattern.matcher((CharSequence) request.getParameter("index")).matches())
		{
			//错误处理页
			response.sendRedirect(null);
		}
		List<Essay> essayList = (List<Essay>) session.getAttribute("essayList");
		int index = Integer.parseInt(request.getParameter("index"));
		Essay essay = essayList.get(index);
		//放request
		String title = (String) ReflectionTools.getter(essay, "title");
		String author = (String) ReflectionTools.getter(essay, "author");
		String content = (String) ReflectionTools.getter(essay, "content");
		String time = (String) ReflectionTools.getter(essay, "time");
		String topic = (String) ReflectionTools.getter(essay, "topic");
		request.setAttribute("title", title);
		request.setAttribute("author", author);
		request.setAttribute("content", content);
		request.setAttribute("time", time);
		request.setAttribute("topic", topic);
		request.getRequestDispatcher("/WEB-INF/essayjsp/essayDetail.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
