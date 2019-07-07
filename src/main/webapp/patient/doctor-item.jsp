<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/3
  Time: 22:50
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
    <link rel="stylesheet" href="../css/patient/doctor-item.css">
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
                <li><a href="${pageContext.request.contextPath}/patient/toDepartmentNav.do">科室导航</a></li>
                <li><a href="#" class="active">医生简介</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toAppointment.do">预约挂号</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toPersonCenter.do">个人中心</a></li>
                <li><a href="#">其他栏目</a></li>
            </ul>
        </nav>
    </div>
</header>
<section class="user-body">
    <div class="wrap">
        <div class="wrap1">
            <span class="title">医生介绍</span>
            <div class="line"></div>
            <div class="pic"><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562002241757&di=b953136c35d5304a8edbdde3246b7f0a&imgtype=0&src=http%3A%2F%2Ftvax1.sinaimg.cn%2Fcrop.0.0.900.900.1024%2F3ecb6b96ly8ff27ji0a19g20p00p0js2.gif" alt=""></div>
            <div class="info">
                <%--<h2 id="name">姓名</h2>--%>
                <%--<div>--%>
                    <%--<span>所属科室：</span>--%>
                    <%--<span id="department-name">国际医疗(心内科)</span>--%>
                <%--</div>--%>
                <%--<div>--%>
                    <%--<span>职称：</span>--%>
                    <%--<span id="zhicheng">主任医师，教授，博士研究生导师，心内科常务副主任</span>--%>
                <%--</div>--%>
                <%--<div>--%>
                    <%--<span>医生信息：</span>--%>
                    <%--<p id="describe">主任医师，教授，博士研究生导师，心内科常务副主任。 长期从事心血管内科的临床、科研、教学和医疗保健工作。在应用超声心动图诊断各种心血管疾病方面有20余年的临床经验。</p>--%>
                <%--</div>--%>
                <h2 id="name">${doctor.d_name}</h2>
                <div>
                    <span>所属科室：</span>
                    <span id="department-name">${department.dp_name}</span>
                </div>
                <div>
                    <span>职称：</span>
                    <span id="zhicheng">${doctor.d_title}</span>
                </div>
                <div>
                    <span>医生信息：</span>
                    <p id="describe">${doctor.d_description}</p>
                </div>
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