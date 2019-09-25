<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>test-signin</title>
</head>
<body>

	<div class="text-center">
		<p>Hello!</p>
		<p><s:property value="tempReader.username"></s:property></p>
		
		<!-- test-current-borrowed -->
		<div class="container mt-5">
			<form action="reader-current-borrowed">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Current Borrowed Books</button>
			</form>
		</div>
		
		<!-- test-borrow-history -->
		<div class="container mt-5">
			<form action="reader-borrow-history">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Borrow History</button>
			</form>
		</div>
	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>