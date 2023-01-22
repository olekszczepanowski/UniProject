package Service.AppointmentStrategy;

import Model.Doctor;
import Model.Patient;
import Service.Appointment;

import java.util.List;

public interface MakeAppointmentStrategy {

    List<Appointment> makeAppointment(Patient loggedPatient, List<Doctor> specializedDoctors);

}
