window.addEventListener("load", function () {

    // 현재 시간을 표시
    function updateTime() {
        const currentTimeElement = document.getElementById('current-time');
        const now = new Date();
        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');
        const seconds = now.getSeconds().toString().padStart(2, '0');
        const formattedTime = `${hours}:${minutes}:${seconds}`;
        currentTimeElement.textContent = formattedTime;
    }

    setInterval(updateTime, 1000);





    // 상태 메세지 
    const pElement = document.querySelector(".status-message");
    let pStep = 0;
    function updateText() {
        let pDots = 'Loading';
        for (let i = 0; i < 5; i++) {
            pDots += i < pStep ? '.' : ' ';
        }
        pElement.innerText = pDots;
        pStep = (pStep + 1) % 5;
    }

    let count = 0; const maxCount = 5;

    const intervalId = setInterval(function() {
        updateText();
        count++;

        if (count >= maxCount) {
            clearInterval(intervalId);
            document.querySelector(".status-message").innerHTML = "데이터가 조회되었습니다.";
        } else if (count < maxCount){
        }
    }, 200); 


})
