<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <title>EShopper - Bootstrap Shop Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <%@include file="Header.jsp" %>
    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Register</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="mainController?action=homePage">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Register</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Checkout Start -->
    <form action="mainController" method="post">
        <div class="container-fluid pt-5">
            <div class="row px-xl-5">
                <div class="col-lg-8">
                    <div class="mb-4">
                        <h4 class="font-weight-semi-bold mb-4">User Information</h4>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>First Name</label>
                                <input class="form-control" name="txtfirstName" value="${requestScope.txtfirstName}" onkeyup="updateInf()" type="text" placeholder="John">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Last Name</label>
                                <input class="form-control" name="txtlastName" value="${requestScope.txtlastName}" onkeyup="updateInf()" type="text" placeholder="Doe" required>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>E-mail</label>
                                <label style="color: red; font-size: 13px;">${requestScope.ERROR_email}</label>
                                <input class="form-control" name="txtemail" value="${requestScope.txtemail}" onkeyup="updateInf()" type="text" placeholder="example@email.com" required>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Password</label>
                                <input class="form-control" name="txtpass" value="${requestScope.txtpass}" onkeyup="updateInf()" type="text" placeholder="xxxxxx" required>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Mobile No</label>
                                <label style="color: red; font-size: 13px;">${requestScope.ERROR_phone}</label>
                                <input class="form-control" name="txtphone" value="${requestScope.txtphone}" onkeyup="updateInf()" type="text" placeholder="+123 456 789">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="card border-secondary mb-5">
                        <div class="card-header bg-secondary border-0">
                            <h4 class="font-weight-semi-bold m-0">Summary</h4>
                        </div>
                        <div class="card-body">
                            <h5 class="font-weight-medium mb-3">Confirm information</h5>
                            <div class="d-flex justify-content-between">
                                <p>Name</p>
                                <p></p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>Email</p>
                                <p></p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>Phone</p>
                                <p></p>
                            </div>
                        </div>
                        <div class="card-footer border-secondary bg-transparent">
                            <button name="action" value="sigin" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Creater an account</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!-- Checkout End -->

    <%@include file="Footer.jsp" %>



    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script src="js/register.js"></script>

</body>

</html>