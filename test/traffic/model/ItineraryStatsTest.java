/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author mael
 */
public class ItineraryStatsTest {
    
    public ItineraryStatsTest() {
    }

    /**
     * Test of getId method, of class ItineraryStats.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ItineraryStats instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class ItineraryStats.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        ItineraryStats instance = null;
        int expResult = 0;
        int result = instance.getTime();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHour method, of class ItineraryStats.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        ItineraryStats instance = null;
        String expResult = "";
        String result = instance.getHour();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class ItineraryStats.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        ItineraryStats instance = null;
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class ItineraryStats.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        ItineraryStats instance = null;
        instance.setDate(date);
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverseDate method, of class ItineraryStats.
     */
    @Test
    public void testReverseDate() {
        System.out.println("reverseDate");
        String date = "";
        ItineraryStats instance = null;
        String expResult = "";
        String result = instance.reverseDate(date);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ItineraryStats.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ItineraryStats instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class ItineraryStats.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ItineraryStats o = null;
        ItineraryStats instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
