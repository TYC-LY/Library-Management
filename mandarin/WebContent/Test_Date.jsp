<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
	<head>
		<meta charset="utf-8" />
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
		<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>
		<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
 
		<title></title>
	</head>
 
	<body>
	<div class="container">
	<div class="col-sm-4">
		<div style="position:relative;">
			<input type='text' class="form-control" id='datetime' />
		</div>
		<script>
			$(function() {
				$("#datetime").datetimepicker({
					format: 'YYYY-MM-DD',
					locale: moment.locale('zh-cn')
				});
			});
		</script>
	</div>
	<div class="col-sm-8">
		<form>
			<div class="col-sm-4">
			<input type='text' class="form-control" id="startdatetime" />
			</div>
			<div class="col-sm-4">
			<input type='text' class="form-control" id="enddatetime" />
			</div>
			<button type="submit">View</button>
		</form>
 		<script type="text/javascript">
	 		$(function() {
				$("#startdatetime").datetimepicker({
					format: 'YYYY-MM-DD',
					locale: moment.locale('zh-cn')
				});
				$("#enddatetime").datetimepicker({
					format: 'YYYY-MM-DD',
					locale: moment.locale('zh-cn')
				});
			});
	 	</script>
	 </div>
	</div>
</body> 
</html>