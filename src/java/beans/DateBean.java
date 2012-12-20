/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author mael
 */
@Named (value = "dateBean")
@RequestScoped
public class DateBean implements Serializable{

 
    private Date currentDate;
    private Date today;
    
    /**
     * Default Constructor
     */
    public DateBean() {
        today = new Date();
    }

    
    public Date getCurrentDate() {
        return currentDate;
    }


    public void setCurrentDate(Date date) {
        this.currentDate = date;
    }

    public void setToday(){
        today = new Date();
    }
    
    public Date getToday(){
        System.out.println("Returning the Date");
        return today;
    }
    
    @PostConstruct
    public void myInitMethod(){
        System.out.println("Init today");
        today = new Date();
    }
}
