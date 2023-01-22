package Controllers;

import Data.Connection;
import Data.UserAccount;
import Model.Admin;
import GraphicInterface.Components.Frame;
import GraphicInterface.Menu.PanelLoginAdmin;
import GraphicInterface.PanelAdmin.PanelAdmin;

import javax.swing.*;
import java.io.IOException;
import java.util.InputMismatchException;

public class AdminController {
    public static void ChangePanel() throws IOException {
        Frame.getFrame().set(new PanelAdmin());
    }

    public static void adminLogin() throws IOException {
        UserAccount.adminLogin();
    }

    public static Admin loggedAdmin() {
        return UserAccount.getLoggedAdmin();
    }

    public static void removePatient(JComboBox comboBoxPatients) {
        UserAccount.getLoggedAdmin().removePatient(Connection.getPatients().get(comboBoxPatients.getSelectedIndex() + 1));
        Connection.savePatients();
    }

    public static void removeDoctor(JComboBox comboBoxDoctors) {
        UserAccount.getLoggedAdmin().removeDoctor(Connection.getDoctors().get(comboBoxDoctors.getSelectedIndex() + 1));
        Connection.saveDoctors();
    }

    public static int getID() {
        int id = 0;
        try {
            id = Integer.parseInt(PanelLoginAdmin.getTextFieldIDAdmin().getText());
        } catch (NumberFormatException ignored) {
        }
        return id;
    }

    public static String getPassword() {
        return String.valueOf(PanelLoginAdmin.getTextFieldPasswordAdmin().getPassword());
    }

    public static void saveDoctors() {
        Connection.saveDoctors();
    }

    public static void saveDoctorRequests() {
        Connection.saveDoctorsRequests();
    }

    public static void savePatients() {
        Connection.savePatients();
    }

    public static void saveAllData() {
        Connection.saveAllData();
    }

    public static int getAdminID() {
        try {
            return Integer.parseInt(PanelLoginAdmin.getTextFieldIDAdmin().getText());
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static String getAdminPassword() {
        try {
            return String.valueOf(PanelLoginAdmin.getTextFieldPasswordAdmin().getPassword());
        } catch (InputMismatchException exception) {
            exception.printStackTrace();
        }
        return "";
    }
}
