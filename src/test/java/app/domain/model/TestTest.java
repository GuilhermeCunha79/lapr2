package app.domain.model;


import app.mappers.dto.ClientDTO;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        new CATest(null, client, typeOfTest, lparameter, "23432" );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNhsCodeCannotBeBlank() {
        Client client = new Client(new ClientDTO("Guilherme", "4323456765063635", "9996665558", "2145412223", "24/05/2003", "male", "91891889158", "guilherme@isep.ipp.pt" ));
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
        new CATest("212@w2@-ji45", client, typeOfTest, lparameter, "23432" );
    }

    @Test()
    public void ensureNhsCodeMustHave12AlphanumericChar() {
        Client client = new Client(new ClientDTO("Andre", "0123432109873275", "4747898745", "0101474740", "23/05/2005","male" ,"87810191481","andre@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("74747", "20", "2", new ParameterCategory("47474", "pc"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("41474", "pa","de", new ParameterCategory("10132", "cp")));
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
        Client client = new Client(new ClientDTO("Pedro", "0147896325470147", "3652563987", "7954795478", "13/06/2006", "male", "99120145631", "pedro@isep.ipp.pt" ));
        TypeOfTest typeOfTest = new TypeOfTest("82585", "0", "9", new ParameterCategory("70010", "de"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("44465", "jos", "sw", new ParameterCategory("89874", "cr")));
        new CATest("2", client, typeOfTest, lparameter, "70302");
    }






    @Test(expected = NullPointerException.class)
    public void ensureNullClientIsNotAccepted() {
        TypeOfTest typeOfTest = new TypeOfTest("12121", "98", "78", new ParameterCategory("12121", "Saul"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("74147", "Ana", "96", new ParameterCategory("41456", "Sergio")));
        new CATest("232323232323", null, typeOfTest, lparameter, "95123");
    }


/*
    @Test
    public void testGetCreatedAt(){
        Client client = new Client(new ClientDTO("Joana", "7474741425632541", "7547854120", "1414569325", "25/10/2002","female","87896523658", "rck@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("12354", "5414", "963", new ParameterCategory("87853", "lab1"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("24102", "lab", "414", new ParameterCategory("47456", "lab2")));
        CATest catest = new CATest("123212123432", client, typeOfTest, lparameter, "42965" );
        String expected = "";
        assertEquals(expected, catest.getCreatedAt());
    }
*/


}
