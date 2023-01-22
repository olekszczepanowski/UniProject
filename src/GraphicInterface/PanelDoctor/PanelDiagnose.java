package GraphicInterface.PanelDoctor;

import Controllers.DoctorController;
import Controllers.PatientController;
import Model.Patient;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.io.IOException;

public class PanelDiagnose extends GeneralPanel {
    private static JTextField TextfieldDrugprice = new JTextField();
    private static JLabel LabelDiagnose = new JLabel("Diagnose");
    private static JTextField TextfieldDiagnose = new JTextField();
    private static JLabel LabelRecommendation = new JLabel("Recommendation");
    private static JTextField TextfieldRecommendation = new JTextField();
    private static JLabel LabelPatient = new JLabel("Patient");
    private static JComboBox<String> Patients = new JComboBox<String>();

    public static JTextField getTextfieldDiagnose() {
        return TextfieldDiagnose;
    }

    public static JComboBox<String> getPatients() {
        return Patients;
    }

    public PanelDiagnose() throws IOException {
        for (Patient patient : PatientController.getAllPatients()) {
            Patients.addItem(patient.getFirstName() + " " + patient.getSurname());
        }
        JButton confirm = new JButton("Confirm");
        add(LabelPatient, getC(5, 4, 0, 0, 0, 0));
        add(TextfieldDiagnose, getC(6, 6, 0, 0, 0, 0));
        add(LabelDiagnose, getC(5, 6, 0, 0, 0, 0));
        add(LabelRecommendation, getC(5, 8, 0, 0, 0, 0));
        add(TextfieldRecommendation, getC(6, 8, 0, 0, 0, 0));
        add(Patients, getC(6, 4, 0, 0, 0, 0));
        add(confirm, getC(5, 10, 0, 0, 0, 0));
        confirm.addActionListener(e -> {
            try {
                DoctorController.addDiagnosis();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
