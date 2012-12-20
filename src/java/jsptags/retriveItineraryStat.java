/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsptags;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.ws.rs.core.Response;
import traffic.controller.StatisticPNGController;

/**
 * Search into the PNGStatistic database the right png to display.
 * @author mael
 */
public class retriveItineraryStat extends BodyTagSupport {

    private String idpmv = null;
    private String d1 = null;
    private String d2 = null;
    
    public String getIdpmv(){return this.idpmv;}
    public String getD1(){return this.d1;}
    public String getD2(){return this.d2;}
    
    public void setIdpmv(String idpmv){this.idpmv=idpmv;}
    public void setD1(String d1){this.d1=d1;}
    public void setD2(String d2){this.d2=d2;}
    
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
        
        StatisticPNGController contr = new StatisticPNGController();
        
        JspWriter out=pageContext.getOut();
        try {
            out.println("<img id='chartPNG' src='");
            try {
                out.println(contr.getLast(Integer.parseInt("11")).getName());
            } catch (SQLException ex) {
                Logger.getLogger(retriveItineraryStat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(retriveItineraryStat.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("' alt='StatPNG'/>");
        } catch (IOException ex) {
            Logger.getLogger(retriveItineraryStat.class.getName()).log(Level.SEVERE, null, ex);
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
