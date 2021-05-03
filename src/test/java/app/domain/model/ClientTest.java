package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test(expected = IllegalArgumentException.class)
    public void garanteeNullClientIsntCreatedWithPhoneNumberAndSex() {
        Client ct = new Client(null, 0, 0, null, null, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void garanteeNullClientIsntCreatedWithSex() {
        Client ct = new Client(null, 0, 0, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void garanteeNullClientIsntCreatedWithPhoneNumber() {
        Client ct = new Client(null, 0, 0, null, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameBirthDateSexEmailCannotBeBlank() {
        Client ct = new Client(" ", 0, 1234567890, "", "", 1234567890, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsAndTinCannotHaveMoreAndLessThan10Characters() {
        Client ct = new Client("Tomás", 1234567890, 1234567890, "23/12/98", "male", 1234567890, "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatSexOnlyAcceptMaleFemale(){
        Client ct = new Client("Tomás", 1234567890,1234567890, "23/12/98","male","tomas@isep.ipp.pt");
    }

    @Test
    public void checkIfTwoClientsAreEqual() {
        Client ct01 = new Client("Tomás", 1234567890, 1234567890, "23/12/88", "male", 12345678901L, "tomas@isep.ipp.pt");
        Client ct02 = new Client("Miguel", 1234567890, 1234567890, "23/12/98", "female", 12345678901L, "tomas@isep.ipp.pt");
        assertTrue(ct01.equals(ct02));
    }

    @Test
    public void getNhsNumber() {
    }

    @Test
    public void setNhsNumber() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getTinNumber() {
    }

    @Test
    public void setTinNumber() {
    }

    @Test
    public void getBirthDate() {
    }

    @Test
    public void setBirthDate() {
    }

    @Test
    public void getSex() {
    }

    @Test
    public void setSex() {
    }

    @Test
    public void getPhoneNumber() {
    }

    @Test
    public void setPhoneNumber() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void setEmail() {
    }

    @Test
    public void validateClient() {
    }

    @Test
    public void testEquals() {
    }
}