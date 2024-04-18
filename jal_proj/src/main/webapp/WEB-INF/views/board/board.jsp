<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" href="css/board.css">
<script src="js/board.js"></script>

<main>
	<div class="_main">
		<c:forEach items="${boardList}" var="board">
			<h2>${board.btitle}</h2>
			<hr>
			<div class="profile">
				<img src='https://ifh.cc/g/MRkSvZ.png'> ${board.uname}
			</div>
			<div class="pDate">게시일 : ${board.bdate}</div>
			<div class="ice">
				<br> ${board.btext}
		</c:forEach>
		<div id="replyForm" style="display: none;">
			<textarea id="replyTextarea" rows="5" cols="70" readonly>re</textarea>
			<button type="button" class="main_btn2" id="submitReplyButton"
				onclick="submitReply()">등록</button>
		</div>
	</div>

	<div class="btn">
		<button type="button" class="main_btn" id="sSize">
			<a href="boardList" style="color: #fff;"> 뒤로가기 </a>
		</button>
		<button type="button" class="main_btn" id="replyButton"
			onclick="showReplyForm()">답글</button>
	</div>
	</div>

</main>
