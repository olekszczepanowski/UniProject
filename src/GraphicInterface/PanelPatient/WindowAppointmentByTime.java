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
        test.setLayout(new GridLayout(SortingController.sortingByTime(PatientController.loggedPatient(), specialization).size(), 1, -20, 0));
        test.setPreferredSize(new Dimension(600, 1000));
        JScrollPane scrollFrame = new JScrollPane(test);
        test.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(600, 1000));
        this.add(scrollFrame);
        for (Appointment appointment : SortingController.sortingByTime(PatientController.loggedPatient(), specialization)) {
            JButton ButtonData = new JButton(String.valueOf(appointment.getAppointmentDate()) + " " + String.valueOf(appointment.getAppointmentTime()) + " "
                    + "Dr" + String.valueOf(DoctorController.getDoctorByID(appointment.getDoctorID()).getFirstName()) + " " + DoctorController.getDoctorByID(appointment.getDoctorID()).getSurname());
            test.add(ButtonData);
            ButtonData.addActionListener(e -> {
                CalendarController.saveAppointment(appointment.getAppointmentDate().getDayOfMonth(), appointment.getAppointmentDate().getMonth().getValue(), appointment.getAppointmentDate().getYear(),
                        appointment.getAppointmentTime().getHour(), DoctorController.getDoctorByID(appointment.getDoctorID()));
            });
        }
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
