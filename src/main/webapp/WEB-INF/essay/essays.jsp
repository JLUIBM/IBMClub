<%--
  Created by IntelliJ IDEA.
  User: 20688
  Date: 2017/8/16
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>前沿文章</title>
    <script type="text/javascript">
        function remove() {
            var title = document.getElementById("essayTitle").childNodes[0].nodeValue.trim();
            var flag = confirm("确定要删除" +title +"吗?");
            if (flag)
            {
                return true;
            }
            return false;
        }
    </script>
</head>
<body>

<input type="hidden" value="${requestScope.essayTitle}">

    <a href="essay?m=editEssay">编辑文章</a>
<br>

    <center>
        <br><br>
        
        <c:if test="${!empty requestScope.essayMessage}">
            <h1>${requestScope.essayMessage}</h1>
        </c:if>
        <br>

        <!-- 根据标题搜索文章 -->
        <form action="essay?m=getEssays" method="post">

            标题:<input type="text" name="essayTitle" id="title" value="${requestScope.essayTitle}" />

            <input type="submit" value="查询" />
        </form>
        <br><br>

        <!-- 没有找到 -->
        <c:if test="${empty requestScope.essayList}">
            <h3>抱歉, 没有找到呢</h3>
        </c:if>
        <br><br>

        <!-- 文章列表 -->
        <c:if test="${!empty requestScope.essayList}">
            <table>

                <tr>
                    <td>标题</td>
                    <td>标签</td>
                    <td>作者</td>
                    <td>时间</td>
                    <c:if test="${sessionScope.user.permission == 1}">
                        <td>操作</td>
                    </c:if>
                </tr>

                <c:forEach items="${requestScope.essayList}" var="essay">
                    <tr>
                        <td>
                            <a id="essayTitle" href="essay?m=getEssay&essayPageNo=${requestScope.essayPageNo}&essayTitle=${requestScope.essayTitle}&essayId=${essay.essayId}">
                                    ${essay.title}
                            </a>
                        </td>

                        <td>${essay.topic}</td>

                        <td>${essay.author}</td>

                        <td>${essay.time}</td>

                        <c:if test="${sessionScope.user.permission == 1}">
                            <td><a href="essay?m=editEssay&essayPageNo=${requestScope.essayPageNo}&essayTitle=${requestScope.essayTitle}&essayId=${essay.essayId}">编辑</a></td>
                        </c:if>
                        <c:if test="${sessionScope.user.permission == 1}">
                            <td>
                                <a onclick="return remove();" href="essay?m=removeEssay&essayPageNo=${requestScope.essayPageNo}&essayTitle=${requestScope.essayTitle}&essayId=${essay.essayId}">
                                    删除
                                </a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>

            </table>
            <br><br>

            <!-- 翻页 -->
            共${requestScope.totalEssayPageNumber}页
            &nbsp;&nbsp;

            当前第${requestScope.essayPageNo}页
            &nbsp;&nbsp;

            <c:if test="${requestScope.essayPageNo -1 != 0}">
                <a href="essay?m=getEssays&essayPageNo=1&essayTitle=${requestScope.essayTitle}">
                    首页
                </a>
            </c:if>
            &nbsp;&nbsp;

            <c:if test="${requestScope.essayPageNo  > 1}">
                <a href="essay?m=getEssays&essayPageNo=${requestScope.essayPageNo -1}&essayTitle=${requestScope.essayTitle}">
                    上一页
                </a>
            </c:if>
            &nbsp;&nbsp;

            <c:if test="${requestScope.essayPageNo  < requestScope.totalEssayPageNumber}">
                <a href="essay?m=getEssays&essayPageNo=${requestScope.essayPageNo +1}&essayTitle=${requestScope.essayTitle}">
                    下一页
                </a>
            </c:if>
            &nbsp;&nbsp;

            <c:if test="${requestScope.essayPageNo < requestScope.totalEssayPageNumber}">
                <a href="essay?m=getEssays&essayPageNo=${requestScope.totalEssayPageNumber}&essayTitle=${requestScope.essayTitle}">
                    末页
                </a>
            </c:if>
            &nbsp;&nbsp;
        </c:if>


    </center>

</body>
</html>
