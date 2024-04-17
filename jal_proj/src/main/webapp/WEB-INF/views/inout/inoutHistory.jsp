<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

  <link rel="stylesheet" href="css/inoutHistory.css">

  <script src="js/inoutHistory.js"></script>

  <main>
    <!-- 검색 -->
    <div id="div-select">
      <select id="selectOption" class="searchSelect">
        <option value="all">전체</option>
        <option value="LOT">LOT No.</option>
        <option value="productCode">제품번호</option>
        <option value="productName">제품명</option>
      </select>
      <input type="text" name="search" class="main_search_txt" id="searchInput">
      <button type="button" class="main_btn" onclick="goSearch()">검색</button>
    </div>

    <!-- 테이블 -->
    <div id="div-table">
      <table id="tbl">
        <colgroup>
          <col width="12%" />
          <col width="10%" />
          <col width="10%" />
          <col width="10%" />
          <col width="*" />
          <col width="10%" />
          <col width="10%" />
          <col width="10%" />
        </colgroup>
        <thead>
          <tr>
            <th>LOT No.</th>
            <th>전표일자-No.</th>
            <th>
              <select id="inoutSelect" class="tableSelect" onchange="goInout()">
                <option value="작업 구분">작업 구분</option>
                <option value="입고">입고</option>
                <option value="출고">출고</option>
              </select>
            </th>
            <th>제품번호</th>
            <th>제품명</th>
            <th>입고수량</th>
            <th>출고수량</th>
            <th>현재고수량</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>LT202402010001</td>
            <td>2024/02/01-1</td>
            <td>입고</td>
            <td>ESB00001</td>
            <td>샌)망곰초코딸기샌드</td>
            <td>200</td>
            <td>-</td>
            <td>200</td>
          </tr>
          <tr>
            <td>LT202402010002</td>
            <td>2024/02/01-2</td>
            <td>입고</td>
            <td>SCC00002</td>
            <td>롯데)허쉬너겟쿠앤크6P</td>
            <td>150</td>
            <td>-</td>
            <td>150</td>
          </tr>
          <tr>
            <td>LT202402010003</td>
            <td>2024/02/01-3</td>
            <td>입고</td>
            <td>ICA00003</td>
            <td>나뚜루)녹차바</td>
            <td>100</td>
            <td>-</td>
            <td>100</td>
          </tr>
          <tr>
            <td>LT202402010001</td>
            <td>2024/02/02-1</td>
            <td>출고</td>
            <td>ESB00001</td>
            <td>샌)망곰초코딸기샌드</td>
            <td>-</td>
            <td>15</td>
            <td>185</td>
          </tr>
          <tr>
            <td>LT202402010001</td>
            <td>2024/02/02-2</td>
            <td>출고</td>
            <td>ESB00001</td>
            <td>샌)망곰초코딸기샌드</td>
            <td>-</td>
            <td>15</td>
            <td>170</td>
          </tr>
          <tr>
            <td>LT202402010002</td>
            <td>2024/02/03-1</td>
            <td>출고</td>
            <td>SCC00002</td>
            <td>롯데)허쉬너겟쿠앤크6P</td>
            <td>-</td>
            <td>10</td>
            <td>140</td>
          </tr>
          <tr>
            <td>LT2024020100003</td>
            <td>2024/02/03-2</td>
            <td>출고</td>
            <td>ICA00003</td>
            <td>나뚜루)녹차바</td>
            <td>-</td>
            <td>10</td>
            <td>90</td>
          </tr>
          <tr>
            <td>LT2024020100003</td>
            <td>2024/02/03-3</td>
            <td>출고</td>
            <td>ICA00003</td>
            <td>나뚜루)녹차바</td>
            <td>-</td>
            <td>20</td>
            <td>70</td>
          </tr>
          <tr>
            <td>LT2024020100003</td>
            <td>2024/02/04-1</td>
            <td>출고</td>
            <td>ICA00003</td>
            <td>나뚜루)녹차바</td>
            <td>-</td>
            <td>10</td>
            <td>60</td>
          </tr>
          <tr>
            <td>LT2024020100003</td>
            <td>2024/02/05-1</td>
            <td>출고</td>
            <td>ICA00003</td>
            <td>나뚜루)녹차바</td>
            <td>-</td>
            <td>10</td>
            <td>50</td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 페이징 -->
<!--     <div id="div-ul"> -->
<!--       <ul> -->
<!--         <li><a href="#">&lt;</a></li> -->
<!--         <li><a href="#">1</a></li> -->
<!--         <li><a href="#">2</a></li> -->
<!--         <li><a href="#">3</a></li> -->
<!--         <li><a href="#">4</a></li> -->
<!--         <li><a href="#">5</a></li> -->
<!--         <li><a href="#">&gt;</a></li> -->
<!--       </ul> -->
<!--     </div> -->
  </main>
