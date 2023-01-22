package Data;

import Controllers.AdminController;
import Controllers.DoctorController;
import Controllers.MenuController;
import Controllers.PatientController;
import Model.*;
import GraphicInterface.Menu.PanelLoginAdmin;
import GraphicInterface.Menu.PanelLoginDoctor;
import GraphicInterface.Menu.RegisterPanel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.logging.Logger;

public final class UserAccount {

    public static String[] getBloodGroups() {
        return bloodGroups;
    }

    private final static String[] bloodGroups = {"A+", "A-", "B+", "B-", "0+", "0-", "AB+", "AB-"};
    private static Patient loggedPatient;
    private static Doctor loggedDoctor;
    private static Admin loggedAdmin;

    public static boolean isSafeCreate() {
        return safeCreate;
    }

    private UserAccount() {
    }

    public static Admin getLoggedAdmin() {
        return loggedAdmin;
    }

    public static Patient getLoggedPatient() {
        return loggedPatient;
    }

    public static Doctor getLoggedDoctor() {
        return loggedDoctor;
    }

    public static void setLoggedPatient(Patient loggedPatient) {
        UserAccount.loggedPatient = loggedPatient;
    }

    public static void setLoggedDoctor(Doctor loggedDoctor) {
        UserAccount.loggedDoctor = loggedDoctor;
    }

    public static void setLoggedAdmin(Admin loggedAdmin) {
        UserAccount.loggedAdmin = loggedAdmin;
    }

    public static boolean found = false;
    static String firstName = null;
    static String surname = null;
    static String password = null;
    static String personalID = null;
    static String email = null;
    static String contactNumber = null;
    static String addressCity = null;
    static String addressStreet = null;
    static String bloodGroup = null;
    static int addressHouseNumber = 0;
    static int weight = 0;
    static int height = 0;
    static LocalDate birthdate = null;
    static char gender;
    private static boolean safeCreate;
    static Specialization specialization;
    static int doctorID;
    static Logger logger = Logger.getLogger(UserAccount.class.getName());

    public static void setSafeCreatePatient(boolean safeCreate) {
        UserAccount.safeCreate = safeCreate;
    }

    public static void generalRegister() throws InputMismatchException {

        firstName = UserData.enterFirstName();
        surname = UserData.enterSurname();
        password = UserData.enterPassword();
        email = UserData.enterEmail();
        birthdate = UserData.enterBirthdate();
        personalID = UserData.enterPersonalIdNumber();
        contactNumber = UserData.enterContactNumber();
        addressCity = UserData.enterAddressCity();
        addressStreet = UserData.enterAddressStreet();
        addressHouseNumber = UserData.enterAddressHouseNumber();
        gender = UserData.enterGender();
    }

    public static void patientRegister() throws IOException {

        logger.info("PATIENT REGISTER");
        safeCreate = false;
        generalRegister();
        height = UserData.enterHeight();
        weight = UserData.enterWeight();
        bloodGroup = UserData.enterBloodGroup();
        if (!safeCreate) {
            Connection.getPatients().add(new Patient(firstName, surname, password, personalID, email, contactNumber,
                    addressCity, addressStreet, addressHouseNumber, birthdate, gender, bloodGroup, weight, height));
            logger.info("ACCOUNT CREATED SUCCESSFULLY");
            MenuController.ChangePanel();
            RegisterPanel.clearText();
            safeCreate = true;
        }
    }

    public static void patientLogin() {

        logger.info("PATIENT LOGIN");

        String personalIDNumber, password;
        personalIDNumber = PatientController.getID();
        password = PatientController.getPassword();

        for (int i = 0; i < Connection.getPatients().size(); i++) {
            if (Connection.getPatients().get(i).getPersonalIdNumber().equals(personalIDNumber) &&
                    Connection.getPatients().get(i).getPassword().equals(password)) {
                loggedPatient = Connection.getPatients().get(i);
                logger.info("ACCESS GRANTED");
            }
        }
    }

    public static void doctorRegister() throws IOException {

        logger.info("DOCTOR REGISTER");

        safeCreate = false;
        generalRegister();
        specialization = UserData.enterSpecialization();
        doctorID = UserData.enterID();
        if (!safeCreate) {
            Connection.getDoctorsRegisterRequests().add(new Doctor(firstName, surname, password, personalID, email,
                    contactNumber, addressCity, addressStreet, addressHouseNumber, birthdate, gender, specialization, doctorID));
            MenuController.ChangePanel();
            RegisterPanel.clearText();
            safeCreate = true;
            logger.info("ACCOUNT CREATED SUCCESSFULLY");
        }
    }

    public static void doctorLogin() throws IOException {

        logger.info("DOCTOR LOGIN");

        int doctorID = 0;
        String password;
        doctorID = DoctorController.getLoginID();
        password = DoctorController.getLoginPassword();
        for (int i = 0; i < Connection.getDoctors().size(); i++) {
            if (Connection.getDoctors().get(i).getDoctorId() == doctorID
                    && Connection.getDoctors().get(i).getPassword().equals(password)) {
                loggedDoctor = Connection.getDoctors().get(i);
                DoctorController.ChangePanel();
                logger.info("ACCESS GRANTED");
            } else {
                PanelLoginDoctor.getLabelIncorrectData().setVisible(true);
            }
        }
    }

    public static void createAdmin(int doctorID, String password) {

        Connection.getAdmins().add(new Admin(doctorID, password));
    }

    public static void adminLogin() throws IOException {

        logger.info("ADMIN LOGIN");

        int adminID = 0;
        String password;
        adminID = AdminController.getAdminID();
        password = AdminController.getAdminPassword();
        for (int i = 0; i < Connection.getAdmins().size(); i++) {
            if (Connection.getAdmins().get(i).getAdminID() == adminID
                    && Connection.getAdmins().get(i).getPassword().equals(password)) {
                loggedAdmin = Connection.getAdmins().get(i);
                AdminController.ChangePanel();
                logger.info("ACCESS GRANTED");
            } else {
                PanelLoginAdmin.getLabelIncorrectData().setVisible(true);
            }
        }
    }
}