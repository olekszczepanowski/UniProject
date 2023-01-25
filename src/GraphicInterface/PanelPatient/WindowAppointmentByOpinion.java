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
        JScrollPane scrollFrame = new JScrollPane(test);
        test.setLayout(new GridLayout(20, 1, 0, 0));
        test.setAutoscrolls(true);
        test.setPreferredSize(new Dimension(400, 1200));
        scrollFrame.setPreferredSize(new Dimension(400, 350));
        this.add(scrollFrame);
        for (Doctor doctor : SortingController.SortByOpinion(specialization)) {
            JLabel LabelData = new JLabel("<html>Dr " + doctor.getFirstName() + " " + doctor.getSurname() + "<br/> " + doctor.getAverageOpinion()+"<html>");
            JButton ButtonData = new JButton("Book");
            JPanel PanelButton = new JPanel();
            JPanel Paneldata = new JPanel();
            Paneldata.setLayout(new GridLayout(1,3,0,0));
            JPanel PanelLabel = new JPanel();
            PanelLabel.setLayout(new BorderLayout());
            PanelLabel.add(LabelData);
            PanelButton.add(ButtonData);
            Paneldata.add(PanelLabel);
            Paneldata.add(new JPanel());
            Paneldata.add(PanelButton);
            ButtonData.addActionListener(e -> {
                MainDialog.dispose();
                new Picker(doctor);
            });
            test.add(Paneldata);
        }
        for(int i=0;i<20-SortingController.SortByOpinion(specialization).size();i++)
            test.add(new JPanel());
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
