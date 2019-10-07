<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Logout</title>

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

	<!-- 导航栏 -->
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
		<a class="navbar-brand" href="#">Navigator</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li>
					<form action="logout">
						<button class="btn btn-primary" name="logout" type="submit">logout</button>
					</form>
				</li>
			</ul>
		</div>
	</nav>

	<!-- 主体部分 -->
	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">

				<ul class="nav nav-pills flex-column">
					<li class="nav-item">
						<!-- 按钮：用于打开模态框 -->
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#RegisterReader">Register Reader</button>
					</li>
					<br>
					<li class="nav-item">
						<!-- 按钮：用于打开模态框 -->
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#AddBook">Add Book</button>
				</ul>

			</div>

			<!-- 模态框 -->
			<div class="modal fade" id="RegisterReader">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- 模态框头部 -->
						<div class="modal-header">
							<h4 class="modal-title">Register Reader</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- 模态框主体 -->
						<div class="modal-body">
							<form action="signup">

								<div class="form-group">
									<label for="username">username:</label> <input
										class="form-control" name="username" type="text"
										id="user-username" placeholder="username" required
										autofocus=""> <label for="email">email:</label> <input
										class="form-control" name="email" type="email" id="user-email"
										placeholder="email" required autofocus=""> <label
										for="password">password:</label> <input class="form-control"
										name="password" type="password" id="user-pass"
										placeholder="password" required autofocus=""> <label
										for="phoneNumber">phoneNumber:</label> <input
										class="form-control" name="phoneNumber" type="text"
										id="user-phoneNumber" placeholder="phoneNumber" required
										autofocus="">
								</div>

								<button class="btn btn-primary" type="submit">Register</button>
							</form>

							<s:property value="errorMessage" />
						</div>

						<!-- 模态框底部 -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>

			<!-- 模态框 -->
			<div class="modal fade" id="AddBook">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- 模态框头部 -->
						<div class="modal-header">
							<h4 class="modal-title">Add Book</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- 模态框主体 -->
						<div class="modal-body">
							<h2>Please Enter the ISBN of the Book!</h2>
							<form action="bookManagement_Find_Book_Detail">
								<div class="form-group">
									<label for="ISBN">ISBN:</label> <input class="form-control"
										name="ISBN" type="text" placeholder="ISBN" required
										autofocus="">
								</div>

								<button class="btn btn-primary" type="submit">Find the
									detail of book</button>
							</form>
						</div>

						<!-- 模态框底部 -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>

			<div class="col-sm-8">
				<h1>Personal Center</h1>
			</div>
		</div>
	</div>

</body>
</html>