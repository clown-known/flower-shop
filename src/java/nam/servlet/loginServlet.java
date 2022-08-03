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
import javax.servlet.http.Cookie;
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
public class loginServlet extends HttpServlet {

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
            String pass = request.getParameter("txtpass");
            String save = request.getParameter("savelogin");

            Account acc = null;
            try {
                if(email==null||email.equals("")||pass==null||pass.equals("")){
                    Cookie[] c = request.getCookies();
                    String token = "";
                    if(c!=null){
                        for (Cookie cookie : c) {
                            if(cookie.getName().equals("selector")){
                                token = cookie.getValue();
                            }
                        }
                    }
                    if(token!=""){
                        acc = AccountDAO.getAccountByToken(token);
                        request.setAttribute("txtemail", acc.getEmail());
                        request.setAttribute("txtpass", acc.getPassword());
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }else{
                        response.sendRedirect("login.jsp");
                    }
                }
                acc = AccountDAO.getAccounts(email, pass);

                if (acc != null) {        
                    if(acc.getStatus()==0){
                        request.setAttribute("WARRING", "Your account has been locked by admin");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }else{
                    
                    if (acc.getRole() == 1) {
                        HttpSession session = request.getSession(true);
                        if (session != null){ 
                            session.setAttribute("user", acc);
                            ArrayList<Account> aList = AccountDAO.getAccounts();
                            request.setAttribute("aList",aList);
                            request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                        }
                    } else {
                        HttpSession session = request.getSession(true);
                        if (session != null) {
                            session.setAttribute("name", acc.getFullName());
                            session.setAttribute("email", email);
                            session.setAttribute("user", acc);
                            
                            if(save!=null){
                                Cookie[] cookieList = request.getCookies();
                                String token = cookieList[cookieList.length-1].getValue();
                                AccountDAO.updateToken(token, email);
                                Cookie cookie = new Cookie("selector", token);
                                cookie.setMaxAge(60*10);
                                response.addCookie(cookie);
                            }
                            request.getRequestDispatcher("home").forward(request, response);
                        } else {
                            request.getRequestDispatcher("home").forward(request, response);
                        }
                    }
                };
                } else {
                    
                    request.setAttribute("ERROR"," Wrong password or email!");
                    request.setAttribute("txtemail",email);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
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
