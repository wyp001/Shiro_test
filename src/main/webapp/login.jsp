<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String path = request.getContextPath()+"/"; %>    
<!DOCTYPE html>
<html>
<head>
<base href="<%=path %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录界面</h1>
	
	<form action="user/login">
		<input name="name"/>
		<br/>
		<input name="password"/>
		<br/>
		<input type="submit" value="登录"/>
	</form>
	
</body>
</html>