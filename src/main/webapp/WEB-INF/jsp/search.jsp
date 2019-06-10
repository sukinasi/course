<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询图书</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/searchByName">
请输入要查询的书籍的名字：<br>
<input type="text" name="name"><br>
<input type="submit"  value="检索">
</form>
</body>
</html>