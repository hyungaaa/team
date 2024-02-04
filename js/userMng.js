// window.onload = function(){
// }
window.addEventListener("load", function () {
    bind();
})

function bind() {

    // "할일 추가" 버튼을
    let add = document.querySelector("#add");
    // console.log(add)

    // 클릭하면
    add.addEventListener('click', function () {
        // console.log("클릭함!!!");

        // input의
        let todo = document.querySelector("#todo");
        // 글씨를
        console.log(todo.value)

        // 목록에
        let todoList = document.querySelector("#todoList");
        // 한줄을
        let html = '';
        // html += '<tr>';
        html += '    <td>이름</td>';
        html += '    <td>사원번호</td>';
        html += '    <td>센터</td>';
        html += '    <td>권한</td>';
        html += '    <td>';
        html += '        <input type="checkbox" class="chk">';
        html += '    </td>';
        html += '    <td>';
        html += '        <input type="checkbox" class="chk">';
        html += '    </td>';
        html += '    <td>';
        html += '        <input type="checkbox" class="chk">';
        html += '    </td>';
        html += '    <td>';
        html += '        <input type="checkbox" class="chk">';
        html += '    </td>';
        html += '    <td>';
        html += '        <input type="checkbox" class="chk">';
        html += '    </td>';
        html += '    <td>';
        html += '        <button type="button" class="del">삭제</button>';
        html += '    </td>';
        // html += '</tr>';
        // 추가한다
        // todoList.innerHTML += html

        let tr = document.createElement("tr"); // <tr></tr>
        tr.innerHTML = html;

        // 삭제 이벤트 부여/바인딩
        tr.querySelector(".del")
            .addEventListener("click", function (event) {
                // 구조상 내 부모의 부모를
                let parent_tr = event.target.parentNode.parentNode;
                // 지우자
                parent_tr.remove();
            })

        // 내 자식 요소 중에서 마지막에 DOM 추가
        todoList.append(tr);
    })


    // 개별 삭제 버튼을
    // 클릭하면
    // 줄 삭제

    // // 개별 삭제 버튼들 모두 가져와서
    // let list_del = document.querySelectorAll(".del");
    // console.log('list_del.length : '+ list_del.length)
    // for(let i=0; i<list_del.length; i++){
    //     // 개별 삭제 버튼 하나마다 클릭 이벤트 주기
    //     list_del[i].addEventListener("click", function(event){
    //         // 실제로 클릭된 요소
    //         console.log(event.target)
    //         console.log(this)
    //         console.log(event.target === this)

    //         // 구조상 내 부모의 부모를
    //         let tr = event.target.parentNode.parentNode;
    //         console.log(tr)

    //         // 지우자
    //         tr.remove();
    //     })
    // }

    // // table은 처음부터 끝까지 함께하니까
    // // table에 클릭이벤트
    // document.querySelector("#todoList").addEventListener("click", function(event){
    //     // 실제로 클릭된 요소
    //     console.log(event.target)

    //     // 이벤트가 바인딩된 요소
    //     console.log(event.currentTarget)

    //     // 단점 : 테이블의 모든 요소에서 클릭 이벤트가 발생하므로
    //     // 삭제 버튼 여부를 확인해야 한다
    // })


    // 선택 삭제 버튼을
    // 누르면
    document.querySelector("#selected_del").addEventListener("click", function () {

        // checkbox가 선택된 줄을
        //      1. 모든 줄마다 check 여부를 검사
        // let list_check = document.querySelectorAll(".chk")
        // for(let i=0; i<list_check.length; i++){
        //     console.log('list_check[i].checked : '+ list_check[i].checked);
        //     if(list_check[i].checked){
        //         list_check[i].parentNode.parentNode.remove();
        //     }

        // }

        //      2. check된 것만 선택
        let list_checked = document.querySelectorAll(".chk:checked")
        // 모두 지운다
        for (let i = 0; i < list_checked.length; i++) {
            list_checked[i].parentNode.parentNode.remove();
        }
    })


    // 전체 선택 checkbox를 클릭하면
    // check 상태에 따라서
    // 전부 check 한 상태로
    // 전부 check 안한 상태로

    document.querySelector("#select_all").addEventListener("click", function (event) {
        // 클릭된 요소가
        // check 상태라면
        let list_check = document.querySelectorAll(".chk")

        if (event.target.checked) {
            let list_check = document.querySelectorAll(".chk")
            for (let i = 0; i < list_check.length; i++) {
                list_check[i].checked = true;
            }
        } else {
            let list_check = document.querySelectorAll(".chk")
            for (let i = 0; i < list_check.length; i++) {
                list_check[i].checked = false;
            }
        }
        // check 상태가 아니라면
    });
}
function openPopup() {
    document.getElementById('popup').style.display = "block";
}

function closePopup() {
    document.getElementById('popup').style.display = "none";
}