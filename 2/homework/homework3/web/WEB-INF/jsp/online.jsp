<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>在线用户</title>
    <base href=${"http://"+=header.host+=pageContext.request.contextPath+="/"}/>
</head>
<body>
<h2>当前在线用户：${fn:length(applicationScope.online)}</h2>
<c:forEach items="${online}" var="user" varStatus="s">
    <p>${user.id} ${user.name}</p>
</c:forEach>
</body>
</html>