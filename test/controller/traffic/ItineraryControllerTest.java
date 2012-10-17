/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.traffic;

import java.util.List;
import model.traffic.Itinerary;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author mael
 */
public class ItineraryControllerTest {
    
    public ItineraryControllerTest() {
    }

    /**
     * Test of importItinerary method, of class ItineraryController.
     */
    @Test
    public void testImportItinerary() throws Exception {
        System.out.println("importItinerary");
        ItineraryController instance = new ItineraryController();
        instance.importItinerary();
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ItineraryController.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Itinerary it = null;
        ItineraryController instance = new ItineraryController();
        instance.add(it);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class ItineraryController.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        ItineraryController instance = new ItineraryController();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class ItineraryController.
     */
    @Test
    public void testRemoveAll() throws Exception {
        System.out.println("removeAll");
        ItineraryController instance = new ItineraryController();
        instance.removeAll();
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ItineraryController.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ItineraryController.main(args);
        fail("The test case is a prototype.");
    }
}
