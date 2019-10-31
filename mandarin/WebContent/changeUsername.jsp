<!--<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Signin Template · Bootstrap</title>


    <!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="http://codeseven.github.io/toastr/build/toastr.min.css">  
<link href="css/bootstrap.css" rel="stylesheet">
<link href="//cdn.bootcss.com/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">

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
 <p align="center">
  <form action="reader-changeUsername" class="reader-login" method="post">
  <!--  <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
  <h1 class="h3 mb-3 font-weight-normal">Mandarin</h1>
  <label for="inputUsername" class="sr-only">Username</label>
  <input name="username" id="inputUsername" class="form-control" placeholder="enter your new username" required>
			<button  class="btn btn-lg btn-primary btn-block" type="submit">submit</button>
			<script>
			function launch_toast() {
		        //var x = document.getElementById("kk")
		        //x.className = "show";
		        //var desc = document.getElementById("desc");
		        //desc.innerHTML = "<s:property value="errorMessage"></s:property>";
		        //setTimeout(function() {
		            //x.className = x.className.replace("show", "");
		        //    x.modal();
		        //}, 5000);
		        toastr.options = {"timeOut": "2500","preventDuplicates": true,"preventManyTimes": true,"hideDuration": "1","positionClass": "toast-top-center"};  
	            var Content= "<s:property value="errorMessage"></s:property>";  
	                    if(Content){  	 
	                        toastr.warning(Content);  
	                    }  
		    };
			console.log("launch_toast defined");
			(function() {
		        // your page initialization code here
		        // the DOM will be available here
		        if("<s:property value="errorMessage"></s:property>" == "") {
		            console.log("no error");
		        } else {
		            launch_toast();
		        }
		    })();
			</script>
  </form>  
  </p> 
</body>
</html>