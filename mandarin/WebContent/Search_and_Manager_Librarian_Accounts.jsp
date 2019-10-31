<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search_and_Manage_Librarian_Accounts</title>
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
.carI {
	width: 50%;
}

p.a {
	font-size: 15px;
	background-color: #ffffff;
}

p.b {
	font-size: 20px;
}

* {
	box-sizing: border-box;
}

body {
	background-color: #E8E8D0;
}

.T0 {
	width: 100%;
	float: left;
}

.T1 {
	background-color: #F0F0F0;
	width: 43%;
	float: left;
	padding: 15px;
	border: 1px layui-bg-green;
}

.T2 {
	background-color: #FfF0Ff;
	width: 43%;
	float: left;
	padding: 15px;
	border: 1px layui-bg-green;
}

.T3 {
	width: 33%;
	float: left;
	padding: 15px;
	border: 1px layui-bg-green;
}

.T4 {
	width: 85%;
	float: left;
	padding: 15px;
	border: 1px layui-bg-green;
}

.menup {
	background-color: #F0F0F0;
	width: 14%;
	float: left;
	padding: 10px;
	border: 1px layui-bg-green;
}

.main {
	background-color: #ffffff;
	width: 80%;
	float: right;
	padding: 15px;
	border: 1px layui-bg-green;
}

.mainp {
	background-color: #ffffff;
	width: 85%;
	float: right;
	padding: 10px;
	border: 1px layui-bg-green;
}

.maint {
	background-color: #ffffff;
	width: 80%;
	float: right;
	padding: 15px;
	border: 1px layui-bg-green;
}

.maintt {
	width: 80%;
	float: right;
	padding: 15px;
	border: 1px layui-bg-green;
}

}
.t1 {
	width: 40%;
	float: right;
	margin-top: 600px;
	padding: 15px;
	border: 1px layui-bg-green;
}

.t3 {
	width: 21%;
	float: right;
	margin-top: 20px;
	padding: 15px;
	border: 1px layui-bg-green;
}

.t2 {
	width: 68%;
	float: left;
	padding: 15px;
	border: 1px layui-bg-green;
}
</style>

</head>

<body class="layui-layout-body">

	<script>
		function search() {
			var aaa = document.getElementById("form");
			aaa.action = "searchLibrarian";
			aaa.submit();
		};
		function renew() {
			var aaa = document.getElementById("form");
			aaa.action = "ManagerLibrarian";
			aaa.submit();
		};
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
								<a href="register_librarian_accounts.jsp">Register</a>
							</dd>
							<dd>
								<a href="delect_librarian_accounts.jsp">Delect </a>
							</dd>
							<dd>
								<a href="change_librarian_accounts.jsp">Change</a>
							</dd>
							<dd>
								<a href="Search_and_Manager_Librarian_Accounts-onload.jsp"
									class="layui-this">Manage</a>
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

				<div style="padding: 20px;">
					<div class="Content-Main">
						<div class="layui-container" style="margin-top: 10px;">

							<div class="layui-container" style="margin-top: 20px;">

								<div class="t2">
									<h3 id="Tname">
										<strong>Search and Manage Librarian Accounts</strong>
									</h3>
								</div>
								<div class="t1">
									<form id="form" method="POST">
										<input name="username" type="username" id="username"
											placeholder="username" /><br />
											<button class="layui-btn layui-btn-primary layui-btn-sm" onclick="search()">Search</button>
											<button class="layui-btn layui-btn-primary layui-btn-sm" onclick="renew()">Renew</button>
											
									</form>
								</div>

								<div class="T3">
									<a
										href="http://localhost:8080/mandarin/register_librarian_accounts.jsp"
										class="layui-btn layui-btn-sm"> Register Librarian
										Accounts</a>
								</div>
								<div class="T3">
									<a
										href="http://localhost:8080/mandarin/delect_librarian_accounts.jsp"
										class="layui-btn layui-btn-sm"> Delect Librarian Accounts</a>
								</div>
								<div class="T3">
									<a
										href="http://localhost:8080/mandarin/change_librarian_accounts.jsp"
										class="layui-btn layui-btn-sm"> Change Librarian Accounts</a>
								</div>

								<div class="T4">
									<hr class="layui-bg-green" />
									<hr class="layui-bg-green" />
								</div>

								<div class="T1">
									<h4>
										<strong>id</strong>
									</h4>
								</div>
								<div class="T2">
									<h4>
										<strong>username</strong>
									</h4>
								</div>
								<hr class="layui-bg-gray" />
								<hr class="layui-bg-gray" />
								<s:iterator value="librariantemp">
									<div class="T0">
										<div class="T2">
											<h4>
												<s:property value="id" />
											</h4>
										</div>
										<div class="T1">
											<h4>
												<s:property value="username" />
											</h4>
										</div>
								</s:iterator>
								<div class="T4">
									<hr class="layui-bg-green" />
									<hr class="layui-bg-green" />
								</div>
							</div>


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