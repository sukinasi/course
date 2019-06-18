<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除评论</title>
</head>
<body>
<form method="post" action="/deleteComment" enctype="multipart/form-data">
<input type="text" hidden="true" name="CourseId"/>
 <input type="submit" value="删除我这条评论"/> 
</body>
</html>