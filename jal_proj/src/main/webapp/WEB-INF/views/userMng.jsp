<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" href="${path}/css/userMng.css">
<script src="${path}/js/userMng.js"></script>
<script src="${path}/js/system.js"></script>
<script src="${path}/js/hello.js"></script>

<main>
	<div style="width: 1080px;">
		<select id="searchSelect" class="main_search_txt"
			style="float: left; width: 100px; margin-left: 30px; margin-top: 30px;">
			<option>센터 검색</option>
			<option value="천안">천안</option>
			<option value="아산">아산</option>
			<option value="평택">평택</option>
		</select>
		<div id="div_yn">
			<button onclick="openPopup()" class="main_btn">권한 요청 목록</button>
			<button onclick="openPopup()" id="num1">2</button>
			<div id="popup" class="popup">
				<div class="popup-content div_scr">
					<p class="userMng_p">사용자 요청 목록</p>
					<table id="table_hd2">
						<colgroup>
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="20%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr id="pop_tr">
								<th>요청사항</th>
								<th>사원번호</th>
								<th>아이디</th>
								<th>이메일</th>
								<th>선택</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty reqList}">
								<c:forEach items="${reqList}" var="user2">
									<tr>
										<td>${user2.rcategory}</td>
										<td>${user2.unum}</td>
										<td>${user2.uuid}</td>
										<td>${user2.uemail}</td>
										<td><input type="checkbox" class="chk"></td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty userInfoAndReqList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:if>
						</tbody>
					</table>
					<br> <span class="popY">승인</span> <span class="popN"
						onclick="closePopup()">취소</span>
				</div>
			</div>
		</div>
		<div class="div_scr">
			<table id="table_cap">
				<colgroup>
					<col width="2%">
					<col width="9%">
					<col width="9%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="9%">
					<col width="9%">
					<col width="9%">
					<col width="9%">
					<col width="9%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th></th>
						<th>이름</th>
						<th>사원번호</th>
						<th><select id="select_change1" class="table_normal_txt"
							style="width: 50px; height: 25px;">
								<option>센터</option>
								<option value="천안" class="select_op1">천안</option>
								<option value="아산" class="select_op1">아산</option>
								<option value="평택" class="select_op1">평택</option>
						</select>
							<button type="button" id="change_button1" class="table_btn"
								style="padding: 6rem;">변경</button></th>
						<th><select id="select_change2" class="table_normal_txt"
							style="width: 50px; height: 25px;">
								<option>권한</option>
								<option value="사원" class="select_op2">사원</option>
								<option value="대리" class="select_op2">대리</option>
								<option value="팀장" class="select_op2">팀장</option>
								<option value="관리자" class="select_op2">관리자</option>
						</select>
							<button type="button" id="change_button2" class="table_btn"
								style="padding: 6rem;">변경</button></th>
						<th>제품조회<input type="checkbox" id="select_all1"></th>
						<th>입/출고등록<input type="checkbox" id="select_all2"></th>
						<th>입/출고수정<input type="checkbox" id="select_all3"></th>
						<th>제품등록<input type="checkbox" id="select_all4"></th>
						<th>게시판수정<input type="checkbox" id="select_all5"></th>
						<th>사용자관리<input type="checkbox" id="select_all6"></th>
						<th>
							<button type="button"
								style="padding: 4rem; border: 0px solid #888; color: #ffffff; border-radius: 5rem; background: #36698c;">전체적용</button>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty infoPower}">
							<tr>
								<td colspan="11">데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${infoPower}" var="user">
								<tr>
									<td><input type="checkbox" class="select_chk"></td>
									<td>${user.uname}</td>
									<td>${user.unum}</td>
									<td><select class="main_search2_txt"
										style="width: 90px; height: 20px;">
											<option value="천안" ${user.cname == '천안' ? 'selected' : ''}>천안</option>
											<option value="아산" ${user.cname == '아산' ? 'selected' : ''}>아산</option>
											<option value="평택" ${user.cname == '평택' ? 'selected' : ''}>평택</option>
									</select></td>
									<td><select class="main_search2_txt"
										style="width: 90px; height: 20px;">
											<option value="사원"
												${user.uposition == '사원' ? 'selected' : ''}>사원</option>
											<option value="대리"
												${user.uposition == '대리' ? 'selected' : ''}>대리</option>
											<option value="팀장"
												${user.uposition == '팀장' ? 'selected' : ''}>팀장</option>
											<option value="관리자"
												${user.uposition == '관리자' ? 'selected' : ''}>관리자</option>
									</select></td>
									<td><input type="checkbox"
										${user.updv == '1' ? 'checked' : ''}></td>
									<td><input type="checkbox"
										${user.updior == '1' ? 'checked' : ''}></td>
									<td><input type="checkbox"
										${user.updiom == '1' ? 'checked' : ''}></td>
									<td><input type="checkbox"
										${user.updr == '1' ? 'checked' : ''}></td>
									<td><input type="checkbox"
										${user.ubdm == '1' ? 'checked' : ''}></td>
									<td><input type="checkbox"
										${user.uum == '1' ? 'checked' : ''}></td>
									<td><form action="${path}/deleteUser" method="POST">
											<input type="hidden" name="uuid" value="${user.uuid}">
											<button type="submit" class="main_btn2" style="padding: 4px;">삭제</button>
										</form>
										<button type="button" class="main_btn" style="padding: 4px;">수정</button>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 성공 메시지 표시 -->
	<c:if test="${not empty message}">
		<div style="color: green;">${message}</div>
	</c:if>

	<!-- 오류 메시지 표시 -->
	<c:if test="${not empty errorMessage}">
		<div style="color: red;">${errorMessage}</div>
	</c:if>
</main>
