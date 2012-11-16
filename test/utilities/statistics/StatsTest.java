/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.statistics;

import java.text.ParseException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author mael
 */
public class StatsTest {
    
    public StatsTest() {
    }

    /**
     * Test of ItineraryStatsXYSeries method, of class Stats.
     */
    @Test
    public void testItineraryStatsXYSeries() throws Exception {
        System.out.println("ItineraryStatsXYSeries");
        int id = 0;
        String d1 = "";
        String d2 = "";
        Stats.ItineraryStatsXYSeries(id, d1, d2);
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Stats.
     */
    @Test
    public void testMain() throws ParseException {
        System.out.println("main");
        String[] args = null;
        Stats.main(args);
        fail("The test case is a prototype.");
    }
}
