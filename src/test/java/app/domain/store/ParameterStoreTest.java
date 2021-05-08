package app.domain.store;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ParameterStoreTest {

    ParameterCategoryStore pcs = new ParameterCategoryStore();
    @Before
    public void createCategoryList(){
        ParameterCategory pc2 = pcs.createParameterCategory("12345", "hemograms");
        pcs.saveParameterCategory(pc2);
    }

    ParameterStore ps = new ParameterStore();
    @Test
    public void ensureCannotAddSameParameterTwice(){
        Parameter p1 = ps.createParameter("12345", "Cells", "Whatever", "hemograms");
        Parameter p2 = ps.createParameter("12345", "Cells", "Whatever", "hemograms");
        ps.saveParameter(p1);
        assertFalse(ps.saveParameter(p2));
    }

    @Test
    public void ensureCannotAddSameParameterTwiceTest2AddParameter(){
        Parameter p1 = ps.createParameter("12325", "Cell", "description", "hemograms");
        Parameter p2 = ps.createParameter("12325", "Cell", "description", "hemograms");
        ps.addParameter(p1);
        assertFalse(ps.addParameter(p2));
    }

    @Test
    public void ensureAdd2differentParametersWorks(){
        Parameter p1 = ps.createParameter("12322", "Blood", "addText", "hemograms");
        Parameter p2 = ps.createParameter("12321", "Cel", "descriptions", "hemograms");
        ps.saveParameter(p1);
        assertTrue(ps.saveParameter(p2));
    }

    @Test
    public void ensureAddNullCategoryDontWork(){
        assertFalse(ps.addParameter(null));
    }

    @Test
    public void testGetCategoryListMethod(){
        Parameter p1 = ps.createParameter("12327", "Covid", "add description", "hemograms");
        Parameter p2 = ps.createParameter("12321", "Covid-19", "no description", "hemograms");
        ps.saveParameter(p1);
        ps.saveParameter(p2);
        assertTrue(ps.getParameterList().contains(p1) && ps.getParameterList().contains(p2));
    }


}