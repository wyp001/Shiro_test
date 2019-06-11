<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<% String path = request.getContextPath()+"/"; %>   
<!DOCTYPE html>
<html>
<head>
<base href="<%=path%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>主界面</h1>
	
	<%--<shiro:hasPermission name="/student/add">--%>
		<a href="student/add">添加学生</a>
		<br/>
	<%--</shiro:hasPermission>--%>
	
	<%--<shiro:hasPermission name="/student/update">--%>
		<a href="student/update">修改学生</a>
		<br/>
	<%--</shiro:hasPermission>--%>
	
	<shiro:hasPermission name="/student/delete">
		<a href="student/delete">删除学生</a>
	 	<br/>
	</shiro:hasPermission>
	
	
	
	
	
	
	<a href="student/query">查询学生</a>
	<br/>
	
	
	
	
	
	
	
</body>
</html>