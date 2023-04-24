<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/13
  Time: 16:16
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
    <h1 style="color: black;">课程成绩列表</h1>
    <table class="tb">
        <tr>
            <td>学生姓名</td>
            <td>课程名称</td>
            <td>课程编号</td>
            <td>分数</td>
        </tr>
        <c:forEach items="${grade}" var="grade">
            <tr>
                <td>${grade.stu_name}</td>
                <td>${grade.course_name}</td>
                <td>${grade.cpid}</td>
                <td>${grade.grades}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>