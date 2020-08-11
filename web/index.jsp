<%--
  Created by IntelliJ IDEA.
  User: MrDerek
  Date: 2020/6/24
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="resources/CSS/index.css" type="text/css">
  <link rel="stylesheet" href="resources/layui/css/layui.css">
  <title>主页</title>
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
<div style="width: 100%;height:100%">
  <div class="div1">
    <div style="position: relative;left: 27%;top: 25%;width: 50%">
      <p class="p1">
        黑 龙 江 大 学 科 技 创 新 协 会
      </p>
    </div>
    <div style="position: relative;left: 19%;top: 30%;width: 80%">
      <p class="p2">
        Heilongjiang University Science and Technology Innovation Association
      </p>
    </div>
    <div style="position: relative;left: 36.5%;top: 40%;width: 50%">
      <a href="login.jsp">
        <button class="a_demo_two">
          点击登录
        </button>
      </a>
    </div>
    <div style="position: relative;left: 45%;top: 45%;width: 40%">
      <a class="a1" href="register.jsp">
        还没账号？点击注册吧！
      </a>
    </div>
  </div>
</div>
<script src="resources/layui/layui.js"></script>
<script type="text/javascript">
  layui.use(["element"],function () {

  })
</script>
</body>
</html>
