package app.domain.mappers;


import app.domain.model.*;
import app.domain.shared.DateTime;
import app.mappers.*;
import app.mappers.dto.ClientDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MappersTest {

    @Test
    public void testParameterCategoryMapper() {
        ParameterCategory pc = new ParameterCategory("12345", "abcd");
        ParameterCategory pc2 = new ParameterCategory("54321", "adaca");
        List<ParameterCategory> lpc = new ArrayList<>();
        lpc.add(pc);
        lpc.add(pc2);
        List<String> expected = new ArrayList<>();
        expected.add(String.format("Parameter Category -> Code: 12345 | Name: abcd |%n"));
        expected.add(String.format("Parameter Category -> Code: 54321 | Name: adaca |%n"));
        assertEquals(expected, ParameterCategoryMapper.toDTO(lpc));
    }

    @Test
    public void testMapperWithoutPCategories() {
        List<ParameterCategory> lpc = new ArrayList<>();
        assertNotNull(ParameterCategoryMapper.toDTO(lpc));
    }

    @Test
    public void testParameterMapper() {
        ParameterCategory pc1 = new ParameterCategory("54321", "adaca");
        Parameter p1 = new Parameter("12345", "abcd", "adsavaa", pc1);
        Parameter p2 = new Parameter("45345", "adsfa", "asdfsdfsd", pc1);
        List<Parameter> lp = new ArrayList<>();
        lp.add(p1);
        lp.add(p2);
        List<String> expected = new ArrayList<>();
        expected.add("Parameter -> Code: 12345 | Name: abcd | Description: adsavaa");
        expected.add("Parameter -> Code: 45345 | Name: adsfa | Description: asdfsdfsd");
        assertEquals(expected, ParameterMapper.toDto(lp));
    }

    @Test
    public void testMapperWithoutParameters() {
        List<Parameter> lp = new ArrayList<>();
        assertEquals(ParameterMapper.toDto(lp), Collections.emptyList());
    }

    @Test
    public void testReadyToValidateMapper() {
        ParameterCategory pc1 = new ParameterCategory("54321", "adaca");
        TypeOfTest tpt = new TypeOfTest("12345", "noth", "mao", pc1);
        TypeOfTest tpt1 = new TypeOfTest("12345", "noteh", "mapo", pc1);
        ClientDTO clDto = new ClientDTO("maria", "1234567890123456", "1234567890", "1234567890", "23/12/2002", "male", "12345678901", "gui@isep.pt", "street 32");
        Parameter p1 = new Parameter("12345", "abcd", "adsavaa", pc1);
        Parameter p2 = new Parameter("45345", "adsfa", "asdfsdfsd", pc1);
        List<Parameter> lp = new ArrayList<>();
        lp.add(p1);
        lp.add(p2);
        List<ClinicalTest> cat = new ArrayList<>();
        Client client = new Client(clDto);
        ClinicalTest ct1 = new ClinicalTest("123456789111", client, tpt, lp, "lol", 2);
        ClinicalTest ct2 = new ClinicalTest("123456783233", client, tpt1, lp, "ll", 3);
        ct1.addReport(new Report("adknfajnf"));
        ct2.addReport(new Report("adknfajnf"));
        cat.add(ct1);
        cat.add(ct2);
        List<String> expected = new ArrayList<>();
        expected.add(String.format("Internal Code: 000000000002 | NHS Code: 123456789111 | Created on: %s | Collected at: null | Reported at: %s |", new DateTime(), new DateTime()));
        expected.add(String.format("Internal Code: 000000000003 | NHS Code: 123456783233 | Created on: %s | Collected at: null | Reported at: %s |", new DateTime(), new DateTime()));
        assertEquals(expected, TestReadyToValidateMapper.toDtoVal(cat));
    }

    @Test(expected = AssertionError.class)
    public void testTestsFinalizedMapper() {
        ParameterCategory pc1 = new ParameterCategory("54321", "adaca");
        TypeOfTest tpt = new TypeOfTest("12345", "noth", "mao", pc1);
        TypeOfTest tpt1 = new TypeOfTest("12345", "noteh", "mapo", pc1);
        ClientDTO clDto = new ClientDTO("maria", "1234567890123456", "1234567890", "1234567890", "23/12/2002", "male", "12345678901", "gui@isep.pt", "street 0");
        Parameter p1 = new Parameter("12345", "abcd", "adsavaa", pc1);
        Parameter p2 = new Parameter("45345", "adsfa", "asdfsdfsd", pc1);
        List<Parameter> lp = new ArrayList<>();
        lp.add(p1);
        lp.add(p2);
        List<ClinicalTest> cat = new ArrayList<>();
        Client client = new Client(clDto);
        ClinicalTest ct1 = new ClinicalTest("123456789111", client, tpt, lp, "lol", 2);
        ClinicalTest ct2 = new ClinicalTest("123456783233", client, tpt1, lp, "ll", 3);
        cat.add(ct1);
        cat.add(ct2);
        ct1.addReport(new Report("adknfajnf"));
        ct2.addReport(new Report("adknfajnf"));
        ct1.addValidation();
        ct2.addValidation();
        List<String> expected = new ArrayList<>();
        expected.add(String.format("Internal Code: 000000000002 | NHS Code: 123456789111 | Created on: %s | Collected at: null | Validated at: %s | Reported at: %s | %n | Report: adknfajnf |%n", new DateTime(), new DateTime(), new DateTime()));
        expected.add(String.format("Internal Code: 000000000003 | NHS Code: 123456783233 | Created on: %s | Collected at: null | Validated at: %s | Reported at: %s | %n | Report: adknfajnf |%n", new DateTime(), new DateTime(), new DateTime()));
        assertEquals(expected, TestsFinalizedMapper.toDtoFin(cat));
    }

    @Test
    public void testClientMapper(){
        ClientDTO clDto = new ClientDTO("maria", "1234567890123456", "1234567890", "1234567890", "23/12/2002", "male", "12345678901", "gui@isep.pt", "street 43");
        Client client = new Client(clDto);
        List<Client> cat = new ArrayList<>();
        cat.add(client);
        List<String> expected = new ArrayList<>();
        expected.add(String.format("Name: maria | Citizen Card Number: 1234567890123456 | NHS number: 1234567890 | TIN number: 1234567890 | Birth date: 23/12/2002 | Sex: male | Phone number: 12345678901 | Email: gui@isep.pt | Address: street 43 %n"));
        assertEquals(expected, ClientMapper.toDTOClient(cat));
    }

}
