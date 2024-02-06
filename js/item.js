
// 저장 버튼 누르면 alert 창 뜨게
function confirmSave() {
    // "취소" 버튼을 눌렀을 때 동작하는 함수
    // 여기에 필요한 로직을 추가하세요.
    alert("취소 버튼을 눌렀습니다.");
}

function saveShow() {
    // "저장" 버튼을 눌렀을 때 동작하는 함수
    var confirmation = confirm("저장 하시겠습니까?");
    if (confirmation) {
        // 사용자가 확인을 눌렀을 때의 동작
        alert("저장되었습니다.");
        // 여기에 실제 저장 로직을 추가하세요.
    } else {
        // 사용자가 취소를 눌렀을 때의 동작
        alert("취소되었습니다.");
    }
}