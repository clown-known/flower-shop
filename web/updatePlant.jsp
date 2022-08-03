<%@page import="nam.dto.Plant"%>
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
    <%@include file="adminHeader.jsp" %>

    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-1">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 200px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Update Plan</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href=""> Admin role</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Update Plant</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->

    <% 
        if(request.getAttribute("obj")!=null){
            Plant p = (Plant)request.getAttribute("obj");

    %>
    <!-- Shop Detail Start -->
    <form action="mainController" method="post">
        <div class="container-fluid py-5">
            <div class="row px-xl-5">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <div class=" form-group card-body card border-secondary mb-5">
                        <div class="d-flex justify-content-between">
                            <p class="nav-item nav-link">ID</p>
                            <input class="form-control" value="${requestScope.obj.getId()}" name="txtid" type="text" readonly="">
                        </div>
                        <div class="d-flex justify-content-between">
                            <p class="nav-item nav-link">Name</p>
                            <input class="form-control" value="${requestScope.obj.getName()}" name="txtname"type="text">
                        </div>
                        <div class=" d-flex justify-content-between">
                            <p class="nav-item nav-link">Price</p>
                            <input class="form-control" value="${requestScope.obj.getPrice()}" name="txtprice" type="number" min="0">
                        </div>
                        <div class=" d-flex justify-content-between">
                            <p class="nav-item nav-link">Image</p>
                            <input class="form-control" name="txtimg" type="file" >
                            <input class="form-control" name="txtimgold" type="hidden" value="${requestScope.obj.getPath()}">
                        </div>
                        <div class=" d-flex justify-content-between">
                            <p class="nav-item nav-link">Description</p>
                            <input value="${requestScope.obj.getDes()}" class="form-control" name="txtdes" style="resize: none; height: 130px;width: 300px;">
                        </div>
                        <div class=" d-flex justify-content-between">
                            <p class="nav-item nav-link">Status</p>
                            <select name="txtstatus"  style="width:300px; height: 30px; ">
                                <option ${requestScope.obj.getStatus()==0?"selected":""} value="0">not yet</option>
                                <option ${requestScope.obj.getStatus()==1?"selected":""} value="1">open</option>
                            </select>
                        </div>
                        <div class=" d-flex justify-content-between">
                            <p class="nav-item nav-link">Category</p>   
                            <select name="txtcate" style="width:300px; height: 30px; ">
                                <c:forEach var="c" items="${sessionScope.cList}" >  
                                    <option ${c.getId()==requestScope.obj.getCateID()?"selected":""} value="${c.getId()}">${c.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <button type="submit" onclick="return confirm('Save plant ? ');" name="action" value="saveUpdatePlant" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3" >Save</button>
                </div>

            </div>
        </div>
    </form>
    <!-- Shop Detail End -->
    <% }%>

    

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