/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.controller;

import database.DataBaseManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.parking.Parking;
import traffic.controller.PMVController;
import utilities.dataBaseTools.ParserCSV;

/**
 * Class to control Parkings on the database.
 * @author Niiner
 */
public class ParkingController {

    /**
     * Import all the Parking from the open data of nantes on the database
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SQLException
     */
    public void importParking() throws FileNotFoundException, IOException, SQLException {

            List<String[]> data = ParserCSV.extractData(System.getProperty("user.dir")+"/horaires_parkings_publics.csv");

            for (String[] oneData : data) {
                            
                String chaine[] = oneData[0].split(",");
                String id = chaine[0].replace("\"", "");              
               
                String day = chaine[5].replace("\"", "");
                String openingH = chaine[6].replace("\"", "");
                String endingH = chaine[7].replace("\"", "");                            

                Parking parking = new Parking((int)Float.parseFloat(id),
                                    day, openingH, endingH);
                                    
                this.add(parking);
            }
    }

    /**
     * Add the Parking to the database.
     * @param parking
     */
    public void add(Parking parking) throws SQLException{

            Statement s = DataBaseManager.getInstance().getCon().createStatement();
            String sqlquery = "INSERT INTO Parking (id,day,openingHours,closedHours)"
                                + "VALUES('"+ parking.getId() + "', "
                                +  "'" + parking.getDay() + "', "
                                +  "'" + parking.getOpeningHours() + "', "                               
                                +  "'" + parking.getClosedHours() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
    }

    public List<Parking> getAll() throws SQLException{
        List<Parking> parkings = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM Parking;";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                parkings.add(new Parking(res.getInt("id"),res.getString("day"),
                                    res.getString("openingHours"),
                                    res.getString("closedHours")));
            }

        return parkings;
    }
    
    /**
     * Return a Parking List matching the id entered as a parameter
     * @param id The id of the Parkings you want to retrieve
     * @return A Parking List matching the entered id
     * @throws SQLException 
     */
    public List<Parking> getParkingById(int id) throws SQLException {
        List<Parking> parkings = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM Parking "
                        + "WHERE id=" + id + ";";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                parkings.add(new Parking(res.getInt("id"),res.getString("day"),
                                    res.getString("openingHours"),
                                    res.getString("closedHours")));
            }

        return parkings;
    }

    public void removeAll() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM Parking;";
        s.executeUpdate(sqlquery);
    }
    
    public static void main(String args[]){

        System.out.print(System.getProperty("user.dir" ));
        ParkingController parkingContr = new ParkingController();
        try {
            parkingContr.removeAll();
        } catch (SQLException ex) {
            Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                parkingContr.importParking();
            } catch (SQLException ex) {
                Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(parkingContr.getAll().size());
        } catch (SQLException ex) {
            Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
