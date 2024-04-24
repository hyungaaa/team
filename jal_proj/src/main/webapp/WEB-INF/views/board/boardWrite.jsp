<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" href="css/boardWrite.css">
<script src="js/boardWrite.js"></script>
<script type="text/javascript"
	src='https://cdn.tiny.cloud/1/6iubxq7xzqgf3958wj5d8uhmql5oz2cuvj9y2zlgav7buznq/tinymce/7/tinymce.min.js'
	referrerpolicy="origin">
	
</script>
<script>
	tinymce
			.init({
				selector : '#btext',
				width : '100%',
				height : 270,
				plugins : [ 'advlist', 'autolink', 'link', 'image', 'lists',
						'charmap', 'preview', 'anchor', 'pagebreak',
						'searchreplace', 'wordcount', 'visualblocks',
						'visualchars', 'code', 'fullscreen', 'insertdatetime',
						'media', 'table', 'emoticons', 'help' ],
				toolbar : 'undo redo | styles | bold italic | alignleft aligncenter alignright alignjustify | '
						+ 'bullist numlist outdent indent | link image | print preview media fullscreen | '
						+ 'forecolor backcolor emoticons | help',
				menu : {
					favs : {
						title : 'My Favorites',
						items : 'code visualaid | searchreplace | emoticons'
					}
				},
				menubar : 'favs file edit view insert format tools table help',
				content_css : 'css/content.css'
			});
</script>
<main>
	<form method="get" action="boardWrite2">
		<div class="dt1">
			<table class="t1">
				<tr>
					<td class="left"><select class="main_normal_txt"
						style="width: 90%;">
							<option>대분류</option>
							<option>간편식사</option>
							<option>과자류</option>
							<option>아이스크림</option>
							<option>식품</option>
							<option>음료</option>
					</select></td>
					<td class="right"><select class="main_normal_txt"
						style="width: 97.2%">
							<option>제품번호</option>
							<option>EJB00002 김)크랩가득유부초밥</option>
							<option>EJB00003 주)LT명란마요삼각</option>
							<option>EJB00004 주)놀라운매콤어묵삼각</option>
							<option>ECB00001 샐)놀라운치킨&에그무스</option>
							<option>EDB00001 도)놀라운치킨마요덮밥</option>
							<option>EDB00002 도)치즈닭갈비고구마밥</option>
							<option>ESB00001 샌)망곰초코딸기샌드</option>
							<option>ICA00003 나뚜루)녹차바</option>
							<option>BMB00005 남양)불가리스딸기150</option>
							<option>SCC00002 롯데)허쉬너겟쿠앤크6P</option>
							<option>FGC00004 CJ)햇반전복미역죽</option>
					</select></td>
				</tr>
				<tr>
					<td class="left">
						<p>제목</p>
					</td>
					<td class="right"><input type="text" name="btitle"
						class="main_normal_txt" placeholder="제목을 입력해주세요"
						style="width: 96%"></td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="btext" id="btext"
							placeholder="내용을 입력해주세요"></textarea></td>
				</tr>
			</table>
		</div>
		<input type="text" id="fileNameDisplay" class="main_normal_txt"
			readonly style="display: none;">

		<div class="sub2">
			<button type="button" class="main_btn2" id="sSize">
				<a href="boardList.jsp" style="color: #fff"> 취소 </a>
			</button>
			<input type="submit" class="main_btn" id="sSize">
		</div>
	</form>
</main>


