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
<link rel="stylesheet" href="css/mypage.css">
<link rel="stylesheet" href="css/mypage2.css">
<script src="js/system.js"></script>
<script src="js/hello.js"></script>

</head>

<body>
	<%@include file="layout/header.jsp"%>
	<%@include file="layout/nav.jsp"%>

	<main>
		<div>
			<a href="이동할 주소"><img src="img/user.png" width="200px"
				style="float: right;"> </a>
			<p style="width: 200px; margin-top: 0; margin-bottom: 5px;"
				class="mypage2_p">사용자 정보</p>
			<div id="mypage2_div" style="width: 850px;">
				<span>&emsp;사원번호&nbsp;&nbsp;&emsp;&emsp;<input type="text"
					class="main_normal_txt" placeholder="${unum}"
					style="border-radius: 5rem;"></span> <span>&emsp;이름&emsp;&emsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt" placeholder="${uname}"
					style="border-radius: 5rem;"></span> <span>&emsp;아이디&nbsp;&emsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt" placeholder="${uuid}"
					style="border-radius: 5rem;"></span> <span>&emsp;새 비밀번호
					&emsp;<input type="password" class="main_normal_txt"
					placeholder="내용을 입력해주세요." style="border-radius: 5rem;"> <a
					style="font-weight: 400; font-size: 14px;">(비밀번호는 6~12자리 영문자와
						숫자조합으로 작성할 수 있습니다)</a>
				</span> <span>&emsp;비밀번호 확인 <input type="password"
					class="main_normal_txt" placeholder="내용을 입력해주세요."
					style="border-radius: 5rem;"> <a
					style="font-weight: 400; font-size: 14px;">비밀번호 변경 시에만 입력해주세요</a></span>
			</div>
			<button type="button" class="main_btn"
				style="float: right; margin-top: -50px; margin-right: 100px; width: auto">파일등록</button>
			<button type="button" class="main_btn2"
				style="float: right; margin-top: -50px;">초기화</button>
		</div>
		<hr style="border-color: #ccc; padding: 0%">
		<p style="width: 200px; margin-top: -5px; margin-bottom: 5px;"
			class="mypage2_p">회원 정보</p>
		<div>
			<div id="mypage2_div" style="width: 500px;">
				<span>&emsp;등급&nbsp;&emsp;&emsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt" placeholder="근무자"
					style="border-radius: 5rem;"></span> <span>&emsp;직급&nbsp;&emsp;&emsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt" placeholder="${uposition}"
					style="border-radius: 5rem;"></span> <span>&emsp;소속&nbsp;&emsp;&emsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt" placeholder="${ccode}"
					style="border-radius: 5rem;"></span>
			</div>
			<div style="width: 500px; float: right; margin-top: -125px;">
				<span>&emsp;생년월일&nbsp;&nbsp;&emsp;<input type="date"
					class="main_normal_txt" style="border-radius: 5rem;"></span> <br>
				<span>&emsp;휴대폰&nbsp;&nbsp;&emsp;&emsp;<input type="text"
					class="main_normal_txt" placeholder="010-0000-0000"
					style="margin-top: 5px; border-radius: 5rem;"></span><br> <span>&emsp;이메일&nbsp;&nbsp;&emsp;&emsp;<input
					type="email" class="main_normal_txt" placeholder="sss@naver.com"
					style="margin-top: 5px; border-radius: 5rem;"></span><br> <span>&emsp;등록일&nbsp;&nbsp;&emsp;&emsp;<input
					type="date" class="main_normal_txt"
					style="margin-top: 5px; border-radius: 5rem;"></span><br>
			</div>
		</div>
		<hr
			style="width: 1100px; border-color: #ccc; padding: 0%; margin-top: 46px;">
		<div style="text-align: center; margin-top: 5px;">
			<button type="button" class="main_btn">저장</button>
			<button type="button" class="main_btn2">취소</button>
		</div>
	</main>

	<%@include file="layout/footer.jsp"%>
</body>
</html>