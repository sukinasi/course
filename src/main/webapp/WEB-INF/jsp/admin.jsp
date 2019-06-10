<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台</title>
</head>
<body>
后台管理系统：<br>
<a href="${pageContext.request.contextPath}/admin/addItem?create">添加图书信息</a>
<a href="${pageContext.request.contextPath}/admin/search">查询图书</a>
</body>
</html>