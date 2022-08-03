/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LapTop
 */
public class addToCartServlet extends HttpServlet {

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
            String itemid = request.getParameter("pid");
            HttpSession session = request.getSession(true);
            HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
            int num = -1;
            if(request.getParameter("txtnum")!=null&&!request.getParameter("txtnum").equals("")){
                num = Integer.parseInt(request.getParameter("txtnum"));
            }
            if(cart == null){
                cart = new HashMap<>();
                if(num == -1) cart.put(itemid, 1);
                else cart.put(itemid, num);
            }else{
                if(cart.containsKey(itemid)){
                    int quantity = cart.get(itemid);
                    if(num == -1) cart.put(itemid, ++quantity);
                    else cart.put(itemid, num + quantity);
                    
                }else{
                    if(num == -1) cart.put(itemid, 1);
                else cart.put(itemid, num);
                }
            }
            session.setAttribute("cart", cart);
            session.setAttribute("cartSize", cart.size());
            request.getRequestDispatcher("shop").forward(request, response);
        
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
