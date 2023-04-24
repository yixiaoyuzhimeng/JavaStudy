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
    密码：<input type="password" name="password"><br>
    性别：<input type="radio" name="sex" value="男" checked>男
    <input type="radio" name="sex" value="女">女<br/>
    爱好：<input type="checkbox" name="hobby" value="篮球">篮球
    <input type="checkbox" name="hobby" value="游泳">游泳
    <input type="checkbox" name="hobby" value="跑步">跑步
    <input type="checkbox" name="hobby" value="阅读">阅读<br/>
    <input type="submit" name="注册"><br>
    <input type="reset" value="重置">
</form>
</body>
</html>
