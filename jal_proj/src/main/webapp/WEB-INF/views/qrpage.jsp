<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title></title>
</head>
<body>

	<table class="qr_table" style="text-align:center">

      <tr>
          <th>제품번호 :</th>
          <td colspan="2"><span>${qrNum}</span> </td>
      </tr>
  	</table>
	<img src="download?fileName=${qr }">
</body>
</html>
