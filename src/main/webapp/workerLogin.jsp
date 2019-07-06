<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/6
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/workerLogin.css" />
    <style>
        .type {
            position: absolute;
            top: 17.8rem;
            right:4rem;
            display: flex;
            width: 373px;
            height: 55px;
        }
        .type div {
            width: 50%;
            height: 55px;
            float: left;
            line-height: 55px;
        }
        .type div input {
            width: 20px;
            height: 20px;
            vertical-align:middle;
            margin-top:-2px;
            margin-bottom:1px;
        }
    </style>
</head>

<body>

<img class="bgone" src="images/w1.jpg" />
<img class="pic" src="images/a.png" />

<div class="table">
<form id="login-form" action="" method="post">
    <div class="wel">医院挂号系统后台登陆</div>
    <div class="wel1">YI YUAN GUA HAO XI TONG HUO TAI DENG LU</div>
    <div class="user">
        <div id="yonghu" style=""><img src="images/yhm.png" /></div>
        <input type="text" name="id" placeholder="职工号" />
    </div>
    <div class="password">
        <div id="yonghu"><img src="images/mm.png" /></div>
        <input type="password" name="password" placeholder="●●●●●●"/>
    </div>
    <div class="type">
        <div>
            <input type="radio" name="type" style="" value="1" checked>普通职工
        </div>
        <div>
            <input type="radio" name="type" style="" value="2"> 管理员
        </div>
    </div>
    <input class="btn" type="button" name="登录" value="登录" id="login-up"/>
</form>
</div>
<script src="js/validateIdCard.js"></script>
<script src="js/jquery-2.2.1.min.js"></script>
<script>

    //登录提交
    $("#login-up").click(function () {
        var login_id = $("input[name='id']" ).val();                        //获取到职工号
        var loing_password = $("input[name='password']" ).val();            //获取到密码
        var type =$("input[name='type']:checked" ).val();

        if(login_id==null || login_id==""){
            alert("账户不能为空!")
        }else if(loing_password==null || loing_password==""){
            alert("密码不能为空");
        }else if(type==1){      // type=1 普通职工登录

            <%--$("#login-form").attr("action","${pageContext.request.contextPath}/doctor/doctorLogin.do");--%>
            <%--$("#login-form").submit();--%>
            // alert(login_id +"   " + loing_password + "    " + type);
            // alert("普通职工登录");
            $.ajax({
                url : "${pageContext.request.contextPath}/doctor/doctorAjaxLogin.do",
                type : "POST",
                data : {
                    d_id:   login_id,
                    d_password:  loing_password
                },
                dataType : "json",
                //处理后端返回的数据
                success : function(result) {
                    if (result != null && result != "") {
                        if(result.message=="success") { //登录成功  跳转到主页面
                            if( result.type == "doctor"){       //医生跳转到医生的界面
                                window.location.href="doctor_index.jsp";
                            }else if( result.type == "pharmacist"){ //药剂师跳转到药剂师的界面
                                window.location.href="pharmacist_index.jsp";
                            }
                        }else {
                            alert("用户名或者密码错误");
                        }
                    }
                    // alert("接受到的数据是：" + result.message+"  " + result.type);
                },
                //处理失败返回的数据
                error : function(result) {
                    window.location.href="err.html";
                }
            });
        }else if(type==2){
            // alert("管理员登录");
            // $("#login-form").attr("action","#");
            <%--$("#login-form").attr("action","${pageContext.request.contextPath}/doctor/doctorLogin.do");--%>
        }
    });
</script>

</body>
</html>