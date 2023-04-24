<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20992
  Date: 2021/1/13
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
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
<form method="post" action="/view/addChoose.do" id="form1">
    <div class="panel admin-panel">
        <div class="panel-head">
            <strong class="icon-reorder">选课</strong>
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
                    <td><input type="checkbox" name="IfChoose" value="${course.name}"></td>
                </tr>
            </c:forEach>
        </table>
        <div class="check">
            <input type="submit" id="btnSubmit" value="提交">&nbsp;
            <input type="reset" id="btnReset" value="重置">
        </div>
    </div>
</form>
<script type="text/javascript">
    function del(id) {
        if (confirm("您确定要删除吗?")) {
            window.location.href="userServlet?method=deleteUser&user_id="+id
        }
    }

    var num = 1;
    $("#checkall").click(function() {
        $("input[name='id[]']").each(function() {
            if (num % 2 == 1) {
                this.checked=true;
            }else {
                this.checked=false;
            }
        });
        num++;
    })

    $("#batchDel").click(function(){
        if(confirm("你确定要批量删除吗?")){
            $("#form1").submit();
        }
    })
</script>
</body>
</html>