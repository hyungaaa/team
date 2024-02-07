
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
                showRow =  true;
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

    listItems.forEach(function(listItem) {
        var currentText = listItem.textContent.trim();
        var newText = prompt("수정할 내용을 입력하세요", currentText);

        if (newText !== null && newText !== "") {
            // 사용자가 입력한 내용으로 갱신
            listItem.querySelector("span.mng_span").textContent = newText;
        }
    });
}

//     // 새로운 li 요소 추가
//     if (confirm("새로운 카테고리를 추가하시겠습니까?")) {
//         var newCategory = prompt("새로운 카테고리를 입력하세요");

//         if (newCategory !== null && newCategory !== "") {
//             var newListItem = document.createElement("li");
//             newListItem.innerHTML = "<a href='#'><span class='mng_span'>" + newCategory + "</span>></a>";

//             // 새로운 li 요소를 main_btn 위에 추가
//             var button = document.querySelector(".main_btn");
//             button.parentNode.insertBefore(newListItem, button);
//         }
//     }
// }

// // 각 버튼을 클릭했을 때 해당 카테고리의 제품만 보이도록 하는 함수
// function filterCategory(category) {
//     var products = document.querySelectorAll("#productBoard tr");
    
//     products.forEach(function(product) {
//         var productCategory = product.querySelector("td:nth-child(2)").textContent.trim();

//         if (category === '전체' || productCategory === category) {
//             product.style.display = "";
//         } else {
//             product.style.display = "none";
//         }
//     });
// }

// // 도시락 버튼을 눌렀을 때 도시락에 해당하는 제품만 보이도록 하는 함수
// function showCategory(category) {
//     filterCategory(category);
// }

// // 초기 페이지 로드시 전체 제품 보이도록 설정
// document.addEventListener("DOMContentLoaded", function() {
//     filterCategory('전체');
// });

// 카테고리에 속하는 제품 행만 보이도록
function filterCategory(category) {
    var productRows = document.querySelectorAll(".product-row");

    productRows.forEach(function(row) {
        var rowCategory = row.dataset.category;

        if (category === '전체' || rowCategory === category) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    });
}
