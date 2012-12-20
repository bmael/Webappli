/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
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
import model.parking.ParkingLocalisation;
import parking.controller.ParkingController;
import parking.controller.ParkingLocalisationController;
import parking.controller.StatsParkingController;


/**
 *
 * @author niiner
 */
@WebServlet(name = "ParkingServlet", urlPatterns = {"/ParkingServlet"})
public class ParkingServlet extends HttpServlet {

    @Inject
    private ParkingController parkingContr;
            
    @Inject 
    private ParkingLocalisationController ParkingLocContr;
            
    @Inject
    private StatsParkingController StatsParkingContr;
            

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
            out.println("<title>Servlet ParkingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkingServlet at " + request.getContextPath() + "</h1>");
            
            try {
                String codeJsParking = new String();
                List<ParkingLocalisation> parkingsLoc = ParkingLocContr.getAll();
                
                for ( ParkingLocalisation parkingLoc : parkingsLoc ) {
                        System.out.println(parkingLoc.toString());
                        codeJsParking += "my_marker = new mxn.Marker(new mxn.LatLonPoint(" + parkingLoc.getLatitude() + "," + parkingLoc.getLongitude() + "));";
                        codeJsParking += "my_marker.setIcon('images/marker.png');";
//                        codeJsParking += "my_marker.setInfoDiv('";
                        
//                        for (Parking parking : parkings ) {
//                            codeJsParking += "<b>" + itinerary.getOrigine() + " > " + itinerary.getDestination() + "</b> : " + statsPmvContr.getLastItineraryTime(itinerary.getId()) + " minutes<br/>";
//                        }
                        
//                        codeJsParking += "','info');";
                        codeJsParking += "mapstraction.addMarker(my_marker);";
                    
                }
                
                request.setAttribute("codeJsParking", codeJsParking);
                request.getServletContext().getRequestDispatcher("/map.jsp").forward(request, response);
                
            }       catch (FileNotFoundException ex) {
                        Logger.getLogger(ParkingServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(ParkingServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                Logger.getLogger(ParkingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
