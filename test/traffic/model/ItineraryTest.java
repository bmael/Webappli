/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.traffic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mael
 */
public class ItineraryTest {
    
    public ItineraryTest() {
    }

    /**
     * Test of getId method, of class Itinerary.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Itinerary instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class Itinerary.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Itinerary instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrigine method, of class Itinerary.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        Itinerary instance = null;
        String expResult = "";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestination method, of class Itinerary.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Itinerary instance = null;
        String expResult = "";
        String result = instance.getDestination();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Itinerary.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Itinerary instance = null;
        instance.setId(id);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class Itinerary.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        Itinerary instance = null;
        instance.setNumero(numero);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrigine method, of class Itinerary.
     */
    @Test
    public void testSetOrigine() {
        System.out.println("setOrigine");
        String origine = "";
        Itinerary instance = null;
        instance.setOrigine(origine);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestination method, of class Itinerary.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String destination = "";
        Itinerary instance = null;
        instance.setDestination(destination);
        fail("The test case is a prototype.");
    }
}
