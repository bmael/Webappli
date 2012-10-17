class PMVController
!!!140162.java!!!	importPMV() : void

//            List<String[]> data = ParserCSV.extractDataFromZip(
//                            "http://data.nantes.fr/fileadmin/data/datastore/"+
//                            "3-publication/mobilite/localisation_pmv/"+
//                            "localisation_pmv_csv.zip");
                   List<String[]> data = ParserCSV.extractData(System.getProperty("user.dir")+"/localisation_pmv.csv");


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
!!!140290.java!!!	add(inout pmv : PMV) : void

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
!!!140418.java!!!	getAll() : PMV
        List<PMV> pmvs = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM Pmv;";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                pmvs.add(new PMV(res.getInt("numero"),res.getString("sens"),
                                    res.getBoolean("indic_temps_parcours"),
                                    res.getFloat("longitude"),
                                    res.getFloat("latitude")));
            }

        return pmvs;
!!!140546.java!!!	removeAll() : void
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM Pmv;";
        s.executeUpdate(sqlquery);
!!!140674.java!!!	main(inout args : String) : void

        System.out.print(System.getProperty("user.dir" ));
        PMVController pmvContr = new PMVController();
        try {
            pmvContr.removeAll();
        } catch (SQLException ex) {
            Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                pmvContr.importPMV();
            } catch (SQLException ex) {
                Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(pmvContr.getAll().size());
        } catch (SQLException ex) {
            Logger.getLogger(PMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
