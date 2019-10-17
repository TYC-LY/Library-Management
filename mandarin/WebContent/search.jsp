<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en" class="h-100">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="referrer" content="no-referrer" />

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
		<form class="m-3" action="reader-search">
			<div class="input-group mt-3">
				<select name="option" class="rounded-left btn-outline-primary">
					<option value="title">Book Title</option>
					<option value="author">Author</option>
					<option value="publisher">Publisher</option>
					<option value="isbn">ISBN</option>
				</select> <input type="text" name="searchContent"
					class="form-control mr-3 rounded-right"
					placeholder="Put some information here." aria-label="Search"
					autocomplete="off">
				<button class="btn btn-outline-primary" type="submit">Search</button>
			</div>
		</form>
		<div class="row">
			<nav class="col-md-10 offset-md-1 col-lg-3 offset-lg-0 sidebar">
				<div class="mt-3 ml-3 mb-3">
					<ul class="list-group flex-column">
						<li class="list-group-item"><button class="btn btn-outline-secondary" disabled>DISABLE</button></li>
						<li class="list-group-item"><button class="btn btn-outline-secondary" disabled>DISABLE</button></li>
						<li class="list-group-item"><button class="btn btn-outline-secondary" disabled>DISABLE</button></li>
						<li class="list-group-item"><button class="btn btn-outline-secondary" disabled>DISABLE</button></li>
						<li class="list-group-item"><button class="btn btn-outline-secondary" disabled>DISABLE</button></li>
						<li class="list-group-item"><button class="btn btn-outline-secondary" disabled>DISABLE</button></li>
						<li class="list-group-item"><button class="btn btn-outline-secondary" disabled>DISABLE</button></li>
						<!-- 分类检索 -->
					</ul>
				</div>
			</nav>
			<div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0">
				<div class="py-3 mr-3">
					<ul class="list-group">
						<s:iterator value="bookTable" status="L">
							<li class="list-group-item d-flex align-items-center">
								<div class="just-content-left mr-3">
									<img src="<s:property value="imgpath"></s:property>"
										height="80px">
								</div>
								<div class="container">
									<div class="row mb-2">
										<h4 data-toggle="tooltip" data-placement="right"
											data-html="true" title="<s:property value='description' />">
											<s:property value="title" />
										</h4>
									</div>
									<div class="row">
										<span class="badge badge-secondary mr-2"><s:property value="isbn" /></span>
										<span class="badge badge-primary mr-2"><s:property value="author" /></span>
										<span class="badge badge-primary mr-2"><s:property value="publisher" /></span>
										<span class="badge badge-secondary mr-2"><s:property value="location" /></span>
										<span class="badge badge-secondary"><s:property value="price" /></span>
									</div>
								</div>
									<form action="reserve" method="post">
										<input type="hidden" name="id" value="<s:property value="id" />">
										<button class="btn btn-primary">reserve</button>
									</form>
								<div>
									<a class="btn btn-primary badge badge-primary badge-pill"
										data-toggle="collapse"
										href="#collapseExample<s:property value="#L.index+1"></s:property>"
										role="button" aria-expanded="false"
										aria-controls="collapseExample"><span
										class="badge badge-primary badge-pill">View Holding</span></a>
								</div>
							</li>
							<div class="collapse"
								id="collapseExample<s:property value="#L.index+1"></s:property>">
								<div class="card card-body">
									<!-- TODO: 完善book馆藏信息 -->
									<table class="table table-striped table-sm">
										<thead>
											<tr>
												<td>Location</td>
												<td>is Borrowed</td>
												<td>is Reversed</td>
												<td>Action</td>
											</tr>
										</thead>
										<tbody>
											<s:iterator>
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</main>

	<footer class="footer mt-auto">
		<div class="container text-center py-3"
			style="background-color: #f5f5f5">
			© 2019 <a href="http://www.nwpu.edu.cn/" target="_blank">NWPU</a>
			Mandarin-Library Automation
		</div>
	</footer>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery-3.3.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
</body>
</html>