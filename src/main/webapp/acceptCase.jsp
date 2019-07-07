<%@ page import="com.whut.bean.Doctor" %>
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
        <h1><a href="unprocessedAppointmentPage.jsp">返回</a></h1></blockquote>
    <fieldset class="layui-elem-field">
        <legend align="center">受理病例</legend>
        <div class="layui-field-box">
            <form action="" class="form-group" id="drug-form">
                <div class="input-group">
                    <span class="input-group-addon">医生工号</span>
                    <input type="text" class="form-control " placeholder="" name="d_id" disabled value="<%=((Doctor)(request.getSession().getAttribute("currentDoctor"))).getD_id()%>">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">病人ID&nbsp;&nbsp;&nbsp;</span>
                    <input type="text" class="form-control " placeholder="" name="p_id" disabled value="<%=request.getParameter("p_id")%>">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">病症描述</span>
                    <textarea type="text" class="form-control " placeholder="" name="c_description" value="" style="height: 120px;width: 400px;resize: none"></textarea>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">检查费用</span>
                    <input type="text" class="form-control " placeholder="" name="c_fee" value="">
                </div>
            </form>
            <div style="text-align: center">
                <a href="javascript:;"><button class="layui-btn layui-btn-normal layui-btn-radius" id="confim"align="center">确认</button></a>
            </div>
        </div>
    </fieldset>

</div>
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script src="js/jquery-2.2.1.min.js">
</script>
<script>

    $("#confim").click(function () {
        diagnosis();
    });
    function diagnosis() {
        var p_id = $("input[name='p_id']").val();
        var c_description = $("textarea[name='c_description']").val();
        var c_fee = $("input[name='c_fee']").val();
     //    alert(c_description);
        $.ajax({
            url : "/doctor/addCase.do",
            type : "POST",
            data :
                {
                    p_id:  p_id ,
                    c_description:   c_description,
                    c_fee:   c_fee,
                    // ad_password:  size
                },
            dataType : "json",
            //处理后端返回的数据
            success : function(result) {
                if(result.message != "successed")
                {
                    alert(result.message);
                    window.location.href="${pageContext.request.contextPath}/unprocessedAppointmentPage.jsp";

                }else
                {
                    window.location.href="${pageContext.request.contextPath}/unprocessedAppointmentPage.jsp";
                }

            },
            //处理失败返回的数据
            error : function(result) {
                alert(result.message);
                // window.location.href="err.html";
            }
        });
    }
</script>
</body>

</html>