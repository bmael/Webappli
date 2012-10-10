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
import model.traffic.PMV;
import org.jdom2.JDOMException;
import utilities.dataBaseTools.LinkagePMV;
import utilities.dataBaseTools.ParserCSV;
import utilities.dataBaseTools.ParserXML;

/**
 *
 * @author niiner
 */
public class StatsPMVController {
   /**
     * Import all the PMV from the open data of nantes on the database
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SQLException
     */
    public void importPMV() throws FileNotFoundException, IOException, SQLException, MalformedURLException, JDOMException {

            List<String[]> data = ParserXML.extractDataFromAPI(
                    "http://data.nantes.fr/api/getTempsParcours/1.0/4XTL4M0FTTASDFQ");

           
    }

    /**
     * Add the PMV to the database.
     * @param pmv
     */
    public void add(PMV pmv) throws SQLException{

       
    }

    public List<PMV> getAll() throws SQLException{
 return null;
 
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
                pmvContr.importPMV();
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
