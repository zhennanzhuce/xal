<%@page import="com.xal.ors.biz.UserService"%>
<%@page import="com.xal.ors.biz.impl.UserServiceImpl"%>
<%@page import="com.xal.ors.model.User"%>
<%@page import="com.xal.ors.model.CostItem"%>
<%@page import="java.util.List"%>
<%@page import="com.xal.ors.biz.impl.CostItemServiceImpl"%>
<%@page import="com.xal.ors.biz.CostItemService"%>
<%@page import="com.xal.ors.util.OptTemplate"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	Object lv = session.getAttribute("lv");
	if(null == lv || 1 != (Integer)lv){
		response.sendRedirect("index.jsp");
		return;
	}

	Object id = session.getAttribute("id");
	if(null == id) {
		response.sendRedirect("index.jsp");
		return;
	}

	UserService service3 = new UserServiceImpl(new OptTemplate());
	User user = service3.findById(id.toString());


%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>我的信息</title>
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
<link rel="stylesheet" type="text/css"
	href="/cdn/js/bootstrap-datetimepicker/2.2.0/css/bootstrap-datetimepicker.min.css"
	media="screen">
<style>
body {
	margin-top: 10px;
}

.container {
	width: 1000px;
}

.olx-form-required {
	color: red;
}

#costItem {
	font-size: 12px;
}

#frm_ShowErr {
	color: red;
	font-size: 12px;
	font-weight: normal;
}

#frm2_ShowErr {
	color: red;
	font-size: 12px;
	font-weight: normal;
}

#addFrm_ShowChkUser {
	color: red;
	font-size: 12px;
	font-weight: normal;
}
</style>
</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-md-12" style="margin-bottom:-10px">
				<div id="info_alert" class="alert alert-<%
						switch(user.getIsPass()){
						case 0:
							out.print("info");
							break;
						case 1:
							out.print("success");
							break;
						case 2:
							out.print("danger");
							break;
						}
					%>">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>提示：</strong><%
						switch(user.getIsPass()){
						case 0:
							out.print("《安全评价从入门到精通》审核正在进行中。");
							break;
						case 1:
							out.print("恭喜你，《安全评价从入门到精通》报名成功。");
							break;
						case 2:
							out.print("《安全评价从入门到精通》审核未通过。");
							break;
						}
					%>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>登陆信息</b>
					</div>
					<div class="panel-body">
						<form id="addFrm2" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="addFrm2_UserName" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>用户名</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm2_UserName" disabled
										name="UserName" placeholder="用户名" value="<%=user.getUserName() %>">
								</div>
								<label for="addFrm2_OldPass" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>原始密码</label>
								<div class="col-sm-4">
									<input type="password" class="form-control"
										id="addFrm2_OldPass" name="OldPass" placeholder="原始密码">
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm2_UserPass" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>登陆密码</label>
								<div class="col-sm-4">
									<input type="password" class="form-control"
										id="addFrm2_UserPass" name="UserPass" placeholder="登陆密码">
								</div>
								<label for="addFrm2_UserPass2" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>确认密码</label>
								<div class="col-sm-4">
									<input type="password" class="form-control"
										id="addFrm2_UserPass2" name="UserPass2" placeholder="确认密码">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" class="btn btn-primary" id="btn_pass_submit">修改</button>
									<button type="reset" class="btn btn-default">重置</button>
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label id="frm2_ShowErr" class="col-sm-offset-2 col-sm-10"></label>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>报名信息</b>
					</div>
					<div class="panel-body">
						<form id="addFrm" class="form-horizontal" role="form" data-url="Reg1">
							<div class="form-group">
								<label for="addFrm_RealName" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>姓名</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_RealName"
										name="RealName" placeholder="姓名" value="<%=user.getRealName() %>">
								</div>
								<label for="addFrm_Sex" class="col-sm-2 control-label">性别</label>
								<div class="col-sm-4">
									<!--div class="radio radio-inline">
											<label>
												<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>男
											</label>
										</div>
										<div class="radio radio-inline">
											<label>
												<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">女
											</label>
										</div-->
									<select class="form-control" id="addFrm_Sex" name="Sex" value="<%=user.getSex() %>">
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm_Idcard" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>身份证号</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Idcard"
										name='Idcard' placeholder="身份证号" value="<%=user.getIdcard() %>">
								</div>
								<label for="addFrm_Zzmm" class="col-sm-2 control-label">政治面貌</label>
								<div class="col-sm-4">
									<select class="form-control" id="addFrm_Zzmm" name="Zzmm" value="<%=user.getZzmm() %>">
										<option value="中共党员">中共党员</option>
										<option value="中共预备党员">中共预备党员</option>
										<option value="共青团员">共青团员</option>
										<option value="民革党员">民革党员</option>
										<option value="民盟盟员">民盟盟员</option>
										<option value="民建会员">民建会员</option>
										<option value="民进会员">民进会员</option>
										<option value="农工党党员">农工党党员</option>
										<option value="致公党党员">致公党党员</option>
										<option value="九三学社社员">九三学社社员</option>
										<option value="台盟盟员">台盟盟员</option>
										<option value="无党派人士">无党派人士</option>
										<option value="群众（现称普通公民）">群众（现称普通公民）</option>
										<option value="港澳同胞">港澳同胞</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm_Mz" class="col-sm-2 control-label">民族</label>
								<div class="col-sm-4">
									<select class="form-control" id="addFrm_Mz" name="Mz" value="<%=user.getMz() %>">
										<option value="汉族">汉族</option>
										<option value="蒙古族">蒙古族</option>
										<option value="彝族">彝族</option>
										<option value="侗族">侗族</option>
										<option value="哈萨克族">哈萨克族</option>
										<option value="畲族">畲族</option>
										<option value="纳西族">纳西族</option>
										<option value="仫佬族">仫佬族</option>
										<option value="仡佬族">仡佬族</option>
										<option value="怒族">怒族</option>
										<option value="保安族">保安族</option>
										<option value="鄂伦春族">鄂伦春族</option>
										<option value="回族">回族</option>
										<option value="壮族">壮族</option>
										<option value="瑶族">瑶族</option>
										<option value="傣族">傣族</option>
										<option value="高山族">高山族</option>
										<option value="景颇族">景颇族</option>
										<option value="羌族">羌族</option>
										<option value="锡伯族">锡伯族</option>
										<option value="乌孜别克族">乌孜别克族</option>
										<option value="裕固族">裕固族</option>
										<option value="赫哲族">赫哲族</option>
										<option value="藏族">藏族</option>
										<option value="布依族">布依族</option>
										<option value="白族">白族</option>
										<option value="黎族">黎族</option>
										<option value="拉祜族">拉祜族</option>
										<option value="柯尔克孜族">柯尔克孜族</option>
										<option value="布朗族">布朗族</option>
										<option value="阿昌族">阿昌族</option>
										<option value="俄罗斯族">俄罗斯族</option>
										<option value="京族">京族</option>
										<option value="门巴族">门巴族</option>
										<option value="维吾尔族">维吾尔族</option>
										<option value="朝鲜族">朝鲜族</option>
										<option value="土家族">土家族</option>
										<option value="傈僳族">傈僳族</option>
										<option value="水族">水族</option>
										<option value="土族">土族</option>
										<option value="撒拉族">撒拉族</option>
										<option value="普米族">普米族</option>
										<option value="鄂温克族">鄂温克族</option>
										<option value="塔塔尔族">塔塔尔族</option>
										<option value="珞巴族">珞巴族</option>
										<option value="苗族">苗族</option>
										<option value="满族">满族</option>
										<option value="哈尼族">哈尼族</option>
										<option value="佤族">佤族</option>
										<option value="东乡族">东乡族</option>
										<option value="达斡尔族">达斡尔族</option>
										<option value="毛南族">毛南族</option>
										<option value="塔吉克族">塔吉克族</option>
										<option value="德昂族">德昂族</option>
										<option value="独龙族">独龙族</option>
										<option value="基诺族">基诺族</option>
									</select>
								</div>
								<label for="addFrm_Jg" class="col-sm-2 control-label">籍贯</label>
								<div class="col-sm-4">
									<select class="form-control" id="addFrm_Jg" name="Jg" value="<%=user.getJg() %>">
										<option value="北京">北京</option>
										<option value="天津">天津</option>
										<option value="河北">河北</option>
										<option value="山西">山西</option>
										<option value="内蒙古">内蒙古</option>
										<option value="辽宁">辽宁</option>
										<option value="吉林">吉林</option>
										<option value="黑龙江">黑龙江</option>
										<option value="上海">上海</option>
										<option value="江苏">江苏</option>
										<option value="浙江">浙江</option>
										<option value="安徽">安徽</option>
										<option value="福建">福建</option>
										<option value="江西">江西</option>
										<option value="山东">山东</option>
										<option value="河南" selected>河南</option>
										<option value="湖北">湖北</option>
										<option value="湖南">湖南</option>
										<option value="广东">广东</option>
										<option value="广西">广西</option>
										<option value="海南">海南</option>
										<option value="重庆">重庆</option>
										<option value="四川">四川</option>
										<option value="贵州">贵州</option>
										<option value="云南">云南</option>
										<option value="西藏">西藏</option>
										<option value="陕西">陕西</option>
										<option value="甘肃">甘肃</option>
										<option value="青海">青海</option>
										<option value="宁夏">宁夏</option>
										<option value="新疆">新疆</option>
										<option value="台湾">台湾</option>
										<option value="香港">香港</option>
										<option value="澳门">澳门</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm_Byyx" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>毕业院校</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Byyx"
										name="Byyx" placeholder="毕业院校" value="<%=user.getByyx() %>">
								</div>
								<label for="addFrm_shadow_Bysj" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>毕业时间</label>
								<div class="col-sm-4">
									<div class="input-group date form_date col-md-12" data-date=""
										data-date-format="yyyy-mm-dd" data-link-field="addFrm_Bysj"
										data-link-format="yyyy-mm-dd">
										<input class="form-control" id='addFrm_shadow_Bysj'
											type="text" value="" readonly placeholder="毕业时间"> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-remove"></span> </span> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-calendar"></span> </span>
									</div>
									<input type="hidden" data-olx-type="olx.form.input"
										class="form-control" id="addFrm_Bysj" name="Bysj"
										placeholder="毕业时间" value="<%=user.getBysj() %>">
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm_Xl" class="col-sm-2 control-label">学历</label>
								<div class="col-sm-4">
									<select class="form-control" id="addFrm_Xl" name='Xl' value="<%=user.getXl() %>">
										<option value="大专">大专</option>
										<option value="本科" selected>本科</option>
										<option value="硕士">硕士</option>
										<option value="博士">博士</option>
										<option value="MBA">MBA</option>
										<option value="EMBA">EMBA</option>
										<option value="中专">中专</option>
										<option value="中技">中技</option>
										<option value="高中">高中</option>
										<option value="初中">初中</option>
										<option value="其他">其他</option>
									</select>
								</div>
								<label for="addFrm_Zy" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>专业</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Zy"
										name="Zy" placeholder="专业" value="<%=user.getZy() %>">
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm_Gzdw" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>工作单位</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Gzdw"
										name="Gzdw" placeholder="工作单位" value="<%=user.getGzdw() %>">
								</div>
								<label for="addFrm_Szbm" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>所在部门</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Szbm"
										name="Szbm" placeholder="所在部门" value="<%=user.getSzbm() %>">
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm_Cszy" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>从事专业</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Cszy"
										name="Cszy" placeholder="从事专业" value="<%=user.getCszy() %>">
								</div>
								<label for="addFrm_Zw" class="col-sm-2 control-label">职位</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Zw"
										name="Zw" placeholder="职位" value="<%=user.getZw() %>">
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm_Zc" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>职称</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Zc"
										name="Zc" placeholder="职称" value="<%=user.getZc() %>">
								</div>
								<label for="addFrm_Lxdh" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>联系电话</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Lxdh"
										name="Lxdh" placeholder="联系电话" value="<%=user.getLxdh() %>">
								</div>
							</div>
							<div class="form-group">
								<label for="addFrm_Zgzs" class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>资格证书</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Zgzs"
										name="Zgzs" placeholder="资格证书" value="<%=user.getZgzs() %>">
								</div>
								<label for="addFrm_Lxdz" class="col-sm-2 control-label">联系地址</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="addFrm_Lxdz"
										name="Lxdz" placeholder="联系地址" value="<%=user.getLxdz() %>">
								</div>
							</div>

							<div class="form-group"></div>
							<div class="form-group"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><span
									class="olx-form-required">*</span>项目选择</label>
								<div class="col-sm-10">
									<table class="table table-bordered table-hover table-condensed table-striped" id='costItem'>
										<thead>
											<tr>
												<th>编号</th>
												<th>项目名称</th>
												<th>天数</th>
												<th>费用</th>
												<th>说明（鼠标悬停单元格可看相关详细介绍）</th>
											</tr>
										</thead>
										<tbody>
											<%
												CostItemService service = new CostItemServiceImpl(new OptTemplate());
												List<CostItem> list = service.query();

												for(int i=0,j=list.size();i<j;i++){
													CostItem item = list.get(i);
											%>
											<tr>
												<td><%=item.getId() %> <input type='checkbox' id='costItem_chk_<%=item.getId() %>'
													value='<%=item.getId() %>'></td>
												<td><%=item.getItemName() %></td>
												<td><%=item.getDayNum() %></td>
												<td><%=item.getCost() %> <%=item.getCostUnit() %></td>
												<td title='<%=item.getComment2() %>'><%=item.getComment() %></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" class="btn btn-primary" id="btn_submit"<% if(1 == user.getIsPass()) out.print(" disabled"); %>>提交</button>
									<button type="reset" class="btn btn-default"<% if(1 == user.getIsPass()) out.print(" disabled"); %>>重置</button>
								</div>
							</div>
							<div class="form-group">
								<label id="frm_ShowErr" class="col-sm-offset-2 col-sm-10">注意：提交前请再次确认带
									* 的信息填写完整，若留空管理员将不会审核您的资料。</label>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="/cdn/js/jquery/2.0.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="/cdn/js/bootstrap/3.0.3/dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="/cdn/js/jquery/ext/ext.form.js"></script>
	<script type="text/javascript"
		src="/cdn/js/underscore/1.5.1/underscore.min.js"></script>
	<script type="text/javascript"
		src="/cdn/js/olxjs/1.0.0/js/olx.min.js?v12"></script>
	<script type="text/javascript"
		src="/cdn/js/bootstrap-datetimepicker/2.2.0/js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="/cdn/js/bootstrap-datetimepicker/2.2.0/js/locales/bootstrap-datetimepicker.zh-CN.js"
		charset="UTF-8"></script>
	<script type="text/javascript">
		$('.form_date').datetimepicker({
			language : 'zh-CN',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
		$(function() {
			$('#addFrm_Sex').val('<%=user.getSex()%>');
			$('#addFrm_Zzmm').val('<%=user.getZzmm()%>');
			$('#addFrm_Mz').val('<%=user.getMz()%>');
			$('#addFrm_Jg').val('<%=user.getJg()%>');
			$('#addFrm_Xl').val('<%=user.getXl()%>');
			$('#addFrm_Bysj').val('<%=user.getBysj()%>');
			$('#addFrm_shadow_Bysj').val('<%=user.getBysj()%>');

			var s = '<%=user.getCostItem()%>';
			var arr = s.split(',');
			for (var i in arr) {
				var id = arr[i];
				var chkid = 'costItem_chk_' + id;
				$('#' + chkid) .attr('checked', true);
			}
		});

		function valiFrm(){
		}

		$('#btn_submit').click(function() {
			var valiResu = valiFrm();
			if(valiResu) {
				$('#frm_ShowErr').css('display', 'block');

				if ('string' === typeof valiResu) {
					return $('#frm_ShowErr').text(valiResu);
				}
				$('#frm_ShowErr').text(valiResu[0]);
				return;
			}

			var data = $('#addFrm').serializeObjectForm ();
			data.Id = <%=user.getId()%>
			data.ts = (new Date()).valueOf();

			var vals = [];
			$('#costItem input[type="checkbox"]:checked').each(function(i, checkbox){
				vals.push($(checkbox).val());
			});
			data.CostItem = vals.toString();

			if('' == data.CostItem){
				$('#frm_ShowErr').css('display', 'block');
				return $('#frm_ShowErr').text('请选择收费项目');
			}


			$.ajax({
				url : 'EditInfo',
				type : "POST",
				dataType : "json",
				data: data
			}).done(function(data) {
				if(!data.success){
					var valiResu = data.msg;
					$('#frm_ShowErr').css('display', 'none');
					$('#frm_ShowErr').css('display', 'block');

					if ('string' === typeof valiResu) {
						return $('#frm_ShowErr').text(valiResu);
					}
					$('#frm_ShowErr').text(valiResu[0]);
					return;
				}
				alert('修改成功');
				location.href = 'my.jsp?ts='+ (new Date()).valueOf();
			});
		});

		$('#btn_pass_submit').click(function(){
			console.log("修改密码");
			$('#frm2_ShowErr').parent().css('display', 'block');
			var frmObj = $('#addFrm2').serializeObjectForm();
			if ('' === frmObj.OldPass) {
				$('#addFrm2_OldPass').focus();
				return $('#frm2_ShowErr').text('原始密码不能为空。');
			}
			if ('' === frmObj.UserPass) {
				$('#addFrm2_UserPass').focus();
				 return $('#frm2_ShowErr').text('登陆密码不能为空。');
			}
			if (frmObj.UserPass2 !== frmObj.UserPass) {
				$('#addFrm2_UserPass2').focus();
				 return $('#frm2_ShowErr').text('登陆密码与确认密码不一致。');
			}

			frmObj.ts = (new Date()).valueOf();

			$.ajax({
				url : 'ChangePass',
				type : "POST",
				dataType : "json",
				data: frmObj
			}).done(function(data) {
				if(data.success) {
					$('#frm2_ShowErr').parent().css('display', 'none');
					alert('密码修改成功!');
					location.href = 'my.jsp?ts='+ (new Date()).valueOf();
					return;
				}
				$('#frm2_ShowErr').parent().css('display', 'block');
				$('#frm2_ShowErr').text('密码修改失败，请确认输入是否正确。');
			});
		});
	</script>
</body>
</html>