<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新用户注册</title>
<style>
label.wrong{
	color: red;
	display: none;
}
</style>
</head>
<body>
<form id='regFrm' onsubmit="return false;">
	<label for='regFrm_UserName'>用户名：</label><input type='text' id='regFrm_UserName' name='UserName'><br>
	<label class='wrong' id='regFrm_UserName_Vali'></label><br>
	<label for='regFrm_UserPass'>登陆密码：</label><input type='password' id='regFrm_UserPass' name='UserPass'><br>
	<label class='wrong' id='regFrm_UserPass_Vali'></label><br>
	<label for='regFrm_UserPass2'>确认密码：</label><input type='password' id='regFrm_UserPass2' name='UserPass2'><br>
	<label class='wrong' id='regFrm_UserPass2_Vali'></label><br>
	<input type="button" id='regFrm_btn_next' value='下一步'>
</form>
<a href='index.jsp'>进入登陆页面&gt;&gt;</a>

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
	var frmObj = $('#regFrm').serializeObjectForm();

	$('form label[id$="_Vali"]').each(function (i, label){
		$(label).css('display', 'none');
	});

	if(!frmObj.UserName.trim().length){
		$('#regFrm_UserName_Vali').text('用户名不能为空');
		$('#regFrm_UserName_Vali').css('display', 'block');
		$('#regFrm_UserName').focus();
		return;
	}
	if(!frmObj.UserPass.trim().length){
		$('#regFrm_UserPass_Vali').text('登陆密码不能为空');
		$('#regFrm_UserPass_Vali').css('display', 'block');
		$('#regFrm_UserPass').focus();
		return;
	}
	if(frmObj.UserPass.trim() != frmObj.UserPass2.trim()){
		$('#regFrm_UserPass2_Vali').text('确认密码与登陆密码不一致，请重新输入！');
		$('#regFrm_UserPass2_Vali').css('display', 'block');
		$('#regFrm_UserPass2').focus();
		return;
	}
}
function subFrm(){
	var result = valiFrm();
	if(!result) return;
	console.log(121)
}
$('#regFrm_btn_next').click(subFrm);

</script>
</body>
</html>