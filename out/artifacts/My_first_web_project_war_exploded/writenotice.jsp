<%--
  Created by IntelliJ IDEA.
  User: MrDerek
  Date: 2020/7/24
  Time: 18:11
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
    <title>写通知</title>
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
    <div style="position: relative;top: 1%">
        <p style="position: relative;left: 42%;font-size: 35px;color: #FFB800;width: 40%"><i class="layui-icon layui-icon-email" style="font-size: 35px; color: #FFB800;"></i>&ensp;发布通知</p>
    </div>
    <form class="layui-form layui-form-pane" action="notice" style="position: relative;top: 3%">
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block">
                <input type="text" autocomplete="off" placeholder="请输入标题" class="layui-input " name="topic">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">正文</label>
            <div class="layui-input-block">
                <textarea name="content" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <div style="position: relative;left: 47%;width: 50%">
            <input type="submit" class="layui-btn layui-btn-normal layui-btn-radius" value="提交">
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
            ,age: [/[\d]+/, "你的年龄是竟然不是数字？"]
        });
    });
</script>
</body>
</html>
