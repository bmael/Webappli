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
 *
 * @author niiner
 */
public class ParserXML {

    static org.jdom2.Document document;
    static Element racine;

    /**
     * Extract data from the zip file at the url given in parameter
     * @param url
     * @return List of data
     */
    public static List<String[]> extractDataFromAPI(String url) throws 
            FileNotFoundException, IOException, MalformedURLException, JDOMException{

        try{
            BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            FileWriter localFile = new FileWriter(new File("itinerary.xml"));

            String s;
            String l;
            while((s = urlReader.readLine()) != null){
                localFile.write(s);
            }

            urlReader.close();
            localFile.close();
        }
        catch(Exception e){
            System.out.println("Erreur : " + e);
        }
        
        return extractData("itinerary.xml");
    }

    /**
     * Extract data from the file given in parameter
     * @param file
     * @return List of data
     */
    public static List<String[]> extractData(String file) throws 
            FileNotFoundException, IOException, MalformedURLException, JDOMException{

          
        List<String[] > data = new ArrayList<String[] >();

        //On crée une instance de SAXBuilder
        SAXBuilder sxb = new SAXBuilder();
        try
        {
        document = sxb.build(new File(file));
        }
        catch(Exception e){e.printStackTrace();}     

         //Initialisation d'un nouvel élément racine avec l'élément racine du document.
        racine = document.getRootElement();

        List <Element> lgs;
        lgs = (List <Element>)XPath.selectNodes(document, "opendata/answer/data/Itineraires/Itineraire");
        Iterator i = lgs.iterator();

        while(i.hasNext())
        {
        //On recrée l'Element courant à chaque tour de boucle afin de
        //pouvoir utiliser les méthodes propres aux Element comme :
        //selectionner un noeud fils, modifier du texte, etc...
        Element courant = (Element)i.next();
        //On affiche le nom de l'element courant
        System.out.println(courant.getChild("Identifiant").getText());
        System.out.println(courant.getChild("Temps").getText());
        System.out.println(courant.getChild("Horodatage").getText());                     
        }

        return null;
    }




    /**
     * Test for the parser
     * @param args
     * @throws FileNotFoundException
     * @throws MalformedURLException
     * @throws IOException 
     */
    public static void main(String args[]) throws 
        FileNotFoundException, MalformedURLException, IOException, JDOMException{
        
        ParserXML.extractDataFromAPI("http://data.nantes.fr/api/getTempsParcours/1.0/4XTL4M0FTTASDFQ");
   }

}


