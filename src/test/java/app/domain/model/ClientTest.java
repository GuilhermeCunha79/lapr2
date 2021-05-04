package app.domain.model;

import org.junit.Test;

import java.util.UnknownFormatConversionException;

import static org.junit.Assert.*;

public class ClientTest {

    @Test(expected = IllegalArgumentException.class)
    public void garanteeNullClientIsntCreatedWithAllDataAndSex() {
        Client ct = new Client(null, 0, 0, null, null, 0, null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void garanteeNullClientIsntCreatedWithoutSex() {
        Client ct = new Client(null, 0, 0, null, 12345678901L, null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureNameBirthDateSexEmailCannotBeBlank() {
        Client ct = new Client(" ", 0, 1234567890, "", "", 1234567890, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsAndTinCannotHaveMoreAndLessThan10Characters() {
        Client ct = new Client("Tomás", 1234567890, 1234567890, "23/12/98", "male", 1234567890, "tomas@isep.ipp.pt");
    }

    @Test
    public void ensureThatSexOnlyAcceptMaleFemale(){
        Client ct = new Client("Tomás", 1234567890,1234567890, "23/12/98","Male",12345678901L,"tomas@isep.ipp.pt");
    }

    @Test
    public void checkIfTwoClientsAreEqual() {
        Client ct01 = new Client("Tomás", 1234567890, 1234567890, "23/12/98", "male", 12345678901L, "tomas@isep.ipp.pt");
        Client ct02 = new Client("Tomás", 1234567890, 1234567890, "23/12/98", "male", 12345678901L, "tomas@isep.ipp.pt");
        assertEquals(ct01, ct02);
    }


    @Test
    public void checkIfTwoClientsAreDifferents() {
        Client ct01 = new Client("Tomás", 9876543213L, 9876543213L, "23/12/88", "Male", 98765432132L, "tomas1@isep.ipp.pt");
        Client ct02 = new Client("Tomás", 1234567890, 1234567890, "23/12/98", "Female", 12345678901L, "tomas@isep.ipp.pt");
        assertNotEquals(ct01, ct02);
    }


    @Test
    public void checkGetName(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "Tomás";
        assertEquals(expected,ct01.getName());
    }

    @Test
    public void checkGetNhsNumber(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        long expected = 1234567890;
        assertEquals(expected,ct01.getNhsNumber());
    }

    @Test
    public void checkGetTinNumber(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        long expected = 1234567891;
        assertEquals(expected,ct01.getTinNumber());
    }

    @Test
    public void checkGetBirthDate(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "23/12/98";
        assertEquals(expected,ct01.getBirthDate());
    }

    @Test
    public void checkGetSex(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "male";
        assertEquals(expected,ct01.getSex());
    }

    @Test
    public void checkPhoneNumber(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        long expected = 12345678901L;
        assertEquals(expected,ct01.getPhoneNumber());
    }

    @Test
    public void checkEmail(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "tomas@isep.ipp.pt";
        assertEquals(expected,ct01.getEmail());
    }

    @Test (expected = UnknownFormatConversionException.class)
    public void checkToStringMethod(){
        Client ct01 = new Client("Tomás", 1234567890,1234567890, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "Client:%nName: Tomás%nNHS number: 1234567890%nTIN number: 1234567890%nBirth date: 23/12/98%nSex: male%nPhone number: 12345678901%nEmail: tomas@isep.ipp.pt";
        assertEquals(expected, ct01.toString());
    }

    @Test
    public void validateClient() {
    }


}