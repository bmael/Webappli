/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.traffic;

/**
 *
 * @author niiner
 */
public class ItineraryStats {
    private int numero;
    private int time;
    private String dateD;
    private String hourH;
    
    
    public ItineraryStats(int numero, int time, String date, String hour){
        this.numero = numero;
        this.dateD = date;
        this.hourH = hour;
        this.time = time;  
    }
    
    public String getHour(){
        return hourH;
    }
    
    public String getDate(){
        return dateD;
    }
    
    public void setDate(String date){
        this.dateD = date;
    }
    
    public int getTime(){
        return time;
    }
    
    /* Return a date to format AAAA-MM-JJ */ 
    public String reverseDate(String date){
        String modifiedDate;
        modifiedDate = date.substring(6, date.length()) + date.substring(2, 6) + date.substring(0, 2);
        return modifiedDate;
    }
    
    public int getId(){
        return numero;
    }
}
