/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traffic.controller;

import database.DataBaseManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mael
 */
public class StatisticPNGController {
    
    /**
     * Add the PMV to the database.
     * @param pmv
     */
    public void add(int id, String d1, String d2, File img) throws SQLException, FileNotFoundException{

                       
            String sqlquery = "INSERT INTO StatsPNG (id,d1,d2,image_stream)"
                                + "VALUES(?,?,?,?) ";
            
            PreparedStatement s = DataBaseManager.getInstance().getCon().prepareStatement(sqlquery);
            s.setInt(1, id);
            s.setString(2, d1);
            s.setString(3, d2);
            
            FileInputStream fis = new FileInputStream(img);
            s.setBinaryStream(4, (InputStream)fis, (int)(img.length()));
            
            System.out.println(sqlquery);
            s.executeUpdate();
    }

    /**
     * Returns the last png for the given id
     * @param id
     * @return fil File the png
     * @throws SQLException
     * @throws IOException
     */
    public File getLast(int id) throws SQLException, IOException{
        
        String sqlquery = "SELECT image_stream, d1, d2 FROM StatsPNG WHERE id=? ORDER BY d1 ASC";
        
        PreparedStatement s = DataBaseManager.getInstance().getCon().prepareStatement(sqlquery);
        s.setInt(1, id);
        
        ResultSet res = s.executeQuery();
        if(res.next()){
            File img = new File(id + "_" + res.getString("d1") + "_" + res.getString("d2"));
            FileOutputStream ostreamImage = new FileOutputStream(img);

            InputStream istreamImage = res.getBinaryStream("image_stream");

            byte[] buffer = new byte[1024];
            int length = 0;

            while((length = istreamImage.read(buffer))!= -1){
                 ostreamImage.write(buffer, 0, length);
            }
            System.out.println("Returning the image file...");
            return img;
        }
        else{
            return null;
        }
   
    }
    
    /**
     * Test this class
     * @param args 
     */
    public static void main(String args[]){

    }
}
