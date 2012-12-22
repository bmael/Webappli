/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.parking;

/**
 * This class represent a ParkingLocalisation
 * @author Niiner
 */
public class ParkingLocalisation { 
    
    private int id;
    private float longitude;
    private float latitude;

    /**
     * Construct a ParkingLocalisation
     * @param id of the Parking
     * @param longitude of the Parking
     * @param latitude of the Parking
     */
    public ParkingLocalisation(int id, float longitude, float latitude){
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }
   
    public String toString() {
        return "id: " + this.id + "| longitude: " + this.longitude + ", latitude: " + this.latitude;
    }
}