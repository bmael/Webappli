class StatsPMVController
!!!140802.java!!!	importAPI() : void

            List<String[]> data = ParserXML.extractDataFromAPI(
                    "http://data.nantes.fr/api/getTempsParcours/1.0/4XTL4M0FTTASDFQ");

            for (String[] oneData : data) {                             
                
                String id = oneData[0];
                String time = oneData[1];
                String date = oneData[2].substring(0,10);
                String hour = oneData[2].substring(11,(oneData[2].length()));
               
              
                ItineraryStats it = new ItineraryStats(Integer.parseInt(id), Integer.parseInt(time), date, hour);
                it.setDate(it.reverseDate(date));
                
                this.add(it);               
          }
!!!140930.java!!!	add(inout itineraryStats : ItineraryStats) : void
    
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
            String sqlquery = "INSERT INTO StatsPMV (id, time, dateD, hourH)"
                                + "VALUES('"+ itineraryStats.getId() + "', "
                                +  "'" + itineraryStats.getTime() + "', "
                                +  "'" + itineraryStats.getDate() + "', "
                                +  "'" + itineraryStats.getHour() + "') ";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
       
!!!141058.java!!!	getAll() : ItineraryStats
        
    List<ItineraryStats> itineraries = new ArrayList();

        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM StatsPMV;";
        ResultSet res = s.executeQuery(sqlquery);

        while(res.next()){
                itineraries.add(new ItineraryStats(res.getInt("id"),res.getInt("time"),
                                res.getString("dateD"), res.getString("hourH")));
        }                          
    

        return itineraries;
 
!!!141186.java!!!	getItinerariesStats(in id : int, in d1 : String, in d2 : String) : ItineraryStats
        
        List <ItineraryStats> liRes = new ArrayList();
        
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "SELECT * FROM StatsPMV "
                        + "WHERE id='"
                        + id + "' "
                        + "AND dateD>='" + d1 + "' "
                        + "AND dateD<='" + d2 + "';";
        ResultSet res = s.executeQuery(sqlquery);
        
        while(res.next()){
                liRes.add(new ItineraryStats(res.getInt("id"),res.getInt("time"),
                                res.getString("dateD"), res.getString("hourH")));
        }
        
        return liRes;
        
!!!141314.java!!!	removeAll() : void
        
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM StatsPMV;";
        s.executeUpdate(sqlquery);
        
!!!141442.java!!!	main(inout args : String) : void
        
        StatsPMVController pmvContr = new StatsPMVController();

        try {
//            pmvContr.importAPI();
            System.out.println(pmvContr.getAll().size());
            for(ItineraryStats it : pmvContr.getItinerariesStats(11, "2012-10-17", "2012-10-17")) {
                System.out.println(it.toString());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StatsPMVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
