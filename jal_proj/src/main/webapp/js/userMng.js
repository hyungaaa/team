window.addEventListener("DOMContentLoaded", function() {
	bindEvents();

	// 초기 활성 탭 설정
	document.querySelector(".navi-item9").setAttribute("class", "navi-item navi-item9 active");
});

function bindEvents() {
	// 전체 선택 체크박스 기능
	document.querySelectorAll('input[id^="select_all"]').forEach(function(selectAllCheckbox) {
		selectAllCheckbox.addEventListener('change', function() {
			let columnIndex = this.parentElement.cellIndex + 1;
			let checkStatus = this.checked;
			let rows = checkRows();
			if (rows.length > 0) {
				rows.forEach(row => {
					row.querySelector(`td:nth-child(${columnIndex}) input[type='checkbox']`).checked = checkStatus;
				});
			} else {
				document.querySelectorAll(`tbody tr td:nth-child(${columnIndex}) input[type='checkbox']`).forEach(function(checkbox) {
					checkbox.checked = checkStatus;
				});
			}
		});
	});

	// 센터 변경 및 권한 변경 버튼 이벤트 리스너 추가
	document.getElementById('change_button1').addEventListener('click', function() {
		applySelectChange('select_change1', 4);
	});

	document.getElementById('change_button2').addEventListener('click', function() {
		applySelectChange('select_change2', 5);
	});

	// 검색 셀렉트 박스 선택 시 테이블 행 필터링
	document.getElementById("searchSelect").addEventListener("change", filterRows);

	// 수정 및 삭제 버튼 기능 설정
	setupEditAndDeleteButtons();
}

// 체크된 행만 반환하는 함수
function checkRows() {
	return Array.from(document.querySelectorAll('.select_chk:checked')).map(checkbox => checkbox.closest('tr'));
}

// 선택된 옵션을 적용하는 함수
function applySelectChange(selectId, columnIndex) {
	var selectedValue = document.getElementById(selectId).value;
	var rows = checkRows();
	if (rows.length > 0) {
		rows.forEach(row => {
			row.querySelector(`td:nth-child(${columnIndex}) select`).value = selectedValue;
		});
	} else {
		document.querySelectorAll(`tbody tr td:nth-child(${columnIndex}) select`).forEach(select => {
			select.value = selectedValue;
		});
	}
}

// 행 필터링 함수
function filterRows() {
	let selectedValue = this.value;
	document.querySelectorAll("#table_cap tr").forEach(row => {
		if (row.querySelector('select.main_search2_txt')) {
			let selectBoxes = row.querySelectorAll("select.main_search2_txt");
			let centerValue = selectBoxes[0].value;
			if (selectedValue === "센터 검색") {
				row.style.display = ""; // '센터 검색' 선택시 모든 행을 보여줌
			} else if (centerValue === selectedValue) {
				row.style.display = ""; // 선택한 센터와 일치하는 행만 보여줌
			} else {
				row.style.display = "none"; // 일치하지 않는 경우 해당 행을 숨김
			}
		}
	});
}


// 수정 및 삭제 버튼 설정 함수
function setupEditAndDeleteButtons() {
	document.querySelectorAll('.main_btn').forEach(button => {
		button.addEventListener('click', function() {
			let row = button.closest('tr');
			let cells = row.querySelectorAll('td:nth-child(2), td:nth-child(3)');
			cells.forEach(cell => {
				let inputValue = cell.innerText;
				cell.innerHTML = '<input type="text" class="edit-input" value="' + inputValue + '">';
			});

			let confirmButton = document.createElement('button');
			confirmButton.className = 'save_btn_cap';
			confirmButton.textContent = '확인';
			button.parentNode.appendChild(confirmButton);

			button.style.display = 'none';

			confirmButton.addEventListener('click', function() {
				cells.forEach(cell => {
					let input = cell.querySelector('input');
					cell.textContent = input.value;
				});

				confirmButton.remove();
				button.style.display = 'inline-block';
			});
		});
	});

	document.querySelectorAll('.main_btn2').forEach(button => {
		button.addEventListener('click', function() {
			let row = this.parentNode.parentNode;
			row.parentNode.removeChild(row);
		});
	});
}

// 팝업 열기 및 닫기 함수
function openPopup() {
	document.getElementById('popup').style.display = "block";
}

function closePopup() {
	document.getElementById('popup').style.display = "none";
}
