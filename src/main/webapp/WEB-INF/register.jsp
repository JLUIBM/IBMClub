<%--
  Created by IntelliJ IDEA.
  User: hyec
  Date: 2017/5/7
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <meta charset="UTF-8">
</head>
<body>
<form method="post" >

    <c:forEach var="message" items="${messages}">
        <p>${message}</p>
    </c:forEach>

    <label for="email">邮箱</label>
    <input type="email" name="email" id="email" value="${email}" />

    <br/>

    <label for="password">密码</label>
    <input type="password" name="password" id="password" value="" />

    <br/>

    <label for="repeat">重复</label>
    <input type="password" name="repeat" id="repeat" value="" />

    <br/>

    <label for="realname">姓名</label>
    <input type="text" name="realname" id="realname" value="${realname}" />

    <br/>

    <label for="gender">性别</label>
    <select id="gender" name="gender" >
        <option selected disabled >请选择</option>
        <option value="1">男</option>
        <option value="2">女</option>
    </select>

    <button type="submit">提交</button>
</form>
</body>
</html>
