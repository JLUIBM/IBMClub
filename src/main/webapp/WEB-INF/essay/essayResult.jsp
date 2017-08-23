<%--
  Created by IntelliJ IDEA.
  User: 20688
  Date: 2017/8/23
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>${requestScope.essayMessage}</title>
</head>
<body>
<a href="essay?m=getEssays&essayPageNo=${param.essayPageNo}&essayTitle=${param.essayTitle}">返回文章列表</a>
    <center>
        <h2>${requestScope.essayMessage}</h2>
    </center>
</body>
</html>
