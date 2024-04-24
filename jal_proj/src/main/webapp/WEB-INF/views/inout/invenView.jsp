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
			  <form method="post" action="invenFix" id="invenForm">
			  <tr>
			    <td><input type="text" name="plot" value="${item.pd_inDTO.plot}" style="width:100px;border: none;" readonly></td>
			    <td>${item.pd_inDTO.wzone}</td>
			    <td>${item.pd_inDTO.pnum}</td>
			    <td>${item.pdDTO.pname}</td>
			    <td>${item.pd_inDTO.pincnt}</td>
			    <td><input type="text" name="icnt" value ="${item.invenDTO2.icnt}" style="width:50px;border: none;" readonly></td>
			    <td>
			    	<input type="button" id="modBtn" onclick="modCnt()" value="수정">
			    	<input type="submit" id="confirmBtn" onclick="modCnt()" style="display: none;" value="확인">
			    </td>
			    <td>${item.pd_inDTO.pindate}</td>
			    <td colspan="3"><input type="text" name="ire" value="${item.invenDTO2.ire}" style="width:100px;border: none;" readonly>
			    	${item.invenDTO2.ire}
			    </td>
			  </tr>
			  </form>
			</c:forEach>
        </tbody>
      </table>
    </div>
  

  </main>
