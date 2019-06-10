<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>购物车</title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="/js/myjs.js">
</script>
<script>
function changeCartNum(iId)
{
	alert("#num"+iId.toString());
	$.ajax(
			{
				url:"${pageContext.request.contextPath}/user/changeCartNum",
				data:{'iId':iId,'num':$("#num").text()},
				success:function(){},
				error:function(){
					alert("操作失败~");
				}
			}
		  );
}

</script>
</head>
<body>
<form action="" method="POST">

<fieldset> 
<legend>购物车：</legend>

<c:forEach items="${list }" var="item">
<div id='${item.itemId}'>
<span>书名:${item.name}</span>&nbsp&nbsp&nbsp&nbsp&nbsp
<span>单价:${item.price}</span>&nbsp&nbsp&nbsp&nbsp&nbsp
数量：<input type="number" value="${item.num}" id="num"+"${item.itemId}" min="1" onblur="changeCartNum('${item.itemId}')">&nbsp&nbsp&nbsp&nbsp&nbsp
<span>小计:${item.price}</span>&nbsp&nbsp&nbsp&nbsp&nbsp
<button type="button" style="background-color:#fff;width:20px;height:20px" onclick="removeItem('${item.itemId}')">×</button>
<br>
</div>
</c:forEach>
<button type="submit"  formaction="${pageContext.request.contextPath}/user/order">结算</button><br>
<a href="${pageContext.request.contextPath}/index">首页</a>
</fieldset>

</form>
</body>
</html>