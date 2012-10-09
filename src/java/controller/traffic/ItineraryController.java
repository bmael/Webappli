/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.traffic;

import controller.database.DataBaseManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.traffic.Itinerary;
import utilities.dataBaseTools.Parser;

/**
 * Class to control Itineraries displayed by PMVs into our database
 * @author mael
 */
public class ItineraryController {
    /**
     * Import all the Itineraries from the csv file created according to table 
     * found at <http://data.nantes.fr/les-donnees/documentation-de-lapi/gettempsparcours/>
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SQLException
     */
    public void importItinerary() throws FileNotFoundException, IOException, SQLException {

            List<String[]> data = Parser.extractData(System.getProperty("user.dir" )+"/itinerary.csv");

            for (String[] oneData : data) {
                String id = oneData[0];
                String numero = oneData[1].replace("PMV ", "").replace(" ", "");
                String origine = oneData[2];
                String destination = oneData[3];

                Itinerary it = new Itinerary(Integer.parseInt(id),
                                    Integer.parseInt(numero),
                                    origine,
                                    destination);

                this.add(it);
            }
    }

    /**
     * Add the PMV to the database.
     * @param pmv
     */
    public void add(Itinerary it) throws SQLException{

            Statement s = DataBaseManager.getInstance().getCon().createStatement();
            String sqlquery = "INSERT INTO Itinerary (id,numero,origine,destination)"
                                + "VALUES('"+ it.getId() + "', "
                                +  "'" + it.getNumero() + "', "
                                +  "'" + it.getOrigine() + "', "
                                +  "'" + it.getDestination() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
    }

    public List<Itinerary> getAll() throws SQLException{
        List<Itinerary> its = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM Itinerary;";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                its.add(new Itinerary(res.getInt("id"),res.getInt("numero"),
                                    res.getString("origine"),
                                    res.getString("destination")));
            }

        return its;
    }

    public void removeAll() throws SQLException{
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM Itinerary;";
        s.executeUpdate(sqlquery);
    }
    
    public static void main(String args[]){

        System.out.print(System.getProperty("user.dir" ));
        ItineraryController itContr = new ItineraryController();
        try {
            itContr.removeAll();
        } catch (SQLException ex) {
            Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                itContr.importItinerary();
            } catch (SQLException ex) {
                Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(itContr.getAll().size());
        } catch (SQLException ex) {
            Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
