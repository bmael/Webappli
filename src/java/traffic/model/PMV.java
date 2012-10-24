/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.traffic;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a PMV
 * @author mael
 */
public class PMV {
    
    private int id;
    private String sens;
    private boolean indic_temps;
    private float longitude;
    private float latitude;
    private List<Itinerary> itineraries;
 
    /**
     * Construct a PMV.
     * @param id the id of the PMV
     * @param sens the direction of the PMV 'S' = going out of the city or 'E' = in the direction of the city
     * @param indic_temps true if the PMV is displaying a time for an itinerary, false otherwise
     * @param longitude longitude of the PMV
     * @param latitude  latitude of the PMV
     * @param itineraries List of the itineraries displayed by the PMV
     */
    public PMV(int id, String sens, boolean indic_temps, float longitude, float latitude, List<Itinerary> itineraries) {
        this.id = id;
        this.sens = sens;
        this.indic_temps = indic_temps;
        this.longitude = longitude;
        this.latitude = latitude;
        this.itineraries = new ArrayList<Itinerary>(itineraries);
    }
    
    /**************************************************************************/
    /****                           Getters & Setters                      ****/
    /**************************************************************************/
    /**
     * Return the identification number of the PMV.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Return the direction of the PMV : 'E'= In the direction of the city center
     *  'S' = Going out of the city.
     * @return sens 
     */
    public String getSens() {
        return sens;
    }

    /**
     * Return true if the PMV indicate the time, false otherwise.
     * @return indic_temps
     */
    public boolean isIndic_temps() {
        return indic_temps;
    }

    /**
     * Return the longitude of the PMV.
     * @return longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Return the latitude of the PMV.
     * @return latitude
     */
    public float getLatitude() {
        return latitude;
    }
    
    /**
     * Return the list of the itineraries displayed by the PMV.
     * @return itineraries  
     */
    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    /**
     * Set the identification number of the PMV.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set the Sense of the PMV 'E'= In the direction of the city center
     *  'S' = Going out of the city.
     * @param sens
     */
    public void setSens(String sens) {
        this.sens = sens;
    }

    /**
     * Set true if the PMV indicate the time, false otherwise.
     * @param indic_temps
     */
    public void setIndic_temps(boolean indic_temps) {
        this.indic_temps = indic_temps;
    }

    /**
     * Set the longitude of the PMV.
     * @param longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Set the latitude of the PMV.
     * @param latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Set the Itineraries displayed by the PMV.
     * @param itineraries 
     */
    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }
    
    
    /**
     * Return a String representation of a PMV
     * @return a String
     */
    @Override
    public String toString(){        
        String res = "Numéro : " + this.id;
        res += " | Sens : " + this.sens;
        res += " | Indique temps parcours : " + this.indic_temps;
        
        return res;    
    }
    
}
