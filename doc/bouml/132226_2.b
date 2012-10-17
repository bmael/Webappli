class ParserCSV
!!!146818.java!!!	extractDataFromZip(in url : String) : List<String[]>
        
        Download.getFile(url);
          
        //Retrieve the name of the zip file and of the csv file
        String archiveName = url.substring(url.lastIndexOf("/")+1);
        
        String[] csvTmpName = archiveName.split("_");
        String csvName = csvTmpName[0] + "_" + csvTmpName[1] + ".csv";
                
        Zipette.extractTo(archiveName, csvName, System.getProperty("user.dir" )+"/");
            
        return extractData(csvName);
!!!146946.java!!!	extractData(in file : String) : List<String[]>
                                         
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
!!!147074.java!!!	main(inout args : String) : void
//        ParserCSV.extractDataFromZip("http://data.nantes.fr/fileadmin/data/datastore/3-publication/mobilite/localisation_pmv/localisation_pmv_csv.zip");
        ParserCSV.extractData(System.getProperty("user.dir")+"/localisation_pmv.csv");
