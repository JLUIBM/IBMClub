<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.*, cn.jluibm.model.entity.*,java.text.*,java.sql.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getSession().getAttribute("login") == null){
			PrintWriter pw = response.getWriter();
			pw.println("您尚未登录，请先登录");
			response.setHeader("refresh", "2,url=" + request.getContextPath()+"/登录页面");
		}
	%>
	当前的活动有：
	<table border = "1">
		<tr>
			<th>活动名称</th>
			<th>活动开始时间</th>
			<th>活动发布时间</th>
		</tr>
		<%
			@SuppressWarnings("unchecked")
			List<Activity> list = (ArrayList<Activity>)request.getAttribute("ActivityList");
			for (int i = 0; i < list.size(); i++)
			{
				String name = list.get(i).getTitle();
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				int ActivityID = list.get(i).getActivityId();
				Timestamp ts = list.get(i).getActivityTime();
				String Atime = "";
				Atime = sdf.format(ts);
				ts = list.get(i).getPublishTime();
				String Ptime = "";
				Ptime = sdf.format(ts);
		%>
			<tr>
				<td><%= name%></td>
				<td><%= Atime%></td>
				<td><%= Ptime%></td>
				<td><a href = "<%= request.getContextPath() %>/ActivitySignInServlet/?target=insert&aID=<%=ActivityID %>" >签到</a></td>
			</tr>
		<%
			}
		%>
		
	</table>
</body>
</html>