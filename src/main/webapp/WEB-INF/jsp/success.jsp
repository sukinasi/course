<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>操作成功</title>
</head>
<body>
<br>
<c:if test="${msg!=null}">
${msg}<br>
</c:if>
<a href="${url}">返回</a>
</body>
</html>