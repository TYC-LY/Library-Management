<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Login</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
</head>
<body>

	<div class="container">
	<h1>Login</h1>
	
	<form action="login" >
		<div class="form-group">
			<label for="username">username:</label>
			<input class="form-control" name="username" type="text" placeholder="account" required autofocus="">
			<label for="password">password:</label>
			<input class="form-control" name="password" type="password" placeholder="password" required autofocus="">
		</div>
		<p class="text-primary"><s:property value="errorMessage"></s:property></p>
		<button class="btn btn-primary" type="submit">login</button>
	</form>
	
	<center><a href="/mandarin/jsp/Recovery_Forget_Password/answerSecurityQuestion.jsp">forgot your password?</a></center>
	
	</div>
</body>
</html>