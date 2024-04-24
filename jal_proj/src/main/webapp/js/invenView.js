document.addEventListener("DOMContentLoaded", function() {

	document.querySelector(".navi-item5").setAttribute("class", "navi-item navi-item5 active");

});


// 검색
function goSearch() {
	// input창
	let input = document.getElementById("searchInput").value.toUpperCase();
	// select 옵션
	let selectOption = document.getElementById("selectOption").value;

	let tbl = document.getElementById("tbl");
	let tbody = tbl.getElementsByTagName("tbody")[0];
	let rows = tbody.getElementsByTagName("tr");

	for (let i = 0; i < rows.length; i++) {
		const cells = rows[i].getElementsByTagName("td");
		let match = false;

		for (let j = 0; j < cells.length; j++) {
			const cell = cells[j];
			const txtValue = cell.textContent || cell.innerText;

			if (selectOption === "all") {
				if (txtValue.toUpperCase().indexOf(input) > -1) {
					match = true;
					break;
				}
			} else if (selectOption === "productName" && j === 3) {
				if (txtValue.toUpperCase().indexOf(input) > -1) {
					match = true;
					break;
				}
			} else if (selectOption === "productCode" && j === 2) {
				if (txtValue.toUpperCase().indexOf(input) > -1) {
					match = true;
					break;
				}
			} else if (selectOption === "LOT" && j === 0) {
				if (txtValue.toUpperCase().indexOf(input) > -1) {
					match = true;
					break;
				}
			} else if (selectOption === "locCode" && j === 1) {
				if (txtValue.toUpperCase().indexOf(input) > -1) {
					match = true;
					break;
				}
			}
		}

		rows[i].style.display = match ? "" : "none";
	}
}

// 재고보정 버튼
//function modCnt() {
//  let tbl = document.getElementById("tbl");
//  let tbody = tbl.getElementsByTagName("tbody")[0];
//  let rows = tbody.getElementsByTagName("tr");
//
//  for (let i = 1; i < tbl.rows.length; i++) {
//    tbl.rows[i].cells[6].onclick = function () {
//      tbl.rows[i].cells[5].innerHTML = "<input class='table_blind_txt mod-txt' id='modifyTxt' type='text'>";
//      tbl.rows[i].cells[6].innerHTML = "<button type='button' class='table_btn' id='confirmBtn'>확인</button>";
//
//      // 확인 버튼의 클릭 이벤트 핸들러 설정
//      document.getElementById("confirmBtn").onclick = function () {
//        let modifyTxt = document.getElementById("modifyTxt").value;
//        tbl.rows[i].cells[5].innerHTML = modifyTxt;
//        tbl.rows[i].cells[6].innerHTML = "<button type='button' class='table_btn' id='modBtn' onclick='modCnt()'>재고보정</button>";
//
//        // 폼 제출
//        let form = document.getElementById("invenForm");
//        console.log("왜 실행 안됨")
//        form.submit();
//      };
//    };
//  }
//}



function modCnt(btn) {
	var btn = event.target; // 클릭된 버튼을 가져옵니다.
	var row = btn.closest("tr"); // 해당 버튼이 속한 행을 가져옵니다.
	var allButtons = row.querySelectorAll('.table_btn'); // 해당 행의 모든 버튼을 선택합니다.

	// 모든 버튼을 비활성화합니다.
	for (var i = 0; i < allButtons.length; i++) {
		allButtons[i].disabled = true;
	}

	btn.disabled = false; // 클릭된 버튼만 활성화합니다.

	var icntInput = row.querySelector("input[name='icnt']");
	icntInput.removeAttribute("readonly"); // 해당 행의 재고 수량 input 요소의 readonly 속성을 제거합니다.
	btn.onclick = function() { confirmUpdate(btn); }; // 버튼의 클릭 이벤트를 confirmUpdate 함수로 변경합니다.

	var modifyBtn = document.getElementById("modBtn"); // 수정 버튼을 가져옵니다.
	var confirmBtn = document.getElementById("confirmBtn"); // 확인 버튼을 가져옵니다.

	modifyBtn.style.display = "none"; // 수정 버튼을 숨깁니다.
	confirmBtn.style.display = "inline"; // 확인 버튼을 보이게 합니다.
}

function confirmUpdate(btn) {
	var row = btn.closest("tr"); // 해당 버튼이 속한 행을 가져옵니다.
	var icntInput = row.querySelector("input[name='icnt']");
	var plotInput = row.querySelector("input[name='plot']");

	// 예를 들어, 서버로 업데이트 요청을 보낸 후에 성공적으로 처리되었다는 메시지를 사용자에게 표시합니다.
	alert("LOT 번호 " + plotInput.value + "의 재고가 성공적으로 업데이트되었습니다.");

	icntInput.setAttribute("readonly", true); // 해당 행의 재고 수량 input 요소를 다시 읽기 전용으로 변경합니다.
	btn.onclick = function() { modCnt(btn); }; // 버튼의 클릭 이벤트를 modCnt 함수로 변경합니다.
}


