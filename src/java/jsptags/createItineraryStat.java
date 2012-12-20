/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsptags;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import org.jfree.chart.ChartUtilities;
import utilities.statistics.Stats;

/**
 *
 * @author mael
 */
public class createItineraryStat extends BodyTagSupport {
    private String idpmv = null;
    private String d1 = null;
    private String d2 = null;
    private String path = null;
    
//    public String getIdpmv(){return this.idpmv;}
//    public String getD1(){return this.d1;}
//    public String getD2(){return this.d2;}
//    public String getPath(){return this.path;}

    public void setIdpmv(String idpmv){this.idpmv=idpmv;}
    public void setD1(String d1){this.d1=d1;}
    public void setD2(String d2){this.d2=d2;}
    public void setPath(String path){this.path= String.valueOf(path);}



    
     
    /**
     * This method is called when the JSP engine encounters the start tag, after
     * the attributes are processed. Scripting variables (if any) have their
     * values set here.
     *
     * @return EVAL_BODY_BUFFERED if the JSP engine should evaluate the tag
     * body, otherwise return SKIP_BODY. This method is automatically generated.
     * Do not modify this method. Instead, modify the methods that this method
     * calls.
     */
    @Override
    public int doStartTag() throws JspException {
        
        try {
            JspWriter out=pageContext.getOut();
            out.println("<div>into the tags </div>");
            try {
       //            Stats.createIntineraryStat(Integer.parseInt(getIdpmv()), getD1(), getD2());
//                pageContext.getResponse().setContentType("image/png");
//ChartUtilities.writeChartAsPNG(pageContext.getResponse().getOutputStream(), Stats.createIntineraryStat(11, d1,d2, path),500,500);
                            Stats.createIntineraryStat(Integer.parseInt(idpmv), d1,d2);
            } catch (SQLException ex) {
                Logger.getLogger(createItineraryStat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(createItineraryStat.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(createItineraryStat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return EVAL_BODY_INCLUDE;          
    }

    /**
     * This method is called after the JSP engine finished processing the tag.
     *
     * @return EVAL_PAGE if the JSP engine should continue evaluating the JSP
     * page, otherwise return SKIP_PAGE. This method is automatically generated.
     * Do not modify this method. Instead, modify the methods that this method
     * calls.
     */
    @Override
    public int doEndTag() throws JspException {
       return EVAL_PAGE;      
    }

  
}
