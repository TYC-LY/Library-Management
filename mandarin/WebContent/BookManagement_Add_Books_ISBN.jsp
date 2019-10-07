<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<div class="container">
		<h2>Please Enter the ISBN of the Book!</h2>
		<form action="bookManagement_Find_Book_Detail">
			<div class="form-group">
				<label for="ISBN">ISBN:</label> 
				<input class="form-control" name="ISBN" type="text" placeholder="ISBN" required
					autofocus=""> 
			</div>
			
			<button class="btn btn-primary" type="submit">Find the detail of book</button>
		</form>
	</div>
</body>
</html>