<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>评论</title>
</head>
<body>
<form method="post" action="/commentUpLoad" enctype="multipart/form-data">

<input type="text" hidden="true" name="CommentId"/><br><br>
<input type="text" hidden="true" name="teacherUserName"/><br><br>
教师星级：<input type="text" name="teacherstar"/><br><br>
教师评论：<input type="text" name="teacherdiscription"/><br><br>
 
<input type="text" hidden="true" name="CourseId"/><br><br>
课程星级：<input type="text" name="coursestar"/><br><br>
课程评论：<input type="text" name="coursediscription"/><br><br>

 <input type="submit" value="上传"/> 
</body>
</html>