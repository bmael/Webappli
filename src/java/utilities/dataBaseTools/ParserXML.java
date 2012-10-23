/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.dataBaseTools;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.xpath.XPath;



/**
 * This class provides some methods to parse an XML file 
 * @author Niiner
 */
public class ParserXML {

    static org.jdom2.Document document;
    static Element racine;

    /**
     * Extract data from the xml file at the url given in parameter
     * @param url
     * @return List of data
     */
    public static List<String[]> extractDataFromAPI(String xmlFileName, String url) throws 
            FileNotFoundException, IOException, MalformedURLException, JDOMException{

        try{
            //String file = fileName + ".xml";
            BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            
            //Replace itinerary.xml by file 
            FileWriter localFile = new FileWriter(new File(xmlFileName));

            String s;
            while((s = urlReader.readLine()) != null){
                localFile.write(s);
            }

            urlReader.close();
            localFile.close();
        }
        catch(Exception e){
            System.out.println("Erreur : " + e);
        }
        
        //return file  delete "try/catch block ?
        return extractData(xmlFileName);     
}
    
  

    /**
     * Extract data from the file given in parameter (for itineraries)
     * @param file
     * @return List of data
     */
    public static List<String[]> extractData(String file) throws 
            FileNotFoundException, IOException, MalformedURLException, JDOMException{

        ArrayList<String[]>datas = new ArrayList<String[]>();

        SAXBuilder sxb = new SAXBuilder();
        try
        {
            document = sxb.build(new File(file));
        }
        catch(Exception e){e.printStackTrace();}     

        //We start to the root of the XML document, taking data in nodes
       

        if (file == "itinerary.xml"){
             racine = document.getRootElement();
            List <Element> lgs = (List <Element>)XPath.selectNodes(document, "opendata/answer/data/Itineraires/Itineraire");
            Iterator i = lgs.iterator();
           
            while(i.hasNext())
            {
                Element courant = (Element)i.next();

                String id = courant.getChild("Identifiant").getText();
                String temps = courant.getChild("Temps").getText();
                String date = courant.getChild("Horodatage").getText();

                String[] line = new String[3];
                line[0] = id;
                line[1] = temps;
                line[2] = date;

                datas.add(line);      
            } 
        }
        else{
            racine = document.getRootElement();
            List <Element> lgs = (List <Element>)XPath.selectNodes(document, "opendata/answer/data/Groupes_Parking/Groupe_Parking");
            Iterator i = lgs.iterator();
            
            while(i.hasNext())
            {
                 Element courant = (Element)i.next();

                 String id = courant.getChild("Grp_identifiant").getText();
                 String nameParking = courant.getChild("Grp_nom").getText();
                 String availablePlaces = courant.getChild("Grp_disponible").getText();
                 String status = courant.getChild("Grp_statut").getText();
                 String date = courant.getChild("Grp_horodatage").getText();
                 String idObj = courant.getChild("IdObj").getText();

                 String[] line = new String[6];
                 line[0] = id;
                 line[1] = nameParking;
                 line[2] = availablePlaces;
                 line[3] = status;
                 line[4] = idObj;
                 line[5] = date;

                 datas.add(line);
             }
        }
        return datas;
}




    /**
     * Test for the parser
     * @param args
     * @throws FileNotFoundException
     * @throws MalformedURLException
     * @throws IOException
     * @throws JDOMException
     * @throws IOException 
     */
    public static void main(String args[]) throws 
        FileNotFoundException, MalformedURLException, IOException, JDOMException{
        ParserXML.extractDataFromAPI("itinerary.xml", "http://data.nantes.fr/api/getTempsParcours/1.0/4XTL4M0FTTASDFQ");
        ParserXML.extractDataFromAPI("parking.xml", "http://data.nantes.fr/api/getDisponibiliteParkingsPublics/1.0/39W9VSNCSASEOGV");
   }

}


