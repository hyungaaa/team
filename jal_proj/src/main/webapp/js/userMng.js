window.addEventListener("DOMContentLoaded", function() {
	bindEvents();

	document.querySelector(".navi-item9").setAttribute("class", "navi-item navi-item9 active");

});

function bindEvents() {
	// 체크박스 '전체 선택' 기능
	document.querySelectorAll('input[id^="select_all"]').forEach(function(selectAllCheckbox) {
		selectAllCheckbox.addEventListener('change', function() {
			let columnIndex = this.parentElement.cellIndex + 1; // 현재 체크박스가 위치한 열의 인덱스
			let checkStatus = this.checked;
			// 같은 열에 있는 모든 체크박스의 상태를 변경
			document.querySelectorAll(`tbody tr td:nth-child(${columnIndex}) input[type='checkbox']`).forEach(function(checkbox) {
				checkbox.checked = checkStatus;
			});
		});
	});

	// 센터 변경 버튼 이벤트 리스너 추가
	document.getElementById('change_button1').addEventListener('click', function() {
		// 선택된 센터 옵션값 가져오기
		var selectedCenter = document.getElementById('select_change1').value;
		// 모든 센터 선택 드롭다운에 대해 선택된 옵션 적용
		var centerDropdowns = document.querySelectorAll('.main_search2_txt');
		centerDropdowns.forEach(function(dropdown) {
			if (dropdown.options[dropdown.selectedIndex].value !== selectedCenter) {
				for (var i = 0; i < dropdown.options.length; i++) {
					if (dropdown.options[i].value === selectedCenter) {
						dropdown.selectedIndex = i;
					}
				}
			}
		});
	});

	// 권한 변경 버튼 이벤트 리스너 추가
	document.getElementById('change_button2').addEventListener('click', function() {
		// 선택된 권한 옵션값 가져오기
		var selectedAuthority = document.getElementById('select_change2').value;
		// 모든 권한 선택 드롭다운에 대해 선택된 옵션 적용
		var authorityDropdowns = document.querySelectorAll('.main_search2_txt');
		authorityDropdowns.forEach(function(dropdown) {
			if (dropdown.options[dropdown.selectedIndex].value !== selectedAuthority) {
				for (var i = 0; i < dropdown.options.length; i++) {
					if (dropdown.options[i].value === selectedAuthority) {
						dropdown.selectedIndex = i;
					}
				}
			}
		});
	});




	// 검색 셀렉트 박스 선택 시 테이블 행 필터링
	document.getElementById("searchSelect").addEventListener("change", function() {
		let selectedValue = this.value;
		let rows = document.querySelectorAll("#table_cap tr");
		rows.forEach(function(row, index) {
			if (index !== 0) {
				let selectBoxes = row.querySelectorAll("select.main_search2_txt");
				let centerValue = selectBoxes[0].value;
				if (selectedValue === "센터 검색" || centerValue === selectedValue) {
					row.style.display = ""; // 해당 행을 표시
				} else {
					row.style.display = "none"; // 일치하지 않는 경우 해당 행을 숨김
				}
			}
		});
	});
	// 수정 버튼 클릭 시 입력 필드로 변경 후 확인/취소 기능
	document.querySelectorAll('.main_btn').forEach(button => {
		button.addEventListener('click', function() {
			let row = button.closest('tr');
			let cells = row.querySelectorAll('td:nth-child(2), td:nth-child(3)'); // 이름과 사원번호 셀 선택
			cells.forEach(function(cell) {
				let inputValue = cell.innerText;
				cell.innerHTML = '<input type="text" class="edit-input" value="' + inputValue + '">';
			});

			// 확인 버튼 생성
			let confirmButton = document.createElement('button');
			confirmButton.className = 'save_btn_cap';
			confirmButton.textContent = '확인';
			button.parentNode.appendChild(confirmButton);

			button.style.display = 'none'; // 원래의 수정 버튼 숨기기

			// 확인 버튼 클릭 이벤트
			confirmButton.addEventListener('click', function() {
				let editedCells = row.querySelectorAll('td:nth-child(2), td:nth-child(3)');
				editedCells.forEach(function(editedCell) {
					let inputValue = editedCell.querySelector('input').value;
					editedCell.innerHTML = inputValue; // 입력 필드의 값을 가져와서 다시 텍스트로 설정
				});

				confirmButton.remove(); // 확인 버튼 제거
				button.style.display = 'inline-block'; // 수정 버튼 다시 표시
			});
		});
	});


	// 삭제 버튼 클릭 시 해당 행 삭제
	document.querySelectorAll('.main_btn2').forEach(button => {
		button.addEventListener('click', function() {
			let row = this.parentNode.parentNode;
			row.parentNode.removeChild(row);
		});
	});
}

//======================================================================

// popup

function openPopup() {
	document.getElementById('popup').style.display = "block";
}

function closePopup() {
	document.getElementById('popup').style.display = "none";
}
//========================================================================
