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

<title>BookManagement Add Books</title>

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
		<a class="navbar-brand" href="#">导航</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">链接</a></li>
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
			<div class="col-sm-8">
				<h2>Add book</h2>			
				<form action="BookManagement_Add_Books">
					<div class="form-group">
						<label for="ISBN">ISBN:</label>
						<input class="form-control" name="ISBN" type="text" placeholder="ISBN" required autofocus="" value="<s:property value="tempBook.ISBN"/>">
						<label for="title">title:</label>
						<input class="form-control" name="title" type="text" placeholder="title" required autofocus="" value="<s:property value="tempBook.title"/>">
						<label for="author">author:</label>
						<input class="form-control" name="author" type="text" placeholder="author" required autofocus="" value="<s:property value="tempBook.author"/>">
						<label for="publisher">publisher:</label>
						<input class="form-control" name="publisher" type="text" placeholder="publisher" required autofocus="" value="<s:property value="tempBook.publisher"/>">
						<label for="description">description:</label>
						<input class="form-control" name="description" type="text" placeholder="description" required autofocus="" value="<s:property value="tempBook.description"/>">
						<label for="location">location:</label>
						<input class="form-control" name="location" type="text" placeholder="location" required autofocus="" >
						<label for="price">price:</label>
						<input class="form-control" name="price" type="text" placeholder="price" required autofocus="" value="<s:property value="tempBook.price"/>">
						<label for="categoryNo">categoryNo:</label>
						<input class="form-control" name="categoryNo" type="text" placeholder="categoryNo" required autofocus="" >
					</div>
					
					<h1><p class="text-success"><s:property value="errorMessage"/></p></h1>
					
					<button class="btn btn-primary" name="submit" type="submit">Add</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>