<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/13
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>
<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%} %>
<table align="center" border="0px" cellpadding="10px" cellspacing="10px">
    <form action="loginServlet?method=login"  method="post"  onsubmit="return check()">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr align="center">
            <th colspan="2">
                <input type="submit" value="登录">
            </th>
        </tr>
        <tr align="center">
            <th colspan="2">
                <span style="font-size: 10px; font-weight: normal">注：初始密码均为123456</span>
            </th>
        </tr>
    </form>
</table>
</body>
</html>
