<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<style>
.errorMessage {
	color:red;
}
</style>
<head>

<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Change Password</title>
</head>
<body>	
	<!-- 输入框整体 -->
	<div class="container">
	<h1>Answer security question</h1>
	<h3>What's your father's name?</h3>
	<form action="answerSecurityQuestion" >
		<div class="form-group">
			<label for="username">username:</label>
			<input class="form-control" name="username" type="text" placeholder="account" required autofocus="">
			<label for="securityAnswer">your answer:</label>
			<input class="form-control" name="securityAnswer" type="text" placeholder="answer" required autofocus="">
		</div>
		<div class="errorMessage">
		<p><s:property value="errorMessage"></s:property></p>
		</div>
		<button class="btn btn-primary" type="submit">OK</button>
	</form>
	
	</div>
</body>
</html>