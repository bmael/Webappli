/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.EJB;

import java.sql.SQLException;
import java.text.ParseException;
import org.jfree.data.xy.XYDataset;
import utilities.statistics.Stats;

/**
 *
 * @author mael
 */
public class ItineraryStatEJB {
    
    private int id;
    private String d1;
    private String d2;

    public int getId() {
        return id;
    }

    public String getD1() {
        return d1;
    }

    public String getD2() {
        return d2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }
    
    public XYDataset retrieveDataSet() throws ParseException, SQLException{
        return Stats.createDataset(id, d1, d2);
    }
}
