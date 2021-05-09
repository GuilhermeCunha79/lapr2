package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClinicalAnalysisLaboratoryStoreTest {

    ClinicalAnalysisLaboratoryStore cals = new ClinicalAnalysisLaboratoryStore();

    @Before
    public void createLaboratoryList() {
        ClinicalAnalysisLaboratory cal = cals.registerClinicalAnalysisLaboratory("Andre", "92898235465", "d3t7y", "3219877895", "RuaDoChocolate11", new ArrayList<>());
        cals.saveClinicalAnalysisLaboratory(cal);
    }

    ClinicalAnalysisLaboratoryStore c = new ClinicalAnalysisLaboratoryStore();

    @Test
    public void ensureCannotAddSameClinicalAnalysisLaboratoryTwice() {
        ClinicalAnalysisLaboratory c1 = c.registerClinicalAnalysisLaboratory("Andre", "92898235465", "d3t7y", "3219877895", "RuaDoChocolate11", new ArrayList<>());
        ClinicalAnalysisLaboratory c2 = c.registerClinicalAnalysisLaboratory("Andre", "92898235465", "d3t7y", "3219877895", "RuaDoChocolate11", new ArrayList<>());
        c.saveClinicalAnalysisLaboratory(c1);
        assertFalse(c.saveClinicalAnalysisLaboratory(c2));
    }

    @Test
    public void ensureCannotAddSameClinicalAnalysisLaboratoryTwiceTest2AddClinicalAnalysisLaboratory() {
        ClinicalAnalysisLaboratory c1 = c.registerClinicalAnalysisLaboratory("Joao", "18998643596", "ertu8", "7896541254", "RuaDaBoavista49", new ArrayList<>());
        ClinicalAnalysisLaboratory c2 = c.registerClinicalAnalysisLaboratory("Joao", "18998643596", "ertu8", "7896541254", "RuaDaBoavista49", new ArrayList<>());
        c.addClinicalAnalysisLaboratory(c1);
        assertFalse(c.addClinicalAnalysisLaboratory(c2));
    }

    @Test
    public void ensureAdd2DifferentClinicalAnalysisLaboratoriesWorks() {
        ClinicalAnalysisLaboratory c1 = c.registerClinicalAnalysisLaboratory("Juliana", "34543675498", "acs39", "3174955631", "RuaDaMoita345", new ArrayList<>());
        ClinicalAnalysisLaboratory c2 = c.registerClinicalAnalysisLaboratory("Julia", "67832449864", "tyu71", "4145639745", "RuaDaMota354", new ArrayList<>());
        c.saveClinicalAnalysisLaboratory(c1);
        assertTrue(c.saveClinicalAnalysisLaboratory(c2));
    }

    @Test
    public void ensureAddNullLaboratoryDontWork() {
        assertFalse(c.addClinicalAnalysisLaboratory(null));
    }

    @Test
    public void testGetCategoryListMethod() {
        ClinicalAnalysisLaboratory c1 = c.registerClinicalAnalysisLaboratory("Samanta", "78541236547", "fghj9", "8964716509", "RuaDaTravessa33", new ArrayList<>());
        ClinicalAnalysisLaboratory c2 = c.registerClinicalAnalysisLaboratory("Sandra", "85631778429", "zmb41", "1593578426", "RuaNovaDaConsituicao45", new ArrayList<>());
        c.saveClinicalAnalysisLaboratory(c1);
        c.saveClinicalAnalysisLaboratory(c2);
        assertTrue(c.getClinicalAnalysisLaboratoryList().contains(c1) && c.getClinicalAnalysisLaboratoryList().contains(c2));
    }
}









