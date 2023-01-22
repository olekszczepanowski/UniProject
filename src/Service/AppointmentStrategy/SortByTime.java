package Service.AppointmentStrategy;

import Model.Doctor;
import Model.Patient;
import Service.Appointment;
import Service.AppointmentFilter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByTime implements MakeAppointmentStrategy {

    @Override
    public List<Appointment> makeAppointment(Patient loggedPatient, List<Doctor> specializedDoctors) {

        LocalDate currentDate = LocalDate.now();
        int currentHour = LocalTime.now().getHour();
        List<Appointment> availableAppointments = new ArrayList<>();

        do {
            if (currentHour >= AppointmentFilter.getLastAppointmentHour()) {
                currentDate = currentDate.plusDays(1);
                currentHour = AppointmentFilter.getFirstAppointmentHour() - 1;
            }

            List<Appointment> tmpAppointments;
            for (Doctor doctor : specializedDoctors) {
                tmpAppointments = AppointmentFilter.filterAvailableAppointments(doctor.getDoctorId(), currentDate);
                availableAppointments.addAll(tmpAppointments);
            }

            int i = 0;
            while (i < availableAppointments.size()) {
                Appointment tmpAppointment = availableAppointments.get(i);
                if (tmpAppointment.getAppointmentTime().getHour() <= currentHour) {
                    availableAppointments.remove(tmpAppointment);
                    i--;
                }
                i++;
            }

            if (availableAppointments.size() == 0) {
                currentDate = currentDate.plusDays(1);
                currentHour = AppointmentFilter.getFirstAppointmentHour() - 1;
            }
        }
        while (availableAppointments.size() == 0);

        availableAppointments.sort(new AppointmentSortByDate());
        return availableAppointments;
    }

    public static class AppointmentSortByDate implements Comparator<Appointment> {

        @Override
        public int compare(Appointment o1, Appointment o2) {
            return Integer.compare(o1.getAppointmentTime().getHour(), o2.getAppointmentTime().getHour());
        }
    }
}
