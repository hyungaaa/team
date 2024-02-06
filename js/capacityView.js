

// 문서가 로드된 후 실행되는 함수
document.addEventListener("DOMContentLoaded", function () {
    // 각각의 div 요소에 대해 이벤트 리스너를 등록
    var elements = document.querySelectorAll("#a_01, #a_02, #b_01, #b_02, #b_03, #b_04, #c_01, #c_02, #c_03");
    
    elements.forEach(function (element) {
        // 마우스가 div에 들어갔을 때 텍스트 나타남
        element.addEventListener("mouseenter", function () {
            document.querySelector(".hover_test").textContent = "일단 보여진다";
        });

        // 마우스가 div에서 나갔을 때 텍스트 사라짐
        element.addEventListener("mouseleave", function () {
            document.querySelector(".hover_test").textContent = "";
        });
    });
});





// 검색결과 나오게 하는 거 

document.addEventListener("DOMContentLoaded", function () {
    // 검색 버튼 요소와 검색어 입력란 요소를 가져옵니다.
    var searchButton = document.querySelector(".main_btn_cap");
    var searchInput = document.querySelector(".main_search_txt_cap");

    // 검색 함수를 정의합니다.
    function performSearch() {
        // 검색어를 가져옵니다.
        var searchKeyword = searchInput.value.toLowerCase();

        // 테이블의 각 행을 가져옵니다.
        var rows = document.querySelectorAll(".cap_view_table2 table tr");

        // 각 행에 대해 검색어와 일치하는 부분이 있는지 확인하고 보이거나 숨깁니다.
        rows.forEach(function (row) {
            var showRow = false;

            // 각 행의 셀에 대해 검색어와 일치하는 부분이 있는지 확인합니다.
            row.querySelectorAll("td").forEach(function (cell) {
                if (cell.textContent.toLowerCase().includes(searchKeyword)) {
                    showRow = true;
                }
            });

            // 검색어와 일치하는 부분이 없으면 해당 행을 숨깁니다.
            if (!showRow) {
                row.style.display = "none";
            } else {
                row.style.display = ""; // 일치하는 부분이 있으면 보이게 처리
            }
        });
    }

    // 검색 버튼 누르면 검색 가능
    searchButton.addEventListener("click", performSearch);

    // 엔터 누르면 검색 가능
    searchInput.addEventListener("keydown", function (event) {
        if (event.key === "Enter") {
            performSearch();
        }
    });
});

// 수정창 변하게

// function modCnt() {
//     let modBtn = document.getElementById("btn_cap");
  
//     let cap_tbl = document.getElementById("cap_tbl");
//     let tbody = cap_tbl.getElementsByTagName("tbody")[0];
//     let rows = tbody.getElementsByTagName("tr");
    
//     for (let i = 0; i < tbl.rows.length; i++) {
//       tbl.rows[i].cells[6].onclick = function() {
//         tbl.rows[i].cells[4].innerHTML = "<input class='table_blind_txt mod-txt' type='text'>";
//         tbl.rows[i].cells[5].innerHTML = "<input class='table_blind_txt mod-txt' type='text'>";
//         tbl.rows[i].cells[6].innerHTML = "<button type='button' class='table_btn' id='modBtn' onclick='modCnt()'>확인</button>";
//       }
//     }
//   }

// 

// document.addEventListener('DOMContentLoaded', function () {
//     // 수정 버튼 클릭 이벤트
//     document.getElementById('btn_cap').addEventListener('click', function () {
//         // 5번째와 6번째 행의 내용을 입력 필드로 교체
//         var rowsToEdit = document.querySelectorAll('#cap_tbl tr:nth-child(5), #cap_tbl tr:nth-child(6)');
//         rowsToEdit.forEach(function (row) {
//             var cells = row.getElementsByTagName('td');
//             for (var i = 4; i <= 5; i++) { // 열 수정으로 변경
//                 var inputValue = cells[i].innerText;
//                 cells[i].innerHTML = '<input type="text" class="edit-input" value="' + inputValue + '">';
//             }
//         });

//         // 확인 버튼 표시
//         var confirmButton = document.createElement('button');
//         confirmButton.className = 'save_btn_cap';
//         confirmButton.id = 'confirm_btn_cap';
//         confirmButton.textContent = '확인';

//         document.getElementById('btn_cap').insertAdjacentElement('afterend', confirmButton);

//         // 수정 버튼 숨기기
//         document.getElementById('btn_cap').style.display = 'none';
//     });

//     // 확인 버튼 클릭 이벤트
//     document.addEventListener('click', function (event) {
//         if (event.target.id === 'confirm_btn_cap') {
//             // 입력 필드로 교체된 값으로 다시 행 내용 교체
//             var rowsToSave = document.querySelectorAll('#cap_tbl tr:nth-child(5), #cap_tbl tr:nth-child(6)');
//             rowsToSave.forEach(function (row) {
//                 var cells = row.getElementsByTagName('td');
//                 for (var i = 4; i <= 5; i++) { // 열 수정으로 변경
//                     var inputValue = cells[i].querySelector('input').value;
//                     cells[i].innerHTML = inputValue;
//                 }
//             });

//             // 확인 버튼 제거
//             document.getElementById('confirm_btn_cap').remove();

//             // 수정 버튼 표시
//             document.getElementById('btn_cap').style.display = 'inline-block'; // 수정
//         }
//     });
// });

document.addEventListener('DOMContentLoaded', function () {
    // 수정 버튼 클릭 이벤트
    document.getElementById('btn_cap').addEventListener('click', function () {
        // "담당자"와 "비고" 열의 내용을 입력 필드로 교체
        var rowsToEdit = document.querySelectorAll('#cap_tbl tr');
        rowsToEdit.forEach(function (row) {
            var cells = row.getElementsByTagName('td');
            for (var i = 5; i <= 6; i++) { // "담당자"와 "비고" 열만 수정 가능하게 변경
                var inputValue = cells[i].innerText;
                cells[i].innerHTML = '<input type="text" class="edit-input" value="' + inputValue + '">';
            }
        });

        // 확인 버튼 표시
        var confirmButton = document.createElement('button');
        confirmButton.className = 'save_btn_cap';
        confirmButton.id = 'confirm_btn_cap';
        confirmButton.textContent = '확인';

        document.getElementById('btn_cap').insertAdjacentElement('afterend', confirmButton);

        // 수정 버튼 숨기기
        document.getElementById('btn_cap').style.display = 'none';
    });

    // 확인 버튼 클릭 이벤트
    document.addEventListener('click', function (event) {
        if (event.target.id === 'confirm_btn_cap') {
            // 입력 필드로 교체된 값으로 다시 열 내용 교체
            var rowsToSave = document.querySelectorAll('#cap_tbl tr');
            rowsToSave.forEach(function (row) {
                var cells = row.getElementsByTagName('td');
                for (var i = 5; i <= 6; i++) { // "담당자"와 "비고" 열만 수정 가능하게 변경
                    var inputValue = cells[i].querySelector('input').value;
                    cells[i].innerHTML = inputValue;
                }
            });

            // 확인 버튼 제거
            document.getElementById('confirm_btn_cap').remove();

            // 수정 버튼 표시
            document.getElementById('btn_cap').style.display = 'inline-block';
        }
    });
});