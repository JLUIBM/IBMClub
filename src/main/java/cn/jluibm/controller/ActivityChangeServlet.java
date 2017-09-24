package cn.jluibm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActivityChangeServlet extends HttpServlet {
	public ActivityChangeServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String activity_id;    //活动ID
		String title;          //活动标题
		String activity_time;  //活动时间
		String manager;        //活动负责人
		String location;       //活动地点
		String content;        //活动内容
		activity_id=request.getParameter("activity_id");
		title=request.getParameter("title");
		manager=request.getParameter("manager");
		activity_time=request.getParameter("activity_time");
		location=request.getParameter("location");
		content=request.getParameter("content");
		request.setAttribute("activity_id",activity_id);
		request.setAttribute("title",title);
		request.setAttribute("activity_time",activity_time);
		request.setAttribute("manager",manager);
		request.setAttribute("location",location);
		request.setAttribute("content",content);
		request.getRequestDispatcher("/WEB-INF/activity/ActivityInputJsp.jsp").forward(request,response);
	}
	public void init() throws ServletException
	{}
}
