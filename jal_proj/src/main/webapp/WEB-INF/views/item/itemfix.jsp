<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.List"%>
<%@ page import="com.spring.lim.ItMngDTO"%>
<script src="../js/system.js"></script>
<script src="../js/item.js"></script>
<script src="../js/itemnew.js"></script>

<link rel="stylesheet" href="css/itemMng.css">

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
        <button class="main_btn">카테고리 설정</button>
    </div>

    <!-- 제품 추가 -->

    <form method="post" action="itemFix2">
    <div id="productBoard_new">
       <table>
			<c:forEach items="${itemMng}" var="item">
            <tr>
                <th>제품명</th>
                <td colspan="3"><input type="text" id="input_new1" value= "${item.pname }" style="text-align: center;" name="pname"></td>
                <th>대분류</th>
                <td> 
                	<select class="select_new1" name="bcid">
					    <option <c:if test="${item.bcid eq 'bc1'}">selected</c:if> value="bc1">간편식사</option>
					    <option <c:if test="${item.bcid eq 'bc2'}">selected</c:if> value="bc2">과자류</option>
					    <option <c:if test="${item.bcid eq 'bc3'}">selected</c:if> value="bc3">아이스크림</option>
					    <option <c:if test="${item.bcid eq 'bc4'}">selected</c:if> value="bc4">식품</option>
					    <option <c:if test="${item.bcid eq 'bc5'}">selected</c:if> value="bc5">음료</option>
					</select>
                </td>
                
            </tr>
            <tr>
                <th>제품번호</th>
                <td><input type="text" name="pnum" id="input_new2" value="${item.pnum }" style="text-align: center;" readonly></td>
                <th>보관위치</th>
                <td>
                	<select class="select_new1" name="wzone">
					    <option <c:if test="${item.wzone eq 'A-01'}">selected</c:if>>A-01</option>
					    <option <c:if test="${item.wzone eq 'A-02'}">selected</c:if>>A-02</option>
					    <option <c:if test="${item.wzone eq 'B-01'}">selected</c:if>>B-01</option>
					    <option <c:if test="${item.wzone eq 'B-02'}">selected</c:if>>B-02</option>
					    <option <c:if test="${item.wzone eq 'B-03'}">selected</c:if>>B-03</option>
					    <option <c:if test="${item.wzone eq 'B-04'}">selected</c:if>>B-04</option>
					    <option <c:if test="${item.wzone eq 'C-01'}">selected</c:if>>C-01</option>
					    <option <c:if test="${item.wzone eq 'C-02'}">selected</c:if>>C-02</option>
					    <option <c:if test="${item.wzone eq 'C-03'}">selected</c:if>>C-03</option>
					</select>
                </td>
                <th>소분류</th>
                <td>
                	<select value="smallCategory" class="select_new1" name="scid">
					    <option <c:if test="${item.scid eq 'all'}">selected="selected"</c:if> value="all">전체</option>
					    <option <c:if test="${item.scid eq 'sc1'}">selected="selected"</c:if> value="sc1">도시락</option>
					    <option <c:if test="${item.scid eq 'sc2'}">selected="selected"</c:if> value="sc2">샌드위치/햄버거</option>
					    <option <c:if test="${item.scid eq 'sc3'}">selected="selected"</c:if> value="sc3">주먹밥/김밥</option>
					    <option <c:if test="${item.scid eq 'sc5'}">selected="selected"</c:if> value="sc5">스낵/비스켓</option>
					    <option <c:if test="${item.scid eq 'sc6'}">selected="selected"</c:if> value="sc6">빵/디저트</option>
					    <option <c:if test="${item.scid eq 'sc7'}">selected="selected"</c:if> value="sc7">껌/초콜릿/캔디</option>
					    <option <c:if test="${item.scid eq 'sc9'}">selected="selected"</c:if> value="sc9">콘</option>
					    <option <c:if test="${item.scid eq 'sc10'}">selected="selected"</c:if> value="sc10">바</option>
					    <option <c:if test="${item.scid eq 'sc11'}">selected="selected"</c:if> value="sc11">샌드</option>
					    <option <c:if test="${item.scid eq 'sc13'}">selected="selected"</c:if> value="sc13">가공식사</option>
					    <option <c:if test="${item.scid eq 'sc14'}">selected="selected"</c:if> value="sc14">안주류</option>
					    <option <c:if test="${item.scid eq 'sc16'}">selected="selected"</c:if> value="sc16">음료</option>
					    <option <c:if test="${item.scid eq 'sc17'}">selected="selected"</c:if> value="sc17">유제품</option>
					    <option <c:if test="${item.scid eq 'sc4'}">selected="selected"</c:if> value="sc4">기타</option>
					</select>
                </td>
                
            </tr>
            <tr>
                
                <th>규격</th>
                <td>
					<select value="size" class="select_new1" name="psize">
					    <option <c:if test="${item.psize eq 'S(소형)'}">selected</c:if> value="S(소형)">S(소형)</option>
					    <option <c:if test="${item.psize eq 'M(중형)'}">selected</c:if> value="M(중형)">M(중형)</option>
					    <option <c:if test="${item.psize eq 'L(대형)'}">selected</c:if> value="L(대형)">L(대형)</option>
					</select>
                </td>
                <th>단위</th>
                <td>
                    <select value="unit" class="select_new1" name="punit">
					    <option <c:if test="${item.punit eq 'each'}">selected</c:if> value="each">EA</option>
					    <option <c:if test="${item.punit eq 'box'}">selected</c:if> value="box">box</option>
					</select>
                </td>
                <th>등록일</th>
                    <td><input type="date" id="input_new2" value="${item.pday }" name="pday"></td>
            </tr>
            </c:forEach>
       </table>
       <!-- 저장 버튼 -->
       <div id="button_new">
           <button type="button" class="main_btn"><a href="itemMng" id="lim_a">취소</button></a>
           <a href="itemMng" id="lim_a"><input type="submit" class="main_btn" value="저장"></a>
       </div>
    </div>
    </form>
    </main>
