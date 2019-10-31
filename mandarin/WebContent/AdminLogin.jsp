<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Admin-login</title>
<link rel="stylesheet" href="layui/css/layui.css">

</head>

<script>
function on() {
    if("<s:property value="errorMessage"/>"!=""){
    	alert("<s:property value="errorMessage"/>");
    }
};	
</script>

<body onload="on()">
	<style>
body {
	background-image: url("img/2.jpg");
	background-repeat: no-repeat;
	background-position: center;
	background-attachment: fixed;
	background-size: cover;
}
</style>
	<div class="layui-header">
		<ul class="layui-nav" lay-filter="">
			<li class="layui-nav-item layui-logo"><a href=""><img
					src="img/011.jpg" class="layui-nav-img" />Library Admin</a></li>

		</ul>
		<ul class="layui-nav layui-layout-right" lay-filter="">
			<li class="layui-nav-item layui-hide-xs" lay-unselect=lay-unselect>

			</li>

		</ul>
	</div>
	<div class="layui-row">
		<div class="layui-col-md9">
			<div class="grid-demo grid-demo-bg1" style="text-align: center;">
				<br>
			</div>
		</div>
		<div class="layui-col-md4" style="margin-left: 60%; margin-right: 5%">
			<div style="padding: 20px; background-color: #F2F2F2;">
				<div class="grid-demo" style="margin-left: 20%; margin-right: 20%">

					<form method="post" action="AdminLogin">

						<div class="layui-form-item">
							<label class="layui-form-label"><strong>Username</strong></label>
							<div class="layui-input-inline" style="width: 190px">
								<input type="text" name="username" id="username"
									placeholder="Please enter user name" class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label"><strong>Password</strong></label>
							<div class="layui-input-inline">
								<input type="password" name="password" id="password"
									placeholder="Please enter your password" class="layui-input">
							</div>

						</div>

						<div class="layui-form-item">
							<div class="layui-input-block"
								style="width: 216px; margin: 0 auto;">
								<button class="layui-btn " type="submit" lay-filter="demo1"
									style="width: 216px; margin: 0;">Login</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="layui/layui.js"></script>
	<script>
//一般直接写在一个js文件中
layui.use(['layer', 'form'], function(){

 
});
</script>
</body>
</html>