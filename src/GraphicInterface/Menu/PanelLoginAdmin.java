package GraphicInterface.Menu;

import Controllers.AdminController;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.IOException;

public class PanelLoginAdmin extends GeneralPanel {

    private static JTextField TextFieldIDAdmin = new JTextField();
    private static JPasswordField TextFieldPasswordAdmin = new JPasswordField();
    private static JLabel LabelIncorrectData = new JLabel("Invalid ID or password");

    public PanelLoginAdmin() throws IOException {
        TextFieldIDAdmin.setText("");
        TextFieldPasswordAdmin.setText("");

        JButton ButtonLogin = new JButton("Log in");

        JLabel LabelLoginAdmin = new JLabel("Admin Log in:");
        JLabel LabelPersonalID = new JLabel("ID");
        JLabel LabelPassword = new JLabel("Password");
        LabelIncorrectData.setForeground(Color.RED);
        LabelIncorrectData.setVisible(false);

        ButtonLogin.addActionListener(e -> {
            try {
                AdminController.adminLogin();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        TextFieldPasswordAdmin.setEchoChar('*');

        JCheckBox CheckBoxShowPassword = new JCheckBox("Show password");
        CheckBoxShowPassword.setOpaque(false);

        CheckBoxShowPassword.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                TextFieldPasswordAdmin.setEchoChar((char) 0);
            } else {
                TextFieldPasswordAdmin.setEchoChar('*');
            }
        });

        add(CheckBoxShowPassword, getC(8, 7, 0, 0, 0, 0));
        add(LabelLoginAdmin, getC(7, 3, 0, 0, 10, 10));
        add(LabelPersonalID, getC(7, 4, 0, 0, 10, 10));
        add(TextFieldIDAdmin, getC(7, 5, 0, 0, 10, 10));
        add(LabelPassword, getC(7, 6, 0, 0, 10, 10));
        add(TextFieldPasswordAdmin, getC(7, 7, 0, 0, 10, 10));
        add(LabelIncorrectData, getC(7, 8, 0, 0, 0, 0));
        add(ButtonLogin, getC(7, 9, 0, 0, 10, 10));
        add(getButtonReturn(), getC(1, 14, 0, 0, 0, 0));
    }

    public static JTextField getTextFieldIDAdmin() {
        return TextFieldIDAdmin;
    }

    public static JPasswordField getTextFieldPasswordAdmin() {
        return TextFieldPasswordAdmin;
    }

    public static JLabel getLabelIncorrectData() {
        return LabelIncorrectData;
    }
}
