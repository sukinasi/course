<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/changeInfo">
<fieldset>
<legend>个人信息：</legend>
登陆名称：<input type="text" name="loginName" value="${user.loginName}" readonly><br>
电话号码：<input type="text" name="phoneNumber" value="${user.phoneNumber}"><br>
邮箱：<input type="text" name="e_mail" value="${user['e_mail'] }"><br>
地址：<input type="text" name="address"value="${user.address }"><br>
加入时间：<input type="text" name="joinDate" value="${user.joinDate}" readonly><br>
<input type="submit" name="submit" value="提交更改"><br>
<a href="${pageContext.request.contextPath}/index">首页</a>
</fieldset>
</form>
</body>
</html>
