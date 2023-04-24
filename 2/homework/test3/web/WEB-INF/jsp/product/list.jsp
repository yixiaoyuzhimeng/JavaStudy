<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myfn" uri="http://cdu.nls/functions" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>显示商品</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>显示商品</h1>
<a href="product/add.do">添加商品</a>
<table>
    <caption>全部商品</caption>
    <tr>
        <th>图片</th>
        <th>id</th>
        <th>姓名</th>
        <th>价格</th>
        <th>打折比例</th>
        <th>库存</th>
        <th>时间</th>
        <th>修改</th>
        <th>删除</th>
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
            <td><a href="product/mod?id=${product.id}">修改</a></td>
            <td><a href="product/del?id=${product.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<c:if test="${page>1}">
    <a href="list?page=${page-1}">上一页</a>
</c:if>
<c:if test="${page<pageContent}">
    <a href="list?page=${page+1}">下一页</a>
</c:if>
</body>
</html>