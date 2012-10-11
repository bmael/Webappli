/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package periodic;


import controller.traffic.PMVController;
import controller.traffic.StatsPMVController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Timer;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimedObject;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import org.jdom2.JDOMException;

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
//   @Schedule(second="*/01", minute="*/15", hour="*")

  
  
}
