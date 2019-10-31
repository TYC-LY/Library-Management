<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Blog Template Â· Bootstrap</title>


<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">

<link href="css/bulletin-board.css" rel="stylesheet">
<link rel="canonical"
	href="https://v4ing.bootcss.com/docs/4.3/examples/checkout/">

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
<link
	href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900"
	rel="stylesheet">

</head>
<body class="d-flex flex-column h-100" background="pic/bg111.jpg">
	<div class="container">
		<header>
			<div class="container">
				<s:include value="navbar.jsp" />
			</div>
		</header>


		<div>
			<div class="card-body" align="center">
				<div>
					<img class="d-block mx-auto mb-4"
						src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72"
						height="72">
					<div role="img" aria-label="Aaron profile" style="height:100px;width:100px"
						class="intercom-1m03k4l e1chjwx0">
						<s:property value="#session.reader.getUsername()"></s:property>
					</div>

					</p>
				</div>
				<div class="col-md-6 order-md-1">
					<h4 class="mb-3">Information</h4>
					<form class="needs-validation" novalidate>
						<div class="row" style="margin-top: 35px;">
							<div class="col-md-6 mb-2" >
								<label for="firstName">Reader-name</label>
								<div class="input-group">
									<a class="form-control" style="color: #000000;"><s:property
											value="#session.reader.getUsername()"></s:property></a>
									<div class="input-group-append">
										<a href="<%=request.getContextPath()%>/changeUsername.jsp"><span
											class="input-group-text">Change</span></a>
									</div>
								</div>
							</div>

							<div class="col-md-6 mb-2">
								<label for="firstName">Phonenumber</label>
								<div class="input-group">
									<a class="form-control" style="color: #000000;"><s:property
											value="#session.reader.getPhoneNumber()"></s:property></a>
									<div class="input-group-append">
										<a href="<%=request.getContextPath()%>/changePhoneNumber.jsp"><span
											class="input-group-text">Change</span></a>
									</div>
								</div>
							</div>

						</div>

						<div class="col-md-14">
							<label for="username">Email Address</label>
							<div class="input-group">
								<a type="text" class="form-control" id="firstName"
									style="color: #000000;"><s:property
										value="#session.reader.getEmail()"></s:property></a>
								<div class="input-group-append">
									<a href="<%=request.getContextPath()%>/changeEmail.jsp"><span
										class="input-group-text">Change</span></a>
								</div>
							</div>
						</div>


						<div class="p-3 mb-2 bg-light rounded" style="margin-top: 35px; height:70px ; width:375px">
							<h4 class="font-italic">Total
								Fine</h4>
							<p class="mb-0">
								<s:property
									value="#session.reader.getTotalFine()"></s:property>
							</p>
						</div>

						<div class="mb-3" style="margin-top: 40px">
							<a class="btn btn-secondary" href="<%=request.getContextPath()%>/changeInfo.jsp">
								Change all information together</a>
						</div>
				</div>
			</div>
		</div>


		<footer class="footer mt-auto" style="bottom: 0;">
			<div class="container text-center py-3"
				style="background-color: #f5f5f5">
				Â© 2019 <a href="http://www.nwpu.edu.cn/" target="_blank">XXXX</a>
				Mandarin-Library Automation
			</div>
		</footer>
		
		<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
