/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.parking.ParkingLocalisation;
import parking.controller.LinkageParkingController;
import parking.controller.ParkingController;
import parking.controller.ParkingLocalisationController;
import parking.controller.StatsParkingController;
import traffic.controller.ItineraryController;
import traffic.controller.LinkageController;
import traffic.controller.PMVController;

/**
 *
 * @author mael
 */
public class Initialize {
    
    public static void main(String args[]){
        
        /** Initialize the PMV **/
        PMVController pmvCont = new PMVController();
        ItineraryController itCont = new ItineraryController();
        LinkageController linkContr = new LinkageController();
        try {
            pmvCont.importPMV();
            itCont.importItinerary();
            linkContr.importLinkage();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

        /** Initialize the Parking **/
        ParkingController parkCont = new ParkingController();
        ParkingLocalisationController parkLocal = new ParkingLocalisationController();
        StatsParkingController statsPark = new StatsParkingController();
        LinkageParkingController linkagePark = new LinkageParkingController();
        try {
            parkCont.importParking();
            parkLocal.importParkingLocalisation();
            statsPark.importParking();
            linkagePark.importLinkage();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        

    }
}
