<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/Linecons.css">
    <title>医院门诊系统</title>
    <style>
        * { margin: 0;padding: 0;}
        body { background: #dddddd; background: url("images/home_bg.jpg") no-repeat; min-height: 1000px; }
        a,li { text-decoration: none; }
        li { list-style: none; }
    </style>
</head>
<body>
<header class="home-header">
    <img src="images/logo.png" style="margin-left: 100px;" alt="">
    <span class="title"><a href="#" style="color: #ffffff;">PHARMACY</a></span>
    <a class="btn-appointment" href="patient/patient_login.jsp">
        <i class="icon icon-clock"></i>
        <span>预约挂号</span>
    </a>
</header>
<section class="home-body">
    <div class="wrap wrap1">
        <p class="title">最爱学习小组</p>
        <p class="content" id="text1">敬佑生命 救死扶伤 <br>
        甘于奉献 大爱无疆<br>
            待病人如亲人<br>
            提高病人满意度<br>
        </p>
        <p class="content" id="text2">xx医院是集医疗、教学、科研于一体的大型三级甲等综合医院
        是国家卫生健康委指定的全国疑难杂症诊治指导中心</p>
        <div class="link-box link-box1">
            <img src="images/icon_user.png" alt="">
            <p class="link-title">用户入口</p>
            <a class="link-btn" href="patient/user_home.jsp">点击进入</a>
        </div>
        <div class="link-box link-box2">
            <img src="images/icon_worker.png" alt="">
            <p class="link-title">员工入口</p>
            <a class="link-btn" href="workerLogin.jsp">点击进入</a>
        </div>
    </div>
    <!--<div class="wrap wrap2">-->
    <!--<div class="slideshow" id="slideshow">-->
    <!--<span class="arrow pre"><i class="icon icon-play2"></i></span>-->
    <!--<span class="arrow next"><i class="icon icon-play2"></i></span>-->
    <!--<ul class="pics">-->
    <!--<li class="active"><img src="images/pic1.jpg" alt=""></li>-->
    <!--<li><img src="images/pic2.jpg" alt=""></li>-->
    <!--<li><img src="images/pic3.jpg" alt=""></li>-->
    <!--<li><img src="images/pic4.jpg" alt=""></li>-->
    <!--</ul>-->
    <!--<ul class="points">-->
    <!--<li class="active"></li>-->
    <!--<li></li>-->
    <!--<li></li>-->
    <!--<li></li>-->
    <!--</ul>-->
    <!--</div>-->
    <!--</div>-->
    <script src="js/jquery-2.2.1.min.js"></script>
    <script src="js/slideshow.js"></script>
</section>
</body>
</html>