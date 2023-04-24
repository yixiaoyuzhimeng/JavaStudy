<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/13
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>录入学生成绩</title>
    <script>
    </script>
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
    <form action="teacherServlet?method=addgrades"  method="post"  onsubmit="return check()">

        <tr>
            <td>课程编号：</td>
            <td><input type="text" name="cpid" id="cpid"></td>
        </tr>
        <tr>
            <td>课程名称：</td>
            <td><input type="text" name="course_name" id="course_name"></td>
        </tr>

        <tr>
            <td>学生姓名：</td>
            <td><input type="text" name="stu_name" id="stu_name"></td>
        </tr>
        <tr>
            <td>分数：</td>
            <td><input type="text" name="grades" id="grades"></td>
        </tr>

        <tr align="center">
            <th colspan="2">
                <input type="submit" value="提交">
            </th>
        </tr>
    </form>
</table>
</body>
</html>


