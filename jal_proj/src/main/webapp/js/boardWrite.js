function openFileExplorer() {
    // 파일 탐색기 열기
    let input = document.createElement('input');
    input.type = 'file';
    input.click();

    // 파일 선택 시 이벤트 처리
    input.onchange = function (event) {
        let file = event.target.files[0];
        let fileName = file.name;
        // 파일 이름을 입력창에 표시하고 보이도록 함
        let fileNameDisplay = document.getElementById('fileNameDisplay');
        fileNameDisplay.value = "첨부파일 : " + fileName;
        fileNameDisplay.style.display = 'block';
        document.getElementById('fileUploadRow').style.display = 'none';
        document.getElementById('fileTitleRow').style.display = 'table-row';
    };

}
function showAlert() {

    let title = document.getElementsByName("title")[0].value;
    let content = document.querySelector("textarea").value;
  
    if (title === "") {
        alert("제목을 입력해주세요.");
    } else if (content === "") {
        alert("내용을 입력해주세요.");
    }
     else {
        alert("정상적으로 등록되었습니다.");
        window.location.href = "boardList.jsp";
    }
  }