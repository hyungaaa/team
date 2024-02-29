<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.List" %>
<%@ page import = "y_02.BoardListDTO" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WMS 잘해보조</title>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ui.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/boardList.css">
    <!-- <link rel="stylesheet" href="../css/dashboard.css"> -->
    <!-- <link rel="stylesheet" href="../css/itemMng.css"> -->
    <!-- <link rel="stylesheet" href="../css/inReg.css"> -->
    <!-- <link rel="stylesheet" href="../css/outReg.css"> -->
    <!-- <link rel="stylesheet" href="../css/invenView.css"> -->
    <!-- <link rel="stylesheet" href="../css/inoutHistory.css"> -->
    <!-- <link rel="stylesheet" href="../css/capacityView.css"> -->
    <!-- <link rel="stylesheet" href="../css/userMng.css"> -->

    <script src="js/system.js"></script>
    <script src="js/boardList.js"></script>

</head>

<body>
<div class="wrapper">
    <header>
        <div class="top-logo">
            <img
                src="https://github.com/hyungaaa/team/blob/764a5932f4e0fe6e3dfc7ae81c561905ef779660/jal_logo_final.png?raw=true">
        </div>
        <div class="top-bar">
            <h1>물류관리시스템</h1>
        </div>
        <div class="top-bar-links">
            <a href="mypage.jsp">마이페이지</a>
            <a href="#">설정</a>
            <a href="login.jsp">로그아웃</a>
        </div>
    </header>
    <nav>
        <div class="navi-bar">
            <ul>
                <li class="navi-item1"><a href="dashboard.jsp">대시<br>보드</a></li>
                <li class="navi-item2"><a href="itemMng.jsp">제품<br>관리</a></li>
                <li class="navi-item3"><a href="inReg.jsp">입고<br>등록</a></li>
                <li class="navi-item4"><a href="outReg.jsp">출고<br>등록</a></li>
                <li class="navi-item5"><a href="invenView.jsp">재고<br>현황</a></li>
                <li class="navi-item6"><a href="inoutHistory.jsp">입출고<br>이력</a></li>
                <li class="navi-item7"><a href="capacityView.jsp">수용량<br>현황</a></li>
                <li class="navi-item8"><a href="boardList.jsp">건의<br>게시판</a></li>
                <li class="navi-item9"><a href="userMng.jsp">사용자<br>관리</a></li>
            </ul>
        </div>
    </nav>
    <main>
        <div class="search">
            <div class="excel">
                <button type="button" value="download" class="main_btn2" onclick="exportToExcel()">
                    excel 다운로드
                </button>
            </div>
            <div class="search1">
                <select name="se_op" id="searchOption" style="border: 0px; margin-right: 15px;">
                    <option value="all">전체</option>
                    <option value="title">제목</option>
                    <option value="productCode">제품코드</option>
                </select>
                <input type="text" name="search" class="main_search_txt" id="searchInput" onkeydown="searchOnEnter(event)" placeholder="검색어를 입력하세요">
                <button type="button" value="se" class="main_btn" onclick="searchTable()">검색</button>
            </div>

        </div>
		<%
			List list = (List) request.getAttribute("list");
			BoardListDTO dto = new BoardListDTO();
		%>

        <div class="tb">
            <table id="tableToExport">
                <colgroup>
                    <col width="5%" \>
                    <col width="11%" \>
                    <col width="11%" \>
                    <col width="*" \>
                    <col width="17%" \>
                    <col width="10%" \>
                </colgroup>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>글쓴이</th>
                        <th>제품코드</th>
                        <th>제목</th>
                        <th>작성일자</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                
                <%
                	for(int i=0; i<7; i++) {
                %>
                
                <tr>
                	<td><%=((BoardListDTO)list.get(i)).getBno()%></td>
                	<td><%=((BoardListDTO)list.get(i)).getUuid()%></td>
                	<td><%=((BoardListDTO)list.get(i)).getPnum()%></td>
                	<td><%=((BoardListDTO)list.get(i)).getBtitle()%></td>
                	<td><%=((BoardListDTO)list.get(i)).getBdate()%></td>
                	<td><%=((BoardListDTO)list.get(i)).getBbits()%></td>
                </tr>
				<%
                	}				
				%>                		
<!--                 <tr> -->
<!--                     <td>7</td> -->
<!--                     <td>임가현</td> -->
<!--                     <td>ICA00003</td> -->
<!--                     <td onclick="location.href='board.jsp'"   -->
<!--                         onmouseover="this.style.color='#5f8caa'" -->
<!--                         onmouseout="this.style.color='black'"  -->
<!--                         style="cursor:pointer"> -->
<!--                             녹차바가 녹았어요 -->
<!--                     </td> -->
<!--                     <td>2024-02-03</td> -->
<!--                     <td>16</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>6</td> -->
<!--                     <td>이가희</td> -->
<!--                     <td>-</td> -->
<!--                     <td>냉장고 온도 조절기에 이상발견</td> -->
<!--                     <td>2024-02-03</td> -->
<!--                     <td>28</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>5</td> -->
<!--                     <td>윤아영</td> -->
<!--                     <td>BMB00005</td> -->
<!--                     <td>불가리스 터짐</td> -->
<!--                     <td>2024-02-02</td> -->
<!--                     <td>29</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>4</td> -->
<!--                     <td>박종화</td> -->
<!--                     <td>-</td> -->
<!--                     <td>불량인 PDA가 너무 많습니다</td> -->
<!--                     <td>2024-02-02</td> -->
<!--                     <td>34</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>3</td> -->
<!--                     <td>송우석</td> -->
<!--                     <td>EDB00006</td> -->
<!--                     <td>제품 수량 안 맞아요</td> -->
<!--                     <td>2024-02-01</td> -->
<!--                     <td>24</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>2</td> -->
<!--                     <td>민병관</td> -->
<!--                     <td>-</td> -->
<!--                     <td>A-01 냉동창고에 물이 흘러요</td> -->
<!--                     <td>2024-02-01</td> -->
<!--                     <td>25</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>1</td> -->
<!--                     <td>구준표</td> -->
<!--                     <td>-</td> -->
<!--                     <td>커피 좀 넉넉히 놔주세요 직원들 마시게요</td> -->
<!--                     <td>2024-02-01</td> -->
<!--                     <td>63</td> -->
<!--                 </tr> -->
            </table>
        </div>
            <div class="write">
                <button type="button" value="write" class="main_btn">
                    <a href="boardWrite.jsp" style="color: #fff">
                        글쓰기
                    </a>
                </button>
            </div>
    
            <div class="page">
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

    </main>
    <footer>
        <div class="footer-content">
            <div class="status-user">
                접속자: 천안센터 관리자
            </div>
            <div class="status-message">
                데이터가 조회되었습니다.
            </div>
            <div class="status-time">
                현재 시간: <span id="current-time"></span>
            </div>
        </div>
    </footer>
</div>
</body>

</html>