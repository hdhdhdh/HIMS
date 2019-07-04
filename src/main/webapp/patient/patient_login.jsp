<%--
  Created by IntelliJ IDEA.
  User: 15927
  Date: 2019/7/4
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/patient/login.do">
    身份证号：<input type="text" name="p_id">s
    密码：<input type="password" name="p_password">
    <button type="submit">登录</button>
    <p>message:${err}</p>
</form>
</body>
</html>
