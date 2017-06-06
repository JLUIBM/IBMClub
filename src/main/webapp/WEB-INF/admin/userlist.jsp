<%--
  Created by IntelliJ IDEA.
  User: hyec
  Date: 2017/5/28
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>

<table border="1">
    <tr>
        <th>用户名</th>
        <th>姓名</th>
    </tr>
    <c:forEach var="user" items="${users}">

        <tr>
            <td>${user["username"]}</td>
            <td>${user["realname"]}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
