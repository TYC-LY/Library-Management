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
	
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Change Password</title>
<style>
.errorMessage {
	color:red;
}
</style>
</head>
<body>
	<!-- 输入框整体 -->	
	<div class="container">
	<h1>Change Password</h1>
	<form action="changePassword" >
		<div class="form-group">
			<label for="password">new password:</label>
			<input class="form-control" name="password" type="password" required autofocus="">
			<label for="repeatpw">input again:</label>
			<input class="form-control" name="repeatpw" type="password" required autofocus="">
		</div>
		<div class="errorMessage">
		<p><s:property value="errorMessage"></s:property></p>
		</div>
		<button class="btn btn-primary" type="submit">OK</button>
	</form>
	
	</div>
</body>
</html>