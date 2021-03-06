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
    <link rel="stylesheet" href="css/begtable.css" />
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
</head>

<body>
<div style="margin: 15px;">
    <blockquote class="layui-elem-quote">
        <h1><a href="js/shujudangan.jsp">返回</a></h1></blockquote>
    <fieldset class="layui-elem-field">
        <legend align="center">开药</legend>
        <div class="input-group" style="text-align: center">
            <span class="input-group-addon">病人描述</span>
            <input type="text" class="form-control " placeholder="" name="p_description" value="" disabled style="width:90%; ">
        </div>
        <div class="input-group" style="text-align: center">
            <span class="input-group-addon">已开药物</span>
            <input type="text" class="form-control " placeholder="" name="m_namelist" value="" disabled style="width:90%; ">
        </div>
        <div class="layui-field-box">
            <p style="text-align: center">
                <input name="m_name" type="text" value="">
                <a href="javascript:;" class="layui-btn layui-btn-small" id="search" style="">
                    <i class="layui-icon" >&#xe615;</i> 搜索
                </a>
                <a><button id="confirm" class="layui-btn layui-btn-normal layui-btn-radius" align="center" style="margin-left: 350px">确认</button></a>
            </p>
        </div>
            <div style="width: 90%; height: 400px; border: 1px solid #009688;">
                <div class="beg-table-box">
                    <div class="beg-table-body">
                        <table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
                            <thead>
                            <tr>
                                <th>药品编号</th>
                                <th>药品名称</th>
                                <th>剩余库存</th>
                                <th>所属类别</th>
                                <th>单价</th>
                                <th>操作</th>
                            </tr>
                            <tr>
                                <%--<td>1</td>--%>
                                <%--<td>86900373000051</td>--%>
                                <%--<td>阿司匹林栓</td>--%>
                                <%--<td>500</td>--%>
                                <%--<td>OTC</td>--%>
                                <%--<td>40.00</td>--%>
                                <%--<td>--%>
                                    <%--<a><button class="layui-btn layui-btn-small" align="center">添加</button></a>--%>
                                <%--</td>>--%>
                            <%--</tr>--%>
                            </thead>
                            <tbody id="medicineTable">

                            </tbody>
                        </table>

                        <%--<div style="text-align: center">--%>
                            <%--<a><button class="layui-btn layui-btn-normal layui-btn-radius" align="center">确认</button></a>--%>
                        <%--</div>--%>
                    </div>
                </div>
        </div>
    </fieldset>
</div>
<script type="text/javascript" src="plugins/layui/layui.js"></script>
</body>
<script src="js/jquery-2.2.1.min.js">
</script>
<script>

    $("#search").click(function ()
    {
        searchMedicine();
    });

    $(document).ready(function ()
    {
        $.ajax({

            url : "/doctor/getCaseById.do",
            type : "POST",
            data :
                {
                    c_id:   "<%=request.getParameter("c_id")%>",
                },
            dataType : "json",

            success : function(result) {
                if (result.message) {
                    alert(result.message);
                    return;
                }
                console.log(result);
                $("input[name='p_description']").val(result.p_description);
                return;
            },

            error : function(result) {
                window.location.href="err.html";
            }
        });
    });
    $("#confirm").click(function ()
    {
        confirmPrescription();
    });
    function confirmPrescription()
    {
        $.ajax({
            url : "/doctor/confirmPrescription.do",
            type : "POST",
            data :
                {
                    c_id: "<%=request.getParameter("c_id")%>",
                    m_list: m_idlist,
                },
            dataType : "json",
            //处理后端返回的数据
            success : function(result) {
                if(result.message != "successed")
                {
                    alert(result.message);
                    window.location.href="${pageContext.request.contextPath}/unprescribedCasePage.jsp";

                }else
                {
                    window.location.href="${pageContext.request.contextPath}/unprescribedCasePage.jsp";
                }

            },
            //处理失败返回的数据
            error : function(result)
            {
                window.location.href="err.html";
            }
        });
    }
    function searchMedicine()
    {
        // page=page||1;
        // size=size||5;	//设置默认第一页，每页5条记录
        $.ajax({
            url : "/doctor/searchMedicineByName.do",
            type : "POST",
            data :
                {
                    m_name: $("input[name='m_name']").val(),
                },
            dataType : "json",
            //处理后端返回的数据
            success : function(result) {
                console.log(result);
                //处理doctorList
                $("#medicineTable").html("");
                $.each(result,function (index, item)
                {
                    $("#medicineTable").append("<tr>" +
                        "<td>" + item.m_id+"</td>\n" +
                        "<td>" + item.m_name +"</td>" +
                        "<td>" + item.m_num +"</td>"+
                        "<td>" + item.m_class +"</td>" +
                        "<td>" + item.m_price +"</td>" +
                        "<td>" +
                        "<button class=\"layui-btn layui-btn-small\""+"onclick=addMedicine(\""+item.m_name+"\",\""+item.m_id+"\")>添加</button>" +
                        "</td>"+
                        "</tr>"
                    )
                });
            },
            //处理失败返回的数据
            error : function(result)
            {
                window.location.href="err.html";
            }
        });
    }
    var m_idlist = "";
    function addMedicine(m_name,m_id)
    {
        $("input[name='m_namelist']").val($("input[name='m_namelist']").val()+"  "+m_name);
        m_idlist = m_idlist+"%"+m_id;
    }
</script>
</html>