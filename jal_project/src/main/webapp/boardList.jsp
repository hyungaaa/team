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
    <%@include file="header.jsp" %>
    <%@include file="nav.jsp" %>
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
                    <col width="5%" />
                    <col width="11%" />
                    <col width="11%" />
                    <col width="*" />
                    <col width="17%" />
                    <col width="10%" />
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
                if (list != null) {
                	for(int i=0; i<list.size(); i++) {
                		 String pnum = ((BoardListDTO)list.get(i)).getPnum();
                %>
                
                <tr>
                	<td><%=((BoardListDTO)list.get(i)).getBno()%></td>
                	<td><%=((BoardListDTO)list.get(i)).getUname()%></td>
                	<td><%= pnum != null ? pnum : "-" %></td>
                	<td><span class="btitle"><%=((BoardListDTO)list.get(i)).getBtitle()%></span></td>
                	<td><%=((BoardListDTO)list.get(i)).getBdate()%></td>
                	<td><%=((BoardListDTO)list.get(i)).getBbits()%></td>
                </tr>
				<%
                	}
                }
				%>                		
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
    
    <%@include file="footer.jsp" %>
    
</div>
</body>

</html>