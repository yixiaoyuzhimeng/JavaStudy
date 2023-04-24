<%@ taglib prefix="myfn" uri="http://cdu.yxy/functions"%>
<%@ page contentType="text/html; cahrset=UTF-8" pageEncoding="utf-8"%>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>回复</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>回复帖子</h1>
<div class="msg">
    <div class="subject">${msg.subject}</div>
    <div class="content">${msg.content}</div>
    <div>
        <span>姓名：${msg.user.name}(${msg.user.id})</span>
        <span>日期：${myfn:formateDatetime(msg.addMsgTime)}</span>
    </div>
</div>
<form action="reply" method="post">
    <input type="text" name="id" value="${msg.id}" readonly hidden><br>
    <textarea name="reply" rows="3" cols="50"></textarea><br>
    <input type="submit" value="回复">
    <input type="reset" value="重置">
</form>

</body>
</html>