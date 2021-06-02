//package app.controller;
//
//
//import app.mappers.dto.ClientDTO;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class RegisterClientControllerTest {
//    RegisterClientController ctrl = new RegisterClientController();
//
//    @Test(expected = NullPointerException.class)
//    public void ensureNullClientIsNotCreated() {
//        ClientDTO dto = new ClientDTO(null,null,null,null,null,null,null,null);
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureClientIsNotCreatedWithBlankAttributes() {
//        ClientDTO dto = new ClientDTO("", "", "","","","","","");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureNonAlphaNumericNameAreNotAccepted() {
//        ClientDTO dto = new ClientDTO("Tom<s@", "1234567890123211", "1234567890", "1234567890", "23/12/2002", "male", "12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureNameCannotHaveMoreThan35Char() {
//        ClientDTO dto = new ClientDTO("Maria Conceição Fonseca Pimentel Pires","1234567890123451","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test
//    public void ensureNameCanHave35Char() {
//        ClientDTO dto = new ClientDTO("Maria Josefina Amaro Silva Costa Ló","1234567890123456","1234567891","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureNameCannotBeCreatedBlank() {
//        ClientDTO dto = new ClientDTO("","","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureCitizenCardNumberCannotBeCreatedBlank() {
//        ClientDTO dto = new ClientDTO("Tomás", "","1234567321","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test
//    public void ensureCitizenCardNumberCanHave16Char() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123111","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        assertTrue(ctrl.newClient(dto));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureCitizenCardNumberCannotHaveMoreAndLessThan16Char() {
//        ClientDTO dto = new ClientDTO("Tomás", "12345678901234561","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureNhsCannotBeCreatedBlank() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456","jjjj","1234567890","23/12/2002","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test
//    public void ensureNhsCanHave10Char() {
//        ClientDTO dto = new ClientDTO("Tomás", "2314124351325213","3242334234","2412341234","23/12/2002","male","32412323434", "tomas@isep.ipp.pt");
//        assertTrue(ctrl.newClient(dto));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureNhsCannotBeHaveMoreAndLessThan10Char() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456","12345678911","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureTinCannotBeCreatedBlank() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123789","1234567890","","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test
//    public void ensureTinCanHave10Char() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123312","1234567890","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        assertTrue(ctrl.newClient(dto));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureTinCannotBeHaveMoreAndLessThan10Char() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123098","1234567890","12345678901","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureDateOfBirthCannotBeCreatedBlank() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123432","1234567890","1234567890","","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureDateOfBirthCannotBeInWrongFormat() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123412","1234567890","1234567890","2002/23/12","male","12345678901", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
///*
//    @Test
//    public void ensureSexCanBeMaleFemale() {
//        ClientDTO dto = new ClientDTO("Tomás", "5647486978760780","4562546756","4567667678","23/12/2002","male","5475668678", "tomas@isep.ipp.pt");
//        assertTrue(ctrl.newClient(dto));
//    }*/
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureSexCannotBeDifferentThanMaleFemale() {
//        ClientDTO dto = new ClientDTO("Tomás", "3425434645654658","4265675867","3567568358","23/12/2002","madeira","35675668568", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensurePhoneNumberCannotBeCreatedBlank() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123443","1234567890","1234567890","23/12/2002","male","", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
///*
//    @Test
//    public void ensurePhoneNumberCanHave11Char() {
//        ClientDTO dto = new ClientDTO("Tomás", "1324123445123453","1234341234","2443477887","23/12/2002","male","41324334657", "tom@isep.ipp.pt");
//        assertTrue(ctrl.newClient(dto));
//    }*/
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensurePhoneNumberCannotHaveMoreLessThan11Char() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123462","1234567890","1234567890","23/12/2002","male","123456789101", "tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureEmailCannotBeCreatedBlank() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123457","1234567890","1234567890","23/12/2002","male","12345678901", "");
//        ctrl.newClient(dto);
//    }
//
//    @Test
//    public void ensureEmailHaveValidFormat() {
//        ClientDTO dto = new ClientDTO("Tomás", "3546656788907890","2341443543","1234567890","23/12/2002","male","12345678901", "tomas@isep.ipp.pt");
//        assertTrue(ctrl.newClient(dto));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void ensureEmailCannotBeCreatedInInvalidFormat() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123451","1234567890","1234567890","23/12/2002","male","12345678901", "tomasisep.ipp.pt");
//        ctrl.newClient(dto);
//    }
//
//    @Test
//    public void ensureCannotCreateSameClientTwice() {
//        ClientDTO dto = new ClientDTO("Tomás", "1234567890123455","1234567890","1234567890","23/12/2000","male","12345678901","tomas@isep.ipp.pt");
//        ctrl.newClient(dto);
//        ctrl.saveClient();
//        ClientDTO dto1 = new ClientDTO("Tomás", "1234567890123455","1234567890","1234567890","23/12/2000","male","12345678901","tomas@isep.ipp.pt");
//        ctrl.newClient(dto1);
//        assertFalse(ctrl.saveClient());
//    }
//
//}
