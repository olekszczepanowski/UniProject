package GraphicInterface.PanelPatient;

import Controllers.DoctorController;
import Controllers.PatientController;
import Data.Connection;
import Model.Doctor;
import GraphicInterface.Components.GeneralPanel;
import GraphicInterface.Menu.PanelMenu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import GraphicInterface.Components.Frame;

public class PanelIllnessAndDrugs extends GeneralPanel {

    private static JComboBox ComboBoxDoctors = new JComboBox<>();
    private static Doctor doctor;

    public static Doctor getDoctor() {
        return doctor;
    }

    public PanelIllnessAndDrugs() throws IOException {

        JLabel LabelRateDoctor = new JLabel("Rate our doctors");
        JButton ButtonRateDoctor = new JButton("Rate");
        JButton ButtonIllnessHistory = new JButton("History of diseases");
        JButton ButtonAppointments = new JButton("My appointments");
        for (int i = 0; i < Connection.getDoctors().size(); i++) {
            ComboBoxDoctors.addItem(DoctorController.getAllDoctors().get(i).getFirstName() + " " + DoctorController.getAllDoctors().get(i).getSurname());
        }
        ButtonIllnessHistory.addActionListener(a -> {
            try {
                if (PatientController.showDiagnoses().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No diagnoses", "",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    WindowIllnessHistory.createAndShowGui();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        ButtonIllnessHistory.setFont(new Font("Now", Font.BOLD, 20));
        add(ButtonIllnessHistory, getC(5, 7, 0, 0, 0, 0));
        add(ButtonLogOut, getC(14, 1, 0, 0, 0, 0));
        add(LabelRateDoctor, getC(5, 9, 0, 0, 0, 0));
        add(ComboBoxDoctors, getC(5, 10, 0, 0, 0, 0));
        add(ButtonRateDoctor, getC(6, 10, 0, 0, 0, 0));
        add(ButtonAppointments, getC(5, 5, 0, 0, 0, 0));
        ButtonAppointments.setFont(new Font("Nul", Font.BOLD, 20));
        ButtonAppointments.addActionListener(e -> {
            try {
                if (PatientController.getAppointments(PatientController.loggedPatient()).size() == 0) {
                    JOptionPane.showMessageDialog(null, "No appointments", "",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    WindowCheckMyAppointments.createAndShowGui();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ButtonRateDoctor.addActionListener(e -> {
            PatientController.setDoctor(Connection.getDoctors().get(ComboBoxDoctors.getSelectedIndex()));
            try {
                WindowGiveOpinion.LevelBar.setClicked(-1);
                WindowGiveOpinion.createAndShowGui();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ButtonLogOut.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelMenu());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
