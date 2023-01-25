package GraphicInterface.Components;

import Controllers.CalendarController;
import Controllers.DoctorController;
import Model.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Picker {
    public Picker(Doctor doctor) {
        JLabel label = new JLabel("Selected Date:");
        final JTextField text = new JTextField(20);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 0, 0));
        JButton button = new JButton("Calendar");
        JPanel panel1 = new JPanel();
        JPanel jPanelhour = new JPanel();
        JComboBox hour = new JComboBox(new String[]{"9", "10", "11", "12", "13", "14", "15", "16", "17"});
        hour.setVisible(false);
        JPanel c = new JPanel();
        JButton confirm = new JButton("Confirm");
        confirm.setVisible(false);
        c.add(confirm);
        jPanelhour.add(hour);
        panel1.add(label);
        panel1.add(text);
        panel1.add(button);
        panel.add(panel1);
        panel.add(jPanelhour);
        panel.add(c);
        final JFrame f = new JFrame(doctor.getFirstName() + " " + doctor.getSurname());
        f.setLocationRelativeTo(null);
        f.getContentPane().add(panel);
        f.pack();
        f.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                text.setText(new DatePicker(f).setPickedDate());
                hour.setVisible(true);
                for (int x = 0; x < hour.getItemCount(); x++) {
                    for (int y = 0; y < DoctorController.getAppointments(doctor).size(); y++) {
                        if (DoctorController.getAppointments(doctor).get(y).getAppointmentTime().getHour() == Integer.parseInt((String) hour.getItemAt(x))) {
                            hour.removeItemAt(x);
                        }
                    }
                }
            }
        });
        hour.addActionListener(e -> confirm.setVisible(true));
        confirm.addActionListener(e ->

        {
            CalendarController.saveAppointment(Integer.parseInt(DatePicker.getDay()), DatePicker.getMonth() + 1, DatePicker.getYear(), Integer.parseInt((String) Objects.requireNonNull(hour.getSelectedItem())), doctor);
            f.dispose();
        });
    }
}

