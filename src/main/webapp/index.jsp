<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="IBM Club" scope="request" />

<c:set var="addition_head" scope="request">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
</c:set>


<c:import url="/WEB-INF/partials/header.jsp" />

<div id="header" >
    <div class="text">
        <p class="text-tit">最高端的技术社团</p>
        <p class="text-cont1">web前端、后台开发、ps培训、算法分析、c/c++技术。</p>
        <p class="text-cont2">就业分享、蓝桥杯大赛、running code编程比赛。</p>
        <p class="text-cont3">你想要的我们都有!</p>
        <div class="join">
            <p class= "text-join"><a href="<c:url value="/register"/>">马上加入</a></p>
        </div>
    </div>
</div>
<!--//header-->
<!--content-->
<div id="cont1" >
    <div class="text">
        <p class="text-tit">优秀coder的聚集地</p>
        <p class="text-cont1">这里有就业于腾讯、华为、去哪儿等知名企业的学长带你get高端offer.</p>
        <p class="text-cont2">这里有专攻acm的算法大神带你玩转算法.</p>
        <p class="text-cont3">这里有各个方向（前端、java、python、C/C++等）的大神为你答疑解惑.</p>
        <div class = "join">
            <p class="text-join"><a href="<c:url value="/register"/>">To Be A Coder</a></p>
        </div>
    </div>

</div>
<div id="cont2" >
    <div class="tit">we’re coder，talk to us</div>
    <p class="text3">At ibmclub we really like talking to people.   Talking about ideas,   big and small.   Talking about design that inspire us, talking about the latest tech trends. Talking about… well, you get the technology.</p>
    <div class="join3"><a href="<c:url value="/register"/>">talk to us</a></div>
</div>
<div id="cont3" >
    <video autoplay>
        <source src="video/movie.mp4"/>
        <source src="video/movie.ogg"/>
        <source src="video/movie.webm"/>
        抱歉，浏览器要换了！
    </video>
</div>

<c:import url="/WEB-INF/partials/footer.jsp" />