<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>BookRegistration</title>
</head>
<body>
	<h1>Add book</h1>

	<form action="register">
		<input name="ISBN" type="text" placeholder="ISBN" required autofocus="">
		<br>
		<input name="title" type="text" placeholder="title" required autofocus="">
		<br>
		<input name="author" type="text" placeholder="author" required autofocus="">
		<br>
		<input name="publisher" type="text" placeholder="publisher" required autofocus="">
		<br>
		<input name="description" type="text" placeholder="description" required autofocus="">
		<br>
		<input name="location" type="text" placeholder="location" required autofocus="">
		<br>
		<input name="price" type="text" placeholder="price" required autofocus="">
		<br>
		<input name="categoryNo" type="text" placeholder="categoryNo" required autofocus="">
		<br>
		<button name="submit" type="submit">Add</button>
	</form>
	<p><s:property value="errorMessage"/></p>
</body>
</html>