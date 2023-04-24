<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/13
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改教师信息</title>
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
    <form action="teacherServlet?method=updatetea"  method="post"  onsubmit="return check()">

        <tr>
            <td>教师姓名：</td>
            <td><input type="text" name="teaname" id="teaname"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <select name="sex">
                    <option value="" selected="selected"  hidden="hidden">请选择</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>教师所在学院：</td>
            <td><input type="text" name="txueyuan" id="txueyuan"></td>
        </tr>
        <tr>
            <td>职称：</td>
            <td>
                <select name="zhicheng">
                    <option value="" selected="selected" hidden="hidden">请选择</option>
                    <option value="教授">教授</option>
                    <option value="副教授">副教授</option>
                    <option value="讲师">讲师</option>
                    <option value="助教">助教</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password" id="password" ></td>
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
