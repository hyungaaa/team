<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "java.util.List" %>
<%@ page import = "lee.PdDTO" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>입고 등록</title>
	<link rel="stylesheet" href="css/layout.css">
	<link rel="stylesheet" href="css/ui.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/inReg.css">

	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="js/system.js"></script>
	<script src="js/inReg.js"></script>
</head>

<body>
	<%@include file="header.jsp" %>	
    
    <%@include file="nav.jsp" %>
	<main>
		<!-- 상단 제품 추가 전 정보 테이블 -->
		<table id="inReg-tbl1">
			<colgroup>
				<col width="6%" />
				<col width="16%" />
				<col width="6%" />
				<col width="6%" />
				<col width="16%" />
				<col width="6%" />
				<col width="16%" />
				<col width="6%" />
				<col width="16%" />
				<col width="6%" />
			</colgroup>
			<%
			List list = (List) request.getAttribute("list");
			PdDTO pdDTO = new PdDTO();
			
			String searchInput = request.getParameter("searchInput");
			System.out.println("이건 jsp: searchInput " + searchInput);
			
			%>
							
			<tr id= "input-tr">
				<td class="rightAlign">제품명</td>
				<td class="leftAlign">
					<input type="text" class="table_normal_txt" id="pdtName" value="" readonly>
				</td>
				<td><button type="button" class="table_btn" onclick="openPopup()">검색</button></td>
				<td class="rightAlign">규격</td>
				<td class="leftAlign"><input type="text" class="table_normal_txt" id="size"></td>
				<td class="rightAlign">단위</td>
				<td class="leftAlign"><input type="text" class="table_normal_txt" id="unit"></td>
				<td class="rightAlign">수량</td>
				<td class="leftAlign"><input type="text" class="table_normal_txt" id="count"></td>
				<td><button type="button" class="table_btn" id="plusTr">추가</button></td>
			</tr>
			<tr>
				<td class="rightAlign">제품번호</td>
				<td colspan="2" class="leftAlign"><input type="text" class="table_normal_txt fullWidth" id="pdtNum">
				</td>
				<td class="rightAlign">비고</td>
				<td colspan="3" class="leftAlign"><input type="text" class="table_normal_txt fullWidth" id="note"></td>
				<td class="rightAlign">위치</td>
				<td colspan="2" class="leftAlign fullWidth">
					<select id="locSelect" class="searchSelect">
						<option value="위치">위치</option>
						<option value="A-01">A-01</option>
						<option value="B-01">B-01</option>
						<option value="C-01">C-01</option>
					</select>
				</td>
			</tr>
		</table>

		<hr>

		<!-- 버튼들 -->
		<input type="date" class="inputDate">
		<button type="button" class="main_btn">조회</button>
		<div class="div-btn">
			<button type="button" class="main_btn" id="add-btn">등록</button>
			<button type="button" class="main_btn" id="selected_del">삭제</button>
			<button type="button" id="qr_button" onclick="openWindow()" class="main_btn2">QR 발행</button>
		</div>
		
		<!-- 아래 추가된 제품 테이블 -->
		<div id="div-tbl2">
			<table id="inReg-tbl2">
				<colgroup>
					<col width="5%" />
					<col width="7%" />
					<col width="8%" />
					<col width="30%" />
					<col width="6%" />
					<col width="8%" />
					<col width="8%" />
					<col width="8%" />
					<col width="10%" />
					<col width="10%" />
				</colgroup>
				<thead>
					<th></th>
					<th>등록일</th>
					<th>제품번호</th>
					<th>제품명</th>
					<th>규격</th>
					<th>단위</th>
					<th>수량</th>
					<th>상태</th>
					<th>LOT No.</th>
					<th>비고</th>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" class="chk"></td>
						<td>2024-02-01</td>
						<td>ESB00001</td>
						<td>샌)망곰초코딸기샌드</td>
						<td>S(소형)</td>
						<td>BOX</td>
						<td>5</td>
						<td>미등록</td>
						<td></td>
						<td></td>
					</tr>
					
				</tbody>
			</table>
		</div>

		<!-- 페이징 -->
		<div id="div-ul">
			<ul>
				<li><a href="#">&lt;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&gt;</a></li>
			</ul>
		</div>
		

		<!-- 팝업 -->
		<div id="popup">
			<div class="popup-content">
				<div class="div_top">
					제품명
					<input type="text" class="main_search_txt" id="searchInput">
					<button type="button" class="main_btn" onclick="inRegSearch2()">검색</button>
				</div>
				<div class="div_tbl">
					<table id="popup-tbl">
						<colgroup>
							<col width="10%" />
							<col width="20%" />
							<col width="45%" />
							<col width="12%" />
							<col width="13%" />
						</colgroup>
						<thead>
							<th></th>
							<th>제품번호</th>
							<th>제품명</th>
							<th>규격</th>
							<th>단위</th>
						</thead>
						<tbody id="popup-tboby">
							<%
								for(int i = 0; i < list.size(); i++) {
							%>
							<tr id="popup-tr">
								<td><input type="radio" name="inReg-radio" value="<%=((PdDTO)list.get(i)).getPnum()%>"></td>
								<td><%=((PdDTO)list.get(i)).getPnum()%></td>
								<td><%=((PdDTO)list.get(i)).getPname()%></td>
								<td><%=((PdDTO)list.get(i)).getPsize()%></td>
								<td><%=((PdDTO)list.get(i)).getPunit()%></td>
							</tr>
							<%
 								}
							%>
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
	
	<%@include file="footer.jsp" %>
</body>

</html>