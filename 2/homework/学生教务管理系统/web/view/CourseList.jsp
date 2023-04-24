<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/5
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../css/pintuser.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery.js"></script>
    <script src="../js/pintuer.js"></script>

</head>

<body>
<form method="post" action="/view/del.do" id="form1">
    <div class="panel admin-panel">
        <div class="panel-head">
            <strong class="icon-reorder">课程管理</strong>
        </div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <td>课程编号</td>
                <td>课程名称</td>
                <td>授课教师</td>
                <td>选择</td>
            </tr>
            <c:forEach items="${courseList}" var="course" varStatus="s">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.teacherName}</td>
                    <td><input type="checkbox" name="IfDel" value="${course.name}"></td>
                </tr>
            </c:forEach>
        </table>
        <div class="check">
            <a href="NewCourse.jsp"><input type="button" id="btnCreate" value="创建"></a>
            <input type="submit" id="btnDelete" value="删除">
        </div>
    </div>
</form>
</body>

</html>