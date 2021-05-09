package app.domain.model;


import org.junit.Test;

import java.util.ArrayList;



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
    public void ensureNameCanHaveLessThan20Char() {
        new ClinicalAnalysisLaboratory("Daniela", "91481806790", "mkli9", "2145639898", "RuaDoViso31", new ArrayList<>());
    }

    @Test
    public void ensureNameCanHave20Char() {
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
        new ClinicalAnalysisLaboratory("Joao Oliveira", "123456789012", "1a234", "1231231231", "Rua do Aldeiro 355", new ArrayList<>() );
    }



    @Test(expected = IllegalArgumentException.class)
    public void ensureThatLaboratoryIDCannotHaveMoreThan5CharAlphanumeric() {
        new ClinicalAnalysisLaboratory("Joao Manuel Oliveira", "11234567890", "a12345", "0123456789", "Rua Nova do Aldeiro 355", new ArrayList<>() );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberCannotHaveMoreThan10Digits() {
        new ClinicalAnalysisLaboratory("Joao Manuel Oliveira","11234567890", "a1234", "01234567891", "Rua Nova do Aldeiro 355", new ArrayList<>()  );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatAddressCannotHaveMoreThan30Chars() {
        new ClinicalAnalysisLaboratory("Joao Manuel Oliveira","11234567890", "a1234", "01234567890", "Avenida Nova do Aldeiro 3455 Lourosa", new ArrayList<>() );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNameCannotHaveAlphanumericChar() {
        new ClinicalAnalysisLaboratory("Jo<o Manuel Oliveira", "01234567890", "a1234", "01234567890", "Rua Nova do Aldeiro 355", new ArrayList<>() );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureIfTheAttributesHaveOnlyDigits() {
        new ClinicalAnalysisLaboratory("Romeu", "34323667634", "t<7yi", "5346987109", "RuaSaoMiguel43", new ArrayList<>());
    }







}



