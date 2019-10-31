<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>registe_librarian_accounts</title>
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
<script>
	function on() {
		if ("<s:property value="registerMessage"/>" == "Username can not be blank!") {
			alert("Username can not be blank!");
		} else if ("<s:property value="registerMessage"/>" == "Username should be in 15 digits!") {
			alert("Username should be in 15 digits!");
		} else if ("<s:property value="registerMessage"/>" == "Username have been registered!") {
			alert("Username have been registered!");
		} else if ("<s:property value="registerMessage"/>" == "Register Success!") {
			alert("Register Success!");
		}
	};
</script>

<body class="layui-layout-body" onload="on()">

	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<ul class="layui-nav" lay-filter="">
				<li class="layui-nav-item layui-logo"><a href=""><img
						src="img/011.jpg" class="layui-nav-img" />Library Admin</a></li>
				<li class="layui-nav-item layui-this"><a href="">Home</a></li>

			</ul>
			<ul class="layui-nav layui-layout-right" lay-filter="">
				<li class="layui-nav-item layui-hide-xs" lay-unselect=lay-unselect>
					<a href="http://localhost:8080/mandarin/AdminLogin.jsp"> 
					<img src="img/01.jpg" class="layui-nav-img" />Sign
						out
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
								<a href="register_librarian_accounts.jsp" class="layui-this">Register</a>
							</dd>
							<dd>
								<a href="delect_librarian_accounts.jsp">Delect </a>
							</dd>
							<dd>
								<a href="change_librarian_accounts.jsp">Change</a>
							</dd>
							<dd>
								<a href="Search_and_Manager_Librarian_Accounts-onload.jsp"
									>Manage</a>
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

		<!-- 内容主体区域 -->
		<div class="layui-body">
			<div style="padding: 15px;">

				<fieldset class="layui-elem-field layui-field-title">
					<legend>Register Librarian Accounts</legend>
				</fieldset>

				<div style="padding: 20px; background-color: #f2f2f2;">
					<div class="Content-Main">
						<div class="layui-container" style="margin-top: 10px;">

							<form method="POST" action="registerLibrarian">
								<div class="layui-form-item">
									<label class="layui-form-label">Librarian Username</label>
									<div class="layui-input-inline">
											<input name="username" type="username" id="username"
												placeholder="enter the username" class="layui-input" />
									</div>
								</div>

								<div class="layui-form-item">
									<p>There is a question that it can help librarian recovery password when he/she forget the password.</p>
									<br>
									<p>Here is the question:</p>
									<p>What is your father's name?</p>
									<br>
									
									<label class="layui-form-label">Security Answer</label>
									<div class="layui-input-inline">
										<input name="securityAnswer" type="username" id="securityAnswer"
												placeholder="enter the username" class="layui-input" />
									</div>
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<button type="SUMBIT" value="Register" class="layui-btn"
											lay-submit lay-filter="formDemo">Register</button>
										<button type="reset" value="Reset"
											class="layui-btn layui-btn-primary">Reset</button>
									</div>
								</div>
							</form>

							<form method="POST" action="ManagerLibrarian">
								<button type="SUBMIT" value="Back"
									class="layui-btn layui-btn-primary layui-btn-sm"><
									Back</button>
							</form>

						</div>
					</div>
				</div>
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
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
</body>
</html>