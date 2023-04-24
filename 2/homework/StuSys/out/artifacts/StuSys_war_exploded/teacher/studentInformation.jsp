<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/13
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

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
<div align="center">
    <h1 style="color: black;">课程信息列表</h1>
    <table class="tb">
        <tr>
            <td>学生学号</td>
            <td>学生姓名</td>
            <td>学生性别</td>
            <td>学生所在班级</td>
            <td>学生专业</td>
            <td>课程名称</td>
            <td></td>
        </tr>
        <c:forEach items="${jibens}" var="item" >
            <tr>
                <td>${item.spid}</td>
                <td>${item.stuname}</td>
                <td>${item.sex}</td>
                <td>${item.banji}</td>
                <td>${item.ye}</td>
                <td>${item.cname}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
