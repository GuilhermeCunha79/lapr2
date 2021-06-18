package app.domain.store;

import app.mappers.dto.ClientDTO;
import app.domain.model.Client;
import auth.domain.model.Email;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ClientStoreTest {

    ClientStore cls = new ClientStore();

    @Before
    public void createClientList() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456","1234567890","1234567890","23/12/2002","male","12345678901","tomas@isep.ipp.pt", "street 1");
        Client ct01 = cls.newClient(dto);
        cls.saveClient(ct01);
    }


    @Test
    public void ensureCannotAddSameClientTwice() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567890123456","1234536890","1234505890","23/12/2002","male","12345634901","tomas@gmail.pt", "street 1");
        Client ct01 = cls.newClient(dto);
        Client ct02 = cls.newClient(dto);
        cls.saveClient(ct01);
        assertFalse(cls.saveClient(ct02));
    }


    @Test
    public void testSaveChanges() {
        ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234569990","23/12/2002","male","12345679901","tomas@outlook.pt", "street 3");
        Client ct01 = cls.newClient(dto);
        assertTrue(cls.saveChanges(ct01));
    }

    @Test(expected = NullPointerException.class)
    public void testSaveChangesNull() {
        Client ct01 = cls.newClient(null);
        assertTrue(cls.saveChanges(ct01));
    }

   @Test
   public void getClientListTest(){
       ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234569990","23/12/2002","male","12345679901","tomas@isep.ipp.pt", "street 3");
       Client ct01 = cls.newClient(dto);
       List<Client> clientList=new ArrayList<>();
       clientList.add(ct01);

       assertEquals(clientList,cls.getClientList());
   }

   @Test
    public void getClientByTIN(){
       ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234567890","23/12/2002","male","12345679901","tomas@isep.ipp.pt", "street 3");
       Client ct01 = cls.newClient(dto);
       String tin="1234567890";
       assertEquals(ct01,cls.getClientByTIN(tin));
   }

   @Test
    public void changeNameTest(){
       ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234567890","23/12/2002","male","12345679901","tomas@isep.ipp.pt", "street 3");
       Client ct01 = cls.newClient(dto);
       cls.changeName(ct01, "roberto");
       String expected= "roberto";
       assertEquals(expected,ct01.getName());
   }

    @Test
    public void changeAddressTest(){
        ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234567890","23/12/2002","male","12345679901","tomas@isep.ipp.pt", "street 3");
        Client ct01 = cls.newClient(dto);
        cls.changeAddress(ct01, "street 56565");
        String expected= "street 56565";
        assertEquals(expected,ct01.getAddress());
    }

    @Test
    public void changeSexTest(){
        ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234567890","23/12/2002","male","12345679901","tomas@isep.ipp.pt", "street 3");
        Client ct01 = cls.newClient(dto);
        cls.changeSex(ct01, "female");
        String expected= "female";
        assertEquals(expected,ct01.getSex());
    }

    @Test
    public void changePhoneNumberTest(){
        ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234567890","23/12/2002","male","12345679901","tomas@isep.ipp.pt", "street 3");
        Client ct01 = cls.newClient(dto);
        cls.changePhoneNumber(ct01, "12121212122");
        String expected= "12121212122";
        assertEquals(expected,ct01.getPhoneNumber());
    }

    @Test
    public void changePhoneNumberToAnExistingOneTest(){
        ClientDTO dto = new ClientDTO("Tomás", "1234567899123456","1239567890","1234567890","23/12/2002","male","12345679901","tomas@isep.ipp.pt", "street 3");
        Client ct01 = cls.newClient(dto);
        ClientDTO dto1 = new ClientDTO("Tomás", "1231567899123456","1239167890","1234167890","23/12/2002","male","11345679901","tomas1@isep.ipp.pt", "street 31");
        Client ct02 = cls.newClient(dto1);
        assertTrue(cls.changePhoneNumber(ct02, "12345679901"));

    }



/*
    @Test
    public void testSaveClient() {
        ClientDTO dto = new ClientDTO("Tom", "1234567490624856","1244157490","1214557490","23/12/2002","male","14445518901","to@yahoo.pt", "street 4");
        Client ct01 = cls.newClient(dto);
        assertTrue(cls.saveClient(ct01));
    }
    */
}