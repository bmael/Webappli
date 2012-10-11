/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.traffic;

import controller.database.DataBaseManager;
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
import model.traffic.Itinerary;
import model.traffic.ItineraryStats;
import model.traffic.PMV;
import org.jdom2.JDOMException;
import utilities.dataBaseTools.LinkagePMV;
import utilities.dataBaseTools.ParserCSV;
import utilities.dataBaseTools.ParserXML;
//import utilities.fileTools.ItineraryBD;

/**
 *
 * @author niiner
 */
public class StatsPMVController {
   /**
     * Import all the Itinarery information (for stats) from the open data of nantes on the database
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SQLException
     */
    public void importAPI() throws FileNotFoundException, IOException, SQLException, MalformedURLException, JDOMException {

            List<String[]> data = ParserXML.extractDataFromAPI(
                    "http://data.nantes.fr/api/getTempsParcours/1.0/4XTL4M0FTTASDFQ");

            for (String[] oneData : data) {                             
                
                String id = oneData[0];
                String time = oneData[1];
                String date = oneData[2].substring(0,10);
                String hour = oneData[2].substring(11,(oneData[2].length()));
               
              
                ItineraryStats it = new ItineraryStats(Integer.parseInt(id), Integer.parseInt(time), date, hour);
                it.setDate(it.reverseDate(date));
                
                System.out.println(it.getDate());
                this.add(it);               
          }
    }

    
    public void add(ItineraryStats itineraryBD) throws SQLException{
    
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
            String sqlquery = "INSERT INTO StatsPMV (id, time, dateD, hourH)"
                                + "VALUES('"+ itineraryBD.getId() + "', "
                                +  "'" + itineraryBD.getTime() + "', "
                                +  "'" + itineraryBD.getDate() + "', "
                                +  "'" + itineraryBD.getHour() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
       
    }

    public List<ItineraryStats> getAll() throws SQLException{
        
    List<ItineraryStats> itineraries = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM StatsPMV;";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                itineraries.add(new ItineraryStats(res.getInt("id"),res.getInt("time"), res.getString("dateD"), res.getString("hourH")));
        }                          
    

        return itineraries;
 
    }

    public void removeAll() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM StatsPMV;";
        s.executeUpdate(sqlquery);
    }
    
    public static void main(String args[]) throws FileNotFoundException, MalformedURLException, MalformedURLException, JDOMException, JDOMException{

        System.out.print(System.getProperty("user.dir" ));
        StatsPMVController pmvContr = new StatsPMVController();
        try {
            pmvContr.removeAll();
        } catch (SQLException ex) {
            Logger.getLogger(StatsPMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                pmvContr.importAPI();
            } catch (SQLException ex) {
                Logger.getLogger(StatsPMVController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(StatsPMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(pmvContr.getAll().size());
        } catch (SQLException ex) {
            Logger.getLogger(StatsPMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




}
