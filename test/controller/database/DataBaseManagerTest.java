/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.database;

import com.sun.tools.xjc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author mael
 */
public class DataBaseManagerTest {
    
    public DataBaseManagerTest() {
    }

    /**
     * Test of getCon method, of class DataBaseManager.
     */
    @Test
    public void testGetCon() throws SQLException {
        System.out.println("getCon");
        assertTrue(DataBaseManager.getInstance().getCon() != null);
    }

    /**
     * Test of getInstance method, of class DataBaseManager.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        assertTrue(DataBaseManager.getInstance() != null);
    }

}
