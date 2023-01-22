package Model;

import Service.Appointment;
import Service.Opinion;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Patient extends Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 5031303074988487825L;
    private String bloodGroup;
    private int weight;
    private int height;
    private PatientCard patientCard = new PatientCard();
    private List<Appointment> appointmentHistory = new ArrayList<>();
    private HashSet<Doctor> myDoctors = new HashSet<>();

    public Patient() {
        super();
        this.bloodGroup = "";
        this.weight = 0;
        this.height = 0;
    }

    public Patient(String firstName, String surname, String password, String personalIdNumber, String email, String contactNumber, String city, String street, int houseNumber, LocalDate birthdate, char gender, String bloodGroup, int weight, int height) {
        super(firstName, surname, password, personalIdNumber, email, contactNumber, city, street, houseNumber, birthdate, gender);
        this.bloodGroup = bloodGroup;
        this.weight = weight;
        this.height = height;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public PatientCard getPatientCard() {
        return patientCard;
    }

    public ArrayList<Medicine> getPrescribedMedicines() {
        return patientCard.getMedicines();
    }

    public List<Appointment> getAppointmentHistory() {
        return appointmentHistory;
    }

    public HashSet<Doctor> getMyDoctors() {
        return myDoctors;
    }

    public void addOpinion(Opinion opinion, Doctor doctor) {
        doctor.setOpinion(opinion);
    }

    @Override
    public String toString() {
        return "Patient [" +
                super.toString() + ", " +
                "bloodGroup: " + bloodGroup +
                ", weight: " + weight +
                ", height: " + height +
                ']';
    }
}