/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.model;

/**
 * This class represent an Itinerary displayed by a PMV
 * @author mael
 */
public class Itinerary {
    private int id;
    private int numero;
    private String origine;
    private String destination;
    
    /**
     * Construct an Itinerary
     * @param id of the itinerary
     * @param num of the PMV whose display it
     * @param orig is the adresse of the PMV (the origin of the itinerary)
     * @param dest is the destination of the itinerary
     */
    public Itinerary(int id, int num, String orig, String dest){
        this.id = id;
        this.numero = num;
        this.origine = orig;
        this.destination = dest;
    }

    /**
     * Return the id of the Itinerary
     * @return id 
     */
    public int getId() {
        return id;
    }

    /**
     * Return the id of the PMV whose display the Itinerary
     * @return numero 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Return the origin of the Itinerary
     * @return origine 
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * Return the destination of the Itinerary
     * @return destination 
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Set the id of the Itinerary
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set the id of the PMV whose display the Itinerary
     * @param numero 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Set the origin of the Itinerary
     * @param origine 
     */
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    /**
     * Set the destination of the Itinerary
     * @param destination 
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    
    
    
}
