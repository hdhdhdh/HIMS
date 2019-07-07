<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<%--  未处理预约   --%>


	<head>
		<meta charset="UTF-8">
		<title>未处理预约</title>
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
		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/begtable.css" />
	</head>

	<body>
		<div style="margin: 15px;">
			<fieldset class="layui-elem-field">
				<legend align="center">未处理预约</legend>
				<form class="clearfix">
					<select class="form-control">
						<option value="today">今天</option>
						<option value="threeday">三天内</option>
						<option value="week">一周内</option>
						<option value="all">全部</option>
					</select>
					<button type="button" class="btn btn-primary" id="refresh">刷新</button>
				</form>
			</fieldset>
			<hr>
			<div style="width: 90%; height: 400px; border: 1px solid #009688;">
			  <div class="beg-table-box">
					<div class="beg-table-body">
						<table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
							<thead>
								<tr>
									<th>病人姓名</th>
									<th>病人性别</th>
									<th>病人年龄</th>
									<th>身份证号</th>
									<th>预约时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="unprocessedAppointmentTable">
								<%--<tr>--%>
									<%--<td>1</td>--%>
									<%--<td>张三</td>--%>
									<%--<td>2019-7-6</td>--%>
									<%--<td>骨科</td>--%>
									<%--<td class="info">待处理</td>--%>
									<%--<td>--%>
										<%--<a href="historyCase.jsp"><button class="layui-btn layui-btn-small">历史病例</button></a>--%>
										<%--<a href="acceptCase.jsp"><button class="layui-btn layui-btn-small">受理</button></a>--%>
									<%--</td>--%>
								<%--</tr>--%>
							</tbody>
						</table>
					</div>
					<div class="beg-table-paged"></div>
			  </div>
			</div>
		</div>
        <div class="footer">
<!--按钮-->

<!--结束-->                
</div>
		<script type="text/javascript" src="plugins/layui/layui.js"></script>
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
		<script src="js/jquery-2.2.1.min.js">
		</script>
<script>

	$("#refresh").click(function () {
        getUnprocessedList();
    });
    $(document).ready(function () {	//页面加载完毕请求医生列表
        getUnprocessedList();
    });
    function getUnprocessedList() {
        // alert("fuck");
        // page=page||1;
        // size=size||5;	//设置默认第一页，每页5条记录
        $.ajax({
            url : "/doctor/getUnprocessedAppointment.do",
            type : "POST",
            data :
			{
                type:   "all",
                // ad_password:  size
            },
            dataType : "json",
            //处理后端返回的数据
            success : function(result) {
                console.log(result);
                //处理doctorList
                $.each(result,function (index, item) {
                    $("#unprocessedAppointmentTable").append("<tr>" +
                        "<td>" + item.p_name+"</td>\n" +
                        "<td>" + item.p_gender +"</td>" +
                        "<td>" + item.p_age +"</td>"+
                        "<td>" + item.p_id +"</td>" +
                        "<td>" + item.a_date +"</td>" +
                        "<td>" +
                        "<a href=\"historyCase.jsp?p_id='" + item.p_id + "'\"><button class=\"layui-btn layui-btn-small\">历史病例</button></a>" +
                        "<a href=\"acceptCase.jsp\"><button class=\"layui-btn layui-btn-small\">受理</button></a>" +
                        "</td>" +
                        "</tr>"
					)
                });
            },
            //处理失败返回的数据
            error : function(result) {
                window.location.href="err.html";
            }
        });
    }
</script>
	</body>

</html>