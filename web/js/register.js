function updateInf() {
    var inf = document.getElementsByTagName("input");
    var fullName, Phone, mail;
    fullName = inf[1].value + " " + inf[2].value;
    phone = inf[5].value;
    mail = inf[3].value;

    var div = document.getElementsByClassName("card-body")[0].getElementsByTagName("div");
    div[0].getElementsByTagName("p")[1].innerHTML = fullName;
    div[1].getElementsByTagName("p")[1].innerHTML = mail;
    div[2].getElementsByTagName("p")[1].innerHTML = phone;

}