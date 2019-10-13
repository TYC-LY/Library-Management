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
				<h3>Librarian Function</h3>
				<!-- 侧边栏 手风琴 -->
				<jsp:include page="/jsp/accordion.jsp" flush="true" />

				<!-- 模态框 RegisterReader -->
				<jsp:include page="/jsp/Reader_Management/Reader_Management_RegisterReader.jsp" flush="true"/>
				
				<!-- 模态框 AddBook -->
				<jsp:include page="/jsp/Book_Management/BookManagement_Add_Books_ISBN.jsp" flush="true"/>

			</div>
			<div class="col-sm-8">
				<!-- 条形码和位置图片页面 -->
				<%@include file="/jsp/Book_Management/BookManagement_Add_Books_Image.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>