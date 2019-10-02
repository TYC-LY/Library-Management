<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en" class="h-100">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
	
		<main role="main" class="flex-shrink-0">
			<div class="container">
				<!-- <div id="carouselExampleIndicators" class="carousel slide"
					data-ride="carousel" style="height: 512px">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" style="height: 512px">
						<div class="carousel-item active">
							<img class="d-block w-100" src="pic/a.jpg" alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="pic/a.jpg" alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="pic/a.jpg" alt="Third slide">
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
				</div> -->
				
				<div class="mt-2 row justify-content-center">
					<form class="form-inline" action="reader-search">
					    <input name="searchContent" type="text" placeholder="Search" class="form-control mr-sm-2" aria-label="Search" autocomplete="off">
					    <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search By</button>
					    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
					    	<option value="title">Book Title</option>
					    	<option value="author">Author</option>
					    	<option value="publisher">Publisher</option>
					    	<option value="isbn">ISBN</option>
					    </select>
				    </form>
				</div>
				
				<div>
					
				</div>	
			</div>
		</main>
	
		<footer class="footer mt-auto">
			<div class="container text-center py-3" style="background-color: #f5f5f5">
				© 2019 <a href="http://www.nwpu.edu.cn/" target="_blank">NWPU</a> Mandarin-Library Automation
			</div>
		</footer>
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery-3.3.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>