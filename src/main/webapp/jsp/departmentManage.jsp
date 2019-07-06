<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/5
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/Linecons.css">
    <link rel="stylesheet" href="../css/left-menu.css">
    <link rel="stylesheet" href="../css/doc-common.css">
    <link rel="stylesheet" href="../css/hadAppointment.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <style>
        body {
            background: #cccccc;
        }
    </style>
    <title>Title</title>
</head>
<body>
<nab class="menu-wrap">
    <div class="menu">
        <ul>
            <!-- 在这里修改链接 跳转  -->
            <li><a href="javascript:;"> <i class="icon icon-calendar"></i><span>首页</span></a></li>
            <li><a href="javascript:;"><i class="icon icon-clock"></i><span>预约管理</span></a></li>
            <li class="darkerlishadow"><a href="preparAppointment.html"><i class="icon icon-clock"></i><span>待处理</span></a></li>
            <li class="darkerlishadowdown activeli"><a href="javascript:;"><i class="icon icon-clock"></i><span>已处理</span></a></li>
            <li><a href="javascript:;"> <i class="icon icon-calendar"></i><span>病例查询</span></a></li>
            <li><a href="javascript:;"><i class="icon icon-clock"></i><span>药品管理</span></a></li>
            <li class="darkerlishadow"><a href="drugList.html"><i class="icon icon-clock"></i><span>分类列表</span></a></li>
            <li class="darkerlishadowdown"><a href="prescription.html"><i class="icon icon-clock"></i><span>处方开药</span></a></li>
            <li class="darkerlishadowdown "><a href="javascript:;"><i class="icon icon-banknote"></i><span>医生管理</span></a></li>
            <li class="darkerlishadowdown activeli"><a  href="${pageContext.request.contextPath}/todepartmentManage.do"><i class="icon icon-banknote"></i><span>科室管理</span></a></li>
            <li><a href="javascript:;"><i class="icon icon-banknote"></i><span>个人中心</span></a></li>
            <li><a href="javascript:;"><i></i><span>退出</span></a></li>
        </ul>
    </div>
</nab>
<div class="card">
    <p class="card-title">科室管理
        <!--
        <input type="text" class="form-control" placeholder="Search">
        <button type="submit" class="btn btn-default" style="float:right">搜索</button>
        -->

        <a type="button"  class="btn btn-primary"  href="${pageContext.request.contextPath}/DoctorMange/toAddDoctor.do">添加科室</a>
    </p>


    <table class="table table-striped table-bordered">

        <thead>
        <tr>
            <!--   <th>#</th>  -->
            <th>科室编号</th>
            <th>科室名称</th>
            <th>科室简介</th>
            <th>科室信息变更</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach items="${DepartmentInfo}" var="Department">
            <tr>
                <td>${Department.dp_id}</td>
                <td>${Department.dp_name}</td>
                <td>${Department.dp_description}</td>


                <td>
                    <!--注意类型不一致的问题-->
                    <a href="${pageContext.request.contextPath}/DoctorMange/toupdateDoctor.do?id=${Doctor.d_id}">更改</a> |
                    <a href="${pageContext.request.contextPath}/DoctorMange/deleteDoctor.do?id=${Doctor.d_id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>


        <nav aria-label="Page navigation" >
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </table>
</div>
<script src="../js/jquery-2.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
