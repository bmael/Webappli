/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.statistics;

import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.jsp.jstl.core.Config;
import model.traffic.ItineraryStats;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.ImageEncoder;
import org.jfree.chart.encoders.ImageEncoderFactory;
import org.jfree.chart.encoders.ImageFormat;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import traffic.controller.StatisticPNGController;
import traffic.controller.StatsPMVController;






/**
 * Static class provides methods to compute statistic graph with JFreeChart
 * @author mael
 */
public class Stats {
      
    /**
     * Creates the dataset used for construct the chart.
     * @param int id - the id of itineray
     * @param String d1 - the start date for the graph
     * @param String d2 - the end daye for the graph
     * @throws ParseException
     * @throws SQLException
     */
    public static XYDataset createDataset(int id, String d1, String d2) throws ParseException, SQLException{
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
        
        return data;
        
    }
    
    /**
     * Export the chart to a png.
     * @param title - the name of the png file
     * @param chart - the chart to display
     * @throws IOException
     */
    private static void saveAsPNG(File img,JFreeChart chart) throws IOException{
        ChartUtilities.saveChartAsPNG(img,
                chart, 560, 400);
    }
    
    /**
     * Show the chart in a frame.
     * @param chart - the chart to display
     */
    private static void show(JFreeChart chart){
        //create and display a frame...
        ChartFrame frame=new ChartFrame("First",chart);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Construct an XY graph. In X we have time (hour), in Y we have time (minutes) 
     * to go at the destination of the itinerary.
     * @param int id - the id of itineray
     * @param String d1 - the start date for the graph
     * @param String d2 - the end daye for the graph
     * @throws ParseException
     * @throws SQLException
     * @throws IOException
     */
    public static JFreeChart ItineraryStatsXYSeries(int id, String d1, String d2) throws SQLException, ParseException, IOException{
        
         XYDataset data = createDataset(id, d1, d2);
         JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Itinéraire " + id + " (" + d1 + ")",
            "Heure de la journée", 
            "Temps de parcours (minutes)", 
            data,
            false,
            true,
            false
        );
                  
         Ellipse2D.Double t = new Ellipse2D.Double(-2.5, -2.5, 5, 5);
         
         XYPlot plot = (XYPlot) chart.getPlot();
         XYLineAndShapeRenderer render = (XYLineAndShapeRenderer) plot.getRenderer();
         render.setSeriesShapesVisible(0, true);
         render.setSeriesShape(0, t);
         
         /* TODO : lisser la courbe si antialiasing est vrai */

//                 show(chart);

         
         return chart;
//        saveAsPNG(id+"_"+d1+"_"+d2,chart);
    }
    
    /**
     * Construct a polar graph. In X we have time (hour), in Y we have time (minutes) 
     * to go at the destination of the itinerary.
     * @param int id - the id of itineray
     * @param String d1 - the start date for the graph
     * @param String d2 - the end daye for the graph
     */
    public static void ItineraryStatsPolar(int id, String d1, String d2) throws SQLException, ParseException{
 
        XYDataset data = createDataset(id, d1, d2);       
        JFreeChart chart = ChartFactory.createPolarChart(
            "Itinéraire " + id + " (" + d1 + ")",
            data,
            true,
            true,
            false
        );
        show(chart);       
    }
    
    /**
     * Create the png of the specific statistic if does not exist.
     * @param int id - the id of itineray
     * @param String d1 - the start date for the graph
     * @param String d2 - the end daye for the graph
     * @param String path - the png path
     */
    public static void createIntineraryStat(int id, String d1, String d2, String path) throws SQLException, ParseException, IOException{
//        System.out.println(System.getProperty("user.dir"));
//        File png = new File(id+"_"+d1+"_"+d2);
            
            File png = new File(path+"/"+id+"_"+d1+"_"+d2+".png");
//            png.mkdirs();
            System.out.println(png.getAbsolutePath());
            JFreeChart chart = Stats.ItineraryStatsXYSeries(id, d1, d2);
            
//            ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(ImageFormat.PNG);
//            imageEncoder.encode(chart.createBufferedImage(560, 400), new FileOutputStream(png));
//
//            StatisticPNGController contr = new StatisticPNGController();
//            contr.add(id, d1, d2, png);
            System.out.println("png created");
            Date now = new Date();
            
            // Last modification have to be inferior to 5 minutes
            if(!png.exists() || png.lastModified() <= now.getTime() - 300000)
            {
                Stats.saveAsPNG(png, chart);
            }
//            return chart;
    }
    
    /**
     * Test this class.
     * @param args 
     */
    public static void main(String args[]) throws ParseException{
        try {
                try {
                    Stats.ItineraryStatsXYSeries(11,"2012-11-15","2012-11-16");
                    Stats.ItineraryStatsXYSeries(11,"2012-10-25","2012-10-25");
                } catch (IOException ex) {
                    Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
                }

        } catch (SQLException ex) {
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
