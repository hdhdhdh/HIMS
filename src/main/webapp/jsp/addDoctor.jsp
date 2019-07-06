<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/2
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>新增用户</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    医生管理--添加医生
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加医生信息</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/DoctorMange/AddDoctor.do"
          method="post">

        医生工号&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="d_id">
        医生编号：<input type="text" name="t_id"><br><br><br>
        医生职称：<input type="text" name="d_title">
        医生性别：<input type="number" name="d_gender"><br><br><br>
        出生年月： <input type="date" name="d_birthday">
            部门编号：<input type="text" name="dp_id"><br><br><br>
        医生密码：<input type="text" name="dp_password">
        医生姓名：<input type="text" name="dp_name"><br><br><br>
        医生简介：<input type="text" name="d_description"><br><br><br>

        <input type="submit" class="btn btn-primary" value="添加" id="add-btn">
    </form>
    <script src="../js/jquery-2.2.1.min.js"></script>
    <script>
        $("#add-btn").click(function () {
            var username  = $("input[name='username']").val();
            alert(username);
        })
    </script>
</div>
</body>
</html>
