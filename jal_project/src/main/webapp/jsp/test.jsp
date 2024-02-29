<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List list = (List) request.getAttribute("list"); %>
<%
	for(int i=0; i<7; i++) {
		out.println(list.get(i));
	}
%>

</body>
</html>