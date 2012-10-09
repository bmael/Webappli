/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.dataBaseTools;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import utilities.fileTools.Download;
import utilities.fileTools.Zipette;

/**
 * This class provides some methods to parse a csv file 
 * @author mael
 */
public class Parser {
    
    /**
     * Extract data from the zip file at the url given in parameter
     * @param url
     * @return List of data
     */
    public static List<String[]> extractDataFromZip(String url) throws 
            FileNotFoundException, IOException, MalformedURLException{
        
        Download.getFile(url);
          
        //Retrieve the name of the zip file and of the csv file
        String archiveName = url.substring(url.lastIndexOf("/")+1);
        
        String[] csvTmpName = archiveName.split("_");
        String csvName = csvTmpName[0] + "_" + csvTmpName[1] + ".csv";
                
        Zipette.extractTo(archiveName, csvName, System.getProperty("user.dir" )+"/");
            
        return extractData(csvName);
    }
    
    /**
     * Extract data from the file given in parameter
     * @param file
     * @return List of data
     */
    public static List<String[]> extractData(String file) throws 
            FileNotFoundException, IOException, MalformedURLException{
                                         
        CSVReader readerPmvs = new CSVReader(new FileReader(file),';');
        List<String[] > data = new ArrayList<String[] >();

        String[] nextLine = readerPmvs.readNext();
        while ((nextLine = readerPmvs.readNext()) != null) {
            int size = nextLine.length;

            // empty line
            if (size == 0) continue;
            
            String start = nextLine[0].trim();
            if (start.length() == 0 && size == 1) continue;

            // comment line
            if (start.startsWith("#")) continue;

            data.add(nextLine);
        }
                
        return data;
    }
    
    /**
     * Test for the parser
     * @param args
     * @throws FileNotFoundException
     * @throws MalformedURLException
     * @throws IOException 
     */
    public static void main(String args[]) throws 
        FileNotFoundException, MalformedURLException, IOException{
        Parser.extractDataFromZip("http://data.nantes.fr/fileadmin/data/datastore/3-publication/mobilite/localisation_pmv/localisation_pmv_csv.zip");
        
    }
    
}
