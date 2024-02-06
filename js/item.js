
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



