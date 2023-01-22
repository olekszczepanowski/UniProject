package Data;

import Model.Patient;
import Model.Person;

import java.time.LocalDate;
import java.util.logging.Logger;

public class ChangeData {

    static Logger logger = Logger.getLogger(ChangeData.class.getName());

    public static <T extends Person> void changeFirstName(T loggedUser, String newFirstName) {
        loggedUser.setFirstName(UserData.nameValidate(newFirstName));
        logger.info("NAME CHANGED");
    }

    public static <T extends Person> void changeSurname(T loggedUser, String newSurname) {
        loggedUser.setFirstName(UserData.nameValidate(newSurname));
        logger.info("SURNAME CHANGED");
    }

    public static <T extends Person> void changePassword(T loggedUser, String oldPassword, String newPassword) {
        if (oldPassword.equals(loggedUser.getPassword()) && !UserData.passwordValidate(newPassword)) {
            loggedUser.setPassword(newPassword);
            logger.info("PASSWORD CHANGED");
        }
    }

    public static <T extends Person> void changePersonalIdNumber(T loggedUser, String newPersonalIdNumber) {
        if (!UserData.personalIDValidate(newPersonalIdNumber)) {
            loggedUser.setPersonalIdNumber(newPersonalIdNumber);
            logger.info("PERSONAL ID NUMBER CHANGED");
        }
    }

    public static <T extends Person> void changeEmail(T loggedUser, String email) {
        if (!UserData.emailValidate(email)) {
            loggedUser.setEmail(email);
            logger.info("EMAIL CHANGED");
        }
    }

    public static <T extends Person> void changeContactNumber(T loggedUser, String contactNumber) {
        if (!UserData.phoneNumberValidate(contactNumber)) {
            loggedUser.setContactNumber(contactNumber);
            logger.info("CONTACT NUMBER CHANGED");
        }
    }

    public static <T extends Person> void changeCity(T loggedUser, String newCity) {
        loggedUser.setCity(UserData.nameValidate(newCity));
        logger.info("CITY CHANGED");
    }

    public static <T extends Person> void changeStreet(T loggedUser, String newStreet) {
        loggedUser.setStreet(UserData.nameValidate(newStreet));
        logger.info("STREET CHANGED");
    }

    public static <T extends Person> void changeHouseNumber(T loggedUser, int newHouseNumber) {
        if (!UserData.positiveNumberValidate(newHouseNumber)) {
            loggedUser.setHouseNumber(newHouseNumber);
            logger.info("HOUSE NUMBER CHANGED");
        }
    }

    public static <T extends Person> void changeDateOfBirth(T loggedUser, String newDateOfBirth) {
        if (!UserData.dateValidate(newDateOfBirth)) {
            LocalDate parsedNewDateOfBirth = LocalDate.parse(newDateOfBirth);
            loggedUser.setBirthdate(parsedNewDateOfBirth);
            logger.info("BIRTHDATE CHANGED");
        }
    }

    public static <T extends Person> void changeGender(T loggedUser, char newGender) {
        if (UserData.genderValidate(newGender)) {
            loggedUser.setGender(newGender);
            logger.info("GENDER CHANGED");
        }
    }

    public static void changeWeight(Patient loggedPatient, int weight) {
        if (!UserData.positiveNumberValidate(weight)) {
            loggedPatient.setWeight(weight);
            logger.info("WEIGHT CHANGED");
        }
    }

    public static void changeHeight(Patient loggedPatient, int height) {
        if (!UserData.positiveNumberValidate(height)) {
            loggedPatient.setHeight(height);
            logger.info("HEIGHT CHANGED");
        }
    }
}