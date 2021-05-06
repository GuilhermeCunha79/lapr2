package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


import static app.domain.model.Client.calculateAge;
import static org.junit.Assert.*;

public class ClientTest {

    @Test(expected = IllegalArgumentException.class)
    public void garanteeNullClientIsntCreatedWithAllDataAndSex() {
        Client ct = new Client(null, null, null, null, null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void garanteeNullClientIsntCreatedWithoutSex() {
        Client ct = new Client(null, null, null, null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNameHasLessThan35Char() {
        Client ct = new Client("Mariana Josefina Amaro Silva Costa Lópes", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "mariajosefina69@yalol.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNameCanHave35Char() {
        Client ct = new Client("Maria Josefina Amaro Silva Costa Lóp", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "mariajosefina69@yalol.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsCanHave10Char() {
        Client ct = new Client("Maria Josefina", "1234567890123456", "1234567890L", "1234567890", "23/12/2001", "male", "12345678901", "mariajosefina69@yalol.com");
    }

    @Test
    public void ensureThatPhoneNumberHave11Char() {
        Client ct = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNameNotHaveAlphanumericarChar() {
        Client ct = new Client("To<más", "1234567890123456", "1234567891", "1234567890", "23/12/2010", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeBlank() {
        Client ct = new Client("", "1234567890123456", "1234567891", "1234567890", "23/02/2001", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCitizenCardNumberCannotBeBlank() {
        Client ct = new Client("Tomas", "", "1234567891", "1234567890", "23/02/2001", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatEmailIsNotBlank() {
        Client ct = new Client("Miguel", "1234567890123456", "1234567891", "1234567890", "23/02/2001", "male", "12345678901", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsIsNotBlank() {
        Client ct = new Client("Miguel", "1234567890123456", "", "1234567890", "23/02/2001", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinIsNotBlank() {
        Client ct = new Client("Miguel", "1234567890123456", "1234567891", "", "23/02/2001", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatBirthDateIsNotBlank() {
        Client ct = new Client("Miguel", "1234567890123456", "1234567891", "1234567890", "", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatSexIsNotBlank() {
        Client ct = new Client("Miguel", "1234567890123456", "1234567891", "1234567890", "23/02/2001", "", "12345678901", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberIsNotBlank() {
        Client ct = new Client("Miguel", "1234567890123456", "1234567891", "1234567890", "23/02/2001", "male", "", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneCantHaveMoreAndLessThan11Char() {
        Client ct = new Client ("Miguel", "1234567890123456", "1234567891", "1234567890", "23/02/2001", "male", "12345", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsAndTinCannotHaveMoreAndLessThan10Characters() {
        Client ct = new Client("Tomás", "1234567890123456", "12345678901", "12345678901", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCitizenCardNumberCannotHaveMore16Characters() {
        Client ct = new Client("Tomás", "12345678901234568", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCitizenCardNumberCannotHaveLessAndMore16Characters() {
        Client ct = new Client("Tomás", "12345678901234567", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatSexOnlyAcceptMaleFemale() {
        Client ct = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "madeira", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test
    public void checkIfTwoClientsAreEqual() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        Client ct02 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        assertEquals(ct01, ct02);
    }

    @Test
    public void checkIfTwoClientsAreDifferents() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567887", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt");
        Client ct02 = new Client("Miguel", "1234567890123232", "1234567891", "1234567890", "21/12/2001", "Female", "34545678901", "111111@isep.ipp.pt");
        assertNotEquals(ct01, ct02);
    }

    @Test
    public void checkIfClientIsNull() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt");
        Client ct02 = null;
        boolean expected = false;
        assertEquals(expected, ct01.equals(ct02));

    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNameWrongFirstConstructor() {
        Client ct01 = new Client("Tom1s", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNameWrongSecondConstructor() {
        Client ct01 = new Client("Tom1s", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberWrongFirstConstructor() {
        Client ct01 = new Client("Tomás", "123456789012345688", "1234567891", "1234567890", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberWrongSecondConstructor() {
        Client ct01 = new Client("Tomás", "123456789012345688", "1234567891", "1234567890", "23/12/2001", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test
    public void checkNhsWrongFirstConstructor() {
        Client ct01 = new Client("Tomás", "1234567890123456", "987654321311", "1234567890", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test
    public void checkNhsWrongSecondConstructor() {
        Client ct01 = new Client("Tomás", "1234567890123456", "987654321", "1234567890", "23/12/2001", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTinWrongFirstConstructor() {
        Client ct01 = new Client("Tomás", "1234567890123456", "9876543213", "987654321311", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTinWrongSecondConstructor() {
        Client ct01 = new Client("Tomás", "1234567890123456", "9876543213", "987654321311", "23/12/2001", "Male", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkBirthDateWrongFirstConstructor() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/20011", "Male", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkBirthDateWrongSecondConstructor() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/20011", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSexWrong() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "madeira", "12345678901", "tomas1@isep.ipp.pt");

    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfStringJustHaveNumbers(){
        Client ct01 = new Client("Tomás", "1234567890123456", "123456789a", "1234567890", "23/12/2001", "madeira", "12345678901", "tomas1@isep.ipp.pt");
    }

    @Test
    public void checkCalculateAge() {
        LocalDate birthDate = LocalDate.of(1961, 5, 17);
        int actual = calculateAge(birthDate, LocalDate.of(2016, 7, 12));
        Assert.assertEquals(55, actual);
    }



    @Test
    public void checkGetName() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = "Tomás";
        assertEquals(expected, ct01.getName());
    }

    @Test
    public void checkSetName() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        ct01.setName("Miguel");
        String expected = "Miguel";
        assertEquals(expected, ct01.getName());
    }

    @Test
    public void checkGetCitizenCardNumber() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = "1234567890123456";
        assertEquals(expected, ct01.getCitizenCardNumber());
    }

    @Test
    public void checkSetCitizenCardNumber() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        ct01.setCitizenCardNumber("1234567890123456");
        String expected = "1234567890123456";
        assertEquals(expected, ct01.getCitizenCardNumber());
    }

    @Test
    public void checkGetNhsNumber() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567890", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = "1234567890";
        assertEquals(expected, ct01.getNhsNumber());
    }

    @Test
    public void checkSetNhsNumber() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        ct01.setNhsNumber("1234567890");
        String expected = "1234567890";
        assertEquals(expected, ct01.getNhsNumber());
    }


    @Test
    public void checkGetTinNumber() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = "1234567890";
        assertEquals(expected, ct01.getTinNumber());
    }

    @Test
    public void checkSetTinNumber() {
        Client ct01 = new Client("Tomas", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        ct01.setTinNumber("1234567890");
        String expected = "1234567890";
        assertEquals(expected, ct01.getTinNumber());
    }

    @Test
    public void checkGetBirthDate() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2000", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = "23/12/2000";
        assertEquals(expected, ct01.getBirthDate());
    }

    @Test
    public void checkSetBirthDate() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt");
        ct01.setBirthDate("24/11/2002");
        String expected = "24/11/2002";
        assertEquals(expected, ct01.getBirthDate());
    }

    @Test
    public void checkGetSex() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = "male";
        assertEquals(expected, ct01.getSex());
    }

    @Test
    public void checkSetSex() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        ct01.setSex("female");
        String expected = "female";
        assertEquals(expected, ct01.getSex());
    }

    @Test
    public void checkPhoneNumber() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = "12345678901";
        assertEquals(expected, ct01.getPhoneNumber());
    }

    @Test
    public void checkSetPhoneNumber() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        ct01.setPhoneNumber("12345678901");
        String expected = "12345678901";
        assertEquals(expected, ct01.getPhoneNumber());
    }

    @Test
    public void checkEmail() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = "tomas@isep.ipp.pt";
        assertEquals(expected, ct01.getEmail());
    }

    @Test
    public void checkSetEmail() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        ct01.setEmail("tomasmiguel@isep.ipp.pt");
        String expected = "tomasmiguel@isep.ipp.pt";
        assertEquals(expected, ct01.getEmail());
    }

    @Test
    public void checkToStringMethod() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567891", "1234567890", "23/12/2001", "male", "12345678901", "tomas@isep.ipp.pt");
        String expected = String.format("Client:%nName: Tomás%nCitizen Card Number: 1234567890123456%nNHS number: 1234567891%nTIN number: 1234567890%nBirth date: 23/12/2001%nSex: male%nPhone number: 12345678901%nEmail: tomas@isep.ipp.pt");
        assertEquals(expected, ct01.toString());
    }

    @Test
    public void validateClientCorrect() {
        Client ct01 = new Client("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        boolean result = Client.validateClient(ct01);
        assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateClientError() {
        Client ct01 = new Client(null, null,"12345678",null,null,"male",null,null);
        boolean result = Client.validateClient(ct01);
        assertFalse(result);
    }

    @Test
    public void checkEqualsJustNameEqual() {
        Client ct01 = new Client("Miguel", "1234567890123456", "1234567891", "1234567831", "23/12/2001", "male", "12345678211", "tomas@isep.ipp.pt");
        Client ct02 = new Client("Miguel", "1234567890123456", "1234567891", "1234567123", "23/12/2002", "female", "12345678945", "tomas11@isep.ipp.pt");
        assertNotEquals(ct01, ct02);
    }

    @Test
    public void checkEqualsJustFalseCitizenCardNumberEqual() {
        Client ct01 = new Client("Tomás","1234567890123458" , "1234567891", "1234567123", "23/12/2011", "male", "12345678321", "tomas@isep.ipp.pt");
        Client ct02 = new Client("Miguel", "1234567890123458", "1234567891", "1234567231", "23/12/2010", "female", "12345678123", "tomas11@isep.ipp.pt");
        assertNotEquals(ct01, ct02);
    }


    @Test
    public void checkEqualsJustPhoneNumberEqual() {
        Client ct01 = new Client("Tomás", "1234567890123123", "1234567843", "1234567832", "23/12/2010", "male", "12345678901", "tomas@isep.ipp.pt");
        Client ct02 = new Client("Miguel", "1234567890123456", "1234567891", "1234567890", "23/12/2011", "female", "12345678901", "tomas11@isep.ipp.pt");
        assertNotEquals(ct01, ct02);
    }

    @Test
    public void checkEqualsJustNhsNumberEqual() {
        Client ct01 = new Client("Tomás", "1234567890123412", "1234567812", "1234567897", "23/12/2010", "male", "12345678931", "tomas@isep.ipp.pt");
        Client ct02 = new Client("Miguel", "1234567890123456", "1234567842", "1234567892", "23/12/2011", "female", "12345678921", "tomas11@isep.ipp.pt");
        assertNotEquals(ct01, ct02);
    }

    @Test
    public void checkEqualsJustTinNumberEqual() {
        Client ct01 = new Client("Tomás", "1234567890123456", "1234567897", "1234567821", "23/12/2010", "male", "12345678921", "tomas@isep.ipp.pt");
        Client ct02 = new Client("Miguel", "1234567890123443", "1234567892", "1234561230", "23/12/2011", "female", "12345678901", "tomas11@isep.ipp.pt");
        assertNotEquals(ct01, ct02);
    }

    @Test
    public void checkEqualsJustEmailEqual() {
        Client ct01 = new Client("Tomás", "1234567890123234", "1234567123", "1234567890", "23/12/2010", "male", "12345678921", "tomas@isep.ipp.pt");
        Client ct02 = new Client("Miguel", "1234567890123443", "1234567891", "1234567456", "23/12/2001", "female", "12345678901", "tomas@isep.ipp.pt");
        assertNotEquals(ct01, ct02);



    }
}