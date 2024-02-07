window.addEventListener("load", function () {
  bind();

  document.querySelector(".navi-item4").setAttribute("class", "navi-item navi-item4 active");

})

// popup창 띄우기
function openPopup() {
  document.getElementById('popup').style.display = "block";
}

// popup창 끄기
function closePopup() {
  document.getElementById('popup').style.display = "none";
}

// 
function inRegSearch() {
  // input창
  let input = document.getElementById("searchInput").value.toUpperCase();

  let tbl = document.getElementById("popup-tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    let match = false;

    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      if (j === 2) {
        if (txtValue.toUpperCase().indexOf(input) > -1) {
          console.log(input);
          match = true;
          break;
        }
      }
    }

    rows[i].style.display = match ? "" : "none";
  }
}


function checkdPopup() {
  let radioBtn = document.querySelector('input[name="inReg-radio"]:checked').value;
  let locSelect = document.getElementById('locSelect');

  let pdtName = document.getElementById('pdtName');
  let pdtNum = document.getElementById('pdtNum');
  let size = document.getElementById('size');
  let unit = document.getElementById('unit');
  let count = document.getElementById('count');
  console.log(radioBtn);

  // 원래 테이블
  let tbl = document.getElementById("inReg-tbl2");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  // 팝업 테이블
  let tblPopup = document.getElementById("popup-tbl");
  let tbodyPopup = tblPopup.getElementsByTagName("tbody")[0];
  let rowsPopup = tbodyPopup.getElementsByTagName("tr");

  // 행 개수
  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    const cellsPopup = rowsPopup[i].getElementsByTagName("td");
    let match = false;

    // 열 개수
    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      if (j == 2) {
        if (txtValue.toUpperCase().indexOf(radioBtn) > -1) {
          match = true;
          closePopup();
          pdtName.value = cells[3].innerText;
          size.value = cellsPopup[3].innerText;
          unit.value = cellsPopup[4].innerText;
          count.value = cells[5].innerText;
          pdtNum.value = radioBtn;
          note.value = cells[10].innerText;

          console.log(radioBtn.substr(2, 1));
          // console.log(locSelect[1].value);

          if (radioBtn.substr(2, 1) == "A") {
            locSelect.value = locSelect[1].value;
          } else if (radioBtn.substr(2, 1) == "B") {
            locSelect.value = locSelect[2].value;
          } else if (radioBtn.substr(2, 1) == "C") {
            locSelect.value = locSelect[3].value;
          }

        }
      }
    }
  }

}

// 테이블 행 추가
function bind() {

  let plusTr = document.getElementById('plusTr');

  plusTr.addEventListener('click', function () {

    let tbl = document.getElementById('inReg-tbl2');
    let today = new Date();
    let year = today.getFullYear();
    let month = ('0' + (today.getMonth() + 1)).slice(-2);
    let day = ('0' + today.getDate()).slice(-2);
    let todayString = year + '-' + month + '-' + day;

    let html = '';
    html += '<tr>';
    html += '  <td><input type="checkbox"></td>';
    html += '  <td>' + todayString + '</td>';
    html += '  <td>' + pdtNum.value + '</td>';
    html += '  <td>' + pdtName.value + '</td>';
    html += '  <td>' + locSelect.value + '</td>';
    html += '  <td>' + count.value + '</td>';
    html += '  <td>' + count.value + '</td>';
    html += '  <td>' + count.value + '</td>';
    html += '  <td>미등록</td>';
    html += '  <td>' + '자동생성' + '</td>';
    html += '  <td></td>';
    html += '</tr>';

    tbl.innerHTML += html;
  })
}
