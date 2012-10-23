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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.traffic.ItineraryStats;
import org.jdom2.JDOMException;
import utilities.dataBaseTools.ParserXML;

/**
 * Class to conrol statistics information about itineraries in the application database.
 * @author Niiner, mael
 */
public class StatsPMVController {
   /**
     * Import all the Itinarery information (for stats) from the open data of nantes on the database
     * @throws FileNotFoundException
     * @throws IOException
     * @throws MalformedURLException
     * @throws JDOMException
     * @throws SQLException
     */
    public void importAPI() throws FileNotFoundException, IOException, SQLException,
            MalformedURLException, JDOMException {

            List<String[]> data = ParserXML.extractDataFromAPI("itinerary.xml",
                    "http://data.nantes.fr/api/getTempsParcours/1.0/4XTL4M0FTTASDFQ");

            for (String[] oneData : data) {                             
                
                String id = oneData[0];
                String time = oneData[1];
                String date = oneData[2].substring(0,10);
                String hour = oneData[2].substring(11,(oneData[2].length()));
                           
                ItineraryStats it = new ItineraryStats(Integer.parseInt(id), Integer.parseInt(time), date, hour);
                it.setDate(it.reverseDate(date));
                
                this.add(it);               
          }
    }
    
      /**
     * Import all the Itinarery information (for stats) from the open data of nantes on the database
     * @throws FileNotFoundException
     * @throws IOException
     * @throws MalformedURLException
     * @throws JDOMException
     * @throws SQLException
     */
    public void importSet(Set<ItineraryStats> setIts) throws SQLException{
        for(ItineraryStats it : setIts){
            add(it);
        }
            
    }

    /**
     * Add the itineraryStats to the database.
     * @throws SQLException
     * @param itineraryStats
     */
    public void add(ItineraryStats itineraryStats) throws SQLException{
    
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
            String sqlquery = "INSERT INTO StatsPMV (id, time, dateD, hourH)"
                                + "VALUES('"+ itineraryStats.getId() + "', "
                                +  "'" + itineraryStats.getTime() + "', "
                                +  "'" + itineraryStats.getDate() + "', "
                                +  "'" + itineraryStats.getHour() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
       
    }

    /**
     * Return all the ItineraryStats from our database.
     * @return a List of ItineraryStats
     * @throws SQLException 
     */
    public List<ItineraryStats> getAll() throws SQLException{
        
    List<ItineraryStats> itineraries = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM StatsPMV;";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                itineraries.add(new ItineraryStats(res.getInt("id"),res.getInt("time"),
                                res.getString("dateD"), res.getString("hourH")));
        }                          
    

        return itineraries;
 
    }
    
    /**
     * Return all ItineraryStats from our databse between the two Dates given on parameter
     * whose have the given id 
     * @return a List of ItineraryStats
     * @throws SQLException 
     */
    public List<ItineraryStats>getItinerariesStats(int id, String d1, String d2) throws SQLException{
        
        List <ItineraryStats> liRes = new ArrayList();
        
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM StatsPMV "
                        + "WHERE id='"
                        + id + "' "
                        + "AND dateD>='" + d1 + "' "
                        + "AND dateD<='" + d2 + "';";
        ResultSet res = s.executeQuery(sqlquery);
        
        while(res.next()){
                liRes.add(new ItineraryStats(res.getInt("id"),res.getInt("time"),
                                res.getString("dateD"), res.getString("hourH")));
        }
        
        return liRes;
        
    }
    
    /**
     * Return the last Itinerary time.
     * @param id The id of the itinerary
     * @return The last itinerary time. If there is no matching result in our database, this method will return 0.
     * @throws SQLException
     */
    public int getLastItineraryTime(int id) throws SQLException {
        List<ItineraryStats> liRes = new ArrayList();
        int time = 0;
        
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        String date = formatDate.format(new Date());
        
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM StatsPMV "
                        + "WHERE id='"
                        + id + "' "
                        + "AND dateD='" + date + "' "
                        + "ORDER BY dateD DESC, hourH DESC;";
        ResultSet res = s.executeQuery(sqlquery);
        
        if (res.next()){
                time = res.getInt("time");
        }
        
        return time;
    }

    /**
     * Delete ALL the itineraryStats in the database.
     * @throws SQLException
     */
    public void removeAll() throws SQLException{
        
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM StatsPMV;";
        s.executeUpdate(sqlquery);
        
    }
    
    /**
     * Test this class.
     * @param args
     * @throws FileNotFoundException
     * @throws MalformedURLException
     * @throws MalformedURLException
     * @throws JDOMException
     * @throws JDOMException
     * @throws IOException 
     */
    public static void main(String args[]) throws FileNotFoundException, MalformedURLException,
            MalformedURLException, JDOMException, JDOMException, IOException{
        
        StatsPMVController pmvContr = new StatsPMVController();

        try {
//            pmvContr.removeAll();
//            pmvContr.importAPI();
            System.out.println(pmvContr.getAll().size());
            for(ItineraryStats it : pmvContr.getItinerariesStats(11, "2012-10-17", "2012-10-17")) {
                System.out.println(it.toString());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StatsPMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }




}
