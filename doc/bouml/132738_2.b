class Stats
!!!147970.java!!!	ItineraryStatsXYSeries(in id : int, in d1 : String, in d2 : String) : void
        
        StatsPMVController statsContr = new StatsPMVController();     
        List<ItineraryStats> its = statsContr.getItinerariesStats(id, d1, d2);
        
        //Remove doublons for statistics
        Set<ItineraryStats> itsSet = new TreeSet();
        itsSet.addAll(its);
        
        TimeSeries series = new TimeSeries("Itinerary stats");

        
        for(ItineraryStats it : itsSet){
            SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
            Date h = simpledate.parse(it.getDate() + " " + it.getHour());
            System.out.println(h.toString());
            series.add(new Millisecond(h,TimeZone.getDefault(),Locale.FRANCE),it.getTime());
        }
        
        TimeSeriesCollection data = new TimeSeriesCollection();
        data.addSeries(series);
        
         JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Itinéraire " + id + " (" + d1 + ")",
            "Heure de la journée", 
            "Temps de parcours (minutes)", 
            data,
            false,
            true,
            false
        );

            //create and display a frame...
            ChartFrame frame=new ChartFrame("First",chart);
            frame.pack();
            frame.setVisible(true);
        
        
!!!148098.java!!!	main(inout args : String) : void
        try {
            try {
                Stats.ItineraryStatsXYSeries(121,"2012-10-17","2012-10-17");
            } catch (ParseException ex) {
                Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
        }
