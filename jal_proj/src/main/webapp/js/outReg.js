window.addEventListener("DOMContentLoaded", function () {
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
//function inRegSearch() {
//  // input창
//  let input = document.getElementById("searchInput").value.toUpperCase();
//
//  let tbl = document.getElementById("popup-tbl");
//  let tbody = tbl.getElementsByTagName("tbody")[0];
//  let rows = tbody.getElementsByTagName("tr");
//
//  for (let i = 0; i < rows.length; i++) {
//    const cells = rows[i].getElementsByTagName("td");
//    let match = false;
//
//    for (let j = 0; j < cells.length; j++) {
//      const cell = cells[j];
//      const txtValue = cell.textContent || cell.innerText;
//
//      if (j === 2) {
//        if (txtValue.toUpperCase().indexOf(input) > -1) {
//          console.log(input);
//          match = true;
//          break;
//        }
//      }
//    }
//
//    rows[i].style.display = match ? "" : "none";
//  }
//}

function inRegSearch() {
	var searchInput = document.getElementById("searchInput").value;

	// AJAX를 사용하여 서블릿으로 검색어 전달
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "outReg/search?searchInput=" + searchInput, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			console.log("searchInput : " + searchInput)
			// xhr.responseText에서 필요한 부분만 추출
			var parser = new DOMParser();
			var doc = parser.parseFromString(xhr.responseText, "text/html");
			console.log(doc)
			
			var popupTr = doc.querySelectorAll('#popup-tr');	// 맨 위 tr만 나옴 쿼리셀렉터로 해야함
			console.log(popupTr)
			let popup_tbody = document.getElementById("popup-tboby");

			document.getElementById('popup-tbl').style.display = "block";
			popup_tbody.innerHTML = "";

			// 팝업에서 뜨는 제품들
			for (var i = 0; i < popupTr.length; i++) {
				console.log(popupTr[i]);
				popup_tbody.append(popupTr[i]);
			}
			console.log(popup_tbody);
			console.log(xhr.responseText);
		}
	};
	xhr.send();
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
    html += '  <td>' + outCount.value + '</td>';
    html += '  <td>' + count.value + '</td>';
    html += '  <td>' + (count.value-outCount.value) + '</td>';
    html += '  <td>미등록</td>';
    html += '  <td></td>';
    html += '  <td></td>';
    html += '</tr>';

    if(pdtName.value == '') {
      alert('제품을 검색해주세요.');
    } else if(outCount.value != '') {
      tbl.innerHTML += html;
    } else {
      alert('수량을 입력해주세요');
    }

  })

  let selected_del = document.getElementById("selected_del"); 
  selected_del.addEventListener("click", function () {
  
    let list_checked = document.querySelectorAll(".chk:checked")
    for(let i=0; i<list_checked.length; i++){
      list_checked[i].parentNode.parentNode.remove();
      // console.log(list_checked[i].parentNode);
      // console.log(list_checked[i].parentNode.parentNode)
    }
  })
  
  
}
