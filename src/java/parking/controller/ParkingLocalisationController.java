/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.controller;

import database.DataBaseManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.parking.ParkingLocalisation;
import org.jdom2.JDOMException;
import utilities.dataBaseTools.ParserCSV;

/**
 *
 * @author niiner
 */
public class ParkingLocalisationController {
   /**
     * Import all the Parking from the open data of nantes on the database
     * @throws FileNotFoundException
     * @throws IOException
     * @throws MalformedURLException
     * @throws JDOMException
     * @throws SQLException
     */
    public void importParkingLocalisation() throws FileNotFoundException, IOException, SQLException, MalformedURLException, JDOMException {

            List<String[]> data = ParserCSV.extractData(System.getProperty("user.dir")+"/services_parkings_publics.csv");

            for (String[] oneData : data) {      
                
            String chaine[] = oneData[0].split(",");
            String id = chaine[0].replace("\"", "");
            String longitude = chaine[10].replace("\"", "");
            String latitude = chaine[11].replace("\"", "");

               
            ParkingLocalisation parkingLoc = new ParkingLocalisation(Integer.parseInt(id),Float.parseFloat(longitude), Float.parseFloat(latitude));
                
            this.add(parkingLoc);               
          }
    }

    /**
     * Add the ParkingStats to the database.
     * @throws SQLException
     * @param ParkingStats
     */
    public void add(ParkingLocalisation parkingLoc) throws SQLException{
    
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
            String sqlquery = "INSERT INTO ParkingLocalisation (id, longitude, latitude)"
                                + "VALUES('"+ parkingLoc.getId() + "', "
                                +  "'" + parkingLoc.getLongitude() + "', "
                                +  "'" + parkingLoc.getLatitude() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
       
    }

    public List<ParkingLocalisation> getAll() throws SQLException{
        
    List<ParkingLocalisation> parkingLoc = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM ParkingLocalisation;";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                parkingLoc.add(new ParkingLocalisation(res.getInt("id"),res.getFloat("longitude"),res.getFloat("latitude")));
        }                          
    
        return parkingLoc;
 
    }

    /**
     * Delete ALL the itineraryStats in the database.
     * @throws SQLException
     */
    public void removeAll() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM ParkingLocalisation;";
        s.executeUpdate(sqlquery);
    }
    
    public static void main(String args[]) throws FileNotFoundException, MalformedURLException, MalformedURLException, JDOMException, JDOMException{

        System.out.print(System.getProperty("user.dir" ));
        ParkingLocalisationController pmvContr = new ParkingLocalisationController();
        try {
            pmvContr.removeAll();
        } catch (SQLException ex) {
            Logger.getLogger(StatsParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                pmvContr.importParkingLocalisation();
            } catch (SQLException ex) {
                Logger.getLogger(StatsParkingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(StatsParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(pmvContr.getAll().size());
        } catch (SQLException ex) {
            Logger.getLogger(StatsParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




}
