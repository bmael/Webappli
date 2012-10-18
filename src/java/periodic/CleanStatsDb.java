/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package periodic;


import controller.traffic.StatsPMVController;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.TimerService;
import model.traffic.ItineraryStats;

/**
 * This class Provides method automatically called for delete doubles in StatsPMV 
 * @author mael
 */
public class CleanStatsDb {

  @Resource
  TimerService timerService;
  
  private DateFormat mediumDateFormat = 
    DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);


  /**
   * Delete the doubles in StatsPMV table. This is necessary because the API getTempsParcours
   * is not update at constant time. So sometimes, we store data and they already are in the table.
   * Actually we don't use it on the application just in this class.
   */
   public static void clean() throws SQLException{
       
    StatsPMVController statsContr = new StatsPMVController();
    List<ItineraryStats> its = statsContr.getAll();
    
    Set<ItineraryStats> setIts = new TreeSet();
    setIts.addAll(its);
    
    statsContr.removeAll();
    statsContr.importSet(setIts);
      
   }
   
   /**
    * Test this class
    * @param args 
    */
   public static void main(String args[]){
        try {
            CleanStatsDb.clean();
        } catch (SQLException ex) {
            Logger.getLogger(CleanStatsDb.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

}
