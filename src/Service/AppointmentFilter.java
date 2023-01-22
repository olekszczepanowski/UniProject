package Service;

import Data.Connection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFilter {

    private static final int FIRST_APPOINTMENT_HOUR = 9;
    private static final int LAST_APPOINTMENT_HOUR = 17;

    public static void printAppointments(List<Appointment> appointments) {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public static List<Appointment> filterByDateForDoctor(LocalDate date, int doctorID) {

        List<Appointment> appointments = new ArrayList<>();

        for (Appointment appointment : Connection.getAppointments()) {
            if (appointment.getAppointmentDate().equals(date) && appointment.getDoctorID() == (doctorID)) {
                appointments.add(appointment);
            }
        }

        return appointments;

    }

    public static List<Appointment> filterAvailableAppointments(int doctorID, LocalDate date) {

        List<Appointment> availableAppointments = new ArrayList<>();
        for (int i = FIRST_APPOINTMENT_HOUR; i <= LAST_APPOINTMENT_HOUR; i++) {
            LocalTime time = LocalTime.of(i, 0);
            availableAppointments.add(new Appointment(date, time, doctorID, null));
        }

        for (Appointment appointment : Connection.getAppointments()) {
            if (appointment.getDoctorID() == doctorID) {
                if (appointment.getAppointmentDate().equals(date)) {
                    LocalTime time = appointment.getAppointmentTime();
                    availableAppointments.removeIf(availableAppointment -> availableAppointment.getAppointmentTime().equals(time));
                }
            }
        }

        return availableAppointments;
    }

    public static int getFirstAppointmentHour() {
        return FIRST_APPOINTMENT_HOUR;
    }

    public static int getLastAppointmentHour() {
        return LAST_APPOINTMENT_HOUR;
    }
}
