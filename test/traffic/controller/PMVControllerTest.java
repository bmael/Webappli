/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.controller;

import java.util.List;
import model.traffic.PMV;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author mael
 */
public class PMVControllerTest {
    
    public PMVControllerTest() {
    }

    /**
     * Test of importPMV method, of class PMVController.
     */
    @Test
    public void testImportPMV() throws Exception {
        System.out.println("importPMV");
        PMVController instance = new PMVController();
        instance.importPMV();
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class PMVController.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        PMV pmv = null;
        PMVController instance = new PMVController();
        instance.add(pmv);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class PMVController.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        PMVController instance = new PMVController();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class PMVController.
     */
    @Test
    public void testRemoveAll() throws Exception {
        System.out.println("removeAll");
        PMVController instance = new PMVController();
        instance.removeAll();
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PMVController.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PMVController.main(args);
        fail("The test case is a prototype.");
    }
}
