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
    <link rel="stylesheet" href="../css/patient/doctor-nav.css">
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
                <li><a href="department-nav.html">科室导航</a></li>
                <li><a href="#" class="active">医生简介</a></li>
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
            <span class="title">医生一览</span>
            <div class="line"></div>
            <ul class="d-wrap">
                <li class="d-wrap-item">
                    <span class="department-name">精神科</span>
                    <div class="line"></div>
                    <ul class="doctors">
                        <li><a href="doctor-item.html">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                    </ul>
                </li>
                <li class="d-wrap-item">
                    <span class="department-name">精神科</span>
                    <div class="line"></div>
                    <ul class="doctors">
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                    </ul>
                </li>
                <li class="d-wrap-item">
                    <span class="department-name">精神科</span>
                    <div class="line"></div>
                    <ul class="doctors">
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                    </ul>
                </li>
                <li class="d-wrap-item">
                    <span class="department-name">精神科</span>
                    <div class="line"></div>
                    <ul class="doctors">
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                    </ul>
                </li>
                <li class="d-wrap-item">
                    <span class="department-name">精神科</span>
                    <div class="line"></div>
                    <ul class="doctors">
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                        <li><a href="">张三</a></li>
                    </ul>
                </li>
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