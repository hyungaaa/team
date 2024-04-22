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

// 페이지 로드 시 초기화합니다.
window.onload = function() {
	updateSubcategories();
};
