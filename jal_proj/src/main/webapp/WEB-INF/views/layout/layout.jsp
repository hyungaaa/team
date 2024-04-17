<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="${path}/css/layout.css">
<link rel="stylesheet" href="${path}/css/ui.css">
<link rel="stylesheet" href="${path}/css/common.css">
<link rel="stylesheet" href="${path}/css/dashboard.css">

<script src="${path}/js/hello.js"></script>
<script src="${path}/js/chart.js"></script>
<script src="${path}/js/system.js"></script>
<script src="${path}/js/dashboard.js"></script>

<title><tiles:insertAttribute name="title" /></title>

</head>
<body>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="side" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
</body>
</html>