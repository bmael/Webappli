/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.database.DataBaseManager;
import controller.traffic.ItineraryController;
import controller.traffic.PMVController;
import controller.traffic.StatsPMVController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mael
 */
@WebServlet(name = "PMVServlet", urlPatterns = {"/PMVServlet"})
public class PMVServlet extends HttpServlet {

    @Inject
    private PMVController pmvContr;
    
    @Inject
    private ItineraryController itineraryContr;
    
    @Inject
    private StatsPMVController statsPmvContr;
    
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
                String codeJs = new String();
                
                // Query to get all the informations needed for the markers
                // Note that the clause WHERE is not necessary
                Statement s = DataBaseManager.getInstance().getCon().createStatement();
                String sqlquery = "SELECT p.indic_temps_parcours, i.numero, i.origine, i.destination, s.time, p.latitude, p.longitude "
                                + "FROM Pmv p "
                                + "JOIN LinkagePMV l ON ( p.numero = l.idPMV ) "
                                + "JOIN Itinerary i ON ( l.idAPI = i.numero ) "
                                + "JOIN StatsPMV s ON ( i.id = s.id ) "
                                + "WHERE p.indic_temps_parcours = 1;";
                ResultSet res = s.executeQuery(sqlquery);
                
                // Generating javascript code using the mapstraction API
                int id;
                while ( res.next() ) {
                    id = res.getInt("i.numero");
                    codeJs += "my_marker = new mxn.Marker(new mxn.LatLonPoint(" + res.getDouble("p.latitude") + "," + res.getDouble("p.longitude") + "));";
                    codeJs += "my_marker.setIcon('images/marker.png');";
                    codeJs += "my_marker.setInfoDiv('<h2>" + res.getString("i.origine") + "</h2>";
                    
                    // Display every PMV destinations
                    do {
                         codeJs += "<b>" + res.getString("i.destination") + "</b> --> " + res.getString("s.time") + " minutes</br>";
                    } while ( res.next() && res.getInt("i.numero") == id );
                    codeJs += "','info');";
                    codeJs += "mapstraction.addMarker(my_marker);";
                    
                    res.previous();
                }
                
                request.setAttribute("codeJs", codeJs);
                request.getServletContext().getRequestDispatcher("/map.jsp").forward(request, response);
                
            }       catch (FileNotFoundException ex) {
                        Logger.getLogger(PMVServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(PMVServlet.class.getName()).log(Level.SEVERE, null, ex);
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
