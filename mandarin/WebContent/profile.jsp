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
		<table class="table container table-hover main-contents mt-4">
			<thead>
				<tr>
					<th class="table-title" scope="col">id</th>
					<th class="table-title" scope="col">username</th>
					<th class="table-title" scope="col">email</th>
					<th class="table-title" scope="col">borrowHistory</th>
					<th class="table-title" scope="col">totalFine</th>
					<th class="table-title" scope="col">operation</th>
				</tr>
			</thead>
			<tbody>
				<tr>
	
					<td><s:property value="#session.reader.getId()"></s:property></td>
					<td><s:property value="#session.reader.getUsername()"></s:property></td>
					<td><s:property value="#session.reader.getEmail()"></s:property></td>
					<!-- <td><s:property value="tempReader.borrowHistory"></s:property></td>
						<td><s:property value="tempReader.totalFine"></s:property></td> -->
					<td>
						<button onclick=window.location.href="<%=request.getContextPath()%>/changeInfo.jsp">
							<i class="layui-icon">&#xe642;</i>change
						</button>
					</td>
				</tr>
			</tbody>
		</table>
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
</body>
</html>