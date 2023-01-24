package Tests;

import Data.UserData;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterInputTests {

    Random random;
    String[] personalIDs;
    @BeforeEach
    void setUp() throws Exception {
        random = new Random();
        personalIDs = new String[]{"12345678900", "00987654321", "13579975201", "41235789012"};
    }
    @Test
    void fourDigitIDValidation() {

        int id = random.nextInt(0,10000);
        boolean result = id < 0 || id > 9999;

        assertEquals(result, UserData.fourDigitIDValidation(1234));

        id = random.nextInt(10000, 100000);
        result = id < 0 || id > 9999;
        assertNotEquals(result, UserData.fourDigitIDValidation(1234));
    }

    @Test
    void nameValidate() {

        String name = "marcin";
        String result = "Marcin";
        assertEquals(result, UserData.nameValidate(name));

        name = "mArcIn";
        assertEquals(result, UserData.nameValidate(name));

        name = "MARCIN";
        assertEquals(result, UserData.nameValidate(name));

        assertNotEquals(name, UserData.nameValidate(name));
    }

    @Test
    void passwordValidate() {

        String[] passwords = {"lekkiekolko", "lekkiekolbo", "witomejeje", "1231285y1vsgd", "12418sgdjk2", "tasafasgabg",
                "haselko12345", "witomejejejje", "taaaaahamhmhmhm"};
        String password = passwords[random.nextInt(passwords.length)];
        boolean result;

        if (password.length() < 8) {
            result = true;
        } else {
            result = false;
        }

        assertEquals(result, UserData.passwordValidate(password));
    }

    @Test
    void emailValidate() {

        String mail = "mail@gmail.com";
        boolean result;

        if (mail.contains("@")) {
            result = false;
        } else {
            result = true;
        }

        assertEquals(result, UserData.emailValidate(mail));

        String notMail = "mail";

        if (notMail.contains("@")) {
            result = false;
        } else {
            result = true;
        }

        assertNotEquals(result, UserData.emailValidate(mail));
    }

    @Test
    void dateValidate() {

        String date = "2023-01-01";
        boolean result;

        if (date.contains("-")) {
            result = false;
        } else {
            result = true;
        }
        assertEquals(result, UserData.dateValidate("2023-01-01"));
        assertNotEquals(result, UserData.dateValidate("2023.01.01"));

    }

    @Test
    void isFutureDate() {

        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.of(2023, 12, 12);
        boolean result = currentDate.until(date, ChronoUnit.DAYS) >= 0;

        assertEquals(result, UserData.isFutureDate(date));
    }

    @Test
    void personalIDValidate() {

        boolean result = personalIDs[random.nextInt(personalIDs.length)].length() != 11;

        assertEquals(result, UserData.personalIDValidate("12345678911"));
        assertNotEquals(result, UserData.personalIDValidate("12345"));
    }

    @Test
    void phoneNumberValidate() {

        String[] phoneNumbers = {"123456789", "009876543", "135799752", "412357890"};
        boolean result = phoneNumbers[random.nextInt(phoneNumbers.length)].length() != 9;

        assertEquals(result, UserData.phoneNumberValidate("112354923"));
        assertNotEquals(result, UserData.personalIDValidate("12345"));
    }

    @Test
    void positiveNumberValidate() {

        int positiveNumber = random.nextInt(1000);
        boolean result = positiveNumber <= 0;

        assertEquals(result, UserData.positiveNumberValidate(12));
        assertNotEquals(result, UserData.positiveNumberValidate(-12));

    }

    @Test
    void genderValidate() {

        char gender = 'M';
        boolean result = gender != 'M' && gender != 'F';

        assertEquals(result, UserData.genderValidate('M'));
        assertEquals(result, UserData.genderValidate('F'));
        assertNotEquals(result, UserData.genderValidate('s'));
    }

    @Test
    void heightValidate() {

        int height = random.nextInt(0, 250);
        boolean result = height < 0 || height > 250;

        assertEquals(result, UserData.heightValidate(188));
        assertEquals(result, UserData.heightValidate(172));
        assertNotEquals(result, UserData.heightValidate(300));
    }

    @Test
    void isDoctorIDUnique() {

        int[] doctorIDs = {12345, 55321, 12348, 89201, 81238, 99201, 10020};
        int validDoctorID = 99999;
        boolean result = true;

        for (int doctorID : doctorIDs)
            if (validDoctorID == doctorID) {
                result = false;
                break;
            }

        assertEquals(result, UserData.isDoctorIDUnique(validDoctorID));
        assertEquals(result, UserData.isDoctorIDUnique(12345));
    }

    @Test
    void isPersonalIDUnique() {

        String validPersonalId = "99999999999";
        boolean result = true;

        for (String personalID : personalIDs)
            if (personalID == validPersonalId) {
                result = false;
                break;
            }

        assertEquals(result, UserData.isPersonalIDUnique(validPersonalId));
        assertEquals(result, UserData.isPersonalIDUnique("99999999990"));
    }
}
