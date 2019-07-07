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
        <div class="wrap1">
            <span class="title">科室一览</span>
            <div class="line"></div>
            <ul class="departments">
                <%--<li>--%>
                    <%--<a href="department-item.html"><span class="li-name">肿瘤科</span><span class="tag">&raquo;</span></a>--%>
                <%--</li>--%>
                <c:forEach items="${departmentList}" var="department">
                    <li>
                        <a href="${pageContext.request.contextPath}/patient/departmentItem.do?dp_id=${department.dp_id}"><span class="li-name">
                                ${department.dp_name}</span><span class="tag">&raquo;</span>
                        </a>
                    </li>
                </c:forEach>
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