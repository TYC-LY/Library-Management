<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<script src="assets/bootstrap.min.js"></script>
	<link rel="stylesheet" href="assets/all.css">
	<link rel="stylesheet" href="pages/css/login.css">
	<link rel="stylesheet" href="pages/css/main.css">
	<script src="assets/fontawesomekit.js"></script>
	<link rel="stylesheet" href="pages/color/default.css">
	<title>Reader login</title>
</head>

<body class="bg-color">
		<form action="reader-login" class="form-signin" method="post">
			<h1 class="h3 mb-3 font-weight-normal text-color"
				style="text-align: center">Reader login</h1>
				
			<input name="email" type="email" id="inputEmail" class="form-control mb-2 rounded" placeholder="email address" required autofocus=""> 
			<input name="password" type="password" id="inputPassword" class="form-control mb-2 rounded" placeholder="password" required autofocus="">

			<button class="btn btn-secondary btn-block" type="submit">
				<i class="fas fa-sign-in-alt mr-2"></i>login
			</button>
<%--			
			<button class="btn btn-secondary btn-block" type="button" id="btn-signup">
				<i class="fas fa-user-plus mr-2"></i>apply
			</button>
			
			<button class="btn btn-secondary btn-block" type="button" id="btn-signfuck" onclick="clickk();">
				<i class="p"></i>signfuck
			</button>
			
			<script>
			function clickk(){
		    	form.action="fuck.jsp";
		    	form.submit();
				}
			</script>
			<a id="aBtn" href="fuck.jsp">signfuck</a>

			<div class="text-center mt-3">
				<a href="#" id="forgot_pswd" class="text-info">忘记密码</a>
			</div>
--%>
		</form>

</body>
</html>