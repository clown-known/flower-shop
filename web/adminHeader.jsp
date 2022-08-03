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
            <div class="col-lg-9 col-6 text-left">
                <div class="container-fluid">
                    <div class="row px-xl-5">
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
                                        <a href="mainController?action=viewAccount" class="nav-item nav-link">Accounts </a>
                                        <a href="mainController?action=plantManager" class="nav-item nav-link ">Plants</a>
                                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                                    </div>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Topbar End -->
    
    <!-- Navbar Start -->
    
    <!-- Navbar End -->
    </body>
</html>
