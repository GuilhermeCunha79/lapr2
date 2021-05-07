package app.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterClientControllerTest {
    RegisterClientController ctrl = new RegisterClientController();

    @Test(expected = NullPointerException.class)
    public void ensureNullClientIsNotCreated() {
        ctrl.newClient(null, null, null,null,null,null,null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureClientIsNotCreatedWithBlankAttributes() {
        ctrl.newClient("", "", "","","","","","");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericNameAreNotAccepted() {
        ctrl.newClient("Tom<s@", "1234567890123211", "1234567890", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan35Char() {
        ctrl.newClient("Maria Conceição Fonseca Pimentel Pires","1234567890123451","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test
    public void ensureNameCanHave35Char() {
        assertTrue(ctrl.newClient("Maria Josefina Amaro Silva Costa Ló","1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeCreatedBlank() {
        ctrl.newClient("", "1234567890123123","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCitizenCardNumberCannotBeCreatedBlank() {
        ctrl.newClient("Tomás", "","1234567321","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test
    public void ensureCitizenCardNumberCanHave16Char() {
        assertTrue(ctrl.newClient("Tomás", "1234567890123111","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCitizenCardNumberCannotHaveMoreAndLessThan16Char() {
        ctrl.newClient("Tomás", "12345678901234561","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCannotBeCreatedBlank() {
        ctrl.newClient("Tomás", "1234567890123456","","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test
    public void ensureNhsCanHave10Char() {
        assertTrue(ctrl.newClient("Tomás", "1234567890123345","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCannotBeHaveMoreAndLessThan10Char() {
        ctrl.newClient("Tomás", "1234567890123456","12345678911","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinCannotBeCreatedBlank() {
        ctrl.newClient("Tomás", "1234567890123789","1234567890","","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test
    public void ensureTinCanHave10Char() {
        assertTrue(ctrl.newClient("Tomás", "1234567890123312","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinCannotBeHaveMoreAndLessThan10Char() {
        ctrl.newClient("Tomás", "1234567890123098","1234567890","12345678901","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDateOfBirthCannotBeCreatedBlank() {
        ctrl.newClient("Tomás", "1234567890123432","1234567890","1234567890","","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDateOfBirthCannotBeInWrongFormat() {
        ctrl.newClient("Tomás", "1234567890123412","1234567890","1234567890","2002/23/12","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSexCannotBeCreatedBlank() {
        ctrl.newClient("Tomás", "1234567890123498","1234567890","1234567890","23/12/2002","","12345678901", "tomas@isep.ipp.pt");
    }

    @Test
    public void ensureSexCanBeMaleFemale() {
        ctrl.newClient("Tomás", "1234567890123467","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSexCannotBeDifferentThanMaleFemale() {
        ctrl.newClient("Tomás", "1234567890123429","1234567890","1234567890","23/12/2002","madeira","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotBeCreatedBlank() {
        ctrl.newClient("Tomás", "1234567890123443","1234567890","1234567890","23/12/2002","male","", "tomas@isep.ipp.pt");
    }

    @Test
    public void ensurePhoneNumberCanHave11Char() {
        ctrl.newClient("Tomás", "1234567890123417","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotHaveMoreLessThan11Char() {
        ctrl.newClient("Tomás", "1234567890123462","1234567890","1234567890","23/12/2002","male","123456789101", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEmailCannotBeCreatedBlank() {
        ctrl.newClient("Tomás", "1234567890123457","1234567890","1234567890","23/12/2002","male","12345678901", "");
    }

    @Test
    public void ensureEmailHaveValidFormat() {
        ctrl.newClient("Tomás", "1234567890123452","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEmailCannotBeCreatedInInvalidFormat() {
        ctrl.newClient("Tomás", "1234567890123451","1234567890","1234567890","23/12/2002","male","12345678901", "tomasisep.ipp.pt");
    }

    @Test
    public void ensureCannotCreateSameClientTwice() {
        ctrl.newClient("Tomás", "1234567890123455","1234567890","1234567890","23/12/2000","male","12345678901","tomas@isep.ipp.pt");
        ctrl.saveClient();
        ctrl.newClient("Tomás", "1234567890123455","1234567890","1234567890","23/12/2000","male","12345678901","tomas@isep.ipp.pt");
        assertFalse(ctrl.saveClient());
    }

}