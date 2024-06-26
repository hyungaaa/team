window.addEventListener("DOMContentLoaded", function () {
    bind();

    document.querySelector(".navi-item4").setAttribute("class", "navi-item navi-item4 active");

})

function bind() {

    // 테이블 행 추가
    let plusTr = document.getElementById('plusTr');
    plusTr.addEventListener('click', function () {

        let tbl = document.getElementById('inReg-tbl2');
        let today = new Date();
        let year = today.getFullYear();
        let month = ('0' + (today.getMonth() + 1)).slice(-2);
        let day = ('0' + today.getDate()).slice(-2);
        let todayString = year + '-' + month + '-' + day;

        let html = '';
        html += '<tr>';
        html += '  <td><input type="checkbox"></td>';
        html += '  <td>' + todayString + '</td>';
        html += '  <td>' + pdtNum.value + '</td>';
        html += '  <td>' + pdtName.value + '</td>';
        html += '  <td>' + locSelect.value + '</td>';
        html += '  <td>' + outCount.value + '</td>';
        html += '  <td>' + count.value + '</td>';
        html += '  <td>' + (count.value - outCount.value) + '</td>';
        html += '  <td>미등록</td>';
        html += '  <td></td>';
        html += '  <td></td>';
        html += '</tr>';

        if (pdtName.value == '') {
            alert('제품을 검색해주세요.');
        } else if (outCount.value != '') {
            tbl.innerHTML += html;
        } else {
            alert('수량을 입력해주세요');
        }

    })

    
    // 삭제 버튼
	let selected_del = document.getElementById("selected_del");
	
	// 삭제 버튼 클릭시 아래 테이블 행 삭제
	selected_del.addEventListener("click", function() {

		let chkValue;
		let list_checked = document.querySelectorAll(".chk:checked")
		
		for (let i = 0; i < list_checked.length; i++) {
			chkValue = list_checked[i].value;
			list_checked[i].parentNode.parentNode.remove();
			// console.log(list_checked[i].parentNode);
			// console.log(list_checked[i].parentNode.parentNode)
		}
		console.log('삭제 chkValue:' + chkValue);
		
		let url = "outReg/delete?chkValue=";

        // ajax 객체 생성
        let xhr = new XMLHttpRequest();
        // 보낼 준비
        xhr.open("get", url + chkValue);
		console.log('삭제 chkValue : ' + chkValue);	// undefined
        // 보내기(단! 언제 끝날지 모름)
        xhr.send();

        // 다녀온 후(응답 이후)
        xhr.onload = function () {
            // 받아온 내용이 저장되는 곳
            let data = xhr.responseText;
//            console.log(data);
            
            let parser = new DOMParser();
			let doc = parser.parseFromString(xhr.responseText, "text/html");
			// 체크박스 td
//			let tblTd = doc.querySelector('#inReg-tbl2 tbody tr td');
//			let chkValue = tblTd.querySelector('.chk').value;
//            console.log(chkValue);

        }
		
		
	})
  
	// 등록 버튼
	let add_btn = document.getElementById("add-btn");
	add_btn.addEventListener("click", function() {

		console.log('등록누름');
		let list_chks = document.querySelectorAll(".chk");
		let list_checked = document.querySelectorAll(".chk:checked");
		console.log('체크박스 개수:' + list_chks.length);
		console.log('체크된 개수:' + list_checked.length);
		
		let chkValues = [];
		let chkValue;
		
		if(list_checked.length > 0) {
			for (let i = 0; i < list_checked.length; i++) {
			console.log('list_checked[i].value : ' + list_checked[i].value);
			chkValue = list_checked[i].value;
			chkValues.push(list_checked[i].value);
			
			console.log('chkValues:' + chkValues);
//			let tr = list_checked[i].parentNode.parentNode;
//			console.log("tr : " + tr);
//			console.log(list_checked[i].parentNode);
//			console.log(list_checked[i].parentNode.parentNode);
			}
		}
		
//		let chkValue = list_checked.value;
		console.log('chkValue : ' + chkValue)	// undefined
		
		
		let url = "outReg/update?chkValue=";

        // ajax 객체 생성
        let xhr = new XMLHttpRequest();
        // 보낼 준비
        xhr.open("get", url + chkValue);
		console.log('chkValue : ' + chkValue);	// undefined
        // 보내기(단! 언제 끝날지 모름)
        xhr.send();

        // 다녀온 후(응답 이후)
        xhr.onload = function () {
            // 받아온 내용이 저장되는 곳
            let data = xhr.responseText;
            console.log(data);
            
            let parser = new DOMParser();
			let doc = parser.parseFromString(xhr.responseText, "text/html");
			// 체크박스 td
			let tblTd = doc.querySelector('#inReg-tbl2 tbody tr td');
			let chkValue = tblTd.querySelector('.chk').value;
            console.log(chkValue);
            
            location.href="outReg"

        }
		

	})

    // 조회 버튼
    // main_btn 버튼 클릭 시 실행되는 함수
    let dateBtn = document.querySelector('#dateCheck');
    dateBtn.addEventListener('click', function () {
        // inputDate 요소에서 선택된 날짜 가져오기
        var selectedDate = document.querySelector('.inputDate').value;
        console.log('selectedDate : ' + selectedDate);

        // inReg-tbl2 테이블의 모든 행 가져오기
        var rows = document.querySelectorAll('#inReg-tbl2 tbody tr');
        console.log('rows : ' + rows);

        // 모든 행 숨기기
        for (var i = 0; i < rows.length; i++) {
            rows[i].style.display = 'none';
        }

        // 등록일이 선택된 날짜와 동일한 행들을 보여주기
        for (var i = 0; i < rows.length; i++) {
            var rowDate = rows[i].querySelector('td:nth-child(2)').innerText; // 등록일 셀
            console.log('rowDate : ' + rowDate);

            // 등록일이 선택된 날짜와 동일한 경우 해당 행을 표시
            if (rowDate === selectedDate) {
                rows[i].style.display = 'table-row';
            }
        }
    })


}

// popup창 띄우기
function openPopup() {
    document.getElementById('popup').style.display = "block";
    //  document.getElementById('popup-tbl').innerHTML = "";
    //	document.getElementById('popup-tbl').style.display = "none";
    document.getElementById("searchInput").value = "";
}

// popup창 끄기
function closePopup() {
    document.getElementById('popup').style.display = "none";
}

// 검색 버튼
function outRegSearch() {
    var searchInput = document.getElementById("searchInput").value;

    // AJAX를 사용하여 서블릿으로 검색어 전달
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "outReg/search?searchInput=" + searchInput, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {

            console.log("searchInput : " + searchInput)
            // xhr.responseText에서 필요한 부분만 추출
            var parser = new DOMParser();
            var doc = parser.parseFromString(xhr.responseText, "text/html");
			console.log(doc);
			console.log(xhr.responseText);
            var popupTr = doc.querySelectorAll('#popup-tr');	// 맨 위 tr만 나옴 쿼리셀렉터로 해야함
            console.log(popupTr)
            let popup_tbody = document.getElementById("popup-tboby");

//            document.getElementById('popup-tbl').style.display = "block";
            popup_tbody.innerHTML = "";

            // 팝업에서 뜨는 제품들
            for (var i = 0; i < popupTr.length; i++) {
                console.log(popupTr[i]);
                popup_tbody.append(popupTr[i]);
            }
            console.log(popup_tbody);
            console.log(xhr.responseText);
            
        }
    };
    xhr.send();
}


function checkedPopup() {
    closePopup();
    // 라디오버튼
    let searchInput = document.querySelector('input[name="inReg-radio"]:checked').value;
    let locSelect = document.getElementById('locSelect');

    //    let count = document.getElementById('count');
    console.log(searchInput);

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "outReg/search?searchInput=" + searchInput, true);
    xhr.onload = function () {
        let pdtName = document.getElementById('pdtName');
        let pdtNum = document.getElementById('pdtNum');
        let size = document.getElementById('size');
        let unit = document.getElementById('unit');
        let count = document.getElementById('count');

        // xhr.responseText에서 필요한 부분만 추출
        var parser = new DOMParser();
        var doc = parser.parseFromString(xhr.responseText, "text/html");
        console.log(doc);
        var popupTr = doc.querySelectorAll('#popup-tr');
        for(let i=0; i<popupTr.length; i++) {
//        	console.log(popupTr[i]);
	        var tds = popupTr[i].querySelectorAll('td');
	        if(tds[1].innerText == searchInput) {
	        	console.log('같다');
		        pdtNum.value = tds[1].innerText;
		        pdtName.value = tds[2].innerText;
		        size.value = tds[3].innerText;
		        unit.value = tds[4].innerText;
		        console.log(tds[5])
		        count.value = tds[5].querySelector('#pincnt').value;
		        console.log(tds[5].querySelector('#pincnt').value);
		        document.querySelector('#pincnt').style.display = "none";
	        }
//	        console.log(tds);
//	        console.log(tds[0]);
//	        console.log(tds[1].innerText);
        }


        if (searchInput.substr(2, 1) == "A") {
            locSelect.value = locSelect[1].value;
        } else if (searchInput.substr(2, 1) == "B") {
            locSelect.value = locSelect[2].value;
        } else if (searchInput.substr(2, 1) == "C") {
            locSelect.value = locSelect[3].value;
        }

    };
    xhr.send();

}




