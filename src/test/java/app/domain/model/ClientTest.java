package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test(expected = NullPointerException.class)
    public void garanteeNullClientIsntCreatedWithPhoneNumberAndSex() {
        Client ct = new Client(0, null, 0, null, null, 0, null);
    }

    @Test(expected = NullPointerException.class)
    public void garanteeNullClientIsntCreatedWithSex() {
        Client ct = new Client(0, null, 0, null, null, null);
    }

    @Test(expected = NullPointerException.class)
    public void garanteeNullClientIsntCreatedWithPhoneNumber() {
        Client ct = new Client(0, null, 0, null, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameBirthDateSexEmailCannotBeBlank() {
        Client ct = new Client(1234567890,"", 123456789, "", "", 12345678901,"");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsAndTinCannotHaveMoreAndLessThan10Characters(){
        Client ct = new Client(1234567890,"Tomás",1234567890,"23/12/98","male",12345678901,"tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatSexOnlyAcceptMaleFemale(){
        Client
    }

    @Test
    public void checkIfDifferentClientsAreEqual(){
        Client ct01 = new Client(1234567890,"Tomás", 123456789,"23/12/98","male",12345678901,"tomas@isep.ipp.pt");
        Client ct02 = new Client(1234567890,"Tomás", 123456789,"23/12/98","male",12345678901,"tomas@isep.ipp.pt");
        assertTrue(ct01.equals(ct02));
    }
}