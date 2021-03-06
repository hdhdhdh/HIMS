<%--
  Created by IntelliJ IDEA.
  User: luodi
  Date: 2019/7/3
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>

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
    <link rel="stylesheet" href="../css/patient/user-home.css">
    <link rel="stylesheet" href="../css/pageIcon.css">
    <title>医院挂号系统</title>
    <style>
        body {
            background: url("../images/bg5.jpg");
        }
    </style>
</head>
<body>
<header class="user-header">
    <div class="wrap">
        <div class="logo"></div>
        <a href="../index.jsp" class="title" style="margin: 0;font-family:'Microsoft Yahei'; text-decoration: none;color: #ffffff">PHARMACY</a>
        <nav class="user-nav">
            <ul>
                <li><a href="user_home.jsp">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/patient/toDepartmentNav.do">科室导航</a></li>
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
            <!-- 左侧  -->
            <!--<ul class="department-menu">-->
            <!--<li>jjjj</li>-->
            <!--<li>hhhhonl</li>-->
            <!--<li>asfsdfas</li>-->
            <!--</ul>-->
            <!--轮播图-->
            <div class="slideshow" id="slideshow">
                <span class="arrow pre"><i class="icon icon-chevron_left"></i></span>
                <span class="arrow next"><i class="icon icon-navigate_next"></i></span>
                <ul class="pics">
                    <li class="active"><img src="../images/1.jpg" alt=""></li>
                    <li><img src="../images/2.jpg" alt=""></li>
                    <li><img src="../images/3.jpg" alt=""></li>
                    <li><img src="../images/4.jpg" alt=""></li>
                </ul>
                <ul class="points">
                    <li class="active"></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>

        </div>
        <div class="wrap2">
            <div class="wrap2-img"></div>
            <div class="wrap2-des">
                <span class="h1">Hospital doctors examine patients </span>
                <span class="h1">so that they can diagnose</span>
                <div class="item">
                    <div class="icon-pic icon icon-atom" style="color: #1cba9f; text-align:center; line-height:100px;font-size: 36px;"></div>
                    <div class="item-content">
                        <span class="h2">Intensive care</span>
                        <p>Behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                </div>
                <div class="item">
                    <div class="icon-pic icon icon-syringe" style="color: #558dca; text-align:center; line-height:100px;font-size: 36px;"></div>
                    <div class="item-content">
                        <span class="h2">Specialised Support Service</span>
                        <p>Behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                </div>
                <div class="item">
                    <div class="icon-pic icon icon-pill" style="color:#223a66; text-align:center; line-height:100px;font-size: 36px;"></div>
                    <div class="item-content">
                        <span class="h2">Medical & Surgical</span>
                        <p>Behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="wrap3">
            <div class="introduce">
                <!--简介-->
                <div class="title">科室简介</div>
                <div class="line"></div>
                <div class="content">暂无信息</div>
            </div>
            <div class="achievement">
                <!--科室成就-->
                <div class="title">科室成就</div>
                <div class="line"></div>
                <div class="content">暂无信息</div>
            </div>
            <div class="reaserch">
                <!--临床研究-->
                <div class="title">临床研究</div>
                <div class="line"></div>
                <div class="content">暂无信息</div>
            </div>
        </div>
        <div class="wrap4" id="wrap4">
            <!--<div class="boc">-->
            <div class="left-menu">
                <ul>
                    <li class="active">挂号须知</li>
                    <li>院内公告</li>
                </ul>
            </div>
            <div class="right-box">
                <div class="content-box" id="xuzhi">
                    <div class="scrollbar"></div>
                    <h3>网络预约挂号及取号流程</h3><hr>
                    <div class="info-item">
                        <h4>预约挂号：</h4>
                        <p>网络预约地址为：http://www.114yygh.com，可关注“北京114预约挂号”微信公众号。</p>
                    </div>
                    <div class="info-item">
                        <h4>放号时间：</h4>
                        <p>通过电话预约挂号可挂7日内的号源，周一至周五上午8:30投放出第7日新号源，下午14:00停止预约次日号源（周末及节假日除外）。</p>
                    </div>
                    <div class="info-item">
                        <h4>就诊当日：</h4>
                        <p>初次来院就诊患者需持患者本人预约时的有效证件先办理注册建档，二代身份证患者可在院内自助机办理注册建档，北京医保患者办理注册建档后需在院内自助机进行医保卡关联。</p>
                    </div>
                    <div class="info-item">
                        <h4>取号方式：</h4>
                        <p>院内自助机取号： 持患者本人身份证、北京医保卡或就医凭证在指定时间内到医院院内自助机缴费取号，可使用任意银联标识的银行卡、微信和支付宝支付挂号费。</p>
                    </div>
                    <div class="info-item">
                        <h4>取号时间：</h4>
                        <p>上午号必须在就诊日上午9:00前取号，下午号必须在就诊日下午14:00前取号。</p>
                        <p>取号成功后需先在院内自助机上报到，再到诊区候诊。</p>
                    </div>
                    <div class="info-item">
                        <h4>退号规则：</h4>
                        <p>本号过期（超过预约就诊日期的工作开始时间）作废，一律不退号。</p>
                    </div>
                </div>
                <div class="content-box" id="gonggao">
                    <div class="scrollbar"></div>
                    <h3>暂无公告</h3><hr>
                </div>
            </div>
            <!--</div>-->
        </div>
    </div>
</section>
<footer class="user-footer">
    <div class="wrap">
    </div>
</footer>
<script src="../js/jquery-2.2.1.min.js"></script>
<script src="../js/slideshow.js"></script>

<script>
    $("#wrap4 li").click(function () {
        $(this).siblings().removeClass("active")
        $("#wrap4 .content-box").hide();
        console.log($(this).index());
        $(this).addClass("active");
        var index = $(this).index();
        $("#wrap4 .content-box").eq(index).show();
    });
</script>
</body>
</html>