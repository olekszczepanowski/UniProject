package GraphicInterface.PanelAdmin;

import Controllers.AdminController;
import Controllers.DoctorController;
import Controllers.MenuController;
import Controllers.PatientController;
import Data.Connection;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.io.IOException;

public class PanelAdmin extends GeneralPanel {

    private static JComboBox<String> ComboBoxPatients = new JComboBox<>();
    private static JComboBox<String> ComboBoxDoctors = new JComboBox<String>();


    public PanelAdmin() throws IOException {
        for (int i = 0; i < DoctorController.getAllDoctors().size(); i++) {
            ComboBoxDoctors.addItem(DoctorController.getAllDoctors().get(i).getFirstName() + " " + DoctorController.getAllDoctors().get(i).getSurname() + "\n Spetialization:" +
                    DoctorController.getAllDoctors().get(i).getSpecialization().getName());
        }
        for (int i = 0; i < PatientController.getAllPatients().size(); i++) {
            ComboBoxPatients.addItem(PatientController.getAllPatients().get(i).getFirstName() + " " + PatientController.getAllPatients().get(i).getSurname() + "\n Pesel:"
                    + PatientController.getAllPatients().get(i).getPersonalIdNumber());
        }
        JButton ButtonRemovePatient = new JButton("Delete patient");
        JButton ButtonRemoveDoctor = new JButton("Delete doctor");
        JLabel LabelPanelAdmin = new JLabel("Admin Panel");
        JLabel LabelDoctorName = new JLabel();
        JLabel LabelDoctorID = new JLabel();
        JLabel LabelDoctorPassword = new JLabel();
        JLabel LabelDoctorSpecialization = new JLabel();
        JLabel LabelPatientName = new JLabel();
        JLabel LabelPatientID = new JLabel();
        JLabel LabelPatientPassword = new JLabel();
        JLabel LabelLoggedAs = new JLabel("Logged as: " + AdminController.loggedAdmin().getAdminID());
        add(ButtonLogOut, getC(7, 1, 0, 0, 50, 0));
        add(LabelPanelAdmin, getC(6, 1, 0, 0, 0, 0));
        add(LabelLoggedAs, getC(6, 2, 0, 0, 50, 0));
        add(ComboBoxPatients, getC(2, 3, 0, 0, 50, 0));
        add(ComboBoxDoctors, getC(6, 3, 0, 0, 50, 0));
        add(ButtonRemovePatient, getC(2, 4, 0, 0, 0, 0));
        add(LabelPatientName, getC(2, 5, 0, 0, 0, 0));
        add(LabelPatientID, getC(2, 6, 0, 0, 0, 0));
        add(LabelPatientPassword, getC(2, 7, 0, 0, 0, 0));
        add(ButtonRemoveDoctor, getC(6, 4, 0, 0, 0, 0));
        add(LabelDoctorName, getC(6, 5, 0, 0, 0, 0));
        add(LabelDoctorID, getC(6, 6, 0, 0, 0, 0));
        add(LabelDoctorPassword, getC(6, 7, 0, 0, 0, 0));
        add(LabelDoctorSpecialization, getC(6, 8, 0, 0, 0, 0));
        ButtonRemovePatient.addActionListener(e -> {
            try {
                ComboBoxPatients.removeItemAt(ComboBoxPatients.getSelectedIndex());
                AdminController.removePatient(ComboBoxPatients);
                revalidate();
                repaint();
            } catch (IndexOutOfBoundsException exception) {
                exception.printStackTrace();
            }
        });
        ButtonRemoveDoctor.addActionListener(e -> {
            try {
                ComboBoxDoctors.removeItemAt(ComboBoxDoctors.getSelectedIndex());
                AdminController.removeDoctor(ComboBoxDoctors);
                revalidate();
                repaint();
            } catch (IndexOutOfBoundsException exception) {
                exception.printStackTrace();
            }
        });
        ComboBoxPatients.addActionListener(e -> {
            try {
                if (PatientController.getAllPatients().size() != 0) {
                    LabelPatientName.setText("Name:" + PatientController.getAllPatients().get(ComboBoxPatients.getSelectedIndex()).getFirstName() + " " + PatientController.getAllPatients().get(ComboBoxPatients.getSelectedIndex()).getSurname());
                    LabelPatientID.setText("Personal ID:" + PatientController.getAllPatients().get(ComboBoxPatients.getSelectedIndex()).getPersonalIdNumber());
                    LabelPatientPassword.setText("Password:" + PatientController.getAllPatients().get(ComboBoxPatients.getSelectedIndex()).getPassword());
                    repaint();
                } else {
                    LabelDoctorName.setText("");
                    LabelDoctorID.setText("");
                    LabelDoctorPassword.setText("");
                    LabelDoctorSpecialization.setText("");
                    repaint();
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        });
        ComboBoxDoctors.addActionListener(e -> {
            try {
                if (DoctorController.getAllDoctors().size() != 0) {
                    LabelDoctorName.setText("Name:" + DoctorController.getAllDoctors().get(ComboBoxDoctors.getSelectedIndex()).getFirstName() + " " + Connection.getDoctors().get(ComboBoxDoctors.getSelectedIndex()).getSurname());
                    LabelDoctorID.setText("ID:" + DoctorController.getAllDoctors().get(ComboBoxDoctors.getSelectedIndex()).getDoctorId());
                    LabelDoctorPassword.setText("Password:" + DoctorController.getAllDoctors().get(ComboBoxDoctors.getSelectedIndex()).getPassword());
                    LabelDoctorSpecialization.setText("Specialization:" + DoctorController.getAllDoctors().get(ComboBoxDoctors.getSelectedIndex()).getSpecialization().getName());
                    repaint();
                } else {
                    LabelDoctorName.setText("");
                    LabelDoctorID.setText("");
                    LabelDoctorPassword.setText("");
                    LabelDoctorSpecialization.setText("");
                    repaint();
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        });
        JLabel LabelWaiting = new JLabel("Doctors waiting for authorization");
        add(LabelWaiting, getC(2, 8, 0, 0, 0, 0));
        JComboBox<String> Waiting = new JComboBox<>();
        JButton Confirm = new JButton("Confirm");
        for (int i = 0; i < DoctorController.getAllDoctorsRequests().size(); i++) {
            Waiting.addItem(DoctorController.getAllDoctorsRequests().get(i).getFirstName() + " " +
                    "" + DoctorController.getAllDoctorsRequests().get(i).getSurname() +
                    " specialization: " + Connection.getDoctorsRegisterRequests().get(i).getSpecialization().getName());
        }
        add(Waiting, getC(2, 9, 0, 0, 0, 0));
        add(Confirm, getC(3, 9, 0, 0, 40, 0));
        Confirm.addActionListener(e -> {
            try {
                AdminController.loggedAdmin().acceptDoctor(DoctorController.getAllDoctorsRequests().get(Waiting.getSelectedIndex()));
                Waiting.removeItemAt(Waiting.getSelectedIndex());
                ComboBoxDoctors.addItem(DoctorController.getAllDoctors().get(DoctorController.getAllDoctors().size() - 1).getFirstName() + " " +
                        "" + DoctorController.getAllDoctors().get(DoctorController.getAllDoctors().size() - 1).getSurname() +
                        " specialization: " + DoctorController.getAllDoctors().get(DoctorController.getAllDoctors().size() - 1).getSpecialization().getName());
                AdminController.saveDoctors();
                AdminController.saveDoctorRequests();
                repaint();
                revalidate();
            } catch (IndexOutOfBoundsException iex) {
                iex.printStackTrace();
            }
        });
        ButtonLogOut.addActionListener(e -> {
            try {
                MenuController.ChangePanel();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ComboBoxPatients.removeAllItems();
            ComboBoxDoctors.removeAllItems();
        });
    }
}
