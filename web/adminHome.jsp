<%@page import="nam.dto.Account"%>
<%@page import="nam.dto.Order"%>
<%@page import="nam.dto.Order"%>
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
    <c:if test="${sessionScope.user.getRole()!=1}">
        <c:redirect url="mainController?action=homePage"></c:redirect>
    </c:if>
    <%@include file="adminHeader.jsp" %>

    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-1">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 200px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Account manager</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href=""> Admin role</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Account manager</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Cart Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-12 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>ID</th>
                            <th>Email</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <% 
                        if(request.getAttribute("aList")!=null){
                            ArrayList<Account> aList = (ArrayList<Account>)request.getAttribute("aList");
                            for (Account a : aList) {
                    %>
                        <tr>
                            <td class="align-middle"><%=a.getId()%></td>
                            <td class="align-middle"><%=a.getEmail()%></td>
                            <td class="align-middle"><%=a.getFullName()%></td>
                            <td class="align-middle"><%=a.getPhone()%></td>
                            <td class="align-middle"><%=a.getStatus()%></td>
                            <td class="align-middle">
                                </td>
                        </tr>
                    <% }}%>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
    <!-- Cart End -->

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
    <script src="js/filterOrder.js"></script>
</body>

</html>