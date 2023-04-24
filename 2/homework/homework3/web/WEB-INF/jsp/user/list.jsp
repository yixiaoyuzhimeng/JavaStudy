<%@ page import="cdu.yxy.app.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>显示</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        th {
            text-align: center;
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {background-color: #f2f2f2;}
    </style>
</head>
<body>
<%--不明白这个路径，还有*.do的作业--%>
<a href="add.do">添加用户</a>
<table>
    <caption>用户列表</caption>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>sex</th>
        <th>hobby</th>
        <th>操作</th>
    </tr>
    <%
        List<User> userList =(List<User>) request.getAttribute("userList");
        for(User user: userList){
    %>
    <tr>
        <td><%=user.getId()  %></td>
        <td><%=user.getName()  %></td>
        <td><%=user.getPassword()  %></td>
        <td><%=user.getSex()  %></td>
        <td><%=user.getHobby()  %></td>
        <td>
            <a href="mod?id=<%=user.getId()%>">修改</a>
            <a href="del?id=<%=user.getId()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%
    int p= (int) request.getAttribute("page");
    int pageSize=(int) request.getAttribute("pageSize");
    int count = (int) request.getAttribute("count");
    int pageNum=(int) request.getAttribute("pageNum");
%>

一共<%=count %>条
每页<%=pageSize %>条
这是第<%=p %>/<%=pageNum %>页
<% if (p>1){ %>
<a href="list?page=<%=p-1%>">上一页</a>
<% } %>
<% if (p<pageNum) {%>
<a href="list?page=<%=p+1%>">下一页</a>
<% } %>


</body>
</html>