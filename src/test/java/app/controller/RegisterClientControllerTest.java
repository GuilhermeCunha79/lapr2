package app.controller;

import app.domain.dto.ClientDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterClientControllerTest {
    RegisterClientController ctrl = new RegisterClientController();

    @Test(expected = NullPointerException.class)
    public void ensureNullClientIsNotCreated() {
        ClientDto dto = new ClientDto(null,null,null,null,null,null,null,null);
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureClientIsNotCreatedWithBlankAttributes() {
        ClientDto dto = new ClientDto("", "", "","","","","","");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericNameAreNotAccepted() {
        ClientDto dto = new ClientDto("Tom<s@", "1234567890123211", "1234567890", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan35Char() {
        ClientDto dto = new ClientDto("Maria Conceição Fonseca Pimentel Pires","1234567890123451","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test
    public void ensureNameCanHave35Char() {
        ClientDto dto = new ClientDto("Maria Josefina Amaro Silva Costa Ló","1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        assertTrue(ctrl.newClient(dto));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeCreatedBlank() {
        ClientDto dto = new ClientDto("","","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCitizenCardNumberCannotBeCreatedBlank() {
        ClientDto dto = new ClientDto("Tomás", "","1234567321","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test
    public void ensureCitizenCardNumberCanHave16Char() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123111","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        assertTrue(ctrl.newClient(dto));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCitizenCardNumberCannotHaveMoreAndLessThan16Char() {
        ClientDto dto = new ClientDto("Tomás", "12345678901234561","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCannotBeCreatedBlank() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123456","jjjj","1234567890","23/12/2002","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test
    public void ensureNhsCanHave10Char() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123345","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        assertTrue(ctrl.newClient(dto));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCannotBeHaveMoreAndLessThan10Char() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123456","12345678911","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinCannotBeCreatedBlank() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123789","1234567890","","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test
    public void ensureTinCanHave10Char() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123312","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        assertTrue(ctrl.newClient(dto));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinCannotBeHaveMoreAndLessThan10Char() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123098","1234567890","12345678901","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDateOfBirthCannotBeCreatedBlank() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123432","1234567890","1234567890","","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDateOfBirthCannotBeInWrongFormat() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123412","1234567890","1234567890","2002/23/12","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSexCannotBeCreatedBlank() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123498","1234567890","1234567890","23/12/2002","","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test
    public void ensureSexCanBeMaleFemale() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123467","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSexCannotBeDifferentThanMaleFemale() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123429","1234567890","1234567890","23/12/2002","madeira","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotBeCreatedBlank() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123443","1234567890","1234567890","23/12/2002","male","", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test
    public void ensurePhoneNumberCanHave11Char() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123417","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotHaveMoreLessThan11Char() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123462","1234567890","1234567890","23/12/2002","male","123456789101", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEmailCannotBeCreatedBlank() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123457","1234567890","1234567890","23/12/2002","male","12345678901", "");
        ctrl.newClient(dto);
    }

    @Test
    public void ensureEmailHaveValidFormat() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123452","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEmailCannotBeCreatedInInvalidFormat() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123451","1234567890","1234567890","23/12/2002","male","12345678901", "tomasisep.ipp.pt");
        ctrl.newClient(dto);
    }

    @Test
    public void ensureCannotCreateSameClientTwice() {
        ClientDto dto = new ClientDto("Tomás", "1234567890123455","1234567890","1234567890","23/12/2000","male","12345678901","tomas@isep.ipp.pt");
        ctrl.newClient(dto);
        ctrl.saveClient();
        ClientDto dto1 = new ClientDto("Tomás", "1234567890123455","1234567890","1234567890","23/12/2000","male","12345678901","tomas@isep.ipp.pt");
        ctrl.newClient(dto1);
        assertFalse(ctrl.saveClient());
    }

}