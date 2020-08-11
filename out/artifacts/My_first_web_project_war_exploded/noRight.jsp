<%--
  Created by IntelliJ IDEA.
  User: MrDerek
  Date: 2020/7/5
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8;" />
    <link rel="stylesheet" href="resources/CSS/index.css" type="text/css">
    <link rel="stylesheet" href="resources/CSS/home.css" type="text/css">
    <link rel="stylesheet" href="resources/layui/css/layui.css">
    <title>没有权利</title>
</head>
<body>
<ul class="layui-nav">
    <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
    <li class="layui-nav-item"><a href="home.jsp">个人主页</a></li>
    <li class="layui-nav-item"><a href="user">用户管理</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">留言</a>
        <dl class="layui-nav-child">
            <dd><a href="writemessage.jsp">发送留言</a></dd>
            <dd><a href="text">查看留言</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:;">通知</a>
        <dl class="layui-nav-child">
            <dd><a href="writenotice.jsp">发布通知</a></dd>
            <dd><a href="view">查看通知</a></dd>
        </dl>
    </li>
</ul>
<div class="div4">
    <div  class="layui-anim layui-anim-up layui-anim-scaleSpring" style="position: absolute;left: 45%;top: 25%">
        <i class="layui-icon layui-icon-face-surprised" style="font-size: 170px; color: #FF5722;"></i>
        <p style="font-size: 50px; color: #FF5722;position: absolute;left: -122%;top : 120%;width: 700px">oops!你好像没有这个权限！</p>
    </div>
</div>
<script src="resources/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(["element"],function () {

    })
</script>

<script>
    layui.use('form', function(){
        var form = layui.form
        form.verify({
            nes: [/[\S]+/, "必填项不能为空"]
            ,age: [/[\d]+/, "你的年龄是竟然不是数字？"]
        });
    });
</script>
</body>
</html>
