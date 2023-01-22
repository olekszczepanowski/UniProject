package GraphicInterface.Menu;

import Controllers.DoctorController;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class PanelLoginDoctor extends GeneralPanel {

    private static JTextField TextFieldIDDoctor = new JTextField();
    private static JPasswordField TextFieldPasswordDoctor = new JPasswordField();

    public static JTextField getTextFieldIDDoctor() {
        return TextFieldIDDoctor;
    }

    public static JPasswordField getTextFieldPasswordDoctor() {
        return TextFieldPasswordDoctor;
    }

    private static JLabel LabelIncorrectData = new JLabel("Invalid ID or password");

    public static JLabel getLabelIncorrectData() {
        return LabelIncorrectData;
    }

    public PanelLoginDoctor() throws IOException {

        JButton ButtonLogin = new JButton("Log in");

        JLabel LabelLoginDoctor = new JLabel("Doctor Log in");
        JLabel LabelPersonalID = new JLabel("ID");
        JLabel LabelPassword = new JLabel("Password");
        LabelIncorrectData.setForeground(Color.RED);
        LabelIncorrectData.setVisible(false);
        TextFieldPasswordDoctor.setText("");
        TextFieldIDDoctor.setText("");

        ButtonLogin.addActionListener(e -> {
            try {
                DoctorController.doctorLogin();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        TextFieldPasswordDoctor.setEchoChar('*');

        JCheckBox CheckBoxShowPassword = new JCheckBox("Show password");
        CheckBoxShowPassword.setOpaque(false);

        CheckBoxShowPassword.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    TextFieldPasswordDoctor.setEchoChar((char) 0);
                } else {
                    TextFieldPasswordDoctor.setEchoChar('*');
                }
            }
        });
        //todo na dole z lambdą
//        CheckBoxShowPassword.addItemListener(e -> {
//            if (e.getStateChange() == ItemEvent.SELECTED) {
//                TextFieldPasswordDoctor.setEchoChar((char) 0);
//            } else {
//                TextFieldPasswordDoctor.setEchoChar('*');
//            }
//        });

        add(CheckBoxShowPassword, getC(8, 7, 0, 0, 0, 0));
        add(LabelLoginDoctor, getC(7, 3, 0, 0, 10, 10));
        add(LabelPersonalID, getC(7, 4, 0, 0, 10, 10));
        add(TextFieldIDDoctor, getC(7, 5, 0, 0, 10, 10));
        add(LabelPassword, getC(7, 6, 0, 0, 10, 10));
        add(TextFieldPasswordDoctor, getC(7, 7, 0, 0, 10, 10));
        add(LabelIncorrectData, getC(7, 8, 0, 0, 0, 0));
        add(ButtonLogin, getC(7, 9, 0, 0, 10, 10));
        add(getButtonReturn(), getC(1, 14, 0, 0, 0, 0));
    }
}
