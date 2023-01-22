package GraphicInterface.PanelPatient;

import Controllers.PatientController;
import Controllers.SortingController;
import Model.Doctor;
import GraphicInterface.Components.Picker;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowAppointmentByOpinion extends JPanel {
    private static JDialog MainDialog;
    private static JFrame frame = new JFrame();

    WindowAppointmentByOpinion(String specialization) {
        JPanel test = new JPanel();
        test.setLayout(new GridLayout(SortingController.SortByOpinion(specialization).size(), 1, -20, 0));
        test.setPreferredSize(new Dimension(600, 1000));
        JScrollPane scrollFrame = new JScrollPane(test);
        test.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(600, 1000));
        this.add(scrollFrame);
        for (Doctor doctor : SortingController.SortByOpinion(specialization)) {
            JButton ButtonData = new JButton("Dr. " + doctor.getFirstName() + " " + doctor.getSurname() + " " + doctor.getAverageOpinion());
            test.add(ButtonData);
            ButtonData.addActionListener(e -> {
                new Picker(doctor);
                MainDialog.dispose();
            });
        }
        add(scrollFrame);
        if (SortingController.sortingByTime(PatientController.loggedPatient(), specialization).size() == 0) {
            JOptionPane.showMessageDialog(null, "No appointmenst avaliable", "",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void createAndShowGui(String specialization) throws IOException {
        MainDialog = new JDialog();
        MainDialog.setTitle(frame.getTitle());
        MainDialog.setModal(true);
        MainDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainDialog.getContentPane().add(new WindowAppointmentByOpinion(specialization));
        MainDialog.pack();
        MainDialog.setLocationRelativeTo(null);
        MainDialog.setVisible(true);
    }
}
