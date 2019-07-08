<%--
  Created by IntelliJ IDEA.
  User: 15927
  Date: 2019/7/4
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/reset.css">
    <script src="../js/jquery-2.2.1.min.js"></script>
    <style>
        body { background: url("../images/home_bg.jpg");}
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
            /*background: red;*/
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
        button:hover{
            /*悬停样式*/
            background: rgba(0,0,0,.2);
            color: #ffffff;
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

        .blue {
            background: blue;
        }

        /*#denglu { display: none; }*/
        /*#zhuce {display: none; }*/
    </style>
    <title>医院挂号系统</title>
</head>
<body>
<div class="container" id="denglu">
    <div class="box" >
        <div class="lab" id="lab-zhuce"><a href="#zhuce"  style="display:block;width: 100%; height: 100%; color:#ffffff;">注册</a></div>
        <div class="title">登录</div>
        <div class="input">
            <label for="id">账户</label>
            <input type="text" name="id">
        </div>
        <div class="input">
            <label for="password">密码</label>
            <input type="password" name="password">
        </div>
        <div class="button login">
            <button>
                <span style="display: block;width: 100%;height: 100%;line-height: 70px;" id="login-up">登录</span>
                <i class="fa fa-check"></i>
            </button>
        </div>
        <p id="denglu-message" style="color: red;text-align: center;"></p>
        <!--<a href="javascript:;" class="pass-forgot">忘记密码？</a>-->
    </div>
</div>
<div class="container container-hide" id="zhuce">
    <div class="box">
        <div class="lab" id="lab-denglu"><a href="#denglu" style="display:block;width: 100%; height: 100%; color:#ffffff;">登录</a></div>
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
            <label for="bitrhady">出生日期</label>
                <input type="date" name="user_date" />
        </div>


        <div class="input">
            <label for="password">密码</label>
            <input type="password" name="password">
        </div>
        <div class="button login">
            <button>
                <span style="display: block;width: 100%;height: 100%;line-height: 70px;" id="regist-up">注册</span>
                <i class="fa fa-check"></i>
            </button>
        </div>
        <p id="zhuce-message" style="color: red;text-align: center;"></p>
    </div>
</div>
<script src="../js/validateIdCard.js"></script>
<script>

    function toDenglu(){
        $('#zhuce').addClass("container-hide");
        $('#denglu').removeClass("container-hide");
        // alert("denglu");
        $("#zhuce-message").text("");
    }
    $(document).ready(function () {
        $('#lab-zhuce').click(function () {
            $('#denglu').addClass("container-hide");
            $('#zhuce').removeClass("container-hide");
            // alert("tozhuce");
            $("#denglu-message").text("");
        });
        $('#lab-denglu').click(function () {
            toDenglu();
        })
    });
    //登录提交
    $("#login-up").click(function () {
        var login_id = $("#denglu input[name='id']" ).val();
        var loing_password = $("#denglu input[name='password']" ).val();
        // alert(login_id + "   "+loing_password);

        if(login_id==null || login_id==""){
            $("#denglu-message").text("账户不能为空");
        }else if(loing_password==null || loing_password==""){
            $("#denglu-message").text("密码不能为空");
        }else {
            $("#denglu-message").text("");
            <%--$.get("${pageContext.request.contextPath}/patient/patientAjaxLogin.do",--%>
                <%--{p_id:login_id,p_p_password:loing_password},--%>
                <%--function(result){--%>
                    <%--if (result != null && result != "") {--%>
                        <%--if(result=="success") { //登录成功  跳转到主页面--%>
                            <%--window.location.href="user_home.jsp";--%>
                        <%--}else {--%>
                            <%--$("#denglu-message").text(result);--%>
                        <%--}--%>
                    <%--}--%>
                <%--});--%>
            $.ajax({
                url : "${pageContext.request.contextPath}/patient/patientAjaxLogin.do",
                type : "POST",
                data : {
                    p_id:   login_id,
                    p_password:  loing_password
                },
                dataType : "json",
                //处理后端返回的数据
                success : function(result) {
                    if (result != null && result != "") {
                        if(result=="success") { //登录成功  跳转到主页面
                            window.location.href="user_home.jsp";

                        }else {
                            $("#denglu-message").text(result);
                        }
                    }
                    //alert("接受到的数据是：" + message);
                },
                //处理失败返回的数据
                error : function(result) {
                    window.location.href="../err.html";
                }
            });
        }
    });

    //注册提交
    $("#regist-up").click(function () {
        var zhuce_id = $("#zhuce input[name='idcard']" ).val();
        var zhuce_name = $("#zhuce input[name='username']" ).val();
        var zhuce_gender = $("#zhuce input[name='gender']:checked" ).val();
        var zhuce_birthday = $("#zhuce input[name='user_date']" ).val();
        var password =  $("#zhuce input[name='password']" ).val();

        if(zhuce_id==null ||zhuce_id==""||zhuce_id.length<18){
            $("#zhuce-message").text("请输入有效身份证号");
        }
        // else if(!validateIdCard(zhuce_id)){
        //     $("#zhuce-message").text("请输入有效身份证号");
        // }
        else if(zhuce_name==null || zhuce_name==""){
            $("#zhuce-message").text("请填写完整姓名");
        }else if(zhuce_birthday==null || zhuce_birthday==""){
            $("#zhuce-message").text("请选择出生日期");
        }else if(password==null || password==""){
            $("#zhuce-message").text("请设置密码");
        }else {
            $("#zhuce-message").text("");
            $.ajax({
                url : "${pageContext.request.contextPath}/patient/patientAjaxRegist.do",
                type : "POST",
                data : {
                    p_id:   zhuce_id,
                    p_name: zhuce_name,
                    birthday:zhuce_birthday,
                    p_gender:zhuce_gender,
                    p_password:  password
                },
                dataType : "json",
                //处理后端返回的数据
                success : function(result) {
                    if (result != null && result != "") {
                        if(result=="success")
                        { //登录成功  跳转到主页面
                            alert("注册成功，请登录")
                            toDenglu();
                        }else {
                            $("#zhuce-message").text(result);
                        }
                    }
                    //alert("接受到的数据是：" + message);
                },
                //处理失败返回的数据
                error : function(result) {
                    window.location.href="../err.html";
                }
            });
        }

        // alert(zhuce_id.length);
        // alert(zhuce_id + "  " + zhuce_name + "  " + zhuce_gender + "  " +zhuce_birthday+"   "+ password  );
    });

</script>
</body>
</html>
