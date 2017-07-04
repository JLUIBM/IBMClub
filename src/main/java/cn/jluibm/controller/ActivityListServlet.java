package cn.jluibm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jluibm.model.dao.impl.ActivityDao;
import cn.jluibm.model.entity.Activity;
import cn.jluibm.utils.SQLTools;

public class ActivityListServlet extends HttpServlet
{
	public ActivityListServlet()
	{
		super();
	}
	public void destroy()
	{
		super.destroy();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		request.getRequestDispatcher("/WEB-INF/activity/ActivityListJsp.jsp").forward(request,response);
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		ActivityDao ac = new ActivityDao();
		HttpSession u = request.getSession();
//		int userid = (int) u.getAttribute("user_id");
		List<Activity> activity = new ArrayList<Activity>();
		String sql = SQLTools.QUERY_ACTIVITY;
		activity = ac.getForList(sql);
		request.setAttribute("activity",activity);
		request.getRequestDispatcher("/WEB-INF/activity/ActivityListJsp.jsp").forward(request,response);
	}
	public void init() throws ServletException {}
}
