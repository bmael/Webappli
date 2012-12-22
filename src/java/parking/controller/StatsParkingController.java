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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.traffic.ItineraryStats;
import model.parking.ParkingStats;
import org.jdom2.JDOMException;
import utilities.dataBaseTools.ParserXML;

/**
 *
 * @author niiner
 */
public class StatsParkingController {
   /**
     * Import all the Parking from the open data of nantes on the database
     * @throws FileNotFoundException
     * @throws IOException
     * @throws MalformedURLException
     * @throws JDOMException
     * @throws SQLException
     */
    public void importParking() throws FileNotFoundException, IOException, SQLException, MalformedURLException, JDOMException {

            List<String[]> data = ParserXML.extractDataFromAPI("parking.xml",
                    "http://data.nantes.fr/api/getDisponibiliteParkingsPublics/1.0/39W9VSNCSASEOGV");

            for (String[] oneData : data) {                             
                
            String id = oneData[0];
            String nameParking = oneData[1];
            String availablePlaces = oneData[2];
            String status = oneData[3];
            String idObj = oneData[4];
            String date = oneData[5].substring(0,10);
            String hour = oneData[5].substring(11,(oneData[5].length()));
               
            ParkingStats parking = new ParkingStats(Integer.parseInt(id),Integer.parseInt(idObj), Integer.parseInt(availablePlaces), Integer.parseInt(status), nameParking, date, hour);
            parking.setDateD(parking.reverseDate(date));
                
            this.add(parking);               
          }
    }

    /**
     * Add the ParkingStats to the database.
     * @throws SQLException
     * @param ParkingStats
     */
    public void add(ParkingStats parkingStats) throws SQLException{
    
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
            String sqlquery = "INSERT INTO StatsParking (id, idObj, availablePlaces, status, parkingName, dateD, hourH)"
                                + "VALUES('"+ parkingStats.getId() + "', "
                                +  "'" + parkingStats.getIdObj() + "', "
                                +  "'" + parkingStats.getAvailablePlaces() + "', "
                                +  "'" + parkingStats.getStatus() + "', "
                                +  "'" + parkingStats.getParkingName() + "', "
                                +  "'" + parkingStats.getDateD() + "', "
                                +  "'" + parkingStats.getHourH() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
       
    }

    public List<ParkingStats> getAll() throws SQLException{
        
    List<ParkingStats> parking = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM StatsParking;";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                parking.add(new ParkingStats(res.getInt("id"),res.getInt("idObj"),res.getInt("availablePlaces"), 
                        res.getInt("status"), res.getString("parkingName"),res.getString("dateD"), 
                        res.getString("hourH")));
        }                          
    
        return parking;
 
    }

    /**
     * Return the last available places.
     * @param id The id of the parking
     * @return The last available places. If there is no matching result in our database, this method will return 0.
     * @throws SQLException
     */
    public int getLastAvailablePlaces(int id) throws SQLException {
        List<ParkingStats> liRes = new ArrayList();
        int availablePlaces = 0;
        
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        String date = formatDate.format(new Date());
        
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM StatsParking "
                        + "WHERE id='"
                        + id + "' "
                        + "AND dateD='" + date + "' "
                        + "ORDER BY dateD DESC, hourH DESC;";
        ResultSet res = s.executeQuery(sqlquery);
        
        if (res.next()){
                availablePlaces = res.getInt("availablePlaces");
        }
        System.out.println("id  : " + id + " Nombre de places dispos : " + availablePlaces);
        return availablePlaces;
    }
    
    /**
     * Delete ALL the itineraryStats in the database.
     * @throws SQLException
     */
    public void removeAll() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM StatsParking;";
        s.executeUpdate(sqlquery);
    }
    
    public static void main(String args[]) throws FileNotFoundException, MalformedURLException, MalformedURLException, JDOMException, JDOMException{

        System.out.print(System.getProperty("user.dir" ));
        StatsParkingController pmvContr = new StatsParkingController();
        try {
            pmvContr.removeAll();
        } catch (SQLException ex) {
            Logger.getLogger(StatsParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                pmvContr.importParking();
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
