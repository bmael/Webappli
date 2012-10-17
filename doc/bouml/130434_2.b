class DataBaseManager
!!!138114.java!!!	DataBaseManager()
         try {
            Class.forName("com.mysql.jdbc.Driver");  //loads the driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebappliDb", "root", "root");
            
            //creates tables for the database
            createTablePMV();
            createTableItinerary();
            createTableLinkage();
            createTableStatsPMV();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
!!!138242.java!!!	createTableStatsPMV() : void
        String sqlquery = "CREATE TABLE IF NOT EXISTS StatsPMV"+
                            "(id INT,"
                            + "time INT,"
                            + "dateD DATE,"
                            + "hourH TIME"
                            + ");";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
!!!138370.java!!!	createTablePMV() : void
        String sqlquery = "CREATE TABLE IF NOT EXISTS Pmv"+
                            "(numero INT,"
                            + "sens VARCHAR(2),"
                            + "indic_temps_parcours INT,"
                            + "longitude REAL,"
                            + "latitude REAL,"
                            + "PRIMARY KEY(numero));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
!!!138498.java!!!	createTableItinerary() : void
        String sqlquery = "CREATE TABLE IF NOT EXISTS Itinerary"+
                            "(id INT,"
                            + "numero INT,"
                            + "origine VARCHAR(100),"
                            + "destination VARCHAR(100),"
                            + "PRIMARY KEY(id));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
!!!138626.java!!!	createTableLinkage() : void
        String sqlquery = "CREATE TABLE IF NOT EXISTS LinkagePMV"+
                            "(idPMV INT,"
                            + "idAPI INT,"
                            + "PRIMARY KEY(idPMV));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
!!!138754.java!!!	getCon() : Connection
        return con;
!!!138882.java!!!	getInstance() : DataBaseManager
        if(instance == null){
            instance = new DataBaseManager();
        }
        return instance;   
!!!139010.java!!!	main(inout args : String) : void
      
        DataBaseManager.getInstance();
