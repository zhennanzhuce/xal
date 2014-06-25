<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.xal.ors.model.CostItem"%>
<%@page import="com.xal.ors.biz.impl.CostItemServiceImpl"%>
<%@page import="com.xal.ors.biz.CostItemService"%>
<%@page import="com.xal.ors.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.xal.ors.util.OptTemplate"%>
<%@page import="com.xal.ors.biz.impl.UserServiceImpl"%>
<%@page import="com.xal.ors.biz.UserService"%>
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

	String RealName = request.getParameter("RealName");
	String Idcard = request.getParameter("Idcard");
%>
<!DOCTYPE html>
<html lang="zh-CN">
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
<link rel="stylesheet" type="text/css"
	href="/cdn/js/olxjs/1.0.0/css/olx/olx.css" media="screen">
<style>
.container {
	margin-top: -40px;
}
#costItem {
	font-size: 12px;
}
</style>
</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">
							<strong>查询条件</strong>
						</h3>
					</div>
					<div class="panel-body">
						<form id="searchFrm" class="form-inline" role="form" method="Get" action="list.jsp">
							<div class="form-group">
								<input type="text" class="form-control" id="searchFrm_RealName"
									name="RealName" placeholder="姓名">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="searchFrm_Idcard"
									name="Idcard" placeholder="身份证号">
							</div>
							<button type="submit"
								class="btn btn-default olx-glyphicon glyphicon-search olx-glyphicon-btn">查询</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
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
												CostItemService service2 = new CostItemServiceImpl(new OptTemplate());
												List<CostItem> list2 = service2.query();

												for(int i=0,j=list2.size();i<j;i++){
													CostItem item = list2.get(i);
											%>
											<tr>
												<td><%=item.getId() %></td>
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

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default table-responsive">
					<div class="panel-heading">
						<div class="btn-group">
							<b>《职业卫生安全评价，从入门到精通》报名人员</b>
						</div>
					</div>

 						<div class="panel-heading">
							<div class="btn-group">
								<button id="btn_sh" class="btn btn-info olx-glyphicon glyphicon-info-sign olx-glyphicon-btn">审核</button>
							    <button id="btn_del" class="btn btn-warning olx-glyphicon glyphicon-remove-sign olx-glyphicon-btn">删除</button>
							</div>

						    <div class="navbar-btn navbar-right hide-xs">
								<div class="btn-group">
									<button type="button" class="btn btn-primary olx-glyphicon glyphicon-export olx-glyphicon-btn">导出</button>
									<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
										<span class="caret"></span>
										<span class="sr-only">Toggle Dropdown</span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="javascript:;" onclick='exportExcel()'>导出 EXCEL</a></li>
									</ul>
								</div>
							</div>
 						</div>

					<table id="table1" data-olx-type="olx.grid"
						class="table table-bordered table-hover table-condensed table-striped"
						data-url="/manage/role/list" data-current="1" data-pagesize="20"
						data-count="561">
						<thead>
							<tr>
								<th class="olx-table-th-center">序号</th>
								<th>用户名</th>
								<th>密码</th>
								<th>姓名</th>
								<th>身份证号</th>
								<th>性别</th>
								<th>政治面貌</th>
								<th>民族</th>
								<th>籍贯</th>
								<th>毕业院校</th>
								<th>毕业时间</th>
								<th>学历</th>
								<th>专业</th>
								<th>工作单位</th>
								<th>所在部门</th>
								<th>从事专业</th>
								<th>职位</th>
								<th>职称</th>
								<th>联系电话</th>
								<th>联系地址</th>
								<th>项目编号</th>
								<th>审核</th>
							</tr>
						</thead>
						<tbody>
							<%
									UserService service = new UserServiceImpl(new OptTemplate());

									List<User> list = null;
									if("".equals(RealName) && "".equals(Idcard)){
										list = service.query();
									}else{
										list = service.query(RealName, Idcard);
									}

									for(int i=0,j=list.size();i<j;i++){
										User item = list.get(i);
								%>
							<tr>
								<td><%=item.getId() %> <input type='checkbox'
									value='<%=item.getId() %>'></td>
								<td><%=item.getUserName() %></td>
								<td><%=item.getUserPass() %></td>
								<td><%=item.getRealName() %></td>
								<td><%=item.getIdcard() %></td>
								<td><%=item.getSex() %></td>
								<td><%=item.getZzmm() %></td>
								<td><%=item.getMz() %></td>
								<td><%=item.getJg() %></td>
								<td><%=item.getByyx() %></td>
								<td><%=item.getBysj() %></td>
								<td><%=item.getXl() %></td>
								<td><%=item.getZy() %></td>
								<td><%=item.getGzdw() %></td>
								<td><%=item.getSzbm() %></td>
								<td><%=item.getCszy() %></td>
								<td><%=item.getZw() %></td>
								<td><%=item.getZc() %></td>
								<td><%=item.getLxdh() %></td>
								<td><%=item.getLxdz() %></td>
								<td><%=item.getCostItem() %></td>
								<td><%
									switch(item.getIsPass()){
									case 0:
										out.print("未审核");
										break;
									case 1:
										out.print("通过");
										break;
									case 2:
										out.print("未通过");
										break;
									}
								%></td>
							</tr>
							<%
									}
								%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="/cdn/js/jquery/2.0.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="/cdn/js/bootstrap/3.0.3/dist/js/bootstrap.js"></script>
	<script type="text/javascript">
		$(function() {
		});
		$('#btn_sh').click(function(){
			console.log("审核");

			var vals = [];
			$('#table1 input[type="checkbox"]:checked').each(function(i, checkbox){
				vals.push($(checkbox).val());
			});
			var ids = vals.toString();
			if('' == ids) return alert('请选择报名人员！');

			var cm = confirm('审核通过点确定，不通过选择取消！');

			$.ajax({
				url : 'Verify',
				type : "POST",
				dataType : "json",
				data: {
					ids: ids,
					isPass: cm ? 1 : 2,
					ts: (new Date()).valueOf()
				}
			}).done(function(data) {
				alert('操作成功！');
				location.reload();
			});
		});
		$('#btn_del').click(function(){
			console.log('删除');

			var vals = [];
			$('#table1 input[type="checkbox"]:checked').each(function(i, checkbox){
				vals.push($(checkbox).val());
			});
			var ids = vals.toString();
			if('' == ids) return alert('请选择报名人员！');


			var cm = confirm('您确定要执行删除操作吗？');
			if(!cm) return;

			$.ajax({
				url : 'RemoveUser',
				type : "POST",
				dataType : "json",
				data: {
					ids: ids,
					ts: (new Date()).valueOf()
				}
			}).done(function(data) {
				alert('操作成功！');
				location.reload();
			});
		});

		function exportExcel(){
			console.log('导出Excel');
		}
	</script>
</body>
</html>