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
	<jsp:include page="/jsp/header.jsp" flush="true"/>
	
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

			<!-- 模态框 RegisterReader -->
			<jsp:include page="/jsp/registerReader.jsp" flush="true"/>
			
			<!-- 模态框 AddBook -->
			<jsp:include page="/jsp/BookManagement_Add_Books_ISBN.jsp" flush="true"/>

			</div>
			<div class="col-sm-8">
				<%@include file="/jsp/BookManagement_Add_Books_Image.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>