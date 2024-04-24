document.addEventListener("DOMContentLoaded", function () {
    // 네비게이션 아이템 클래스 변경
    document.querySelector(".navi-item2").setAttribute("class", "navi-item navi-item2 active");

    // 페이지 로드 시 카테고리 업데이트
    updateSubcategories();

    // 버튼 클릭 이벤트 설정
    document.getElementById('getDataBtn').addEventListener('click', function() {
        // XMLHttpRequest 객체 생성
        var xhr = new XMLHttpRequest();

        // 요청을 열고 설정합니다.
        xhr.open('GET', 'http://192.168.1.62:8001/api/qr/getLastData', true);

        // 요청이 완료되었을 때의 처리를 설정합니다.
        xhr.onreadystatechange = function() {
            // 요청이 완료되고 응답이 정상적으로 받아졌는지 확인합니다.
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // JSON 데이터를 파싱합니다.
                    var data = JSON.parse(xhr.responseText);
                    var outData = data.out_data;
                    // 가져온 데이터를 처리합니다.
                    console.log("out_data 값:", outData);
                    document.getElementById('input_new2').value = outData;
                } else {
                    // 오류 처리
                    console.error('요청에 실패했습니다.');
                }
            }
        };

        // 요청을 보냅니다.
        xhr.send();
    });
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

function updateSubcategories() {
	var category = document.querySelector("select[name='bcid']").value;
	var smallCategory = document.querySelector("select[name='scid']");

	// 모든 옵션을 제거합니다.
	smallCategory.innerHTML = '';

	// 선택된 대분류에 따라 소분류 옵션을 추가합니다.
	if (category == "bc1") {
        var options = [
            { value: "sc1", text: "도시락" },
            { value: "sc2", text: "샌드위치/햄버거" },
            { value: "sc3", text: "주먹밥/김밥" }
        ];
    } else if (category == "bc2") {
        var options = [
            { value: "sc5", text: "스낵/비스켓" },
            { value: "sc6", text: "빵/디저트" },
            { value: "sc7", text: "껌/초콜릿/캔디" }
        ];
    } else if (category == "bc3") {
        var options = [
            { value: "sc9", text: "콘" },
            { value: "sc10", text: "바" },
            { value: "sc11", text: "샌드" }
        ];
    } else if (category === "bc4") {
        var options = [
            { value: "sc13", text: "가공식사" },
            { value: "sc14", text: "안주류" }
        ];
    } else if (category === "bc5") {
        var options = [
            { value: "sc16", text: "음료" },
            { value: "sc17", text: "유제품" }
        ];
    } else {
        var options = [
            { value: "sc4", text: "전체" }
        ];
    }

	// 옵션을 추가합니다.
	for (var i = 0; i < options.length; i++) {
		var option = document.createElement("option");
		option.value = options[i].value;
        option.text = options[i].text;
        smallCategory.add(option);
	}
}

function submitForm() {
    document.getElementById("productForm").submit();
}
