<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/6
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <script src="js/jquery-2.2.1.min.js"></script>
    <style>
        body { background: url("images/home_bg.jpg");}
        .container{
            width: 100%;
            max-width: 460px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%) scale(1,1);
            opacity: 1;
            background: #ffffff;
            -webkit-transition: all .3s ease;
            transition: all .5s ease;
            transform-style: preserve-3d;
        }
        .box {
            position: relative;
            padding: 60px 50px 40px 50px;
        }
        /*zrgj0574*/
        .container-hide {
            opacity: 0;
            -webkit-transform:translate(-50%, -50%) scale(0.1,0.1);

        }
        .container-hide .lab { display: none;}
        .title {
            font-size: 25px;
            line-height: 46px;
            font-weight: 700;
            letter-spacing: 2px;
        }
        .input {
            height: 50px;
            margin-top: 30px;
            position:relative;
        }
        .input:before{
            content:"";
            display: block;
            position: absolute;
            bottom: 0;
            right: 0;
            height: 1px;
            width: 100%;
            background: rgba(0, 0, 0, 0.1);
        }
        .input label {
            position: absolute;
            display: block;
            line-height: 18px;
            font-size: 18px;
            font-weight: 100;
            top: 0;
            left: 0;
        }
        .input input {
            margin-top: 10px;
            height: 60px;
            width: 100%;
            font-weight: 300;
            font-size: 16px;
            line-height: 24px;
            border-style: none;
        }

        .input .radio-group {
            float: left;
            margin-left: 70px;
            overflow: hidden;
            height: 60px;
            width: 50px;
        }
        .input .radio-group input {
            margin-top: 0;
            height: 20px;
            width: 20px;
        }

        .login {
            position: relative;
            height: 70px;
            width: 60%;
            left: 20%;
            background: red;
            margin: 30px 0;
        }
        .login button{
            width: 100%;
            height: 100%;
            font-size: 18px;
            border: 3px solid #dddddd;
            color: #dddddd;
            background: #ffffff;
        }

        .lab {
            width: 70px;
            height: 40px;
            line-height: 32px;
            text-align: center;
            position: absolute;
            right: 0;
            top: 10px;
            margin-right: -60px;
            border: 3px solid #2e6da4;
            background: #2e6da4;
            box-sizing: border-box;
            color: #ffffff;
            font-size: 18px;
            cursor:pointer
        }
        .pass-forgot {
            width: 100%;
            float: left;
            text-align: center;
            color: rgba(0, 0, 0, 0.4);
            font-size: 18px;
        }

        .blue {
            background: blue;
        }

        /*#denglu { display: none; }*/
        /*#zhuce {display: none; }*/
    </style>
    <title>Title</title>
</head>
<body>
<div class="container" id="denglu">
    <div class="box" >
        <div class="lab" id="lab-zhuce">注册</div>
        <div class="title">登录</div>
        <div class="input">
            <label for="id">账户</label>
            <input type="text" name="id">
        </div>
        <div class="input">
            <label for="password">密码</label>
            <input type="password" name="password">
        </div>
        <div class="button login" id="login">
            <button>
                <span>登录</span>
                <i class="fa fa-check"></i>
            </button>
        </div>
        <a href="javascript:;" class="pass-forgot">忘记密码？</a>
    </div>
</div>
<div class="container container-hide" id="zhuce">
    <div class="box">
        <div class="lab" id="lab-denglu">登录</div>
        <div class="title">注册</div>
        <div class="input">
            <label for="idcard">身份证号</label>
            <input type="text" name="idcard">
        </div>
        <div class="input">
            <label for="username">姓名</label>
            <input type="text" name="username">
        </div>

        <div class="input">
            <label for="gender">性别</label>
            <div class="radio-group">
                <input type="radio" name="gender" value="1" checked>
                <span>男</span>
            </div>
            <div class="radio-group">
                <input type="radio" name="gender" value="2"><span>女</span>
            </div>
        </div>

        <div class="input">
            <label for="bitrhady">出生年月</label>
            <form action="/example/html5/demo_form.asp" method="get">
                <input type="date" name="user_date" />
            </form>
        </div>


        <div class="input">
            <label for="password">密码</label>
            <input type="password" name="password">
        </div>
        <div class="button login">
            <button>
                <span>注册</span>
                <i class="fa fa-check"></i>
            </button>
        </div>
    </div>
</div>
<script>

    $(document).ready(function () {
        $('#lab-zhuce').click(function () {
            $('#denglu').addClass("container-hide");
            $('#zhuce').removeClass("container-hide");
        });
        $('#lab-denglu').click(function () {
            $('#zhuce').addClass("container-hide");
            $('#denglu').removeClass("container-hide")
        })
    })
</script>
</body>
</html>>
