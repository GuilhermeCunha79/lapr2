package app.domain.model;


import org.junit.Test;

import static org.junit.Assert.*;


public class ClinicalAnalysisLaboratoryTest {

    @Test(expected = NullPointerException.class)
    public void ensureNullClinicalAnalysisLaboratoryIsNotCreated() {
        new ClinicalAnalysisLaboratory(null, null, null, null, null);
    }

    @Test(expected = NullPointerException.class)
    public void ensureNullLabIDIsNotAccepted() {
        new ClinicalAnalysisLaboratory(null, "Joao", "RuaMirandela45", "11223998741", "5478212987");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericNameAreNotAccepted() {
        new ClinicalAnalysisLaboratory("az321", "Jo@o", "RuaMirandela45", "11223998741", "5478212987");
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan20Char() {
        new ClinicalAnalysisLaboratory("a1234", "JoaoManuelOliveiraMartins", "RuaNovaDoAldeiro355", "11234516789", "1234578891");
    }

    @Test
    public void ensureNameCanHaveLessThan20Char() {//store
        new ClinicalAnalysisLaboratory("mkli9", "Daniela", "RuaDoViso31", "21456319898", "9148106790");
    }

    @Test
    public void ensureNameCanHave20Char() {//store
        new ClinicalAnalysisLaboratory("qcp32", "JoaoGuilhermeDaniela", "Rua25DeAbril", "75211496745", "2312495064");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeBlank () {
        new ClinicalAnalysisLaboratory("sde45", "", "Rua21DeMaio", "12565478987", "7414789658");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberMustHaveOnlyDigits() {
        new ClinicalAnalysisLaboratory("kli81", "Maria", "Rua26Junho", "aaassdfgtrq", "4871295276");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberCannotHaveMoreThan11DigitsNumber () {
        new ClinicalAnalysisLaboratory("1a234", "Joao Oliveira", "RuaDoAldeiro355", "123456789012", "1231231231" );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatPhoneNumberCannotHaveLessThan11DigitsNumber () {
        new ClinicalAnalysisLaboratory("vba09", "Diogo Ribeiro", "RuaDaBoavista4525", "2012352102", "4875457487");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotBeBlank () {
        new ClinicalAnalysisLaboratory("der45", "Benedita", "RuaDaLousada420", "", "9574136859");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDMustHaveAlphanumericChar() {
        new ClinicalAnalysisLaboratory("@,ft5", "Diana", "RuaDaVindima37", "87587896589", "8787458746");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatLaboratoryIDCannotHaveLessThan5CharAplphanumeric() {
        new ClinicalAnalysisLaboratory("7r5", "Tiago", "RuaDaTerra54", "17414787458", "7878762562");
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureThatLaboratoryIDCannotHaveMoreThan5CharAlphanumeric() {
        new ClinicalAnalysisLaboratory("a12345", "JoaoManuelOliveira", "Rua Nova do Aldeiro 355", "11234567890", "1134567890" );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatLaboratoryIDCannotBeBlanked() {
        new ClinicalAnalysisLaboratory("", "Rui", "RuaLusitana19242", "78712030211", "1209429854");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberMustHaveOnlyDigitNumbers() {
        new ClinicalAnalysisLaboratory("klop5", "Rafael", "RuaVelha54", "23432980764", "awedsftrewq");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberCannotHaveMoreThan10Digits() {
        new ClinicalAnalysisLaboratory("a1234","Joao Manuel", "Rua Nova do Aldeiro 355", "01234567891", "01234567891");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberHaveLessThan10Digits() {
        new ClinicalAnalysisLaboratory("lcz21", "Romao", "lcz21", "78741549794", "12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatTinNumberCannotBeBlanked() {
        new ClinicalAnalysisLaboratory("frt56", "Leonel", "RuaDoRojao56", "4543210987", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatAddressCannotHaveMoreThan90Chars() {
        new ClinicalAnalysisLaboratory("a1234","Joao Santos", "ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss", "01234567890", "0123456789" );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatAddressCannotBeBlanked() {
        new ClinicalAnalysisLaboratory("qzxo9", "Rolando", "", "31845623319", "74102036580");
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericAddressAreNotAccepted() {
        new ClinicalAnalysisLaboratory("qwlo9", "Sara", "@,Rua,@", "14563215412", "4543450875");
    }

    @Test
    public void checkGetNameMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("fvt56", "Matias", "AvenidaDeGaia34", "74859613214", "3451024598");
        String expected = "Matias";
        assertEquals(expected, c1.getName());
    }

    @Test
    public void checkSetNameMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("45po5", "john", "RuaDaPraia34", "78659876918", "7865187698");
        c1.setName("Mateus");
        String expected = "Mateus";
        assertEquals(expected, c1.getName());
    }

    @Test
    public void checkGetPhoneNumberMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("787po", "Raul", "RuaDaBaia234", "32123421234", "3212342123");
        String expected = "32123421234";
        assertEquals(expected, c1.getPhoneNumber());
    }

    @Test
    public void checkSetPhoneNumberMethod() {
            ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("458ty", "Francisco", "RuaDoAlgarve45", "12325161232", "1232516123");
        c1.setPhoneNumber("21209096837");
        String expected = "21209096837";
        assertEquals(expected, c1.getPhoneNumber());
    }

    @Test
    public void checkGetTinNumberMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("2345t", "Ricky", "RuaDoPataco56", "54684852958", "5464852958");
        String expected = "5464852958";
        assertEquals(expected, c1.getTinNumber());
    }

    @Test
    public void checkSetTinNumberMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("e3e4r", "Edu", "RuaDaAreia48", "45789651412", "5464852958");
        c1.setTinNumber("4578965412");
        String expected = "4578965412";
        assertEquals(expected, c1.getTinNumber());
    }

    @Test
    public void checkGetLaboratoryIDMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("hy908", "Nani", "RuaDaAndorinha34", "14202140361", "1420240361");
        String expected = "hy908";
        assertEquals(expected, c1.getLaboratoryID());
    }

    @Test
    public void checkSetLaboratoryIDMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("Si2ao", "John", "RuaDaMadeira21", "34468031276", "1234678900");
        c1.setLaboratoryID("frgt6");
        String excepted = "frgt6";
        assertEquals(excepted, c1.getLaboratoryID());
    }

    @Test
    public void checkGetAddressMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("cfgt5", "Ronaldo", "RuaDaPassada45", "45967518745", "8692858385");
        String expected = "RuaDaPassada45";
        assertEquals(expected, c1.getAddress());
    }

    @Test
    public void checkSetAddressMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("2345b", "Felix", "RuaDoCouto98", "78458741896", "7845871896");
        c1.setAddress("rua 21");
        String expected = "rua 21";
        assertEquals(expected, c1.getAddress());
    }

    @Test
    public void checkToStringMethod() {
        ClinicalAnalysisLaboratory c1 = new ClinicalAnalysisLaboratory("test5", "Pedro", "RuaDaMorte98", "46564971894", "4656497194");
        String expected = String.format("Clinical Analysis Laboratory:%nName: Pedro%nPhone Number: 46564971894%nLaboratory ID: test5%nTIN number: 4656497194%nAddress: RuaDaMorte98%n No Type of Tests");
        assertEquals(expected, c1.toString());
    }

    @Test
    public void ensureAddingTestTypesWorks() {
        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("az321", "Joao", "RuaMirandela45", "11223998741", "5478212987");
        assertTrue(cal.addTestType(new TypeOfTest("12132", "sdadvvasdv", "swab", new ParameterCategory("21322", "advas"))));
    }

    @Test
    public void ensureTwoCALWithSameParametersAreEquals() {
        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("az321", "Joao", "RuaMirandela45", "11223998741", "5478212987");
        assertEquals(cal, cal);
    }

    @Test
    public void ensureCALIsDifferentThanNullObject() {
        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("az321", "Joao", "RuaMirandela45", "11223998741", "5478212987");
        assertFalse(cal.equals(null));
    }

    @Test
    public void ensureCALIsDifferentThanOtherClassObject() {
        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("az321", "Joao", "RuaMirandela45", "11223998741", "5478212987");
        assertFalse(cal.equals("saaa"));
    }

    @Test
    public void ensureTwoCALWithSamePhoneNumberAreEquals() {
        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("az321", "Joao", "RuaMirandela45", "11223998741", "5478212987");
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("add23", "Lab3", "RuaMirandela32", "11223998741", "5472312987");
        assertEquals(cal, cal2);
    }

    @Test
    public void ensureTwoCALWithSameIDAreEquals() {
        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("az321", "Joao", "RuaMirandela45", "11223998741", "5478212987");
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("az321", "Lab3", "RuaMirandela32", "11223998741", "5472312987");
        assertEquals(cal, cal2);
    }

    @Test
    public void ensureTwoCALWithSameTINAreEquals() {
        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("az321", "Joao", "RuaMirandela45", "11223998741", "5478212987");
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("a2121", "Lab3", "RuaMirandela32", "11223998741", "5478212987");
        assertEquals(cal, cal2);
    }

    @Test
    public void ensureTwoCALWithSameAddressAreEquals() {
        ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory("az321", "Joao", "RuaMirandela45", "11223998741", "5478212987");
        ClinicalAnalysisLaboratory cal2 = new ClinicalAnalysisLaboratory("a2121", "Lab3", "RuaMirandela45", "11223998741", "5477612987");
        assertEquals(cal, cal2);
    }
}












