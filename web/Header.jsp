<%-- 
    Document   : Header
    Created on : Apr 12, 2022, 10:18:59 AM
    Author     : LapTop
--%>
<%@page import="nam.dao.CateDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nam.dto.Category"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row bg-secondary py-2 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark" href="">FAQs</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Help</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Support</a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <c:if test="${sessionScope.user==null}">
                    <a class="text-dark px-2" href="mainController?action=registerPage">
                        <img style="height: 25px;width: 25px;" src="images/icons8-registration-30.png"> Register 
                    </a>
                    <a class="text-dark px-2" href="mainController?action=loginPage">
                        Login <img style="height: 30px;width: 30px;" src="images/icons8-login-30.png">
                    </a>
                </c:if>
                <c:if test="${sessionScope.user!=null}">
                    <a class="text-dark px-2" href="">
                        Wellcome ${sessionScope.user.getFullName()}
                    </a>
                    <a class="text-dark px-2" href="mainController?action=logout">
                        Logout <img style="height: 30px;width: 30px;" src="images/icons8-sign-out-30.png">
                    </a>
                </c:if>
                </div>
            </div>
        </div>
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
                <form action="mainController" method="get">
                    <div class="input-group">
                        <input type="text" name="txtsearchName" value="${requestScope.txtsearchName}" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                            <button name="action" value="viewPlant" class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-3 col-6 text-right">
                <a href="" class="btn border">
                    <i class="fas fa-heart text-primary"></i>
                    <span class="badge">0</span>
                </a>
                <a href="mainController?action=viewCart" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge">${sessionScope.cartSize==null?0:sessionScope.cartSize}</span>
                </a>
            </div>
        </div>
    </div>
    <!-- Topbar End -->
    
    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        <%
                            ArrayList<Category> cList = CateDAO.getAllCategories();
                            if(cList!=null){
                                for (Category c : cList) {
                        %>
                        <a href="mainController?action=viewPlant&cid=<%=c.getId()%>" class="nav-item nav-link"><%=c.getName()%></a>
                        <% }}%>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="mainController?action=homePage" class="nav-item nav-link">Home</a>
                            <a href="mainController?action=viewPlant" class="nav-item nav-link ">Shop</a>
                            
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="mainController?action=viewCart" class="dropdown-item">Shopping Cart</a>
                                    <c:if test="${sessionScope.user!=null}">
                                        <a href="checkout.jsp" class="dropdown-item">Checkout</a>
                                        <a href="mainController?action=persionalOrderPage" class="dropdown-item">Ordered</a>        
                                    </c:if>
                                    
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                        </div>
                        
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->
    </body>
</html>
