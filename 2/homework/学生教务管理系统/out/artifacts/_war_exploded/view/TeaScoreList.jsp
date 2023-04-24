<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/5
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
<%--    <link rel="stylesheet" href="../css/pintuser.css">--%>
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery.js"></script>
<%--    <script src="../js/pintuer.js"></script>--%>

</head>
<body>
<form method="post" action="/view/delChoose" id="form1">
    <div class="panel admin-panel">
        <div class="panel-head">
            <strong class="icon-reorder">成绩</strong>
        </div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>

                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th>课程编号</th>
                <th>课程名称</th>
                <th>授课老师</th>
                <th>学生学号</th>
                <th>学生姓名</th>
                <th>成绩</th>
                <th>更改</th>
                <th>删除</th>
            </tr>


            <c:forEach items="${chooseList}" var="choose" varStatus="s">
                <tr>
                    <td>${choose.courseId}</td>
                    <td>${choose.courseName}</td>
                    <td>${choose.teacherName}</td>
                    <td>${choose.studentId}</td>
                    <td>${choose.studentName}</td>
                    <td>${choose.score}</td>
                        <%--                        <td><a href="/view/mod?id=${choose.id}?"><input type="button" value="修改" ></a></td>--%>
                    <td><input type="button" id="n" value="修改" onclick="prom(${choose.id})"></td>
                    <td><input type="checkbox" name="IfDel" value="${choose.id}"></td>
                </tr>
            </c:forEach>

        </table>
        <div class="check">
            <input type="submit" id="submit" value="提交">
        </div>
    </div>
</form>
<script type="text/javascript">
    function del(id) {
        if (confirm("您确定要删除吗?")) {
            window.location.href="userServlet?method=deleteUser&user_id="+id
        }
    }
    function prom(id)
    {
        var name=prompt("请输入成绩","");//将输入的内容赋给变量 name ，
        //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值
        if(name)//如果返回的有内容
        {
            // document.getElementById("n").href("/view/mod?id=" + id + "&name=" + name);
            window.location.href="/view/mod?id=" + id + "&name=" + name;
        }
    }
</script>
</body>
</html>