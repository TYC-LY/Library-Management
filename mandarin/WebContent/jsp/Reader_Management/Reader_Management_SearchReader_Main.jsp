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

<title>ReaderManagement Search/Delete Reader</title>

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
				<!-- 侧边栏 -->
				<jsp:include page="/jsp/sidebar.jsp" flush="true" />
			</div>
			<div class="col-sm-8">
				<%@include file="/jsp/Reader_Management/Reader_Management_SearchReader.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>