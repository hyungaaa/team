<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.spring.y_02.BoardListDTO" %>
<%@ page import = "com.spring.y_02.BoardListDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<link rel="stylesheet" href="css/dashboard.css">

<script src="js/hello.js"></script>
<script src="js/chart.js"></script>
<script src="js/dashboard.js"></script>
    
    <main>
        <div class="dashboard">
            <div class="dash-box1">
                <span>수용량 현황</span>

                <div class="arrow" id="arrow1_1">&lt;</div><div class="arrow" id="arrow1_2">&gt;</div>   <!-- 화살표 -->

                <ul id="doughnut-list">
                    <!-- 카드 형식 도넛 차트 -->
                </ul>
                
            </div>
            <div class="dash-box2">
                <canvas id="line-chart" width="300" height="100%"></canvas>
            </div>
            <div class="dash-box3">
                <span class="golistbtn">건의게시판 (더보기)</span>
                <iframe class="dash-iframe" id="dash-iframe" src="board/boardList.jsp"></iframe>
                <table id="tableView" style="margin-top: 10px;">
                    <!-- 건의게시판 내용 가져오기 -->
                    <colgroup><col width="10%"/><col width="75%"/><col width="*"/></colgroup><thead><th>번호</th><th>제목</th><th>조회수</th></thead>
                    
                    <%
                    BoardListDAO dao = new BoardListDAO();
                    List list = dao.selectBoard();
                    
					BoardListDTO dto = new BoardListDTO();
					%>
					
                    <%
	                if (list != null) {
	                	for(int i=0; i<4; i++) {
	                
	                %>
	                
	                <tr>
	                	<td><%=((BoardListDTO)list.get(i)).getBno()%></td>
	                	<td><span class="btitle"><%=((BoardListDTO)list.get(i)).getBtitle()%></span></td>
	                	<td><%=((BoardListDTO)list.get(i)).getBbits()%></td>
	                </tr>
					<%
	                	}
	                }
					%>      
                    
                    
                </table>
            </div>
        </div>        
        
    </main>
    
<%--     <%@include file="footer.jsp" %> --%>
    
