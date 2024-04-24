<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

  <link rel="stylesheet" href="${path}/css/invenView.css">

  <script src="${path}/js/invenView.js"></script>

  <main>
    <!-- 검색 -->
    <div id="div-select">
      <select id="selectOption" class="searchSelect">
        <option value="all">전체</option>
        <option value="productName">제품명</option>
        <option value="productCode">제품번호</option>
        <option value="LOT">LOT No.</option>
        <option value="locCode">위치코드</option>
      </select>
      <input type="text" name="search" class="main_search_txt" id="searchInput">
      <button type="button" class="main_btn" onclick="goSearch()">검색</button>
    </div>

    <!-- 테이블 -->
    <div id="div-tbl">
      <table id="tbl">
        <colgroup>
          <col width="12%" />
          <col width="8%" />
          <col width="9%" />
          <col width="16%" />
          <col width="7%" />
          <col width="7%" />
          <col width="11%" />
          <col width="10%" />
          <col width="10%" />
          <col width="7%" />
          <col width="3%" />
        </colgroup>
        <thead>
          <tr>
            <th>LOT No.</th>
            <th>위치코드</th>
            <th>제품번호</th>
            <th>제품명</th>
            <th>전산재고</th>
            <th>실재고수량</th>
            <th>재고보정</th>
            <th>최종작업일자 </th>
            <th colspan="3">보정사유</th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach var="item" items="${list}">
			  <tr>
			    <td>${item.pd_inDTO.plot}</td>
			    <td>${item.pd_inDTO.wzone}</td>
			    <td>${item.pd_inDTO.pnum}</td>
			    <td>${item.pdDTO.pname}</td>
			    <td>${item.pd_inDTO.pincnt}</td>
			    <td>${item.invenDTO2.icnt}</td>
			    <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td>
			    <td>${item.pd_inDTO.pindate}</td>
			    <td colspan="3">${item.invenDTO2.ire}</td>
			  </tr>
			</c:forEach>
<!--           <tr> -->
<!--             <td>LT202402010001</td> -->
<!--             <td>B-01</td> -->
<!--             <td>ESB00001</td> -->
<!--             <td>샌)망곰초코딸기샌드</td> -->
<!--             <td>20</td> -->
<!--             <td>20</td> -->
<!--             <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td> -->
<!--             <td>24-02-01</td> -->
<!--             <td colspan="3"></td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>LT202402010002</td> -->
<!--             <td>B-01</td> -->
<!--             <td>ESB00001</td> -->
<!--             <td>샌)망곰초코딸기샌드</td> -->
<!--             <td>20</td> -->
<!--             <td>20</td> -->
<!--             <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td> -->
<!--             <td>24-02-01</td> -->
<!--             <td colspan="3"></td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>LT202402020001</td> -->
<!--             <td>B-01</td> -->
<!--             <td>ESB00001</td> -->
<!--             <td>샌)망곰초코딸기샌드</td> -->
<!--             <td>20</td> -->
<!--             <td>20</td> -->
<!--             <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td> -->
<!--             <td>24-02-01</td> -->
<!--             <td colspan="3"></td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>LT202402020002</td> -->
<!--             <td>A-01</td> -->
<!--             <td>ICA00003</td> -->
<!--             <td>나뚜루)녹차바</td> -->
<!--             <td>10</td> -->
<!--             <td>30</td> -->
<!--             <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td> -->
<!--             <td>24-02-02</td> -->
<!--             <td colspan="3">재고 안 맞음</td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>LT202402020003</td> -->
<!--             <td>B-01</td> -->
<!--             <td>BMB00005</td> -->
<!--             <td>남양)불가리스딸기150ml</td> -->
<!--             <td>20</td> -->
<!--             <td>20</td> -->
<!--             <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td> -->
<!--             <td>24-02-02</td> -->
<!--             <td colspan="3"></td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>LT202402020004</td> -->
<!--             <td>B-01</td> -->
<!--             <td>EJB00003</td> -->
<!--             <td>주)LT명란마요삼각</td> -->
<!--             <td>20</td> -->
<!--             <td>20</td> -->
<!--             <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td> -->
<!--             <td>24-02-02</td> -->
<!--             <td colspan="3"></td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>LT202402020005</td> -->
<!--             <td>A-01</td> -->
<!--             <td>ICA00003</td> -->
<!--             <td>나뚜루)녹차바</td> -->
<!--             <td>100</td> -->
<!--             <td>100</td> -->
<!--             <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td> -->
<!--             <td>24-02-02</td> -->
<!--             <td colspan="3"></td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>LT202402020005</td> -->
<!--             <td>A-01</td> -->
<!--             <td>ICA00003</td> -->
<!--             <td>나뚜루)녹차바</td> -->
<!--             <td>100</td> -->
<!--             <td>90</td> -->
<!--             <td><button type="button" class="table_btn" id="modBtn" onclick="modCnt()">재고보정</button></td> -->
<!--             <td>24-02-02</td> -->
<!--             <td colspan="3">재고 안 맞음</td> -->
<!--           </tr> -->
        </tbody>
      </table>
    </div>

  </main>
