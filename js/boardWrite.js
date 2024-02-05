function openFileExplorer() {
    // 파일 탐색기 열기
    const input = document.createElement('input');
    input.type = 'file';
    input.click();

    // 파일 선택 시 이벤트 처리
    input.onchange = function (event) {
        const file = event.target.files[0];
        const fileName = file.name;
        // 파일 이름을 입력창에 표시하고 보이도록 함
        const fileNameDisplay = document.getElementById('fileNameDisplay');
        fileNameDisplay.value = "첨부파일 : " + fileName;
        fileNameDisplay.style.display = 'block';
        document.getElementById('fileUploadRow').style.display = 'none';
        document.getElementById('fileTitleRow').style.display = 'table-row';
    };
}