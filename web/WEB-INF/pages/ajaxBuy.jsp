<%--
  Created by IntelliJ IDEA.
  User: 刘顺顺
  Date: 2021/9/3
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css"href="/res/layui-v2.5.6/layui/css/layui.css">
<script src="/res/layui-v2.5.6/layui/layui.js"></script>
<%--<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>--%>
<html>
<head>
    <title>go shopping</title>
</head>
<body>
        <div>
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>水稻</td>
                    <td>80</td>
                    <td>1</td>
                    <td><input type="button" value="购买" onclick="buy(this);" /></td>
                </tr>
                <tr>
                    <td>玉米</td>
                    <td>90</td>
                    <td>1</td>
                    <td><input type="button" value="购买" onclick="buy(this);" /></td>
                </tr>
                <tr>
                    <td>麻豆</td>
                    <td>100</td>
                    <td>1</td>
                    <td><input type="button" value="购买" onclick="buy(this);" /></td>
                </tr>
                </tbody>
            </table>
        </div>

        <script>
            $(function () {
                $("#buy").click(function () {
                    $.ajax({
                        url:"/api/admin/ajaxBuy",
                        type:"POST",
                        dataType:"json",
                        data:{

                        },
                        dataType:"json",
                        success:function (r) {
                            console.log(r)
                        }
                    });
                })
            });
        </script>
</body>
</html>
