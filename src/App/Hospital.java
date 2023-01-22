package App;

import Data.Connection;
import Model.Admin;
import Model.Doctor;
import Model.Patient;
import GraphicInterface.Components.Frame;
import GraphicInterface.Menu.PanelMenu;

public class Hospital {

    public static void main(String[] args) {

        Connection.loadAllData();
        showAllDoctors();
        showAllPatients();
        showAllAdmins();

        try {
            Frame.getFrame().set(new PanelMenu());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Connection.saveAllData();
    }

    public static void showAllDoctors() {

        for (Doctor doctor : Connection.getDoctors()) {
            System.out.println(doctor);
        }
        System.out.println();
    }

    public static void showAllPatients() {

        for (Patient patient : Connection.getPatients()) {
            System.out.println(patient);
        }
        System.out.println();
    }

    public static void showAllAdmins() {

        for (Admin admin : Connection.getAdmins()) {
            System.out.println(admin);
        }
        System.out.println(

        );
    }
}