<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
// int umaster = (int) session.getAttribute("umaster");
%>

    <footer>
        <div class="footer-content">
            <div class="status-user">
                접속자 :
                ${cname} 센터
                ${uname} 
                <%
//                 if(umaster==1){
                	out.println("관리자");
//                 }
                %>
            </div>
            <div class="status-message">
                Loading
            </div>
            <div class="status-time">
                현재 시간: <span id="current-time"></span>
            </div>
        </div>
    </footer>