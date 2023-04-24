<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/13
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../css/left.css"
</head>
<body>

<div class="leftMenu">
    <div class="menu">
        <div class="menuParent">
            <div class="ListTitlePanel">
                <div class="ListTitle">
                    <strong>教师菜单</strong>
                    <div class="leftbgbt"></div>
                </div>
            </div>
            <div class="menuList">
                <div><a target="main_right" href="addCourse.jsp">添加课程信息</a></div>
                <div><a target="main_right" href="updateTeacher.jsp">修改个人信息</a></div>
                <div><a target="main_right" href="teacherServlet?method=liulanstu">浏览选课学生信息</a></div>
                <div><a target="main_right" href="addGrades.jsp">录入成绩</a></div>
            </div>
        </div>


    </div>
</div>

<script type="text/javascript">



</script>

</body>
</html>
