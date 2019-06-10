<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>

<script>
</script>

</head>
<body>

<form method="GET" id="form">

<fieldset> 

<legend>item:</legend>

书名:${item.name}<br>
价格:${item.price}<br>
库存:${item.reserve }<br>
<input type="hidden" name="itemId" value="${item.id }">
<input type="hidden" name="name" value="${item.name }">
<input type="hidden" name="price" value="${item.price }">
数量：<input type="number" name="num" value="1" min="1" max="${item.reserve}">
<button type="submit"   formaction="${pageContext.request.contextPath}/user/addToCart">添加到购物车</button>
<button type="submit"  formaction="">立即选购</button><br>
<a href="${pageContext.request.contextPath}/user/cart">购物车</a><br>
<a href="${pageContext.request.contextPath}/index">首页</a>
</fieldset>

</form>

</body>
</html>