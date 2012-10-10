/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.dataBaseTools;

import controller.traffic.ItineraryController;
import controller.traffic.PMVController;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.traffic.Itinerary;
import model.traffic.PMV;

/**
 *
 * @author mael
 */
public class LinkagePMV {
    
    public static void ImportLinkage() throws SQLException{
        PMVController pmvContr = new PMVController();
        ItineraryController itContr = new ItineraryController();
        
        List<PMV> pmvs = pmvContr.getAll();
        List<Itinerary> its = itContr.getAll();
        
        Map<Integer, Integer> ids = new HashMap();
        
        
        for (Itinerary it : its){
            
            for (PMV pmv : pmvs){
            ids.put(pmv.getId(), it.getNumero());
        
            }
        }
        
        
        
    }
    
}
