<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="css/capacityView.css">
<script src="js/capacityView.js"></script>
<script src="js/chart.js"></script>
<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->

<!-- <head> -->
<!--     <meta charset="UTF-8"> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!--     <title>WMS 잘해보조</title> -->
<!--     <link rel="stylesheet" href="css/layout.css"> -->
<!--     <link rel="stylesheet" href="css/ui.css"> -->
<!--     <link rel="stylesheet" href="css/common.css"> -->
<!--     <link rel="stylesheet" href="css/dashboard.css"> -->
<!--     <link rel="stylesheet" href="css/capacityView.css"> -->


<!--     <script src="js/system.js"></script> -->
<!--     <script src="js/capacityView.js"></script> -->
 


<!-- </head> -->

<!-- <body> -->
<%--     <%@include file="header.jsp" %>	 --%>
    
<%--     <%@include file="nav.jsp" %> --%>
    
    <main>
        <!-- 창고 이미지 -->
        <div class="storage_map_img">
            <img class="map_img" src="https://i.ibb.co/hdJLTR0/map-final.png">
        </div>

        <!-- 창고 맵 위에 호버 할 div -->
        <div id="a_01"></div>
        <div id="a_02"></div>
        <div id="b_01"></div>
        <div id="b_02"></div>
        <div id="b_03"></div>
        <div id="b_04"></div>
        <div id="c_01"></div>
        <div id="c_02"></div>
        <div id="c_03"></div>

        <div class="search_cap">
            <input type="text"  class="main_search_txt_cap" placeholder="검색어 입력">
            <button class="main_btn" style="padding-left:12rem; padding-right:12rem">검색</button>
            <button class="main_btn2" style="padding-left:12rem; padding-right:12rem" id="btn_cap" onclick="">수정</button>
        </div>

        

        <!-- 표 -->
        <div class="cap_view">
            <div class="cap_view_table">
                <table>
                    <thead>
                        <th>구역</th>
                        <th>분류</th>
                        <th>규격 크기</th>
                        <th>현재</th>
                        <th>총량</th>
                        <th>수용량(%)</th>
                        <th>담당자</th>
                        <th>비고</th>
                    </thead>
                </table>
            </div>

            <!-- 마우스 hover 시 뜨는 차트..-->

            <div class="hover_test">
                <canvas id="line-chart_capa"  height="100%"></canvas>
            </div>

            <!-- 빈칸 -->
            <div class="cap_view_table2" style="overflow: auto;">
                <table id="cap_tbl">  
                    <tr>
                        <td>A-01</td>
                        <td>냉동</td>
                        <td>S(소형)</td>
                        <td>232</td>
                        <td>520</td>
                        <td>40 %</td>
                        <td>이가희</td>
                        <td>영하 20도</td>
                    </tr>
                    <tr>
                        <td>A-02</td>
                        <td>냉동</td>
                        <td>S(소형)</td>
                        <td>75</td>
                        <td>130</td>
                        <td>60 %</td>
                        <td>이가희</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>B-01</td>
                        <td>냉장</td>
                        <td>M(중형)</td>
                        <td>15</td>
                        <td>128</td>
                        <td>12 %</td>
                        <td>윤아영</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>B-02</td>
                        <td>냉장</td>
                        <td>S(소형)</td>
                        <td>120</td>
                        <td>150</td>
                        <td>70 %</td>
                        <td>윤아영</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>B-03</td>
                        <td>냉장</td>
                        <td>L(대형)</td>
                        <td>190</td>
                        <td>230</td>
                        <td>80 %</td>
                        <td>임가현</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>B-04</td>
                        <td>냉장</td>
                        <td>M(중형)</td>
                        <td>100</td>
                        <td>120</td>
                        <td>80%</td>
                        <td>임가현</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>C-01</td>
                        <td>상온</td>
                        <td>S(소형)</td>
                        <td>276</td>
                        <td>320</td>
                        <td>83%</td>
                        <td>송우석</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>C-02</td>
                        <td>상온</td>
                        <td>M(중형)</td>
                        <td>180</td>
                        <td>260</td>
                        <td>78%</td>
                        <td>송우석</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>C-03</td>
                        <td>상온</td>
                        <td>L(대형)</td>
                        <td>200</td>
                        <td>430</td>
                        <td>53%</td>
                        <td>박종화</td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>

    </main>
    
<%--     <%@include file="footer.jsp" %> --%>
   
<!-- </body> -->

<!-- </html> -->