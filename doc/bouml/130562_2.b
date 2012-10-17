class ItineraryController
!!!139138.java!!!	importItinerary() : void

            List<String[]> data = ParserCSV.extractData(System.getProperty("user.dir" )+"/itinerary.csv");

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
!!!139266.java!!!	add(inout it : Itinerary) : void

            Statement s = DataBaseManager.getInstance().getCon().createStatement();
            String sqlquery = "INSERT INTO Itinerary (id,numero,origine,destination)"
                                + "VALUES('"+ it.getId() + "', "
                                +  "'" + it.getNumero() + "', "
                                +  "'" + it.getOrigine() + "', "
                                +  "'" + it.getDestination() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
!!!139394.java!!!	getAll() : Itinerary
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
!!!139522.java!!!	removeAll() : void
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM Itinerary;";
        s.executeUpdate(sqlquery);
!!!139650.java!!!	main(inout args : String) : void

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
