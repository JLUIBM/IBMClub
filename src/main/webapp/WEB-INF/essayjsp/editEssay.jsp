<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>编辑文章</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/essayEdit" method="post" >

	<label for="title">标题:</label>
	<input name="title" id="title" type="text" value="${requestScope.title}" >
	<br>
	
	<label for="topic">主题</label>
    <select name="topic" id="topic" >
        <option selected disabled >请选择</option>
        <option value="编程语言">编程语言</option>
        <option value=""></option>
    </select>
	<br>
	
	<label for="content">内容:</label>
	<textarea name="content" id="content" rows="30" cols="50">${requestScope.content}</textarea>
	<br>
	
	<input name="author" id="author" type="hidden" value="${sessionScope.essayAuthor}" >
	
	<input name="type" id="type" type="hidden" value="${sessionScope.essayType}">
	
	<input type="submit" value="发表">
</form>
</body>
</html>