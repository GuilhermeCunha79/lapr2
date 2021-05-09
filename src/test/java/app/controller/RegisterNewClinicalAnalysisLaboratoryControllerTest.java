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
        ctrl.registerNewClinicalAnalysisLaboratory(null, null, null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureClinicalAnalysisLaboratoryIsNotCreatedWithBlankAttributes() {
        ctrl.registerNewClinicalAnalysisLaboratory("", "", "", "", "", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericNameAreNotAccepted() {
        ctrl.registerNewClinicalAnalysisLaboratory("T2om<s@", "12345678901", "a1234", "1234567890", "RuaDeFornos223", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotHaveMoreThan20Char() {
        ctrl.registerNewClinicalAnalysisLaboratory("MariaFonsecaOliveiraDias", "12341234123", "b34d5", "2323148976", "AvenidaDaLiberdade34", new ArrayList<>());
    }

    @Test
    public void ensureNameCanHaveLessThan20Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("DiogoDias", "11234543565", "k9k87", "2123435459", "RuaDoCorvo65", new ArrayList<>()));
    }

    @Test
    public void ensureNameCanHave20Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("JoaoPedroSilvaDaniel", "45678989999", "f54f5", "7685450976", "RuaDosDescobrimentos17", new ArrayList<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("", "21213434345", "g5g67", "6543211121", "AvenidaDaMemoria34", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberMustHaveNumbers() {
        ctrl.registerNewClinicalAnalysisLaboratory("Joana", "aaaaaaaaaaa", "w3x4d", "3434343434", "RuaEstreita41", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotHaveMoreThan11Digits() {
        ctrl.registerNewClinicalAnalysisLaboratory("JoaoPaulo", "234321564758", "q2w3e", "9645090867", "RuaCentral45", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotHaveLessThan11Digits() {
        ctrl.registerNewClinicalAnalysisLaboratory("RicardoReis", "4878657097", "we3r4", "4370954325", "RuaLateral87", new ArrayList<>());
    }

    @Test
    public void ensurePhoneNumberMustHave11Digits() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("Rui", "23212123233", "d4r56", "9897898988", "RuaDezembro56", new ArrayList<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("Lia", "", "z3z45", "2434541421", "AvenidaRaimundo98", new ArrayList<>());
    }

    @Test
    public void ensureLaboratoryIDMustHaveAlphanumericChar() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("Sergio", "21987654323", "a23de", "4546567879", "RuaEscura76", new ArrayList<>()));
    }

    @Test
    public void ensureLaboratoryIDMustHave5AlphanumericChar() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("Sofia", "91211808691", "f120o", "1219659656", "AvenidaPicoto987", new ArrayList<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDCannotHaveMoreThan5AlphanumericChar() {
        ctrl.registerNewClinicalAnalysisLaboratory("Julia", "91481806878", "v545tt", "4346765699", "RuaDoCharco314", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDCannotHaveLessThan5AlphanumericChar() {
        ctrl.registerNewClinicalAnalysisLaboratory("Ana", "25643164854", "fr5e", "5459616498", "AvenidaDaSolidao76", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("Rita", "25556667543", "", "9998887776", "RuaDaAlegria34", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinNumberMustHaveDigits() {
        ctrl.registerNewClinicalAnalysisLaboratory("Diana", "91621304747", "ft165", "1<12223332", "NacionalN1", new ArrayList<>());
    }

    @Test
    public void ensureTinNumberMustHave10Digits() {
       assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("Marta", "23113224565", "hji11", "9812143212", "AvenidaDaFelicidade21", new ArrayList<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinNumberCannotHaveMoreThan10Digits() {
        ctrl.registerNewClinicalAnalysisLaboratory("Raquel", "91411623636", "lk122", "22211122233", "AvenidaDaFaculdade67", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinNumberCannotHaveLessThan10Digits() {
        ctrl.registerNewClinicalAnalysisLaboratory("Daniel", "91343221221", "lk122", "21", "RuaDoComercio32", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTinNumberCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("Mario", "64821545632", "ghij7", "", "RuaApertada32", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNonAlphaNumericAddressAreNotAccepted() {
        ctrl.registerNewClinicalAnalysisLaboratory("Joaquim", "21232343454", "w9i9i", "5654987123", "Ruad<Dragão,1", new ArrayList<>());
    }

    @Test
    public void ensureAddressCanHave30Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("Maria", "33344433367", "aa2aa", "9634987899", "AvenidaDaRepublicaEArredores35", new ArrayList<>()));
    }

    @Test
    public void ensureAddressCanHaveMoreThan30Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("Rafael", "21114555676", "12g67", "8651345455", "AvenidadaRepublicaEDaLiberdade4566", new ArrayList<>()));
    }

    @Test
    public void ensureAddressCanHaveLessThan30Char() {
        assertTrue(ctrl.registerNewClinicalAnalysisLaboratory("Rafaela", "56566678798", "ert56", "2198674545", "Rua43", new ArrayList<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAddressCannotBeCreatedBlank() {
        ctrl.registerNewClinicalAnalysisLaboratory("Rui","55555666777", "123as", "1119998887", "", new ArrayList<>());
    }

    @Test
    public void ensureCannotCreateSameClinicalAnalysisLaboratoryTwice() {
        ctrl.registerNewClinicalAnalysisLaboratory("Tomas", "12345678907","gt615","1234567890","RuaSantosSilva44", new ArrayList<>());
        ctrl.saveClinicalAnalysisLaboratory();
        ctrl.registerNewClinicalAnalysisLaboratory("Tomas", "12345678907","gt615","1234567890","RuaSantosSilva44", new ArrayList<>());
        assertFalse(ctrl.saveClinicalAnalysisLaboratory());
    }




}



































