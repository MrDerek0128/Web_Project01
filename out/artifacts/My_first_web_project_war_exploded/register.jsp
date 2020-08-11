<%--
  Created by IntelliJ IDEA.
  User: MrDerek
  Date: 2020/6/25
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="resources/CSS/index.css" type="text/css">
    <link rel="stylesheet" href="resources/layui/css/layui.css">
    <title>注册</title>
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
<div class="div2">
    <div style="position: relative;left: 38%;top: 8%;width: 40%">
        <p style="font-family: Microsoft JhengHei;font-size: 70px;color: white">sign up here!</p>
    </div>
    <form class="layui-form" action="Register" style="width: 50%;position: relative;top: 18%;left: 24%">
        <div class="layui-form-item" style="margin-bottom: 0;width: 50%;float: left">
            <label class="layui-form-label" style="color: white;">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="nes" placeholder="请输入用户名" autocomplete="off" class="layui-input" style="width: 280px">
            </div>
        </div>
        <div class="layui-form-item" style="position: relative;left: 50%;top: -39px;">
            <label class="layui-form-label" style="color: white">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" lay-verify="nes" placeholder="请输入密码" autocomplete="off" class="layui-input" style="width: 280px">
            </div>
        </div>
        <div class="layui-form-item" style="position: relative;left: 0%;top: -25px;">
            <label class="layui-form-label" style="color: white">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="nes" placeholder="请输入姓名" autocomplete="off" class="layui-input" style="width: 280px">
            </div>
        </div>
        <div class="layui-form-item" style="position: relative;left: 50%;top: -79px;width: 50%">
            <label class="layui-form-label"  style="color: white">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age" lay-verify="nes|age" placeholder="请输入年龄" autocomplete="off" class="layui-input" style="width: 280px">
            </div>
        </div>
        <div class="layui-form-item" style="position: relative;left: 34.5%;top: -75px;width: 40%">
            <label class="layui-form-label" style="color: #2F4056">性别</label>
            <div class="layui-input-block" style="color: #2F4056">
                <input type="radio" name="sex" value="male" title="男" >
                <input type="radio" name="sex" value="female" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="a_demo_three" style="position: relative;left: 27%;top: -70px" lay-submit="">立即提交</button>
            </div>
        </div>
        <div style="position: relative;left: 50.5%;top: -75px;width: 40%">
            <a class="a1" href="login.jsp">
                已有账号
            </a>
        </div>
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
            ,age: [/^\d+$/, "你的年龄是竟然不是数字？"]
        });
    });
</script>
</body>
</html>
