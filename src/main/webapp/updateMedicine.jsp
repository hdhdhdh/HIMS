<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>Paging</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">

		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/global.css" media="all">
        <link rel="stylesheet" href="css/demo.css" media="all">
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
	</head>

	<body>
		<div style="margin: 15px;">
			<blockquote class="layui-elem-quote">
				<h1><a href="begtable.html">返回</a></h1></blockquote>
			<fieldset class="layui-elem-field">
				<legend align="center">药品基本信息</legend>
				<div class="layui-field-box">
                        <form action="" class="form-group" id="drug-form">
                            <div class="input-group">
                                <span class="input-group-addon">药品名称</span>
                                <input type="text" class="form-control " placeholder="" name="m_name" value="<%=URLDecoder.decode(request.getParameter("m_name"),"utf-8")%>" disabled>
                            </div>
							<div class="input-group">
								<span class="input-group-addon">药品编号</span>
								<input type="text" class="form-control " placeholder="" name="m_id" value="<%=request.getParameter("m_id")%>" disabled>
							</div>
                            <div class="input-group">
                                <span class="input-group-addon">添加库存</span>
                                <input type="text" class="form-control " placeholder="" name="m_num" value="">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon">更改单价</span>
                                <input type="text" class="form-control " placeholder="" name="m_price" value="">
                            </div>
                        </form>
				 <div style="text-align: center">
                    <a><button class="layui-btn layui-btn-normal layui-btn-radius" align="center"id="confirm">确认</button></a>
				</div>
				</div>
			</fieldset>
			
		</div>

		<script src="js/jquery-2.2.1.min.js">
		</script>
		<script>
            $("#confirm").click(function ()
            {
                updateMedicine();
            });
            function updateMedicine()
            {
                $.ajax({
                    url : "/pharmacist/updateMedicine.do",
                    type : "POST",
                    data :
                        {
                            m_id: "<%=request.getParameter("m_id")%>",
							m_num: $("input[name='m_num']").val(),
                            m_price:$("input[name='m_price']").val(),
                        },
                    dataType : "json",
                    //处理后端返回的数据
                    success : function(result) {
                        if(result.message != "successed")
                        {
                            alert(result.message);
                            window.location.href="${pageContext.request.contextPath}/begtable.html";

                        }else
                        {
                            window.location.href="${pageContext.request.contextPath}/begtable.html";
                        }

                    },
                    //处理失败返回的数据
                    error : function(result)
                    {
                        window.location.href="err.html";
                    }
                });
            }
		</script>
		<script type="text/javascript" src="plugins/layui/layui.js"></script>

	</body>

</html>