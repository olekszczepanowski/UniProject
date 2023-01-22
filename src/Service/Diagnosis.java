package Service;

import Model.Doctor;
import Model.Medicine;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Diagnosis implements Serializable {

    private ArrayList<Medicine> medicines = new ArrayList<>();
    private String diagnosis;
    private String recommendation;
    private Doctor doctor;
    private LocalDate date;

    public Diagnosis(String diagnosis, String recommendation, ArrayList<Medicine> medicines, Doctor doctor) {
        this.diagnosis = diagnosis;
        this.recommendation = recommendation;
        this.medicines = medicines;
        this.doctor = doctor;
        this.date = LocalDate.now();
    }

//    public void displayDiagnosis() {
//        System.out.println("Date: " + date);
//        System.out.println("Diagnosis: \n" + diagnosis);
//        System.out.println("Recommendation: \n" + recommendation);
//        System.out.println("Medicines: ");
//        if (medicines.size() == 0)
//            System.out.println("There were no medicines prescribed");
//        else
//            for (Medicine medicine : medicines)
//                System.out.println(medicine);
//        System.out.println("Doctor: " + doctor);
//    }


    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
