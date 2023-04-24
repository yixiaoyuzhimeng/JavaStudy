<%--
  Created by IntelliJ IDEA.
  User: yixi
  Date: 2021/11/10
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myfn" uri="http://cdu.nls/functions" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>确认订单</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>确认订单</h1>
hello,${customer.name}</br>
${empty customer?"<a href='login.do'>登录</a><a href='register'>注册</a>":"<a href='logout'>注销</a>/"}
<a href="list">取消订单，返回购物</a>
<c:if test="${!empty products}">
    <table>
        <tr>
            <th>订单号</th>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>价格</th>
            <th>现价</th>
            <th>购买数量</th>
        </tr>
    <c:forEach items="${productMap}" var="map" varStatus="s">
        <tr>
            <td>${map.key}</td>
            <td><img src="${map.value.imgUrl}" width="50" height="50"></td>
            <td>${map.value.name}</td>
            <td>${myfn:currency(map.value.price)}</td>
            <td>${myfn:currency(map.value.salePrice)}</td>
            <td>${productNumMap[map.key]}</td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="6">总价：${myfn:currency(cartMoney)}</th>
    </tr>
    </table>
    <form action="order" method="get">
        收货人：<input type="text" name="name"/><br>
        电话：<input type="text" name="tel"/><br>
        地址：<input type="text" name="address"/><br>
        <input type="submit" name="提交订单，准备支付"/><br>
    </form>
</c:if>

</body>
</html>
