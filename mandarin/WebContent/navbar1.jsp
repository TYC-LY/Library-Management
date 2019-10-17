<%@ page import="entity.Reader" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav class="navbar navbar-expand-lg navbar-light">

	<img alt="logo" src="pic/b.png">
	
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
<!--  	<script type="text/javascript" src=src="mandarin/js/navibar.js"  charset="utf-8"></script> -->

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="search.jsp">Search</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Current Borrowing</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Borrowing History</a></li>
		</ul>
		<!-- <form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form> -->
		<!-- <div class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" 
				id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sign in </a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				<a class="dropdown-item" href="#">As Reader</a> <a
					class="dropdown-item" href="#">As Librarian</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">As Admin</a>
			</div>
		</div> -->
<!-- 			<button class="btn btn-outline-primary my-2 my-sm-0" onclick=window.location.href=<%=request.getContextPath() %>/test-login.jsp>login</button> -->
	
	<form action="in" class="form-login" method="post"> 
		<%
			session=request.getSession();
			Reader reader= (Reader)session.getAttribute("reader");
		%>
		<c:set var="emaill"  scope="session" value="${sessionScope.reader.getEmail()}"/>
		<c:if test="${empty emaill}">  <!-- 判断当session中不存在reader对象时生成login按钮 -->
			<button class="btn btn-outline-primary my-2 my-sm-0" id="btn-login" >login</button>
		</c:if>
	</form>
	
	<form action="out" class="form-logout" method="post">	
		<c:if test="${not empty emaill}">  <!-- 判断当session中存在reader对象时生成logout按钮 -->
			<button class="btn btn-outline-primary my-2 my-sm-0" >logout			
			</button>
			<a class="btn btn-outline-primary my-2 my-sm-0" id="btn-login" >
			<font color='white'> <s:property value="#session.reader.getUsername()"></s:property></font> <!-- 获取session中reader的username -->
			</a>

		</c:if>
		
		
	</form>
</div>
</nav>