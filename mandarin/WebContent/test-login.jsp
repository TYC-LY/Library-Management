<!--<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Signin Template · Bootstrap</title>


<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="http://codeseven.github.io/toastr/build/toastr.min.css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="//cdn.bootcss.com/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link href="css/login.css" rel="stylesheet">

<!-- JS -->
<script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/toastr.min.js"></script>


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="css/login.css" rel="stylesheet">
</head>
<body class="text-center" background="pic/bg111.jpg">

	<div class="modal fade" id="kk" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>

	<form action="reader-login" class="reader-login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Mandarin</h1>
		<label for="inputPhoneNumber" class="sr-only">Phonenumber</label> <input
			name="phoneNumber" id="inputPhoneNumber" class="form-control"
			placeholder="Phonenumber" required> <label
			for="inputPassword" class="sr-only">Password</label> <input
			name="password" type="password" id="inputPassword"
			class="form-control" placeholder="Password" required>
		<div class="checkbox mb-3">
			<!-- <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>-->
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit"
			onclick="fun()">login</button>
		<a class="btn btn-lg btn-primary btn-block" href="recovery.jsp">recovery
			password</a>
		<a class="btn btn-lg btn-primary btn-block" href="login.jsp">login as librarian</a>
		<script>
			function launch_toast() {
				toastr.options = {
					"timeOut" : "2500",
					"preventDuplicates" : true,
					"preventManyTimes" : true,
					"hideDuration" : "1",
					"positionClass" : "toast-top-center"
				};
				var Content = "<s:property value="errorMessage"></s:property>";
				if (Content == "Login successfully") {
					toastr.success(Content);
				} else {
					toastr.error(Content);
				}
			};
			console.log("launch_toast defined");
			(function() {
				if ("<s:property value="errorMessage"></s:property>" == "") {
					console.log("no error");
				} else {
					launch_toast();
				}
			})();
		</script>
	</form>
</body>
</html>