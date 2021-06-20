package app.domain.model;

import app.mappers.dto.ClientDTO;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static app.domain.model.Client.calculateAge;
import static org.junit.Assert.*;

public class ClientTest {

    /**
     * Tests with null values
     */
    @Test(expected = NullPointerException.class)
    public void garanteeNullClientIsntCreatedWithAllDataAndSex() {
        ClientDTO dto = new ClientDTO(null, null, null, null, null, null, null, null);
        new Client(dto);
    }

    /**
     * Tests with null values
     */
    @Test(expected = NullPointerException.class)
    public void garanteeNullClientIsntCreatedWithoutSex() {
        ClientDTO dto = new ClientDTO(null, null, null, null, null, null, null, null);
        new Client(dto);
    }

    /**
     * Tests to clients's code acceptance criterias
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNameHasLessThan35Char() {
        ClientDTO dto = new ClientDTO("Mariana Josefina Amaro Silva Costa Lópes", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "mariajosefina69@yalol.com", "street 1");
        new Client(dto);
    }

    /**
     * Tests to clients's name acceptance criterias
     */
    @Test
    public void ensureThatNameCanHave35Char() {
        ClientDTO dto = new ClientDTO("Ângelo Josefina Amaro Silva Costaaa", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "mariajosefina69@yalol.com", "street 1");
        new Client(dto);
    }

    /**
     * Tests to clients's nhsNumber acceptance criterias
     */
    @Test
    public void ensureThatNhsCanHave10Char() {
        ClientDTO dto = new ClientDTO("Maria Josefina", "1234567890123456", "1234567890", "1234567890", "23/12/2001", "male", "12345678901", "mariajosefina69@yalol.com", "street 1");
        new Client(dto);
    }

    /**
     * Tests to clients's phoneNumber acceptance criterias
     */
    @Test
    public void ensureThatPhoneNumberHave11Char() {
        ClientDTO dto = new ClientDTO("Costa", "1234567890123456", "1234567891", "1234567890", "23/12/2001","male","12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests that name cannot have number and characters
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNameNotHaveAlphanumericChar() {
        ClientDTO dto = new ClientDTO("To<más", "1234567890123456", "1234567891", "1234567890", "23/12/2010", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with name blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeBlank() {
        ClientDTO dto = new ClientDTO("To<más", "1234567890123456", "1234567891", "1234567890", "23/12/2010", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with address blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureAddressCannotBeBlank() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2010", "male", "12345678901", "tomas@isep.ipp.pt", "");
        new Client(dto);
    }

    /**
     * Tests with address blank
     */
    @Test(expected = NullPointerException.class)
    public void ensureAddressCannotBeNull() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2010", "male", "12345678901", "tomas@isep.ipp.pt", null);
        new Client(dto);
    }

    /**
     * Tests with citizenCardNumber blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureCitizenCardNumberCannotBeBlank() {
        ClientDTO dto = new ClientDTO("Tomas", "", "1234567891", "1234567890", "23/02/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with email blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatEmailIsNotBlank() {
        ClientDTO dto = new ClientDTO("Miguel", "1234567890123456", "1234567891", "1234567890", "23/02/2001", "male", "12345678901", "", "street 1");
        new Client(dto);
    }

    /**
     * Tests with nhsNumber blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsIsNotBlank() {
        ClientDTO dto = new ClientDTO("Miguel", "1234567890123456", "", "1234567890", "23/02/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with tinNumber blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinIsNotBlank() {
        ClientDTO dto = new ClientDTO("Miguel", "1234567890123456", "1234567891", "", "23/02/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with birthDate blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatBirthDateIsNotBlank() {
        ClientDTO dto = new ClientDTO("Miguel", "1234567890123456", "1234567891", "1234567890", "", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with phoneNumber blank
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberIsNotBlank() {
        ClientDTO dto = new ClientDTO("Miguel", "1234567890123456", "1234567891", "1234567890", "23/02/2001", "male", "", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests acceptance criteria of phoneNumber
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneCantHaveMoreAndLessThan11Char() {
        ClientDTO dto = new ClientDTO("Miguel", "1234567890123456", "1234567891", "1234567890", "23/02/2001", "male", "12345", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests acceptance criteria of tin and nhs number
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsAndTinCannotHaveMoreAndLessThan10Characters() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "12345678901", "12345678901", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests acceptance criteria of citizenCardNumber
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCitizenCardNumberCannotHaveMore16Characters() {
        ClientDTO dto = new ClientDTO("Tomás", "12345678901234568", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests acceptance criteria of citizenCardNumber
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCitizenCardNumberCannotHaveLessAndMore16Characters() {
        ClientDTO dto = new ClientDTO("Tomás", "12345678901234567", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests acceptance criteria of sex
     */
    @Test(expected = IllegalArgumentException.class)
    public void ensureThatSexOnlyAcceptMaleFemale() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "madeira", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests acceptance criteria of sex
     */
    @Test
    public void ensureThatSexCannotBeNull() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", null, "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if two clients are equal
     */
    @Test
    public void checkIfTwoClientsAreEqual() {
        ClientDTO dto1 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        ClientDTO dto2 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct01 = new Client(dto1);
        Client ct02 = new Client(dto2);
        assertEquals(ct01, ct02);
    }

    /**
     * Tests if two clients are different
     */
    @Test
    public void checkIfTwoClientsAreDifferents() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567887", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Miguel", "1234567890123232", "1234567891", "1234567890", "21/12/2001", "Female", "34545678901", "111111@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Tests if one client is equal to one clinet null
     */
    @Test
    public void checkIfClientIsNull() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        ClientDTO ct02 = null;
        boolean expected = false;
        assertEquals(expected, ct01.equals(ct02));

    }

    /**
     * Tests if name is wrong, first constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkNameWrongFirstConstructor() {
        ClientDTO dto = new ClientDTO("Tom1s", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if name is wrong, second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkNameWrongSecondConstructor() {
        ClientDTO dto = new ClientDTO("<omass", "1234567890323456", "1234527891", "1231567890", "23/11/2001", "12341678901", "tomas11@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if citizenCardNumber is wrong, first constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberWrongFirstConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "123456789012345688", "1234567891", "1234567890", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }


    /**
     * Tests if citizenCardNumber is wrong, second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberWrongSecondConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "123456789012345688", "1234567891", "1234567890", "23/12/2001", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if nhsNumber is wrong, first constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkNhsWrongFirstConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "987654321311", "1234567890", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if nhsNumber is wrong, second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkNhsWrongSecondConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "987654321", "1234567890", "23/12/2001", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if tinNumber is wrong, first constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkTinWrongFirstConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "9876543213", "987654321311", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if tinNumber is wrong, second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkTinWrongSecondConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "9876543213", "987654321311", "23/12/2001", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if birthDate is wrong, first constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkBirthDateWrongFirstConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/20011", "Male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if birthDate is wrong, first constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkClientIsYoungerThan150years() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/1500", "Male", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if birthDate is wrong, second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkBirthDateWrongSecondConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/20011", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if sex is wrong
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkSexWrong() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "madeira", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);

    }

    /**
     * Tests if phoneNumber is wrong, first constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkPhoneNumberWrongFirstConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "1234561111178901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);

    }

    /**
     * Tests if phoneNumber is wrong, second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkPhoneNumberWrongSecondConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "1234561111178901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests if email is wrong, first constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkEmailWrongFirstConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas1isep.ipp.pt", "street 1");
        new Client(dto);

    }

    /**
     * Tests if email is wrong, second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkEmailWrongSecondConstructor() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "12345678901", "tomas1isep.ipp.pt", "street 1");
        new Client(dto);

    }

    /**
     * Tests method of validating an email
     */
    @Test
    public void checkValidEmail() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    @Test(expected = NullPointerException.class)
    public void checkInvalidEmailNull() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", null, "street 1");
        new Client(dto);
    }

    /**
     * Tests method of stringJustHaveNumbers
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkIfStringJustHaveNumbers() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456", "123456789a", "1234567890", "23/12/2001", "madeira", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests method of isAlphanumerical
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkIfStringJustHaveNumbersWithLetter() {
        ClientDTO dto = new ClientDTO("Tomás", "123456789a123456", "123456789a", "1234567890", "23/12/2001", "madeira", "12345678901", "tomas1@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests method of convertStringToDate
     */
    @Test
    public void checkConvertStringToDate() {
        String birthDate = "23/12/2002";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.FRENCH);
        LocalDate expected = LocalDate.of(2002, 12, 23);
        assertEquals(LocalDate.parse(birthDate, formatter), expected);
    }

    /**
     * Tests method of calculateAge
     */
    @Test
    public void checkCalculateAge() {
        LocalDate birthDate = LocalDate.of(1500, 5, 17);
        int actual = calculateAge(birthDate, LocalDate.of(2016, 7, 12));
        Assert.assertEquals(516, actual);
    }

    /**
     * Tests method of calculateAge, with null parameters
     */
    @Test
    public void checkCalculateAgeNull() {
        int actual = calculateAge(null, null);
        Assert.assertEquals(0, actual);
    }

    /**
     * Tests method of calculateAge, with first null parameter
     */
    @Test
    public void checkCalculateAgeFirstDateNull() {
        int actual = calculateAge(null, LocalDate.of(2002, 12, 12));
        Assert.assertEquals(0, actual);
    }

    /**
     * Tests method of calculateAge, with second null parameter
     */
    @Test
    public void checkCalculateAgeSecondDateNull() {
        int actual = calculateAge(LocalDate.of(2002, 9, 11), null);
        Assert.assertEquals(0, actual);
    }
    /**
     * Tests method of calculateAge, with a age older than the acceptance criteria
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkCalculateAgeOlder() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890231451", "1234567877", "1234567898", "12/11/1800", "male", "12341111111", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Test of getName method, of class Client.
     */
    @Test
    public void checkGetName() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "Tomás";
        assertEquals(expected, ct01.getName());
    }


    /**
     * Test of setName method, of class Client.
     */
    @Test
    public void checkSetName() {
        ClientDTO ct01 = new ClientDTO("Miguel", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setName("Miguel");
        String expected = "Miguel";
        assertEquals(expected, ct01.getName());
    }

    /**
     * Test of getCitizenCardNumber method, of class Client.
     */
    @Test
    public void checkGetCitizenCardNumber() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "1234567890123456";
        assertEquals(expected, ct01.getCitizenCardNumber());
    }

    /**
     * Test of setCitizenCardNumber method, of class Client.
     */
    @Test
    public void checkSetCitizenCardNumber() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setCitizenCardNumber("1234567890123456");
        String expected = "1234567890123456";
        assertEquals(expected, ct01.getCitizenCardNumber());
    }

    /**
     * Test of getNhsNumber method, of class Client.
     */
    @Test
    public void checkGetNhsNumber() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567890", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "1234567890";
        assertEquals(expected, ct01.getNhsNumber());
    }

    /**
     * Test of setNhsNumber method, of class Client.
     */
    @Test
    public void checkSetNhsNumber() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setNhsNumber("1234567890");
        String expected = "1234567890";
        assertEquals(expected, ct1.getNhsNumber());
    }

    /**
     * Test of getTinNumber method, of class Client.
     */
    @Test
    public void checkGetTinNumber() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "1234567890";
        assertEquals(expected, ct01.getTinNumber());
    }

    /**
     * Test of setTinNumber method, of class Client.
     */
    @Test
    public void checkSetTinNumber() {
        ClientDTO ct01 = new ClientDTO("Tomas", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "1234567890";
        assertEquals(expected, ct01.getTinNumber());
    }

    /**
     * Test of getBirthDate method, of class Client.
     */
    @Test
    public void checkGetBirthDate() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2000", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "23/12/2000";
        assertEquals(expected, ct01.getBirthDate());
    }

    /**
     * Test of setBirthDate method, of class Client.
     */
    @Test(expected = IllegalArgumentException.class)
    public void checkSetBirthDateWithMoreThan150y() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setBirthDate("24/11/1500");
        String expected = "24/11/1500";
        assertEquals(expected, ct1.getBirthDate());
    }


    /**
     * Test of setBirthDate method, of class Client.
     */
    @Test
    public void checkSetBirthDate() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setBirthDate("24/11/2002");
        String expected = "24/11/2002";
        assertEquals(expected, ct1.getBirthDate());
    }
    /**
     * Test of getSex method, of class Client.
     */
    @Test
    public void checkGetSex() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        new Client(ct01);
        String expected = "male";
        assertEquals(expected, ct01.getSex());
    }

    /**
     * Test of setSex method, of class Client.
     */
    @Test
    public void checkSetSex() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setSex("female");
        String expected = "female";
        assertEquals(expected, ct1.getSex());
    }

    /**
     * Test of setSex method, of class Client.
     */
    @Test
    public void checkSetSexBlank() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setSex("");
        String expected = "";
        assertEquals(expected, ct1.getSex());
    }

    /**
     * Test of getPhoneNumber method, of class Client.
     */
    @Test
    public void checkGetPhoneNumber() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "12345678901";
        assertEquals(expected, ct01.getPhoneNumber());
    }

    /**
     * Test of setPhoneNumber method, of class Client.
     */
    @Test
    public void checkSetPhoneNumber() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setPhoneNumber("12345678901");
        String expected = "12345678901";
        assertEquals(expected, ct01.getPhoneNumber());
    }

    /**
     * Test of getEmail method, of class Client.
     */
    @Test
    public void checkGetEmail() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "tomas@isep.ipp.pt";
        assertEquals(expected, ct01.getEmail());
    }

    /**
     * Test of setEmail method, of class Client.
     */
    @Test
    public void checkSetEmail() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setEmail("tomasmiguel@isep.ipp.pt");
        String expected = "tomasmiguel@isep.ipp.pt";
        assertEquals(expected, ct1.getEmail());
    }

    /**
     * Test of getAddress method, of class Client.
     */
    @Test
    public void checkGetAddress() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567890", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = "street 1";
        assertEquals(expected, ct01.getAddress());
    }

    /**
     * Test of setAddress method, of class Client.
     */
    @Test
    public void checkSetAddress() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        Client ct1 = new Client(ct01);
        ct1.setAddress("street 53");
        String expected = "street 53";
        assertEquals(expected, ct1.getAddress());
    }

    /**
     * Test of toString method, of class Client.
     */
    @Test
    public void checkToStringMethod() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        String expected = String.format("Client:%nName: Tomás%nCitizen Card Number: 1234567890123456%nNHS number: 1234567891%nTIN number: 1234567890%nBirth date: 23/12/2001%nSex: male%nPhone number: 12345678901%nEmail: tomas@isep.ipp.pt%nAddress: street 1%n");
        assertEquals(expected, ct01.toString());
    }

    /**
     * Test if two clients are equal with just citizenCardNumber equal
     */
    @Test
    public void checkEqualsJustFalseCitizenCardNumberEqual() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123458", "1234567891", "1234567123", "23/12/2011", "male", "12345678321", "tomas@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Miguel", "1234567890123458", "1234567891", "1234567231", "23/12/2010", "female", "12345678123", "tomas11@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Test if two clients are equal with just phoneNumber equal
     */
    @Test
    public void checkEqualsJustPhoneNumberEqual() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123123", "1234567843", "1234567832", "23/12/2010", "male", "12345678901", "tomas@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Miguel", "1234567890123456", "1234567891", "1234567890", "23/12/2011", "female", "12345678901", "tomas11@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Test if two clients are equal with just nhsNumber equal
     */
    @Test
    public void checkEqualsJustNhsNumberEqual() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123412", "1234567812", "1234567897", "23/12/2010", "male", "12345678931", "tomas@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Miguel", "1234567890123456", "1234567842", "1234567892", "23/12/2011", "female", "12345678921", "tomas11@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Test if two clients are equal with just nhsNumber different
     */
    @Test
    public void checkEqualsJustNhsNumberDifferent() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123412", "1234567812", "1234567897", "23/12/2010", "male", "12345678931", "tomas@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Tomás", "1234567890123412", "1234567842", "1234567897", "23/12/2010", "male", "12345678931", "tomas@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Test if two clients are equal with just tinNumber equal
     */
    @Test
    public void checkEqualsJustTinNumberEqual() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567897", "1234567821", "23/12/2010", "male", "12345678921", "tomas@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Miguel", "1234567890123443", "1234567892", "1234561230", "23/12/2011", "female", "12345678901", "tomas11@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Test if two clients are equal with just tinNumber different
     */
    @Test
    public void checkEqualsJustTinNumberDifferent() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123456", "1234567897", "1234567821", "23/12/2010", "male", "12345678921", "tomas11@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Tomás", "1234567890123456", "1234567897", "1234561230", "23/12/2010", "male", "12345678921", "tomas11@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Test if two clients are equal with just email equal
     */
    @Test
    public void checkEqualsJustEmailEqual() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123234", "1234567123", "1234567890", "23/12/2010", "male", "12345678921", "tomas2@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Miguel", "1234567890123443", "1234567891", "1234567456", "23/12/2001", "female", "12345678901", "tomas2@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Test if two clients are equal with just email different
     */
    @Test
    public void checkEqualsJustEmailDifferent() {
        ClientDTO ct01 = new ClientDTO("Tomás", "1234567890123234", "1234567123", "1234567890", "23/12/2010", "male", "12345678921", "miguel@isep.ipp.pt", "street 1");
        ClientDTO ct02 = new ClientDTO("Tomás", "1234567890123234", "1234567123", "1234567890", "23/12/2010", "male", "12345678921", "tomas11@isep.ipp.pt", "street 1");
        assertNotEquals(ct01, ct02);
    }

    /**
     * Tests with Citizen Card Number null value
     */
    @Test(expected = NullPointerException.class)
    public void checkCitizenCardNumberNull() {
        ClientDTO dto = new ClientDTO("Tomás", null, "1234567123", "1234567890", "23/12/2010", "male", "12345678921", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with Nhs number null value
     */
    @Test(expected = NullPointerException.class)
    public void checkNhsNumberNull() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123443", null, "1234567890", "23/12/2010", "male", "12345678921", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with Tin number null value
     */
    @Test(expected = NullPointerException.class)
    public void checkTinNumberNull() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123443", "1234567123", null, "23/12/2010", "male", "12345678921", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

    /**
     * Tests with Birth date null value
     */
    @Test(expected = NullPointerException.class)
    public void checkBirthDateNumberNull() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123443", "1234567123", "1234567890", null, "male", "12345678921", "tomas@isep.ipp.pt", "street 1");
        new Client(dto);
    }

}