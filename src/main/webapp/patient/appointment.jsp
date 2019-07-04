<%--
  Created by IntelliJ IDEA.
  User: cuijiahao
  Date: 2019/7/4
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<!-- 用户预约页面 -->
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
    <link rel="stylesheet" href="../css/patient/apointment.css">
    <title>Title</title>

</head>
<body>
<header class="user-header">
    <div class="wrap">
        <div class="logo"></div>
        <h1 class="title">PHARMACY</h1>
        <nav class="user-nav">
            <ul>
                <li><a href="user_home.html">首页</a></li>
                <li><a href="department-nav.html">科室导航</a></li>
                <li><a href="#">医生简介</a></li>
                <li><a href="#"  class="active">预约挂号</a></li>
                <li><a href="#">个人中心</a></li>
                <li><a href="#">其他栏目</a></li>
            </ul>
        </nav>
    </div>
</header>
<section class="user-body">
    <div class="wrap">
        <!--<form id="form" action="#">-->
        <div class="wrap1">
            请选择科室和时间来进行预约
            <span class="title">科室选择：</span>
            <div class="d-box">
                <div class="d-item">
                    <label for="key">
                        <input type="radio" name="deportment-name" id="key" value="科室id1">科室名称
                    </label>
                    <span class="btn">科室名称</span>
                </div>
                <div class="d-item">
                    <label for="key2">
                        <input type="radio" name="deportment-name" id="key2" value="科室id2">科室名称
                    </label>
                    <span class="btn">科室名称</span>
                </div>
            </div>
        </div>
        <div class="wrap2">
            <span class="title">时间选择：</span>
            <div id="timebox">
                <table id="timetable" >
                    <thead>
                    <tr>
                        <th><div><p class="week">周一</p><p class="day">2019-5-6</p></div></th>
                        <th><div><p class="week">周一</p><p class="day">2019-5-6</p></div></th>
                        <th><div><p class="week">周一</p><p class="day">2019-5-6</p></div></th>
                        <th><div><p class="week">周一</p><p class="day">2019-5-6</p></div></th>
                        <th><div><p class="week">周一</p><p class="day">2019-5-6</p></div></th>
                        <th><div><p class="week">周一</p><p class="day">2019-5-6</p></div></th>
                        <th><div><p class="week">周一</p><p class="day">2019-5-6</p></div></th>
                    </tr>
                    </thead>
                    <tbody>
                    <!--第一行-->
                    <tr>
                        <td>
                            <div class="time-box">
                                <label for="time11"><input type="radio" name="time" id="time11" value="test"></label>
                                <span class="btn-time">9:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time12"><input type="radio" name="time" id="time12"></label>
                                <span class="btn-time">9:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time13"><input type="radio" name="time" id="time13"></label>
                                <span class="btn-time">9:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time14"><input type="radio" name="time" id="time14"></label>
                                <span class="btn-time">9:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time15"><input type="radio" name="time" id="time15"></label>
                                <span class="btn-time">9:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time16"><input type="radio" name="time" id="time16"></label>
                                <span class="btn-time">9:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time17"><input type="radio" name="time" id="time17"></label>
                                <span class="btn-time">9:00</span>
                            </div>
                        </td>
                    </tr>
                    <!--第二行-->
                    <tr>
                        <td>
                            <div class="time-box">
                                <label for="time21"><input type="radio" name="time" id="time21"></label>
                                <span class="btn-time">10:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time22"><input type="radio" name="time" id="time22"></label>
                                <span class="btn-time">10:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time23"><input type="radio" name="time" id="time23"></label>
                                <span class="btn-time">10:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time24"><input type="radio" name="time" id="time24"></label>
                                <span class="btn-time">10:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time25"><input type="radio" name="time" id="time25"></label>
                                <span class="btn-time">10:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time26"><input type="radio" name="time" id="time26"></label>
                                <span class="btn-time">10:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time27"><input type="radio" name="time" id="time27"></label>
                                <span class="btn-time">10:00</span>
                            </div>
                        </td>
                    </tr>
                    <!--第三行-->
                    <tr>
                        <td>
                            <div class="time-box">
                                <label for="time31"><input type="radio" name="time" id="time31" value="test"></label>
                                <span class="btn-time">11:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time32"><input type="radio" name="time" id="time32" value="test"></label>
                                <span class="btn-time">11:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time33"><input type="radio" name="time" id="time33" value="test"></label>
                                <span class="btn-time">11:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time34"><input type="radio" name="time" id="time34" value="test"></label>
                                <span class="btn-time">11:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time35"><input type="radio" name="time" id="time35" value="test"></label>
                                <span class="btn-time">11:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time36"><input type="radio" name="time" id="time36" value="test"></label>
                                <span class="btn-time">11:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time37"><input type="radio" name="time" id="time37" value="test"></label>
                                <span class="btn-time">11:00</span>
                            </div>
                        </td>
                    </tr>
                    <!--第四行-->
                    <tr>
                        <td>
                            <div class="time-box">
                                <label for="time41"><input type="radio" name="time" id="time41" value="test"></label>
                                <span class="btn-time">14:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time42"><input type="radio" name="time" id="time42" value="test"></label>
                                <span class="btn-time">14:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time43"><input type="radio" name="time" id="time43" value="test"></label>
                                <span class="btn-time">14:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time44"><input type="radio" name="time" id="time44" value="test"></label>
                                <span class="btn-time">14:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time45"><input type="radio" name="time" id="time45" value="test"></label>
                                <span class="btn-time">14:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time46"><input type="radio" name="time" id="time46" value="test"></label>
                                <span class="btn-time">14:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time47"><input type="radio" name="time" id="time47" value="test"></label>
                                <span class="btn-time">14:00</span>
                            </div>
                        </td>
                    </tr>
                    <!--第五行-->
                    <tr>
                        <td>
                            <div class="time-box">
                                <label for="time51"><input type="radio" name="time" id="time51" value="test"></label>
                                <span class="btn-time">15:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time52"><input type="radio" name="time" id="time52" value="test"></label>
                                <span class="btn-time">15:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time53"><input type="radio" name="time" id="time53" value="test"></label>
                                <span class="btn-time">15:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time54"><input type="radio" name="time" id="time54" value="test"></label>
                                <span class="btn-time">15:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time55"><input type="radio" name="time" id="time55" value="test"></label>
                                <span class="btn-time">15:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time56"><input type="radio" name="time" id="time56" value="test"></label>
                                <span class="btn-time">15:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time57"><input type="radio" name="time" id="time57" value="test"></label>
                                <span class="btn-time">15:00</span>
                            </div>
                        </td>
                    </tr>
                    <!--第六行-->
                    <tr>
                        <td>
                            <div class="time-box">
                                <label for="time61"><input type="radio" name="time" id="time61" value="test"></label>
                                <span class="btn-time">16:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time62"><input type="radio" name="time" id="time62" value="test"></label>
                                <span class="btn-time">16:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time63"><input type="radio" name="time" id="time63" value="test"></label>
                                <span class="btn-time">16:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time64"><input type="radio" name="time" id="time64" value="test"></label>
                                <span class="btn-time">16:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time65"><input type="radio" name="time" id="time65" value="test"></label>
                                <span class="btn-time">16:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time66"><input type="radio" name="time" id="time66" value="test"></label>
                                <span class="btn-time">16:00</span>
                            </div>
                        </td>
                        <td>
                            <div class="time-box">
                                <label for="time67"><input type="radio" name="time" id="time67" value="test"></label>
                                <span class="btn-time">16:00</span>
                            </div>
                        </td>
                    </tr>
                    <!--第七行-->
                    <!--<tr>-->
                    <!--<td>-->
                    <!--<div class="time-box">-->
                    <!--<label for="time71"><input type="radio" name="time" id="time71" value="test"></label>-->
                    <!--<span class="btn-time">17:00</span>-->
                    <!--</div>-->
                    <!--</td>-->
                    <!--</tr>-->
                    </tbody>
                </table>
            </div>
            <span class="title"></span>
        </div>
        <div class="wrap3">
            <form id="form" action="#"  method="post" onsubmit="return checkForm()">
                <div class="input">
                    <label for="indeportment">所选科室：</label>
                    <input type="text" id="indeportment" disabled>
                </div>
                <div class="input">
                    <label for="intime" >所选时间：</label>
                    <input type="text" id="intime" disabled>
                </div>
                <button id="btn-ok">提交</button>
                <button id="btn-cancel" type="reset">取消</button>
                <p class="message" id="message"></p>
            </form>
        </div>
        <!--</form>-->
    </div>

</section>
<footer class="user-footer">
    <div class="wrap">
    </div>
</footer>
<script src="../js/jquery-2.2.1.min.js"></script>
<script>

    // 这是按钮切换的选择
    $(".d-item label").click(function() {
        $(this).siblings("span").addClass("active");
        $(this).parent().siblings("div").find("span").removeClass("active");
        //给input表单的科室负值
        $("#indeportment")[0].value = $(this).find("input")[0].value;
    });
    //时间按钮切换
    $("#timetable label").click(function () {
        $("#timetable span").removeClass("active");
        $(this).siblings("span").addClass("active");
        // console.log($(this).find("input")[0].value);
        //给input表单设值
        $("#intime")[0].value = datetimeFormat($(this).find("input")[0].value);
    });

    //提交按钮，
    function checkForm(){
        var message = $("#message");
        var dp =  $("#indeportment")[0].value;
        var time = $("#intime")[0].value;
        if(dp==null || dp=="") {
            console.log("空的");
            $("#message").text( "*请选择预约科室");
            return false;
        } else if( time==null || time == "") {
            $("#message").text( "*请选择预约时间");
            return false;
        }else {
            $("#message").text("");
            return true;
        }
    }
    //取消按钮
    $("#btn-cancel").click(function () {
        $("#timetable span").removeClass("active");
        $(".d-item span").removeClass("active");
    });




    $(document).ready(function () {
        var nowtime = new Date();
        // var nexttime = new Date(nowtime);
        // nexttime.setDate(nowtime.getDate()+1);
        //设置th中的标题
        var weektds = $("#timetable .week");
        var daytds = $("#timetable .day");
        for(var i=0;i<weektds.length;i++){
            var t_time = new Date(nowtime);
            t_time.setDate(nowtime.getDate() + i);  //设置星期
            weektds.eq(i).text(t_time.getDay());
        }
        for(var i=0;i<daytds.length;i++){
            var t_time = new Date(nowtime);
            t_time.setDate(nowtime.getDate() + i);  //设置星期
            var year = t_time.getFullYear() ;

            var month = t_time.getMonth() + 1;
            var day = t_time.getDate();
            daytds.eq(i).text(year+"-"+month+"-"+day);
        }

        var trs =  $("#timetable tbody tr"); //tbody的行
        var time1 = new Date(nowtime);
        //第一行
        time1.setHours(9,0,0,0); //参数分别是 时 分 秒 毫秒
        setRowTime(time1,0);
        // var labels1 = trs.eq(0).find("label");    // 第一行 label数组
        // for(var i=0;i<labels1.length;i++){
        //     var temp_time = new Date(time1);
        //     temp_time.setDate(nowtime.getDate() + i);
        //     //...这里设置lable中inpupt的value
        //     labels1.eq(i).find("input")[0].value = temp_time;
        // }
        //第二行
        time1.setHours(10,0,0,0);
        setRowTime(time1,1);
        //第三行
        time1.setHours(11,0,0,0);
        setRowTime(time1,2);
        //第四行
        time1.setHours(14,0,0,0);
        setRowTime(time1,3);
        //第五行
        time1.setHours(15,0,0,0);
        setRowTime(time1,4);
        //第六行
        time1.setHours(16,0,0,0);
        setRowTime(time1,5);
        //第七行
        time1.setHours(17,0,0,0);
        setRowTime(time1,6);
        /**
         *  设置行的时间
         *  time 是设置的时间 row 是行号
         */
        function setRowTime(paratime,row){
            var labels = trs.eq(row).find("label");
            for(var i=0;i<labels.length;i++){
                var temp_time = new Date(paratime);
                temp_time.setDate(nowtime.getDate() + i);
                //...这里设置lable中inpupt的value
                labels.eq(i).find("input")[0].value = temp_time.getTime();
            }
        }
    });


    /*
* 时间格式化工具
* 把Long类型的1527672756454日期还原yyyy-MM-dd 00:00:00格式日期
*/
    function datetimeFormat(longTypeDate ){
        var dateTypeDate = "";
        var date = new Date();
        date.setTime(longTypeDate);
        dateTypeDate += date.getFullYear();   //年
        dateTypeDate += "-" + getMonth(date); //月
        dateTypeDate += "-" + getDay(date);   //日
        dateTypeDate += " " + getHours(date);   //时
        dateTypeDate += ":" + getMinutes(date);     //分
        dateTypeDate += ":" + getSeconds(date);     //分
        return dateTypeDate;
    }
    /*
     * 时间格式化工具
     * 把Long类型的1527672756454日期还原yyyy-MM-dd格式日期
     */
    function dateFormat(longTypeDate){
        var dateTypeDate = "";
        var date = new Date();
        date.setTime(longTypeDate);
        dateTypeDate += date.getFullYear();   //年
        dateTypeDate += "-" + getMonth(date); //月
        dateTypeDate += "-" + getDay(date);   //日
        return dateTypeDate;
    }
    //返回 01-12 的月份值
    function getMonth(date){
        var month = "";
        month = date.getMonth() + 1; //getMonth()得到的月份是0-11
        if(month<10){
            month = "0" + month;
        }
        return month;
    }
    //返回01-30的日期
    function getDay(date){
        var day = "";
        day = date.getDate();
        if(day<10){
            day = "0" + day;
        }
        return day;
    }
    //小时
    function getHours(date){
        var hours = "";
        hours = date.getHours();
        if(hours<10){
            hours = "0" + hours;
        }
        return hours;
    }
    //分
    function getMinutes(date){
        var minute = "";
        minute = date.getMinutes();
        if(minute<10){
            minute = "0" + minute;
        }
        return minute;
    }
    //秒
    function getSeconds(date){
        var second = "";
        second = date.getSeconds();
        if(second<10){
            second = "0" + second;
        }
        return second;
    }

</script>
</body>
</html>