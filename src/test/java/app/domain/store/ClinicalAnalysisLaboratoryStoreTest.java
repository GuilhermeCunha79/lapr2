package app.domain.store;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ClinicalAnalysisLaboratoryStoreTest {

    ClinicalAnalysisLaboratoryStore cals = new ClinicalAnalysisLaboratoryStore();

    @Before
    public void createLaboratoryList() {
        ClinicalAnalysisLaboratory cal = cals.registerClinicalAnalysisLaboratory("Andre", "92898235465", "d3,7y", "3219877895", "RuaDoChocolate11", new ArrayList<>());
        cals.saveClinicalAnalysisLaboratory(cal);
    }


}


