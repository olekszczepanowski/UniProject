package GraphicInterface.Menu;

import Controllers.PatientController;
import Data.UserAccount;
import GraphicInterface.Components.Frame;
import GraphicInterface.Components.GeneralPanel;
import GraphicInterface.PanelPatient.PanelPatient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.IOException;

public class PanelLoginPatient extends GeneralPanel {

    private static JButton ButtonLogin = new JButton("Log in");
    private static JButton ButtonReturn = new JButton("<-");

    private static JLabel LabelLoginPatient = new JLabel("Patient log in");
    private static JLabel LabelPersonalID = new JLabel("Personal ID number");
    private static JLabel LabelPassword = new JLabel("Password");
    private static JLabel LabelIncorrectData = new JLabel("Invalid id number or password");

    private static final JTextField TextFieldPersonalIDPatient = new JTextField();
    private static final JPasswordField TextFieldPasswordPatient = new JPasswordField();

    public static JTextField getTextFieldPersonalIDPatient() {
        return TextFieldPersonalIDPatient;
    }

    public static JPasswordField getTextFieldPasswordPatient() {
        return TextFieldPasswordPatient;
    }

    public PanelLoginPatient() throws IOException {

        LabelIncorrectData.setForeground(Color.RED);
        LabelIncorrectData.setVisible(false);
        TextFieldPasswordPatient.setText("");
        TextFieldPersonalIDPatient.setText("");
        ButtonReturn.addActionListener(e -> {
            try {
                Frame.getFrame().set(new PanelMenu());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ButtonLogin.addActionListener(e -> {
            PatientController.patientLogin();
            if (UserAccount.getLoggedPatient() != null) {
                try {
                    Frame.getFrame().setTab(new PanelPatient());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                LabelIncorrectData.setVisible(true);
                repaint();
            }
        });
        TextFieldPasswordPatient.setEchoChar('*');

        JCheckBox CheckBoxViewPassword = new JCheckBox("Show password");
        CheckBoxViewPassword.setOpaque(false);

        CheckBoxViewPassword.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                TextFieldPasswordPatient.setEchoChar((char) 0);
            } else {
                TextFieldPasswordPatient.setEchoChar('*');
            }
        });
        //todo to też można ulepszyc stream/lambda
//        CheckBoxViewPassword.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    TextFieldPasswordPatient.setEchoChar((char) 0);
//                } else {
//                    TextFieldPasswordPatient.setEchoChar('*');
//                }
//            }
//        });

        add(CheckBoxViewPassword, getC(8, 7, 0, 0, 0, 0));

        add(LabelLoginPatient, getC(7, 3, 0, 0, 10, 10));

        add(LabelPersonalID, getC(7, 4, 0, 0, 10, 10));

        add(TextFieldPersonalIDPatient, getC(7, 5, 0, 0, 10, 10));

        add(LabelPassword, getC(7, 6, 0, 0, 10, 10));

        add(TextFieldPasswordPatient, getC(7, 7, 0, 0, 10, 10));

        add(LabelIncorrectData, getC(7, 8, 0, 0, 0, 0));

        add(ButtonLogin, getC(7, 9, 0, 0, 10, 10));

        add(getButtonReturn(), getC(1, 14, 0, 0, 0, 0));
    }
}
