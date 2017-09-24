package cn.jluibm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jluibm.model.dao.impl.ActivityDao;
import cn.jluibm.model.entity.Activity;

public class ActivityInputServlet extends HttpServlet 
{
	public ActivityInputServlet() 
	{
		super();
	}
	public void destroy()
	{}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/activity/ActivityInputJsp.jsp").forward(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession u=request.getSession();
		PrintWriter out=response.getWriter();
		int user_id = 123456;
				//(int)u.getAttribute("user_id");
		String activity_id;    //活动ID
		String title;          //活动标题
		String activity_time;  //活动时间
		String manager;        //活动负责人
		String location;       //活动地点
		String content;        //活动内容
		String flag;
		Date adate = null;
		Date cdate = null;
		flag=request.getParameter("flag");
		activity_id=request.getParameter("activity_id");
		title=request.getParameter("title");
		manager=request.getParameter("manager");
		activity_time=request.getParameter("activity_time");
		location=request.getParameter("location");
		content=request.getParameter("content");
		boolean IsDate=true;
		if(title==null||manager==null||location==null||content==null||activity_time==null)
		{
			request.getRequestDispatcher("/WEB-INF/activity/ActivityInputJsp.jsp").forward(request,response);
			return;
		}
		if(title.equals("")||manager.equals("")||location.equals("")||content.equals("")||activity_time.equals(""))
		{
			request.setAttribute("message","不能为空！");
			request.setAttribute("activity_id",activity_id);
			request.setAttribute("title",title);
			request.setAttribute("activity_time",activity_time);
			request.setAttribute("manager",manager);
			request.setAttribute("location",location);
			request.setAttribute("content",content);
			request.getRequestDispatcher("/WEB-INF/activity/ActivityInputJsp.jsp").forward(request,response);
			return;
		}
//日期是否合法
		try {
		    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		    format.setLenient(false);  
		    adate=format.parse(activity_time);
		} catch (Exception ex){
		    IsDate=false;
		}
		
		try {
			Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String str_date = sdf.format(d);
			cdate=sdf.parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(title.length()>64||title.length()<1||!IsDate||manager.length()>30||manager.length()<1||location.length()>30||location.length()<1||content.length()>1024||content.length()<1)
		{
			request.setAttribute("message","填写长度出错");
			request.setAttribute("activity_id",activity_id);
			request.setAttribute("title",title);
			request.setAttribute("activity_time",activity_time);
			request.setAttribute("manager",manager);
			request.setAttribute("location",location);
			request.setAttribute("content",content);
			request.getRequestDispatcher("/WEB-INF/activity/ActivityInputJsp.jsp").forward(request,response);
			return;
		}
		Activity ac=new Activity();
		ac.setTitle(title);
		ac.setActivityTime(new Timestamp(adate.getTime()));
		ac.setPublishTime(new Timestamp(cdate.getTime()));
		ac.setManager(manager);
		ac.setLocation(location);
		ac.setContent(content);
		ac.setUserId(user_id);
		ActivityDao adao=new ActivityDao();
		if(flag.equals("0"))
		{
			adao.addObject(ac);
			request.getRequestDispatcher("/WEB-INF/activity/ActivityInformJsp.jsp").forward(request,response);
		}
		if(flag.equals("1"))
		{
			String sql = "update activities set title=?,activity_time=?,publish_time=?,manager=?,location=?,content=?,user_id=? where activity_id=?;";
			adao.update(sql,title,activity_time,new Timestamp(cdate.getTime()),manager,location,content,user_id,activity_id);
			request.getRequestDispatcher("/WEB-INF/activity/ActivityInformJsp3.jsp").forward(request,response);
		}
		return;
	}
	public void init() throws ServletException 
	{}
}
