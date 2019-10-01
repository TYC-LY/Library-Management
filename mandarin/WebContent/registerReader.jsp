<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register reader</title>
</head>
<body>
	<h1 style="text-align: center">Register reader</h1>
	
	<form action="signup">
		<input name="username" type="text" id="user-username" placeholder="username" required autofocus=""> 
		<input name="email" type="email" id="user-email" placeholder="email" required autofocus=""> 
		<input name="password" type="password" id="user-pass" placeholder="password" required autofocus="">
		<input name="phoneNumber" type="text" id="user-phoneNumber" placeholder="phoneNumber" required autofocus="">
		<button type="submit">注册</button>
	</form>
	
	<s:property value="errorMessage"/>
	
</body>
</html>