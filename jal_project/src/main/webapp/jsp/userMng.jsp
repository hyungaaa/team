<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="Mng.UserMngDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WMS 잘해보조</title>
<link rel="stylesheet" href="../css/layout.css">
<link rel="stylesheet" href="../css/ui.css">
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/userMng.css">
<script src="../js/userMng.js"></script>
<script src="../js/system.js"></script>
<script src="../js/hello.js"></script>

</head>

<body>
	<header>
		<div class="top-logo">
			<img
				src="https://github.com/hyungaaa/team/blob/764a5932f4e0fe6e3dfc7ae81c561905ef779660/jal_logo_final.png?raw=true">
		</div>
		<div class="top-bar">
			<h1>사용자 권한 관리</h1>
		</div>
		<div class="top-bar-links">
			<a href="mypage.html">마이페이지</a> <a href="#">설정</a> <a
				href="login.html">로그아웃</a>
		</div>
	</header>
	<nav>
		<div class="navi-bar">
			<ul>
				<li class="navi-item1"><a href="dashboard.html">대시<br>보드
				</a></li>
				<li class="navi-item2"><a href="itemMng.html">제품<br>관리
				</a></li>
				<li class="navi-item3"><a href="inReg.html">입고<br>등록
				</a></li>
				<li class="navi-item4"><a href="outReg.html">출고<br>등록
				</a></li>
				<li class="navi-item5"><a href="invenView.html">재고<br>현황
				</a></li>
				<li class="navi-item6"><a href="inoutHistory.html">입출고<br>이력
				</a></li>
				<li class="navi-item7"><a href="capacityView.html">수용량<br>현황
				</a></li>
				<li class="navi-item8"><a href="boardList.html">건의<br>게시판
				</a></li>
				<li class="navi-item9"><a href="userMng.html">사용자<br>관리
				</a></li>
			</ul>
		</div>
	</nav>
	<main>
		<%
		List list = (List) request.getAttribute("list");
		UserMngDTO dto = new UserMngDTO();
		%>
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
					<div class="popup-content">
						<p class="userMng_p">사용자 요청 목록</p>
						<table id="table_hd2">
							<colgroup>
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
							</colgroup>
							<tr id="pop_tr">
								<th>요청사항</th>
								<th>사원번호</th>
								<th>아이디</th>
								<th>이메일</th>
								<th>선택</th>
							</tr>
							<%
							if (list != null) {
								for (int i = 0; i < list.size(); i++) {
							%>

							<tr>
								<td><%=((UserMngDTO) list.get(i)).getRcategory()%></td>
								<td><%=((UserMngDTO) list.get(i)).getUnum()%></td>
								<td><%=((UserMngDTO) list.get(i)).getUuid()%></td>
								<td><%=((UserMngDTO) list.get(i)).getUemail()%></td>
								<td><input type="checkbox" class="chk"></td>
							</tr>
							<%
							}
							}
							%>
							<!-- <tr>
								<td>사용자 등록</td>
								<td>asd213</td>
								<td>asf54</td>
								<td>sda@naver.com</td>
								<td><input type="checkbox" class="chk"></td>
							</tr>
							<tr>
								<td>비밀번호 초기화</td>
								<td>asd321</td>
								<td>fsa65</td>
								<td>ass@gmail.com</td>
								<td><input type="checkbox" class="chk"></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><input type="checkbox" class="chk"></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><input type="checkbox" class="chk"></td>
							</tr> -->
						</table>
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
						<span class="popY">승인</span> <span class="popN"
							onclick="closePopup()">취소</span>
					</div>
				</div>
			</div>
			<div class="div_scr">
				<table id="table_cap">
					<colgroup>
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
							<th>이름</th>
							<th>사원번호</th>
							<th><select id="select_change1" class="table_normal_txt"
								style="width: 60px; height: 25px;">
									<option>센터</option>
									<option value="천안" class="select_op1">천안</option>
									<option value="아산" class="select_op1">아산</option>
									<option value="평택" class="select_op1">평택</option>
							</select>
								<button type="button" id="change_button1" class="table_btn"
									style="padding: 6rem;">변경</button></th>
							<th><select id="select_change2" class="table_normal_txt"
								style="width: 60px; height: 25px;">
									<option>권한</option>
									<option value="게스트" class="select_op2">게스트</option>
									<option value="사용자" class="select_op2">사용자</option>
									<option value="부관리자" class="select_op2">부관리자</option>
									<option value="관리자" class="select_op2">관리자</option>
							</select>
								<button type="button" id="change_button2" class="table_btn"
									style="padding: 6rem;">변경</button></th>
							<th>제품조회<input type="checkbox" id="select_all1"
								class="select_all">
							</th>
							<th>입/출고등록<input type="checkbox" id="select_all2">
							</th>
							<th>입/출고수정<input type="checkbox" id="select_all3">
							</th>
							<th>제품등록<input type="checkbox" id="select_all4">
							</th>
							<th>게시판수정<input type="checkbox" id="select_all5">
							</th>
							<th>사용자관리<input type="checkbox" id="select_all6">
							</th>
							<th></th>
						</tr>
					</thead>
					<%
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
					%>

					<tr>
						<td><%=((UserMngDTO) list.get(i)).getUname()%></td>
						<td><%=((UserMngDTO) list.get(i)).getUnum()%></td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="천안" class="select_op1">천안</option>
								<option value="아산" class="select_op1">아산</option>
								<option value="평택" class="select_op1">평택</option>
						</select></td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="게스트" class="select_op2">게스트</option>
								<option value="사용자" class="select_op2">사용자</option>
								<option value="부관리자" class="select_op2">부관리자</option>
								<option value="관리자" class="select_op2" selected>관리자</option>
						</select></td>
						<td><input type="checkbox" class="chk1" checked></td>
						<td><input type="checkbox" class="chk2" checked></td>
						<td><input type="checkbox" class="chk3" checked></td>
						<td><input type="checkbox" class="chk4" checked></td>
						<td><input type="checkbox" class="chk5" checked></td>
						<td><input type="checkbox" class="chk6" checked></td>
						<td>
							<button type="button" class="main_btn2" style="padding: 8rem;">삭제</button>
							<button type="button" class="main_btn" style="padding: 8rem;">수정</button>
						</td>
					</tr>
					<%
					}
					}
					%>
					<!-- <tr>
						<td>임가현</td>
						<td>C00001</td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="천안" class="select_op1">천안</option>
								<option value="아산" class="select_op1">아산</option>
								<option value="평택" class="select_op1">평택</option>
						</select></td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="게스트" class="select_op2">게스트</option>
								<option value="사용자" class="select_op2">사용자</option>
								<option value="부관리자" class="select_op2">부관리자</option>
								<option value="관리자" class="select_op2" selected>관리자</option>
						</select></td>
						<td><input type="checkbox" class="chk1" checked></td>
						<td><input type="checkbox" class="chk2" checked></td>
						<td><input type="checkbox" class="chk3" checked></td>
						<td><input type="checkbox" class="chk4" checked></td>
						<td><input type="checkbox" class="chk5" checked></td>
						<td><input type="checkbox" class="chk6" checked></td>
						<td>
							<button type="button" class="main_btn2" style="padding: 8rem;">삭제</button>
							<button type="button" class="main_btn" style="padding: 8rem;">수정</button>
						</td>
					</tr>
					<tr>
						<td>이가희</td>
						<td>C00002</td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="천안" class="select_op1">천안</option>
								<option value="아산" class="select_op1" selected>아산</option>
								<option value="평택" class="select_op1">평택</option>
						</select></td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="게스트" class="select_op2">게스트</option>
								<option value="사용자" class="select_op2">사용자</option>
								<option value="부관리자" class="select_op2" selected>부관리자</option>
								<option value="관리자" class="select_op2">관리자</option>
						</select></td>
						<td><input type="checkbox" class="chk1" checked></td>
						<td><input type="checkbox" class="chk2" checked></td>
						<td><input type="checkbox" class="chk3" checked></td>
						<td><input type="checkbox" class="chk4"></td>
						<td><input type="checkbox" class="chk5"></td>
						<td><input type="checkbox" class="chk6"></td>
						<td>
							<button type="button" class="main_btn2" style="padding: 8rem;">삭제</button>
							<button type="button" class="main_btn" style="padding: 8rem;">수정</button>
						</td>
					</tr>
					<tr>
						<td>윤아영</td>
						<td>C00003</td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="천안" class="select_op1">천안</option>
								<option value="아산" class="select_op1">아산</option>
								<option value="평택" class="select_op1" selected>평택</option>
						</select></td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="게스트" class="select_op2" selected>게스트</option>
								<option value="사용자" class="select_op2">사용자</option>
								<option value="부관리자" class="select_op2">부관리자</option>
								<option value="관리자" class="select_op2">관리자</option>
						</select></td>
						<td><input type="checkbox" class="chk1"></td>
						<td><input type="checkbox" class="chk2"></td>
						<td><input type="checkbox" class="chk3"></td>
						<td><input type="checkbox" class="chk4"></td>
						<td><input type="checkbox" class="chk5"></td>
						<td><input type="checkbox" class="chk6"></td>
						<td>
							<button type="button" class="main_btn2" style="padding: 8rem;">삭제</button>
							<button type="button" class="main_btn" style="padding: 8rem;">수정</button>
						</td>
					</tr>
					<tr>
						<td>박종화</td>
						<td>C00004</td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="천안" class="select_op1" selected>천안</option>
								<option value="아산" class="select_op1">아산</option>
								<option value="평택" class="select_op1">평택</option>
						</select></td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="게스트" class="select_op2" selected>게스트</option>
								<option value="사용자" class="select_op2">사용자</option>
								<option value="부관리자" class="select_op2">부관리자</option>
								<option value="관리자" class="select_op2">관리자</option>
						</select></td>
						<td><input type="checkbox" class="chk1"></td>
						<td><input type="checkbox" class="chk2"></td>
						<td><input type="checkbox" class="chk3"></td>
						<td><input type="checkbox" class="chk4"></td>
						<td><input type="checkbox" class="chk5"></td>
						<td><input type="checkbox" class="chk6"></td>
						<td>
							<button type="button" class="main_btn2" style="padding: 8rem;">삭제</button>
							<button type="button" class="main_btn" style="padding: 8rem;">수정</button>
						</td>
					</tr>
					<tr>
						<td>송우석</td>
						<td>C00005</td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="천안" class="select_op1">천안</option>
								<option value="아산" class="select_op1" selected>아산</option>
								<option value="평택" class="select_op1">평택</option>
						</select></td>
						<td><select class="main_search2_txt"
							style="width: 90px; height: 20px;">
								<option value="게스트" class="select_op2">게스트</option>
								<option value="사용자" class="select_op2">사용자</option>
								<option value="부관리자" class="select_op2" selected>부관리자</option>
								<option value="관리자" class="select_op2">관리자</option>
						</select></td>
						<td><input type="checkbox" class="chk1" checked></td>
						<td><input type="checkbox" class="chk2" checked></td>
						<td><input type="checkbox" class="chk3" checked></td>
						<td><input type="checkbox" class="chk4"></td>
						<td><input type="checkbox" class="chk5"></td>
						<td><input type="checkbox" class="chk6"></td>
						<td>
							<button type="button" class="main_btn2" style="padding: 8rem;">삭제</button>
							<button type="button" class="main_btn" style="padding: 8rem;">수정</button>
						</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr> -->
				</table>
			</div>
		</div>


	</main>
	<footer>
		<div class=" footer-content">
			<div class="status-user">접속자: 천안센터 관리자</div>
			<div class="status-message">데이터가 조회되었습니다.</div>
			<div class="status-time">
				현재 시간: <span id="current-time"></span>
			</div>
		</div>
	</footer>
</body>

</html>
