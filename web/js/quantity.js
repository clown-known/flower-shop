var changeQuantity = function(value) {
    var tr = document.getElementsByTagName("tr");
    for (var i = 1; i < tr.length; i++) {
        var td = tr[i].getElementsByTagName("td");
        var txtid = td[1].textContent || td[1].innerText;
        if (txtid == value) {
            var a = td[3].getElementsByTagName("input")[0];
            var txtValue = a.value;
            if (txtValue == null || txtValue == "" || txtValue == 0) {
                td[4].innerHTML = "$0";
            } else {
                var txtPrice = td[2].textContent || td[2].innerText;
                txtPrice = txtPrice.substring(1);
                var intPrice = parseInt(txtPrice);
                var intValue = parseInt(txtValue);
                td[4].innerHTML = "$" + intPrice * intValue;
            }

        }
    }
    var t = document.getElementsByClassName("total-project");
    var sum = 0;
    for (var i = 0; i < t.length; i++) {
        var txtPrice = t[i].textContent || t[i].innerText;
        txtPrice = txtPrice.substring(1);
        var intPrice = parseInt(txtPrice);
        sum += intPrice;
    }
    var card = document.getElementById("build");
    card.getElementsByTagName("h6")[1].innerHTML = "$" + sum;

    return false;
}

var plusQuantity = function(value) {
    var tr = document.getElementsByTagName("tr");
    for (var i = 1; i < tr.length; i++) {
        var td = tr[i].getElementsByTagName("td");
        var txtid = td[1].textContent || td[1].innerText;
        if (txtid == value) {
            var a = td[3].getElementsByTagName("input")[0];
            var txtValue = a.value;
            if (txtValue == null || txtValue == "" || txtValue == 0) {
                intValue = 1;
            } else {
                intValue = parseInt(txtValue) + 1;
            }
            var txtPrice = td[2].textContent || td[2].innerText;
            txtPrice = txtPrice.substring(1);
            var intPrice = parseInt(txtPrice);
            td[4].innerHTML = "$" + intPrice * intValue;

        }
    }
    var t = document.getElementsByClassName("total-project");
    var sum = 0;
    for (var i = 0; i < t.length; i++) {
        var txtPrice = t[i].textContent || t[i].innerText;
        txtPrice = txtPrice.substring(1);
        var intPrice = parseInt(txtPrice);
        sum += intPrice;
    }
    var card = document.getElementById("build");
    card.getElementsByTagName("h6")[1].innerHTML = "$" + sum;

    return false;
}

var minusQuantity = function(value) {
    var tr = document.getElementsByTagName("tr");
    for (var i = 1; i < tr.length; i++) {
        var td = tr[i].getElementsByTagName("td");
        var txtid = td[1].textContent || td[1].innerText;
        if (txtid == value) {
            var a = td[3].getElementsByTagName("input")[0];
            var txtValue = a.value;
            if (txtValue == null || txtValue == "" || txtValue == 0) {
                intValue = 0;
            } else {
                var txtPrice = td[2].textContent || td[2].innerText;
                txtPrice = txtPrice.substring(1);
                var intPrice = parseInt(txtPrice);
                intValue = parseInt(txtValue) - 1;
                td[4].innerHTML = "$" + intPrice * intValue;
            }

        }

    }
    var t = document.getElementsByClassName("total-project");
    var sum = 0;
    for (var i = 0; i < t.length; i++) {
        var txtPrice = t[i].textContent || t[i].innerText;
        txtPrice = txtPrice.substring(1);
        var intPrice = parseInt(txtPrice);
        sum += intPrice;
    }
    var card = document.getElementById("build");
    card.getElementsByTagName("h6")[1].innerHTML = "$" + sum;
    return false;
}

var removeButton = function(id) {
    if (confirm('Are you sure remove product id ' + id + ' ?') == true) {
        var tr = document.getElementsByTagName("tr");
        for (var i = 1; i < tr.length; i++) {
            var td = tr[i].getElementsByTagName("td");
            var txtid = td[1].textContent || td[1].innerText;
            if (txtid == id) {
                td[3].getElementsByTagName("input")[0].value = 0;
                tr[i].style.display = "none";
                changeQuantity(id);
            }
        }
    }
    return false;
}