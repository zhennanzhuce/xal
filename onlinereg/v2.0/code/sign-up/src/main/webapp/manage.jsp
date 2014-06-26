<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//response.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	Object lv = session.getAttribute("lv");
	if(null == lv || 2 != (Integer)lv){
		response.sendRedirect("manage_login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>后台管理</title>
<meta charset="utf-8">
<meta name="robots" content="all" />
<meta name="author" content="3203317@qq.com,新" />
<meta name="generator" content="Foreworld" />
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<!--[if lte IE 9]>
		<link rel="stylesheet" type="text/css" href="/cdn/js/bsie/0.0.0/css/bootstrap-ie6.css">
		<link rel="stylesheet" type="text/css" href="/cdn/js/bsie/0.0.0/css/ie.css">
		<link rel="stylesheet" type="text/css" href="/cdn/js/verybsie/1.0.0/css/bootstrap-verybsie.css">
		<![endif]-->

<!--[if lte IE 7]>
		<link rel="stylesheet" type="text/css" href="/cdn/js/verybsie/1.0.0/css/bootstrap-verybsie.css">
		<![endif]-->

<link rel="stylesheet" type="text/css"
	href="/cdn/js/bootstrap/3.0.3/dist/css/bootstrap.css?v3.0.3"
	media="screen">
<link rel="stylesheet" type="text/css"
	href="/cdn/js/bootstrap/3.0.3/dist/css/bootstrap-theme.min.css?v3.0.3"
	media="screen">
<style>
body {
	background-color: #F5F5F5;
	padding-bottom: 40px;
	padding-top: 100px;
}

#logFrm {
	background-color: #FFFFFF;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
	margin: 0 auto 20px;
	max-width: 350px;
	padding: 19px 29px 29px;
}
</style>
</head>
<body>

	<section class="container">
		<form id="logFrm" role="form" onsubmit="return false;">
			<div class="form-group" style="text-align: center">
				<a type="button" class="btn btn-warning" href="changePw.jsp"><h2>修改密码</h2></a>
			</div>
			<div class="form-group" style="text-align: center">
				<a type="button" class="btn btn-primary" href="list.jsp?RealName=&Idcard="><h2>报名信息</h2></a>
			</div>
		</form>
	</section>

	<script type="text/javascript"
		src="/cdn/js/jquery/2.0.2/jquery.min.js?v2.0.2"></script>
	<script type="text/javascript" src="/cdn/js/jquery/ext/jquery.pin.js"></script>
	<script type="text/javascript" src="/cdn/js/jquery/ext/ext.form.js"></script>
	<script type="text/javascript"
		src="/cdn/js/underscore/1.5.1/underscore.min.js"></script>
	<script type="text/javascript"
		src="/cdn/js/bootstrap/3.0.3/dist/js/bootstrap.min.js?v3.0.3"></script>
	<script type="text/javascript"
		src="/cdn/js/FlexSlider/2.2.2/jquery.flexslider-min.js" defer></script>
	<script>
		$(function() {
		});
	</script>
</body>
</html>