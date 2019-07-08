<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>btable</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="css/btable.css" />
    <link rel="stylesheet" href="css/begtable.css" />
</head>

<body style=" background-color: gainsboro;">

<div style="margin: 15px;">
    <fieldset class="layui-elem-field">
        <legend>处方确认</legend>
        <div style="width: 1300px; height: 350px; border: 1px solid #009688;">
            <div class="beg-table-box">
                <div class="beg-table-body">
                    <a href="javascript:;" class="layui-btn layui-btn-small" id="search" style="float: right">
                        <i class="layui-icon">&#xe615;</i> 查询
                    </a>
                    <p style="float: right"><input name="p_id" type="text" value="请输入身份证号"></p>
                    <table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
                        <thead>
                        <tr>
                            <th>身份证号</th>
                            <th>病人姓名</th>
                            <th>病人性别</th>
                            <th>药物清单</th>
                            <th></th>
                        </tr>
                        <tr>
                            <!--<td>723</td>-->
                            <!--<td>张三</td>-->
                            <!--<td>2019-7-6</td>-->
                            <!--<td>骨科</td>-->
                            <!--<td>药物a、药物b、药物c</a></td>-->
                            <!--<td><Doc class="chen"></Doc></td>-->
                            <!--&lt;!&ndash; Button trigger modal &ndash;&gt;-->
                            <!--<td><a class="layui-btn layui-btn-small" id="#conform" >确认</a>-->
                        </tr>
                        </thead>
                        <tbody id="prescriptiontable">
                        </tbody>
                    </table>
                </div>
                <div class="beg-table-paged"></div>
            </div>
        </div>
    </fieldset>
</div>
<script src="js/jquery-2.2.1.min.js">
</script>
<script src="js/jquery-2.2.1.min.js">
</script>
<script>

    $("#search").click(function () {
        getUncheckoutPrescription();
    });
    function getUncheckoutPrescription() {
        // page=page||1;
        // size=size||5;	//设置默认第一页，每页5条记录
        $.ajax(
            {
                url: "/pharmacist/getUncheckoutPrescription.do",
                type: "POST",
                data:
                    {
                        p_id:$("input[name='p_id']").val(),
                    },
                dataType: "json",
                //处理后端返回的数据
                success: function (result) {
                    if (result.message) {
                        alert(result.message);
                        return;
                    }
                    console.log(result);
                    $("#prescriptiontable").html("");
                    $.each(result, function (index, item) {
                        $("#prescriptiontable").append("<tr>" +
                            "<td>" + item.p_id + "</td>\n" +
                            "<td>" + item.p_name + "</td>" +
                            "<td>" + item.p_gender + "</td>" +
                            "<td>" + item.m_list + "</td>" +
                            "<td>" +
                            "<button class=\"layui-btn layui-btn-small\""+"onclick=checkoutPrescription(\""+item.c_id+"\")>确认</button>" +
                            "</tr>"
                        )
                    });
                },
                //处理失败返回的数据
                error: function (result) {
                    alert(result.message);
                    // window.location.href="err.html";
                }
            });
    }
    function checkoutPrescription(c_id) {
        // page=page||1;
        // size=size||5;	//设置默认第一页，每页5条记录
        $.ajax(
            {
                url: "/pharmacist/checkoutPrescription.do",
                type: "POST",
                data:
                    {
                        c_id:c_id,
                    },
                dataType: "json",
                //处理后端返回的数据
                success : function(result) {
                    if(result.message != "successed")
                    {
                        alert(result.message);
                        window.location.href="${pageContext.request.contextPath}/checkOutPrescription.jsp";

                    }else
                    {
                        window.location.href="${pageContext.request.contextPath}/checkOutPrescription.jsp";
                    }

                },
                //处理失败返回的数据
                error: function (result) {
                    alert(result.message);
                    // window.location.href="err.html";
                }
            });
    }
</script>




<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script>


    layui.config({
        base: 'js/'
    }).use(['btable'], function () {
        var btable = layui.btable(),
            $$ = layui.jquery;

        checkoutPrescriptionPage.set({
            elem: '#content',
            url: 'datas/btable_data.json',
            pageSize: 3,
            columns: [{
                fieldName: '昵称',
                field: 'name'
            }, {
                fieldName: '加入时间',
                field: 'createtime'
            }, {
                fieldName: '签名',
                field: 'sign'
            }],
            even: true,
            //skin: 'row',
            checkbox: true,
            paged: true,
            singleSelect: false
        });
        checkoutPrescriptionPage.render();

        $$('#getAll').on('click', function () {

            //btable.getSelected(function(obj){
            //	console.log(obj.elem);
            //	layer.msg(obj.id);
            //});
            //获取选择的数据
            checkoutPrescriptionPage.getSelections(function (obj) {
                console.log(obj.elem);
                console.log(obj.ids);
                console.log(obj.count);
                layer.msg(obj.ids.join(','))
            });

        });

        $$(window).on('resize', function (e) {
            var $that = $$(this);
            $$('#content').height($that.height() - 92);
        }).resize();
    });
</script>
</body>

</html>
<!----出发确认---->