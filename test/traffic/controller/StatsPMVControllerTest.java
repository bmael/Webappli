/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.traffic;

import java.util.List;
import model.traffic.ItineraryStats;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mael
 */
public class StatsPMVControllerTest {
    
    public StatsPMVControllerTest() {
    }

    /**
     * Test of importAPI method, of class StatsPMVController.
     */
    @Test
    public void testImportAPI() throws Exception {
        System.out.println("importAPI");
        StatsPMVController instance = new StatsPMVController();
        instance.importAPI();
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class StatsPMVController.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        ItineraryStats itineraryStats = null;
        StatsPMVController instance = new StatsPMVController();
        instance.add(itineraryStats);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class StatsPMVController.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        StatsPMVController instance = new StatsPMVController();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItinerariesStats method, of class StatsPMVController.
     */
    @Test
    public void testGetItinerariesStats() throws Exception {
        System.out.println("getItinerariesStats");
        int id = 0;
        String d1 = "";
        String d2 = "";
        StatsPMVController instance = new StatsPMVController();
        List expResult = null;
        List result = instance.getItinerariesStats(id, d1, d2);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class StatsPMVController.
     */
    @Test
    public void testRemoveAll() throws Exception {
        System.out.println("removeAll");
        StatsPMVController instance = new StatsPMVController();
        instance.removeAll();
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class StatsPMVController.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        StatsPMVController.main(args);
        fail("The test case is a prototype.");
    }
}
