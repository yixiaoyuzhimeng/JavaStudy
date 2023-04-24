<%--
  Created by IntelliJ IDEA.
  User: yixi
  Date: 2021/11/10
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<h1>用户登录</h1>
<form action="login" method="post">
    姓名：<input type="text" name="name">
    密码：<input type="password" name="password">
    <input type="submit" value="登录">
</form>
</body>
</html>
