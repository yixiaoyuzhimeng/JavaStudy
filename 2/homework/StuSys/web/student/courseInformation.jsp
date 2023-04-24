<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/12/13
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程信息详情</title>
    <style>
        .a{
            margin-top: 20px;
        }
        .b{
            font-size: 20px;
            width: 160px;
            color: white;
            background-color: greenyellow;
        }
        .tb, td {
            border: 0px solid black;
            font-size: 22px;
        }
    </style>
</head>

<body>

<div align="center">
    <h1 style="color: black;">课程详细信息</h1>
    <table class="tb">
        <tr>
            <td>课程编号</td>
            <td>课程名称</td>
            <td>课程容量</td>
            <td>课程选课人数</td>
            <td>任课教师</td>
        </tr>
        <tr>
            <td>${cou.cpid}</td>
            <td>${cou.cname}</td>
            <td>${cou.num}</td>
            <td>${cou.snum}</td>
            <td>${cou.jiaoshi}</td>
        </tr>
    </table>

    <table align="center" border="0px" cellpadding="10px" cellspacing="10px">
        <form action="courseServlet?method=xuanke"  method="post"  onsubmit="return check()">
            <tr>
                <td><input type="hidden" name="cpid" id="cpid" value="${cou.cpid}"></td>
            </tr>

            <tr>
                <td><input type="hidden" name="snum" id="snum" value="${cou.snum}"></td>
            </tr>

            <tr>
                <td><input type="hidden" name="jiaoshi" id="jiaoshi" value="${cou.jiaoshi}"></td>
            </tr>

            <tr align="center">
                <th colspan="2">
                    <input type="submit" value="选课">
                </th>
            </tr>
        </form>
    </table>
</div>

</body>
</html>
