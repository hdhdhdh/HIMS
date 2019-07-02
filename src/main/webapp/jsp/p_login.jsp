<%--
  Created by IntelliJ IDEA.
  User: 11727
  Date: 2019/7/1
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>病人登录</title>
</head>
<body>
<form method="post" action="/patient/login.do">
    <div>
        <input type="text" name="p_id">
        身份证号
    </div>
    <div>
    <input type="password" name="p_password">
            密码
    </div>
    <div>
        <button type="submit">登录</button>
    </div>
<div>
    <input type="button" value="注册" onclick="register.jsp">
</div>
</form>
</body>
</html>
