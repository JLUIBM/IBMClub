<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="title" type="java.lang.String"--%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%;">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><c:out value="${title}" default="IBM俱乐部"/></title>
    <link href="<c:url value="/css/default.css"/> " type="text/css" rel="stylesheet">
    <link href="<c:url value="/css/main.css"/>" type="text/css" rel="stylesheet">
</head>

<body>
<div id="top">
    <div class="logo">
        <img src="<c:url value="/img/logo.png"/>">
    </div>
    <ul class="menu">
        <li><a href="<c:url value="/"/>"><span>加入我们</span></a></li>
        <li><a href="<c:url value="/"/>"><span>社团通知</span></a></li>
        <li><a href="<c:url value="/"/>"><span>我要签到</span></a></li>
        <li><a href="<c:url value="/essay"/>"><span>前沿文章</span></a></li>
    </ul>
    <ul class="register-login">
        <%-- TODO: login check. --%>
        <li><a href="<c:url value="/login"/>"><span>登录</span></a></li>
        <li><a href="<c:url value="/register"/>"><span>注册</span></a></li>
    </ul>
</div>

