package app.domain.model;

import org.junit.Assert;
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
        Client ct = new Client(null, 0, 0, null,"male", 12345678901L, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNameHasLessThan35Char(){
        Client ct = new Client("Maria Josefina Amaro Silva Costa Miguel",1234567890L,1234567890L,"23/12/03","male",12345678901L,"mariajosefina69@yalol.com");
    }
    @Test (expected = IllegalArgumentException.class)
    public void ensureThatNameNotHaveAlphanumericarChar(){
        Client ct = new Client("To<más",1234567890,1234567890,"23/12/2010","male",12345678901L, "tomas@isep.ipp.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameBirthDateSexEmailCannotBeBlank() {
        Client ct = new Client(" ", 0, 1234567890, "", "", 12345678901L, "");
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
    public void checkIfTwoClientsAreEqualWithOneNull(){
        Client ct01 = new Client("Tomás", 9876543213L, 9876543213L, "23/12/88", "Male", 98765432132L, "tomas1@isep.ipp.pt");
        Client ct02 = null;
        boolean expected = false;
        assertEquals(expected, ct01.equals(ct02));

    }

    @Test (expected = IllegalArgumentException.class)
    public void checkNameWrong(){
        Client ct01 = new Client("Tom@s", 9876543213L, 9876543213L, "23/12/88", "Male", 98765432132L, "tomas1@isep.ipp.pt");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkNhsWrong(){
        Client ct01 = new Client("Tomás", 987654321311L, 9876543213L, "23/12/88", "Male", 98765432132L, "tomas1@isep.ipp.pt");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkTinWrong(){
        Client ct01 = new Client("Tomás", 9876543213L, 987654321311L, "23/12/88", "Male", 98765432132L, "tomas1@isep.ipp.pt");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkBirthDateWrong(){
        Client ct01 = new Client("Tomás", 9876543213L, 9876543213L, "23/12/8888", "Male", 98765432132L, "tomas1@isep.ipp.pt");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkSexWrong(){
        Client ct01 = new Client("Tomás", 9876543213L, 9876543213L, "23/12/8888", "lololol", 98765432132L, "tomas1@isep.ipp.pt");
    }


    @Test
    public void checkGetName(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "Tomás";
        assertEquals(expected,ct01.getName());
    }

    @Test
    public void checkSetName(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        ct01.setName("Miguel");
        String expected= "Miguel";
        assertEquals(expected,ct01.getName());
    }

    @Test
    public void checkGetNhsNumber(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        long expected = 1234567890;
        assertEquals(expected,ct01.getNhsNumber());
    }

    @Test
    public void checkSetNhsNumber(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        ct01.setNhsNumber(1234567891);
        long expected= 1234567891;
        assertEquals(expected,ct01.getNhsNumber());
    }


    @Test
    public void checkGetTinNumber(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        long expected = 1234567891;
        assertEquals(expected,ct01.getTinNumber());
    }

    @Test
    public void checkSetTinNumber(){
        Client ct01 = new Client("Tomas", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        ct01.setTinNumber(1234567890);
        long expected= 1234567890;
        assertEquals(expected,ct01.getTinNumber());
    }

    @Test
    public void checkGetBirthDate(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "23/12/98";
        assertEquals(expected,ct01.getBirthDate());
    }

    @Test
    public void checkSetBirthDate(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        ct01.setBirthDate("24/11/97");
        String expected= "24/11/97";
        assertEquals(expected,ct01.getBirthDate());
    }

    @Test
    public void checkGetSex(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "male";
        assertEquals(expected,ct01.getSex());
    }

    @Test
    public void checkSetSex(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        ct01.setSex("female");
        String expected= "female";
        assertEquals(expected,ct01.getSex());
    }

    @Test
    public void checkPhoneNumber(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        long expected = 12345678901L;
        assertEquals(expected,ct01.getPhoneNumber());
    }

    @Test
    public void checkSetPhoneNumber(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        ct01.setPhoneNumber(12345678911L);
        long expected= 12345678911L;
        assertEquals(expected,ct01.getPhoneNumber());
    }

    @Test
    public void checkEmail(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "tomas@isep.ipp.pt";
        assertEquals(expected,ct01.getEmail());
    }

    @Test
    public void checkSetEmail(){
        Client ct01 = new Client("Tomás", 1234567890,1234567891, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        ct01.setEmail("tomasmiguel@isep.ipp.pt");
        String expected= "tomasmiguel@isep.ipp.pt";
        assertEquals(expected,ct01.getEmail());
    }

    @Test (expected = UnknownFormatConversionException.class)
    public void checkToStringMethod(){
        Client ct01 = new Client("Tomás", 1234567890,1234567890, "23/12/98","male",12345678901L,"tomas@isep.ipp.pt");
        String expected = "Client:%nName: Tomás%nNHS number: 1234567890%nTIN number: 1234567890%nBirth date: 23/12/98%nSex: male%nPhone number: 12345678901%nEmail: tomas@isep.ipp.pt";
        assertEquals(expected, ct01.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkEqualsJustPhoneNumberEqual(){
        Client ct01= new Client ("Tomás", 1234567890,1234567890,"23/12/20","male",12345678901L,"tomas@isep.ipp.pt");
        Client ct02= new Client ("Miguel", 1234567891,1234567891,"23/12/22","female",12345678901L,"tomas11@isep.ipp.pt");
        assertEquals(ct01,ct02);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkEqualsJustNhsNumberEqual(){
        Client ct01= new Client ("Tomás", 1234567890,1234567890,"23/12/20","male",12345678901L,"tomas@isep.ipp.pt");
        Client ct02= new Client ("Miguel", 1234567890,1234567891,"23/12/22","female",12345678902L,"tomas11@isep.ipp.pt");
        assertEquals(ct01,ct02);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkEqualsJustTinNumberEqual(){
        Client ct01= new Client ("Tomás", 1234567890,1234567890,"23/12/20","male",12345678901L,"tomas@isep.ipp.pt");
        Client ct02= new Client ("Miguel", 1234567891,1234567890,"21/12/22","female",12345678902L,"tomas11@isep.ipp.pt");
        assertEquals(ct01,ct02);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkEqualsJustEmailEqual(){
        Client ct01= new Client ("Tomás", 1234567890,1234567890,"23/12/20","male",12345678901L,"tomas@isep.ipp.pt");
        Client ct02= new Client ("Miguel", 1234567891,1234567891,"21/12/22","female",12345678902L,"tomas@isep.ipp.pt");
        assertEquals(ct01,ct02);
    }








    @Test
    public void validateClient() {
    }


}