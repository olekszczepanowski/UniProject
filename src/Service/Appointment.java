package Service;

import Data.Connection;
import Model.Doctor;
import Model.Patient;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment implements Serializable {

    @Serial
    private static final long serialVersionUID = 2120442681896028757L;
    private final LocalDate appointmentDate;
    private final LocalTime appointmentTime;
    private final int doctorID;
    private final String patientID;

    public Appointment(LocalDate appointmentDate, LocalTime appointmentTime, int doctorID, String patientID) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    @Override
    public String toString() {
        return "AppointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", doctorID=" + doctorID +
                ", patientID=" + patientID;
    }

    public void archive() {

        int doctorID = this.getDoctorID();
        Doctor currentDoctor;
        for (Doctor doctor : Connection.getDoctors()) {
            if (doctor.getDoctorId() == doctorID) {
                currentDoctor = doctor;
                doctor.getAppointmentHistory().add(this);

                String patientPersonalID = this.getPatientID();
                for (Patient patient : Connection.getPatients()) {
                    if (patient.getPersonalIdNumber().equals(patientPersonalID)) {
                        patient.getAppointmentHistory().add(this);
                        patient.getMyDoctors().add(currentDoctor);
                        break;
                    }
                }
                break;
            }
        }

    }
}