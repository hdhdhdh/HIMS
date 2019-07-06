<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>处方开药</title>
	<!--弹出框-->
	<style>
		.black_overlay{
			display: none;
			position: absolute;
			top: 0%;
			left: 0%;
			width: 100%;
			height: 100%;
			background-color: black;
			z-index:1001;
			-moz-opacity: 0.8;
			opacity:.80;
			filter: alpha(opacity=88);
		}
		.white_content {
			display: none;
			position: absolute;
			top: 25%;
			left: 25%;
			width: 55%;
			height: 55%;
			padding: 20px;
			border: 10px solid orange;
			background-color: white;
			z-index:1002;
			overflow: auto;
		}
	</style>
	<!---->


	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../css/begtable.css" />
</head>

<body>
<div style="margin: 15px;">
	<fieldset class="layui-elem-field">
		<legend align="center">开药</legend>

	</fieldset>
	<hr>
	<div style="width: 90%; height: 400px; border: 1px solid #009688;">
		<div class="beg-table-box">
			<div class="beg-table-body">
				<table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
					<thead>
					<tr>
						<th>病例编号</th>
						<th>病人姓名</th>
						<th>诊断时间</th>
						<th>诊断科目</th>
						<th>病状描述/医疗指导</th>
						<th>药物条目</th>
						<th>诊断医师</th>
						<th></th>
					</tr>
					<tr>
						<td>1</td>
						<td>张三</td>
						<td>2019-7-6</td>
						<td>骨科</td>
						<td class="info">描述描述描述描述</td>
						<td class="warning"></a></td>
						<td><Doc class="chen"></Doc></td>
						<td><a href="../writePrescription.jsp" class="layui-btn layui-btn-small" id="conform">开药</a>
					</tr>
					</thead>
				</table>
			</div>
			<div class="beg-table-paged"></div>
		</div>
	</div>
</div>

<script type="text/javascript" src="../plugins/layui/layui.js"></script>
<script>
	layui.config({
		base: 'js/'
	});

	layui.use('begtable', function() {
		var begtable = layui.begtable(),
				layer = layui.layer,
				$ = layui.jquery,
				laypage = layui.laypage;

		laypage({
			cont: $('.beg-table-paged'),
			pages: 25 //总页数
			,
			groups: 5 //连续显示分页数
			,
			jump: function(obj, first) {
				//得到了当前页，用于向服务端请求对应数据
				var curr = obj.curr;
				if(!first) {
					//layer.msg('第 '+ obj.curr +' 页');
				}
			}
		});

		console.log(begtable.getSelectedRows());
		console.log(location);
	});
</script>

<script>
	layui.use('element', function() {
		var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块

	});
</script>

</body>

</html>