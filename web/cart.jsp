<%@page import="nam.dto.Plant"%>
<%@page import="nam.dao.PlanDAO"%>
<%@page import="java.util.HashMap"%>
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
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="mainController?action=homePage">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Shopping Cart</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Cart Start -->
    <form>
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Products</th>
                            <th>ID</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <%
                        int total = 0;
                        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
                                if (cart != null && !cart.isEmpty()) {
                    %>
                    <tbody class="align-middle">
                        <tr>
                            <%
                                int i = 0;
                                for (String pid : cart.keySet()) {
                                    Plant p = PlanDAO.getPlant(Integer.parseInt(pid.trim()));
                                    total += p.getPrice() * cart.get(p.getId() + "");
                            %>
                            <td class="align-middle"><img src="<%=p.getPath()%>" alt="" style="width: 50px;margin-right: 30px;"><%=p.getName()%></td>
                            <td class="align-middle"><%=p.getId()%></td>
                            <td class="align-middle">$<%=p.getPrice()%></td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button onclick="return minusQuantity('<%=p.getId()%>');" class="btn btn-sm btn-primary btn-minus" >
                                        <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                        <input type="text" name="txtnum<%=i++%>" onkeyup="changeQuantity('<%=p.getId()%>')" class="form-control form-control-sm bg-secondary text-center" value="<%=cart.get(pid)%>">
                                    <div class="input-group-btn">
                                        <button onclick="return plusQuantity('<%=p.getId()%>');" class="btn btn-sm btn-primary btn-plus">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle total-project">$<%=p.getPrice()*cart.get(pid)%></td>
                            <td class="align-middle"><button onclick="return removeButton('<%=p.getId()%>');" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button></td>
                        </tr>
                        <% }%>
                        <tr><td colspan="5"></td>
                            <td >
                                    <div class="input-group">
                <!--                        <input type="text" class="form-control p-4" placeholder="Coupon Code">-->
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" name="action" value="saveCart">Save</button>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                    <% }%>
                </table>
            </div>
            <div class="col-lg-4">
                
                <div class="card border-secondary mb-5" id="build">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                    </div>
                    <div class="card-body">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Subtotal</h6>
                            <h6 class="font-weight-medium">$<%=total%></h6>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">     
                        <button <c:if test="${sessionScope.cart==null||sessionScope.cart.size()==0}">disabled</c:if> name="action" value="moveCheckout" class="btn btn-block btn-primary my-3 py-3">Proceed To Checkout</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
    <!-- Cart End -->
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
    <script src="js/quantity.js"></script>
</body>

</html>