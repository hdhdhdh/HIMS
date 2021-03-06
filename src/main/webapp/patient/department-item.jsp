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
    <title>医院挂号系统</title>

</head>
<body>
<header class="user-header">
    <div class="wrap">
        <div class="logo"></div>
        <a href="../index.jsp" class="title" style="margin: 0;font-family:'Microsoft Yahei'; text-decoration: none;color: #ffffff">PHARMACY</a>
        <nav class="user-nav">
            <ul>
                <li><a href="user_home.jsp">首页</a></li>
                <li><a href="#" class="active">科室导航</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toDoctorNav.do">医生简介</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toAppointment.do">预约挂号</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toPersonCenter.do">个人中心</a></li>
                <li><a href="#">其他栏目</a></li>
            </ul>
        </nav>
    </div>
</header>
<section class="user-body">
    <div class="wrap">
        <div class="wrap2">
            <%--<h2>科室介绍</h2>--%>
            <%--<hr>--%>
            <%--<p>我科采用心身医学的理念，心理治疗与药物治疗结合。为受心理或情绪困扰的来访者、为因心理疾病产生情绪问题或身体的功能性症状难以缓解而苦恼的患者、为慢性或严重疾病在心理上承受折磨的患者及家属提供帮助。</p>--%>
            <h2>${deparment.dp_name}</h2>
                <hr>
            <p>${deparment.dp_description}</p>
        </div>
    </div>
</section>
<footer class="user-footer">
    <div class="wrap">
    </div>
</footer>
</body>
</html>