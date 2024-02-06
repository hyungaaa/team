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

function lotSelect() {
  // 셀렉트
  let lotSelect = document.getElementById("lotSelect");
  // 셀렉트 옵션 값 가져오기
  var optionTxt = lotSelect.options[document.getElementById("lotSelect").selectedIndex].text;

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    let match = false;

    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      if (optionTxt === "LOT No." && j === 0) {
        if (txtValue.toUpperCase().indexOf(optionTxt) == -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "LT202402010001" && j === 0) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "LT202402010002" && j === 0) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }

      } else if (optionTxt === "LT202402020001" && j === 0) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }

      } else if (optionTxt === "LT202402020002" && j === 0) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }

      } else if (optionTxt === "LT202402020003" && j === 0) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }

      } else if (optionTxt === "LT202402020004" && j === 0) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }

      } else if (optionTxt === "LT202402020005" && j === 0) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      }
    }

    rows[i].style.display = match ? "" : "none";
  }
}

function locSelect() {
  // 셀렉트
  let locSelect = document.getElementById("locSelect");
  // 셀렉트 옵션 값 가져오기
  var optionTxt = locSelect.options[document.getElementById("locSelect").selectedIndex].text;

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    let match = false;

    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      if (optionTxt === "위치코드" && j === 1) {
        if (txtValue.toUpperCase().indexOf(optionTxt) == -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "A-01" && j === 1) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "B-01" && j === 1) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      }
    }
    rows[i].style.display = match ? "" : "none";
  }
}

function pdtCodeSelect() {
  // 셀렉트
  let pdtCodeSelect = document.getElementById("pdtCodeSelect");
  // 셀렉트 옵션 값 가져오기
  var optionTxt = pdtCodeSelect.options[document.getElementById("pdtCodeSelect").selectedIndex].text;

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    let match = false;

    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      if (optionTxt === "제품번호" && j === 2) {
        if (txtValue.toUpperCase().indexOf(optionTxt) == -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "ESB00001" && j === 2) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "ICA00003" && j === 2) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "BMB00005" && j === 2) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "EJB00003" && j === 2) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      }
    }
    rows[i].style.display = match ? "" : "none";
  }
}

function pdtNameSelect() {
  // 셀렉트
  let pdtNameSelect = document.getElementById("pdtNameSelect");
  // 셀렉트 옵션 값 가져오기
  var optionTxt = pdtNameSelect.options[document.getElementById("pdtNameSelect").selectedIndex].text;

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    let match = false;

    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      if (optionTxt === "제품명" && j === 3) {
        if (txtValue.toUpperCase().indexOf(optionTxt) == -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "샌)망곰초코딸기샌드" && j === 3) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "나뚜루)녹차바" && j === 3) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "남양)불가리스딸기150ml" && j === 3) {
        if (txtValue.indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      } else if (optionTxt === "주)LT명란마요삼각" && j === 3) {
        if (txtValue.toUpperCase().indexOf(optionTxt) > -1) {
          match = true;
          break;
        }
      }
    }
    rows[i].style.display = match ? "" : "none";
  }
}

function modCnt() {
  let modBtn = document.getElementById("modBtn");

  let tbl = document.getElementById("tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");
  
  for (let i = 0; i < tbl.rows.length; i++) {
    tbl.rows[i].cells[6].onclick = function() {
      tbl.rows[i].cells[4].innerHTML = "<input class='table_blind_txt mod-txt' type='text'>";
      tbl.rows[i].cells[5].innerHTML = "<input class='table_blind_txt mod-txt' type='text'>";
      tbl.rows[i].cells[6].innerHTML = "<button type='button' class='table_btn' id='modBtn' onclick='modCnt()'>확인</button>";
    }
  }
}