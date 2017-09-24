<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="cn.jluibm.model.entity.Activity"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getActivityJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    List<Activity> activity = (ArrayList<Activity>)request.getAttribute("activity");
    for(int i=0;i<activity.size();i++)
    {
    	Activity temp = activity.get(i);
    %>
    <p>活动ID:<%=temp.getActivityId()%></p>
    <p>活动标题:<%=temp.getTitle()%></p>
    <p>活动时间:<%=temp.getActivityTime()%></p>
    <p>活动发布时间:<%=temp.getPublishTime()%></p>
    <p>活动负责人:<%=temp.getManager()%></p>
    <p>活动地点:<%=temp.getLocation()%></p>
    <p>活动内容:<%=temp.getContent()%></p>
    <p>活动发布人ID:<%=temp.getUserId()%></p>
    <form method="post" action="ActivityChangeServlet-admin">
    	<input type="hidden" name="activity_id" value=<%=temp.getActivityId()%>>
    	<input type="hidden" name="title" value=<%=temp.getTitle()%>>
    	<input type="hidden" name="activity_time" value=<%=temp.getActivityTime()%>>
    	<input type="hidden" name="manager" value=<%=temp.getManager()%>>
    	<input type="hidden" name="location" value=<%=temp.getLocation()%>>
    	<input type="hidden" name="content" value=<%=temp.getContent()%>>
    	<input type="submit" value="修改">
    </form>
	
	<form method="post" action="ActivityDeleteServlet-admin">
		<input type="hidden" name="activity_id" value=<%=temp.getActivityId()%>>
		<input type="submit" value="删除">
	</form>
    <%
    }
     %>
  </body>
</html>
