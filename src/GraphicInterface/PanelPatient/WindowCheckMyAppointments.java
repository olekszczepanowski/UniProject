package GraphicInterface.PanelPatient;

import Controllers.DoctorController;
import Controllers.PatientController;
import Service.Appointment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class WindowCheckMyAppointments extends JPanel {
    private static JDialog MainDialog;
    private static JFrame frame = new JFrame("Appointments");

    WindowCheckMyAppointments() {
        JPanel test = new JPanel();
        test.setLayout(new GridLayout(10, 1, -20, 0));
        test.setPreferredSize(new Dimension(400, Math.min(200, PatientController.getAppointments(PatientController.loggedPatient()).size() * 50)));
        JScrollPane scrollFrame = new JScrollPane(test);
        test.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(400, 200));
        this.add(scrollFrame);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        for (Appointment appointment : PatientController.getAppointments(PatientController.loggedPatient())) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1, 0, 0));
            panel.add(new JLabel("Date " + appointment.getAppointmentDate()));
            panel.add(new JLabel("Time: " + appointment.getAppointmentTime()));
            panel.add(new JLabel("Dr " + DoctorController.getDoctorByID(appointment.getDoctorID()).getFirstName() + " " + DoctorController.getDoctorByID(appointment.getDoctorID()).getSurname()));
            panel.add(new JLabel(""));
            panel.setBorder(blackline);
            test.add(panel);
        }
        for(int i=0;i<10-PatientController.getAppointments(PatientController.loggedPatient()).size();i++)
            test.add(new JPanel());
        add(scrollFrame);
    }

    public static void createAndShowGui() throws IOException {
        MainDialog = new JDialog();
        MainDialog.setTitle(frame.getTitle());
        MainDialog.setModal(true);
        MainDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainDialog.getContentPane().add(new WindowCheckMyAppointments());
        MainDialog.pack();
        MainDialog.setLocationRelativeTo(null);
        MainDialog.setVisible(true);
    }
}
