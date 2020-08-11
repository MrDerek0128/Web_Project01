<%--
  Created by IntelliJ IDEA.
  User: MrDerek
  Date: 2020/6/25
  Time: 14:41
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
    <title>个人主页</title>
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
<div class="div3">
    <div class="layui-anim layui-anim-up layui-anim-scale">
        <p style="color: #01AAED;font-size: 130px;font-family: Georgia;position: absolute;left: 32%;top: 150px">Welcome!</p>
        <p style="color: #01AAED;font-size: 60px;font-family: Georgia;position: absolute;left: 25%;top: 350px">快点击上方的导航进行操作吧！</p>
    </div>
    <form action = "loginOut" style="position: absolute;left: 88%;top: 85%">
        <input type="submit" class="layui-btn layui-btn-danger layui-btn-radius" name="out" value="退出登录">
    </form>
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
