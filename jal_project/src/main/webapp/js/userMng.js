// window.addEventListener("load", function () {
//     bind();
// })

// function bind() {
//     document.querySelector("#select_all1").addEventListener("click", function (event) {
//         let list_check1 = document.querySelectorAll(".chk1")

//         if (event.target.checked) {
//             let list_check1 = document.querySelectorAll(".chk1")
//             for (let i = 0; i < list_check1.length; i++) {
//                 list_check1[i].checked = true;
//             }
//         } else {
//             let list_check1 = document.querySelectorAll(".chk1")
//             for (let i = 0; i < list_check1.length; i++) {
//                 list_check1[i].checked = false;
//             }
//         }
//     });
//     document.querySelector("#select_all2").addEventListener("click", function (event) {
//         let list_check2 = document.querySelectorAll(".chk2")

//         if (event.target.checked) {
//             let list_check2 = document.querySelectorAll(".chk2")
//             for (let i = 0; i < list_check2.length; i++) {
//                 list_check2[i].checked = true;
//             }
//         } else {
//             let list_check2 = document.querySelectorAll(".chk2")
//             for (let i = 0; i < list_check2.length; i++) {
//                 list_check2[i].checked = false;
//             }
//         }
//     });
//     document.querySelector("#select_all3").addEventListener("click", function (event) {
//         let list_check3 = document.querySelectorAll(".chk3")

//         if (event.target.checked) {
//             let list_check3 = document.querySelectorAll(".chk3")
//             for (let i = 0; i < list_check3.length; i++) {
//                 list_check3[i].checked = true;
//             }
//         } else {
//             let list_check3 = document.querySelectorAll(".chk3")
//             for (let i = 0; i < list_check3.length; i++) {
//                 list_check3[i].checked = false;
//             }
//         }
//     });
//     document.querySelector("#select_all4").addEventListener("click", function (event) {
//         let list_check4 = document.querySelectorAll(".chk4")

//         if (event.target.checked) {
//             let list_check4 = document.querySelectorAll(".chk4")
//             for (let i = 0; i < list_check4.length; i++) {
//                 list_check4[i].checked = true;
//             }
//         } else {
//             let list_check4 = document.querySelectorAll(".chk4")
//             for (let i = 0; i < list_check4.length; i++) {
//                 list_check4[i].checked = false;
//             }
//         }
//     });
//     document.querySelector("#select_all5").addEventListener("click", function (event) {
//         let list_check5 = document.querySelectorAll(".chk5")

//         if (event.target.checked) {
//             let list_check5 = document.querySelectorAll(".chk5")
//             for (let i = 0; i < list_check5.length; i++) {
//                 list_check5[i].checked = true;
//             }
//         } else {
//             let list_check5 = document.querySelectorAll(".chk5")
//             for (let i = 0; i < list_check5.length; i++) {
//                 list_check5[i].checked = false;
//             }
//         }
//     });

//     // select 모두 선택

//     document.getElementById("change_button1").addEventListener("click", function () {
//         let list_change1 = document.querySelectorAll(".select_op1");
//         let selectedOption = document.getElementById("select_change1").value;

//         for (let i = 0; i < list_change1.length; i++) {
//             if (list_change1[i].value === selectedOption) {
//                 list_change1[i].selected = !list_change1[i].selected;
//             }
//         }
//     });

//     document.getElementById("change_button2").addEventListener("click", function () {
//         let list_change2 = document.querySelectorAll(".select_op2");
//         let selectedOption = document.getElementById("select_change2").value;

//         for (let i = 0; i < list_change2.length; i++) {
//             if (list_change2[i].value === selectedOption) {
//                 list_change2[i].selected = !list_change2[i].selected;
//             }
//         }
//     });

//     // select 선택 검색

// }

// // popup

// function openPopup() {
//     document.getElementById('popup').style.display = "block";
// }

// function closePopup() {
//     document.getElementById('popup').style.display = "none";
// }

//=============================================================================
window.addEventListener("load", function() {
	bindEvents();

	document.querySelector(".navi-item9").setAttribute("class", "navi-item navi-item9 active");

});



function bindEvents() {
	// 체크박스 전체 선택
	document.querySelectorAll("[id^='select_all']").forEach(function(checkbox) {
		checkbox.addEventListener("click", function(event) {
			let checkboxClass = event.target.id.replace("select_all", "chk");
			let checkboxes = document.querySelectorAll("." + checkboxClass);
			checkboxes.forEach(function(chk) {
				chk.checked = event.target.checked;
			});
		});
	});

	// 셀렉트 옵션 변경
	document.querySelectorAll("[id^='change_button']").forEach(function(button) {
		button.addEventListener("click", function() {
			let selectClass = "select_op" + button.id.replace("change_button", "");
			let selectedOption = document.getElementById("select_change" + button.id.slice(-1)).value;
			let selectOptions = document.querySelectorAll("." + selectClass);
			selectOptions.forEach(function(option) {
				option.selected = (option.value === selectedOption);
			});
		});
	});

	// 셀렉트 선택 검색
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


	var buttons = document.querySelectorAll('.main_btn');
	buttons.forEach(function(button) {
		button.addEventListener('click', function() {
			// 클릭된 버튼이 속한 행 찾기
			var row = button.closest('tr');
			// 행의 첫 번째 열과 두 번째 열을 입력 필드로 변경
			var cells = row.querySelectorAll('td:nth-child(1), td:nth-child(2)');
			cells.forEach(function(cell) {
				var inputValue = cell.innerText;
				cell.innerHTML = '<input type="text" class="edit-input" value="' + inputValue + '">';
			});

			// 확인 버튼 생성
			var confirmButton = document.createElement('button');
			confirmButton.className = 'save_btn_cap';
			confirmButton.textContent = '확인';
			button.parentNode.appendChild(confirmButton);

			// 수정 버튼 숨기기
			button.style.display = 'none';

			// 확인 버튼 클릭 이벤트 리스너 등록
			confirmButton.addEventListener('click', function() {
				// 입력 필드로 교체된 값으로 열 내용 교체
				var editedCells = row.querySelectorAll('td:nth-child(1), td:nth-child(2)');
				editedCells.forEach(function(editedCell) {
					var inputValue = editedCell.querySelector('input').value;
					editedCell.innerHTML = inputValue;
				});

				// 확인 버튼 제거
				confirmButton.remove();

				// 수정 버튼 다시 보이게 하기
				button.style.display = 'inline-block';
			});
		});
	});


	// 삭제 버튼 클릭 시 해당 행 삭제
	document.querySelectorAll('.main_btn2').forEach(button => {
		button.addEventListener('click', function() {
			let id = this.getAttribute("data-id"); // J0002
			console.log(id);
			//			location.href = "userUpdate?id="+id
			const row = this.parentNode.parentNode;
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
