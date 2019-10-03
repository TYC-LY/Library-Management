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
				<div class="sidebar">
					<!-- 侧边导航栏，按目录检索 -->
				</div>
				<div class="container">
					<form action="reader-search">
						<div class="input-group mt-3">
						    <select class="rounded-left btn-outline-primary" id="inlineFormCustomSelect">
								<option value="title">Book Title</option>
								<option value="author">Author</option>
								<option value="publisher">Publisher</option>
								<option value="isbn">ISBN</option>
							</select>
							<input type="text" name="searchContent" class="form-control mr-3 rounded-right" placeholder="Put some information here." aria-label="Search" autocomplete="off">
						    <button class="btn btn-outline-primary" type="submit">Search</button>
						</div>
					</form>
					<div class="py-3">
						<ul class="list-group">
							<s:iterator value="bookTable" status="L">
								<li class="list-group-item d-flex justify-content-between align-items-center">
									<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample<s:property value="#L.index+1"></s:property>" role="button" aria-expanded="false" aria-controls="collapseExample">
					    				<s:property value="title" />
					  				</a>
					  				<div class="justify-content-right">
					  					<span class="badge badge-primary"><s:property value="author" /></span>
					  					<span class="badge badge-primary"><s:property value="publisher" /></span>
						  				<span class="badge badge-secondary"><s:property value="location" /></span>
										<span class="badge badge-primary badge-pill"><s:property value="restNumber" /></span>
					  				</div>
								</li>
								<div class="collapse" id="collapseExample<s:property value="#L.index+1"></s:property>">
									<div class="card card-body">
										<!-- TODO: 完善book信息 -->
										<s:property value="description" />
									</div>
								</div>
							</s:iterator>
						</ul>
					</div>
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