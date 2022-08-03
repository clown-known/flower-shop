function disableButton() {
    var num = document.getElementsByName("txtnum");
    var button = document.getElementsByName("action");
    var txtValue = num[0].value;
    alert(txtValue == 0)
    if (txtValue == 0) {
        button[0].disabled = true;
    }
}