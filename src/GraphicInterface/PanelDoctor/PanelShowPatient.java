package GraphicInterface.PanelDoctor;

import Controllers.DoctorController;
import Model.Patient;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.Locale;

public class PanelShowPatient extends GeneralPanel {
    private static final HintTextField TextfieldSearch = new HintTextField("Personal ID");
    private static final JButton ButtonSearch = new JButton("Search");

    public PanelShowPatient() throws IOException {
        JLabel LabelGender = new JLabel("Gender:");
        JLabel LabelgetGender = new JLabel("");
        JLabel LabelNameAndSurname = new JLabel("Name: ");
        JLabel LabelgetNameAndSurname = new JLabel("");
        JLabel LabelEmailAdress = new JLabel("Adress Email: ");
        JLabel LabelgetAdresEmail = new JLabel("");
        JLabel LabelBloodType = new JLabel("Blood group: ");
        JLabel LabelgetBloodType = new JLabel("");
        JLabel LabelPhone = new JLabel("Phone number: ");
        JLabel LabelgetPhone = new JLabel("");
        JLabel LabelAdress = new JLabel("Address: ");
        JLabel LabelgetAdress = new JLabel("");
        JLabel LabelWeight = new JLabel("Weight: ");
        JLabel LabelgetWeight = new JLabel("");
        JLabel LabelHeight = new JLabel("Height: ");
        JLabel LabelgetHeight = new JLabel("");
        JLabel LabelPersonalID = new JLabel("Personal ID: ");
        JLabel LabelgetPersonalID = new JLabel("");
        JComponent[] component = {LabelGender, LabelgetGender, LabelNameAndSurname, LabelgetNameAndSurname, LabelEmailAdress,
                LabelgetAdresEmail, LabelBloodType, LabelgetBloodType, LabelPhone, LabelgetPhone, LabelAdress, LabelgetAdress,
                LabelWeight, LabelgetWeight, LabelHeight, LabelgetHeight, LabelPersonalID, LabelgetPersonalID};
        for (JComponent object : component) {
            object.setVisible(false);
        }
        add(LabelPersonalID, getC(5, 2, 0, 0, 0, 0));
        add(LabelgetPersonalID, getC(5, 3, 0, 0, 0, 0));
        add(LabelAdress, getC(5, 5, 0, 0, 0, 0));
        add(LabelgetAdress, getC(5, 6, 0, 0, 0, 0));
        add(LabelPhone, getC(5, 8, 0, 0, 0, 0));
        add(LabelgetPhone, getC(5, 9, 0, 0, 0, 0));
        add(LabelBloodType, getC(5, 11, 0, 0, 0, 0));
        add(LabelgetBloodType, getC(5, 12, 0, 0, 0, 0));
        add(LabelNameAndSurname, getC(10, 2, 0, 0, 0, 0));
        add(LabelgetNameAndSurname, getC(10, 3, 0, 0, 0, 0));
        add(LabelGender, getC(11, 2, 0, 0, 0, 0));
        add(LabelgetGender, getC(11, 3, 0, 0, 0, 0));
        add(LabelEmailAdress, getC(10, 5, 0, 0, 100, 0));
        add(LabelgetAdresEmail, getC(10, 6, 0, 0, 0, 0));
        add(LabelWeight, getC(10, 8, 0, 0, 0, 0));
        add(LabelgetWeight, getC(10, 9, 0, 0, 0, 0));
        add(LabelHeight, getC(10, 11, 0, 0, 0, 0));
        add(LabelgetHeight, getC(10, 12, 0, 0, 0, 0));
        ButtonSearch.addActionListener(e -> {
            Patient patient = DoctorController.searchPatient(TextfieldSearch.getText());
            if (patient != null) {
                LabelgetGender.setText(String.valueOf(patient.getGender()).toUpperCase(Locale.ROOT));
                LabelgetNameAndSurname.setText(patient.getFirstName() + " " + patient.getSurname());
                LabelgetAdresEmail.setText(patient.getEmail());
                LabelgetBloodType.setText(patient.getBloodGroup());
                LabelgetPhone.setText(patient.getContactNumber());
                LabelgetAdress.setText(patient.getCity() + " " + patient.getStreet() + " " + patient.getHouseNumber());
                LabelgetWeight.setText(patient.getWeight() + " kg");
                LabelgetHeight.setText(patient.getHeight() + " cm");
                LabelgetPersonalID.setText(patient.getPersonalIdNumber());
                revalidate();
                repaint();
                for (JComponent object : component)
                    object.setVisible(true);
            } else {
                for (JComponent object : component)
                    object.setVisible(false);
                JOptionPane.showMessageDialog(null, "Patient with this ID not found", "",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        add(ButtonSearch, getC(8, 1, 0, 0, 0, 0));
        add(TextfieldSearch, getC(7, 1, 0, 0, 100, 0));
    }
}
