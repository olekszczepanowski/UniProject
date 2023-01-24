package Model;

import Data.Connection;
import Service.Appointment;
import Service.Opinion;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Doctor extends Person implements Serializable {

    @Serial
    private static final long serialVersionUID = -5720566371622132090L;
    private Specialization specialization;
    private int doctorId;
    private List<Opinion> opinions;
    private double averageOpinion;
    private List<Appointment> appointmentHistory = new ArrayList<>();


    public Doctor() {
        super();
        this.specialization = null;
        this.doctorId = 0;
        this.opinions = new ArrayList<>();
        this.averageOpinion = 0.0;
    }

    public Doctor(String firstName, String surname, String password, String personalIdNumber, String email, String contactNumber, String city, String street, int houseNumber, LocalDate birthdate, char gender, Specialization specialization, int doctorId) {
        super(firstName, surname, password, personalIdNumber, email, contactNumber, city, street, houseNumber, birthdate, gender);
        this.specialization = specialization;
        this.doctorId = doctorId;

        this.opinions = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int value = random.nextInt(1, 6);
            String content = "Opinion " + i;
            opinions.add(new Opinion(value, content));
        }
        this.averageOpinion = calculateAverageOpinion();
    }


    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinion(Opinion opinion) {
        opinions.add(opinion);
        setAverageOpinion(calculateAverageOpinion());
    }

    public double getAverageOpinion() {
        return averageOpinion;
    }

    public void setAverageOpinion(double averageOpinion) {
        this.averageOpinion = averageOpinion;
    }

    public List<Appointment> getAppointmentHistory() {
        return appointmentHistory;
    }

    @Override
    public String toString() {
        return "Doctor [" +
                super.toString() +
                ", doctor id: " + doctorId + ", " +
                "specialization: " + specialization + ", " +
                "average opinion: " + averageOpinion +
                ']';
    }

    @Override
    public int hashCode() {
        return this.getDoctorId();
    }

    @Override
    public boolean equals(Object obj) {
        Doctor other = (Doctor) obj;
        if (other == null) {
            return false;
        } else {
            return this.getDoctorId() == other.getDoctorId();
        }
    }

    public double calculateAverageOpinion() {
        double sum = 0.0;
        for (Opinion opinion : opinions) {
            sum += opinion.getValue();
        }
        return Math.round(sum / opinions.size() * 100) / 100.0;
    }

    public static void generateDoctors(int quantity) {
        Random random = new Random();
        String[] firstnames = {"Tom", "James", "Adam", "John", "Michael", "Francis", "Charles", "Will", "Robert"};
        String[] surnames = {"Smith", "Jones", "Williams", "Taylor", "Brown", "Thomas"};
        String[] streets = {"Long", "Short", "Blue", "Main", "Church", "High", "Park"};
        String[] cities = {"New York", "Washington", "Miami", "Boston", "Atlantic City", "Richmond"};
        String[] specializations = Connection.getSpecializations();

        String firstname;
        String surname;
        String password = "12345678";
        String personalIDNumber;
        String email;
        String contactNumber;
        String city;
        String street;
        int houseNumber;
        LocalDate birthdate;
        char gender = 'M';
        Specialization specialization;
        int doctorId;

        for (int i = 0; i < quantity; i++) {
            firstname = firstnames[random.nextInt(firstnames.length)];
            surname = surnames[random.nextInt(surnames.length)];
            personalIDNumber = Long.toString(random.nextLong(10000000000L, 100000000000L));
            email = firstname.substring(0, 3).toLowerCase() + surname.substring(0, 4).toLowerCase() + random.nextInt(10, 100) + "@gmail.com";
            contactNumber = Integer.toString(random.nextInt(100000000, 1000000000));
            city = cities[random.nextInt(cities.length)];
            street = streets[random.nextInt(streets.length)];
            houseNumber = random.nextInt(100);
            birthdate = LocalDate.of(random.nextInt(1960, 2000), random.nextInt(1, 13), random.nextInt(1, 29));
            specialization = new Specialization(specializations[random.nextInt(specializations.length)]);
            doctorId = random.nextInt(1000, 10000);

            Connection.getDoctors().add(new Doctor(firstname, surname, password, personalIDNumber, email, contactNumber, city, street, houseNumber, birthdate, gender, specialization, doctorId));
        }
    }

    public void prescribeMedicine(Medicine medicine, Patient patient) {
        patient.getPrescribedMedicines().add(medicine);
    }
}