/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parking;

import controller.database.DataBaseManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.parking.Parking;
import model.parking.ParkingLocalisation;
import model.traffic.Itinerary;
import model.traffic.PMV;

/**
 *
 * @author Niiner
 */
public class LinkageParkingController {
    
    public void importLinkage() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
            
        ParkingController parkingContr = new ParkingController();
        ParkingLocalisationController ParkingLocContr = new ParkingLocalisationController();
        
        List<Parking> parkings = parkingContr.getAll();
        List<ParkingLocalisation> parkingsLoc = ParkingLocContr.getAll();
        
        /* TODO : sqlQuery + creation of databases */
        
    }
    
    public void removeAll() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM LinkagePMV;";
        s.executeUpdate(sqlquery);
    }
      
    public static void main(String args[]){
        LinkageParkingController linkageContr = new LinkageParkingController();
        try {
            linkageContr.removeAll();
            linkageContr.importLinkage();
        } catch (SQLException ex) {
            Logger.getLogger(LinkageParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
