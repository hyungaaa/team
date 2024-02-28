function showReplyForm() {
    var replyForm = document.getElementById("replyForm");
    // 답글 입력창을 표시합니다.
    replyForm.style.display = "block";

    // textarea를 수정 가능하도록 설정합니다.
    var replyTextarea = document.getElementById("replyTextarea");
    replyTextarea.readOnly = false;
}

function submitReply() {
    var replyTextarea = document.getElementById("replyTextarea");
    var replyContent = replyTextarea.value;

    // textarea에 입력된 내용을 그대로 저장합니다.
    replyTextarea.value = replyContent;

    // 등록 버튼을 없앱니다.
    var submitReplyButton = document.getElementById("submitReplyButton");
    submitReplyButton.style.display = "none";

     // textarea를 읽기 전용으로 변경합니다.
    replyTextarea.readOnly = true;
}