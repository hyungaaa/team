
document.addEventListener("DOMContentLoaded", function () {

    document.querySelector(".navi-item2").setAttribute("class", "navi-item navi-item2 active");

});

// 저장 버튼 누르면 alert 창 뜨게
function saveShow() {
    var savealert = confirm("저장 하시겠습니까?");
    if (savealert) {
        alert("저장되었습니다.");
    } else {
        alert("취소되었습니다.");
    }
}


// 검색 가능
// 검색결과 나오게 하는 거 

document.addEventListener("DOMContentLoaded", function () {
    // 검색버튼, 입력 요소 가져오기
    var searchButton = document.querySelector(".main_btn_mng");
    var searchInput = document.querySelector(".main_search_txt_mng");


    function performSearch() {
        var searchKeyword = searchInput.value.toLowerCase();
        var rows = document.querySelectorAll("#productBoard table tr");
        rows.forEach(function (row, index) {
            var showRow = false;

            if (index === 0) {
                showRow = true;
            }
            else {
                // 검색어 일치하는지 확인
                row.querySelectorAll("td").forEach(function (cell) {
                    if (cell.textContent.toLowerCase().includes(searchKeyword)) {
                        showRow = true;
                    }
                });
            }

            // 일치 하는 부분 없으면 행 숨김
            if (!showRow) {
                row.style.display = "none";
            } else {
                row.style.display = ""; // 일치하는 부분 표시
            }
        });
    };


    // 검색 버튼 누르면 검색 가능
    searchButton.addEventListener("click", performSearch);

    // 엔터 누르면 검색 가능
    searchInput.addEventListener("keydown", function (event) {
        if (event.key === "Enter") {
            performSearch();
        }
    });
});


// 이미지 보여지게
// document.getElementById('imageUpload').addEventListener('change', function (event) {
//     var selectedFile = event.target.files[0];

//     // 여기에 선택된 파일을 업로드하는 로직을 추가하세요.
//     // 예를 들어, 이미지를 미리보기로 표시할 수 있습니다.
//     if (selectedFile) {
//         var reader = new FileReader();
//         reader.onload = function (e) {
//             // 선택된 이미지를 미리보기로 표시
//             var preview = document.createElement('img');
//             preview.src = e.target.result;
//             preview.style.width = '100%';
//             preview.style.height = 'auto';
//             document.body.appendChild(preview);
//         };
//         reader.readAsDataURL(selectedFile);
//     }
// });

// document.getElementById('imageUpload').addEventListener('change', function (event) {
//     var selectedFile = event.target.files[0];

//     // 선택된 파일을 업로드하는 로직을 추가할 수 있습니다.

//     // 이미지를 미리보기로 표시
//     if (selectedFile) {
//         var reader = new FileReader();
//         reader.onload = function (e) {
//             // 선택된 이미지를 미리보기로 표시
//             var preview = document.createElement('img');
//             preview.src = e.target.result;
//             preview.style.width = '100%';
//             preview.style.height = 'auto';

//             // 미리보기를 표시할 div에 추가
//             var previewContainer = document.getElementById('img_prv');
//             previewContainer.innerHTML = ''; // 이전에 추가된 미리보기가 있다면 초기화
//             previewContainer.appendChild(preview);
//         };
//         reader.readAsDataURL(selectedFile);
//     }
// });

// 카테고리 설정 버튼 누르면 li 수정 가능
function setting_btn() {
    // 각 li 요소의 내용을 수정 가능하게 만들기
    var listItems = document.querySelectorAll("#bigCategory ul li");

    listItems.forEach(function (listItem) {
        var currentText = listItem.textContent.trim();
        var newText = prompt("수정할 내용을 입력하세요", currentText);

        if (newText !== null && newText !== "") {
            // 사용자가 입력한 내용으로 갱신
            listItem.querySelector("span.mng_span").textContent = newText;
        }
    });
}

// // 새로운 li 요소 추가
// if (confirm("새로운 카테고리를 추가하시겠습니까?")) {
//     var newCategory = prompt("새로운 카테고리를 입력하세요");

//     if (newCategory !== null && newCategory !== "") {
//         var newListItem = document.createElement("li");
//         newListItem.innerHTML = "<a href='#'><span class='mng_span'>" + newCategory + "</span>></a>";

//         // 새로운 li 요소를 main_btn 위에 추가
//         var button = document.querySelector(".main_btn");
//         button.parentNode.insertBefore(newListItem, button);
//     }
// }



// 카테고리에 속하는 제품 행만 보이도록
function filterCategory(category) {
    var productRows = document.querySelectorAll(".product-row");
    productRows.forEach(function (row) {
        var rowCategory = row.dataset.category;

        if (category ==  '전체' || rowCategory == category) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }

    });

}

document.addEventListener("DOMContentLoaded", function () {

    var catBtn = document.querySelectorAll('#scate_mng');

    catBtn.forEach(function (btn) {

        
        btn.addEventListener("click",
        filterCategory()
        )
        btn.addEventListener("click", function () {
            
            catBtn.forEach(function (otherBtn) {
                if (otherBtn !== btn) {
                    otherBtn.classList.remove('active');
                }
            });
            btn.classList.add('active');
        })

    })

});


document.addEventListener("DOMContentLoaded", function () {
    filterCategory('전체');

    let selected_del = document.getElementById("selected_del"); 
  selected_del.addEventListener("click", function () {
  
    let list_checked = document.querySelectorAll(".chk:checked")
    for(let i=0; i<list_checked.length; i++){
      list_checked[i].parentNode.parentNode.remove();
      // console.log(list_checked[i].parentNode);
      // console.log(list_checked[i].parentNode.parentNode)
    }
  })
  
});

// 삭제

// let selected_del = document.getElementById("selected_del"); 
//   selected_del.addEventListener("click", function () {
  
//     let list_checked = document.querySelectorAll(".chk:checked")
//     for(let i=0; i<list_checked.length; i++){
//       list_checked[i].parentNode.parentNode.remove();
//       // console.log(list_checked[i].parentNode);
//       // console.log(list_checked[i].parentNode.parentNode)
//     }
//   })

// function showCheckboxes() {
//     // 테이블에서 체크박스 열의 위치를 찾기
//     var checkboxColumnIndex = 0; // 예시로 첫 번째 열로 설정했습니다.

//     // 테이블 참조
//     var table = document.getElementById("productBoard");

//     // 모든 행을 가져와서 처리
//     var rows = table.getElementsByClassName("product-row");
//     for (var i = 0; i < rows.length; i++) {
//         // 각 행의 셀에 체크박스 추가
//         var checkboxCell = rows[i].insertCell(checkboxColumnIndex);
//         var checkbox = document.createElement("input");
//         checkbox.type = "checkbox";
//         checkboxCell.appendChild(checkbox);
//     }

//     // 삭제 버튼을 비활성화
//     document.getElementById("selected_del").disabled = true;
// }

// var checkboxesShown = false;

// function showCheckboxes() {
//     // 테이블 참조
//     var table = document.getElementById("productBoard");

//     // 체크박스를 이미 보여주고 있는 경우
//     if (checkboxesShown) {
//         // 헤더 열에서 체크박스와 "선택" 텍스트 제거
//         var headerRow = table.querySelector("#title_mng");
//         headerRow.deleteCell(0);
//         headerRow.cells[headerRow.cells.length - 1].innerHTML = "";

//         // 모든 행에서 체크박스 제거
//         var rows = table.getElementsByClassName("product-row");
//         for (var i = 0; i < rows.length; i++) {
//             rows[i].deleteCell(0);
//         }

//         // 헤더 열을 원래 위치로 이동
//         for (var i = headerRow.cells.length - 1; i > 0; i--) {
//             headerRow.cells[i].innerHTML = headerRow.cells[i - 1].innerHTML;
//         }
//         headerRow.cells[0].innerHTML = "제품명";

//         // 삭제 버튼을 다시 활성화
//         document.getElementById("selected_del").disabled = false;

//         checkboxesShown = false;
//     } else {
//         // 헤더 열에 체크박스 추가
//         var headerRow = table.querySelector("#title_mng");
//         var checkboxHeaderCell = headerRow.insertCell(0);
//         var checkboxHeader = document.createElement("input");
//         checkboxHeader.type = "checkbox";
//         checkboxHeaderCell.appendChild(checkboxHeader);

//         // 모든 행의 셀에 체크박스 추가
//         var rows = table.getElementsByClassName("product-row");
//         for (var i = 0; i < rows.length; i++) {
//             var checkboxCell = rows[i].insertCell(0);
//             var checkbox = document.createElement("input");
//             checkbox.type = "checkbox";
//             checkboxCell.appendChild(checkbox);
//         }

//         // 헤더 열을 한 칸 오른쪽으로 이동
//         for (var i = 0; i < headerRow.cells.length - 1; i++) {
//             headerRow.cells[i].innerHTML = headerRow.cells[i + 1].innerHTML;
//         }

//         // 빈 공간에 "선택" 텍스트 추가
//         headerRow.cells[headerRow.cells.length - 1].innerHTML = "선택";

//         // 삭제 버튼을 비활성화
//         document.getElementById("selected_del").disabled = true;

//         checkboxesShown = true;
//     }
// }


