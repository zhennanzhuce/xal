<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>《职业卫生安全评价，从入门到精通》网上报名</title>
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
	padding-top: 40px;
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

#alert_info {
	max-width: 350px;
	margin: 0 auto 20px;
}

#regFrm_ShowErr {
	color: red;
	font-size: 12px;
	font-weight: normal;
}
</style>
</head>
<body>

	<section class="container">
	<form id="logFrm" role="form" onsubmit="return false;"
		data-url="step0.do">
		<h3>《职业卫生安全评价，从入门到精通》</h3>
		<div class="form-group">
			<input id="logFrm_UserName" name="UserName" type="text"
				class="form-control" placeholder="用户名">
		</div>
		<div class="form-group">
			<input id="logFrm_UserPass" name="UserPass" type="password"
				class="form-control" placeholder="密码">
		</div>
		<button id="btn_submit" type="button" class="btn btn-primary">登陆</button>
		<button id="btn_regNew" type="button" class="btn btn-default">注册</button>
		<div class="form-group">
			<label id="regFrm_ShowErr"></label>
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

		function valiFrm() {
			var frmObj = $('#logFrm').serializeObjectForm();
			$('#regFrm_ShowErr').css('display', 'none');

			if (!frmObj.UserName.trim().length) {
				$('#regFrm_ShowErr').text('用户名不能为空');
				$('#regFrm_ShowErr').css('display', 'block');
				$('#logFrm_UserName').focus();
				return;
			}
			if (!frmObj.UserPass.trim().length) {
				$('#regFrm_ShowErr').text('密码不能为空');
				$('#regFrm_ShowErr').css('display', 'block');
				$('#logFrm_UserPass').focus();
				return;
			}
			return true;
		}
		function subFrm() {
			var result = valiFrm();
			if (!result)
				return;

			$.ajax({
				url : 'Login',
				type : "GET",
				dataType : "json",
				data: {
					UserName: $('#logFrm_UserName').val(),
					UserPass: $('#logFrm_UserPass').val(),
					ts: (new Date()).valueOf()
				}
			}).done(function(data) {
				if (!data.success) {
					$('#regFrm_ShowErr').css('display', 'block');
					$('#regFrm_ShowErr').text('用户名或密码输入错误，请重试！');
					return;
				}
				location.href = 'my.jsp';
			});
		}
		$('#btn_submit').click(subFrm);

		$('#btn_regNew').click(function() {
			location.href = 'reg1.jsp';
		});
	</script>
</body>
</html>