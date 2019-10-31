<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>change_admin_password</title>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<script src="layui/layui.js"></script>
<script src="layui/layui.all.js"></script>
<style>
.T0 {
	background-color: #FfF0Ff;
	float: left;
	padding: 15px;
	border-style: solid;
	border-color: #006666;
	border-width: 5px;
}
</style>
</head>

<body class="layui-layout-body" onload="on()">

	<script language="JavaScript">
		var req;
		var same;
		var rname;
		var rpassword;
		function rightpassword() {
			var password1 = document.getElementsByName("password")[0];
			wdiv = document.getElementById("rightword");
			var text = password1.value;
			if (text.match("^[0-9A-Za-z]{1,10}$") == null) {
				wdiv.innerHTML = "<font color='red'>What you entered doesn't conform to the rules!</font>";
				rpassword = 1;
			} else {
				wdiv.innerHTML = "<font color='greed'>The password format is correct</font>";
				rpassword = 0;
			}

		}
		function sameword() {
			var password1 = document.getElementsByName("password")[0];
			var password2 = document.getElementsByName("password1")[0];
			mdiv = document.getElementById("wordmsg");

			if (password1.value != password2.value) {
				mdiv.innerHTML = "<font color='red'>Passwords are inconsistent</font>";
				same = 1;
			} else {
				mdiv.innerHTML = "<font color='green'>Password consistency</font>";
				same = 0;
			}
		}

		function check() {
			var password1 = document.getElementsByName("password");
			var password2 = document.getElementsByName("password1");
			if (rpassword == 0 && same == 0) {
				var aaa = document.getElementById("form");
				aaa.submit();
			} else {
				alert("Sumbit failed!Something wrong!")
			}
		}

		function on() {
			if ("<s:property value="errorMessage"/>" == "No problem!") {
				alert("Change successfully");
			} else if ("<s:property value="errorMessage"/>" == "Original Password is wrong!") {
				alert("<s:property value="errorMessage"/>");
			}
		}
	</script>

	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<ul class="layui-nav" lay-filter="">
				<li class="layui-nav-item layui-logo"><a href=""><img
						src="img/011.jpg" class="layui-nav-img" />Library Admin</a></li>
				<li class="layui-nav-item layui-this"><a href="">Home</a></li>

			</ul>
			<ul class="layui-nav layui-layout-right" lay-filter="">
				<li class="layui-nav-item layui-hide-xs" lay-unselect=lay-unselect>
					<a href="http://localhost:8080/mandarin/AdminLogin.jsp"> <img
						src="img/01.jpg" class="layui-nav-img" />Sign out
				</a>
				</li>

			</ul>
		</div>

		<div class="layui-side layui-bg-black">

			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;">Set/Modify</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="modify_finevalue-onload.jsp">FineValue</a>
							</dd>
							<dd>
								<a href="modify_period-onload.jsp">ReturnPeriod</a>
							</dd>
							<dd>
								<a href="modify_deposit-onload.jsp">SecurityDeposit</a>
							</dd>

						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">Librarian
							Account</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="register_librarian_accounts.jsp">Register</a>
							</dd>
							<dd>
								<a href="delect_librarian_accounts.jsp">Delect </a>
							</dd>
							<dd>
								<a href="change_librarian_accounts.jsp">Change</a>
							</dd>
							<dd>
								<a href="Search_and_Manager_Librarian_Accounts-onload.jsp">Manage</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a
						href="http://localhost:8080/mandarin/change_admin_password.jsp">ChangePassword</a></li>
				</ul>
				<script src="layui/layui.js" charset="utf-8">
					
				</script>
				<script>
					layui.use([ 'element', 'layer' ], function() {
						var element = layui.element;
						var layer = layui.layer;

						//监听折叠
						element.on('collapse(test)', function(data) {
						});
					});
				</script>
			</div>
		</div>


		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">

				<fieldset class="layui-elem-field layui-field-title">
					<legend>Change Password</legend>
				</fieldset>

				<div style="padding: 20px; background-color: #f2f2f2;">
					<div class="Content-Main">
						<div class="layui-container" style="margin-top: 10px;">

							<form method="POST" action="changePassword" id="form">
								<div class="layui-form-item">
									<label class="layui-form-label">Original password</label>
									<div class="layui-input-inline">
										<tr>
											<input type="password" name="oripassword" required
												lay-verify="required" placeholder="enter original password"
												class="layui-input" />
										</tr>
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">Input password</label>
									<div class="layui-input-inline">
										<tr>
											<input type="password" name="password"
												onblur="rightpassword()" required lay-verify="required"
												placeholder="enter a new password" class="layui-input" />
											<span id="rightword"></span>
										</tr>
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">Confirm password</label>
									<div class="layui-input-inline">
										<tr>
											<input name="password1" type="password" id="password1"
												onblur="sameword()" required lay-verify="required"
												placeholder=" the same password" class="layui-input" />
											<span id="wordmsg"></span>
										</tr>
									</div>
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<input type="button" onclick="check()" value="Submit"
											class="layui-btn" lay-submit lay-filter="formDemo" />
										<button type="reset" class="layui-btn layui-btn-primary">Reset</button>
									</div>
								</div>
							</form>

						</div>
					</div>

					<div class="layui-footer">
						<!-- 底部固定区域 -->
						Mandarin Admin
					</div>
				</div>
				<script src="../src/layui.js"></script>
				<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>