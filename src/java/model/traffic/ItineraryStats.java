/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.traffic;

/**
 * This class contains information for Itinerary Statistics
 * @author Niiner
 */
public class ItineraryStats {
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
    
    
}

