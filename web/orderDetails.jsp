<%-- 
    Document   : orderDetails
    Created on : Apr 16, 2022, 3:58:00 PM
    Author     : LapTop
--%>
<%@page import="nam.dto.OrderDetail"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
<%@include file="Header.jsp" %>
    <body>
        <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Shopping Cart</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->
    
    <!-- Cart Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="row">
                <div class="col-lg-5"></div>
                <div class="col-lg-7" >
                        <div class="input-group-append">
                            <button onclick="history.back()" class="btn btn-primary">Back</button>
                        </div>
                </div> 
            </div>
            <div class="col-lg-12 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <c:if test="${requestScope.oList!=null}">
                    <%
                        ArrayList<OrderDetail> oList = (ArrayList<OrderDetail>) request.getAttribute("oList");
                        for (OrderDetail o : oList) {
                    %>
                    <tbody class="align-middle">
                        <tr>
                            <td class="align-middle"><img src="<%=o.getImgPath()%>" alt="" style="width: 50px;"><%=o.getPlantName()%></td>
                            <td class="align-middle">$<%=o.getPrice()%></td>
                            <td class="align-middle"><%=o.getQuantity()%></td>
                            <td class="align-middle">$<%=o.getQuantity()*o.getPrice()%></td>
                        </tr>

                    </tbody>
                    <%    }%>
                    </c:if>
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
</body>

</html>
