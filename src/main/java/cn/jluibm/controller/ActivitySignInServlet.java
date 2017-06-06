package cn.jluibm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jluibm.model.dao.impl.ActivityDao;
import cn.jluibm.model.dao.impl.ActivitySigninDao;
import cn.jluibm.model.entity.Activity;
import cn.jluibm.model.entity.ActivitySignin;
import cn.jluibm.utils.SQLTools;

@SuppressWarnings("serial")
public class ActivitySignInServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ActivityDao adao = new ActivityDao();
		List<Activity> list = new ArrayList<Activity>();
		String sql = SQLTools.QUERY_ACTIVITY;
		list = adao.getForList(sql);
		
		request.setAttribute("ActivityList", list);
		request.getRequestDispatcher("/WEB-INF/ActivitySignIn.jsp").forward(request, response);
		
		String getTarget = request.getParameter("target");
		if("insert".equals(getTarget)){
			//将已签到用户写入签到表中
			ActivitySignin as = new ActivitySignin();
			int userId = (Integer) request.getSession().getAttribute("userId");
			int activityId = Integer.parseInt(request.getParameter("aID"));
			Timestamp signinTime = new Timestamp(System.currentTimeMillis());
			as.setUserId(userId);
			as.setActivityId(activityId);
			as.setSigninTime(signinTime);
			ActivitySigninDao asd = new ActivitySigninDao();
			asd.addObject(as);
			//跳转...
			out.println("您已签到成功");
			response.setHeader("refresh", "2,url=" + request.getContextPath()+"/ActivitySignIn.jsp");
		}
	}
}
