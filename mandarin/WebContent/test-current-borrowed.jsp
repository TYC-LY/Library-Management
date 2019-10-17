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

    <title>current-borrowed</title>
</head>
<body class="d-flex flex-column h-100">

	<header>
		<div class="container">
			<s:include value="navbar.jsp" />
		</div>
	</header>

	<main role="main" class="flex-shrink-0">
	<div class="container mt-3">
		<table class="table table-striped table-sm">
			<thead>
				<tr>
					<td>Book Name</td>
					<td>Borrowing Date</td>
					<td>Deadline</td>
					<td>Fine value</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="currentTable">
					<tr>
						<td><s:property value="book.title" /></td>
						<td><s:property value="borrowDate" /></td>
						<td><s:property value="deadline" /></td>
						<td><s:property value="fineValue" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
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
</body>
</html>