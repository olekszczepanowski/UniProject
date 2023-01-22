package Model;

import Service.Diagnosis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class PatientCard implements Serializable {
    private List<Diagnosis> diagnoses = new ArrayList<>();

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void addDiagnosis(String diagnosis, String recommendation, ArrayList<Medicine> medicines, Doctor doctor) {
        diagnoses.add(new Diagnosis(diagnosis, recommendation, medicines, doctor));
    }

//    public void displayOneDiagnosis() {
//        if (diagnoses.size() == 0)
//            System.out.println("No diagnoses to show");
//        else if (diagnoses.size() == 1) {
//            System.out.println("There is only one diagnosis:");
//            diagnoses.get(0).displayDiagnosis();
//        } else {
//            System.out.println("Select a diagnosis:");
//            for (int i = 0; i < diagnoses.size(); i++) {
//                System.out.println((i + 1) + ". " + diagnoses.get(i).getDate() + " " + diagnoses.get(i).getDoctor().getSpecialization());
//            }
//            boolean safeChoice;
//            int choice = 0;
//            do {
//                safeChoice = false;
//                try {
//                    choice = Input.getInt();
//                } catch (InputMismatchException InvalidInput) {
//                    System.out.println("\nInvalid data. Try again");
//                    safeChoice = true;
//                }
//            } while (choice < 1 || choice > diagnoses.size() || safeChoice);
//            diagnoses.get(choice - 1).displayDiagnosis();
//        }
//    }
//
//    public void showMedicalHistory() {
//        if (diagnoses.size() == 0)
//            System.out.println("This patient's medical history is blank");
//        for (Diagnosis diagnosis : diagnoses) {
//            System.out.println("Date: " + diagnosis.getDate());
//            System.out.println("Diagnosis: " + diagnosis.getDiagnosis());
//            System.out.println("Prescribed medicines: ");
//            if (diagnosis.getMedicines().size() == 0)
//                System.out.println("There were no medicines prescribed");
//            else
//                for (Medicine medicine : diagnosis.getMedicines())
//                    System.out.println(medicine);
//            System.out.println();
//        }
//    }

    public ArrayList<Medicine> getMedicines() {
        ArrayList<Medicine> medicines = new ArrayList<>();
        for (Diagnosis diagnosis : diagnoses)
            medicines.addAll(diagnosis.getMedicines());
        return medicines;
    }
}
