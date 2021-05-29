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
        new CATest(null, null, null, null, null);
    }

    @Test(expected = NullPointerException.class)
    public void ensureNullNhsCodeIsNotAccepted() {
        Client client = new Client(new ClientDTO("Joao", "1232343456543456", "1357986432", "1434324565", "11/12/2012", "male", "92121345437", "joao@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("12345", "33", "56", new ParameterCategory("12334", "Rui"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("34567", "Tiago", "87", new ParameterCategory("12334", "Raul")));
        new CATest(null, client, typeOfTest, lparameter, "23432");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsCodeCannotBeBlank() {
        Client client = new Client(new ClientDTO("Guilherme", "4323456765063635", "9996665558", "2145412223", "24/05/2003", "male", "91891889158", "guilherme@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("11002", "998", "1", new ParameterCategory("47586", "cat"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("63254", "par", "des", new ParameterCategory("01298", "catt")));
        new CATest("", client, typeOfTest, lparameter, "35410");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCodeMustHaveAlphanumericChar() {
        Client client = new Client(new ClientDTO("Rafa", "7874789568987458", "3652563652", "4587896589", "12/11/2012", "male", "77889966554", "sandro@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("47854", "323", "566", new ParameterCategory("12934", "Gomes"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("52541", "Tomas", "887", new ParameterCategory("12734", "Raimundo")));
        new CATest("212@w2@-ji45", client, typeOfTest, lparameter, "23432");
    }

    @Test()
    public void ensureNhsCodeMustHave12AlphanumericChar() {
        Client client = new Client(new ClientDTO("Andre", "0123432109873275", "4747898745", "0101474740", "23/05/2005", "male", "87810191481", "andre@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("74747", "20", "2", new ParameterCategory("47474", "pc"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("41474", "pa", "de", new ParameterCategory("10132", "cp")));
        new CATest("123abc123abc", client, typeOfTest, lparameter, "47897");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCodeCannotHaveMoreThan12AlphanumericChar() {
        Client client = new Client(new ClientDTO("Francisco", "7104717401478502", "7478747847", "1212123232", "12/01/2004", "male", "97478798456", "francisco@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("35748", "10", "8", new ParameterCategory("56104", "tr"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("20203", "gr", "2", new ParameterCategory("71935", "saw")));
        new CATest("1222227222222", client, typeOfTest, lparameter, "73020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNhsCodeCannotHaveLessThan12AlphanumericChar() {
        Client client = new Client(new ClientDTO("Pedro", "0147896325470147", "3652563987", "7954795478", "13/06/2006", "male", "99120145631", "pedro@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("82585", "0", "9", new ParameterCategory("70010", "de"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("44465", "jos", "sw", new ParameterCategory("89874", "cr")));
        new CATest("2", client, typeOfTest, lparameter, "70302");
    }

    @Test
    public void checkGetTypeOfTestMethod() {
        Client client = new Client(new ClientDTO("Sandrina", "1020304506070809", "7020346589", "7172737445", "19/01/2008", "female", "21122332011", "sandrina@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("71217", "358", "121", new ParameterCategory("21987", "hop"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("03000", "fr", "2097", new ParameterCategory("11121", "wwe")));
        CATest t1 = new CATest("741474147985", client, typeOfTest, lparameter, "01097");
        String expected = String.format("Type of Test:%nCode: 71217%nDescription: 358%nCollecting Method: 121%nParameter Category(ies):%nParameter Category -> Name: hop | Code: 21987 |%n");
        assertEquals(expected, t1.getTypeOfTest().toString());
    }


    @Test
    public void checkGetClientMethod() {
        Client client = new Client(new ClientDTO("Emilia", "0202417845965874", "1074601020", "1212787895", "05/03/1963", "female", "91474765456", "emilia@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("00002", "7777", "666", new ParameterCategory("70104", "lkj"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("90265", "sz", "7021", new ParameterCategory("22109", "ads")));
        CATest t2 = new CATest("100090000003", client, typeOfTest, lparameter, "88878");
        String expected = String.format("Client:%nName: Emilia%nCitizen Card Number: 0202417845965874%nNHS number: 1074601020%nTIN number: 1212787895%nBirth date: 05/03/1963%nSex: female%nPhone number: 91474765456%nEmail: emilia@isep.ipp.pt");
        assertEquals(expected, t2.getClient().toString());
    }


    @Test
    public void checkGetNhsCodeMethod() {
        Client client = new Client(new ClientDTO("John", "0000770101769632", "0007014132", "7016998630", "19/08/2001", "male", "88858985897", "john@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("10000", "678483", "21212", new ParameterCategory("77775", "deg"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("33245", "wqp", "20202", new ParameterCategory("77891", "fgh")));
        CATest t3 = new CATest("447474799555", client, typeOfTest, lparameter, "10022");
        String expected = String.format("447474799555");
        assertEquals(expected, t3.getNhsCode().toString());
    }

    @Test(expected = NullPointerException.class)
    public void ensureThatParameterListCannotBeNull() {
        Client client = new Client(new ClientDTO("Mary", "1144770011447744", "1212565671", "0009434309", "12/05/1955", "female", "41425023697", "mary@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("01902", "3547", "4443", new ParameterCategory("41560", "free"));
        new CATest("414709521158", client, typeOfTest, null, "17774");
    }

    @Test
    public void ensureThatParameterListIsNotNull() {
        Client client = new Client(new ClientDTO("Dane", "4444444444444444", "7777744444", "4444477777", "13/07/1997", "female", "44411110123", "dane@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("66245", "01012", "550", new ParameterCategory("21225", "lklk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("00425", "rrt", "2228", new ParameterCategory("11111", "sss")));
        new CATest("111100009324", client, typeOfTest, lparameter, "99000");

    }

    @Test(expected = NullPointerException.class)
    public void ensureThatTypeOfTestCannotBeNull() {
        Client client = new Client(new ClientDTO("Rose", "5552227410147989", "5558887771", "5269876025", "28/01/1968", "female", "77770398565", "rose@isep.ipp.pt"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("09092", "hgh", "769", new ParameterCategory("88323", "ery")));
        new CATest("447450008965", client, null, lparameter, "99999");
    }


    @Test
    public void chekMethodGetParameterList() {
        Client client = new Client(new ClientDTO("Sousa", "2727474775499372", "5547424342", "1244464355", "08/02/1995", "male", "44443266387", "sousa@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("66352", "8410", "200", new ParameterCategory("66664", "wqer"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("20256", "rcb", "77", new ParameterCategory("00196", "çl")));
        CATest t4 = new CATest("774740747897", client, typeOfTest, lparameter, "11090");
        String expected = String.format("[Parameter -> Code: 20256 | Name: rcb | Description: 77]");
        assertEquals(expected, t4.getParameterList().toString());
    }

    @Test
    public void checkMethodGetLabWhereCreated() {
        Client client = new Client(new ClientDTO("Ricky", "4473023201452145", "0212301423", "4105484501", "18/09/2012", "male", "47416874710", "ricky@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("99202", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("33231", "uiy", "090", new ParameterCategory("55900", "fmds")));
        CATest t5 = new CATest("002150021456", client, typeOfTest, lparameter, "77065");
        String expected = String.format("77065");
        assertEquals(expected, t5.getLabWhereCreated().toString());
    }


    @Test(expected = NullPointerException.class)
    public void ensureNullClientIsNotAccepted() {
        TypeOfTest typeOfTest = new TypeOfTest("12121", "98", "78", new ParameterCategory("12121", "Saul"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        new CATest("232323232323", null, typeOfTest, lparameter, "95123");
    }


    @Test(expected = NullPointerException.class)
    public void ensureNullTypeOfTestIsNotAccepted() {
        Client client = new Client(new ClientDTO("Rute", "4001301625963254", "2121989803", "0104032965", "10/05/2009", "female", "54145210147", "rute@isep.ipp.pt"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("22443", "ds", "401", new ParameterCategory("79878", "detr")));
        new CATest("000111222333", client, null, lparameter, "30174");
    }

    @Test
    public void addParameter() {


    }

    @Test
    public void checkToStringMethod() {
        Client client = new Client(new ClientDTO("Fabio", "1118011112101115", "6663206663", "7741777410", "21/08/1999", "male", "99969963210", "fabio@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("44044", "0028", "1303", new ParameterCategory("44707", "dddg"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("00700", "hyre", "7272", new ParameterCategory("99990", "sssd")));
        CATest test1 = new CATest("001400140014", client, typeOfTest, lparameter, "77000");
        String expected = String.format("CA Test:%nNHS Code: 001400140014%nClient: Client:%nName: Fabio%nCitizen Card Number: 1118011112101115%nNHS number: 6663206663%nTIN number: 7741777410%nBirth date: 21/08/1999%nSex: male%nPhone number: 99969963210%nEmail: fabio@isep.ipp.pt%nType Of Test: Type of Test:%nCode: 44044%nDescription: 0028%nCollecting Method: 1303%nParameter Category(ies):%nParameter Category -> Name: dddg | Code: 44707 |%n%nParameter List: [Parameter -> Code: 00700 | Name: hyre | Description: 7272]%nLab Where Created: 77000%nInternal Code: 000000000001%n");
        assertEquals(expected, test1.toString());


    }

    @Test
    public void ensureAddingParameterWorks() {
        Client client = new Client(new ClientDTO("Eva", "2228889809321234", "5411211201", "7017410787", "23/11/1986", "female" , "42224324321", "eva@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("10000", "1212", "112", new ParameterCategory("99000", "dwqe"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("22222", "kkk", "11111", new ParameterCategory("66666", "uico")));
        CATest caTest = new CATest("777807778401", client, typeOfTest, lparameter, "00123");
        assertTrue(caTest.addParameter(new Parameter("07770", "lll", "32032", new ParameterCategory("01121", "zzz"))));
    }

    @Test
    public void ensureThatNhsCodeAreNotTheSameInTwoTests() {}

    @Test
    public void testAddReportWorks(){
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        CATest test = new CATest("341341323234", client, typeOfTest, lparameter, "l0001");
        assertTrue(test.addReport(new Report("afakdfbabdf")));
    }

    @Test
    public void checkReportDoneIsTrue(){
        Client client = new Client(new ClientDTO("Ric", "4473022301452145", "0212341423", "4105124501", "18/09/2012", "male", "47416124710", "ric@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("34534", "5560", "010", new ParameterCategory("80789", "dflk"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        CATest test = new CATest("341341323234", client, typeOfTest, lparameter, "l0001");
        test.addReport(new Report("afakdfbabdf"));
        assertTrue(test.getReportStatus());
    }

}