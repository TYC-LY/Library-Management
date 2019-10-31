<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="http://codeseven.github.io/toastr/build/toastr.min.css">  
<link href="css/bootstrap.css" rel="stylesheet">
<link href="//cdn.bootcss.com/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">

<!-- JS -->
<script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/toastr.min.js"></script>
<script src="js/bootstrap.js"></script>


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
	
  </head>
  <body class="text-center" background="pic/bg111.jpg">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>Mandarin</title>
</head>
<body>
   
	             
<form action="reader-changeInfo" class="reader-login" method="post">
  <h1 class="h3 mb-3 font-weight-normal">Mandarin</h1>
  <input name="username" type="text" class="form-control" placeholder="enter new username" aria-label="" required aria-describedby="basic-addon2">
  <input name="email" type="text" class="form-control" placeholder="enter new email" aria-label="" required aria-describedby="basic-addon2">
  <input name="password" type="text" class="form-control" placeholder="enter new password" aria-label="" required aria-describedby="basic-addon2">
  <input name="repeatpw" type="text" class="form-control" placeholder="enter new repeatwd" aria-label="" required aria-describedby="basic-addon2">
  <input name="phoneNumber" type="text" class="form-control" placeholder="enter new phoneNumber" aria-label="" required aria-describedby="basic-addon2">
  <div class="checkbox mb-3">
  </div>
		<button class="btn btn-lg btn-primary btn-block">submit</button>
	</form>
</body>
<script type="text/javascript">
</script>
</html>