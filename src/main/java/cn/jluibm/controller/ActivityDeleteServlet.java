package cn.jluibm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jluibm.model.dao.impl.ActivityDao;
import cn.jluibm.model.entity.Activity;
public class ActivityDeleteServlet extends HttpServlet
{
	public ActivityDeleteServlet()
	{
		super();
	}
	public void destroy() 
	{
		super.destroy();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ActivityDao adao=new ActivityDao();
		String activity_id=request.getParameter("activity_id");
		int id = Integer.valueOf(activity_id).intValue();
		adao.deleteObjectByKey(id);request.getRequestDispatcher("/WEB-INF/activity/ActivityInformJsp2.jsp").forward(request,response);
	}
	public void init() throws ServletException {}
}
