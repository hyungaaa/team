
document.addEventListener("DOMContentLoaded", function () {

    document.querySelector(".navi-item2").setAttribute("class", "navi-item navi-item2 active");

});

// 저장 버튼 누르면 alert 창 뜨게
function saveShow() {
    var savealert = confirm("저장 하시겠습니까?");
    if (savealert) {
        alert("저장되었습니다.");
    } else {
        alert("취소되었습니다.");
    }
}


// 검색 가능
// 검색결과 나오게 하는 거 

document.addEventListener("DOMContentLoaded", function () {
    // 검색버튼, 입력 요소 가져오기
    var searchButton = document.querySelector(".main_btn_mng");
    var searchInput = document.querySelector(".main_search_txt_mng");


    function performSearch() {
        var searchKeyword = searchInput.value.toLowerCase();
        var rows = document.querySelectorAll("#productBoard table tr");
        rows.forEach(function (row, index) {
            var showRow = false;

            if (index === 0) {
                showRow = true;
            }
            else {
                // 검색어 일치하는지 확인
                row.querySelectorAll("td").forEach(function (cell) {
                    if (cell.textContent.toLowerCase().includes(searchKeyword)) {
                        showRow = true;
                    }
                });
            }

            // 일치 하는 부분 없으면 행 숨김
            if (!showRow) {
                row.style.display = "none";
            } else {
                row.style.display = ""; // 일치하는 부분 표시
            }
        });
    };


    // 검색 버튼 누르면 검색 가능
    searchButton.addEventListener("click", performSearch);

    // 엔터 누르면 검색 가능
    searchInput.addEventListener("keydown", function (event) {
        if (event.key === "Enter") {
            performSearch();
        }
    });
});




// 카테고리에 속하는 제품 행만 보이도록
function filterCategory(category) {
    var productRows = document.querySelectorAll(".product-row");
    productRows.forEach(function (row) {
        var rowCategory = row.dataset.category;

        if (category ==  '전체' || rowCategory == category) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }

    });

}

document.addEventListener("DOMContentLoaded", function () {

    var catBtn = document.querySelectorAll('#scate_mng');

    catBtn.forEach(function (btn) {

        
        btn.addEventListener("click",
        filterCategory()
        )
        btn.addEventListener("click", function () {
            
            catBtn.forEach(function (otherBtn) {
                if (otherBtn !== btn) {
                    otherBtn.classList.remove('active');
            console.log("실행됨 근데 db가 되어야 함 븅아")
                }
            });
            btn.classList.add('active');
        })

    })

});


document.addEventListener("DOMContentLoaded", function () {
    filterCategory('전체');

    let selected_del = document.getElementById("selected_del"); 
  selected_del.addEventListener("click", function () {
  
    let list_checked = document.querySelectorAll(".chk:checked")
    for(let i=0; i<list_checked.length; i++){
      list_checked[i].parentNode.parentNode.remove();
      // console.log(list_checked[i].parentNode);
      // console.log(list_checked[i].parentNode.parentNode)
    }
  })
  
});

function goToProductDetail(pnum) {
    // 제품 상세 정보 페이지 URL을 생성합니다.
    var url = "itemFix?pnum=" + pnum;
    
    // 새로운 페이지로 이동합니다.
    window.location.href = url;
}


function submitForm() {
    document.getElementById("productForm").submit();
}

