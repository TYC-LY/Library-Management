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
  <form action="reader-changeEmail" class="reader-login" method="post">
  <!--  <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
  <h1 class="h3 mb-3 font-weight-normal">Mandarin</h1>
  <label for="inputEmail" class="sr-only">email</label>
  <input name="email" type="text" id="email" class="form-control" placeholder="email" required>
  <div class="checkbox mb-3">
  </div>
			<button  class="btn btn-lg btn-primary btn-block" type="submit">submit</button>
  </form>
  </p>  
</body>
</html>