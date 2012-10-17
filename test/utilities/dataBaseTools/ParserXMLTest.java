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
public class ParserXMLTest {
    
    public ParserXMLTest() {
    }

    /**
     * Test of extractDataFromAPI method, of class ParserXML.
     */
    @Test
    public void testExtractDataFromAPI() throws Exception {
        System.out.println("extractDataFromAPI");
        String url = "";
        List expResult = null;
        List result = ParserXML.extractDataFromAPI(url);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of extractData method, of class ParserXML.
     */
    @Test
    public void testExtractData() throws Exception {
        System.out.println("extractData");
        String file = "";
        List expResult = null;
        List result = ParserXML.extractData(file);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ParserXML.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        ParserXML.main(args);
        fail("The test case is a prototype.");
    }
}
