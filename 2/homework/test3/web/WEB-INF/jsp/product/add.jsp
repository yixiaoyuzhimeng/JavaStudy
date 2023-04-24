<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8">
    <title>添加商品</title>
</head>
<body>
<h1>添加商品</h1>
<%--路径问题？--%>
<form action="product/add" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="name"><br>
    价格：<input type="text" name="price"><br>
    折扣：<input type="text" name="sale"><br>
    库存：<input type="text" name="stock"><br>
    图片：<input type="file" name="img"><br>
    简介：<textarea name="info" rows="10" cols="50"></textarea><br/>
    <input type="submit" name="添加"><br>
    <input type="reset" name="重置"><br>
</form>
</body>
</html>