<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.Calendar"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布活动</title>
</head>
<body>

	<% String message = (String)request.getAttribute("message");
		if(message != null) { %>
		
		<p> <%= message %> </p>
		
	<% } %>
	
	<form method="post" action="ActivityInputServlet-admin">
		活动标题:<input type="text" name="title" value="${title}">
		<br>
		活动时间:<input type="date" name="activity_time" value="${activity_time}">
		<br>
		活动负责人:<input type="text" name="manager" value="${manager}">
		<br>
		活动地点:<input type="text" name="location" value="${location}">
		<br>
		活动内容:<textarea rows="20" cols="20" name="content" charset="UTF-8" value="${content}"></textarea>
		<br>
		
		<%
		String activity_id = (String)request.getAttribute("activity_id");
		if(activity_id!=null&&!activity_id.equals("-1")) {
		%>
		<input type="hidden" name="flag" value=1>
		<input type="hidden" name="activity_id" value=<%=activity_id%>>
		<input type="submit" value="提交">
		<%} %>
		<%
		if(activity_id==null||activity_id.equals("-1")) {
		%>
		<input type="hidden" name="flag" value=0>
		<input type="submit" value="提交">
		<%} %>
	</form>
</body>
</html>
