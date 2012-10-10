/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.traffic;

import controller.database.DataBaseManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.traffic.Itinerary;
import model.traffic.PMV;

/**
 *
 * @author mael
 */
public class LinkageController {
    
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
    
    public void removeAll() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM LinkagePMV;";
        s.executeUpdate(sqlquery);
    }
      
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
