/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
 *
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
    
    private DataBaseManager(){
         try {
            Class.forName("com.mysql.jdbc.Driver");  //loads the driver
            setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/WebappliDb", "root", "root"));
            
            //creates tables for the database
            createTablePMV();
            createTableParkingLocation();
            createTableParking();
            createTableItinerary();
            createTableLinkage();
            createTableStatsPMV();
            createTableStatsParking();
            
            createTableStatsPNG();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

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
    
        private void createTableParking(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS Parking"+
                            "(id INT,"
                            + "day VARCHAR(10),"
                            + "openingHours TIME,"
                            + "closedHours TIME);";
                           // + "PRIMARY KEY(id));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
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
    
        private void createTableStatsParking(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS StatsParking"+
                            "(id INT,"
                            + "idObj INT,"
                            + "availablePlaces INT,"
                            + "status INT,"
                            + "parkingName VARCHAR(50),"
                            + "dateD DATE,"
                            + "hourH TIME);";
                           // + "PRIMARY KEY(id));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
        
    private void createTableParkingLocation(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS ParkingLocalisation"+
                            "(id INT,"
                            + "longitude REAL,"
                            + "latitude REAL,"
                            + "PRIMARY KEY(id));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }      
    
    
    private void createTableStatsPMV(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS StatsPMV"+
                            "(id INT,"
                            + "time INT,"
                            + "dateD DATE,"
                            + "hourH TIME);";
                          //  + "PRIMARY KEY(id));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private void createTableStatsPNG(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS StatsPNG"+
                            "(id INT,"
                            + "d1 VARCHAR(50),"
                            + "d2 VARCHAR(50),"
                            + "image_stream blob NOT NULL);";
                          //  + "PRIMARY KEY(id));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    public Connection getCon() {
        return con;
    }
    
    public static synchronized DataBaseManager getInstance(){
        if(instance == null){
            instance = new DataBaseManager();
        }
        return instance;   
    }
    
    public static void main(String args[]){      
        DataBaseManager.getInstance();      
    }

}

