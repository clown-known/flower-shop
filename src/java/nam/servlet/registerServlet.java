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
import javax.servlet.http.HttpSession;
import nam.dao.AccountDAO;
import nam.dto.Account;

/**
 *
 * @author LapTop
 */
public class registerServlet extends HttpServlet {

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
            String email = request.getParameter("txtemail");
            String name = request.getParameter("txtfirstName") + " " + request.getParameter("txtlastName");
            String password = request.getParameter("txtpass");
            String phone = request.getParameter("txtphone");
            int status = 1;
            int role = 0;
            boolean result = true;
            if(AccountDAO.getAccounts(email)!=null){
                request.setAttribute("txtemail",email);
                request.setAttribute("txtfirstName",request.getParameter("txtfirstName"));
                request.setAttribute("txtlastName",request.getParameter("txtlastName"));
                request.setAttribute("txtphone",phone);
                request.setAttribute("ERROR_email","This e-mail is already taken");
                result = false; 
            }
            if(!phone.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")){
                request.setAttribute("txtemail",email);
                request.setAttribute("txtfirstName",request.getParameter("txtfirstName"));
                request.setAttribute("txtlastName",request.getParameter("txtlastName"));
                request.setAttribute("txtphone",phone);
                request.setAttribute("ERROR_phone","This phone number is invalid.");
                result = false; 
            }
            if(result) {
                if (AccountDAO.insertAccount(email, password, name, phone, status, role)) {
                    Account acc = new Account(-1, email, password, name, phone, status, role);
                    HttpSession session = request.getSession(true);
                        if (session != null) {
                            session.setAttribute("name", acc.getFullName());
                            session.setAttribute("email", email);
                            session.setAttribute("user", acc);
                            request.getRequestDispatcher("home").include(request, response);
                        }
                } else {
                    request.getRequestDispatcher("register.jsp").include(request, response);
                }
            }else {
                    request.getRequestDispatcher("register.jsp").include(request, response);
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
