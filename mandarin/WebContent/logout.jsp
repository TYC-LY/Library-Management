<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Logout</title>
</head>
<body>
	<form action="logout">
		welcome,<s:property value="username" ></s:property>
		<br>
		
		<button name="logout" type="submit">
		logout
		</button>
	</form>
</body>
</html>