<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String title = (String) request.getAttribute("title");
		String author = (String) request.getAttribute("author");
		String time = (String) request.getAttribute("time");
		String topic = (String) request.getAttribute("topic");
		String content = (String) request.getAttribute("content");
	%>
	<a href="<%= request.getContextPath() %>/essay">返回文章列表</a>
	标题:<p>${requestScope.title}</p>
	<br>
	
	作者:<p>${requestScope.author}</p>
	<br>
	
	发布时间:<p>${requestScope.time}</p>
	<br>
	
	主题:<p>${requestScope.topic}</p>
	<br>
	
	内容:<p>${requestScope.content}</p>
</body>
</html>