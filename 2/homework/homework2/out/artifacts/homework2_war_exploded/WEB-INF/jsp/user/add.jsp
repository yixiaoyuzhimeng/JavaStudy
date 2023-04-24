<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html lang=""en>
<head>
    <meta charst="utf-8">
    <title>添加</title>
</head>
<body>
<h1>添加</h1>
<form action="<%=request.getContextPath()%>/user/add" method="post">
    姓名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    性别：<input type="radio" name="sex" value="男" checked>男
        <input type="radio" name="sex" value="女">女<br/>
    爱好：<input type="checkbox" name="hobby" value="篮球">篮球
    <input type="checkbox" name="hobby" value="游泳">游泳
    <input type="checkbox" name="hobby" value="跑步">跑步
    <input type="checkbox" name="hobby" value="阅读">阅读<br/>
    <input type="submit" value="添加">
    <input type="reset" value="重置">
</form>
</body>
</html>