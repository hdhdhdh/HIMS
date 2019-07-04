<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/3
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<!-- 科室导航页面 -->
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
    <link rel="stylesheet" href="../css/patient/department-nav.css">
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
                <li><a href="#" class="active">科室导航</a></li>
                <li><a href="doctor-nav.html">医生简介</a></li>
                <li><a href="appointment.html">预约挂号</a></li>
                <li><a href="#">个人中心</a></li>
                <li><a href="#">其他栏目</a></li>
            </ul>
        </nav>
    </div>
</header>
<section class="user-body">
    <div class="wrap">
        <div class="wrap1">
            <span class="title">科室一览</span>
            <div class="line"></div>
            <ul class="departments">
                <li>
                    <a href="department-item.html"><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></a>
                </li>
                <li><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></li>
                <li><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></li>
                <li><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></li>
                <li><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></li>
                <li><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></li>
                <li><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></li>
                <li><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></li>
            </ul>
        </div>
    </div>
</section>
<footer class="user-footer">
    <div class="wrap">
    </div>
</footer>
</body>
</html>