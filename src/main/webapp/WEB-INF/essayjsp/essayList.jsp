<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="cn.jluibm.model.entity.Essay" %>
    <%@ page import="cn.jluibm.utils.ReflectionTools" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//基本信息，作者，
		String essayAuthor = (String) session.getAttribute("essayAuthor");
		String essayType = (String) session.getAttribute("essayType");
		String essayState = (String) session.getAttribute("essayState");
		List<Essay> essayList = (List<Essay>) session.getAttribute("essayList");
	%>
	<a href="<%= request.getContextPath() %>">返回文章首页</a>
	<table border="1" bgcolor="pink">
		<tr>
			<th>标题</th>
			<th>时间</th>
			<th>审核状态</th>
			<th>操作</th>
		</tr>
		<%
			for (int i = 0; i < essayList.size(); i++)
			{
				Essay essay = essayList.get(i);
		%>
			<tr>
				<td><a href="<%= request.getContextPath() %>/essay?index=<%= i %>" >
				<%= ReflectionTools.getter(essay, "title") %>></a></td>
				<td><%= ReflectionTools.getter(essay, "time") %></td>
				<td><%= ReflectionTools.getter(essay, "state") %></td>
				<td><a href="<%= request.getContextPath() %>/essayEdit?index=<%= i %>" >编辑</a>
				<a href="<%= request.getContextPath() %>/removeEssay?index=<%= i %>">删除</a></td>
			</tr>
		<%
			}
		%>
	</table>
	
</body>
</html>