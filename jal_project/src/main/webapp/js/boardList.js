document.addEventListener("DOMContentLoaded", function () {

    document.querySelector(".navi-item8").setAttribute("class", "navi-item navi-item8 active");


	// 글제목 클릭 했을 때 클릭이벤트 부여
	 document.querySelectorAll('.btitle').forEach(function(span) {
	    span.addEventListener('click', function() {
	        // 클릭된 span의 부모인 td의 이전 형제 요소(td)에서 텍스트 내용(bno)을 얻음
	        var bno = this.parentNode.previousElementSibling.previousElementSibling.previousElementSibling.innerText;
	        console.log(bno);
	        
	        goBoard(bno);
	    });
	});
});


function exportToExcel() {
    let table = document.getElementById("tableToExport");
    let html = table.outerHTML;

    let blob = new Blob([html], {
        type: "application/vnd.ms-excel"
    });

    let a = document.createElement("a");
    let url = URL.createObjectURL(blob);
    a.href = url;
    a.download = "data.xls";
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);
}

function searchTable() {
    // 검색어와 검색 옵션을 가져옵니다.
    let input = document.getElementById("searchInput").value.toUpperCase();
    let selectOption = document.getElementById("searchOption").value;

    // 테이블과 테이블의 tbody를 가져옵니다.
    let table = document.getElementById("tableToExport");
    let tbody = table.getElementsByTagName("tbody")[0];
    let rows = tbody.getElementsByTagName("tr");

    // 테이블의 각 행을 검색합니다.
    for (let i = 1; i < rows.length; i++) { // i를 1부터 시작하여 th행은 건너뜁니다.
        let cells = rows[i].getElementsByTagName("td");
        let match = false;

        // 각 셀에서 검색어를 찾습니다.
        for (let j = 0; j < cells.length; j++) {
            let cell = cells[j];
            let txtValue = cell.textContent || cell.innerText;

            // 선택된 옵션에 따라 해당 셀에 검색어가 포함되는지 확인합니다.
            if (selectOption === "all" ||
                (selectOption === "title" && j === 3) ||
                (selectOption === "productCode" && j === 2)) {
                if (txtValue.toUpperCase().indexOf(input) > -1) {
                    match = true;
                    break; // 검색어를 찾았으므로 더 이상 반복할 필요가 없습니다.
                }
            }
        }

        // 검색 결과에 따라 행을 표시하거나 숨깁니다.
        rows[i].style.display = match ? "" : "none";
    }
}

// enter키 쳤을 때 검색 가능 함수
function searchOnEnter(event) {
    if (event.key === "Enter") {
        searchTable();
    }
}




// 글로 이동하는 링크
function goBoard(bno) {
	
	window.location.href = 'board?bno=' + bno;
	
}
