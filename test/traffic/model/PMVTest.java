/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mael
 */
public class PMVTest {
    
    public PMVTest() {
    }

    /**
     * Test of getId method, of class PMV.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PMV instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSens method, of class PMV.
     */
    @Test
    public void testGetSens() {
        System.out.println("getSens");
        PMV instance = null;
        String expResult = "";
        String result = instance.getSens();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIndic_temps method, of class PMV.
     */
    @Test
    public void testIsIndic_temps() {
        System.out.println("isIndic_temps");
        PMV instance = null;
        boolean expResult = false;
        boolean result = instance.isIndic_temps();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLongitude method, of class PMV.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        PMV instance = null;
        float expResult = 0.0F;
        float result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLatitude method, of class PMV.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        PMV instance = null;
        float expResult = 0.0F;
        float result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItineraries method, of class PMV.
     */
    @Test
    public void testGetItineraries() {
        System.out.println("getItineraries");
        PMV instance = null;
        List expResult = null;
        List result = instance.getItineraries();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class PMV.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        PMV instance = null;
        instance.setId(id);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSens method, of class PMV.
     */
    @Test
    public void testSetSens() {
        System.out.println("setSens");
        String sens = "";
        PMV instance = null;
        instance.setSens(sens);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndic_temps method, of class PMV.
     */
    @Test
    public void testSetIndic_temps() {
        System.out.println("setIndic_temps");
        boolean indic_temps = false;
        PMV instance = null;
        instance.setIndic_temps(indic_temps);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLongitude method, of class PMV.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        float longitude = 0.0F;
        PMV instance = null;
        instance.setLongitude(longitude);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLatitude method, of class PMV.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        float latitude = 0.0F;
        PMV instance = null;
        instance.setLatitude(latitude);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItineraries method, of class PMV.
     */
    @Test
    public void testSetItineraries() {
        System.out.println("setItineraries");
        List<Itinerary> itineraries = null;
        PMV instance = null;
        instance.setItineraries(itineraries);
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PMV.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PMV instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
