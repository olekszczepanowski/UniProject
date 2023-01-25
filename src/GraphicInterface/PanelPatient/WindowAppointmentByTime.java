package GraphicInterface.PanelPatient;

import Controllers.CalendarController;
import Controllers.DoctorController;
import Controllers.PatientController;
import Controllers.SortingController;
import Service.Appointment;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowAppointmentByTime extends JPanel {

    private static JDialog MainDialog;
    private static JFrame frame = new JFrame();

    WindowAppointmentByTime(String specialization) {
        JPanel test = new JPanel();
        JScrollPane scrollFrame = new JScrollPane(test);
        test.setLayout(new GridLayout(20, 1, 0, 0));
        test.setAutoscrolls(true);
        test.setPreferredSize(new Dimension(400, 1200));
        scrollFrame.setPreferredSize(new Dimension(400, 350));
        this.add(scrollFrame);
        for (Appointment appointment : SortingController.sortingByTime(PatientController.loggedPatient(), specialization)) {
            JLabel LabelData = new JLabel("<html>" + String.valueOf(appointment.getAppointmentDate()) + " " + String.valueOf(appointment.getAppointmentTime()) + "<br/> "
                    + "Dr" + String.valueOf(DoctorController.getDoctorByID(appointment.getDoctorID()).getFirstName()) + " "
                    + DoctorController.getDoctorByID(appointment.getDoctorID()).getSurname() + "<html>");
            JButton ButtonData = new JButton("Book");
            JPanel PanelLabel = new JPanel();
            PanelLabel.setLayout(new BorderLayout());
            PanelLabel.add(LabelData);
            JPanel PanelButton = new JPanel();
            PanelButton.add(ButtonData);
            test.add(PanelLabel);
            test.add(new JPanel());
            test.add(PanelButton);
            ButtonData.addActionListener(e -> {
                CalendarController.saveAppointment(appointment.getAppointmentDate().getDayOfMonth(), appointment.getAppointmentDate().getMonth().getValue(), appointment.getAppointmentDate().getYear(),
                        appointment.getAppointmentTime().getHour(), DoctorController.getDoctorByID(appointment.getDoctorID()));
            });
        }
        for (int i = 0; i < 20 - SortingController.sortingByTime(PatientController.loggedPatient(), specialization).size(); i++)
            test.add(new JPanel());
        add(scrollFrame);
        if (SortingController.sortingByTime(PatientController.loggedPatient(), specialization).size() == 0) {
            JOptionPane.showMessageDialog(null, "No appointmenst avaliable", "",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void createAndShowGui(String spetialization) throws IOException {
        MainDialog = new JDialog();
        MainDialog.setTitle(frame.getTitle());
        MainDialog.setModal(true);
        MainDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainDialog.getContentPane().add(new WindowAppointmentByTime(spetialization));
        MainDialog.pack();
        MainDialog.setLocationRelativeTo(null);
        MainDialog.setVisible(true);
    }
}
