<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<nav class="navbar navbar-expand-lg navbar-light">

	<img alt="logo" src="pic/b.png">
	
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

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
		<form>
			<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Sign in</button>
		</form>
	</div>

</nav>