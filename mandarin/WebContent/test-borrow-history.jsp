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

    <title>test-borrow-history</title>
</head>
<body>

	<div>
		<ul class="list-group">
			<s:iterator value="historyTable">
				<li class="list-group-item d-flex justify-content-between align-items-center">
					<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
	    				<s:property value="book.title" />/
	    				<s:property value="borrowDate" />/
	    				呜呜呜
	  				</a>
				</li>
				<div class="collapse" id="collapseExample">
					<div class="card card-body">
						<!-- TODO: 完善book信息 -->
						<s:property value="location" />
					</div>
				</div>
			</s:iterator>
		</ul>
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>