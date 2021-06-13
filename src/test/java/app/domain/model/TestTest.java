package app.domain.model;


import app.domain.shared.DateTime;
import app.mappers.dto.ClientDTO;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTest {


    @Test(expected = NullPointerException.class)
    public void ensureNullTestIsNotCreated() {
        new ClinicalTest(null, null, null, null, null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void ensureNullNhsCodeIsNotAccepted() {
        Client client = new Client(new ClientDTO("Joao", "1232343456543456", "1357986432", "1434324565", "11/12/2012", "male", "92121345437", "joao@isep.ipp.pt", "street1"));
        TypeOfTest typeOfTest = new TypeOfTest("12345", "33", "56", new ParameterCategory("12334", "Rui"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("34567", "Tiago", "87", new ParameterCategory("12334", "Raul")));
        new ClinicalTest(null, client, typeOfTest, lparameter, "23432", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsCodeCannotBeBlank() {
        Client client = new Client(new ClientDTO("Guilherme", "4323456765063635", "9996665558", "2145412223", "24/05/2003", "male", "91891889158", "guilherme@isep.ipp.pt", "street2"));
        TypeOfTest typeOfTest = new TypeOfTest("11002", "998", "1", new ParameterCategory("47586", "cat"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("63254", "par", "des", new ParameterCategory("01298", "catt")));
        new ClinicalTest("", client, typeOfTest, lparameter, "35410", 2);
    }

    @Test(expected = NullPointerException.class)
    public void ensureParameterListCannotBeNull() {
        Client client = new Client(new ClientDTO("Rafa", "7874789568987458", "3652563652", "4587896589", "12/11/2012", "male", "77889966554", "sandro@isep.ipp.pt", "street3"));
        TypeOfTest typeOfTest = new TypeOfTest("47854", "323", "566", new ParameterCategory("12934", "Gomes"));
        new ClinicalTest("123133131231", client, typeOfTest, null, "23432", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCodeMustHaveAlphanumericChar() {
        Client client = new Client(new ClientDTO("Rafa", "7874789568987458", "3652563652", "4587896589", "12/11/2012", "male", "77889966554", "sandro@isep.ipp.pt", "street 4"));
        TypeOfTest typeOfTest = new TypeOfTest("47854", "323", "566", new ParameterCategory("12934", "Gomes"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("52541", "Tomas", "887", new ParameterCategory("12734", "Raimundo")));
        new ClinicalTest("212@w2@-ji45", client, typeOfTest, lparameter, "23432",4);
    }

    @Test()
    public void ensureNhsCodeMustHave12AlphanumericChar() {
        Client client = new Client(new ClientDTO("Andre", "0123432109873275", "4747898745", "0101474740", "23/05/2005", "male", "87810191481", "andre@isep.ipp.pt", "street 5"));
        TypeOfTest typeOfTest = new TypeOfTest("74747", "20", "2", new ParameterCategory("47474", "pc"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("41474", "pa", "de", new ParameterCategory("10132", "cp")));
        new ClinicalTest("123abc123abc", client, typeOfTest, lparameter, "47897", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCodeCannotHaveMoreThan12AlphanumericChar() {
        Client client = new Client(new ClientDTO("Francisco", "7104717401478502", "7478747847", "1212123232", "12/01/2004", "male", "97478798456", "francisco@isep.ipp.pt", "street 6"));
        TypeOfTest typeOfTest = new TypeOfTest("35748", "10", "8", new ParameterCategory("56104", "tr"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("20203", "gr", "2", new ParameterCategory("71935", "saw")));
        new ClinicalTest("1222227222222", client, typeOfTest, lparameter, "73020", 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCodeCannotHaveLessThan12AlphanumericChar() {
        Client client = new Client(new ClientDTO("Pedro", "0147896325470147", "3652563987", "7954795478", "13/06/2006", "male", "99120145631", "pedro@isep.ipp.pt", "street 7"));
        TypeOfTest typeOfTest = new TypeOfTest("82585", "0", "9", new ParameterCategory("70010", "de"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("44465", "jos", "sw", new ParameterCategory("89874", "cr")));
        new ClinicalTest("2", client, typeOfTest, lparameter, "70302", 7);
    }

    @Test
    public void checkGetTypeOfTestMethod() {
        Client client = new Client(new ClientDTO("Sandrina", "1020304506070809", "7020346589", "7172737445", "19/01/2008", "female", "21122332011", "sandrina@isep.ipp.pt", "street 9"));
        TypeOfTest typeOfTest = new TypeOfTest("71217", "358", "121", new ParameterCategory("21987", "hop"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("03000", "fr", "2097", new ParameterCategory("11121", "wwe")));
        ClinicalTest t1 = new ClinicalTest("741474147985", client, typeOfTest, lparameter, "01097", 8);
        String expected = String.format("Type of Test:%nCode: 71217%nDescription: 358%nCollecting Method: 121%nParameter Category(ies):%nParameter Category -> Code: 21987 | Name: hop |%n");
        assertEquals(expected, t1.getTypeOfTest().toString());
    }


    @Test
    public void checkGetClientMethod() {
        Client client = new Client(new ClientDTO("Emilia", "0202417845965874", "1074601020", "1212787895", "05/03/1963", "female", "91474765456", "emilia@isep.ipp.pt", "street 8"));
        TypeOfTest typeOfTest = new TypeOfTest("00002", "7777", "666", new ParameterCategory("70104", "lkj"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("90265", "sz", "7021", new ParameterCategory("22109", "ads")));
        ClinicalTest t2 = new ClinicalTest("100090000003", client, typeOfTest, lparameter, "88878",9);
        String expected = String.format("%nClient:%nName: Emilia%nCitizen Card Number: 0202417845965874%nNHS number: 1074601020%nTIN number: 1212787895%nBirth date: 05/03/1963%nSex: female%nPhone number: 91474765456%nEmail: emilia@isep.ipp.pt%nAddress: street 8%n");
        assertEquals(expected, t2.getClient().toString());
    }


    @Test
    public void checkGetNhsCodeMethod() {
        Client client = new Client(new ClientDTO("John", "0000770101769632", "0007014132", "7016998630", "19/08/2001", "male", "88858985897", "john@isep.ipp.pt", "street 12"));
        TypeOfTest typeOfTest = new TypeOfTest("10000", "678483", "21212", new ParameterCategory("77775", "deg"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("33245", "wqp", "20202", new ParameterCategory("77891", "fgh")));
        ClinicalTest t3 = new ClinicalTest("447474799555", client, typeOfTest, lparameter, "10022", 10);
        String expected = String.format("447474799555");
        assertEquals(expected, t3.getNhsCode().toString());
    }

    @Test(expected = NullPointerException.class)
    public void ensureThatParameterListCannotBeNull() {
        Client client = new Client(new ClientDTO("Mary", "1144770011447744", "1212565671", "0009434309", "12/05/1955", "female", "41425023697", "mary@isep.ipp.pt", "street 11"));
        TypeOfTest typeOfTest = new TypeOfTest("01902", "3547", "4443", new ParameterCategory("41560", "free"));
        new ClinicalTest("414709521158", client, typeOfTest, null, "17774", 11);
    }

    @Test
    public void ensureThatParameterListIsNotNull() {
        Client client = new Client(new ClientDTO("Dane", "4444444444444444", "7777744444", "4444477777", "13/07/1997", "female", "44411110123", "dane@isep.ipp.pt", "street 21"));
        TypeOfTest typeOfTest = new TypeOfTest("66245", "01012", "550", new ParameterCategory("21225", "lklk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("00425", "rrt", "2228", new ParameterCategory("11111", "sss")));
        new ClinicalTest("111100009324", client, typeOfTest, lparameter, "99000", 12);

    }

    @Test(expected = NullPointerException.class)
    public void ensureThatTypeOfTestCannotBeNull() {
        Client client = new Client(new ClientDTO("Rose", "5552227410147989", "5558887771", "5269876025", "28/01/1968", "female", "77770398565", "rose@isep.ipp.pt", "street 23"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("09092", "hgh", "769", new ParameterCategory("88323", "ery")));
        new ClinicalTest("447450008965", client, null, lparameter, "99999", 13);
    }


    @Test
    public void chekMethodGetParameterList() {
        Client client = new Client(new ClientDTO("Sousa", "2727474775499372", "5547424342", "1244464355", "08/02/1995", "male", "44443266387", "sousa@isep.ipp.pt", "street 25"));
        TypeOfTest typeOfTest = new TypeOfTest("66352", "8410", "200", new ParameterCategory("66664", "wqer"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("20256", "rcb", "77", new ParameterCategory("00196", "çl")));
        ClinicalTest t4 = new ClinicalTest("774740747897", client, typeOfTest, lparameter, "11090", 14);
        String expected = String.format("[Parameter -> Code: 20256 | Name: rcb | Description: 77]");
        assertEquals(expected, t4.getParameterList().toString());
    }

    @Test
    public void checkMethodGetLabWhereCreated() {
        Client client = new Client(new ClientDTO("Ricky", "4473023201452145", "0212301423", "4105484501", "18/09/2012", "male", "47416874710", "ricky@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("99202", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("33231", "uiy", "090", new ParameterCategory("55900", "fmds")));
        ClinicalTest t5 = new ClinicalTest("002150021456", client, typeOfTest, lparameter, "77065", 15);
        String expected = "77065";
        assertEquals(expected, t5.getLabWhereCreated());
    }


    @Test(expected = NullPointerException.class)
    public void ensureNullClientIsNotAccepted() {
        TypeOfTest typeOfTest = new TypeOfTest("12121", "98", "78", new ParameterCategory("12121", "Saul"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        new ClinicalTest("232323232323", null, typeOfTest, lparameter, "95123", 16);
    }


    @Test(expected = NullPointerException.class)
    public void ensureNullTypeOfTestIsNotAccepted() {
        Client client = new Client(new ClientDTO("Rute", "4001301625963254", "2121989803", "0104032965", "10/05/2009", "female", "54145210147", "rute@isep.ipp.pt", "street"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("22443", "ds", "401", new ParameterCategory("79878", "detr")));
        new ClinicalTest("000111222333", client, null, lparameter, "30174", 17);
    }

    @Test
    public void checkToStringMethod() {
        Client client = new Client(new ClientDTO("Fabio", "1118011112101115", "6663206663", "7741777410", "21/08/1999", "male", "99969963210", "fabio@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("44044", "0028", "1303", new ParameterCategory("44707", "dddg"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("00700", "hyre", "7272", new ParameterCategory("99990", "sssd")));
        ClinicalTest test1 = new ClinicalTest("001400140014", client, typeOfTest, lparameter, "77000", 18);
        String expected = String.format("Internal Code: 000000000018 | NHS Code: 001400140014 | Created on: %s |", new DateTime());
        assertEquals(expected, test1.toString());
    }

    @Test
    public void ensureAddingParameterWorks() {
        Client client = new Client(new ClientDTO("Eva", "2228889809321234", "5411211201", "7017410787", "23/11/1986", "female" , "42224324321", "eva@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("10000", "1212", "112", new ParameterCategory("99000", "dwqe"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("22222", "kkk", "11111", new ParameterCategory("66666", "uico")));
        ClinicalTest clinicalTest = new ClinicalTest("777807778401", client, typeOfTest, lparameter, "00123", 19);
        assertTrue(clinicalTest.addParameter(new Parameter("07770", "lll", "32032", new ParameterCategory("01121", "zzz"))));
    }

    @Test
    public void ensureAddingSameParameterDoesntWorks() {
        Client client = new Client(new ClientDTO("Eva", "2228889809321234", "5411211201", "7017410787", "23/11/1986", "female" , "42224324321", "eva@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("10000", "1212", "112", new ParameterCategory("99000", "dwqe"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("22222", "kkk", "11111", new ParameterCategory("66666", "uico")));
        ClinicalTest clinicalTest = new ClinicalTest("777807778401", client, typeOfTest, lparameter, "00123", 20);
        clinicalTest.addParameter(new Parameter("07770", "lll", "32032", new ParameterCategory("01121", "zzz")));
        assertFalse(clinicalTest.addParameter(new Parameter("07770", "lll", "32032", new ParameterCategory("01121", "zzz"))));
    }

    @Test
    public void ensureThatNhsCodeAreNotTheSameInTwoTests() {
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        ClinicalTest test = new ClinicalTest("341341323234", client, typeOfTest, lparameter, "l0001", 21);
        assertTrue(test.addReport(new Report("afakdfbabdf")));
    }

    @Test
    public void testAddReportWorks(){
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        ClinicalTest test = new ClinicalTest("341341323234", client, typeOfTest, lparameter, "l0001", 22);
        assertTrue(test.addReport(new Report("afakdfbabdf")));
    }

    @Test
    public void testAddValidationWorks(){
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        ClinicalTest test = new ClinicalTest("341341323234", client, typeOfTest, lparameter, "l0001", 23);
        assertTrue(test.addValidation());
    }

    @Test
    public void checkReportDoneIsTrue(){
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        ClinicalTest test = new ClinicalTest("341341323234", client, typeOfTest, lparameter, "l0001", 24);
        test.addReport(new Report("afakdfbabdf"));
        assertTrue(test.getReportStatus());
    }

    @Test
    public void checkValidationDoneIsTrue(){
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        ClinicalTest test = new ClinicalTest("341341323234", client, typeOfTest, lparameter, "l0001", 25);
        test.addReport(new Report("afakdfbabdf"));
        assertFalse(test.getValidationStatus());
    }

    @Test
    public void checkAddTestParameterResultMethod(){
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("IgGAN", "IgGAN", "IgC antibodies", new ParameterCategory("89898", "Covid")));
        ClinicalTest test = new ClinicalTest("341341323234", client, typeOfTest, lparameter, "l0001", 26);
        assertTrue(test.addTestParameterResult("IgGAN", 0.22, "mg"));
    }

    @Test
    public void checkAddTestParameterResultDoesntWorkWhenTheTestParameterIsntFound(){
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt", "street"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("IgGAN", "IgGAN", "IgC antibodies", new ParameterCategory("89898", "Covid")));
        ClinicalTest test = new ClinicalTest("341341323234", client, typeOfTest, lparameter, "l0001", 27);
        assertFalse(test.addTestParameterResult("98909", 0.22, "mg"));
    }

/*
       @Test
        public void checkItsNotAllowedToRegisterAResultForTheSameParameterTwice(){
            Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt"));
            TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
            List<Parameter> lparameter = new ArrayList<>();
            lparameter.add(new Parameter("IgGAN", "IgGAN", "IgC antibodies", new ParameterCategory("89898", "Covid")));
            CATest test = new CATest("341341323234", client, typeOfTest, lparameter, "l0001", 28);
            test.addTestParameterResult("IgGAN", 0.22, "mg");
            String expected = String.format("%n%nTest Results: %n"+
                    "- Parameter tested: Parameter -> Code: IgGAN | Name: IgGAN | Description: IgC antibodies | Results -> value: 0.220000 mg | Reference Values -> min. value: 0.000000 Index (S/C) Value | max. value: 1.400000 Index (S/C) Value %n");
            assertEquals(expected, test.getTestResults());

        }

        @Test
        public void checkItsNotAllowedToValidateTheSameTestTwice(){
            Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt"));
            TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
            List<Parameter> lparameter = new ArrayList<>();
            lparameter.add(new Parameter("IgGAN", "IgGAN", "IgC antibodies", new ParameterCategory("89898", "Covid")));
            CATest test = new CATest("341341323234", client, typeOfTest, lparameter, "l0001", 29);
            test.addTestParameterResult("IgGAN", 0.22, "mg");
            test.getTestValidation();
            String expected = String.format("%n%nTest Results: %nInternal Code: 000000000029 | NHS Code: 341341323234 | Created on: %s | Collected at: null | Reported at: %s |", new DateTime(), new DateTime());
            assertEquals(expected, test.getTestValidation());

        }*/

    @Test
    public void ensureThatNHSCodeAreTheSameInTwoDifferentTests() {
        Client cl1 = new Client(new ClientDTO("Ema", "2222254246456425", "5454323432", "1195385492", "21/01/1990", "female", "11069472764", "ema@isep.ipp.pt", "street"));
        Client cl2 = new Client(new ClientDTO("Sonia", "1103928472575737", "1195737274", "8805909725", "21/10/2000",  "female", "54540194853", "sonia@isep.ipp.pt", "street"));
        TypeOfTest tt1 = new TypeOfTest("11051", "22019", "8071", new ParameterCategory("22000", "vvc"));
        TypeOfTest tt2 = new TypeOfTest("09901", "009", "7670", new ParameterCategory("77097", "zzxx"));
        List<Parameter> lp1 = new ArrayList<>();
        lp1.add(new Parameter("99199", "bool", "257", new ParameterCategory("11444", "tyy")));
        List<Parameter> lp2 = new ArrayList<>();
        lp2.add(new Parameter("44400", "dfffg", "5555", new ParameterCategory("60006", "yyu")));
        ClinicalTest cat1 = new ClinicalTest("111111111110", cl1, tt1, lp1, "09090", 30);
        ClinicalTest cat2 = new ClinicalTest("111111111110", cl2, tt2, lp2, "90909", 30);
        assertEquals(cat1, cat2);
    }

}