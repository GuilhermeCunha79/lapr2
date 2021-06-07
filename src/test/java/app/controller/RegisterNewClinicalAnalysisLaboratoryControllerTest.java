package app.controller;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.ParameterCategory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegisterNewClinicalAnalysisLaboratoryControllerTest {

    ArrayList<ClinicalAnalysisLaboratory> Listcal = new ArrayList<ClinicalAnalysisLaboratory>();


    RegisterNewClinicalAnalysisLaboratoryController ctrl = new RegisterNewClinicalAnalysisLaboratoryController();

    @Test(expected = NullPointerException.class)
    public void ensureNullClinicalAnalysisLaboratoryIsNotCreated() {
        ctrl.registerNewClinicalAnalysisLaboratory(null, null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureClinicalAnalysisLaboratoryIsNotCreatedWithBlankAttributes() {
        ctrl.registerNewClinicalAnalysisLaboratory("", "", "", "", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericNameAreNotAccepted() {
        ctrl.registerNewClinicalAnalysisLaboratory("43232", "sfas@dcasd", "asdcsdca", "12345617890", "3413323341");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan20Char() {
        ctrl.registerNewClinicalAnalysisLaboratory("43237", "asfsadsadssvaasvasdfa", "adfsdafasd", "23231418976", "1321232123");
    }

    @Test
    public void ensureNameCanHaveLessThan20Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("13423", "safadsf", "avdasdvas", "21234135459", "1231241234"));
    }

    @Test
    public void ensureNameCanHave20Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("f54f5", "JoaoPedroSilvaDaniel", "RuaDosDescobrimentos17", "76854509176", "7685459176"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("31223", "", "aergadb", "65432111121", "654321111213");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberMustHaveNumbers() {
        ctrl.registerNewClinicalAnalysisLaboratory("13434", "aaaaaaaaaaa", "advasdv", "343434a3434", "343433423434");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotHaveMoreThan11Digits() {
        ctrl.registerNewClinicalAnalysisLaboratory("54343", "adavadsv", "advsdvad", "964509011867", "9645090118");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotHaveLessThan11Digits() {
        ctrl.registerNewClinicalAnalysisLaboratory("65456", "asdvasdv", "we3advavr4", "4370954325", "4370954325");
    }

    @Test
    public void ensurePhoneNumberMustHave11Digits() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("54237", "advasdv", "asdsav", "78657475450", "9897889188"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("12424", "abcbzxc", "z3z45", "", "1242424434");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDMustHaveAlphanumericChar() {
        ctrl.registerNewClinicalAnalysisLaboratory("@£@@£", "dasgasdg", "asdgasdga", "45465671879", "4551671879");
    }

    @Test
    public void ensureLaboratoryIDMustHave5AlphanumericChar() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("32143", "afsdgds", "agadga", "12196591656", "1243234423"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDCannotHaveMoreThan5AlphanumericChar() {
        ctrl.registerNewClinicalAnalysisLaboratory("453244", "gsdgsdfgss", "sfgfdgsgfs", "43416765699", "3421343234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDCannotHaveLessThan5AlphanumericChar() {
        ctrl.registerNewClinicalAnalysisLaboratory("123", "dadfasdf", "adsfasdf", "54591616498", "1231212412");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("", "davsdfasd", "asdfasdfas", "99988817776", "9998817776");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinNumberMustHaveDigits() {
        ctrl.registerNewClinicalAnalysisLaboratory("12324", "adsgasd", "dasgasd", "11232223332", "NacionalN1");
    }

    @Test
    public void ensureTinNumberMustHave10Digits() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("32132", "daasgsdg", "adgasdas", "98121143212", "2314133244"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinNumberCannotHaveMoreThan10Digits() {
        ctrl.registerNewClinicalAnalysisLaboratory("12332", "adsfadsfas", "adfadsfas", "22211122233", "12412342341234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinNumberCannotHaveLessThan10Digits() {
        ctrl.registerNewClinicalAnalysisLaboratory("14241", "asdgdsgda", "dafsdsfadf", "12341341324", "2142421");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinNumberCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("Mario", "adsfsdfasd", "afsasdfasd", "12341371324", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericAddressAreNotAccepted() {
        ctrl.registerNewClinicalAnalysisLaboratory("21243", "adsfsfasdf", "§@DSAFASD", "56549817123", "5654987123");
    }

    @Test
    public void ensureAddressCanHave30Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("Maria", "adfasdf", "aaadfasdasdasdsgasdasgsdgsd2aa", "96341987899", "1231313213"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAddressCannotHaveMoreThan30Char() {
        ctrl.registerNewClinicalAnalysisLaboratory("13412", "dasfasdfa", "aaadfasdasdasdsgasdasgsdgsd2aafasf", "86513451455", "1231313213");
    }

    @Test
    public void ensureAddressCanHaveLessThan30Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("56754", "adsvsdvd", "ert56", "21986174545", "2186174545"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAddressCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("21319", "dadsvasdv", "", "11199980887", "1119998887");
    }

    @Test
    public void ensureCannotCreateSameClinicalAnalysisLaboratoryTwice() {
        ctrl.registerNewClinicalAnalysisLaboratory("13243", "adsfsdfad", "adsfasdfa", "12345678690", "2142534345");
        ctrl.saveClinicalAnalysisLaboratory();
        ctrl.registerNewClinicalAnalysisLaboratory("13243", "adsfsdfad", "adsfasdfa", "12345678690", "2142534345");
        assertFalse(ctrl.saveClinicalAnalysisLaboratory());
    }


}



































