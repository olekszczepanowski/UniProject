package Service.AppointmentStrategy;

import Data.UserData;
import Model.Doctor;
import Model.Patient;
import Service.Appointment;
import Service.AppointmentFilter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Comparator;

public class SortByOpinion implements MakeAppointmentStrategy {

    @Override
    public List<Appointment> makeAppointment(Patient loggedPatient, List<Doctor> specializedDoctors) {

        specializedDoctors.sort(new DoctorCompareOpinion());

        System.out.println();
        for (int i = 0; i < specializedDoctors.size(); i++) {
            System.out.println("\t" + (i + 1) + ": " + specializedDoctors.get(i));
        }

        int choice = 1;

        if (choice >= 0 && choice < specializedDoctors.size()) {
            Doctor chosenDoctor = specializedDoctors.get(choice);

            System.out.print("\nEnter date (YYYY-MM-DD): ");
            String date = "2000-01-01";

            if (!UserData.dateValidate(date)) {
                LocalDate parsedDate = LocalDate.parse(date);
                if (UserData.isFutureDate(parsedDate)) {

                    List<Appointment> availableAppointments = AppointmentFilter.filterAvailableAppointments(chosenDoctor.getDoctorId(), parsedDate);

                    if (parsedDate.equals(LocalDate.now())) {
                        int i = 0;
                        int currentHour = LocalTime.now().getHour();

                        while (i < availableAppointments.size()) {
                            Appointment tmpAppointment = availableAppointments.get(i);
                            if (tmpAppointment.getAppointmentTime().getHour() <= currentHour) {
                                availableAppointments.remove(tmpAppointment);
                                i--;
                            }
                            i++;
                        }
                    }

                    if (availableAppointments.size() == 0) {
                        return null;
                    }

                    return availableAppointments;
                }
                else {
                    System.out.println("\nInvalid input");
                    return null;
                }
            }
            else {
                System.out.println("\nInvalid input");
                return null;
            }
        }
        else {
            System.out.println("\nInvalid input");
            return null;
        }
    }

    public static class DoctorCompareOpinion implements Comparator<Doctor> {
        @Override
        public int compare(Doctor o1, Doctor o2) {
            return Double.compare(o2.getAverageOpinion(), o1.getAverageOpinion());
        }
    }

}
