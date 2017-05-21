<%--
  Created by IntelliJ IDEA.
  User: hyec
  Date: 2017/5/14
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">

    <p>${message}</p>

    <br/>

    <label for="email">邮箱</label>
    <input name="email" id="email" value="${email}" />

    <br/>

    <label for="password">密码</label>
    <input name="password" id="password" value="${password}" />

    <br/>

    <input name="from" type="hidden" value="${from}" />
    <button type="submit">登录</button>
</form>
</body>
</html>
