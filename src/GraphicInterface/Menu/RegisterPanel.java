package GraphicInterface.Menu;

import Controllers.DoctorController;
import Controllers.PatientController;
import GraphicInterface.Components.EmptyPanel;
import GraphicInterface.Components.GeneralPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RegisterPanel extends GeneralPanel {

    private static JLabel LabelRegistration = new JLabel("<html>Register<br/> as Patient</html");
    private static JLabel LabelName = new JLabel("Name: ");
    private static JTextField TextFieldName = new JTextField();
    private static JLabel LabelEmailAdress = new JLabel("E-mail address: ");
    private static JTextField TextFieldEmailAdress = new JTextField();
    private static JLabel LabelDoctorID = new JLabel("ID: ");
    private static JTextField TextFieldDoctorID = new JTextField();
    private static JLabel LabelPhoneNumber = new JLabel("Phone number: ");
    private static JTextField TextFieldPhoneNumber = new JTextField();
    private static JLabel LabelDateOfBirth = new JLabel("Birthdate: ");
    private static JTextField TextFieldDateOfBirth = new HintTextField("YYYY-MM-DD");
    private static JLabel LabelStreet = new JLabel("Residence street: ");
    private static JTextField TextFieldStreet = new JTextField();
    private static JLabel LabelCity = new JLabel("City of Residence: ");
    private static JTextField TextFieldCity = new JTextField();
    private static JLabel LabelFlatAddress = new JLabel("Flat number: ");
    private static JTextField TextFieldHouseNumber = new JTextField();
    private static JLabel LabelWeight = new JLabel("Weight: ");
    private static JTextField TextFieldWeight = new JTextField();
    private static JLabel LabelHeight = new JLabel("Height: ");
    private static JTextField TextFieldHeight = new JTextField();
    private static JLabel LabelBloodType = new JLabel("Blood Group: ");
    private static JTextField TextFieldBloodType = new JTextField();
    private static JLabel LabelSpeciality = new JLabel("Specialization: ");
    private static JLabel LabelSurname = new JLabel("Surname: ");
    private static JTextField TextFieldSurname = new JTextField();
    private static JLabel LabelPassword = new JLabel("Password: ");
    private static JTextField TextFieldPassword = new JTextField();
    private static JLabel LabelPersonalID = new JLabel("Personal ID number: ");
    private static JTextField TextFieldPersonalID = new JTextField();
    private static JLabel LabelChooseGender = new JLabel("Choose gender: ");
    private static JButton ButtonRegister = new JButton("Register");
    private static JRadioButton RadioButtonWoman = new JRadioButton("Female");
    private static JRadioButton RadioButtonMan = new JRadioButton("Male");
    private static ButtonGroup group = new ButtonGroup();
    private static JComboBox ComboBoxBloodGroup = new JComboBox(PatientController.getBloodTypes());

    public static JComboBox getComboBoxBloodGroup() {
        return ComboBoxBloodGroup;
    }

    public static JComboBox ComboBoxSpecialities = new JComboBox<>(DoctorController.getSpecializations());

    public static ButtonGroup getGroup() {
        return group;
    }

    public static JRadioButton getRadioButtonWoman() {
        return RadioButtonWoman;
    }

    public static JRadioButton getRadioButtonMan() {
        return RadioButtonMan;
    }

    public static JTextField getTextFieldDoctorID() {
        return TextFieldDoctorID;
    }

    static JComponent[] ComponentTab = {LabelName, LabelSurname, LabelPhoneNumber, LabelCity, LabelStreet, LabelFlatAddress,
            LabelDateOfBirth, LabelHeight, TextFieldName, TextFieldSurname, TextFieldPhoneNumber, TextFieldCity, TextFieldStreet,
            TextFieldHouseNumber, TextFieldDateOfBirth, TextFieldHeight, LabelSurname, LabelPersonalID, LabelBloodType, LabelWeight,
            LabelChooseGender, RadioButtonWoman, TextFieldEmailAdress, TextFieldPersonalID, TextFieldBloodType, TextFieldWeight,
            new EmptyPanel(), RadioButtonMan, TextFieldPassword, TextFieldDoctorID};

    public static JComponent[] getComponentTab() {
        return ComponentTab;
    }

    public RegisterPanel() throws IOException {
        JButton ButtonAsDoctor = new JButton("As Doctor");
        JButton ButtonAsPatient = new JButton("As Patient");
        ButtonAsDoctor.setEnabled(true);
        ButtonAsPatient.setEnabled(false);
        ComboBoxSpecialities.setVisible(false);
        LabelSpeciality.setVisible(false);
        LabelDoctorID.setVisible(false);
        TextFieldDoctorID.setVisible(false);
        ButtonAsDoctor.addActionListener(e -> {
            LabelRegistration.setText("<html>Register<br/> as Doctor</html");
            ButtonAsDoctor.setEnabled(false);
            ButtonAsPatient.setEnabled(true);
            ComboBoxSpecialities.setVisible(true);
            LabelSpeciality.setVisible(true);
            ComboBoxBloodGroup.setVisible(false);
            LabelBloodType.setVisible(false);
            LabelDoctorID.setVisible(true);
            TextFieldDoctorID.setVisible(true);
        });
        ButtonAsPatient.addActionListener(e -> {
            LabelRegistration.setText("<html>Register<br/> as Patient</html");
            ButtonAsPatient.setEnabled(false);
            ButtonAsDoctor.setEnabled(true);
            ComboBoxSpecialities.setVisible(false);
            LabelSpeciality.setVisible(false);
            ComboBoxBloodGroup.setVisible(true);
            LabelBloodType.setVisible(true);
            LabelDoctorID.setVisible(false);
            TextFieldDoctorID.setVisible(false);
        });
        group.add(RadioButtonWoman);
        group.add(RadioButtonMan);
        RadioButtonWoman.setOpaque(false);
        RadioButtonMan.setOpaque(false);

        RadioButtonWoman.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int i = 0; i < 16; i++) {
            if (ComponentTab[i].getClass() == JLabel.class) {
                ((JLabel) ComponentTab[i]).setHorizontalAlignment(SwingConstants.RIGHT);
            }
            if (i < 8) {
                add(ComponentTab[i], getC(1, i + 4, 0, 0, 20, 0));
            } else {
                add(ComponentTab[i], getC(2, i - 4, 0, 0, 200, 0));
            }
            add(TextFieldPersonalID, getC(6, 4, 0, 0, 0, 0));
            LabelPersonalID.setHorizontalAlignment(SwingConstants.RIGHT);
            add(LabelPersonalID, getC(5, 4, 0, 0, 0, 0));
            LabelEmailAdress.setHorizontalAlignment(SwingConstants.RIGHT);
            add(TextFieldEmailAdress, getC(6, 5, 0, 0, 200, 0));
            add(LabelEmailAdress, getC(5, 5, 0, 0, 0, 0));
            add(LabelPassword, getC(5, 6, 0, 0, 0, 0));
            add(TextFieldPassword, getC(6, 6, 0, 0, 0, 0));
            LabelWeight.setHorizontalAlignment(SwingConstants.RIGHT);
            add(TextFieldWeight, getC(6, 8, 0, 0, 0, 0));
            add(LabelWeight, getC(5, 8, 0, 0, 0, 0));
            LabelBloodType.setHorizontalAlignment(SwingConstants.RIGHT);
            add(LabelBloodType, getC(5, 7, 0, 0, 0, 0));
            LabelSpeciality.setHorizontalAlignment(SwingConstants.RIGHT);
            add(LabelSpeciality, getC(5, 7, 0, 0, 0, 0));
            add(ComboBoxBloodGroup, getC(6, 7, 0, 0, 0, 0));
            add(ComboBoxSpecialities, getC(6, 7, 0, 0, 0, 0));
            LabelPassword.setHorizontalAlignment(SwingConstants.RIGHT);
            add(RadioButtonWoman, getC(5, 10, 0, 0, 0, 0));
            add(RadioButtonMan, getC(6, 10, 0, 0, 0, 0));
            add(LabelDoctorID, getC(5, 11, 0, 0, 0, 0));
            add(TextFieldDoctorID, getC(6, 11, 0, 0, 0, 0));
            LabelDoctorID.setHorizontalAlignment(SwingConstants.RIGHT);
            LabelChooseGender.setHorizontalAlignment(SwingConstants.RIGHT);
            add(LabelChooseGender, getC(5, 9, 0, 0, 100, 0));
            add(ButtonAsPatient, getC(1, 2, 0, 0, 0, 0));
            add(ButtonAsDoctor, getC(1, 3, 0, 0, 0, 0));
            add(getButtonReturn(), getC(1, 15, 0, 0, 0, 0));
        }
        LabelRegistration.setFont(new Font("Now", Font.BOLD, 30));
        add(LabelRegistration, getC(5, 1, 0, 0, 0, 0));
        add(ButtonRegister, getC(5, 13, 0, 0, 0, 0));
        ButtonRegister.addActionListener(e -> {
            if (ButtonAsPatient.isEnabled()) {
                try {
                    DoctorController.doctorRegister();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (ButtonAsDoctor.isEnabled()) {
                try {
                    PatientController.patientRegister();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        getButtonReturn().addActionListener(e -> clearText());
    }

    public static JTextField getTextFieldName() {
        return TextFieldName;
    }

    public static JTextField getTextFieldEmailAdress() {
        return TextFieldEmailAdress;
    }

    public static JTextField getTextFieldPhoneNumber() {
        return TextFieldPhoneNumber;
    }

    public static JTextField getTextFieldDateOfBirth() {
        return TextFieldDateOfBirth;
    }

    public static JTextField getTextFieldStreet() {
        return TextFieldStreet;
    }

    public static JTextField getTextFieldWeight() {
        return TextFieldWeight;
    }

    public static JTextField getTextFieldHeight() {
        return TextFieldHeight;
    }

    public static JTextField getTextFieldBloodType() {
        return TextFieldBloodType;
    }

    public static JTextField getTextFieldSurname() {
        return TextFieldSurname;
    }

    public static JTextField getTextFieldPersonalID() {
        return TextFieldPersonalID;
    }

    public static JTextField getTextFieldCity() {
        return TextFieldCity;
    }

    public static JTextField getTextFieldHouseNumber() {
        return TextFieldHouseNumber;
    }

    public static JTextField getTextFieldPassword() {
        return TextFieldPassword;
    }

    public static char getGender() {
        if (RadioButtonMan.isSelected()) {
            return 'M';
        } else if (RadioButtonWoman.isSelected()) {
            return 'K';
        } else {
            return 'b';
        }
    }

    public static JComboBox getComboBoxSpecialities() {
        return ComboBoxSpecialities;
    }

    public static void clearText() {
        for (JComponent jComponent : getComponentTab()) {
            if (jComponent instanceof JTextField) {
                ((JTextField) jComponent).setText("");
                jComponent.setBackground(Color.WHITE);
            }
            ComboBoxSpecialities.setSelectedIndex(0);
            ComboBoxSpecialities.setBackground(Color.WHITE);
            getComboBoxBloodGroup().setBackground(Color.WHITE);
            getComboBoxBloodGroup().setSelectedIndex(0);
        }
    }
}
