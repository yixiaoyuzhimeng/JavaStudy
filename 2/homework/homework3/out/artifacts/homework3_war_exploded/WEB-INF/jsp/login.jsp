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
    姓名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    验证码：<input type='text' name='inputCode'>
    <img src='ValidCode' width='60' height='22'><br>
<%--    <input type='checkbox' name='saveUser'>保护用户名和密码<br/>--%>
    <input type="submit" value="登录">
    <button><a value='注册' href='register.do' target='_blank'>注册</a></button>
</form>
</body>
</html>
