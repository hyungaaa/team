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
    <link rel="stylesheet" href="css/dashboard.css">

    <script src="js/hello.js"></script>
    <script src="js/chart.js"></script>
    <script src="js/system.js"></script>
    <script src="js/dashboard.js"></script>


</head>
<body>
    <%@include file="header.jsp" %>	
    
    <%@include file="nav.jsp" %>	
    
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
                <span>건의게시판</span>
                <!--  <iframe class="dash-iframe" id="dash-iframe" src="jsp/boardList.jsp"></iframe>-->
                <table id="tableView" style="margin-top: 10px;">
                    <!-- 건의게시판 내용 가져오기 -->
                </table>
            </div>
        </div>        
        
    </main>
    
    <%@include file="footer.jsp" %>
    
</body>
</html>