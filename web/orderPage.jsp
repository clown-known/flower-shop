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
    <%--<c:if test="${sessionScope.user==null}">--%>
        <%--<c:redirect url="mainController?action=login"></c:redirect>--%>
    <%--</c:if>--%>
    <%@include file="Header.jsp" %>


    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Persional Order</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="mainController?action=homePage">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Persional Order</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Cart Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-3">
                <h5 class="font-weight-semi-bold mb-4">Filter by price</h5>
                <form>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" onclick="fillerFunction('0')" class="custom-control-input" checked id="price-all">
                        <label class="custom-control-label" for="price-all">All</label>
                        <span class="badge border font-weight-normal">1000</span>
                    </div>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" onclick="fillerFunction('1')" class="custom-control-input" id="price-1">
                        <label class="custom-control-label" for="price-1">Processing</label>
                        <span class="badge border font-weight-normal">150</span>
                    </div>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" onclick="fillerFunction('2')" class="custom-control-input" id="price-2">
                        <label class="custom-control-label" for="price-2">Completed</label>
                        <span class="badge border font-weight-normal">295</span>
                    </div>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" onclick="fillerFunction('3')" class="custom-control-input" id="price-3">
                        <label class="custom-control-label" for="price-3">Canceled</label>
                        <span class="badge border font-weight-normal">246</span>
                    </div>
                </form>
            </div>
            <div class="col-lg-9 table-responsive mb-5">
                <div class="col-12 pb-1">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <form action="mainController" method="get">
                            <div class="input-group">
                                <input type="date" name="dateFrom" class="form-control">
                                <input type="date" name="dateTo" class="form-control">
                                <div class="input-group-append">
                                    <button name="action" value="searchOrder" class="input-group-text bg-transparent text-primary">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                        <div class="dropdown ml-4">
                            <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Sort by
                                    </button>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                <a class="dropdown-item" href="#">Latest</a>
                                <a class="dropdown-item" href="#">Popularity</a>
                                <a class="dropdown-item" href="#">Best Rating</a>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Order ID</th>
                            <th>Order Date</th>
                            <th>Ship Date</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <% 
                        if(request.getAttribute("oList")!=null){
                            String[] status = {"","<font color='blue'>processing</font>","<font color='green'>completed</font>","<font color='red'>canceled</font>"};
                            ArrayList<Order> oList = (ArrayList<Order>)request.getAttribute("oList");
                            for (Order o : oList) {
                    %>
                        <tr>
                            <td class="align-middle"><%=o.getOrderID()%></td>
                            <td class="align-middle"><%=o.getOrderDate()%></td>
                            <td class="align-middle"><%=o.getShipDate()==null?"-":o.getShipDate()%></td>
                            <td class="align-middle"><%=status[o.getStatus()]%></td>
                            <td class="align-middle">
                                <a href="mainController?action=viewOrder&oid=<%=o.getOrderID()%>" class="btn btn-sm btn-primary"><img style="height: 20px;width: 20px;" src="images/icons8-view-details-26.png"></a>
                                <c:if test="<%=o.getStatus()==1%>"><a href="mainController?action=cancel&oid=<%=o.getOrderID()%>" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></a></c:if>
                                <c:if test="<%=o.getStatus()==3%>"><a href="mainController?action=reorder&oid=<%=o.getOrderID()%>" class="btn btn-sm btn-primary"><i class="fas fa-shopping-cart"></i></a></c:if>
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