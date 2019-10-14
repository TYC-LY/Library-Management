<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">

	<title>Mandarin</title>
</head>
<body>
                <form action="reset" class="readerAction" method="post">
	                <div class="input-group mb-3">
	                    <input name="email" type="text" class="form-control" placeholder="please enter your email" aria-label="" required aria-describedby="basic-addon2">
	                    <input name="password" type="text" class="form-control" placeholder="please enter your password" aria-label="" required aria-describedby="basic-addon2">
	                    <input name="repeatpw" type="text" class="form-control" placeholder="please repeat your password" aria-label="" required aria-describedby="basic-addon2">
	                    <div class="input-group-append">
	                        <button class="btn btn-outline-color"  type="submit" onclick=confirm()>submit</button>
	                    </div>
	                </div>  
	             </form>>   
<script type="text/javascript">
function confirm(){
	window.confirm("Your email and password will be changed");
}
</script>
</body>
</html>