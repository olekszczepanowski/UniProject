package Controllers;

import Data.ChangeData;
import Data.Connection;
import Model.Doctor;
import Model.Patient;
import Service.Appointment;
import Service.AppointmentFilter;
import Service.Diagnosis;
import Data.UserAccount;
import GraphicInterface.Menu.PanelLoginPatient;
import GraphicInterface.PanelPatient.PanelChoosingAppointmentByOpinion;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientController {
    private static Doctor doctor = null;
    private static final String[] bloodTypes = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};

    public static String[] getBloodTypes() {
        return bloodTypes;
    }

    public static String getID() {
        String id = null;
        try {
            id = PanelLoginPatient.getTextFieldPersonalIDPatient().getText();
        } catch (NumberFormatException ignored) {
        }
        return id;
    }

    public static String getPassword() {
        return String.valueOf(PanelLoginPatient.getTextFieldPasswordPatient().getPassword());
    }

    public static void patientLogin() {

        UserAccount.patientLogin();
    }

    public static void patientRegister() throws IOException {

        UserAccount.patientRegister();
    }

    public static List<Patient> getAllPatients() {
        return Connection.getPatients();
    }

    public static Patient loggedPatient() {
        return UserAccount.getLoggedPatient();
    }

    public static void changeEmail(String email, Patient patient) {
        ChangeData.changeEmail(patient, email);
    }

    public static void changeWeight(int weight, Patient patient) {
        ChangeData.changeWeight(patient, weight);
    }

    public static void changeHeight(int height, Patient patient) {
        ChangeData.changeHeight(patient, height);
    }

    public static void changePhoneNumber(String contactNumber, Patient patient) {
        ChangeData.changeContactNumber(patient, contactNumber);
    }

    public static Doctor PanelchoosingDoctor() {
        return PanelChoosingAppointmentByOpinion.getDoctor();
    }

    public static void setDoctor(Doctor docto) {
        doctor = docto;
    }

    public static Doctor getDoctor() {
        return doctor;
    }

    public static List<Appointment> getAppointments(Patient loggedPatient) {
        List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment appointment : Connection.getAppointments()) {
            if (appointment.getPatientID().equals(loggedPatient.getPersonalIdNumber())) {
                patientAppointments.add(appointment);
            }
        }
        return patientAppointments;
    }

    public static List<Appointment> filterAvailableAppointments(Doctor doc) {
        return AppointmentFilter.filterAvailableAppointments(doc.getDoctorId(), LocalDate.now());
    }

    public static List<Diagnosis> showDiagnoses() {
        return loggedPatient().getPatientCard().getDiagnoses();
    }
}
