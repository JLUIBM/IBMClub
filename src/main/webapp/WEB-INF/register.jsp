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

    <link href="<c:url value="/css/register.css"/>" type="text/css" rel="stylesheet">
</head>


<body>
<div class="bg">
    <div id="wrap">
        <div class="tit">
            <p class="word">注册</p>
        </div>
        <div class="content">
            <form action="<c:url value="/register"/>" method="post">
                <dl class="cont1">
                    <dd>Email</dd>
                    <dt><input type="text" name="email" id="email" tabindex="5" placeholder="请输入Email地址" value="${email}">
                    </dt>
                </dl>
                <dl class="cont1">
                    <dd>密码</dd>
                    <dt><input type="password" name="password" id="password" placeholder="请输入密码" value=""></dt>
                </dl>
                <dl class="cont1">
                    <dd>确认密码</dd>
                    <dt><input type="password" name="repassword" id="repassword" placeholder="请确认密码" value=""></dt>
                </dl>
                <dl class="cont1">
                    <dd>真实姓名</dd>
                    <dt><input type="text" name="realname" id="realname" placeholder="请输入真实姓名" value="${realname}"></dt>
                </dl>
                <dl class="cont1">
                    <dd>电话号码</dd>
                    <dt><input type="text" alt="" name="phonenum" id="phonenum" placeholder="请输入可联系的电话号码"></dt>
                </dl>
                <div class="bottom_btn">
                    <button type="submit" value="注册" id="register_btn">注册</button>
                </div>
                <a href="<c:url value="/login" />" class="alright">已有账号</a>

                <c:forEach var="message" items="${messages}">
                    <p>${message}</p>
                </c:forEach>
            </form>
        </div>
    </div>
</div>
</body>

</html>
