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
<link href="css/bootstrap.css" rel="stylesheet">


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
    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
  </head>
  <body class="text-center">
  
<div class="modal fade" id="kk" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
</div>
  
  <form action="reader-login" class="reader-login" method="post">
  <!--  <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
  <h1 class="h3 mb-3 font-weight-normal">Mandarin</h1>
  <label for="inputEmail" class="sr-only">Email address</label>
  <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
  <label for="inputPassword" class="sr-only">Password</label>
  <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
			<button  class="btn btn-lg btn-primary btn-block" >login</button>
			<a class="btn btn-lg btn-primary btn-block" href="recovery.jsp">recovery password</a>
			<script>
			function launch_toast() {
		        var x = document.getElementById("kk")
		        //x.className = "show";
		        //var desc = document.getElementById("desc");
		        //desc.innerHTML = "<s:property value="errorMessage"></s:property>";
		        setTimeout(function() {
		            //x.className = x.className.replace("show", "");
		            x.modal();
		        }, 5000);
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
</body>
</html>