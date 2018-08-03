<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/item/queryItem.action" method="post"></form>
查询条件：
<table width="100%" border=1>
<tr>
<td>
<input type="submit" value="查询">
</td>
</tr>
</table>
商品列表:
<table width="100%" border=1>
<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
</tr>
<c:forEach items="{itemsList}" var="item">
<tr>
	<td>${item.Id}</td>
	<td>${item.UserId}</td>
	<td>${item.Number}</td>
	<td>${item.Createtime}</td>
	<td>${item.Note}</td>
	
	<td><a herf="${pagecontext.request.contextpath}/item/editItem.action?id=${item.id}">修改</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>