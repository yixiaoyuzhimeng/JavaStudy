<%--
  Created by IntelliJ IDEA.
  User: yixi
  Date: 2021/11/10
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myfn" uri="http://cdu.nls/functions" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>支付</title>
    <Link href="css/style" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>支付页面</h1>
    ${customer.name}
    ${empty customer?"<a href='login.do'>登录</a><a href='register.do'>注册</a>":"<a href='logout'>注销</a> "}
    </br><a href="list">返回购物</a><br>
    <c:if test="${!empty order}">
        <hr>
        订单号：${order.orderId}<br>
        订单花费：${order.money}<br>
        订单名称：${order.name}<br>
        订单地址：${order.address}<br>
        订单电话：${order.tel}<br>
        订单状态：${order.status}<br>
        订单时间：${myfn:formatDatetime(order.createTime)}<br>
        <hr>
    </c:if>
    <c:if test="${order.statusCode==0}">
        <a href="pay?orderId=${order.orderId}">支付</a><br>
        <a href="orderCancel?orderId=${order.orderId}">取消订单</a><br>
    </c:if>
</body>
</html>
