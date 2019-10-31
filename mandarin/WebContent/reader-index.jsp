<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!doctype html>
<html lang="en" class="h-100">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<title>Mandarin</title>
</head>
<body class="d-flex flex-column h-100">

	<header>
		<div class="container">
			<s:include value="navbar.jsp" />
		</div>
	</header>

	<main role="main" class="">
	<div class="">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<!--  	<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>-->
			</ol>


			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" src="pic/1.jpg" alt="First slide">
					<div class="carousel-caption text-left" style="color: #666666">
						<h1>Welcome to Mandarin-Library Automation</h1>
						<p>To experience more functions, please click the button in
							the upper right corner to log in!</p>
					</div>
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="pic/2.jpg" alt="Third slide">
					<div class="carousel-caption text-right" style="color: #666666">
						<h1>No reader account yet?</h1>
						<p>Please contact the librarian to pay the deposit and
							register.</p>
					</div>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<div class="mt-4 row justify-content-center">
		<form class="form-inline" action="reader-search">
			<select name="option" class="custom-select mr-sm-2 rounded-right"
				id="inlineFormCustomSelect">
				<option value="title">Book Title</option>
				<option value="author">Author</option>
				<option value="publisher">Publisher</option>
				<option value="isbn">ISBN</option>
			</select> <input name="searchContent" type="text" placeholder="Search"
				class="form-control mr-sm-2" aria-label="Search" autocomplete="off">
			<button class="btn btn-outline-primary my-2 my-sm-0 rounded-left"
				type="submit">Search</button>
		</form>
	</div>

	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/mandarin?serverTimezone=GMT" user="root"
		password="123456" /> <sql:query dataSource="${snapshot}" var="result">
				SELECT * from announcement;
				</sql:query>

	<div class="container mt-4 mb-4 text-center">
		<h3 class="text-center" style="color: #777777">Announcement</h3>
			<c:forEach var="row" items="${result.rows}">
				<div class="card">
				    <div class="card-header">
				        <h5 class="mb-0">
				        	<a class="card-header" data-toggle="collapse"
								href="#collapse<c:out value="${row.author}" />" role="button" aria-expanded="false"
								aria-controls="collapse<c:out value="${row.author}" />">
								<c:out value="${row.title}" /><span class="toggler-right" style="color:#777777"> by <c:out value="${row.author}" /></span>
							</a>
				      	</h5>
				    </div>
				
				    <div class="collapse" id="collapse<c:out value="${row.author}" />">
				    	<div class="card-body">
				      		<c:out value="${row.content}" />
				    	</div>
				    </div>
				</div>
			</c:forEach>
	</div>
	
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
	</main>

	<footer class="footer mt-auto">
		<div class="container text-center py-3"
			style="background-color: #f5f5f5">
			© 2019 <a href="http://www.nwpu.edu.cn/" target="_blank">XXXX</a>
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