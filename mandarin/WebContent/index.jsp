<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin</title>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<script src="layui/layui.js"></script>
<script src="layui/layui.all.js"></script>
</head>
<body class="layui-layout-body">
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
    <div class="grid-demo grid-demo-bg1" style="text-align: center; ">
			 <img src="img/011.jpg">
		  </div>
    <div style="padding: 15px;">
    <div class="layui-anim layui-anim-upbit">
   	 	<div  action="Admin.do" method="post" id="box" style="margin-top: 20px;text-align: center; ">  
    		<h1>Welcome!<s:property value="user"/></h1>
    		
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