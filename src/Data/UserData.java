package Data;

import Controllers.RegisterController;
import Model.Doctor;
import Model.Patient;
import Model.Specialization;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.regex.Pattern;

import static Data.UserAccount.setSafeCreatePatient;

public class UserData {

    private UserData() {
    }

    public static String enterFirstName() throws InputMismatchException {
        String firstName = RegisterController.getName().getText();
        if (firstName.length() == 0) {
            setSafeCreatePatient(true);
            RegisterController.SetRed(RegisterController.getName());
        } else {
            RegisterController.SetWhite(RegisterController.getName());
            firstName = nameValidate(firstName);
        }
        return firstName;
    }

    public static String enterSurname() throws InputMismatchException {

        String surname = RegisterController.getSurname().getText();
        if (surname.length() == 0) {
            setSafeCreatePatient(true);
            RegisterController.SetRed(RegisterController.getSurname());
        } else {
            RegisterController.SetWhite(RegisterController.getSurname());
            surname = nameValidate(surname);
        }
        return surname;
    }

    public static String enterPassword() throws InputMismatchException {

        String password;
        password = RegisterController.getPassword().getText();
        if (passwordValidate(password)) {
            RegisterController.SetRed(RegisterController.getPassword());
            setSafeCreatePatient(true);
        } else {
            RegisterController.SetWhite(RegisterController.getPassword());
        }
        return password;
    }

    public static String enterEmail() throws InputMismatchException {

        String email;
        email = RegisterController.getEmailAdress().getText();
        if (emailValidate(email)) {
            RegisterController.SetRed(RegisterController.getEmailAdress());
            setSafeCreatePatient(true);
        } else {
            RegisterController.SetWhite(RegisterController.getEmailAdress());
        }
        return email;
    }

    public static LocalDate enterBirthdate() throws InputMismatchException {

        String birthdate;
        birthdate = RegisterController.getBirth().getText();
        if (dateValidate(birthdate)) {
            RegisterController.SetRed(RegisterController.getBirth());
            setSafeCreatePatient(true);
        } else {
            RegisterController.SetWhite(RegisterController.getBirth());
        }
        try {
            return LocalDate.parse(birthdate);
        } catch (DateTimeParseException e) {
            RegisterController.SetRed(RegisterController.getBirth());
            setSafeCreatePatient(true);
        }
        return null;
    }

    public static String enterPersonalIdNumber() throws InputMismatchException {

        String personalIdNumber;

        personalIdNumber = RegisterController.getPersonalId().getText();
        if (personalIDValidate(personalIdNumber)) {
            RegisterController.SetRed(RegisterController.getPersonalId());
            setSafeCreatePatient(true);
        } else {
            RegisterController.SetWhite(RegisterController.getPersonalId());
        }
        return personalIdNumber;
    }

    public static String enterContactNumber() throws InputMismatchException {

        String contactNumber;

        contactNumber = RegisterController.getPhoneNumber().getText();
        if (phoneNumberValidate(contactNumber)) {
            RegisterController.SetRed(RegisterController.getPhoneNumber());
            setSafeCreatePatient(true);
        } else {
            RegisterController.SetWhite(RegisterController.getPhoneNumber());
        }
        return contactNumber;
    }

    public static String enterAddressCity() throws InputMismatchException {

        String addressCity = RegisterController.getCity().getText();
        if (RegisterController.getCity().getText().length() == 0) {
            RegisterController.SetRed(RegisterController.getCity());
            setSafeCreatePatient(true);
        } else {
            RegisterController.SetWhite(RegisterController.getCity());
            addressCity = RegisterController.getCity().getText();
        }
        return addressCity;
    }

    public static String enterAddressStreet() throws InputMismatchException {

        String addressStreet = RegisterController.getStreet().getText();
        if (addressStreet.length() == 0) {
            RegisterController.SetRed(RegisterController.getStreet());
            setSafeCreatePatient(true);
        } else {
            RegisterController.SetWhite(RegisterController.getStreet());
        }

        return addressStreet;
    }

    public static int enterAddressHouseNumber() throws InputMismatchException {

        int addressHouseNumber = 0;
        if (RegisterController.getHouseNumber().getText().length() == 0) {
            RegisterController.SetRed(RegisterController.getHouseNumber());
            setSafeCreatePatient(true);
        } else {
            addressHouseNumber = Integer.parseInt(RegisterController.getHouseNumber().getText());
            RegisterController.SetWhite(RegisterController.getHouseNumber());
        }
        return addressHouseNumber;
    }

    public static char enterGender() throws InputMismatchException {

        char gender = RegisterController.getGender();
        if (RegisterController.getGender() == 'b') {
            RegisterController.getKobieta().setBackground(Color.RED);
            RegisterController.getKobieta().setOpaque(true);
            RegisterController.getMezczyzna().setBackground(Color.RED);
            RegisterController.getMezczyzna().setOpaque(true);
            setSafeCreatePatient(true);
        } else {
            RegisterController.getKobieta().setBackground(Color.GRAY);
            RegisterController.getKobieta().setOpaque(false);
            RegisterController.getMezczyzna().setBackground(Color.GRAY);
            RegisterController.getMezczyzna().setOpaque(false);
        }
        return gender;
    }

    public static int enterWeight() throws InputMismatchException {
        int weight = 0;
        try {
            weight = Integer.parseInt(RegisterController.getWeight().getText());
            if (positiveNumberValidate(weight)) {
                RegisterController.SetRed(RegisterController.getWeight());
                setSafeCreatePatient(true);
            } else {
                RegisterController.SetWhite(RegisterController.getWeight());
            }
        } catch (NumberFormatException e) {
            RegisterController.SetRed(RegisterController.getWeight());
            setSafeCreatePatient(true);
        }
        return weight;
    }

    public static int enterHeight() throws InputMismatchException {
        int height = 0;
        try {
            height = Integer.parseInt(RegisterController.getHeight().getText());
            if (positiveNumberValidate(height)) {
                RegisterController.SetRed(RegisterController.getHeight());
                setSafeCreatePatient(true);
            } else {
                RegisterController.SetWhite(RegisterController.getHeight());
            }
        } catch (NumberFormatException e) {
            RegisterController.SetRed(RegisterController.getHeight());
            setSafeCreatePatient(true);
        }
        return height;
    }


    public static String enterBloodGroup() throws InputMismatchException {

        String bloodGroup = (String) RegisterController.getComboBoxBlood().getSelectedItem();
        if (Objects.equals(bloodGroup, "Wybierz grupe krwi")) {
            RegisterController.SetRed(RegisterController.getComboBoxBlood());
            setSafeCreatePatient(true);
        } else {
            RegisterController.SetWhite(RegisterController.getComboBoxBlood());
        }
        return bloodGroup;
    }


    public static Specialization enterSpecialization() throws InputMismatchException {
        return new Specialization(Connection.getSpecializations()[RegisterController.getComboBoxSpecialization().getSelectedIndex()]);
    }

    public static int enterID() throws InputMismatchException {

        int doctorID = 0;
        try {
            doctorID = Integer.parseInt(RegisterController.getDoctorID().getText());
            if (fourDigitIDValidation(doctorID)) {
                RegisterController.SetRed(RegisterController.getDoctorID());
                UserAccount.setSafeCreatePatient(true);
            } else {
                RegisterController.SetWhite(RegisterController.getDoctorID());
            }
        } catch (NumberFormatException e) {
            RegisterController.SetWhite(RegisterController.getDoctorID());
            UserAccount.setSafeCreatePatient(true);
        }
        return doctorID;
    }

    public static boolean fourDigitIDValidation(int doctorID) {

        return doctorID > 9999 || doctorID < 1000;
    }

    public static String nameValidate(String name) {

        if (name == null || name.length() == 0) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public static boolean passwordValidate(String password) {

        return password.length() < 8;
    }

    public static boolean emailValidate(String email) {

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) return true;
        return !pat.matcher(email).matches();
    }

    public static boolean dateValidate(String date) {

        String dateRegex = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";

        Pattern pat = Pattern.compile(dateRegex);

        if (date == null) return true;
        return !pat.matcher(date).matches();
    }

    public static boolean isFutureDate(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.until(date, ChronoUnit.DAYS) >= 0;
    }

    public static boolean personalIDValidate(String personalID) {

        return personalID.length() != 11;
    }

    public static boolean phoneNumberValidate(String phoneNumber) {

        return phoneNumber.length() != 9;
    }

    public static boolean positiveNumberValidate(int houseNumber) {

        return houseNumber <= 0;
    }

    public static boolean genderValidate(char gender) {

        return gender != 'M' && gender != 'F';
    }

    public static boolean heightValidate(int height) {

        return height < 0 || height > 250;
    }

    public static boolean specializationValidate(int choice) {

        return choice < 0 || choice >= Connection.getSpecializations().length;
    }

    public static boolean isNumeric(String strNum) {

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static boolean isDoctorIDUnique(int doctorID) {
        for (Doctor doctor : Connection.getDoctors()) {
            if (doctor.getDoctorId() == doctorID) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPersonalIDUnique(String personalID) {
        for (Patient patient : Connection.getPatients()) {
            if (patient.getPersonalIdNumber().equals(personalID)) {
                System.out.println("User with this personal ID already exists");
                return false;
            }
        }
        for (Doctor doctor : Connection.getDoctors()) {
            if (doctor.getPersonalIdNumber().equals(personalID)) {
                System.out.println("User with this personal ID already exists");
                return false;
            }
        }
        return true;
    }
}