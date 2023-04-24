<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>简易教务系统</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<!-- contact-form -->
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>欢迎登录简易教务系统</h1>
            <div class="alert-close"></div>
        </div>
        <form action="/login" method="post">
            <input type="hidden" name="method" value="login">
            <li>选择身份<input name="role" type="radio" value="student">学生
                <input name="role" type="radio" value="teacher">教师</li>
            <div class="clear"></div>
            <li><input name="name" type="text" class="text"
                       value="账户"><a
                    href="#" class=" icon user"></a></li>
            <div class="clear"></div>
            <li><input name="password" type="password" value="密码">
                <a href="#" class="icon lock"></a></li>
            <div class="clear"></div>
            <li><input type="text" name="inputCode" value="验证码"><img src="/validCode"></li>
            <div class="clear"></div>
            <div class="submit">
                <input type="submit" value="登录">
                <div class="clear"></div>
            </div>
        </form>
    </div>
</div>

<div class="clear"></div>
<!--- footer --->
<div class="footer">
    <p>Made by xian</p>
</div>
</body>
</html>
