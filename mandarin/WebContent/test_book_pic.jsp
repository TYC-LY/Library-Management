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
	<div class="container">
		<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
			Tooltip on top
		</button>
		<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="right" title="Tooltip on right">
			Tooltip on right
		</button>
		<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="bottom" title="Tooltip on bottom">
			Tooltip on bottom
		</button>
		<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="left" title="Tooltip on left">
			Tooltip on left
		</button>
		<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-html="true" title="<img src='http://img1.doubanio.com/view/subject/m/public/s1106934.jpg' weight='100px' height='60px'>">
			Tooltip with HTML
		</button>
	</div>
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script>
    	$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip();
    	});
    </script>
</body>
</html>