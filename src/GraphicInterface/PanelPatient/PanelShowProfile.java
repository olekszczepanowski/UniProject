package GraphicInterface.PanelPatient;

import Controllers.PatientController;
import GraphicInterface.Components.GeneralPanel;
import GraphicInterface.Menu.PanelMenu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;

import GraphicInterface.Components.Frame;

public class PanelShowProfile extends GeneralPanel {

    public PanelShowProfile() throws IOException {

        JButton ButtonLogout = new JButton("Log out");
        JButton ButtonChangePhone = new JButton("Change");
        JButton ButtonChangeWeight = new JButton("Change");
        JButton ButtonChangeHeight = new JButton("Change");
        JButton ButtonChangeAdress = new JButton("Change");
        JButton ButtonChangeEmail = new JButton("Change");
        JButton ButtonConfirm = new JButton("Confirm changes");
        ButtonConfirm.setVisible(false);

        JLabel LabelGender = new JLabel("Gender: ");
        JLabel LabelgetGender = new JLabel(String.valueOf(PatientController.loggedPatient().getGender()).toUpperCase(Locale.ROOT));
        JLabel LabelShowProfile = new JLabel("Your profile");
        LabelShowProfile.setFont(new Font("Now", Font.BOLD, 20));

        JLabel LabelNameAndSurname = new JLabel("Full name: ");
        JLabel LabelgetNameAndSurname = new JLabel(PatientController.loggedPatient().getFirstName() + " " + PatientController.loggedPatient().getSurname());

        JLabel LabelEmailAdress = new JLabel("E-mail address: ");
        JLabel LabelgetAdresEmail = new JLabel(PatientController.loggedPatient().getEmail());
        JTextField TextFieldEmailAdress = new JTextField(LabelgetAdresEmail.getText());
        TextFieldEmailAdress.setVisible(false);

        JLabel LabelBloodType = new JLabel("Blood Group: ");
        JLabel LabelgetBloodType = new JLabel(PatientController.loggedPatient().getBloodGroup());

        JLabel LabelPhone = new JLabel("Phone number: ");
        JLabel LabelgetPhone = new JLabel(PatientController.loggedPatient().getContactNumber());
        JTextField TextFieldPhone = new JTextField(LabelgetPhone.getText());
        TextFieldPhone.setVisible(false);

        JLabel LabelAdress = new JLabel("Address: ");
        JLabel LabelgetAdress = new JLabel(PatientController.loggedPatient().getCity() + " " + PatientController.loggedPatient().getStreet()
                + " " + PatientController.loggedPatient().getHouseNumber());
        JTextField TextFieldAdress = new JTextField(LabelgetAdress.getText());
        TextFieldAdress.setVisible(false);

        JLabel LabelWeight = new JLabel("Weight: ");
        JLabel LabelgetWeight = new JLabel(PatientController.loggedPatient().getWeight() + " kg");
        JTextField TextFieldWeight = new JTextField();
        TextFieldWeight.setVisible(false);

        JLabel LabelHeight = new JLabel("Height: ");
        JLabel LabelgetHeight = new JLabel(PatientController.loggedPatient().getHeight() + " cm");
        JTextField TextFieldHeight = new JTextField();
        TextFieldHeight.setVisible(false);

        JLabel LabelPersonalID = new JLabel("Personal ID number: ");
        JLabel LabelgetPersonalID = new JLabel(PatientController.loggedPatient().getPersonalIdNumber());

        ButtonChangeAdress.addActionListener(e -> {
            LabelgetAdress.setVisible(false);
            ButtonChangeAdress.setVisible(false);
            TextFieldAdress.setVisible(true);
            ButtonConfirm.setVisible(true);
        });
        ButtonChangeEmail.addActionListener(e -> {
            LabelgetAdresEmail.setVisible(false);
            TextFieldEmailAdress.setVisible(true);
            ButtonChangeEmail.setVisible(false);
            ButtonConfirm.setVisible(true);
        });
        ButtonChangeWeight.addActionListener(e -> {
            LabelgetWeight.setVisible(false);
            TextFieldWeight.setVisible(true);
            ButtonChangeWeight.setVisible(false);
            ButtonConfirm.setVisible(true);
        });
        ButtonChangeHeight.addActionListener(e -> {
            LabelgetHeight.setVisible(false);
            TextFieldHeight.setVisible(true);
            ButtonChangeHeight.setVisible(false);
            ButtonConfirm.setVisible(true);
        });
        ButtonChangePhone.addActionListener(e -> {
            LabelgetPhone.setVisible(false);
            ButtonChangePhone.setVisible(false);
            TextFieldPhone.setVisible(true);
            ButtonConfirm.setVisible(true);
        });
        ButtonChangeAdress.addActionListener(e -> {
            LabelgetAdress.setVisible(false);
            TextFieldAdress.setVisible(true);
            ButtonChangeAdress.setVisible(false);
            ButtonConfirm.setVisible(true);
        });
        ButtonConfirm.addActionListener(e -> {
            if (TextFieldAdress.isVisible()) {
                LabelgetAdress.setText(TextFieldAdress.getText());
                ButtonChangeAdress.setVisible(true);
                TextFieldAdress.setVisible(false);
                LabelgetAdress.setVisible(true);
            }
            if (TextFieldEmailAdress.isVisible()) {
                String email = TextFieldEmailAdress.getText();
                PatientController.changeEmail(email, PatientController.loggedPatient());
                LabelgetAdresEmail.setText(PatientController.loggedPatient().getEmail());
                repaint();
                TextFieldEmailAdress.setText(LabelgetAdresEmail.getText());
                ButtonChangeEmail.setVisible(true);
                TextFieldEmailAdress.setVisible(false);
                LabelgetAdresEmail.setVisible(true);
            }
            if (TextFieldWeight.isVisible()) {
                try {
                    int weight = Integer.parseInt(TextFieldWeight.getText());
                    PatientController.changeWeight(weight, PatientController.loggedPatient());
                    LabelgetWeight.setText(weight + " kg");
                    TextFieldWeight.setText(String.valueOf(weight));
                } catch (NumberFormatException exception) {
                    exception.printStackTrace();
                }
                ButtonChangeWeight.setVisible(true);
                TextFieldWeight.setVisible(false);
                LabelgetWeight.setVisible(true);
            }
            if (TextFieldHeight.isVisible()) {
                try {
                    int height = Integer.parseInt(TextFieldHeight.getText());
                    PatientController.changeHeight(height, PatientController.loggedPatient());
                    LabelgetHeight.setText(height + " cm");
                } catch (NumberFormatException exception) {
                    exception.printStackTrace();
                }
                TextFieldHeight.setText(LabelgetHeight.getText());
                ButtonChangeHeight.setVisible(true);
                TextFieldHeight.setVisible(false);
                LabelgetHeight.setVisible(true);
            }
            if (TextFieldPhone.isVisible()) {
                ButtonChangePhone.setVisible(true);
                String contactNumber = TextFieldPhone.getText();
                PatientController.changePhoneNumber(contactNumber, PatientController.loggedPatient());
                LabelgetPhone.setText(contactNumber);
                repaint();
                TextFieldPhone.setText(LabelgetPhone.getText());
                TextFieldPhone.setVisible(false);
                LabelgetPhone.setVisible(true);
            }
            ButtonConfirm.setVisible(false);
        });
        ButtonLogout.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelMenu());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        add(LabelShowProfile, getC(7, 0, 0, 0, 0, 0));
        add(LabelPersonalID, getC(5, 2, 0, 0, 0, 0));
        add(LabelgetPersonalID, getC(5, 3, 0, 0, 0, 0));
        add(LabelAdress, getC(5, 5, 0, 0, 0, 0));
        add(LabelgetAdress, getC(5, 6, 0, 0, 0, 0));
        add(TextFieldAdress, getC(5, 6, 0, 0, 0, 0));
        add(ButtonChangeAdress, getC(6, 5, 0, 0, 0, -10));
        add(LabelPhone, getC(5, 8, 0, 0, 0, 0));
        add(LabelgetPhone, getC(5, 9, 0, 0, 0, 0));
        add(TextFieldPhone, getC(5, 9, 0, 0, 0, 0));
        add(LabelBloodType, getC(5, 11, 0, 0, 0, 0));
        add(LabelgetBloodType, getC(5, 12, 0, 0, 0, 0));
        add(ButtonChangePhone, getC(6, 8, 0, 0, 0, -10));
        add(LabelNameAndSurname, getC(10, 2, 0, 0, 0, 0));
        add(LabelgetNameAndSurname, getC(10, 3, 0, 0, 0, 0));
        add(LabelGender, getC(11, 2, 0, 0, 0, 0));
        add(LabelgetGender, getC(11, 3, 0, 0, 0, 0));
        add(LabelEmailAdress, getC(10, 5, 0, 0, 100, 0));
        add(LabelgetAdresEmail, getC(10, 6, 0, 0, 0, 0));
        add(TextFieldEmailAdress, getC(10, 6, 0, 0, 0, -10));
        add(ButtonChangeEmail, getC(11, 5, 0, 0, 0, -10));
        add(LabelWeight, getC(10, 8, 0, 0, 0, 0));
        add(LabelgetWeight, getC(10, 9, 0, 0, 0, 0));
        add(TextFieldWeight, getC(10, 9, 0, 0, 0, 0));
        add(ButtonChangeWeight, getC(11, 8, 0, 0, 0, -10));
        add(LabelHeight, getC(10, 11, 0, 0, 0, 0));
        add(LabelgetHeight, getC(10, 12, 0, 0, 0, 0));
        add(TextFieldHeight, getC(10, 12, 0, 0, 0, 0));
        add(ButtonChangeHeight, getC(11, 11, 0, 0, 0, -10));
        add(ButtonConfirm, getC(7, 14, 0, 0, 0, -10));
        add(ButtonLogout, getC(14, 1, 0, 0, 0, 0));
    }
}
