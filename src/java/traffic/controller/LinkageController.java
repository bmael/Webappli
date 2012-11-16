/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.controller;

import database.DataBaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.traffic.Itinerary;
import model.traffic.PMV;

/**
 * This class provides methods to link PMVs ids from API getTempsParcours and csv file.
 * @author mael
 */
public class LinkageController {
    
    /**
     * Links the PMV id's from API getTempsParcours and csv file and stores 
     * this link in LinkagePMV.
     * @throws SQLException 
     */
    public void importLinkage() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
            
        PMVController pmvContr = new PMVController();
        ItineraryController itContr = new ItineraryController();
        
        List<PMV> pmvs = pmvContr.getAll();
        List<Itinerary> its = itContr.getAll();
        
        for (PMV pmv : pmvs){
            //Link only PMV whose display something
            if(pmv.isIndic_temps()){
                String sqlquery = "INSERT INTO LinkagePMV (idPMV)"
                                + "VALUES('"+ pmv.getId() + "');";
                System.out.println(sqlquery);
                s.executeUpdate(sqlquery);
            }
        }
        
        for (Itinerary it : its){
            String sqlquery = "UPDATE LinkagePMV SET idAPI='"
                                + it.getNumero() + "' WHERE idPMV='11"+ String.format("%02d", it.getNumero()) +"';";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
        }
    }
    
    /**
     * Return the Itinerary id(in the API) corresponding to the PMV numero given as a parameter
     * @param idPMV
     * @return The id in the API corresponding to the PMV numero
     * @throws SQLException
     */
    public int getPmvToItineraryId(int idPMV) throws SQLException {
        int result = 0;
        
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT idAPI FROM LinkagePMV WHERE idPMV = " + idPMV + ";";
        ResultSet res = s.executeQuery(sqlquery);
        
        if ( res.next() ) {
            result = res.getInt("idAPI");
        }
        
        return result;
    }
    
    /**
     * Remove all the entries in LinkagePMV.
     * @throws SQLException 
     */
    public void removeAll() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM LinkagePMV;";
        s.executeUpdate(sqlquery);
    }
      
    /**
     * Test this class.
     * @param args 
     */
    public static void main(String args[]){
        LinkageController linkageContr = new LinkageController();
        try {
            linkageContr.removeAll();
            linkageContr.importLinkage();
        } catch (SQLException ex) {
            Logger.getLogger(LinkageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
