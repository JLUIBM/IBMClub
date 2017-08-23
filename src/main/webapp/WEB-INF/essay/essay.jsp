<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="essay?m=getEssays&essayPageNo=${param.essayPageNo}&essayTitle=${param.essayTitle}">返回文章列表</a>
	<br><br>

	<center>

		标题:<p>${requestScope.essay.title}</p>
		<br>

		作者:<p>${requestScope.essay.author}</p>
		<br>

		发布时间:<p>${requestScope.essay.time}</p>
		<br>

		主题:<p>${requestScope.essay.topic}</p>
		<br>

		内容:<p>${requestScope.essay.content}</p>

	</center>

</body>
</html>