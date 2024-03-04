

window.addEventListener("load", function () {
    bind();


    document.querySelector(".navi-item1").setAttribute("class", "navi-item navi-item1 active");

    //로그인 환경
    const userType = localStorage.getItem('userType');


    if(userType == 'admin'){

    } else if (userType == 'user'){
        
        document.querySelector(".navi-item9").style.display = "none";
        document.querySelector(".status-user").innerHTML = "접속자: 천안센터 사용자";

    }

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




    // AJAX를 사용하여 서버로 요청을 보냄
    let dataServer;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'whhis.do', true);

    // 요청이 완료되었을 때의 동작
    xhr.onload = function () {
        if (xhr.status == 200) {
            // 요청이 성공했을 때의 동작
            dataServer = JSON.parse(xhr.responseText);
			
			// chart 갱신 함수 실행
			updateChart(dataServer)
			
        } else {
            // 요청이 실패했을 때의 동작
            console.error('Request failed. Status code: ' + xhr.status);
        }
    };

    // 요청 보내기
    xhr.send();
    
	// 차트 갱신 함수
	function updateChart(dataServer) {
		console.log(dataServer);
		console.log(dataServer[0]);
		
		// 도넛 차트 이름 업데이트
		var newName = new Array(9);
		for(let i =0;  i < newName.length ;i++){
        	newName[i] = dataServer[i].wzone;
        }
        
        
        // 도넛 차트 내용 업데이트
		var newDataset = new Array(9);
		for(let i =0;  i < newDataset.length ;i++){
			// j : 최근 일주일 데이터 중 가장 마지막일
			let j = dataServer.length - (newDataset.length -1);
        	newDataset[i] = [dataServer[j].wcnt,dataServer[j].wcnt*dataServer[j].wpercent/100];
        }
        
        
	    // chart 부분 정보 불러오기
	    for (let i = 0; i < 9; i++) {
	
	        var chartID = `doughnut-chart${i}`;
	        
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
	
	
	
		// line chart (주간 수용량 변화)
	    var newDataset_line = new Array(9);
	    
	    colorSet = ["#3e95cd","#8e5ea2","#33FF57","#FF33F6","#FFC300", "#FF5733", "#F333FF", "#33FFF6", "#8e5ea2"];
	    
	    for(let i = 0; i < newDataset_line.length; i++){
	    
	    	newDataset_line[i] = {
	        data: [dataServer[i+0*newDataset_line.length].wpercent, dataServer[i+1*newDataset_line.length].wpercent, dataServer[i+2*newDataset_line.length].wpercent, dataServer[i+3*newDataset_line.length].wpercent, dataServer[i+4*newDataset_line.length].wpercent, dataServer[i+5*newDataset_line.length].wpercent, dataServer[i+6*newDataset_line.length].wpercent],
	        label: dataServer[i].wzone,
	        borderColor: colorSet[i],
	        fill: false
	    	};
	    
	    }
	    
	    
	    let Chart_line = new Chart (document.getElementById("line-chart"), {
	        type: 'line',
	        data: {
	            labels: [dataServer[0*newDataset_line.length].wdate, dataServer[1*newDataset_line.length].wdate, dataServer[2*newDataset_line.length].wdate, dataServer[3*newDataset_line.length].wdate, dataServer[4*newDataset_line.length].wdate, dataServer[5*newDataset_line.length].wdate, dataServer[6*newDataset_line.length].wdate],
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
	}
    


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

