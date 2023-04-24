<%--
  Created by IntelliJ IDEA.
  User: yixi
  Date: 2021/11/10
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<h1>注册</h1>
<form action="register" method="post">
    姓名：<input type="text" name="name"><br>
<%--    <input type="text" name="name"><br>--%>
<%--    还有个什么？--%>
    密码：<input type="password" name="password"><br>
    <input type="submit" name="注册"><br>
</form>
</body>
</html>
