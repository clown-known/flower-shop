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
    <!-- Checkout Start -->
    <form action="mainController" method="post">
        <div class="container-fluid pt-5">
            <div class="row px-xl-5">
                <div class="col-lg-4">
                </div>
                <div class="col-lg-4">
                    <div class="card border-secondary mb-5">
                        <div class="card-header bg-secondary border-0">
                            <h4 class="font-weight-semi-bold m-0">Login</h4>
                        </div>
                        <div class="card-body">
                            <h5 class="font-weight-medium">Confirm information</h5>
                            <div class="d-flex justify-content-between">
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label>Email</label>
                                        <input class="form-control" type="text" name="txtemail" value="${requestScope.txtemail}" placeholder="Email" required>
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <label>Password</label>
                                        <input class="form-control" type="text" name="txtpass" value="${requestScope.txtpass}" placeholder="Password" required>
                                    </div>
                                    <c:if test="${requestScope.ERROR!=null}">
                                        <div class="col-md-12 form-group">
                                            <font color="red">${requestScope.ERROR}</font>
                                        </div>
                                    </c:if>
                                    <div class="col-md-12 form-group">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" name="savelogin" class="custom-control-input" id="newaccount">
                                            <label class="custom-control-label" for="newaccount">Save me</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer border-secondary bg-transparent">
                                <button name="action" value="login" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Login</button>
                            </div>
                        </div>
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
    <c:if test="${requestScope.WARRING!=null}">
        <script>
            alert("${requestScope.WARRING}");
        </script>
    </c:if>

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

</body>

</html>