window.addEventListener("load", function () {
    bind();
})

function bind() {
    document.querySelector("#select_all1").addEventListener("click", function (event) {
        let list_check1 = document.querySelectorAll(".chk1")

        if (event.target.checked) {
            let list_check1 = document.querySelectorAll(".chk1")
            for (let i = 0; i < list_check1.length; i++) {
                list_check1[i].checked = true;
            }
        } else {
            let list_check1 = document.querySelectorAll(".chk1")
            for (let i = 0; i < list_check1.length; i++) {
                list_check1[i].checked = false;
            }
        }
    });
    document.querySelector("#select_all2").addEventListener("click", function (event) {
        let list_check2 = document.querySelectorAll(".chk2")

        if (event.target.checked) {
            let list_check2 = document.querySelectorAll(".chk2")
            for (let i = 0; i < list_check2.length; i++) {
                list_check2[i].checked = true;
            }
        } else {
            let list_check2 = document.querySelectorAll(".chk2")
            for (let i = 0; i < list_check2.length; i++) {
                list_check2[i].checked = false;
            }
        }
    });
    document.querySelector("#select_all3").addEventListener("click", function (event) {
        let list_check3 = document.querySelectorAll(".chk3")

        if (event.target.checked) {
            let list_check3 = document.querySelectorAll(".chk3")
            for (let i = 0; i < list_check3.length; i++) {
                list_check3[i].checked = true;
            }
        } else {
            let list_check3 = document.querySelectorAll(".chk3")
            for (let i = 0; i < list_check3.length; i++) {
                list_check3[i].checked = false;
            }
        }
    });
    document.querySelector("#select_all4").addEventListener("click", function (event) {
        let list_check4 = document.querySelectorAll(".chk4")

        if (event.target.checked) {
            let list_check4 = document.querySelectorAll(".chk4")
            for (let i = 0; i < list_check4.length; i++) {
                list_check4[i].checked = true;
            }
        } else {
            let list_check4 = document.querySelectorAll(".chk4")
            for (let i = 0; i < list_check4.length; i++) {
                list_check4[i].checked = false;
            }
        }
    });
    document.querySelector("#select_all5").addEventListener("click", function (event) {
        let list_check5 = document.querySelectorAll(".chk5")

        if (event.target.checked) {
            let list_check5 = document.querySelectorAll(".chk5")
            for (let i = 0; i < list_check5.length; i++) {
                list_check5[i].checked = true;
            }
        } else {
            let list_check5 = document.querySelectorAll(".chk5")
            for (let i = 0; i < list_check5.length; i++) {
                list_check5[i].checked = false;
            }
        }
    });

    // select 모두 선택

    document.getElementById("change_button1").addEventListener("click", function () {
        let list_change1 = document.querySelectorAll(".select_op1");
        let selectedOption = document.getElementById("select_change1").value;

        for (let i = 0; i < list_change1.length; i++) {
            if (list_change1[i].value === selectedOption) {
                list_change1[i].selected = !list_change1[i].selected;
            }
        }
    });

    document.getElementById("change_button2").addEventListener("click", function () {
        let list_change2 = document.querySelectorAll(".select_op2");
        let selectedOption = document.getElementById("select_change2").value;

        for (let i = 0; i < list_change2.length; i++) {
            if (list_change2[i].value === selectedOption) {
                list_change2[i].selected = !list_change2[i].selected;
            }
        }
    });

    // select 선택 검색

}

// popup

function openPopup() {
    document.getElementById('popup').style.display = "block";
}

function closePopup() {
    document.getElementById('popup').style.display = "none";
}
