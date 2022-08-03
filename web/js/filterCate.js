var filter = function(value) {

    var tr = document.getElementsByTagName("tr");
    for (var i = 1; i < tr.length; i++) {
        tr[i].style.display = "none";
    }
    if (value == 'all') {
        for (var i = 1; i < tr.length; i++) {
            tr[i].style.display = "";
        }
    } else {
        for (var i = 1; i < tr.length; i++) {
            var line = tr[i].getElementsByClassName("cate-name")[0].textContent ||
                tr.getElementsByClassName("cate-name")[0].innerText;
            if (line == value) {
                tr[i].style.display = "";
            }
        }
    }
}