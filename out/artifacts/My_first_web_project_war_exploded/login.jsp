<%--
  Created by IntelliJ IDEA.
  User: MrDerek
  Date: 2020/6/25
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="resources/CSS/index.css" type="text/css">
    <link rel="stylesheet" href="resources/layui/css/layui.css">
    <title>登录</title>
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
    <div style="position: relative;left: 42.5%;top: 8%;width: 40%">
        <p style="font-family: Microsoft JhengHei;font-size: 75px;color: white">sign in</p>
    </div>
    <form class="layui-form" action="login" method="post" style="position: relative;left: 35%;top: 15%;width: 50%">
        <div class="layui-form-item">
            <label class="layui-form-label" style="color: white">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input" style="width: 280px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="color: white">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password"  placeholder="请输入密码" autocomplete="off" class="layui-input" style="width: 280px">
            </div>
        </div>
        <div class="layui-form-item" style="position: relative;left: 18%;height: 4%">
            <label class="layui-form-label" style="color: white">三天免登录</label>
            <div class="layui-input-block">
                <input type="checkbox" lay-skin="switch" name="free" value="yes">
            </div>
        </div>
        <button class="a_demo_three">
            点击登录
        </button>
        <div style="position: relative;left: 22%;top: 50%;width: 40%">
            <a class="a1" href="register.jsp">
                还没账号？点击注册吧！
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
    //Demo
    layui.use('form', function(){

    });
</script>
</body>
</html>
