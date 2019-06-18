<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看评论</title>
</head>
<body>
<form method="post" action="/checkTeacherComment" enctype="multipart/form-data">
<input type="text" hidden="true" name="teacherUserName"/>
 <input type="submit" value="查看教师评论"/> 
</body>
</html>