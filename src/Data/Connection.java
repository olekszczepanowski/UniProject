package Data;

import Model.Admin;
import Model.Doctor;
import Model.Medicine;
import Model.Patient;
import Service.Appointment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class Connection {

    private static final String filenameAdmins = "data_base/admins.txt";
    private static final String filenamePatients = "data_base/patients.txt";
    private static final String filenameDoctors = "data_base/doctors.txt";
    private static final String filenameDoctorsRequests = "data_base/doctors_requests.txt";
    private static final String filenameMedicines = "data_base/medicines.txt";
    private static final String filenameAppointments = "data_base/appointments.txt";
    private static List<Admin> admins = new ArrayList<>();
    private static List<Patient> patients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Doctor> doctorsRegisterRequests = new ArrayList<>();
    private static List<Medicine> medicines = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private final static String[] specializations = {
            "Family doctor",
            "Orthopedist",
            "Cardiologist",
            "Gynecologist",
            "Laryngologist",
            "Dermatologist",
            "Oncologist",
            "Eye specialist"
    };

    private Connection() {
    }

    public static List<Patient> getPatients() {
        return patients;
    }

    public static List<Doctor> getDoctors() {
        return doctors;
    }

    public static List<Admin> getAdmins() {
        return admins;
    }

    public static List<Doctor> getDoctorsRegisterRequests() {
        return doctorsRegisterRequests;
    }

    public static List<Medicine> getMedicines() {
        return medicines;
    }

    public static List<Appointment> getAppointments() {
        return appointments;
    }

    public static String[] getSpecializations() {
        return specializations;
    }

    public static void loadAllData() {

        loadDoctors();
        loadPatients();
        loadAdmins();
        loadDoctorsRequests();
        loadMedicines();
        loadAppointments();
    }

    public static void saveAllData() {

        saveDoctors();
        savePatients();
        saveDoctorsRequests();
        saveAdmins();
        saveMedicines();
        saveAppointments();
    }

    public static void savePatients() {

        try {
            FileOutputStream fos = new FileOutputStream(filenamePatients);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(patients);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadPatients() {

        try {
            FileInputStream fis = new FileInputStream(filenamePatients);
            ObjectInputStream ois = new ObjectInputStream(fis);
            patients = (List<Patient>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            if (!patients.isEmpty()) exception.printStackTrace();
        }
    }

    public static void saveDoctors() {

        try {
            FileOutputStream fos = new FileOutputStream(filenameDoctors);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(doctors);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadDoctors() {

        try {
            FileInputStream fis = new FileInputStream(filenameDoctors);
            ObjectInputStream ois = new ObjectInputStream(fis);
            doctors = (List<Doctor>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            if (!doctors.isEmpty()) exception.printStackTrace();
        }
    }

    public static void saveAdmins() {

        try {
            FileOutputStream fos = new FileOutputStream(filenameAdmins);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(admins);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadAdmins() {

        try {
            FileInputStream fis = new FileInputStream(filenameAdmins);
            ObjectInputStream ois = new ObjectInputStream(fis);
            admins = (List<Admin>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            if (!admins.isEmpty()) exception.printStackTrace();
        }
    }

    public static void saveDoctorsRequests() {

        try {
            FileOutputStream fos = new FileOutputStream(filenameDoctorsRequests);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(doctorsRegisterRequests);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadDoctorsRequests() {

        try {
            FileInputStream fis = new FileInputStream(filenameDoctorsRequests);
            ObjectInputStream ois = new ObjectInputStream(fis);
            doctorsRegisterRequests = (List<Doctor>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            if (!doctorsRegisterRequests.isEmpty()) exception.printStackTrace();
        }
    }

    public static void saveMedicines() {

        try {
            FileOutputStream fos = new FileOutputStream(filenameMedicines);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(medicines);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadMedicines() {

        try {
            FileInputStream fis = new FileInputStream(filenameMedicines);
            ObjectInputStream ois = new ObjectInputStream(fis);
            medicines = (List<Medicine>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            if (!medicines.isEmpty()) exception.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadAppointments() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filenameAppointments))) {
            appointments = (List<Appointment>) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            if (!appointments.isEmpty()) exception.printStackTrace();
        }

        int i = 0;
        while (i < appointments.size()) {
            Appointment tmpAppointment = appointments.get(i);
            if (!UserData.isFutureDate(tmpAppointment.getAppointmentDate())) {
                tmpAppointment.archive();
                appointments.remove(tmpAppointment);
                i--;
            }
            i++;
        }

    }

    public static void saveAppointments() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filenameAppointments))) {
            oos.writeObject(appointments);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}