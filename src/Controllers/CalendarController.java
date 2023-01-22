package Controllers;

import Data.Connection;
import Model.Doctor;
import Service.Appointment;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CalendarController {

    public static List<Appointment> getAppointments() {
        return Connection.getAppointments();
    }

    public static void saveAppointment(int day, int month, int year, int time, Doctor doctor) {
        Connection.getAppointments().add(new Appointment(LocalDate.of(year, month + 1, day), LocalTime.of(time, 0), doctor.getDoctorId(), PatientController.loggedPatient().getPersonalIdNumber()));
        JOptionPane.showMessageDialog(null, "Appointment signed correctly", "",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
