package Controllers;

import GraphicInterface.Menu.RegisterPanel;

import javax.swing.*;
import java.awt.*;

public class RegisterController {
    public static JTextField getName() {
        return RegisterPanel.getTextFieldName();
    }

    public static JTextField getSurname() {
        return RegisterPanel.getTextFieldSurname();
    }

    public static JTextField getPassword() {
        return RegisterPanel.getTextFieldPassword();
    }

    public static JTextField getHeight() {
        return RegisterPanel.getTextFieldHeight();
    }

    public static JTextField getWeight() {
        return RegisterPanel.getTextFieldWeight();
    }

    public static JTextField getBloodType() {
        return RegisterPanel.getTextFieldBloodType();
    }

    public static JTextField getCity() {
        return RegisterPanel.getTextFieldCity();
    }

    public static JTextField getBirth() {
        return RegisterPanel.getTextFieldDateOfBirth();
    }

    public static JTextField getDoctorID() {
        return RegisterPanel.getTextFieldDoctorID();
    }

    public static JTextField getEmailAdress() {
        return RegisterPanel.getTextFieldEmailAdress();
    }

    public static JTextField getHouseNumber() {
        return RegisterPanel.getTextFieldHouseNumber();
    }

    public static JTextField getPhoneNumber() {
        return RegisterPanel.getTextFieldPhoneNumber();
    }

    public static JTextField getStreet() {
        return RegisterPanel.getTextFieldStreet();
    }

    public static JTextField getPersonalId() {
        return RegisterPanel.getTextFieldPersonalID();
    }

    public static void SetRed(JComponent text) {
        text.setBackground(Color.RED);
    }

    public static void SetWhite(JComponent text) {
        text.setBackground(Color.WHITE);
    }

    public static JComboBox getComboBoxBlood() {
        return RegisterPanel.getComboBoxBloodGroup();
    }

    public static JComboBox getComboBoxSpecialization() {
        return RegisterPanel.getComboBoxSpecialities();
    }

    public static char getGender() {
        return RegisterPanel.getGender();
    }

    public static JRadioButton getMezczyzna() {
        return RegisterPanel.getRadioButtonMan();
    }

    public static JRadioButton getKobieta() {
        return RegisterPanel.getRadioButtonWoman();
    }
}
