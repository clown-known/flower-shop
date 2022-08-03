var MyFunction = function(value) {
    var checkList = document.getElementsByClassName("custom-control-input");
    var productList = document.getElementsByClassName("product-display");
    for (var j = 0; j < productList.length; j++) {
        productList[j].style.display = "none";
    }
    for (i = 0; i < checkList.length; i++) {
        if (checkList[i].checked == true) {
            if (i == 0) {
                for (var j = 0; j < productList.length; j++) {
                    productList[j].style.display = "";
                }
            }
            for (var k = 1; k < 7; k++) {
                if (i == k) {
                    for (var j = 0; j < productList.length; j++) {
                        var a = productList[j].getElementsByTagName("h6")[1];
                        var txtValue = a.textContent || a.innerText;
                        txtValue = txtValue.substring(1);
                        var intValue = parseInt(txtValue);
                        if ((k - 1) * 100 <= intValue && intValue <= k * 100) {
                            productList[j].style.display = "";
                        }
                    }
                }
            }
        }
    }
};