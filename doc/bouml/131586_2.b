class PeriodicImport
!!!145666.java!!!	importEveryDay() : void
       PMVController pmvContr = new PMVController();
        try {
            pmvContr.removeAll();
            pmvContr.importPMV();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    Logger.getLogger(PeriodicImport.class.getName()).log(Level.INFO, 
      "Execution import PMV " + mediumDateFormat.format(new Date()));
!!!145794.java!!!	importStatsEvery10Min() : void
       StatsPMVController pmvContr = new StatsPMVController();

        try {
            pmvContr.importAPI();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(PeriodicImport.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    Logger.getLogger(PeriodicImport.class.getName()).log(Level.INFO, 
      "Execution importAPI " + mediumDateFormat.format(new Date()));
