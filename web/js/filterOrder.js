var fillerFunction = function(value) {

    var tr = document.getElementsByTagName("tr");
    var checkList = document.getElementsByClassName("custom-control-input");
    for (var i = 1; i < tr.length; i++) {
        tr[i].style.display = "none";
    }
    var statusList = ['', 'processing', 'completed', 'canceled'];
    for (var i = 0; i < checkList.length; i++) {
        if (checkList[i].checked == true) {
            if (i == 0) {
                for (var j = 1; j < tr.length; j++) {
                    tr[j].style.display = "";
                }
            }
            for (var k = 1; k <= 3; k++) {
                if (i == k) {
                    for (var j = 1; j < tr.length; j++) {
                        var a = tr[j].getElementsByTagName("td")[3];
                        var txtStatus = a.textContent || a.innerText;
                        if (txtStatus == statusList[k]) {
                            tr[j].style.display = "";
                        }
                    }
                }
            }
        }
    }

}