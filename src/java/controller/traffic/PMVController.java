/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.traffic;

import au.com.bytecode.opencsv.CSVReader;
import controller.database.DataBaseManager;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.traffic.PMV;
/**
 * Class to control a PMV on the database.
 * @author mael
 */
public class PMVController {
    
    public void importPMV() throws FileNotFoundException, IOException{
       
        try{
            CSVReader readerPmvs = new CSVReader(new FileReader(System.getProperty("user.dir" )+"/src/java/resources/Localisation_pmv.csv"),';',' ');
            
            List<String[] > data = new ArrayList<String[] >();

            String[] nextLine = readerPmvs.readNext();
            try{
                while ((nextLine = readerPmvs.readNext()) != null) {
                    int size = nextLine.length;

                    // empty line
                    if (size == 0) {
                        continue;
                    }
                    String start = nextLine[0].trim();
                    if (start.length() == 0 && size == 1) {
                        continue;
                    }

                    // comment line
                    if (start.startsWith("#")) {
                        continue;
                    }
                    data.add(nextLine);
                }
                
                
                for (String[] oneData : data) {
                    String id = oneData[0].replace(',', '.');
                    String sens = oneData[1];
                    String indic_temps = oneData[2];
                    String longitude = oneData[3].replace(',', '.');
                    String latitude = oneData[4].replace(',', '.');
                    
                    PMV pmv = new PMV((int)Float.parseFloat(id),
                                        sens,
                                        ("Oui".equals(indic_temps)) ? true : false,
                                        Float.parseFloat(longitude),
                                        Float.parseFloat(latitude));
                    
                    this.add(pmv);
                }
                           
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Add the PMV to the database.
     * @param pmv
     */
    public void add(PMV pmv){
        try{
            Statement s = DataBaseManager.getInstance().getCon().createStatement();
                        int indic = (pmv.isIndic_temps())? 1 : 0;
            String sqlquery = "INSERT INTO Pmv (numero,sens,indic_temps_parcours,longitude,latitude)"
                                + "VALUES('"+ pmv.getId() + "', "
                                +  "'" + pmv.getSens() + "', "
                                +  "'" + indic + "', "
                                +  "'" + pmv.getLongitude() + "', "
                                +  "'" + pmv.getLatitude() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
            

        }catch(SQLException e){
            e.printStackTrace();

        }
    }
    
    public static void main(String args[]){
        DataBaseManager.getInstance().clean("Pmv");
        System.out.print(System.getProperty("user.dir" ));
        PMVController pmvContr = new PMVController();
        try {
            pmvContr.importPMV();
        } catch (IOException ex) {
            Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
