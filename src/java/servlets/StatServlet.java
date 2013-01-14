/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mael
 */
@WebServlet(name = "StatServlet", urlPatterns = {"/StatServlet"})
public class StatServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date d = simpledate.parse(request.getParameter("date"));
                        
                        if(request.getParameter("action").equals("prev")){
                            d.setTime(d.getTime() - 86400000); //decrease one day in milliseconds of the current date to have the day before.
                        }
                        if(request.getParameter("action").equals("next")){
                            d.setTime(d.getTime() + 86400000); //increase one day in millisecond of the current date to have the day after.
                        }
                        
                        request.setAttribute("itId",request.getParameter("itId"));
                        request.setAttribute("date", d);
                        request.getServletContext().getRequestDispatcher("/stat.jsp").forward(request, response);
                        
                    } catch (ParseException ex) {
                        Logger.getLogger(StatServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
