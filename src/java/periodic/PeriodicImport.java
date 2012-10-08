/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package periodic;


import controller.traffic.PMVController;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimedObject;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 *
 * @author mael
 */
@Singleton
@Startup
@LocalBean
public class PeriodicImport implements TimedObject {

  @Resource
  TimerService timerService;
  private DateFormat mediumDateFormat = 
    DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

  @PostConstruct
  public void creerTimer() {
    Logger.getLogger(PeriodicImport.class.getName()).log(Level.INFO, 
      "Creation du Timer" + mediumDateFormat.format(new Date()));
    GregorianCalendar calend = 
      new GregorianCalendar(2012, GregorianCalendar.OCTOBER, 8, 23, 12, 0);
    Timer timer = timerService.createSingleActionTimer(calend.getTime(), new TimerConfig());
  }

    @Override
  public void ejbTimeout(Timer timer) {
        PMVController pmvContr = new PMVController();
        try {
            pmvContr.removeAll();
            pmvContr.importPMV();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    Logger.getLogger(PeriodicImport.class.getName()).log(Level.INFO, 
      "Execution du traitement" + mediumDateFormat.format(new Date()));
  }
}
