<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
</head>
<body>
	
	
	<!-- 导航栏 -->
	<jsp:include page="/jsp/header.jsp" flush="true" />

	<!-- 主体部分 -->
	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">
				<!-- 侧边栏 -->
				<jsp:include page="/jsp/sidebar.jsp" flush="true" />
			</div>

			<div class="col-sm-8">
				<h1>Edit Announcement</h1>			
		      <form action="editAnnouncement">
		      		<input name="state" type="hidden" value="Edit"/>
		      		<input name="id" type="hidden" value="<s:property value="announcement.id"/>" />
		        	<label for="title">title:</label><br/>
					<input class="form-control" name="title" type="text" style="width:500px;height:30px;" value="<s:property value="announcement.title"/>"/><br/><br/>
					<label for="content">content:</label><br/>
					<textarea class="form-control" name="content" type="text" style="width:500px;height:300px;" /><s:property value="announcement.content"/></textarea><br/><br/>
					
					<s:property value="errorMessage"/>
					
					<button type="submit" class="btn btn-primary">Edit</button>
			  </form>
			</div>
		</div>
	</div>
	
</body>
</html>