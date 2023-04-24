<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<html>
<head>
<%--    <base href="http://${header.host}${pageContext.request.contextPath}/"/>--%>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>修改商品</title>
</head>
<body>
<h1>修改商品</h1>
<%--路径问题？--%>
<form action="product/mod" method="post" enctype="multipart/form-data">
    id:<input type="text" name="id" value="${product.id}" readonly><br>
    名称:<input type="text" name="name" value="${product.name}" ><br>
    价格:<input type="text" name="price" value="${product.price}" ><br>
    售价:<input type="text" name="sale" value="${product.sale}" ><br>
    库存:<input type="text" name="stock" value="${product.stock}" ><br>
    图片:<img src="${product.imgUrl}" width="50" height="50"/><input type="file" name="img"><br>
    简介:<textarea name="info" rows="10" cols="50">${product.info}</textarea><br/>
    <input type="submit" name="修改"><br>
    <input type="reset" name="重置"><br>
</form>
</body>
</html>