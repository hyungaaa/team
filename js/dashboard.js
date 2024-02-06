
window.addEventListener("load", function () {
    bind();

})


function bind() {


    // 정보 배열로 입력  
    let listItem = [];
    let item = ["<canvas id='doughnut-chart", "' height='170px'></canvas>"];
    listItem.push(item);
    for (let i = 1; i < 9; i++) {
        item = ["<canvas id='doughnut-chart", "' height='170px'></canvas>"];
        listItem.push(item);
    }


    // 이미지
    let list = document.querySelector("#doughnut-list");

    let html = "";
    for (let i = 0; i < listItem.length; i++) {
        html += ' <li id=list_' + [i] + '>';
        html += listItem[i][0] + i + listItem[i][1];
        html += ' </li>';
    }
    list.innerHTML = html;

  



    // 카드 슬라이딩 기능
    let currentIndex = 0;
    const cardWidth = (300 - 44); // 카드의 너비 + 마진
    let allCard = document.querySelector("#doughnut-list");

    document.querySelector("#arrow1_1").addEventListener("click", function () {
        if (currentIndex > 0) {
            currentIndex--;
            moveCards();

            Chart_line.data.datasets= [newDataset_line[currentIndex], newDataset_line[currentIndex+1], newDataset_line[currentIndex+2], newDataset_line[currentIndex+3]];
            Chart_line.update();
        }
    })

    document.querySelector("#arrow1_2").addEventListener("click", function () {
        if (currentIndex < allCard.children.length - 1-3) {
            currentIndex++;
            moveCards();

            Chart_line.data.datasets= [newDataset_line[currentIndex], newDataset_line[currentIndex+1], newDataset_line[currentIndex+2], newDataset_line[currentIndex+3]];
            Chart_line.update();
        }
    })


    function moveCards() {
        const offset = -currentIndex * cardWidth;
        allCard.style.transform = `translateX(${offset}px)`;
    }






    // chart 부분 정보 불러오기
    for (let i = 0; i < 9; i++) {

        var chartID = `doughnut-chart${i}`;
        var newDataset = new Array(9);
        newDataset[0] = [3, 1745];
        newDataset[1] = [30, 1745];
        newDataset[2] = [300, 1745];
        newDataset[3] = [3000, 1745];
        newDataset[4] = [3000, 1];
        newDataset[5] = [3000, 17];
        newDataset[6] = [3000, 174];
        newDataset[7] = [300, 1745];
        newDataset[8] = [30, 17];

        var newName = new Array(9);
        newName[0] = "A-01";
        newName[1] = "A-02";
        newName[2] = "B-01";
        newName[3] = "B-02";
        newName[4] = "B-03";
        newName[5] = "B-04";
        newName[6] = "C-01";
        newName[7] = "C-02";
        newName[8] = "C-03";

        let chart_doughnut = new Chart(document.getElementById(chartID), {
            type: 'doughnut',
            data: {
                labels: ["사용", "미사용"],
                datasets: [
                    {
                        label: "수용량 (%)",
                        backgroundColor: ["#3e95cd", "#cccccc"],
                        data: newDataset[i]
                    }
                ]
            },
            options: {
                title: {
                    display: true,
                    text: newName[i]
                }
            }
        });
    }

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

    let Chart_line = new Chart (document.getElementById("line-chart"), {
        type: 'line',
        data: {
            labels: ["2024-02-01", "2024-02-02", "2024-02-03", "2024-02-04", "2024-02-05", "2024-02-06", "2024-02-07"],
            datasets: [newDataset_line[currentIndex], newDataset_line[currentIndex+1], newDataset_line[currentIndex+2], newDataset_line[currentIndex+3]
            ]
        },
        options: {
            title: {
                display: true,
                text: '주간 수용량 변화'
            }
        }
    });

    


    //게시판 불러오기

    let tableView = document.querySelector("#tableView");

    let iframe = document.querySelector("#dash-iframe");
    let iframeDoc = iframe.contentDocument || iframe.contentWindow.document;


        var table = iframeDoc.getElementsByTagName('table')[0];

        // 선택한 열의 데이터를 저장할 배열
        var columnData_title = [];
        var columnData_open = [];
    
        // 테이블의 각 행을 순회하며 해당 열의 데이터 추출
        for (var i = 1; i < table.rows.length; i++) {
            var cell = table.rows[i].cells[3];
            if (cell) {
                columnData_title.push(cell.textContent || cell.innerText);
            }
        }
        for (var i = 1; i < table.rows.length; i++) {
            var cell = table.rows[i].cells[5];
            if (cell) {
                columnData_open.push(cell.textContent || cell.innerText);
            }
        }
    
        // 결과 확인
        // console.log(columnData_title);
    
        html = '<colgroup><col width="85%"/><col width="*"/></colgroup><thead><th>제목</th><th>조회수</th></thead>';
        for(let i = 0; i <4; i++){
            html += ' <tr>';
            html += ' <td>';
            html += ' <a href="board.html">';
            html += columnData_title[i];
            html += ' </a>';
            html += ' </td>';
            html += ' <td>';
            html += columnData_open[i];
            html += ' </td>';
            html += ' </tr>';
        }

        tableView.innerHTML = html;


};

