<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "java.util.List" %>
<%@ page import = "lim.itMngDTO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WMS 잘해보조</title>
    <link rel="stylesheet" href="css/layout.css">
	<link rel="stylesheet" href="css/ui.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/inReg.css">
    <link rel="stylesheet" href="css/itemMng.css">


    <script src="../js/system.js"></script>
    <script src="../js/item.js"></script>
    
    <script>
    <!-- 
    function validateForm() {
        var checkboxes = document.getElementsByName('selectedItems');
        var isChecked = false;
        
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                isChecked = true;
                break;
            }
        }
        
        if (!isChecked) {
            alert('삭제할 항목을 선택하세요.');
            return false;
        }

        return true;
    }
    -->
    function validateForm() {
        var checkboxes = document.getElementsByName('selectedItems');
        var isChecked = false;

        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                isChecked = true;
                break;
            }
        }

        if (!isChecked) {
            alert('삭제할 항목을 선택하세요.');
            return false;
        }

        return true;
    }
    
	    function confirmAndDelete() {
	        if (confirm('선택한 제품을 삭제하시겠습니까?')) {
	            // 서버에 삭제 요청을 보내는 코드 추가
	            document.forms[0].submit(); // 폼 제출
	        }
	        return false; // 기존의 confirm 창에서도 확인을 누르면 폼이 두 번 제출되는 것을 방지
	    }
	</script>


</head>
<body>


    <%@include file="header.jsp" %>	
    
    <%@include file="nav.jsp" %>
    	
    <main>
    <!-- 입출고 이력 -->

    <!-- 대분류 카테고리 -->
    <div id="bigCategory">
        <ul>
            <li onclick="filterCategory('간편식사')" class="find-item"><a href="itemMng.jsp"><span class="mng_span">간편식사</span>></a>
                <ul class="sub-menu">
                    <li><a href="#" onclick="filterCategory('도시락')">도시락</a></li>
                    <li><a href="#" onclick="filterCategory('샌드위치/햄버거')">샌드위치/햄버거</a></li>
                    <li><a href="#" onclick="filterCategory('주먹밥')">주먹밥</a></li>
                    <li><a href="#">기타</a></li>
                </ul>
            </li>
            <li onclick="filterCategory('과자류')" class="find-item"><a href="itemMng_snack.html"><span class="mng_span">과자류</span>></a>
                <ul class="sub-menu">
                    <li><a href="#">스낵/비스켓</a></li>
                    <li><a href="#">빵/디저트</a></li>
                    <li><a href="#">껌/초콜릿/캔디</a></li>
                    <li><a href="#">기타</a></li>
                </ul>
            </li>
            <li onclick="filterCategory('아이스크림')" class="find-item"><a href="itemMng_icecream.html"><span class="mng_span">아이스크림</span>></a>
                <ul class="sub-menu">
                    <li><a href="#">콘</a></li>
                    <li><a href="#">바</a></li>
                    <li><a href="#">샌드</a></li>
                    <li><a href="#">기타</a></li>
                </ul>
            </li>
            <li onclick="filterCategory('식품')" class="find-item"><a href="itemMng_fresh.html"><span class="mng_span">식품</span>></a>
                <ul class="sub-menu">
                    <li><a href="#">가공식사</a></li>
                    <li><a href="#">안주류</a></li>
                    <li><a href="#">기타</a></li>
                </ul>
            </li>
            <li onclick="filterCategory('음료')" class="find-item"><a href="itemMng_beverage.html"><span class="mng_span">음료</span>></a>
                <ul class="sub-menu">
                    <li><a href="#">음료</a></li>
                    <li><a href="#">유제품</a></li>
                    <li><a href="#">기타</a></li>
                </ul>
            </li>
        </ul>
        <button class="main_btn" onclick="setting_btn()">카테고리 설정</button>
    </div>
    
    <!-- 소분류 카테고리 -->
    <div id="all1"> 
    <div id="scate">
        <button class="main_btn" id="scate_mng" onclick="filterCategory('전체')">전체</button>
        <button class="main_btn" id="scate_mng" onclick="filterCategory('도시락')">도시락</button>
        <button class="main_btn" id="scate_mng" onclick="filterCategory('샌드위치/햄버거')">샌드위치/햄버거</button>
        <button class="main_btn" id="scate_mng" onclick="filterCategory('주먹밥')">주먹밥</button>
        <button class="main_btn" id="scate_mng" onclick="filterCategory('기타')">기타</button>
    </div>

    <!-- 선 -->


    <!-- 검색 창 -->
    <div id="search">
        <input type="text" class="main_search_txt_mng" placeholder="검색어 입력">
        <button class="main_btn_mng">검색</button>
    </div>

    <!-- 제품 게시판? -->
    <div id="productBoard">
        <form action="itMngD" method="post"
         onsubmit="return validateForm();"> <!-- 폼 추가 -->
        <table class="table_mng">
        <colgroup>
               <col width="7%" />
               <col width="30%" />
               <col width="20%" />
               <col width="10%" />
               <col width="7%" />  
               <col width="10%" />  
               <col width="8%" />  
            </colgroup>
            
            <%-- 데이터 불러옴 --%>
            <%
            	List list = (List) request.getAttribute("list");
            	// itMngDTO itmngDTO = new itMngDTO();
            
            %>
            
            <tr id="title_mng">
                <th><input type="checkbox" id="selectAll" onclick="toggleCheckboxes(this)"></th>
                <th>제품명</th>
                <th>소분류</th>
                <th>제품번호</th>
                <th>보관위치</th>
                <th>등록일</th>
                <th>규격</th>
            </tr>
            
            <%
            	if (list != null) {
					for(int i = 0; i < list.size(); i++) {
	
			%>
            
            <tr class="product-row" data-category="<%= ((itMngDTO)list.get(i)).getSct() %>">
                <td><input type = "checkbox" class="chk"  
                name="selectedItems" value="<%= ((itMngDTO)list.get(i)).getPnum() %>"></td>
                <td><%= ((itMngDTO)list.get(i)).getPname() %></td>
                <td><%= ((itMngDTO)list.get(i)).getSct() %></td>
                <td><%= ((itMngDTO)list.get(i)).getPnum() %></td>
                <td><%= ((itMngDTO)list.get(i)).getWzone() %></td>
                <td><%= ((itMngDTO)list.get(i)).getPday() %></td>
                <td><%= ((itMngDTO)list.get(i)).getPsize() %></td>
           	</tr>
         
            <%
				}
            } else {
            	System.out.println("null입니다~.");
            }
			%>
        </table>
    	</form>
        </div>
    

    <!-- 페이지 -->
    <div id="div-ul_mng">
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
        
        <div id="button_mng_2">
            <button type="button" class="main_btn" id="selected_del" onclick="return confirmAndDelete()">제품 삭제</button>
            <button class="main_btn"><a href="itemNew.jsp" id="lim_a">제품 추가</button></a>          
        </div>

    </div>
    
    </main>
    
   <%@include file="footer.jsp" %>
   
</body>
</html>