/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nam.dao.CateDAO;
import nam.dao.PlanDAO;
import nam.dto.Account;
import nam.dto.Category;
import nam.dto.PlantDes;

/**
 *
 * @author LapTop
 */
public class createPlantServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null && ((Account) session.getAttribute("user")).getRole() == 1) {
                String name = request.getParameter("txtname");
                int price = Integer.parseInt(request.getParameter("txtprice"));
                String path = "images/"+request.getParameter("txtimg");
                String des = request.getParameter("txtdescription");
                int status = Integer.parseInt(request.getParameter("txtstatus"));
                int cate = Integer.parseInt(request.getParameter("txtcate"));
                PlanDAO.insertPlant(name, price, path,des, status, cate);
                ArrayList<PlantDes> result = PlanDAO.getAllPlantsDes();
                ArrayList<Category> cList = CateDAO.getAllCategories();                
                session.setAttribute("cList", cList);
                request.setAttribute("pList", result);
                request.getRequestDispatcher("managePlants.jsp").forward(request, response);
            }
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
