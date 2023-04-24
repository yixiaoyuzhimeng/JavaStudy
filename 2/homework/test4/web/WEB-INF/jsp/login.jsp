<%@ page contentType="text/html; cahrset=UTF-8" pageEncoding="utf-8"%>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>登录</title>
</head>
<body>
<h1>用户登录</h1>
<form action="login" method="post">
    姓名：<input type="text" name="name"><br>
    密码：<input type="text" name="password"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>