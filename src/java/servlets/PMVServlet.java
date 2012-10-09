/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.traffic.PMVController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.traffic.PMV;

/**
 *
 * @author mael
 */
@WebServlet(name = "PMVServlet", urlPatterns = {"/PMVServlet"})
public class PMVServlet extends HttpServlet {

    @Inject
    private PMVController pmvContr;
    
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
                    
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PMVServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PMVServlet at " + request.getContextPath() + "</h1>");
            
            try {
                List<PMV> pmvs = pmvContr.getAll();
                String codeJs = new String();
                
                //out.println("Il y a " + pmvs.size() + " PMV dans notre base de données.<br/>");
                
                for (PMV pmv:pmvs) {
                    //out.println(pmv.toString()+"<br/>");
                    codeJs += "my_marker = new mxn.Marker(new mxn.LatLonPoint(" + pmv.getLatitude() + "," + pmv.getLongitude() + "));";
                    codeJs += "my_marker.setIcon('images/marker.png');";
                    codeJs += "mapstraction.addMarker(my_marker);";
                }
                request.setAttribute("codeJs", codeJs);
                request.getServletContext().getRequestDispatcher("/WEB-INF/map.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(PMVServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            out.println("</body>");
            out.println("</html>");
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
