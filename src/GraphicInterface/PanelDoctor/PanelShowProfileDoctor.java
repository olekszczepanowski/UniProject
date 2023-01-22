package GraphicInterface.PanelDoctor;

import Controllers.DoctorController;
import Data.UserAccount;
import GraphicInterface.Components.GeneralPanel;
import GraphicInterface.Menu.PanelMenu;
import GraphicInterface.Menu.RegisterPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;

import GraphicInterface.Components.Frame;

public class PanelShowProfileDoctor extends GeneralPanel {

    public PanelShowProfileDoctor() throws IOException {

        JButton ButtonLogout = new JButton("Logout");
        JButton ButtonChangePhone = new JButton("Change");
        JButton ButtonChangeAdress = new JButton("Change");
        JButton ButtonChangeEmail = new JButton("Change");
        JButton ButtonConfirm = new JButton("Confirm changes");
        ButtonConfirm.setVisible(false);

        JLabel LabelGender = new JLabel("Gender:");
        JLabel LabelgetGender = new JLabel(String.valueOf(DoctorController.loggedDoctor().getGender()).toUpperCase(Locale.ROOT));
        JLabel LabelShowProfile = new JLabel("Your Profile");
        LabelShowProfile.setFont(new Font("Now", Font.BOLD, 20));

        JLabel LabelNameAndSurname = new JLabel("Full Name: ");
        JLabel LabelgetNameAndSurname = new JLabel(DoctorController.loggedDoctor().getFirstName() + " " + DoctorController.loggedDoctor().getSurname());

        JLabel LabelSpetialization = new JLabel("Specialization: ");
        JLabel LabelgetSpetialization = new JLabel(DoctorController.loggedDoctor().getSpecialization().getName());

        JLabel LabelEmailAdress = new JLabel("E-mail address: ");
        JLabel LabelgetAdresEmail = new JLabel(DoctorController.loggedDoctor().getEmail());
        JTextField TextFieldEmailAdress = new JTextField(LabelgetAdresEmail.getText());
        TextFieldEmailAdress.setVisible(false);

        JLabel LabelPhone = new JLabel("Phone Number: ");
        JLabel LabelgetPhone = new JLabel(DoctorController.loggedDoctor().getContactNumber());
        JTextField TextFieldPhone = new JTextField(LabelgetPhone.getText());
        TextFieldPhone.setVisible(false);

        JLabel LabelAdress = new JLabel("Adress: ");
        JLabel LabelgetAdress = new JLabel(DoctorController.loggedDoctor().getCity() + " " + DoctorController.loggedDoctor().getStreet() + " " + DoctorController.loggedDoctor().getHouseNumber());
        JTextField TextFieldAdress = new JTextField(LabelgetAdress.getText());
        TextFieldAdress.setVisible(false);

        JLabel LabelPersonalID = new JLabel("Personal ID Number: ");
        JLabel LabelgetPersonalID = new JLabel(DoctorController.loggedDoctor().getPersonalIdNumber());

        String password = RegisterPanel.getTextFieldPassword().getText();

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
                DoctorController.changeEmail(email, DoctorController.loggedDoctor());
                LabelgetAdresEmail.setText(UserAccount.getLoggedDoctor().getEmail());
                repaint();
                TextFieldEmailAdress.setText(LabelgetAdresEmail.getText());
                ButtonChangeEmail.setVisible(true);
                TextFieldEmailAdress.setVisible(false);
                LabelgetAdresEmail.setVisible(true);
            }

            if (TextFieldPhone.isVisible()) {
                ButtonChangePhone.setVisible(true);
                String contactNumber = TextFieldPhone.getText();
                DoctorController.changePhoneNumber(contactNumber, DoctorController.loggedDoctor());
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
        add(ButtonChangePhone, getC(6, 8, 0, 0, 0, -10));
        add(LabelNameAndSurname, getC(10, 2, 0, 0, 0, 0));
        add(LabelgetNameAndSurname, getC(10, 3, 0, 0, 0, 0));
        add(LabelGender, getC(11, 2, 0, 0, 0, 0));
        add(LabelgetGender, getC(11, 3, 0, 0, 0, 0));
        add(LabelSpetialization, getC(10, 8, 0, 0, 0, 0));
        add(LabelgetSpetialization, getC(10, 9, 0, 0, 0, 0));
        add(LabelEmailAdress, getC(10, 5, 0, 0, 100, 0));
        add(LabelgetAdresEmail, getC(10, 6, 0, 0, 0, 0));
        add(TextFieldEmailAdress, getC(10, 6, 0, 0, 0, -10));
        add(ButtonChangeEmail, getC(11, 5, 0, 0, 0, -10));
        add(ButtonConfirm, getC(7, 14, 0, 0, 0, -10));
        add(ButtonLogout, getC(14, 1, 0, 0, 0, 0));
    }
}
