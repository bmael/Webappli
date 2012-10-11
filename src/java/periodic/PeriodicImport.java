/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package periodic;


import java.text.DateFormat;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;

/**
 *
 * @author mael
 */
@Singleton
@Startup
@LocalBean
public class PeriodicImport {

  @Resource
  TimerService timerService;
  
  private DateFormat mediumDateFormat = 
    DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);


//   @Schedule(second="*", minute="*", hour="*/23")
//   public void importEveryDay(){
//       PMVController pmvContr = new PMVController();
//        try {
//            pmvContr.removeAll();
//            pmvContr.importPMV();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    Logger.getLogger(PeriodicImport.class.getName()).log(Level.INFO, 
//      "Execution du traitement" + mediumDateFormat.format(new Date()));
//   }
  

/* TODO : A schedule with an import of ItineraryStats every 15mn */
//     @Schedule(second="*/30", minute="*", hour="*")
//     public void importEveryDay() throws MalformedURLException, JDOMException{
//       StatsPMVController pmvContr = new StatsPMVController();
//        try {
//            pmvContr.removeAll();
//            pmvContr.importAPI();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    Logger.getLogger(PeriodicImport.class.getName()).log(Level.INFO, 
//      "Execution du traitement" + mediumDateFormat.format(new Date()));
//   }

  
  
}
