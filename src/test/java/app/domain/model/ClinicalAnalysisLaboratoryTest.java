package app.domain.model;


import org.junit.Test;

import javax.naming.Name;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ClinicalAnalysisLaboratoryTest {

    @Test(expected = NullPointerException.class)
    public void ensureNullClinicalAnalysisLaboratoryIsNotCreated() {
        new ClinicalAnalysisLaboratory(null, null, null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericNameAreNotAccepted() {
        new ClinicalAnalysisLaboratory("Jo@o", "54782112987", "az321", "1122399874", "RuaMirandela45", new ArrayList<>());
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan20Char() {
        new ClinicalAnalysisLaboratory("JoaoManuelOliveiraMartins", "12345678891", "a1234", "1123456789", "RuaNovaDoAldeiro355", new ArrayList<>());
    }

    @Test
    public void ensureNameCanHaveLessThan20Char() {//store
        new ClinicalAnalysisLaboratory("Daniela", "91481806790", "mkli9", "2145639898", "RuaDoViso31", new ArrayList<>());
    }

    @Test
    public void ensureNameCanHave20Char() {//store
        new ClinicalAnalysisLaboratory("JoaoGuilhermeDaniela", "23124985064", "qcp32", "7521496745", "Rua25DeAbril", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeBlank () {
        new ClinicalAnalysisLaboratory("", "12565478987", "sde45", "7414789658", "Rua21DeMaio", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberMustHaveOnlyDigits() {
        new ClinicalAnalysisLaboratory("Maria", "aaassdfgtrq", "kli81", "4871295276", " Rua26Junho", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberCannotHaveMoreThan11DigitsNumber () {
        new ClinicalAnalysisLaboratory("Joao Oliveira", "123456789012", "1a234", "1231231231", "RuaDoAldeiro355", new ArrayList<>() );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberCannotHaveLessThan11DigitsNumber () {
        new ClinicalAnalysisLaboratory("Diogo Ribeiro", "4875457487", "vba09", "2012352102", "RuaDaBoavista4525", new ArrayList<>());
    }

    @Test
    public void ensureThatPhoneNumberMustHave11DigitsNumber () {//store
        new ClinicalAnalysisLaboratory("Rute", "41598547412", "5fr43", "1010235263", "RuaDeCoimbra45", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotBeBlank () {
        new ClinicalAnalysisLaboratory("Benedita", "", "der45", "9574136859", "RuaDaLousada420", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDMustHaveAlphanumericChar() {
        new ClinicalAnalysisLaboratory("Diana", "87587896589", "@,ft5", "8787458746", "RuaDaVindima37", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatLaboratoryIDCannotHaveLessThan5CharAplphanumeric() {
        new ClinicalAnalysisLaboratory("Tiago", "78787562562", "7r5", "7414787458", "RuaDaTerra54", new ArrayList<>());
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureThatLaboratoryIDCannotHaveMoreThan5CharAlphanumeric() {
        new ClinicalAnalysisLaboratory("JoaoManuelOliveira", "11234567890", "a12345", "0123456789", "Rua Nova do Aldeiro 355", new ArrayList<>() );
    }

    @Test
    public void ensureThatLaboratoryIDMustHave5CharAlphanumeric() {//store
        new ClinicalAnalysisLaboratory("JoseGomes", "45345345656", "t6r54", "2323098573", "RuaMirandesa45", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatLaboratoryIDCannotBeBlanked() {
        new ClinicalAnalysisLaboratory("Rui", "21209429854", "", "7871203021", "RuaLusitana1924", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberMustHaveOnlyDigitNumbers() {
        new ClinicalAnalysisLaboratory("Rafael", "23432980764", "klop5", "awedsftrewq", "RuaVelha54", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberCannotHaveMoreThan10Digits() {
        new ClinicalAnalysisLaboratory("Joao Manuel","11234567890", "a1234", "01234567891", "Rua Nova do Aldeiro 355", new ArrayList<>()  );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberHaveLessThan10Digits() {
        new ClinicalAnalysisLaboratory("Romao", "78741549794", "lcz21", "32", "AvenidaAlmada23", new ArrayList<>());
    }

    @Test
    public void ensureThatTinNumberMustHave10Digits() {
        new ClinicalAnalysisLaboratory("Roberto", "34390987890", "2q234", "1456541458", "RuaDaRocha21", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberCannotBeBlanked() {
        new ClinicalAnalysisLaboratory("Leonel", "4543210987", "frt56", "", "RuaDoRojao56", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatAddressCannotHaveMoreThan30Chars() {
        new ClinicalAnalysisLaboratory("Joao Santos","11234567890", "a1234", "01234567890", "Avenida Nova do Aldeiro 3455 Lourosa", new ArrayList<>() );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatAddressCannotBeBlanked() {
        new ClinicalAnalysisLaboratory("Rolando", "74102036580", "qzxo9", "3184562339", "", new ArrayList<>());
    }

    @Test
    public void ensureThatAddressCanHaveLessThan30Char() {
        new ClinicalAnalysisLaboratory("Artur", "56545687609", "sw34r", "587858985", "Rua", new ArrayList<>());
    }

    @Test
    public void ensureThatAddressCanHave30Char() {
        new ClinicalAnalysisLaboratory("Rafa", "56426802864", "kjkh5", "2121098640", "RuaNovaDaAldeia12345", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericAddressAreNotAccepted() {
        new ClinicalAnalysisLaboratory("Sara", "45434509875", "qwlo9", "1456325412", "@,Rua,@", new ArrayList<>());
    }

    @Test
    public void checkGetNameMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("Matias", "34510245987", "fvt56", "7485963214", "AvenidaDeGaia34", new ArrayList<>());
        String expected = "Matias";
        assertEquals(expected, c1.getName());
    }

    @Test
    public void checkSetNameMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("Mateus", "69693696369", "45po5", "7865987698", "RuaDaPraia34", new ArrayList<>())
        c1.setName("Mateus");
        String expected = "Mateus";
        assertEquals(expected, c1.getName());
    }

    @Test
    public void checkGetPhoneNumberMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("Raul", "32123421234", "787po", "4747858596", "RuaDaBaia234", new ArrayList<>());
        String expected = "32123421234";
        assertEquals(expected, c1.getPhoneNumber());
    }








}



