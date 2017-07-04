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
	
	<form method="post" >
		
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
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间   其实没有卵用sevlet重写了一个
		String str_date1 = formatter.format(currentTime); //将日期时间格式化   
		String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式   
		%> 
		<input type="hidden" name="publishtime" value="<%= str_date2%>">
		<input type="submit" value="提交">
		
	</form>
</body>
</html>
