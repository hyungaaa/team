window.addEventListener("load", function(){
    bind();
});

function bind(){
    
    preventEnter();
    id_event();
    pw_event();
    login();
    request1();
    request2();
    
};

//id에서 엔터 입력시 password로 이동
function id_event(){
    document.querySelector("#userid")
    .addEventListener("keyup", function (event) {
        console.log(event.keyCode)
        if (event.keyCode == 13 && document.querySelector("#userid").value == "") {
            document.querySelector("#alert_msg").innerHTML='<span >아이디를 입력하세요</span>';
        } else if(event.keyCode == 13){
            document.querySelector("#pw").value = "";
            document.querySelector("#pw").focus();
        } ;
    });
};

//password에서 엔터 입력시 자동으로 로그인 버튼 클릭
function pw_event(){
document.querySelector("#pw")
    .addEventListener("keyup", function (event) {
        console.log(event.keyCode)
        if (event.keyCode == 13 && document.querySelector("#pw").value == "" && document.querySelector("#userid").value == "") {
            document.querySelector("#alert_msg").innerHTML='<span >아이디를 입력하세요</span>';
        } else if(event.keyCode == 13 && document.querySelector("#userid").value !== "" && document.querySelector("#pw").value == "") {
            document.querySelector("#alert_msg").innerHTML='<span >비밀번호를 입력하세요</span>';
        } else if(event.keyCode == 13 && document.querySelector("#userid").value !== "" && document.querySelector("#pw").value !== "") {
            document.querySelector("#login_btn").click();
        } ;
    });
};

function preventEnter(){
	document.querySelector("#form").addEventListener("keydown", function(event) {
	    if (event.key === "Enter") {
	      event.preventDefault();
	    }
	});
	document.querySelector("#form_idreg").addEventListener("keydown", function(event) {
	    if (event.key === "Enter") {
	      event.preventDefault();
	    }
	});
}
 

function login(){
    document.querySelector("#login_btn").addEventListener("click", function(){		
		
/*        var userId = document.querySelector("#userid").value;
        var password = document.querySelector("#pw").value;

        if (userId === "admin" && password === "admin") {
            // 관리자 로그인 성공 시, 
            localStorage.setItem('userType', 'admin');
            window.location.href = "dashboard.html";
        } else if(userId === "user" && password === "user") {
            // 사용자 로그인 성공 시, 
            localStorage.setItem('userType', 'user');
            window.location.href = "dashboard.html";
        } else {
            // 로그인 실패 시, 
            document.querySelector("#alert_msg").innerHTML = '<span>아이디 또는 비밀번호가 올바르지 않습니다</span>';
        };*/
        
        
        // 로그인 실패 시,
        document.querySelector("#alert_msg").innerHTML = '<span>아이디 또는 비밀번호가 올바르지 않습니다</span>';

        
        document.querySelector("#form").submit();
        
    });
}





function request1(){
    // 버튼 클릭 시 div 보이게 하기
    document.querySelector("#request1_btn").addEventListener("click", function(){
        document.querySelector(".popup1").style.display = "block";
        document.querySelector(".popup-content1").style.display = "block";
    });

    emailValid();
    
    
    
    //중복확인 버튼 기능
    let validId = false;
    document.querySelector("#id_check").addEventListener("click", function(event){
		event.preventDefault();
		
		if(document.querySelector("#req1_id").value.length < 5 ){
			alert("아이디는 5자리 이상 입력해주세요");
		} else {
		
		
			// AJAX로 중복확인 서블릿 이동
			var xhr = new XMLHttpRequest();
		    xhr.open("GET", "idcheck.do?uuid=" + document.querySelector("#req1_id").value, true);
		    xhr.onreadystatechange = function() {
		        if (xhr.readyState === XMLHttpRequest.DONE) {
					
		            var response = xhr.responseText; // 서블릿에서 반환된 응답
		            
		            if (response.includes("invalid")) {
		                alert("사용 불가능한 아이디입니다");
		                validId = false;
		            } else {
		                alert("사용 가능한 아이디입니다");
		                validId = true;
		            }
		            
					
		        }
		    };
		    xhr.send();
				
		}
	});


    // 확인 버튼 클릭시 실행& div 안보이게 하기
    document.querySelector("#popY1").addEventListener("click", function(){

        if (document.querySelector("#req1_empno").value =="" || document.querySelector("#req1_email").value == "" || document.querySelector("#req1_id").value ==""){
            document.querySelector("#alert_msg1").innerHTML='<span>내용을 입력하세요</span>';
        } else{
            
            // 아이디 유효성 검사 확인 후
            if(validId){
				document.querySelector(".popup1").style.display = "none";
            	document.querySelector(".popup-content1").style.display = "none";
            	
            	document.querySelector("#form_idreg").submit();
	            alert("요청되었습니다");
	            input_clear();
			} else {
				alert("아이디를 확인하세요");
			}
            
            
        }
    });
    document.querySelector("#popN1").addEventListener("click", function(){
        document.querySelector(".popup1").style.display = "none";
        document.querySelector(".popup-content1").style.display = "none";
        input_clear();
    });

}




function request2(){
    // 버튼 클릭 시 div 보이게 하기
    document.querySelector("#request2_btn").addEventListener("click", function(){
        console.log("click");
        document.querySelector(".popup2").style.display = "block";
        document.querySelector(".popup-content2").style.display = "block";
    });

    emailValid();

    // 버튼 클릭시 div 안보이게 하기
    document.querySelector("#popY2").addEventListener("click", function(){
        if (document.querySelector("#req2_empno").value =="" || document.querySelector("#req2_email").value == "" || document.querySelector("#req2_id").value ==""){
            document.querySelector("#alert_msg2").innerHTML='<span>내용을 입력하세요</span>';
        } else{
			
			
        	// AJAX로 비밀번호초기화 요청 서블릿 이동
			var xhr = new XMLHttpRequest();
		    xhr.open("GET", "resetpw.do?unum=" + document.querySelector("#req2_empno").value + "&uuid=" + document.querySelector("#req2_id").value + "&uemail=" + document.querySelector("#req2_email").value, true);
		    xhr.onreadystatechange = function() {
		        if (xhr.readyState === XMLHttpRequest.DONE) {
					
		            var response = xhr.responseText; // 서블릿에서 반환된 응답
		            
		            if (response.includes("no match-unum")) {
						
		                alert("일치하는 사원번호가 없습니다");
		                
		            } else if (response.includes("no match-uemail")) {
						
		                alert("이메일 주소가 일치하지 않습니다");
		                
		            } else {
						
						document.querySelector(".popup2").style.display = "none";
		        		document.querySelector(".popup-content2").style.display = "none";
		        		alert("요청되었습니다");
        		
					}
		            
		        }
		    };
		    xhr.send();
			    
			//document.querySelector("#form_resetpw").submit();
            
            input_clear();

        }
    });
    document.querySelector("#popN2").addEventListener("click", function(){
        document.querySelector(".popup2").style.display = "none";
        document.querySelector(".popup-content2").style.display = "none";
        input_clear();
    });
}


//유효 이메일 체크
function emailValid(){
    document.querySelector("#req1_email")
    .addEventListener("keyup", function (event) {

        var ePattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

        if (ePattern.test(document.querySelector("#req1_email").value)) {
            document.querySelector("#alert_msg1").innerHTML='<span>ok</span>';
        } else {
            document.querySelector("#alert_msg1").innerHTML='<span>적절하지 않은 이메일 형식입니다</span>';
        };
    });

    document.querySelector("#req2_email")
    .addEventListener("keyup", function (event) {

        var ePattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

        if (ePattern.test(document.querySelector("#req2_email").value)) {
            document.querySelector("#alert_msg2").innerHTML='<span>ok</span>';
        } else {
            document.querySelector("#alert_msg2").innerHTML='<span>적절하지 않은 이메일 형식입니다</span>';
        };
    });
};

// 팝업창 내용 지우기
function input_clear(){
    document.querySelector("#req1_empno").value ="";
    document.querySelector("#req1_id").value ="";
    document.querySelector("#req1_email").value ="";
    document.querySelector("#req2_empno").value ="";
    document.querySelector("#req2_id").value ="";
    document.querySelector("#req2_email").value ="";
    document.querySelector("#alert_msg1").innerText ="";
    document.querySelector("#alert_msg2").innerText ="";
}