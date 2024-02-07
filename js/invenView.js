// 검색
function goSearch() {
  // input창
  let input = document.getElementById("searchInput").value.toUpperCase();
  // select 옵션
  let selectOption = document.getElementById("selectOption").value;

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    let match = false;

    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      if (selectOption === "all") {
        if (txtValue.toUpperCase().indexOf(input) > -1) {
          match = true;
          break;
        }
      } else if (selectOption === "productName" && j === 3) {
        if (txtValue.toUpperCase().indexOf(input) > -1) {
          match = true;
          break;
        }
      } else if (selectOption === "productCode" && j === 2) {
        if (txtValue.toUpperCase().indexOf(input) > -1) {
          match = true;
          break;
        }
      } else if (selectOption === "LOT" && j === 0) {
        if (txtValue.toUpperCase().indexOf(input) > -1) {
          match = true;
          break;
        }
      } else if (selectOption === "locCode" && j === 1) {
        if (txtValue.toUpperCase().indexOf(input) > -1) {
          match = true;
          break;
        }
      }
    }

    rows[i].style.display = match ? "" : "none";
  }
}

// 작업자 셀렉트별로 보이게
function workerSelect() {
  // 셀렉트
  let workerSelect = document.getElementById("workerSelect");
  // 셀렉트 옵션 값 가져오기
  var optionTxt = workerSelect.value;

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  // 행
  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    let match = false;

    // 열
    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      // 셀렉트 옵션 값이랑 테이블 9번째 열 비교
      // 나중에는 작업자 이름대신 사원번호를 벨류에 넣어서 비교
      if (optionTxt === "작업자" && j === 9) {
        if (txtValue.toUpperCase().indexOf(optionTxt) == -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "박종화" && j === 9) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "송우석" && j === 9) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "윤아영" && j === 9) {
        if (txtValue.indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "이가희" && j === 9) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "임가현" && j === 9) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      }
    }
    rows[i].style.display = match ? "" : "none";
  }
}

// 재고보정 버튼
function modCnt() {
  let modBtn = document.getElementById("modBtn");

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  for (let i = 1; i < tbl.rows.length; i++) {
    console.log(tbl.rows[i].cells[6]);
    tbl.rows[i].cells[6].onclick = function () {
      tbl.rows[i].cells[4].innerHTML = "<input class='table_blind_txt mod-txt' id='modifyTxt' type='text'>";
      tbl.rows[i].cells[5].innerHTML = "<input class='table_blind_txt mod-txt' id='modifyTxt' type='text'>";
      tbl.rows[i].cells[6].innerHTML = "<button type='button' class='table_btn' id='confirmBtn' onclick='onConfirmBtn()'>확인</button>";
    }
  }
}

// 확인 버튼
function onConfirmBtn() {
  let confirmBtn = document.getElementById("confirmBtn");
  let modifyTxt = document.getElementById("modifyTxt").value;

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  for (let i = 1; i < tbl.rows.length; i++) {
    tbl.rows[i].cells[6].onclick = function () {
      // console.log(tbl.rows[i].cells[6]);
      for (let j = 4; j <= 5; j++) {
        var inputValue = tbl.rows[i].cells[j].querySelector('input').value;
        tbl.rows[i].cells[j].innerHTML = inputValue;
        // console.log(inputValue);
      }
      tbl.rows[i].cells[6].innerHTML = "<button type='button' class='table_btn' id='modBtn' onclick='modCnt()'>재고보정</button>";
    }
  }
}