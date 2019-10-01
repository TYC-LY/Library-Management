<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	
	<form action="login" >
		<input name="username" type="text" placeholder="account" required autofocus="">
		<br>
		<input name="password" type="password" placeholder="password" required autofocus="">
		<br>
		
		<button type="submit">
			login
		</button>
	</form>
	
	<p><s:property value="errorMessage"></s:property></p>
</body>
</html>