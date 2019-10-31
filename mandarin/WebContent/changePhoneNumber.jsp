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
   
<p align="center">           
<form action="reader-changePhoneNumber" class="reader-login" method="post">
  <h1 class="h3 mb-3 font-weight-normal">Mandarin</h1>
  <label for="inputPhoneNumber" class="sr-only">New PhoneNumber</label>
  <input name="phoneNumber" type="text" class="form-control" placeholder="please enter your phoneNumber" aria-label="" required aria-describedby="basic-addon2">
  <div class="checkbox mb-3">
  </div>
		<button class="btn btn-lg btn-primary btn-block" onclick="pop()">submit</button>
		<script>
		toastr.options = {"timeOut": "2500","preventDuplicates": true,"preventManyTimes": true,"hideDuration": "1","positionClass": "toast-top-center"};
			function pop(){
				if("<s:property value="errorMessage"></s:property>" == "") {
					toastr.success("successfulli send password to your email")
		        } else {
		            toastr.warning("<s:property value="errorMessage"></s:property>");
		        }			  
			}
		</script>
	</form>
	</p>
</body>
<script type="text/javascript">
</script>
</html>