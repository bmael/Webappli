/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.managedBean;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import org.jfree.chart.annotations.XYDataImageAnnotation;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author mael
 */
@ManagedBean(value = "itineraryStatBean")
@Dependent
public class ItineraryStatBean {
    @EJB
    private ItineraryStatBean itineraryStat;
    
   public int getId(){
       return itineraryStat.getId();
   }
   
   public String getD1(){
       return itineraryStat.getD1();
   }
   
   public String getD2(){
       return itineraryStat.getD2();
   }
   
   public void setId(int id){
       itineraryStat.setId(id);
   }
   
   public void setD1(String d1){
       itineraryStat.setD1(d1);
   }
   
   public void setD2(String d2){
       itineraryStat.setD2(d2);
   }
   
   public XYDataset retrieveDataSet(){
       return itineraryStat.retrieveDataSet();
   }
}
