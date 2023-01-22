package Controllers;

import Data.Connection;
import Model.Doctor;
import Model.Patient;
import Service.Appointment;
import Service.AppointmentStrategy.SortByOpinion;
import Service.AppointmentStrategy.SortByTime;

import java.util.ArrayList;
import java.util.List;

public class SortingController {

    public static List<Appointment> sortingByTime(Patient loggedPatient, String chosenSpecialization) {
        SortByTime sortByTime = new SortByTime();
        List<Doctor> specializedDoctors = specializedDoctors(chosenSpecialization);
        return sortByTime.makeAppointment(loggedPatient, specializedDoctors);
    }

    public static List<Doctor> SortByOpinion(String chosenSpecialization) {

        List<Doctor> specializedDoctors = specializedDoctors(chosenSpecialization);
        specializedDoctors.sort(new SortByOpinion.DoctorCompareOpinion());
        return specializedDoctors;
    }

    public static List<Doctor> specializedDoctors(String chosenSpecialization) {

        List<Doctor> specializedDoctors = new ArrayList<>();
        for (Doctor doctor : Connection.getDoctors()) {
            if (doctor.getSpecialization().getName().equals(chosenSpecialization)) {
                specializedDoctors.add(doctor);
            }
        }
        return specializedDoctors;
    }
}