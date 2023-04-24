<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<h1>用户登录成功</h1>
<h1>欢迎你，${username}</h1>
<a href='logout'>注销</a>
</body>
</html>
