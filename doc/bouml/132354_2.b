class ParserXML
!!!147202.java!!!	extractDataFromAPI(in url : String) : List<String[]>

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
!!!147330.java!!!	extractData(in file : String) : List<String[]>

        ArrayList<String[]>datas = new ArrayList<String[]>();

        SAXBuilder sxb = new SAXBuilder();
        try
        {
            document = sxb.build(new File(file));
        }
        catch(Exception e){e.printStackTrace();}     

        //We start to the root of the XML document, taking data in nodes
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
        
        return datas;
!!!147458.java!!!	main(inout args : String) : void
        ParserXML.extractDataFromAPI("http://data.nantes.fr/api/getTempsParcours/1.0/4XTL4M0FTTASDFQ");
