<%--
  Created by IntelliJ IDEA.
  User: yixi
  Date: 2021/11/10
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myfn" uri="http://cdu.nls/functions" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>商品列表</h1>
${empty customer?"<a href='login.do'>登录</a>/<a href='register.do'>注册</a>":"<a href='cart'>查看购物车</a>/<a href='logout'>注销</a>"}
<table>
    <tr>
        <th>商品图</th>
        <th>id</th>
        <th>商品名称</th>
        <th>价格</th>
        <th>打折比例</th>
        <th>库存</th>
        <th>上架时间</th>
        <th>选入购物车</th>
    </tr>
    <c:forEach items="${productList}" var="product" varStatus="s">
        <tr>
            <td><img src="${product.imgUrl}" width="50" height="50"></td>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${myfn:currency(product.price)}</td>
            <td>${product.sale}</td>
            <td>${product.stock}</td>
            <td>${myfn:formatDate(product.marketDate)}</td>
            <td>
                <c:if test="${product.stock>0}">
                    <a href="cartIn?productId=${product.id}">选入购物车</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<c:if test="${page>1}">
    <a href="list?page=${page-1}">上一页</a>
</c:if>
<c:if test="${page<pageCount}">
    <a href="list?page=${page+1}">下一页</a>
</c:if>
</body>
</html>
