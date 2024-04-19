window.addEventListener("DOMContentLoaded", function () {
  bind();

  document.querySelector(".navi-item3").setAttribute("class", "navi-item navi-item3 active");

})

function bind() {

	// 추가 버튼
	let plusTr = document.getElementById('plusTr');
	
	// 추가 버튼 클릭시 아래 테이블에 행 추가
	plusTr.addEventListener('click', function() {
		let tbl = document.getElementById('inReg-tbl2');
		let today = new Date();
		let year = today.getFullYear();
		let month = ('0' + (today.getMonth() + 1)).slice(-2);
		let day = ('0' + today.getDate()).slice(-2);
		let todayString = year + '-' + month + '-' + day;

		let html = '';
		html += '<tr>';
		html += '  <td><input type="checkbox" class="chk"></td>';
		html += '  <td>' + todayString + '</td>';
		html += '  <td>' + pdtNum.value + '</td>';
		html += '  <td>' + pdtName.value + '</td>';
		html += '  <td>' + size.value + '</td>';
		html += '  <td>' + unit.value + '</td>';
		html += '  <td>' + count.value + '</td>';
		html += '  <td>미등록</td>';
		html += '  <td></td>';
		html += '  <td></td>';
		html += '</tr>';

		if (pdtName.value == '') {
			alert('제품을 검색해주세요.');
		} else if (count.value != '') {
			tbl.innerHTML += html;
		} else {
			alert('수량을 입력해주세요');
		}
	})

	// 삭제 버튼
	let selected_del = document.getElementById("selected_del");
	
	// 삭제 버튼 클릭시 아래 테이블 행 삭제
	selected_del.addEventListener("click", function() {

		let list_checked = document.querySelectorAll(".chk:checked")
		for (let i = 0; i < list_checked.length; i++) {
			list_checked[i].parentNode.parentNode.remove();
			// console.log(list_checked[i].parentNode);
			// console.log(list_checked[i].parentNode.parentNode)
		}
	})
  
	// 등록 버튼
	let add_btn = document.getElementById("add-btn");
	add_btn.addEventListener("click", function() {


		console.log('버튼이 눌리긴 했니?');
		
		

		let list_checked = document.querySelectorAll(".chk:checked");
		console.log(list_checked.length);
		
//		for (let i = 0; i < list_checked.length; i++) {
//			console.log(list_checked[i]);
//			let tr = list_checked[i].parentNode.parentNode;
//			console.log("tr : " + tr);
//			console.log(list_checked[i].parentNode);
//			console.log(list_checked[i].parentNode.parentNode);
//		}

	})
}

// popup창 띄우기
function openPopup() {
	document.getElementById('popup').style.display = "block";
	//  document.getElementById('popup-tbl').innerHTML = "";
	document.getElementById('popup-tbl').style.display = "none";
	document.getElementById("searchInput").value = "";
}

// popup창 끄기
function closePopup() {
	document.getElementById('popup').style.display = "none";
}


function checkedPopup() {
	closePopup();
	let radioBtn = document.querySelector('input[name="inReg-radio"]:checked').value;
	let locSelect = document.getElementById('locSelect');

	//    let count = document.getElementById('count');
	console.log(radioBtn);

	var xhr = new XMLHttpRequest();
	xhr.open("GET", "inReg?searchInput=" + radioBtn, true);
	xhr.onload = function() {
		let pdtName = document.getElementById('pdtName');
		let pdtNum = document.getElementById('pdtNum');
		let size = document.getElementById('size');
		let unit = document.getElementById('unit');

		// xhr.responseText에서 필요한 부분만 추출
		var parser = new DOMParser();
		var doc = parser.parseFromString(xhr.responseText, "text/html");
		console.log(doc);
		var popupTr = doc.querySelector('#popup-tr');
		console.log(popupTr);

		var tds = popupTr.querySelectorAll('td');
		console.log(tds);
		console.log(tds[0]);
		console.log(tds[1].innerText);

		pdtNum.value = tds[1].innerText;
		pdtName.value = tds[2].innerText;
		size.value = tds[3].innerText;
		unit.value = tds[4].innerText;

		if (radioBtn.substr(2, 1) == "A") {
			locSelect.value = locSelect[1].value;
		} else if (radioBtn.substr(2, 1) == "B") {
			locSelect.value = locSelect[2].value;
		} else if (radioBtn.substr(2, 1) == "C") {
			locSelect.value = locSelect[3].value;
		}


	};
	xhr.send();


}

function openWindow() {
	// 팝업 창 크기 설정
	var width = 400; // 팝업 창의 너비
	var height = 600; // 팝업 창의 높이

	// 화면 중앙에 팝업 창을 위치시키기 위한 계산
	var left = (window.screen.width / 2) - (width / 2);
	var top = (window.screen.height / 2) - (height / 2);

	// 새 팝업 창 열기
	window.open('qrpage.html', 'newWindow', 'width=' + width + ', height=' + height + ', top=' + top + ', left=' + left);
}


// inReg.js
function inRegSearch2() {
	var searchInput = document.getElementById("searchInput").value;

	// AJAX를 사용하여 서블릿으로 검색어 전달
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "inReg?searchInput=" + searchInput, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			console.log("searchInput : " + searchInput)
			// xhr.responseText에서 필요한 부분만 추출
			var parser = new DOMParser();
			var doc = parser.parseFromString(xhr.responseText, "text/html");
			console.log(doc)
			
			var popupTr = doc.querySelectorAll('#popup-tr');	// 맨 위 tr만 나옴 쿼리셀렉터로 해야함

			let popup_tbody = document.getElementById("popup-tboby");

			document.getElementById('popup-tbl').style.display = "block";
			popup_tbody.innerHTML = "";

			// 팝업에서 뜨는 제품들
			for (var i = 0; i < popupTr.length; i++) {
				console.log(popupTr[i]);
				popup_tbody.append(popupTr[i]);
			}
			console.log(popup_tbody);
			console.log(xhr.responseText);
			console.log(popupTr[0]);
		}
	};
	xhr.send();
}

