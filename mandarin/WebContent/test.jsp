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

    <title>teat page</title>
</head>
<body>

	<div class="text-center">
		
		<!-- test-signin -->
		<div class="container mt-5">
			<form class="form-signin" action="reader-signin" method="post">
				<div class="form-group">
			    	<input name="email" type="email" class="form-control" aria-describedby="emailHelp" placeholder="Enter email">
			    	<small class="form-text text-muted">We'll never share your email with anyone else.</small>
			  	</div>
			  	<div class="form-group">
			    	<input name="password" type="password" class="form-control" placeholder="Password">
			  	</div>
			  	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			  	<p class="mt-5 mb-3 text-muted">&copy; 2019-9999</p>
			</form>
		</div>
		
	  	<!-- test-search -->
	  	<div class="container mt-5">
	  		<form action="reader-search">
		  	    <div class="input-group mb-3">
				  <input name="searchContent" type="text" class="form-control" placeholder="Enter the book title you want to search" aria-label="Search Book" aria-describedby="button-addon2">
				  <div class="input-group-append">
				    <button class="btn btn-primary btn-block" type="submit">SEARCH</button>
				  </div>
				</div>
			</form>
		</div>
		
		<img src="https://api.qrserver.com/v1/create-qr-code/?size=150%C3%97150&data=9787464654">
		
	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>