<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/4
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>修改医生信息</title>
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
                    管理医生的个人信息
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改医生信息</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/DoctorMange/update.do"
          method="post">
        <!--待修改修改
        -->

        <input type="hidden" name="id" value="${DoctorInfo.d_id}"/>
        医生工号：<input type="text" name="d_id" value="${Doctor.d_id}"/>
        医生的ID: <input type="text" name="t_id" value="${Doctor.t_id}"/><br><br>
        医生职称：<input type="text" name="d_title" value="${Doctor.d_title}"/>
        医生性别：<input type="text" name="d_gender" value="${Doctor.d_gender}"/><br><br>
        出生日期：<input type="date" name="d_birthday" value="${Doctor.d_birthday}"/>
        科室编号：<input type="text" name="dp_id" value="${Doctor.dp_id}"/><br><br>
        登录密码：<input type="text" name="d_password" value="${Doctor.d_password}"/>
        医生姓名：<input type="text" name="d_name" value="${Doctor.d_name}"/><br><br>
        医生备注：<input type="text" name="d_description" value="${Doctor.d_description}"/>
        <br>

        <input type="submit"  class="btn btn-primary" value="提交" />
    </form>
</div>
</body>
</html>
