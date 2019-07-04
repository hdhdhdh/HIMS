<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/3
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 科室导航页面 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/patient/user-header.css">
    <link rel="stylesheet" href="../css/patient/user-footer.css">
    <link rel="stylesheet" href="../css/patient/person-center.css">
    <link rel="stylesheet" href="../css/patient/mytable.css">
    <title>Title</title>

</head>
<body>
<header class="user-header">
    <div class="wrap">
        <div class="logo"></div>
        <h1 class="title">PHARMACY</h1>
        <nav class="user-nav">
            <ul>
                <li><a href="user_home.html">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toDepartmentNav.do">科室导航</a></li>
                <li><a href="#">医生简介</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toAppointment.do">预约挂号</a></li>
                <li><a href="#"  class="active">个人中心</a></li>
                <li><a href="#">其他栏目</a></li>
            </ul>
        </nav>
    </div>
</header>
<section class="user-body">
    <div class="wrap">
        <div id="wrap1" class="wrap-x">
            <span class="title" >我的预约</span><hr>
            <div class="table-wrap">
                <table class="mytable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>姓名</th>
                        <th>预约科室</th>
                        <th>预约时间</th>
                        <th>编号</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
        <div id="wrap2" class="wrap-x">
            <span class="title">待缴费用</span><hr>
            <div class="table-wrap">
                <table class="mytable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>姓名</th>
                        <th>预约科室</th>
                        <th>预约时间</th>
                        <th>编号</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="wrap3" class="wrap-x">
            <span class="title">个人信息</span><hr>
            <div class="table-wrap">
                <table class="mytable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>姓名</th>
                        <th>预约科室</th>
                        <th>预约时间</th>
                        <th>编号</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="wrap4" class="wrap-x">
            <span class="title">历史病例</span><hr>
            <div class="table-wrap">
                <table class="mytable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>姓名</th>
                        <th>预约科室</th>
                        <th>预约时间</th>
                        <th>编号</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>me</td>
                        <td>华东师范</td>
                        <td>123456</td>
                        <td>12315</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<footer class="user-footer">
    <div class="wrap">
    </div>
</footer>
</body>
</html>