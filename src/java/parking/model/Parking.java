/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.parking;

/**
 * This class represent a Parking
 * @author Niiner
 */
public class Parking { 
    
    private int id;
    private String day;
    private String openingHours;
    private String closedHours;

    /**
     * Construct a Parking
     * @param id of the Parking
     * @param day 
     * @param openingHours 
     * @param closedHours
     */
    public Parking(int id, String day, String openingHours, String closedHours){
        this.id = id;
        this.day = day;
        this.openingHours = openingHours;
        this.closedHours = closedHours;
    }
  
      
    /**
     * Return the identification number of the Parking
     * @return id
     */ 
    public int getId() {
        return id;
    }

    /**
     * Return the day of the Parking
     * @return id
     */ 
    public String getDay() {
        return day;
    }

    /**
     * Return the opening hours of the Parking
     * @return id
     */     
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * Return the closed hours of the Parking
     * @return id
     */ 
    public String getClosedHours() {
        return closedHours;
    }

    
}

