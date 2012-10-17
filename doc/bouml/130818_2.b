class LinkageController
!!!139778.java!!!	importLinkage() : void
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
            
        PMVController pmvContr = new PMVController();
        ItineraryController itContr = new ItineraryController();
        
        List<PMV> pmvs = pmvContr.getAll();
        List<Itinerary> its = itContr.getAll();
        
        for (PMV pmv : pmvs){
            //Link only PMV whose display something
            if(pmv.isIndic_temps()){
                String sqlquery = "INSERT INTO LinkagePMV (idPMV)"
                                + "VALUES('"+ pmv.getId() + "');";
                System.out.println(sqlquery);
                s.executeUpdate(sqlquery);
            }
        }
        
        for (Itinerary it : its){
            String sqlquery = "UPDATE LinkagePMV SET idAPI='"
                                + it.getNumero() + "' WHERE idPMV='11"+ String.format("%02d", it.getNumero()) +"';";
            System.out.println(sqlquery);
            s.executeUpdate(sqlquery);
        }
!!!139906.java!!!	removeAll() : void
        Statement s = DataBaseManager.getInstance().getCon().createStatement();
        String sqlquery = "DELETE FROM LinkagePMV;";
        s.executeUpdate(sqlquery);
!!!140034.java!!!	main(inout args : String) : void
        LinkageController linkageContr = new LinkageController();
        try {
            linkageContr.removeAll();
            linkageContr.importLinkage();
        } catch (SQLException ex) {
            Logger.getLogger(LinkageController.class.getName()).log(Level.SEVERE, null, ex);
        }
