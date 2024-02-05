        function exportToExcel() {
            const table = document.getElementById("tableToExport");
            const html = table.outerHTML;

            const blob = new Blob([html], {
                type: "application/vnd.ms-excel"
            });

            const a = document.createElement("a");
            const url = URL.createObjectURL(blob);
            a.href = url;
            a.download = "data.xls";
            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
            URL.revokeObjectURL(url);
        }

        function searchTable() {
            const input = document.getElementById("searchInput").value.toUpperCase();
            const selectOption = document.getElementById("searchOption").value;

            const table = document.getElementById("tableToExport");
            const tbody = table.getElementsByTagName("tbody")[0];
            const rows = tbody.getElementsByTagName("tr");

            for (let i = 0; i < rows.length; i++) {
                const cells = rows[i].getElementsByTagName("td");
                let match = false;

                for (let j = 0; j < cells.length; j++) {
                    const cell = cells[j];
                    const txtValue = cell.textContent || cell.innerText;

                    if (selectOption === "all") {
                        if (txtValue.toUpperCase().indexOf(input) > -1) {
                            match = true;
                            break;
                        }
                    } else if (selectOption === "title" && j === 3) {
                        if (txtValue.toUpperCase().indexOf(input) > -1) {
                            match = true;
                            break;
                        }
                    } else if (selectOption === "productCode" && j === 2) {
                        if (txtValue.toUpperCase().indexOf(input) > -1) {
                            match = true;
                            break;
                        }
                    }
                } 

                rows[i].style.display = match ? "" : "none";
            }
        }
