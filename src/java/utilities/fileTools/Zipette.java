/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.fileTools;

/**
 *
 * @author mael
 */
//Importation des packages dont on va se servir
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Zipette{

    /**
     * Return the list of the files on the zip
     * @param archive zip file
     * @return The list of the files on the zip file 
     */
    public static ArrayList getFiles(String archive) {
        ArrayList fileList = new ArrayList<String>();
        ZipInputStream zipInputStream = null;
        ZipEntry zipEntry = null;
        Long size;

        try {
            zipInputStream = new ZipInputStream(new FileInputStream(archive));
            zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                String[] file = new String[3];
                file[0] = zipEntry.getName();
                size = zipEntry.getSize()/1024;
                file[1] = size.toString()+ " ko";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                file[2] = simpleDateFormat.format(new Date(zipEntry.getTime()));

                fileList.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Zipette.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                zipInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Zipette.class.getName()).log(Level.SEVERE, null, ex);
            }
            return fileList;
        }
    }

    /**
     * Extract a file
     * @param archive zip file
     * @param file file name to extract
     * @param destPath destination folder
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void extractTo(String archive, String file, String destPath) throws FileNotFoundException, IOException {
        ZipInputStream zipInputStream = null;
        ZipEntry zipEntry = null;
        byte[] buffer = new byte[2048];
       
        zipInputStream = new ZipInputStream(new FileInputStream(archive));
        zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            if (zipEntry.getName().equalsIgnoreCase(file)) {
                FileOutputStream fileoutputstream = new FileOutputStream(destPath + file);
                int n;

                while ((n = zipInputStream.read(buffer, 0, 2048)) > -1) {
                    fileoutputstream.write(buffer, 0, n);
                }

                fileoutputstream.close();
                zipInputStream.closeEntry();

            }
            zipEntry = zipInputStream.getNextEntry();
        }
    }
}