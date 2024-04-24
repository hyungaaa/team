<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/ui.css">
<link rel="stylesheet" href="css/common.css">


<script src="js/system.js"></script>

<title><tiles:insertAttribute name="title" /></title>

</head>
<body>
		<tiles:insertAttribute name="body" />
</body>
</html>