<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="css/itemMng.css">


<script src="js/system.js"></script>
<!-- <script src="js/item.js"></script> -->
<script src="js/itemnew.js"></script>


<main>
	<!-- 새로운 제품 추가 창 -->

	<!-- 대분류 카테고리 -->
	<div id="bigCategory">
		<ul>
			<li><a href="itemMng"><span class="mng_span">간편식사</span>></a></li>
			<li><a href="itemMng2"><span class="mng_span">과자류</span>></a></li>
			<li><a href="itemMng3"><span class="mng_span">아이스크림</span>></a></li>
			<li><a href="itemMng4"><span class="mng_span">식품</span>></a></li>
			<li><a href="itemMng5"><span class="mng_span">음료</span>></a></li>
		</ul>
	</div>

	<!-- 제품 추가 -->

	<form method="post" action="itemNew2">
		<div id="productBoard_new">
			<table>
				<tr>
					<th colspan="6">제품 추가</th>
				</tr>
				<tr>
					<th>제품명</th>
					<td colspan="3"><input type="text" id="input_new1" name="pname"></td>
					<th>대분류</th>
					<td>
						<select value="category" class="select_new1" name="bcid" onchange="updateSubcategories()">
							<option value="bc1">간편식사</option>
							<option value="bc2">과자류</option>
							<option value="bc3">아이스크림</option>
							<option value="bc4">식품</option>
							<option value="bc5">음료</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>제품번호</th>
					<td><input type="text" id="input_new2" name="pnum"></td>
					<th>보관위치</th>
					<td><select class="select_new1" name="wzone">
							<option value="A-01">A-01</option>
							<option value="A-02">A-02</option>
							<option value="B-01">B-01</option>
							<option value="B-02">B-02</option>
							<option value="B-03">B-03</option>
							<option value="B-04">B-04</option>
							<option value="C-01">C-01</option>
							<option value="C-02">C-02</option>
							<option value="C-03">C-03</option>
					</select></td>
					<th>소분류</th>
					<td>
						<select value="smallCategory" class="select_new1" name="scid">
							<option value="all">전체</option>
							<option value="sc1">도시락</option>
							<option value="sc2">샌드위치/햄버거</option>
							<option value="sc3">주먹밥/김밥</option>
							<option value="sc5">스낵/비스켓</option>
							<option value="sc6">빵/디저트</option>
							<option value="sc7">껌/초콜릿/캔디</option>
							<option value="sc9">콘</option>
							<option value="sc10">바</option>
							<option value="sc11">샌드</option>
							<option value="sc13">가공식사</option>
							<option value="sc14">안주류</option>
							<option value="sc16">음료</option>
							<option value="sc17">유제품</option>
							<option value="sc4">기타</option>
						</select>
					</td>

				</tr>
				<tr>
					<th>규격</th>
					<td><select value="size" class="select_new1" name="psize">
							<option value="S(소형)">S(소형)</option>
							<option value="M(중형)">M(중형)</option>
							<option value="L(대형)">L(대형)</option>
					</select></td>
					<th>단위</th>
					<td>
						<select value="unit" class="select_new3" name="punit">
							<option value="each">EA</option>
							<option value="box">box</option>
						</select>
						</td>
					<th>등록일</th>
					<td><input type="date" id="input_new2" name="pday"></td>
				</tr>

			</table>
			<!-- 저장 버튼 -->
			<div id="button_new">
				<button id="getDataBtn" type="button" class="main_btn" style="margin-right: 550px;">QR제품번호 생성</button>
				<button type="submit" class="main_btn">
					<a href="itMng" id="lim_a">취소 </a>
				</button>
				<input type="submit" class="main_btn" value="제출">
					<a href="itemMng" id="lim_a" onclick="saveShow()">
				</a>
				</div>
			</div>
	</form>


</main>
