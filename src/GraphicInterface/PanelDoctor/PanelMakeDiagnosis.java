package GraphicInterface.PanelDoctor;

import Controllers.DoctorController;
import Controllers.PatientController;
import Model.Patient;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.io.IOException;

public class PanelMakeDiagnosis extends GeneralPanel {
    private static JTextField TextfieldDrugprice = new JTextField();
    private static JLabel LabelDrugprice = new JLabel("Medicine price");
    private static JTextField TextfieldDrug = new JTextField();
    private static JLabel LabelDrug = new JLabel("Medicine name");
    private static JTextField TextfieldCondition = new JTextField();
    private static JLabel LabelCondition = new JLabel("For what condition");
    private static JComboBox<String> Patients = new JComboBox<String>();

    public static JTextField getTextfieldDrugprice() {
        return TextfieldDrugprice;
    }

    public static JLabel getLabelDrugprice() {
        return LabelDrugprice;
    }

    public static JTextField getTextfieldDrug() {
        return TextfieldDrug;
    }

    public static JLabel getLabelDrug() {
        return LabelDrug;
    }

    public static JTextField getTextfieldCondition() {
        return TextfieldCondition;
    }

    public static JLabel getLabelCondition() {
        return LabelCondition;
    }

    private static JButton buttonadd = new JButton("Add medicine");

    public PanelMakeDiagnosis() throws IOException {
        for (Patient patient : PatientController.getAllPatients()) {
            Patients.addItem(patient.getFirstName() + " " + patient.getSurname());
        }
        JButton confirm = new JButton("Confirm");
        add(LabelCondition, getC(5, 4, 0, 0, 0, 0));
        add(TextfieldDrug, getC(6, 6, 0, 0, 0, 0));
        add(LabelDrug, getC(5, 6, 0, 0, 0, 0));
        add(TextfieldCondition, getC(6, 4, 0, 0, 0, 0));
        add(LabelDrugprice, getC(5, 8, 0, 0, 0, 0));
        add(TextfieldDrugprice, getC(6, 8, 0, 0, 0, 0));
        add(buttonadd, getC(6, 10, 0, 0, 0, 0));
        add(confirm, getC(5, 10, 0, 0, 0, 0));
        buttonadd.addActionListener(e -> {
            try {
                DoctorController.addMedicine(false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        confirm.addActionListener(e -> {
            try {
                DoctorController.addMedicine(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
