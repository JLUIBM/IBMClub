<%--
  Created by IntelliJ IDEA.
  User: hyec
  Date: 2017/5/7
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>HelloWorld</title>
</head>
<body>
    <p> ${message} </p>
    <form method="post">
        <label for="hello">HelloWorld</label>
        <input type="text" id="hello" name="hello" />

        <button id="submit" type="submit">提交</button>
    </form>
</body>
</html>
