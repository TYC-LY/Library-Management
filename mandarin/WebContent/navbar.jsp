<%@ page import="entity.Reader"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<nav class="navbar navbar-expand-lg navbar-light">

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="http://codeseven.github.io/toastr/build/toastr.min.css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="//cdn.bootcss.com/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
<link href="css/bulletin-board.css" rel="stylesheet">

<script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/toastr.min.js"></script>


	<%
		session = request.getSession();
		Reader reader = (Reader) session.getAttribute("reader");
	%>
	<c:set var="emaill" scope="session"
		value="${sessionScope.reader.getEmail()}" />
	<img alt="logo" src="pic/logo.png" weight="100px" height="60px">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav m-auto">
			<li class="nav-item"><a class="btn btn-light" href="reader-index.jsp">Home</a></li>
			<li class="nav-item"><a class="btn btn-light" href="search.jsp">Search</a></li>
			<li class="nav-item">
				<button type="button" class="btn btn-light" data-toggle="modal"
					data-target="#exampleModal" data-whatever="Librarian">Contact
					us</button>
			</li>
			<c:if test="${not empty emaill}">
				<li class="nav-item"><a class="btn btn-light" id="btn-login"
					href="profile.jsp"> Profile </a></li>
				<li class="nav-item">
					<form action="reader-current-borrowed">
						<button type="submit" class="btn btn-light">Current
							Borrowing</button>
					</form>
				</li>
				<li class="nav-item">
					<form action="reader-borrow-history">
						<button type="submit" class="btn btn-light">Borrowing
							history</button>
					</form>
				</li>
			</c:if>
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


		<form action="reader-in" class="form-login" method="post">
			<c:if test="${empty emaill}">
				<!-- 判断当session中不存在reader对象时生成login按钮 -->
				<button class="btn btn-outline-primary my-2 my-sm-0" id="btn-login">login</button>
			</c:if>
		</form>

		<form action="reader-out" class="form-logout" method="post">
			<c:if test="${not empty emaill}">
				<!-- 判断当session中存在reader对象时生成logout按钮 -->
				<button class="btn btn-outline-primary my-2 my-sm-0">logout
				</button>
				<a class="btn btn-primary my-2 my-sm-0" id="btn-login"
					href="profile.jsp"> <s:property
						value="#session.reader.getUsername()"></s:property>
					<!-- 获取session中reader的username -->
				</a>
			</c:if>
		</form>
		</div>

		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="exampleModalLabel">New message</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<a class="legend">Message will be send to</a>
							<div role="img" aria-label="Aaron profile" size="51"
								class="intercom-1m03k4l e1chjwx0">H</div>
							<div class="intercom-8lzof5 emkvacf6">Huang</div>

							<div>
								<div class="input-group" style="margin-top: 15px;">
									<div class="input-group-prepend">
										<span class="input-group-text">Contact email:</span>
									</div>
									<input type="text" class="form-control" id="useremail"
										placeholder="Email" required="">
									<div class="invalid-feedback" style="width: 100%;">Your
										email is required.</div>
								</div>
								<div class="form-group" style="margin-top: 10px;">
									<label for="message-text" class="control-label">Message:</label>
									<div id="editor">
										<p>write here</p>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<form action="reader-send-message" class="form-send-message"
								method="post">
								<a class="btn btn-default" data-dismiss="modal">Close</a> <input
									type="hidden" id="content" name="content_reader">
									<input
									type="hidden" id="contactemail" name="contactemail">
								<button class="btn btn-primary" onclick="fun()">Send
									message</button>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- contact us的编辑器触发 -->
			<script>
				$('#exampleModal').on('show.bs.modal', function(event) {
					var button = $(event.relatedTarget) // Button that triggered the modal
					//var recipient = button.data('whatever') // Extract info from data-* attributes
					// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
					// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
					//var modal = $(this)
					//modal.find('.modal-title').text('New message to ' + recipient)
					//modal.find('.modal-body input').val(recipient)
				})
			</script>
			<script src="//unpkg.com/wangeditor/release/wangEditor.min.js"></script>
			<script>
				var E = window.wangEditor
				var editor = new E('#editor')
				editor.customConfig.menus = [ 'head', 'bold', 'italic',
						'foreColor', // 文字颜色
						'backColor', // 背景颜色
						'underline', //下划线
						'image', // 插入图片
						'video', // 插入视频
						'undo', // 撤销
				]
				// 或者 var editor = new E( document.getElementById('editor') )
				editor.create();

				function fun() {
					toastr.options = {
						"timeOut" : "2500",
						"preventDuplicates" : true,
						"preventManyTimes" : true,
						"hideDuration" : "1",
						"positionClass" : "toast-top-center"
					};
					var content = editor.txt.text();
					document.getElementById("content").value = content;
					toastr.success('email has been sent')
					var l = document.getElementById("useremail").value
					document.getElementById("contactemail").value = l;
				}
			</script>

		</div>
</nav>