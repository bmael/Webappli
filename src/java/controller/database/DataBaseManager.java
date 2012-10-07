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
 *
 * @author mael
 */
public class DataBaseManager {
    
    private static DataBaseManager instance; 
    private Connection con = null;
    
    private DataBaseManager(){
         try {
            Class.forName("com.mysql.jdbc.Driver");  //loads the driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebappliDb", "root", "root");
            
            //creates tables for the database
            createTablePMV();
            
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
    
    public void clean(String table_Name){
         String sqlquery = "DELETE FROM "+ table_Name;
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
        
        //here import the csv file to load it on the database 
          
        DataBaseManager.getInstance();
        
        
        
    }

}

