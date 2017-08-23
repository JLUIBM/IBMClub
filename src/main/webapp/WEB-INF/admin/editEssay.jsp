<%--
  Created by IntelliJ IDEA.
  User: 20688
  Date: 2017/8/21
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑文章</title>
    <script type="text/javascript" src="wangEditor.js"></script>
</head>
<body>
<h1>${requestScope.essay.title}</h1>
<div id="editor" >
    <p>${requestScope.essay.content}</p>
</div>
<form action="essay?m=saveEssay&essayId=${requestScope.essay.essayId}" method="post" onsubmit="return check();">
    <input type="hidden" id="essayContent" name="essayContent">
    标签: <input type="text" name="essayTopic" id="essayTopic" value="${requestScope.essay.topic}">
    标题: <input type="text" name="essayTitle" id="essayTitle" value="${requestScope.essay.title}">
    <input type="submit"  value="保存">
</form>

</body>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E(document.getElementById("editor"));
    editor.create();
    
    function check() {
        var content = document.getElementById("essayContent");
        content.value = editor.txt.html();
        //1.检测是否有内容
        if (editor.hasContents())
        {

            //2.检测是否有标签
            var topic = document.getElementById("essayTopic");
            if (topic.value == null || topic.value == "")
            {
                alert("请编辑标签");
                return false;
            }
            else
            {
                //3.检测是否有标题
                var title = document.getElementById("essayTitle");
                if(title.value == null || title.value == "")
                {
                    alert("请编辑标题");
                    return false;
                }
                return true;
            }

        }
        else
        {
            alert("请编辑文章内容");
            return false;
        }
    };
</script>
</html>
