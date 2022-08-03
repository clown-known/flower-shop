/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LapTop
 */
public class mainController extends HttpServlet {

    String url = "errorpage.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action").trim();
            
            switch(action){
                case "homePage":
                    url = "home";
                    break;
                case "viewPlant":
                    url = "shop";
                    break;
                case "viewDetail":
                    url = "viewDetailServlet";
                    break;
                case "addToCart":
                    url = "addToCartServlet";
                    break;
                case "viewCart":
                    url = "cart.jsp";
                    break;
                case "loginPage":
                    url = "loginServlet";
                    break;
                case "login":
                    url = "loginServlet";
                    break;
                case "logout":
                    url = "logoutSerlvet";
                    break;
                case "registerPage":
                    url = "register.jsp";
                    break;
                case "sigin":
                    url = "registerServlet";
                    break;
                case "persionalOrderPage":
                    url = "viewPersionalOrderServlet";
                    break;
                case "searchOrder":
                    url = "searchOrderServlet";
                    break;
                case "moveCheckout":
                    url = "moveCheckoutSevlet";
                    break;
                case "checkout":
                    url = "checkoutServlet";
                    break;
                case "cancel":
                    url = "cancelOrderServlet";
                    break;
                case "viewOrder":
                    url = "viewOrderServlet";
                    break;
                case "viewAccount":
                    url = "viewAccountServlet";
                    break;
                case "saveCart":
                    url = "saveCartServlet";
                    break;
                case "plantManager":
                    url = "plantManagerServlet";
                    break;
                case "removePlant":
                    url = "removePlantServlet";
                    break;
                case "createPlant":
                    url = "createPlantServlet";
                    break;
                case "updatePlant":
                    url = "updatePlantServlet";
                    break;
                case "saveUpdatePlant":
                    url = "saveUpdatePlantServlet";
                    break;
                case "searchPlantByAdmin":
                    url = "searchPlantByAdminServlet";
                    break;
                default:
                    url = "home";
                    break;
//            }
            }
//            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
