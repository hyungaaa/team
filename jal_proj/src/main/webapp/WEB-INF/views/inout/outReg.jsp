<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<link rel="stylesheet" href="css/outReg.css">

	<script src="js/outReg.js?ver=1"></script>

	<main>
		<!-- 상단 제품 추가 전 정보 테이블 -->
		<table id="inReg-tbl1">
			<colgroup>
				<col width="6%" />
				<col width="16%" />
				<col width="7%" />
				<col width="6%" />
				<col width="12%" />
				<col width="6%" />
				<col width="12%" />
				<col width="6%" />
				<col width="8%" />
				<col width="6%" />
				<col width="8%" />
				<col width="7%" />
			</colgroup>
			
			<form method="post" action="outReg/insert">
				<tr>
					<td class="rightAlign">제품명</td>
					<td class="leftAlign"><input type="text" class="table_normal_txt" id="pdtName" name="pname" value="${pd_in.plot}"readonly></td>
					<td><button type="button" class="table_btn" onclick="openPopup()">검색</button></td>
					<td class="rightAlign">규격</td>
					<td class="leftAlign"><input type="text" class="table_normal_txt" id="size" name="psize"></td>
					<td class="rightAlign">단위</td>
					<td class="leftAlign"><input type="text" class="table_normal_txt" id="unit" name="punit"></td>
					<td class="rightAlign">현재고</td>
					<td class="leftAlign"><input type="text" class="table_normal_txt" id="count" name="pincnt"></td>
					<td class="rightAlign">출고 수량</td>
					<td class="leftAlign"><input type="text" class="table_normal_txt" id="outCount" name="poutcnt"></td>
					<td><input type="submit" class="table_btn" id="plusTr" value="추가"></td>
<!-- 					<button type="button" class="table_btn" id="plusTr">추가</button> -->
				</tr>
				<tr>
					<td class="rightAlign">제품번호</td>
					<td colspan="2" class="leftAlign"><input type="text" class="table_normal_txt fullWidth" id="pdtNum" name="pnum"></td>
					<td class="rightAlign">비고</td>
					<td colspan="3" class="leftAlign"><input type="text" class="table_normal_txt fullWidth" id="note" name="pnote"></td>
					<td class="rightAlign">위치</td>
					<td colspan="4" class="leftAlign fullWidth">
						<select id="locSelect" class="searchSelect" name="wzone">
							<option value="위치">위치</option>
							<option value="A-01">A-01</option>
							<option value="A-02">A-02</option>
							<option value="B-01">B-01</option>
							<option value="B-02">B-02</option>
							<option value="B-03">B-03</option>
							<option value="B-04">B-04</option>
							<option value="C-01">C-01</option>
							<option value="C-02">C-02</option>
							<option value="C-03">C-03</option>
						</select>
					</td>
				</tr>
			</form>
		</table>

		<hr>

		<!-- 버튼들 -->
		<input type="date" class="inputDate">
		<button type="button" class="main_btn" id="dateCheck">조회</button>
		<div class="div-btn">
			<button type="button" class="main_btn" id="add-btn">등록</button>
			<button type="button" class="main_btn" id="selected_del">삭제</button>
		</div>

		<!-- 아래 추가된 제품 테이블 -->
		<div id="div-tbl2">
			<table id="inReg-tbl2">
				<colgroup>
					<col width="5%" />
					<col width="7%" />
					<col width="8%" />
					<col width="*" />
					<col width="6%" />
					<col width="8%" />
					<col width="8%" />
					<col width="8%" />
					<col width="6%" />
					<col width="10%" />
					<col width="10%" />
				</colgroup>
				<thead>
					<th></th>
					<th>등록일</th>
					<th>제품번호</th>
					<th>제품명</th>
					<th>위치</th>
					<th>출고수량</th>
					<th>현재고</th>
					<th>변경 후 수량</th>
					<th>상태</th>
					<th>LOT No.</th>
					<th>비고</th>
				</thead>
				<tbody>
<%-- 				<c:forEach var="undertbl" ${ }> --%>
<!-- 					<tr> -->
<!-- 						<td></td> -->
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>

					<c:forEach var="pdOut" items="${pdOutList}">
						<tr>
							<td><input type="checkbox" class="chk" value="${pdOut.pd_inDTO.plot}"></td>
							<td>${pdOut.pd_inDTO.pindate}</td>
							<td>${pdOut.pd_inDTO.pnum}</td>
							<td>${pdOut.pdDTO.pname}</td>
							<td>${pdOut.pdDTO.wzone}</td>
							<td>${pdOut.pd_outDTO.poutcnt}</td>
							<td>${pdOut.pd_inDTO.pincnt}</td>
							<td>${(pdOut.pd_inDTO.pincnt-pdOut.pd_outDTO.poutcnt)}</td>
							<c:if test="${pdOut.pd_outDTO.poutstate == '출고완료' }">
								<td>${pdOut.pd_outDTO.poutstate}</td>
							</c:if>
							<c:if test="${pdOut.pd_outDTO.poutstate != '출고완료' }">
								<td>${pdOut.pd_inDTO.pstate}</td>
							</c:if>
							<td>${pdOut.pd_inDTO.plot}</td>
							<c:if test="${pdOut.pd_inDTO.pnote == null}">
								<td></td>
							</c:if>
							<c:if test="${pdOut.pd_inDTO.pnote != null}">
								<td>${pdOut.pd_inDTO.pnote}</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- 페이징 -->
<!-- 		<div id="div-ul"> -->
<!-- 			<ul> -->
<!-- 				<li><a href="#">&lt;</a></li> -->
<!-- 				<li><a href="#">1</a></li> -->
<!-- 				<li><a href="#">2</a></li> -->
<!-- 				<li><a href="#">3</a></li> -->
<!-- 				<li><a href="#">4</a></li> -->
<!-- 				<li><a href="#">5</a></li> -->
<!-- 				<li><a href="#">&gt;</a></li> -->
<!-- 			</ul> -->
<!-- 		</div> -->

		<!-- 팝업 -->
		<div id="popup">
			<div class="popup-content">
				<div class="div_top">
					제품명
					<input type="text" class="main_search_txt" id="searchInput">
					<button type="button" class="main_btn" onclick="outRegSearch()">검색</button>
				</div>
				<div class="div_tbl">
					<table id="popup-tbl">
						<colgroup>
							<col width="10%" />
							<col width="20%" />
							<col width="*" />
							<col width="15%" />
							<col width="15%" />
						</colgroup>
						<thead>
							<th></th>
							<th>제품번호</th>
							<th>제품명</th>
							<th>규격</th>
							<th>단위</th>
						</thead>
						<tbody id="popup-tboby">
						 <c:forEach var="pdList" items="${pdList}">
						 	<tr id="popup-tr">
								<td><input type="radio" name="inReg-radio" value="${pdList.pdDTO.pnum}"></td>
								<td>${pdList.pdDTO.pnum}</td>
								<td>${pdList.pdDTO.pname}</td>
								<td>${pdList.pdDTO.psize}</td>
								<td>${pdList.pdDTO.punit}</td>
								<td style="display:none"><input type="hidden" id="pincnt" value="${pdList.pd_inDTO.pincnt}"></td>
							</tr>
						 </c:forEach>
						</tbody>
					</table>
				</div>
<!-- 				<div class="div_flex"> -->
<!-- 					<button type="button" class="main_btn">&lt; prev</button> -->
<!-- 					<button type="button" class="main_btn">next &gt;</button> -->
<!-- 				</div> -->
				<div class="div_line"></div>
				<div class="div_btn">
					<a href="#">
						<div class="div_in" onclick="checkedPopup()">선택</div>
					</a>
					|
					<a href="#">
						<div class="div_in" onclick="closePopup()">취소</div>
					</a>
				</div>
			</div>
		</div>
	</main>
