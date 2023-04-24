
<%--
  Created by IntelliJ IDEA.
  User: yixi
  Date: 2021/11/10
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myfn" uri="http://cdu.nls/functions" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <h1>购物车</h1>
    hello,${customer.name}</br>
    ${empty customer?"<a href='login.do'>登录</a><a href='register.do'>注册</a>":"<a href='logout'>注销</a>"}
    </br><a href="list">继续购物</a><br>
    <c:if test="${!empty products}">
        <a href="cartClear">清空购物车</a>
        <table>
            <tr>
                <th>序号</th>
                <th>图片</th>
                <th>名称</th>
                <th>原格</th>
                <th>折后价</th>
                <th>购买数目</th>
                <th>移除</th>
            </tr>
            <c:forEach items="${productMap}" var="map" varStatus="s">
                <tr>
                    <td>${map.key}</td>
                    <td><img src="${map.value.imgUrl}" width="50" height="50"></td>
                    <td>${map.value.name}</td>
                    <td>${myfn:currency(map.value.price)}</td>
                    <td>${myfn:currency(map.value.salePrice)}</td>
                    <td>${productNumMap[map.key]}</td>
                    <td><a href="cartOut?productId=${map.value.id}">移出购物车</a></td>
                </tr>
            </c:forEach>
        </table>
        </br>合计：${myfn:currency(cartMoney)}<br>
        <a href="order.do">确定下单</a>
    </c:if>
</body>
</html>
