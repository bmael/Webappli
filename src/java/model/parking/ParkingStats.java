/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.parking;

/**
 * This class represent a ParkingStats
 * @author Niiner
 */
public class ParkingStats { 
    
    private int id;
    private int idObj;
    private int availablePlaces;
    private int status;
    private String dateD;
    private String hourH;
    private String parkingName;

    /**
     * Construct a ParkingStats
     * @param id of the ParkingStats
     * @param idObj of the ParkingStats
     * @param availablePlaces of the ParkingStats
     * @param status of the ParkingStats (see getStatus method)
     * @param dateD is the date in which we get back our information 
     * @param hourH is the hour in which we get back our information 
     * @param parkingName 
     */
    public ParkingStats(int id, int idObj, int nbPlacesDispo, int status, String parkingName, String dateD, String hourH ){
        this.id = id;
        this.idObj = idObj;
        this.availablePlaces = nbPlacesDispo;
        this.status = status;
        this.dateD = dateD;
        this.hourH = hourH;
        this.parkingName = parkingName;               
    }

    /**
     * Return the id of the ParkingStats
     * @return id 
     */
    public int getId() {
        return id;
    }
    
    /**
     * Return the idOb of the ParkingStats
     * @return id 
     */
      public int getIdObj() {
        return idObj;
    }
    
    

    /**
     * Return the number of available places in the parking
     * @return availablePlaces 
     */
    public int getAvailablePlaces() {
        return availablePlaces;
    }

    /**
     * Return the status of the ParkingStats ->
     * 0 = Indicator Out Of Order
     * 1 = ParkingStats closed
     * 2 = ParkingStats open only for subscribers
     * 5 = Show the number of availables places or Complete ParkingStats 
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Return the date of the ParkingStats
     * @return dateD 
     */
    public String getDateD() {
        return dateD;
    }
    
    /**
     * Return the hour of the ParkingStats
     * @return hourH
     */
    public String getHourH() {
        return hourH;
    }
    
    /**
     * Return the name of the ParkingStats
     * @return parkingName
     */
    public String getParkingName() {
        return parkingName;
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
     * Set the date of the Itinerary
     * @param date 
     */
    public void setDateD(String dateD) {
        this.dateD = dateD;
    }
    
}

