/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.traffic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mael
 */
public class LinkageControllerTest {
    
    public LinkageControllerTest() {
    }

    /**
     * Test of importLinkage method, of class LinkageController.
     */
    @Test
    public void testImportLinkage() throws Exception {
        System.out.println("importLinkage");
        LinkageController instance = new LinkageController();
        instance.importLinkage();
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class LinkageController.
     */
    @Test
    public void testRemoveAll() throws Exception {
        System.out.println("removeAll");
        LinkageController instance = new LinkageController();
        instance.removeAll();
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class LinkageController.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LinkageController.main(args);
        fail("The test case is a prototype.");
    }
}
