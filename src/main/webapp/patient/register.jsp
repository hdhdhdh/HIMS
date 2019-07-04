<%--
  Created by IntelliJ IDEA.
  User: 11727
  Date: 2019/7/2
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post" action="/patient/register.do">
    <div>
        身份证号
        <input type="text" name="p_id">
    </div>
    <div>
        姓名
        <input type="text" name="p_name">
    </div>
    <div>
        性别
        <input type="text" name="p_gender">
    </div>
    <div>
        出生日期
        <input type="date" name="p_birthday">
    </div>
    <div>
        密码
        <input type="text" name="p_password">
    </div>
    <div>
        <input type="submit" value="注册">
    </div>
</form>
</body>
</html>
