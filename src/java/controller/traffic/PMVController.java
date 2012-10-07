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
import model.traffic.PMV;
/**
 * Class to control a PMV on the database.
 * @author mael
 */
public class PMVController {
    
    public void importPMV() throws FileNotFoundException, IOException{
       
        try{
            CSVReader readerPmvs = new CSVReader(new FileReader("resources/Localisation_pmv.csv"));
            
            List<String[] > data = new ArrayList<String[] >();

            String[] nextLine = null;
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
                
                List<PMV> pmvs = new ArrayList<PMV>();

                for (String[] oneData : data) {
                    String id = oneData[0];
                    String sens = oneData[1];
                    String indic_temps = oneData[2];
                    String longitude = oneData[3];
                    String latitude = oneData[4];

                    PMV pmv = new PMV();
                    pmvs.add(pmv);
                }
                
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void add(PMV pmv){
        try{
            Statement s = DataBaseManager.getInstance().getCon().createStatement();
                        
            String sqlquery = "INSERT INTO PMV (id,sens,indic_temps_parcours,longitude,latitude)"
                                + "VALUES('"+ pmv.getId() +"', "
                    +  "'" + pmv.getSens() +"', "
                    +  "'" + pmv.getSens() +"', "
                    +  "'" + pmv.getSens() +"', "
                                +  "'" + pmv.getSens() +"', ";
            s.executeUpdate(sqlquery);
            

        }catch(SQLException e){
            System.err.println("SQLException : error in adding Highscore");
            System.err.println(e);
        }
    }
    
    
}
