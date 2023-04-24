<%@ page import="cdu.yxy.app.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>修改</title>
</head>
<body>
<h1>修改</h1>
<%
    User user=(User) request.getAttribute("user");
%>
<form action="<%=request.getContextPath()%>/user/mod" method="post">
    id:<input type="text" name="id" value="<%=user.getId()%>" readonly><br/>
    姓名：<input type="text" name="username" value="<%=user.getName()%>"><br/>
    密码：<input type="password" name="password" value="<%=user.getPassword()%>"><br/>
    性别：<input type="radio" name="sex" value="男" <%=user.getSex().equals("男")?"checked":"" %>>男
    <input type="radio" name="sex" value="女" <%=user.getSex().equals("女")?"checked":"" %> >女<br/>
    爱好：<input type="checkbox" name="hobby" value="篮球" <%=user.getHobby().contains("篮球")?"checked":"" %> >篮球
    <input type="checkbox" name="hobby" value="游泳" <%=user.getHobby().contains("游泳")?"checked":"" %> >游泳
    <input type="checkbox" name="hobby" value="跑步" <%=user.getHobby().contains("跑步")?"checked":"" %> >跑步
    <input type="checkbox" name="hobby" value="阅读" <%=user.getHobby().contains("阅读")?"checked":"" %> >阅读<br/>
    <input type="submit" value="修改">
    <input type="reset" value="重置">
</form>
</body>
</html>
