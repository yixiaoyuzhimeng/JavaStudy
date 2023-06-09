<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/5
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>教师中心</title>
    <link rel="stylesheet" href="../css/pintuser.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery.js"></script>
</head>

<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="../images/头像.JPG" class="radius-circle rotate-hover" height="50" alt="" />你好：${userName}</h1>
    </div>
    <div class="head-l"> <a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span>
        清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="/view/login.jsp"><span
            class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>系统管理</h2>
    <ul style="display:block">

        <li><a href="/view/courseList" target="right"><span
                class="icon-caret-right"></span>课程管理</a></li>
        <li><a href="/view/teaScoreList" target="right"><span
                class="icon-caret-right"></span>学生管理</a></li>

    </ul>

</div>
<script type="text/javascript">
    $(function () {
        $(".leftnav h2").click(function () {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function () {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文</span></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="" name="right" width="100%" height="100%"></iframe>
</div>

</body>

</html>
