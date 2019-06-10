<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
首页<br>
<c:if test="${user==null}">
<div>
<a href="${pageContext.request.contextPath}/login">登陆</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="${pageContext.request.contextPath}/register">注册</a>
</div>
</c:if>
<div>
<c:forEach items="${list }" var="item">
<a href="${pageContext.request.contextPath}/item?id=${item.id}">书名：${item.name }&nbsp&nbsp&nbsp价格：${item.price }</a><br>
</c:forEach>
</div>
<a href="${pageContext.request.contextPath}/user/cart">购物车</a><br>
</body>
</html>