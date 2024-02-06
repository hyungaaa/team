function openPopup() {
  document.getElementById('popup').style.display = "block";
}

function closePopup() {
  document.getElementById('popup').style.display = "none";
}

function inRegSearch() {
  // input창
  let input = document.getElementById("searchInput").value.toUpperCase();
  // select 옵션
  // let selectOption = document.getElementById("selectOption").value;

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
  let checked = document.getElementById("chkBox").checked;

  let tbl = document.getElementById("popup-tbl");
  let tbody = tbl.getElementsByTagName("tbody")[0];
  let rows = tbody.getElementsByTagName("tr");

  let tbl2 = document.getElementById("inReg-tbl2");
  let tbody2 = tbl2.getElementsByTagName("tbody")[0];
  let rows2 = tbody2.getElementsByTagName("tr");

  for (let i = 0; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName("td");
    let match = false;

    for (let j = 0; j < cells.length; j++) {
      const cell = cells[j];
      const txtValue = cell.textContent || cell.innerText;

      
    }

    rows[i].style.display = match ? "" : "none";
  }

}