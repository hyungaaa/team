<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.List"%>
<%@ page import="com.spring.lim.ItMngDTO"%>
<link rel="stylesheet" href="css/itemMng.css">
<script src="js/item.js"></script>

<main>
	<!-- 입출고 이력 -->

	<!-- 대분류 카테고리 -->
		<div id="bigCategory">
			<ul>
				<li onclick="filterCategory('간편식사')" class="find-item"><a
					href="itemMng"><span class="mng_span">간편식사</span>></a></li>
				<li onclick="filterCategory('과자류')" class="find-item"><a
					href="itemMng2"><span class="mng_span">과자류</span>></a></li>
				<li onclick="filterCategory('아이스크림')" class="find-item"><a
					href="itemMng3"><span class="mng_span">아이스크림</span>></a>
				</li>
				<li onclick="filterCategory('식품')" class="find-item"><a
					href="itemMng4"><span class="mng_span">식품</span>></a></li>
				<li onclick="filterCategory('음료')" class="find-item"><a
					href="itemMng5"><span class="mng_span">음료</span>></a>
				</li>
			</ul>
		</div>
	<!-- 소분류 카테고리 -->
	<div id="all1">
		<div id="scate">
			<button class="main_btn" id="scate_mng" onclick="filterCategory('전체')">전체</button>
			<button class="main_btn" id="scate_mng" onclick="filterCategory('음료')">음료</button>
			<button class="main_btn" id="scate_mng" onclick="filterCategory('유제품')">유제품</button>
			<button class="main_btn" id="scate_mng" onclick="filterCategory('기타')">기타</button>
		</div>

		<!-- 선 -->


		<!-- 검색 창 -->
		<div id="search">
			<input type="text" class="main_search_txt_mng" placeholder="검색어 입력">
			<button class="main_btn_mng">검색</button>
		</div>

		<!-- 제품 게시판? -->
		<div id="productBoard">
			<form action="itMngD" method="post" onsubmit="return validateForm();">
				<!-- 폼 추가 -->
				<table class="table_mng">
					<colgroup>
						<col width="7%" />
						<col width="30%" />
						<col width="20%" />
						<col width="10%" />
						<col width="7%" />
						<col width="10%" />
						<col width="8%" />
					</colgroup>

					<%-- 데이터 불러옴 --%>
					<%
					List list = (List) request.getAttribute("list");
					// itMngDTO itmngDTO = new itMngDTO();
					%>

					<tr id="title_mng">
						<th><input type="checkbox" id="selectAll"
							onclick="toggleCheckboxes(this)"></th>
						<th>제품명</th>
						<th>소분류</th>
						<th>제품번호</th>
						<th>보관위치</th>
						<th>등록일</th>
						<th>규격</th>
					</tr>

					<%
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
					%>

					<tr class="product-row"
						data-category="<%=((ItMngDTO) list.get(i)).getSct()%>">
						<td><input type="checkbox" class="chk" name="selectedItems"
							value="<%=((ItMngDTO) list.get(i)).getPnum()%>"></td>
						<td><%=((ItMngDTO) list.get(i)).getPname()%></td>
						<td><%=((ItMngDTO) list.get(i)).getSct()%></td>
						<td><%=((ItMngDTO) list.get(i)).getPnum()%></td>
						<td><%=((ItMngDTO) list.get(i)).getWzone()%></td>
						<td><%=((ItMngDTO) list.get(i)).getPday()%></td>
						<td><%=((ItMngDTO) list.get(i)).getPsize()%></td>
					</tr>

					<%
					}
					} else {
					System.out.println("null입니다~.");
					}
					%>
				</table>
			</form>
		</div>


		<div id="button_mng_2">
			<button type="button" class="main_btn" id="selected_del"
				onclick="return confirmAndDelete()">제품 삭제</button>
			<button class="main_btn">
				<a href="itemNew.jsp" id="lim_a">제품 추가 
			</button>
			</a>
		</div>

	</div>

</main>