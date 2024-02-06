
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
    // 검색 버튼 요소와 검색어 입력란 요소를 가져옵니다.
    var searchButton = document.querySelector(".main_btn_mng");
    var searchInput = document.querySelector(".main_search_txt_mng");
 
    // 검색 함수를 정의합니다.
    function performSearch() {
        // 검색어를 가져옵니다.
        var searchKeyword = searchInput.value.toLowerCase();
        // 테이블의 각 행을 가져옵니다.
        var rows = document.querySelectorAll("#productBoard table tr");
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