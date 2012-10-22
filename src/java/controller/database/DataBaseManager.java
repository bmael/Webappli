/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.database;

/**
 *
 * @author mael
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton to manage the connection with application database.
 * @author mael
 */
public class DataBaseManager {
    
    private static DataBaseManager instance; 
    private Connection con = null;

    /**
     * Set the Connection
     * @param con 
     */
    private void setCon(Connection con) {
        this.con = con;
    }
    
    /**
     * Initialize the connection to the database and constructs all the tables 
     * if they do not exist.
     */
    private DataBaseManager(){
         try {
            Class.forName("com.mysql.jdbc.Driver");  //loads the driver
            setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/WebappliDb", "root", "root"));
            
            //creates tables for the database
            createTablePMV();
            createTableItinerary();
            createTableLinkage();
            createTableStatsPMV();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create StatsPMV table if it do not exist. 
     */
    private void createTableStatsPMV(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS StatsPMV"+
                            "(id INT,"
                            + "time INT,"
                            + "dateD DATE,"
                            + "hourH TIME"
                            + ");";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
}
    
    /**
     * Create Pmv table if it do not exist. 
     */
    private void createTablePMV(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS Pmv"+
                            "(numero INT,"
                            + "sens VARCHAR(2),"
                            + "indic_temps_parcours INT,"
                            + "longitude REAL,"
                            + "latitude REAL,"
                            + "PRIMARY KEY(numero));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Create Itinerary table if it do not exist. 
     */
     private void createTableItinerary(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS Itinerary"+
                            "(id INT,"
                            + "numero INT,"
                            + "origine VARCHAR(100),"
                            + "destination VARCHAR(100),"
                            + "PRIMARY KEY(id));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
    /**
     * Create LinkagePMV table if it do not exist. 
     */
    private void createTableLinkage(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS LinkagePMV"+
                            "(idPMV INT,"
                            + "idAPI INT,"
                            + "PRIMARY KEY(idPMV));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Return the database connection
     * @return a Connection
     */
    public Connection getCon() {
        return con;
    }
    
    /**
     * Create an instance of DataBaseManager if it do not exist.
     * @return an instance of DataBaseManager
     */
    public static synchronized DataBaseManager getInstance(){
        if(instance == null){
            instance = new DataBaseManager();
        }
        return instance;   
    }
    
    /**
     * Test this class.
     * @param args 
     */
    public static void main(String args[]){      
        DataBaseManager.getInstance();
    }

}

