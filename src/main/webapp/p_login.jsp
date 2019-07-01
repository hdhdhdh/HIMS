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
<form method="post" action="">
<table>
    <tr>
        <td>
            身份证号
        </td>
        <td>
        <input type="text" name="p_id">
        </td>
    </tr>
    <tr>
        <td>
            密码
        </td>
        <td>
            <input type="password" name="p_password">
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" value="登录">
        </td>
        <td>
            <input type="button" value="注册">
        </td>
    </tr>
</table>
</form>
</body>
</html>
