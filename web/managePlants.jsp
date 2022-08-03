<%@page import="nam.dto.Plant"%>
<%@page import="nam.dto.PlantDes"%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="o"%>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>

    <%@include file="adminHeader.jsp" %>
    
        <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-1">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 200px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Plant manager</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href=""> Admin role</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Plant manager</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->
    
    <div class="container">
    <!-- Trigger the modal with a button -->
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Create Plant</button>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <form action="mainController" method="post">
            <div class="modal-content">
                <div class="modal-body">
                    <div class=" form-group card-body">
                        <o:modal_create_plant/>
                        <div class=" d-flex justify-content-between">
                            <p class="nav-item nav-link">Category</p>
                            <select name="txtcate" style="width:300px; height: 30px; ">
                                <c:forEach var="c" items="${sessionScope.cList}" >   
                                    <option value="${c.getId()}">${c.getName()}</option>
                                </c:forEach>
                            </select>       
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" onclick="return confirm('Create plant ? ');" name="action" value="createPlant" class="btn" >Create</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>
    <!-- Cart Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <form action="mainController" method="post">
                                <div class="input-group">
                                    <input type="text" name="txtsearchName" value="${requestScope.txtsearchName}" class="form-control" placeholder="Search by name">
                                    <div class="input-group-append">
                                        <button name="action" value="searchPlantByAdmin" class="input-group-text bg-transparent text-primary">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                            <div class="dropdown ml-4">
                                <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                                        aria-expanded="false">
                                            Filter By
                                        </button>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                    <a onclick="filter('all')" class="dropdown-item" href="#">All</a>

                                    <c:forEach var="c" items="${sessionScope.cList}" >   
                                        <button onclick="filter('${c.getName()}')" class="dropdown-item" href="#">${c.getName()}</button>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
            <div class="col-lg-12 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>ID</th>
                            <th>Images</th>
                            <th>Product</th>
                            <th>Category </th>
                            <th>NO Orders</th>
                            <th>Processing</th>
                            <th>Completed</th>
                            <th>Canceled</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <%
                        if(request.getAttribute("pList")!=null){
                    %>
                    <tbody class="align-middle ">
                        <% 
                            ArrayList<PlantDes> pList =(ArrayList<PlantDes>) request.getAttribute("pList");
                            int i = 0;
                            String[] status = {"not yet","active"};
                            for (PlantDes p : pList) {
                                i++;    
                        %>
                        <tr style="height: 150px;" class="text-dark <%=i%2==0?"bg-secondary":""%>">
                            <td class="align-middle "><%=p.getId()%></td>
                            <td class="align-middle " style="width: 200px; "><img src="<%=p.getPath()%>" alt="" style="width: 160px;"></td>
                            <td class="text-left" style="width: 300px; ">
                                Name: <%=p.getName()%> <br>
                                Price: <%=p.getPrice()%> <br>
                                Desctiption: <%=p.getDes()%><br>
                                Status: <%=status[p.getStatus()]%>
                            </td>
                            <td class="align-middle cate-name"><%=p.getCateName()%></td>
                            <td class="align-middle "><%=p.getProcessing()+p.getCompleted()+p.getCanceled()%></td>
                            <td class="align-middle "><font color="blue"><%=p.getProcessing()%></font></td>
                            <td class="align-middle "><font color="green"><%=p.getCompleted()%></font></td>
                            <td class="align-middle "><font color="red"><%=p.getCanceled()%></font></td>
                            <td class="align-middle"><a onclick="return confirm('Delete Plant ID <%=p.getId()%>?');" class="btn btn-sm btn-primary" href="mainController?action=removePlant&pid=<%=p.getId()%>"><i class="fa fa-times"></i></a>
                                <a class="btn btn-sm btn-primary" href="mainController?action=updatePlant&pid=<%=p.getId()%>"><img style="height: 10px;width: 10px;" src="images/edit.png"></a></td>
                        </tr>
                        <% }%>
                    </tbody>
                    <% }%>
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
    <script src="js/filterCate.js"></script>
</body>

</html>