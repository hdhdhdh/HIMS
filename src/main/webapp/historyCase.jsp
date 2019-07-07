<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>历史病例</title>


    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="css/begtable.css" />
</head>

<body>
<div style="margin: 15px;">
    <blockquote class="layui-elem-quote">
        <h1><a href="unprocessedAppointmentPage.jsp">返回</a></h1></blockquote>
    <div class="layui-elem-field">
        <legend align="center">历史病例</legend>
        <div style="width: 90%; height: 400px; border: 1px solid #009688;">
            <div class="beg-table-box">
                <div class="beg-table-body">
                    <table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
                        <thead>
                        <tr>
                            <th>病人姓名</th>
                            <th>病人性别</th>
                            <th>出生日期</th>
                            <th>诊断时间</th>
                            <th>诊断医师</th>
                            <th>诊断结果</th>
                        </tr>
                        </thead>
                        <tbody id="patientCaseTable">
                        <%--<c:forEach items="${patientCaseList}" var="patientCase">--%>
                            <%--<tr>--%>
                                <%--<th>"${p_name}"</th>--%>
                                <%--<th>"${p_gender}"</th>--%>
                                <%--<th>"${p_birthday}"</th>--%>
                                <%--<th>"${patientCase.c_date}"</th>--%>
                                <%--<th>"${patientCase.d_id}"</th>--%>
                                <%--<th>"${patientCase.c_description}"</th>--%>
                            <%--</tr>--%>
                        <%--</c:forEach>--%>
                        </tbody>
                    </table>
                </div>
                <div class="beg-table-paged"></div>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-2.2.1.min.js"></script>
<script>
    $(document).ready(function ()
    {
        console.log("获取到的：" +<%=request.getParameter("p_id")%>);
        getPatientCaseList();
    });
    function getPatientCaseList() {
        // alert("fuck");
        // page=page||1;
        // size=size||5;	//设置默认第一页，每页5条记录
        $.ajax({
            url : "/doctor/getPatientCase.do",
            type : "POST",
            data :
                {
                    p_id:   <%=request.getParameter("p_id")%>,
                    // ad_password:  size
                },
            dataType : "json",
            //处理后端返回的数据
            success : function(result) {
                if(result.message)
                {
                    alert(result.message); return;
                }

                console.log(result);
                $("#patientCaseTable").html("");
                $.each(result,function (index, item) {

                    $("#patientCaseTable").append("<tr>" +
                        "<td>" + item.p_name+"</td>\n" +
                        "<td>" + item.p_gender +"</td>" +
                        "<td>" + item.p_birthday +"</td>"+
                        "<td>" + item.c_date +"</td>" +
                        "<td>" + item.d_id +"</td>" +
                        "<td>" + item.c_description +"</td>" +
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

</body>

</html>