<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WMS 잘해보조</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ui.css">
    <link rel="stylesheet" href="css/login.css">

    <script src="js/login.js"></script>

</head>
<body>

    <div class="login_page">
	    
		<form method= "post" action="login" id="form">
	
	        <span class="login_title">LOGIN</span>
	        <br><br><br>
	        
	        <table class="login_table">
	
	            <colgroup>
	                <col width="20%"/>
	                <col width="*"/>
	                <col width="20%"/>
	            </colgroup>
	            <tr>
	                <td rowspan="2">
	                    <img src="img/user.png" style="max-width: 100%;">
	                </td>
	                <td><input class="main_normal_txt"  type="text" id= "userid" name = "userid" tabindex="1" placeholder="아이디를 입력하세요"></td>
	                <td rowspan="2"><button type="submit" class="main_btn" style="height: 80rem;" id="login_btn" tabindex="3">로그인</button></td>
	            </tr>
	            <tr>
	                <td><input class="main_normal_txt"  type="password" id = "pw" name = "pw" tabindex="2" placeholder="비밀번호를 입력하세요"></td>
	            </tr>
	            <tr height="28rem">
	                <td></td>
	                <td>
	                    <div id="alert_msg" style="color:red; font-size:12rem;"> </div>
	                </td>
	                <td></td>
	            </tr>
	
	        </table>
		</form>
	        <hr><br>
	
	        <div style="display: flex;justify-content: space-around;">
	            <button class="main_btn" id="request1_btn" tabindex="4">사용권한 등록 요청</button>
	            <button class="main_btn2" id="request2_btn" tabindex="5">비밀번호 초기화 요청</button>
	        </div>
	
	        <br><br>
	        <span> 최초 사용시에는 상단의 '사용권한 등록요청'을 클릭하여 권한을 등록한 뒤 로그인 해주시기 바랍니다.</span>
	
	   </div>
	    

    <!-- 팝업창1 -->
    <div id="popup1" class="popup1">
        <div class="popup-content1">

            <p style="font-size: 18rem; font-weight: 500;">사용권한 등록 요청</p>
            
            <form id="form_idreg" method="post" action="idreg.do">
	            <table>
	                <colgroup>
	                    <col width="20%"/>
	                    <col width="*"/>
	                    <col width="30%"/>
	                </colgroup>
	                <tr>
	                    <td>사원번호</td>
	                    <td colspan="2"><input type="text" class="table_normal_txt" id="req1_empno" name="unum" style="width: 95%;"></td>
	                </tr>
	                <tr>
	                    <td>아이디</td>
	                    <td><input type="text" class="table_normal_txt" style="width: 95%;" id="req1_id" name="uuid"></td>
	                    <td><button type="button" class="main_btn2" id="id_check" style="padding: 8rem 12rem 8rem;">중복확인</button></td>
	                </tr>
	                <tr>
	                    <td>이메일</td>
	                    <td colspan="2"><input class="table_normal_txt" type="email" style="width: 95%;" id="req1_email" name="uemail" placeholder="example@gmail.com"></td>
	                </tr>
	                <tr height="28rem">
	                    <td></td>
	                    <td colspan="2">
	                        <div id="alert_msg1" style="color:red; font-size:12rem;"> </div>
	                    </td>
	                </tr>
	    
	            </table>
	            <br>
	            <div class="pBtn">
	                <span id="popY1">확 인</span>
	                <span id="popN1">취 소</span>
	            </div>
            </form>

        </div>
    </div>
    <!-- 팝업창1  -->


    <!-- 팝업창2 -->
    <div id="popup2" class="popup2">
        <div class="popup-content2">

            <p style="font-size: 18rem; font-weight: 500;">비밀번호 초기화 요청</p>
            
            <form id="form_resetpw" method="post" action="resetpw.do">
            
	            <table>
	
	                <colgroup>
	                    <col width="20%"/>
	                    <col width="*"/>
	                </colgroup>
	                <tr>
	                    <td>사원번호</td>
	                    <td><input type="text" class="table_normal_txt" id="req2_empno" name="unum" style="width: 95%;"></td>
	                </tr>
	                <tr>
	                    <td>아이디</td>
	                    <td><input type="text" class="table_normal_txt" style="width: 95%;" id="req2_id" name="uuid"></td>
	                </tr>
	                <tr>
	                    <td>이메일</td>
	                    <td><input class="table_normal_txt" type="email" style="width: 95%;" id="req2_email" name="uemail" placeholder="example@gmail.com"></td>
	                </tr>
	                <tr height="28rem">
	                    <td></td>
	                    <td>
	                        <div id="alert_msg2" style="color:red; font-size:12rem;"> </div>
	                    </td>
	                </tr>
	    
	            </table>
	        
	        
            <br>
            <div class="pBtn">
                <span id="popY2">확 인</span>
                <span id="popN2">취 소</span>
            </div>
	        </form>

        </div>
    </div>
    <!-- 팝업창2  -->


</body>
</html>