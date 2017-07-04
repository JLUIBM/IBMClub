<%--
  Created by IntelliJ IDEA.
  User: hyec
  Date: 2017/6/4
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="message" items="${messages}">
    <p>${message}</p>
</c:forEach>
</body>
</html>
