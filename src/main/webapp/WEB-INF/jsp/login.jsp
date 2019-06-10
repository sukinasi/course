<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

</script>
<meta charset="UTF-8">
<title>登陆</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="POST">

<fieldset>
<legend>login:</legend>
登陆名称：<input type="text" name="loginName" ><br>
密码：<input type="password" name="password"><br>
<input type="submit" name="submit" value="提交"><br>
<a href="${pageContext.request.contextPath}/index">首页</a>
</fieldset>
</form>

</body>
</html>