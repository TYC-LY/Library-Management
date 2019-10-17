<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<title>Mandarin</title>
</head>
<style>
.id {
	font-weight: bold;
	color: dimgray;
}

.createTime {
	color: grey;
}

.email {
	font-weight: normal;
	color: grey;
	font-size: small;
}

.nickname {
	background: none;
	color: inherit;
	border: none;
	padding: 0 !important;
	font: inherit;
	border-bottom: 1px solid #444;
	cursor: pointer;
}

.operation {
	font-weight: normal;
	color: grey;
	font-size: small;
}
</style>
<s:include value="navbar.jsp" />
<body class="layui-anim layui-anim-up">
	<div class="x-nav"></div>
	<table class="table container table-hover main-contents mt-4">
		<thead>
			<tr>
				<th class="table-title" scope="col">id</th>
				<th class="table-title" scope="col">username</th>
				<th class="table-title" scope="col">email</th>
				<th class="table-title" scope="col">borrowHistory</th>
				<th class="table-title" scope="col">totalFine</th>
				<th class="table-title" scope="col">operation</th>
			</tr>
		</thead>
		<tbody>
			<tr>

				<td><s:property value="#session.reader.getId()"></s:property></td>
				<td><s:property value="#session.reader.getUsername()"></s:property></td>
				<td><s:property value="#session.reader.getEmail()"></s:property></td>
				<!-- <td><s:property value="tempReader.borrowHistory"></s:property></td>
					<td><s:property value="tempReader.totalFine"></s:property></td> -->
				<td>
					<button onclick=window.location.href="<%=request.getContextPath()%>/changeInfo.jsp">
						<i class="layui-icon">&#xe642;</i>change
					</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>