<%--
  Created by IntelliJ IDEA.
  User: MrDerek
  Date: 2020/6/26
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8;" />
    <link rel="stylesheet" href="resources/CSS/index.css" type="text/css">
    <link rel="stylesheet" href="resources/CSS/home.css" type="text/css">
    <link rel="stylesheet" href="resources/layui/css/layui.css">
    <title>用户管理</title>
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
    <div>
        <p style="position: relative;left: 45%;font-size: 35px;color: #009688;width: 40%">用户管理</p>
    </div>
    <table align="center" class="layui-table" border="1px" cellspacing='0'>
        <tr>
            <td>用户名</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="st">
            <tr>
                <td>${user.username}</td>
                <td>${user.name}</td>
                <td>${user.sex}</td>
                <td>${user.age}</td>
                <td><button type="button" class="layui-btn layui-btn-sm layui-bg-red"><a href="delete?id=${user.id}"><i class="layui-icon" style="color: white">&#xe640;</i></a></button></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" align="center">
                <a href="?start=0">[首  页]</a>
                <span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</span>
                <a href="?start=${pre}"><i class="layui-icon" style="color: #01AAED;">&#xe65a;</i></a>
                <span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</span>
                <a href="?start=${next}"><i class="layui-icon" style="color: #01AAED;">&#xe65b;</i></a>
                <span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</span>
                <a href="?start=${last}">[末  页]</a>
            </td>
        </tr>
    </table>
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
