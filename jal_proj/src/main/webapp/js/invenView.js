document.addEventListener("DOMContentLoaded", function () {

  document.querySelector(".navi-item5").setAttribute("class", "navi-item navi-item5 active");

});


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

// 재고보정 버튼
//function modCnt() {
//  let tbl = document.getElementById("tbl");
//  let tbody = tbl.getElementsByTagName("tbody")[0];
//  let rows = tbody.getElementsByTagName("tr");
//
//  for (let i = 1; i < tbl.rows.length; i++) {
//    tbl.rows[i].cells[6].onclick = function () {
//      tbl.rows[i].cells[5].innerHTML = "<input class='table_blind_txt mod-txt' id='modifyTxt' type='text'>";
//      tbl.rows[i].cells[6].innerHTML = "<button type='button' class='table_btn' id='confirmBtn'>확인</button>";
//
//      // 확인 버튼의 클릭 이벤트 핸들러 설정
//      document.getElementById("confirmBtn").onclick = function () {
//        let modifyTxt = document.getElementById("modifyTxt").value;
//        tbl.rows[i].cells[5].innerHTML = modifyTxt;
//        tbl.rows[i].cells[6].innerHTML = "<button type='button' class='table_btn' id='modBtn' onclick='modCnt()'>재고보정</button>";
//
//        // 폼 제출
//        let form = document.getElementById("invenForm");
//        console.log("왜 실행 안됨")
//        form.submit();
//      };
//    };
//  }
//}
