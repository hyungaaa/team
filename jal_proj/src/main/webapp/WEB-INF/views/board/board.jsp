<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WMS 잘해보조</title>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ui.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/board.css">

    <script src="js/system.js"></script>
    <script src="js/board.js"></script>

</head>

<body>
    <%@include file="header.jsp" %>

    <%@include file="nav.jsp" %>

	<%
	    String btitle = (String) request.getAttribute("btitle");
	    String uname = (String) request.getAttribute("uname");
	    String bdate = (String) request.getAttribute("bdate");
	    String btext = (String) request.getAttribute("btext");
	%>
	
    <main>
        <div class="_main">
            <h2><%=btitle%></h2>
            <hr>
            <div class="profile">
                <img src='https://ifh.cc/g/MRkSvZ.png'>
                <%=uname %>
            </div>
            <div class="pDate">
                게시일 : <%=bdate %>
            </div>
            <div class="ice">
                <br>
                <%=btext %>
                <div id="replyForm" style="display: none;">
                    <textarea id="replyTextarea" rows="5" cols="70" readonly>re</textarea>
                    <button type="button" class="main_btn2" id="submitReplyButton" onclick="submitReply()">등록</button>
                </div>
            </div>

            <div class="btn">
                <button type="button" class="main_btn" id="sSize">
                    <a href="boardList" style="color: #fff;">
                        뒤로가기
                    </a>
                </button>
                <button type="button" class="main_btn" id="replyButton" onclick="showReplyForm()">
                    답글
                </button>
            </div>
        </div>

    </main>
    
    <%@include file="footer.jsp" %>

</body>

</html>