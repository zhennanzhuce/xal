<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登陆</title>
<style>
label.wrong{
	color: red;
	display: none;
}
</style>
</head>
<body>
<form id='logFrm' onsubmit="return false;">
	<label for='logFrm_UserName'>用户名：</label><input type='text' id='logFrm_UserName' name='UserName'><br>
	<label class='wrong' id='logFrm_UserName_Vali'></label><br>
	<label for='logFrm_UserPass'>密码：</label><input type='password' id='logFrm_UserPass' name='UserPass'><br>
	<label class='wrong' id='logFrm_UserPass_Vali'></label><br>
	<input type="button" id='logFrm_btn_log' value='登陆'><input id='btn_regNew' type="button" value='新用户注册'>
</form>

<script type="text/javascript" src="/cdn/js/jquery/2.0.2/jquery.min.js?v2.0.2"></script>
<script type="text/javascript" src="/cdn/js/jquery/ext/jquery.pin.js"></script>
<script type="text/javascript" src="/cdn/js/jquery/ext/ext.form.js"></script>
<script type="text/javascript" src="/cdn/js/underscore/1.5.1/underscore.min.js"></script>
<script type="text/javascript" src="/cdn/js/bootstrap/3.0.3/dist/js/bootstrap.min.js?v3.0.3"></script>
<script type="text/javascript" src="/cdn/js/FlexSlider/2.2.2/jquery.flexslider-min.js" defer></script>
<script>
$(function(){
});

function valiFrm(){
	var frmObj = $('#logFrm').serializeObjectForm();
	$('form label[id$="_Vali"]').each(function (i, label){
		$(label).css('display', 'none');
	});

	if(!frmObj.UserName.trim().length){
		$('#logFrm_UserName_Vali').text('用户名不能为空');
		$('#logFrm_UserName_Vali').css('display', 'block');
		$('#logFrm_UserName').focus();
		return;
	}
	if(!frmObj.UserPass.trim().length){
		$('#logFrm_UserPass_Vali').text('密码不能为空');
		$('#logFrm_UserPass_Vali').css('display', 'block');
		$('#logFrm_UserPass').focus();
		return;
	}
}
function subFrm(){
	var result = valiFrm();
	if(!result) return;
	console.log(121)
}
$('#logFrm_btn_log').click(subFrm);

$('#btn_regNew').click(function(){
	location.href = 'reg1.jsp';
});
</script>
</body>
</html>