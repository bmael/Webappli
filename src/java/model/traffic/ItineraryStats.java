/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.traffic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains information for Itinerary Statistics
 * @author Niiner
 */
public class ItineraryStats implements Comparable<ItineraryStats>{
    private int id;
    private int time;
    private String dateD;
    private String hourH;
    
    /**
     * Construct an ItineraryStats
     * @param numero of the itinerary
     * @param time is the time indicated for this itinerary
     * @param date is the date in which we get back our information (time)
     * @param hour is the hour in which we get back our information (time)
     */
    public ItineraryStats(int id, int time, String date, String hour){
        this.id = id;
        this.time = time;
        this.dateD = date;
        this.hourH = hour;         
    }
    
    /**
     * Return the id of the ItineraryStats
     * @return id
     */
    public int getId(){
        return id;
    }
    
    /**
     * Return the time indicated by the ItineraryStats
     * @return time 
     */
    public int getTime(){
        return time;
    }
    
    /**
     * Return the hour of the ItineraryStats
     * @return hourH 
     */
    public String getHour(){
        return hourH;
    }
    
    /**
     * Return the date of the ItineraryStats
     * @return dateD 
     */
    public String getDate(){
        return dateD;
    }
    
    /**
     * Set the hour of the Itinerary
     * @param date 
     */
    public void setDate(String date){
        this.dateD = date;
    }
       
    /**
     * Return a date to AAAA/MM/JJ format
     * @param date 
     * @precondition date is to JJ/MM/AAAA format
     * @return modifiedDate 
     */
    public String reverseDate(String date){
        String modifiedDate;
        modifiedDate = date.substring(6, date.length()) + date.substring(2, 6) + date.substring(0, 2);
        return modifiedDate;
    }
    
    /**
     * Return the String representation of an ItineraryStats.
     * @return the String representation of an ItineraryStats
     */
    @Override
    public String toString(){
        
        String res = "";
        
        res+= "----------------------------\n";
        res+= "id : " + id + "\n";
        res+= "time : " + time + "\n";
        res+= "dateD : " + dateD + "\n";
        res+= "hourH : " + hourH + "\n";
        
        return res;
    }
    
    /**
     * Method to compare two ItineraryStats.
     * @param o the other ItinerayStats
     * @return 1 if this is greater than o, 0 if both are equals and -1 if this is lesser than o
     */
    @Override
    public int compareTo(ItineraryStats o) {
        SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date d1 = simpledate.parse(dateD + " " + hourH);
            Date d2 = simpledate.parse(o.dateD + " " + o.hourH);
            return d1.compareTo(d2);

        } catch (ParseException ex) {
            Logger.getLogger(ItineraryStats.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }

    
  
    
}

