


// 차트 보이게
document.addEventListener("DOMContentLoaded", function () {
    var elements = document.querySelectorAll("#a_01, #a_02, #b_01, #b_02, #b_03, #b_04, #c_01, #c_02, #c_03");

    elements.forEach(function (element) {
        // 마우스가 div에 들어갔을 때 텍스트 나타남
        element.addEventListener("mouseenter", function () {
 
            let currentIndex = 0;

            switch(element.getAttribute("id")) {
                case 'a_01' : currentIndex=0;break;
                case 'a_02' : currentIndex=1;break;
                case 'b_01' : currentIndex=2;break;
                case 'b_02' : currentIndex=3;break;
                case 'b_03' : currentIndex=4;break;
                case 'b_04' : currentIndex=5;break;
                case 'c_01' : currentIndex=6;break;
                case 'c_02' : currentIndex=7;break;
                case 'c_03' : currentIndex=8;break;
            }


            Chart_line_capa.data.datasets = [newDataset_line[currentIndex]];
            Chart_line_capa.update();

            console.log(element.getAttribute("id"))

        });

        // 마우스가 div에서 나갔을 때 텍스트 사라짐
        element.addEventListener("mouseleave", function () {
            // document.querySelector(".hover_test").textContent = "";
        });
    });



    var newDataset_line = new Array(9);
    newDataset_line[0] = {
        data: [0, 66, 81, 81, 76, 51, 65],
        label: "A-01",
        borderColor: "#3e95cd",
        fill: false
    };
    newDataset_line[1] = {
        data: [66, 43, 22, 10, 5, 18, 25],
        label: "A-02",
        borderColor: "#8e5ea2",
        fill: false
    };
    newDataset_line[2] = {
        data: [83, 62, 31, 82, 8, 84, 40],
        label: "B-01",
        borderColor: "#33FF57",
        fill: false
    };
    newDataset_line[3] = {
        data: [97, 100, 17, 12, 86, 75, 54],
        label: "B-02",
        borderColor: "#FF33F6",
        fill: false
    };
    newDataset_line[4] = {
        data: [58, 53, 55, 82, 48, 88, 7],
        label: "B-03",
        borderColor: "#FFC300",
        fill: false
    };
    newDataset_line[5] = {
        data: [96, 70, 1, 77, 10, 61, 33],
        label: "B-04",
        borderColor: "#FF5733",
        fill: false
    };
    newDataset_line[6] = {
        data: [97, 99, 50, 51, 56, 99, 55],
        label: "C-01",
        borderColor: "#F333FF",
        fill: false
    };
    newDataset_line[7] = {
        data: [86, 15, 57, 1, 99, 68, 63],
        label: "C-02",
        borderColor: "#33FFF6",
        fill: false
    };
    newDataset_line[8] = {
        data: [2, 71, 58, 72, 35, 32, 14],
        label: "C-03",
        borderColor: "#8e5ea2",
        fill: false
    };

    currentIndex = 0;

    let Chart_line_capa = new Chart(document.getElementById("line-chart_capa"), {
        type: 'line',
        data: {
            labels: ["2024-02-01", "2024-02-02", "2024-02-03", "2024-02-04", "2024-02-05", "2024-02-06", "2024-02-07"],
            datasets: [newDataset_line[currentIndex]]
        },
        options: {
            title: {
                display: true,
                text: '주간 수용량 변화'
            }
        }
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



// 수정 할 수 있게

document.addEventListener('DOMContentLoaded', function () {
    // 수정 버튼 클릭 이벤트
    document.getElementById('btn_cap').addEventListener('click', function () {
        var rowsToEdit = document.querySelectorAll('#cap_tbl tr');
        rowsToEdit.forEach(function (row) {
            var cells = row.getElementsByTagName('td');
            for (var i = 6; i <= 7; i++) { // 담당자, 비고 열만 가능
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
                for (var i = 6; i <= 7; i++) { // 담당자, 비고 열만 가능하게
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
