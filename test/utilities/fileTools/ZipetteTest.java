/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.fileTools;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mael
 */
public class ZipetteTest {
    
    public ZipetteTest() {
    }

    /**
     * Test of getFiles method, of class Zipette.
     */
    @Test
    public void testGetFiles() {
        System.out.println("getFiles");
        String archive = "";
        ArrayList expResult = null;
        ArrayList result = Zipette.getFiles(archive);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of extractTo method, of class Zipette.
     */
    @Test
    public void testExtractTo() throws Exception {
        System.out.println("extractTo");
        String archive = "";
        String file = "";
        String destPath = "";
        Zipette.extractTo(archive, file, destPath);
        fail("The test case is a prototype.");
    }
}
