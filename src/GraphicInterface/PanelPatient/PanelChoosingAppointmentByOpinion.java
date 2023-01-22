package GraphicInterface.PanelPatient;

import Controllers.DoctorController;
import Controllers.SortingController;
import Model.Doctor;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import GraphicInterface.Components.Frame;
import GraphicInterface.Components.Picker;

public class PanelChoosingAppointmentByOpinion extends GeneralPanel {
    private static String text = "";

    public static void setText(String text) {
        PanelChoosingAppointmentByOpinion.text = text;
    }

    private static String speciality;
    private static Doctor doctor;

    public static String getSpeciality() {
        return speciality;
    }

    public static Doctor getDoctor() {
        return doctor;
    }

    public PanelChoosingAppointmentByOpinion(String spetialization) throws IOException {

        JLabel LabelShowDoctorList = new JLabel("Show doctor list");
        JLabel LabelDoctorType = new JLabel(spetialization);
        LabelShowDoctorList.setFont(new Font("Arial", Font.BOLD, 22));
        JButton ButtonReturn = new JButton("Return");
        ButtonReturn.addActionListener(e -> {
            try {
                Frame.getFrame().setTab(new PanelPatient());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int y = 0;
        for (int i = 0; i < SortingController.SortByOpinion(spetialization).size(); i++) {
            doctor = DoctorController.getAllDoctors().get(i);
            JButton buttonDoctor = new JButton(DoctorController.getAllDoctors().get(i).getFirstName() + " " + DoctorController.getAllDoctors().get(i).getSurname());
            JLabel LabelOpinion = new JLabel(String.valueOf(DoctorController.getAllDoctors().get(i).getAverageOpinion()));
            add(buttonDoctor, getC(6, 6 + 2 * y, 0, 0, 0, 0));
            add(LabelOpinion, getC(7, 6 + 2 * y, 0, 0, 0, 0));
            buttonDoctor.addActionListener(e -> {
                new Picker(doctor);
            });
            y++;
        }
        add(LabelShowDoctorList, getC(6, 2, 0, 0, 0, 0));
        add(LabelDoctorType, getC(6, 4, 0, 0, 0, 0));
        add(ButtonReturn, getC(1, 14, 0, 0, 0, 0));
    }
}
