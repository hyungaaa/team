window.addEventListener("load", function () {
  bind();

  document.querySelector(".navi-item3").setAttribute("class", "navi-item navi-item3 active");

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



function checkdPopup() {
  let radioBtn = document.querySelector('input[name="inReg-radio"]:checked').value;
  let locSelect = document.getElementById('locSelect');

  let pdtName = document.getElementById('pdtName');
  let pdtNum = document.getElementById('pdtNum');
  let size = document.getElementById('size');
  let unit = document.getElementById('unit');
  let count = document.getElementById('count');
  console.log(radioBtn);
  

  let tbl = document.getElementById("inReg-tbl2");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");
  
  

  // 행 개수
  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
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
          size.value = cells[4].innerText;
          unit.value = cells[5].innerText;
          // count.value = cells[6].innerText;
          pdtNum.value = radioBtn;
          note.value = cells[9].innerText;

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


function openWindow() {
  // 팝업 창 크기 설정
  var width = 400; // 팝업 창의 너비
  var height = 600; // 팝업 창의 높이

  // 화면 중앙에 팝업 창을 위치시키기 위한 계산
  var left = (window.screen.width / 2) - (width / 2);
  var top = (window.screen.height / 2) - (height / 2);

  // 새 팝업 창 열기
  window.open('qrpage.html', 'newWindow', 'width=' + width + ', height=' + height + ', top=' + top + ', left=' + left);
}


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
    html += '  <td>' + size.value + '</td>';
    html += '  <td>' + unit.value + '</td>';
    html += '  <td>' + count.value + '</td>';
    html += '  <td>미등록</td>';
    html += '  <td></td>';
    html += '  <td></td>';
    html += '</tr>';

    if(pdtName.value == '') {
      alert('제품을 검색해주세요.');
    } else if(count.value != '') {
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

// inReg.js

function inRegSearch2() {
    var searchInput = document.getElementById("searchInput").value;
    // AJAX를 사용하여 서블릿으로 검색어 전달
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "inReg?searchInput=" + searchInput, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // 서블릿으로부터 받은 결과를 현재 페이지에 적용
            // xhr.responseText에서 필요한 부분만 추출하여 삽입
		    var parser = new DOMParser();
		    var doc = parser.parseFromString(xhr.responseText, "text/html");
		    var popupTr = doc.getElementById("popup-tr");
		
		    // popup-container에 추출한 부분 삽입
//		    var tbl = document.getElementById("popup-tbl");
			
		    document.getElementById("popup-tboby").innerHTML = popupTr;
            
            console.log(xhr.responseText);
            console.log(popupTr);
            console.log(searchInput);
        }
    };
    xhr.send();
}

