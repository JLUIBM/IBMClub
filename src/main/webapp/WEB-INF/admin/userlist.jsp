<%--
  Created by IntelliJ IDEA.
  User: hyec
  Date: 2017/5/28
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="用户管理" scope="request"/>
<c:import url="/WEB-INF/partials/header.jsp"/>

<%--@elvariable id="users" type="java.util.List"--%>

<style>


    * {
        margin: 0;
        padding: 0;
        list-style: none;
        text-decoration: none;
    }

    body, html {
        height: 100%;
    }

    body {
        background-color: #eee;
    }

    #wrap {
        max-width: 1130px;
        min-width: 320px;
        margin: 100px auto;
    }

    #wrap .cont-left {
        width: 25%;
        min-height: 630px;
        margin-right: 5%;
        background-color: #fff;
        float: left;
    }

    #wrap .cont-left .identity {
        width: 100px;
        height: 100px;
        border-radius: 50%;
        background-color: #FEAD0F;
        margin: 40px auto 60px;
    }

    #wrap .cont-left ul {
        max-width: 120px;
        margin: 30px auto 0;
    }

    #wrap .cont-left ul li {
        width: 100%;
        margin: 20px auto;
        font-size: 18px;
        color: #9A9A9A;
    }

    #wrap .cont-left ul li a {
        color: #9A9A9A;

    }

    #wrap .cont-left ul li a:hover {
        color: #FEAD0F;
    }

    #wrap .cont-right {
        width: 70%;
        min-height: 630px;
        background-color: #fff;
        float: right;
    }

    #wrap .cont-right nav {
        height: 40px;
        text-align: center;
        line-height: 40px;
        overflow: hidden;
        background-color: #eee;
        display: flex;
        /*border:1px solid #fff;*/
    }

    #wrap .cont-right .count {
        height: 80px;
        line-height: 80px;
        margin-left: 5%;
        color: rgba(0, 0, 0, 0.5);
        font-size: 15px;
    }

    #num {
        color: red;
    }

    #wrap .cont-right .seek {
        height: 200px;
        margin-left: 5%;
        margin-right: 5%;
        border-top: 1px dashed #ccc;
        border-bottom: 1px dashed #ccc;
    }

    #wrap .cont-right .search {
        margin-top: 20px;
    }

    #wrap .cont-right .search input {
        margin-right: 5%;
        float: right;
    }

    #wrap .cont-right .separate {
        margin-top: 60px;
        height: 10px;
        background-color: #eee;
    }

    nav a {
        display: block;
        width: 25%;
        /*border-right: 1px solid #FFF;*/
        color: #000;
        text-decoration: none;
    }

    nav a:last-child {
        border-right: 0 none;
    }

    nav a.active {
        background-color: #FEAD0F;
        color: #fff;
    }

    .cont {
        overflow: hidden;
        display: none;
    }

    .cont ol {
        line-height: 30px;
        margin-top: 20px;
    }

    .cont ol li {
        margin-left: 5%;
    }


    #users
    {
        font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
        width:100%;
        border-collapse:collapse;
    }
    /*id为users 的标签里面的td标签和th标签的样式*/
    #users td, #users th
    {
        font-size:1em;
        border:1px solid #98BF21;
        padding:3px 7px 2px 7px;
    }
    /*id为users 的标签里面的th标签的样式*/
    #users th
    {
        font-size:1.1em;
        text-align:left;
        padding-top:5px;
        padding-bottom:4px;
        background-color:#A7C942;
        color:#FFF;
    }
    /*id为users的标签里面的class名为alt的tr标签里面的td标签的样式*/
    #users tr.alt td
    {
        color:#000;
        background-color:#EAF2D3;
    }

</style>

<div id="wrap">
    <div class="cont-left fl">
        <div class="identity"></div>
        <ul>
            <li><a href="information.html">普通成员管理</a></li>
            <li><a href="information.html">管理层管理</a></li>
            <li><a href="information.html">管理成员emm</a></li>
        </ul>
    </div>
    <div class="cont-right fl">
        <nav>
            <a href="javascript:;" data-cont="local" class="active">全部人员</a>
            <a href="javascript:;" data-cont="global">C/C++小组</a>
            <a href="javascript:;" data-cont="sports">java小组</a>
            <a href="javascript:;" data-cont="funny">web小组</a>
            <a href="javascript:;" data-cont="funny">算法小组</a>
            <a href="javascript:;" data-cont="funny">活动部</a>
        </nav>
        <div class="count">
            目前，有<span id="num">300</span>人加入社团
        </div>
        <div class="seek">
            这里是查找方式。比如院系查找：软件学院 计算机学院 电子学院 其他
            性别查找：男 女
            （类似这样子的，按照你的功能来设计）
        </div>
        <div class="search">
            <input type="search" value="请输入查找人姓名">
        </div>
        <div class="separate"></div>
        <section class="cont" id="local" style="display: block;">
            <form method="post">

                <input name="method" type="hidden" value="delete" />

                <table id="users">
                    <tr>
                        <th></th>
                        <th>用户名</th>
                        <th>姓名</th>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td><input name="id" type="checkbox" value="${user["userId"]}" /></td>
                            <td>${user["username"]}</td>
                            <td>${user["realname"]}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>
                            <button type="submit">提交</button>
                        </td>
                    </tr>
                </table>


            </form>
        </section>
        <section class="cont" id="global">
            <ol>
                <li>许婷婷</li>
                <li>韩晔聪</li>
                <li>李彤</li>
            </ol>
        </section>
        <section class="cont" id="sports">
            <ol>
                <li>许婷婷</li>
                <li>韩晔聪</li>
                <li>李彤</li>
            </ol>
        </section>
        <section class="cont" id="funny">
            <ol>
                <li>许婷婷</li>
                <li>韩晔聪</li>
                <li>李彤</li>
            </ol>
        </section>
    </div>
</div>

<script>
    // 目标： 默认显示一个 当前的样式
    // 点击导航，实现切换
    // key 表示的当前显示的是第几个

    (function (key) {
        //获取所有的导航
        var navs = document.querySelectorAll('nav a');
        //遍历 给导航 绑定事件，并且添加当前样式
        for (var i = 0; i < navs.length; i++) {
            //如果是用户指定的当前样式
            if (key === i) {
                navs[i].classList.add('active');
                //拿到要显示内容section的id
                var secId = navs[i].dataset['cont'];
                //获取对应的section标签
                document.querySelector('#' + secId).style.display = 'block';
            }

            //给每一个导航绑定点击事件
            navs[i].onclick = function () {
                //排他
                //之前有active样式的清除, 之前显示的section 隐藏
                var currentNav = document.querySelector('.active');
                //获取对应的内容区域 ，让其隐藏
                var currentId = currentNav.dataset['cont'];
                //去掉导航的 active 样式
                currentNav.classList.remove('active');
                //对应的内容区域
                document.querySelector('#' + currentId).style.display = 'none';

                //突出显示自己 导航添加样式  对应的section 显示
                //给自己添加 active 样式
                this.classList.add('active');
                //对应的 section 模块显示出来
                var myId = this.dataset['cont'];
                document.querySelector('#' + myId).style.display = 'block';
            }
        }

    })(0);
</script>

<script>
    function delUserById(id) {
        alert(id);
    }
</script>

<c:import url="/WEB-INF/partials/footer.jsp"/>
