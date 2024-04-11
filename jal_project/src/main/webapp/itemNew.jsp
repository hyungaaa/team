<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WMS 잘해보조</title>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ui.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/itemMng.css">


    <script src="../js/system.js"></script>
    <script src="../js/item.js"></script>


</head>
<body>
    
    <%@include file="header.jsp" %>	
    
    <%@include file="nav.jsp" %>

    <!-- 메인 -->
    <main>
        <!-- 새로운 제품 추가 창 -->

    <!-- 대분류 카테고리 -->
    <div id="bigCategory">
        <ul>
            <li><a href="#"><span class="mng_span">간편식사</span>></a></li>
            <li><a href="#"><span class="mng_span">과자류</span>></a></li>
            <li><a href="#"><span class="mng_span">아이스크림</span>></a></li>
            <li><a href="#"><span class="mng_span">식품</span>></a></li>
            <li><a href="#"><span class="mng_span">음료</span>></a></li>
        </ul>
        <button class="main_btn">카테고리 설정</button>
    </div>

    <!-- 제품 추가 -->

    <form method="post" action="itMngNew">
    <div id="productBoard_new">
       <table>
            <tr>
                <!-- 이미지 창 버튼 누르면 그 버튼으로 이미지 올라가게 하고 싶어요-->
                <td colspan="6" height="200" auto>
                    <!-- <img id="imageDisplay" style="width: 100%; height: auto; display: none;"> -->
                    <!-- <button type="button" class="main_btn_new2" id="img_btn_new"> -->
                    <!-- <div id="img_prv"></div> -->
                    <label for="imageUpload" class="main_btn_new2">이미지 업로드</label>
                    <input type="file" id="imageUpload" style="display: none" accept="image/*">
                </td></button>
            <tr>
                <th>제품명</th>
                <td colspan="3"><input type="text" id="input_new1"></td>
                <th>대분류</th>
                <td>
                	<select value="category" class="select_new1">
                        <option value="easy">간편식사</option>
                        <option value="snack">과자류</option>
                        <option value="icecream">아이스크림</option>
                        <option value="food">식품</option>
                        <option value="beverage">음료</option>
                      </select>
                   </td>
            </tr>
            <tr>
                <th>제품번호</th>
                <td><input type="text" id="input_new2"></td>
                <th>보관위치</th>
                <td><select class="select_new1">
                    <option>A-01</option>
                    <option>A-02</option>
                    <option>B-01</option>
                    <option>B-02</option>
                    <option>B-03</option>
                    <option>B-04</option>
                    <option>C-01</option>
                    <option>C-02</option>
                    <option>C-03</option>
                </select></td>
                <th>소분류</th>
                <td> 
                <select value="smallCategory" class="select_new1">
                 	<option value="all">전체</option>
                    <option value="lunch">도시락</option>
                    <option value="sand">샌드위치/햄버거</option>
                    <option value="bob">주먹밥/김밥</option>
                    <option value="lunch">스낵/비스켓</option>
                    <option value="sand">빵/디저트</option>
                    <option value="bob">껌/초콜릿/캔디</option>
                    <option value="etc">콘</option>
                    <option value="lunch">바</option>
                    <option value="sand">샌드</option>
                    <option value="bob">가공식사</option>
                    <option value="etc">안주류</option>
                    <option value="lunch">음료</option>
                    <option value="sand">유제품</option>
                    <option value="etc">기타</option>
                </select>
                </td>
                
            </tr>
            <tr>
                <th>규격</th>
                <td>
                    <select value="size" class="select_new1">
                        <option value="small">S(소형)</option>
                        <option value="medium">M(중형)</option>
                        <option value="large">L(대형)</option>
                    </select>
                </td>
                <th>단위</th>
                <td>
                    <input type="text" id="input_new3">
                    <select value="unit" class="select_new3">
                        <option value="each">EA</option>
                        <option value="box">box</option>
                    </select>
                </td>
                <th>등록일</th>
                <td><input type="date" id="input_new2"></td>
            </tr>
           
       </table>
       <!-- 저장 버튼 -->
       <div id="button_new">
           <button type="submit" class="main_btn"><a href="itMng" id="lim_a">취소</button></a>
           <button type="submit" class="main_btn"><a href="itMng" id="lim_a" onclick="saveShow()">저장</button></a>
       </div>
    </div>
    </form>


    </main>
    
    <%@include file="footer.jsp" %>
    
</body>
</html>
