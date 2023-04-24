<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/5
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<table class="course" align="center">
    <div class="courseContent">
        <form action="/view/addCourse.do" method="post">
            <tr>
                <td>课程编号:<input type="text" name="courseId" id="courseId"></td>
            </tr>
            <tr>
                <td>课程名称:<input type="text" name="courseName" id="courseName"></td>
            </tr>
            <tr>
                <td>授课教师:<input type="text" name="teacherName" id="teacherName"></td>
            </tr>
            <tr align="center">
                <th colspan="2">
                    <input type="submit" value="提交">
                    <input type="reset" value="重置">
                </th>
            </tr>
        </form>
    </div>
</table>
</body>

</html>