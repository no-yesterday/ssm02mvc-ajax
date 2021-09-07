<%--
  Created by IntelliJ IDEA.
  User: 刘顺顺
  Date: 2021/9/2
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<html>
<head>
    <title>springmvc 之 ajax 和 mvc 收参数</title>
</head>
<body>
        <div>
            <input type="button" value="ajax 的 01 中传参数 k-v结构" id="ajax01">
            <input type="button" value="ajax 的 02 中传参数 对象" id="ajax02">
            <input type="button" value="ajax 的 03 中传参数 传数组或者集合" id="ajax03">
            <input type="button" value="ajax 的 04 中传参数 传json对象" id="ajax04">
            <input type="button" value="ajax 的 05 中传参数 传多个对象" id="ajax05">
            <input type="button" value="ajax 的 06 中传参数 传 批量对象传参" id="ajax06">
            <input type="button" value="ajax 的 07 中传参数 map传参" id="ajax07">
            <input type="button" value="ajax 的 08 中对象+常用类型 混合，常见于带参数的分页查询" id="ajax08">
        </div>

        <script>
            $(function () {
                $("#ajax01").click(function () {
                    $.ajax({
                        url:"/api/admin/regByBean",
                        type:"POST",
                        data:{
                            'adminName':'zhangsan',
                            'adminPwd':'123',
                            'adminTime':'2010-09-08 23:09:08'
                        },
                        dataType:'JSON',
                        success:function (res) {
                            console.log(res)
                        }
                    });
                })
                $("#ajax02").click(function () {
                    var adminInfo={};
                        adminInfo.adminName='zhangsan';
                        adminInfo.adminPwd='123';
                        adminInfo.adminTime='2010-09-08 23:09:08';
                    $.ajax({
                        url:"/api/admin/regByBean",
                        type:"POST",
                        data:adminInfo,
                        dataType:'JSON',
                        success:function (rs) {
                            console.log(rs)
                        }
                    });
                })
                //ajax 传数组， 集合， 应用的范围是 批量删除。
                $("#ajax03").click(function () {
                    var ids=new Array();
                        ids.push(3);
                        ids.push(6);
                        ids.push(8);
                        ids.push(10);
                    $.ajax({
                        url:"/api/admin/ajax03",
                        type:"POST",
                        data:{'ids':ids},
                        dataType:'JSON',
                        success:function (res) {
                            console.log(res)
                        }
                    });
                })
                $("#ajax04").click(function () {
                    //json 对象 浏览器中看到的请求是彩色的
                    var adminInfo={
                        adminName:"谢欣欣",
                        adminTime:"2020-09-08 12:09:34",
                        adminPwd:"123",
                        loverList:[
                            {
                                name:"lala",
                                age:18
                            },
                            {
                                name:"aaa",
                                age:8
                            },
                            {
                                name:"go",
                                age:20
                            }
                        ],
                        aiHao:[4,9,13]
                    };
                    //var出来的对象，他是个对象，如果直接传输，是以  www-urlxxx 传递的，黑色的
                    //因为 普通的 请求 是很多个 k-v 结构，后台收取特别麻烦，所以就需要把复杂的对象转换成json对象
                    //然后 后台接收就方便多了，前后端项目  ，一般都是用json传递
                    $.ajax({
                        url:"/api/admin/ajax04",
                        type:"POST",
                        // data:adminInfo,   //普通的 k-v 结构 请求方式是： Content-Type：application/x-www-form-urlencoded;charset=UTF-8
                        dataType:"json",
                        data:JSON.stringify(adminInfo),  //变为json对象后，就需要Content-Type 更改为application/json;charset=UTF-8
                        contentType:"application/json;charset=UTF-8",
                        dataType:"json",
                        success:function (rs) {
                            console.log(rs)
                        }
                    });
                })
                $("#ajax05").click(function () {  //不常见，因为 发货单，上面是收货人对象，下面是产品对象
                    $.ajax({
                        url:"/api/admin/ajax05",
                        type:"POST",
                        data:{
                            'lover.name':'老薛',
                            'lover.age':18,
                            'dog.dogId':1002,
                            'dog.dogSex':'X',
                        },
                        dataType:'JSON',
                        success:function (res) {
                            console.log(res)
                        }
                    });
                })
                $("#ajax06").click(function () {
                    var loverList=[];
                    for (var i = 0; i < 5; i++) {
                        var lover={
                            name:"小小"+i,
                            age:18
                        }
                        loverList.push(lover)
                    }
                    //多个对象，就属于复杂， 复杂用json
                    $.ajax({
                        url:"/api/admin/ajax06",
                        // type:"GET",    //get请求没有方法体，无法传输 json 的协议 和 json数据！
                        type:"POST",
                        data:JSON.stringify(loverList),
                        dataType:'json',
                        contentType:'application/json;charset=utf-8',
                        success:function (r) {
                            console.log(r)
                        }
                    });
                })
                $("#ajax07").click(function () {
                    var map = {
                        'adminName':'zhangsan',
                        'adminPwd':'123',
                        'adminTime':'2010-09-08 23:09:08'
                    }
                    $.ajax({
                        url:"/api/admin/ajax07",
                        type:"POST",
                        dataType:"json",
                        data:JSON.stringify(map),   //json序列化
                        contentType:"application/json;charset=UTF-8",
                        dataType:"json",
                        success:function (res) {
                            console.log(res)
                        }
                    });
                })
                $("#ajax08").click(function () {
                    $.ajax({
                        url:"/api/admin/ajax08",
                        type:"POST",
                        dataType:"json",
                        data:{   //四个k-v
                            'name':'三',
                            'age':3,
                            'pageSize':5,
                            'page':2
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
