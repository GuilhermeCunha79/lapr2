/*package app.domain.store;

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
        ClinicalAnalysisLaboratory cal = cals.registerClinicalAnalysisLaboratory("d3t7y", "Andre", "RuaDoChocolate11", "32198177895", "3219817789");
        cals.saveClinicalAnalysisLaboratory(cal);
    }

    ClinicalAnalysisLaboratoryStore c = new ClinicalAnalysisLaboratoryStore();

    @Test
    public void ensureCannotAddSameClinicalAnalysisLaboratoryTwice() {
        ClinicalAnalysisLaboratory c1 = c.registerClinicalAnalysisLaboratory("d3t7y", "Andre", "RuaDoChocolate11", "32198177895", "3219817789");
        ClinicalAnalysisLaboratory c2 = c.registerClinicalAnalysisLaboratory("d3t7y", "Andre", "RuaDoChocolate11", "32198177895", "3219817789");
        c.saveClinicalAnalysisLaboratory(c1);
        assertFalse(c.saveClinicalAnalysisLaboratory(c2));
    }

    @Test
    public void ensureAdd2DifferentClinicalAnalysisLaboratoriesWorks() {
        ClinicalAnalysisLaboratory c1 = c.registerClinicalAnalysisLaboratory("acs39", "Juliana", "RuaDaMoita345", "31749155631", "3454365498");
        ClinicalAnalysisLaboratory c2 = c.registerClinicalAnalysisLaboratory("ac212", "Juli", "RuaDaMoita5", "31329155631", "3454325498");
        c.saveClinicalAnalysisLaboratory(c1);
        assertTrue(c.saveClinicalAnalysisLaboratory(c2));
    }

    @Test
    public void ensureAddNullLaboratoryDontWork() {
        assertFalse(c.saveClinicalAnalysisLaboratory(null));
    }

    @Test
    public void testGetCategoryListMethod() {
        ClinicalAnalysisLaboratory c1 = c.registerClinicalAnalysisLaboratory("ac139", "lab31", "RuaDaMoita5", "31743155631", "3454545498");
        ClinicalAnalysisLaboratory c2 = c.registerClinicalAnalysisLaboratory("ac239", "lab1", "RuaMoita5", "31776155631", "3454585498");
        c.saveClinicalAnalysisLaboratory(c1);
        c.saveClinicalAnalysisLaboratory(c2);
        assertTrue(c.getClinicalAnalysisLaboratoryList().contains(c1) && c.getClinicalAnalysisLaboratoryList().contains(c2));
    }
}*/









