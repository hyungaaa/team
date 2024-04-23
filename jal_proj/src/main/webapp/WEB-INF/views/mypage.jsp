<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" href="${path}/css/mypage2.css">
<script src="${path}/js/system.js"></script>
<script src="${path}/js/hello.js"></script>

<main>
	<form action="${path}/updateUserInfo" method="post">
		<div>
			<a href="이동 주소"><img src="img/user.png" width="200px"
				style="float: right;"> </a>
			<p style="width: 200px; margin-top: 0; margin-bottom: 5px;"
				class="mypage2_p">사용자 정보</p>

			<div id="mypage2_div" style="width: 850px;">
				<span>&emsp;사원번호&nbsp;&nbsp;&emsp;&emsp;<input type="text"
					class="main_normal_txt" name="unum" value="${myPageUserInfo.unum}"
					style="border-radius: 5rem;"></span> <span>&emsp;이름&emsp;&emsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt" name="uname"
					value="${myPageUserInfo.uname}" style="border-radius: 5rem;"></span>
				<span>&emsp;아이디&nbsp;&emsp;&emsp;&emsp;<input type="text"
					class="main_normal_txt" name="uuid" value="${myPageUserInfo.uuid}"
					style="border-radius: 5rem;" readonly></span> <span>&emsp;새
					비밀번호 &emsp;<input type="password" class="main_normal_txt"
					placeholder="내용을 입력해주세요." style="border-radius: 5rem;" disabled>
					<a style="font-weight: 400; font-size: 14px;">(비밀번호는 6~12자리
						영문자와 숫자조합으로 작성할 수 있습니다)</a>
				</span> <span>&emsp;비밀번호 확인 <input type="password"
					class="main_normal_txt" placeholder="내용을 입력해주세요."
					style="border-radius: 5rem;" disabled> <a
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
					style="border-radius: 5rem;" disabled></span> <span>&emsp;직급&nbsp;&emsp;&emsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt" name="uposition"
					value="${myPageUserInfo.uposition}" style="border-radius: 5rem;"></span>
				<span>&emsp;소속&nbsp;&emsp;&emsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt" name="ccode"
					value="${myPageUserInfo.ccode}" style="border-radius: 5rem;"></span>
			</div>
			<div style="width: 500px; float: right; margin-top: -125px;">
				<span>&emsp;생년월일&nbsp;&nbsp;&emsp;<input type="date"
					class="main_normal_txt" style="border-radius: 5rem;" name="ubirth"
					value="<fmt:formatDate value="${myPageUserInfo.ubirth}" pattern="yyyy-MM-dd" />"></span>
				<br> <span>&emsp;휴대폰&nbsp;&nbsp;&emsp;&emsp;<input
					type="text" class="main_normal_txt"
					style="margin-top: 5px; border-radius: 5rem;" name="utel"
					value="${myPageUserInfo.utel}"></span><br> <span>&emsp;이메일&nbsp;&nbsp;&emsp;&emsp;<input
					type="email" class="main_normal_txt"
					style="margin-top: 5px; border-radius: 5rem;" name="uemail"
					value="${myPageUserInfo.uemail}"></span><br> <span>&emsp;등록일&nbsp;&nbsp;&emsp;&emsp;<input
					type="date" class="main_normal_txt"
					style="margin-top: 5px; border-radius: 5rem;" name="udate"
					value="<fmt:formatDate value="${myPageUserInfo.udate}" pattern="yyyy-MM-dd" />"></span><br>
			</div>
		</div>

		<hr
			style="width: 1100px; border-color: #ccc; padding: 0%; margin-top: 46px;">
		<div style="text-align: center; margin-top: 5px;">
			<button type="submit" class="main_btn">저장</button>
			<button type="button" class="main_btn2">취소</button>
		</div>
	</form>
</main>