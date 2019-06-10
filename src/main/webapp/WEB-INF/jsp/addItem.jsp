<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加物品</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/addItem">
<fieldset>
<legend>添加物品</legend>
书名：<input type="text" name="name"><br>
价格：<input type="number" name="price"><br>
数量：<input type="number" name="reserve"><br>
<button type="submit" >提交</button>
</fieldset>
</form>
</body>
</html>