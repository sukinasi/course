<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/Register" method="POST">

<fieldset>
<legend>register:</legend>

登陆名称：<input type="text" name="loginName" required><br>
密码：<input type="password" name="password" required><br>
邮箱：<input type="text" name="e_mail" ><br>
电话号码：<input type="text" name="phonenNumber" ><br>
地址：<input type="text" name="address" ><br>
<input type="submit" name="submit" value="提交"><br>
<a href="${pageContext.request.contextPath}/index">首页</a>
</fieldset>

</form>
</body>

</html>