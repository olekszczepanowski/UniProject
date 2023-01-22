package Controllers;

import Data.ChangeData;
import Data.Connection;
import Data.UserAccount;
import Model.Doctor;
import Model.Medicine;
import Model.Patient;
import Model.PatientCard;
import Service.Appointment;
import GraphicInterface.Components.Frame;
import GraphicInterface.Menu.PanelLoginDoctor;
import GraphicInterface.PanelDoctor.PanelDiagnose;
import GraphicInterface.PanelDoctor.PanelDoctor;
import GraphicInterface.PanelDoctor.PanelMakeDiagnosis;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

public class DoctorController {
    private static ArrayList<Medicine> medics = new ArrayList<>();

    public static String[] getSpecializations() {
        return Connection.getSpecializations();
    }

    public static void doctorLogin() throws IOException {
        UserAccount.doctorLogin();
    }

    public static void doctorRegister() throws IOException {
        UserAccount.doctorRegister();
    }

    public static List<Doctor> getAllDoctors() {
        return Connection.getDoctors();
    }

    public static List<Doctor> getAllDoctorsRequests() {
        return Connection.getDoctorsRegisterRequests();
    }

    public static Doctor loggedDoctor() {
        return UserAccount.getLoggedDoctor();
    }

    public static void changeEmail(String email, Doctor doctor) {
        ChangeData.changeEmail(doctor, email);
    }

    public static void changePhoneNumber(String phoneNumber, Doctor doctor) {
        ChangeData.changeContactNumber(doctor, phoneNumber);
    }

    public static int getID() {
        int id = 0;
        try {
            id = Integer.parseInt(PanelLoginDoctor.getTextFieldIDDoctor().getText());
        } catch (NumberFormatException ignored) {
        }
        return id;
    }

    public static String getPassword() {
        return String.valueOf(PanelLoginDoctor.getTextFieldPasswordDoctor().getPassword());
    }

    public static void ChangePanel() throws IOException {
        Frame.getFrame().setTab(new PanelDoctor());
    }

    public static Patient searchPatient(String PersonalID) {
        for (Patient patient : Connection.getPatients()) {
            if (Objects.equals(patient.getPersonalIdNumber(), PersonalID)) {
                return patient;
            }
        }
        return null;
    }

    public static ArrayList<Appointment> getAppointments(Doctor doc) {
        ArrayList<Appointment> lista = new ArrayList<>();
        for (int i = 0; i < Connection.getAppointments().size(); i++) {
            if (Connection.getAppointments().get(i).getDoctorID() == doc.getDoctorId()) {
                lista.add(Connection.getAppointments().get(i));
            }
        }
        return lista;
    }

    public static void addDiagnosis() throws IOException {
        Frame.getFrame().set(new PanelMakeDiagnosis());
    }

    public static void addMedicine(boolean finished) throws IOException {
        if (!finished) {
            try {
                medics.add(new Medicine(PanelMakeDiagnosis.getTextfieldDrug().getText(), LocalDate.of(LocalDate.now().getYear() + 1, LocalDate.now().getMonth().getValue(), LocalDate.now().getDayOfMonth()),
                        PanelMakeDiagnosis.getTextfieldCondition().getText(), Integer.parseInt(PanelMakeDiagnosis.getTextfieldDrugprice().getText())));
                JOptionPane.showMessageDialog(null, "Medicine added", "",
                        JOptionPane.INFORMATION_MESSAGE);
                PanelMakeDiagnosis.getTextfieldDrug().setText("");
                PanelMakeDiagnosis.getTextfieldCondition().setText("");
                PanelMakeDiagnosis.getTextfieldDrugprice().setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Incorrect price", "",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            PatientCard patientCard = PatientController.getAllPatients().get(PanelDiagnose.getPatients().getSelectedIndex()).getPatientCard();
            patientCard.addDiagnosis(PanelDiagnose.getTextfieldDiagnose().getText(), PanelDiagnose.getTextfieldDiagnose().getText(), medics, DoctorController.loggedDoctor());
            PanelMakeDiagnosis.getTextfieldDrug().setText("");
            PanelMakeDiagnosis.getTextfieldCondition().setText("");
            PanelMakeDiagnosis.getTextfieldDrugprice().setText("");
            JOptionPane.showMessageDialog(null, "Diagnosis added", "",
                    JOptionPane.INFORMATION_MESSAGE);
            Connection.saveAllData();
            Frame.getFrame().setTab(new PanelDoctor());
        }
    }

    public static int getLoginID() {
        try {
            return Integer.parseInt(PanelLoginDoctor.getTextFieldIDDoctor().getText());
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static String getLoginPassword() {
        try {
            return String.valueOf(PanelLoginDoctor.getTextFieldPasswordDoctor().getPassword());
        } catch (InputMismatchException exception) {
            exception.printStackTrace();
        }
        return "";
    }

    public static Doctor getDoctorByID(int doctorID) {

        for (Doctor doctor : Connection.getDoctors()) {
            if (doctor.getDoctorId() == doctorID) {
                return doctor;
            }
        }
        return null;
    }
}