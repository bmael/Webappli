/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.dataBaseTools;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mael
 */
public class ParserTest {
    
    public ParserTest() {
    }

    /**
     * Test of extractDataFromZip method, of class Parser.
     */
    @Test
    public void testExtractDataFromZip() throws Exception {
        System.out.println("extractDataFromZip");
        String url = "";
        List expResult = null;
        List result = Parser.extractDataFromZip(url);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of extractData method, of class Parser.
     */
    @Test
    public void testExtractData() throws Exception {
        System.out.println("extractData");
        String file = "";
        List expResult = null;
        List result = Parser.extractData(file);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Parser.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Parser.main(args);
        fail("The test case is a prototype.");
    }
}
