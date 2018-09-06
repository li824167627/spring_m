<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="SERVER_PATH" value="${pageContext.request.contextPath}"></c:set>
<c:set var="SERVER_PATH_resources"
	value="${pageContext.request.contextPath}/resources"></c:set>

<script type="text/javascript">
	var SERVER_PATH = '${SERVER_PATH}';
	var SERVER_PATH_Resources = '${SERVER_PATH_resources}';
</script>

<meta charset="utf-8" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,  minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />



