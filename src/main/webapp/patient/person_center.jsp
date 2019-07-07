<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.whut.bean.Patient" %>
<%@ page import="com.whut.bean.Appointment" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/patient/user-header.css">
    <link rel="stylesheet" href="../css/patient/user-footer.css">
    <link rel="stylesheet" href="../css/patient/person-center.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <title>医院挂号系统</title>
    <style>
        body {
            background: #eeeeee;
        }
        /*  个人信息的样式 */
        #person-info-box {
            position: absolute;
            top: 100px;
            left: 100px;
            width: 500px;
            height: 300px;
            background: #00ccff;
            box-shadow: 0px 0px 5px rgba(0,0,0,.2);
            border-radius: 5px;
            padding: 50px;
            box-sizing: border-box;
        }
        #person-info-box  p {
            display: block;
            height: 40px;
            line-height: 40px;
            font-size: 18px;
            font-weight: 600;
        }
        #person-info-box .info-img {
            position: absolute;
            right: 50px;
            width: 80px;
            height: 80px;
            background: url("../images/icon_user.png");
            background-size: 100%;
        }
        #person-info-box .info-text {
            position: absolute;
            top:auto;
            width: 300px;
            height: 200px;
        }


        /* 我的预约样式 */
        #myappointment-box {
            position: absolute;
            top: 100px;
            right: 100px;
            width: 500px;
            height: 300px;
            background: pink;
            border-radius: 5px;
            padding: 50px;
            box-sizing: border-box;
        }
        #myappointment-box .line {
            display: block;
            height: 1px;
            width: 100%;
            background: #ffffff;
            margin: 5px 0;
        }
        #myappointment-box p {
            display: block;
            height: 40px;
            line-height: 40px;
            font-size: 18px;
            font-weight: 600;
        }
        /* 代缴费用*/
        #fee-box {
            position: absolute;
            width: 100%;
            height: 500px;
            background: #dcdcdc;
            padding: 50px 100px 100px 100px;
            box-sizing: border-box;
            border-radius: 10px;
        }
        #fee-table-box {
            width: 100%;
            height: 300px;
            /*background: #2f95b7;*/
            overflow-y: auto;
        }

        /*历史病例*/
        #history-case-box {
            margin-top: 100px;
            width: 100%;
            height: 500px;
            background: #dcdcdc;
            padding: 50px 100px 100px 100px;
            box-sizing: border-box;
            border-radius: 10px;

        }
        #case-table-box {
            width: 100%;
            height: 300px;
            /*background: #2f95b7;*/
            overflow-y: auto;
            overflow-x: auto;
        }

        table {
            font-size: 16px;
        }
        table td {
            min-width: 100px;
        }

    </style>
</head>
<body>
<header class="user-header">
    <div class="wrap">
        <div class="logo"></div>
        <a href="../index.jsp" class="title" style="margin: 0;font-family:'Microsoft Yahei'; text-decoration: none;color: #ffffff">PHARMACY</a>
        <nav class="user-nav">
            <ul>
                <li><a href="user_home.jsp">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toDepartmentNav.do">科室导航</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toDoctorNav.do">医生简介</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toAppointment.do">预约挂号</a></li>
                <li><a href="#"  class="active">个人中心</a></li>
                <li><a href="#">其他栏目</a></li>

            </ul>
        </nav>
    </div>
</header>
<section class="user-body">
    <div class="wrap">
        <div style="width: 100%;height: 500px;position: relative;">
            <div id="person-info-box">
                <!-- 个人信息 -->
                <div class="info-img">

                </div>
                <div class="info-text">
                    <p>姓名：<span><%=((Patient)(request.getSession().getAttribute("currentPatient"))).getP_name()%></span></p>
                    <p>性别：<span><%=((Patient)(request.getSession().getAttribute("currentPatient"))).getP_gender()==1? '男':'女'%></span></p>
                    <p>出生日期：<span><%=new SimpleDateFormat("yyyy-MM-dd").format(((Patient)(request.getSession().getAttribute("currentPatient"))).getP_birthday())%></span></p>
                    <p>身份证号：<span><%=((Patient)(request.getSession().getAttribute("currentPatient"))).getP_id()%></span></p>
                    <p>密码：****** <a style="margin-left: 20px;text-decoration: none; cursor: pointer;display: inline-block;width: 80px;">修改密码</a></p>
                </div>
            </div>
            <div id="myappointment-box">
                <h3>我的预约:</h3>
                <span class="line"></span>
                <p>预约科室：<span>${department.dp_name}</span></p>
                <p>预约时间：<span><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(((Appointment)request.getAttribute("appointment")).getA_date())%></span></p>
                <p>编号：<span>${appointment.a_id}</span></p>
            </div>
        </div>

        <%--<c:forEach items="${departmentList}" var="department">--%>
            <%--<div class="d-item">--%>
                <%--<label for="${department.dp_id}">--%>
                    <%--<input type="radio" name="deportment-name" id="${department.dp_id}" value="${department.dp_id}">${department.dp_name}--%>
                <%--</label>--%>
                <%--<span class="btn">${department.dp_name}</span>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>
        <!-- 缴费 -->
        <div style="width: 100%;height: 500px;position: relative;">
            <div id="fee-box" >
                <h2>代缴费用</h2>
                <span style="display: block;height: 2px;width: 100%;background: #ffffff;margin: 5px 0;"></span>
                <div id="fee-table-box">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>产生时间</th>
                            <th>费用</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${feesCaseList}" var="fee">

                            <tr>
                                <td><%=((Patient)(request.getSession().getAttribute("currentPatient"))).getP_name()%></td>
                                <td>${fee.c_date}</td>
                                <td>${fee.c_fee}</td>
                                <td><a href="javascript:;">缴费</a></td>
                            </tr>
                        </c:forEach>
                            <%--<tr>--%>
                                <%--<td>123</td>--%>
                                <%--<td>456</td>--%>
                                <%--<td>789</td>--%>
                                <%--<td><a href="javascript:;">缴费</a></td>--%>
                            <%--</tr>--%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!--历史病例  -->
        <div style="width: 100%;height: 500px;position: relative; ">
            <div id="history-case-box">
                <h2>历史病例</h2>
                <span style="display: block;height: 2px;width: 100%;background: #ffffff;margin: 5px 0;"></span>
                <div id="case-table-box">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>时间</th>
                            <th>病状描述</th>
                            <th>医生</th>
                            <th>费用</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${historyCaseList}" var="historyCase">
                            <tr>
                                <td><%=((Patient)(request.getSession().getAttribute("currentPatient"))).getP_name()%></td>
                                <td>${historyCase.c_date}</td>
                                <td>${historyCase.c_description}</td>
                                <td>${historyCase.d_id}</td>
                                <td>${historyCase.c_fee}</td>
                            </tr>
                        </c:forEach>
                        <%--<tr>--%>
                            <%--<td>123</td>--%>
                            <%--<td>456</td>--%>
                            <%--<td>789</td>--%>
                            <%--<td>123</td>--%>
                            <%--<td>456</td>--%>
                        <%--</tr>--%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <!--</div>-->
        <!--<div id="wrap2" class="wrap-x">-->
            <!--<span class="title">待缴费用</span><hr>-->
            <!--<div class="table-wrap">-->
                <!--<table class="mytable">-->
                    <!--<thead>-->
                    <!--<tr>-->
                        <!--<th>#</th>-->
                        <!--<th>姓名</th>-->
                        <!--<th>时间</th>-->
                        <!--<th>费用</th>-->
                    <!--</tr>-->
                    <!--</thead>-->
                    <!--<tbody>-->
                    <!--<tr>-->
                        <!--<td>1</td>-->
                        <!--<td>me</td>-->
                        <!--<td>华东师范</td>-->
                        <!--<td>123456</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td>1</td>-->
                        <!--<td>me</td>-->
                        <!--<td>华东师范</td>-->
                        <!--<td>123456</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td>1</td>-->
                        <!--<td>me</td>-->
                        <!--<td>华东师范</td>-->
                        <!--<td>123456</td>-->
                    <!--</tr>-->
                    <!--</tbody>-->
                <!--</table>-->
            <!--</div>-->
        <!--</div>-->
        <!--<div id="wrap4" class="wrap-x">-->
            <!--<span class="title">历史病例</span><hr>-->
            <!--<div class="table-wrap">-->
                <!--<table class="mytable">-->
                    <!--<thead>-->
                    <!--<tr>-->
                        <!--<th>#</th>-->
                        <!--<th>姓名</th>-->
                        <!--<th>诊断科目</th>-->
                        <!--<th>时间</th>-->
                        <!--<th>病状描述</th>-->
                        <!--<th>医生</th>-->
                        <!--<th>药物清单</th>-->
                        <!--<th>费用</th>-->
                    <!--</tr>-->
                    <!--</thead>-->
                    <!--<tbody>-->
                    <!--<tr>-->
                        <!--<td>1</td>-->
                        <!--<td>me</td>-->
                        <!--<td>华东师范</td>-->
                        <!--<td>123456</td>-->
                        <!--<td>12315</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td>1</td>-->
                        <!--<td>me</td>-->
                        <!--<td>华东师范</td>-->
                        <!--<td>123456</td>-->
                        <!--<td>12315</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td>1</td>-->
                        <!--<td>me</td>-->
                        <!--<td>华东师范</td>-->
                        <!--<td>123456</td>-->
                        <!--<td>12315</td>-->
                    <!--</tr>-->
                    <!--</tbody>-->
                <!--</table>-->
            <!--</div>-->
        <!--</div>-->
    </div>
</section>
<footer class="user-footer">
    <div class="wrap">
    </div>
</footer>
</body>
</html>