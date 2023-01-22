package GraphicInterface.PanelDoctor;

import Controllers.DoctorController;
import Service.Appointment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class WindowAppointments extends JPanel {
    private static JDialog MainDialog1;
    private static JFrame frame1 = new JFrame("Appointments");

    WindowAppointments() {
        JPanel test = new JPanel();
        test.setLayout(new GridLayout(DoctorController.getAppointments(DoctorController.loggedDoctor()).size(), 1, -20, 0));
        test.setPreferredSize(new Dimension(200, 2000));
        JScrollPane scrollFrame = new JScrollPane(test);
        test.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(200, 400));
        this.add(scrollFrame);
        int i = 0;
        Border blackline = BorderFactory.createLineBorder(Color.black);
        for (Appointment appointment : DoctorController.getAppointments(DoctorController.loggedDoctor())) {
            i++;
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1, 0, 0));
            panel.add(new JLabel("Appointment date: " + appointment.getAppointmentDate()));
            panel.add(new JLabel("Appointment time: " + appointment.getAppointmentTime()));
            panel.add(new JLabel("Patient: " + appointment.getPatientID()));
            panel.setBorder(blackline);
            test.add(panel);
        }
        add(scrollFrame);
        if (DoctorController.getAppointments(DoctorController.loggedDoctor()).size() == 0) {
            JOptionPane.showMessageDialog(null, "No appointments yet", "",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void createAndShowGui() throws IOException {
        MainDialog1 = new JDialog();
        MainDialog1.setTitle(frame1.getTitle());
        MainDialog1.setModal(true);
        MainDialog1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MainDialog1.getContentPane().add(new WindowAppointments());
        MainDialog1.pack();
        MainDialog1.setLocationRelativeTo(null);
        MainDialog1.setVisible(true);
    }
}
