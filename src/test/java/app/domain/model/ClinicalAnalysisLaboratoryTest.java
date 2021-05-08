package app.domain.model;


import org.junit.Test;

import java.util.ArrayList;



public class ClinicalAnalysisLaboratoryTest {

    @Test(expected = NullPointerException.class)
    public void ensureNullClinicalAnalysisLaboratoryIsNotCreated() {
        new ClinicalAnalysisLaboratory(null, null, null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatNameCannotHaveMoreThan20Char() {
        new ClinicalAnalysisLaboratory("Joao Manuel Oliveira Martins", "12345678891", "a1234", "1123456789", "Rua Nova do Aldeiro 355", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberCannotHaveMoreThan11Digits() {
        new ClinicalAnalysisLaboratory("Joao Guilherme Oliveira", "123456789012", "1a234", "1231231231", "Rua do Aldeiro 355", new ArrayList<>() );
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



}



