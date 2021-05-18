package app.domain.store;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ParameterStoreTest {

    ParameterCategoryStore pcs = new ParameterCategoryStore();
    ParameterStore ps = new ParameterStore();
    

    /**
     * Creates a category to be used in other tests that need it
     *
     */
    @Before
    public void createCategoryList(){
        ParameterCategory pc2 = pcs.createParameterCategory("12345", "hemograms");
        pcs.saveParameterCategory(pc2);
    }

    /**
     * Verify that it is not possible to add the same parameter twice(saveParameter method)
     */
    @Test
    public void ensureCannotAddSameParameterTwice(){
        Parameter p1 = ps.createParameter("12345", "Cells", "Whatever", "hemograms");
        Parameter p2 = ps.createParameter("12345", "Cells", "Whatever", "hemograms");
        ps.saveParameter(p1);
        assertFalse(ps.saveParameter(p2));
    }

    /**
     * Verify that it is not possible to add the same parameter twice (tests addParameter method)
     */

    @Test
    public void ensureCannotAddSameParameterTwiceTest2AddParameter(){
        Parameter p1 = ps.createParameter("12325", "Cell", "description", "hemograms");
        Parameter p2 = ps.createParameter("12325", "Cell", "description", "hemograms");
        ps.saveParameter(p1);
        assertFalse(ps.saveParameter(p2));
    }

    /**
     * Ensures that it is possible to add two different parameters to the system
     */

    @Test
    public void ensureAdd2differentParametersWorks(){
        Parameter p1 = ps.createParameter("12322", "Blood", "addText", "hemograms");
        Parameter p2 = ps.createParameter("12321", "Cel", "descriptions", "hemograms");
        ps.saveParameter(p1);
        assertTrue(ps.saveParameter(p2));
    }
    /**
     * Verify that it is not possible to add a null parameter
     */
    @Test
    public void ensureAddNullParameterDontWork(){
        assertFalse(ps.saveParameter(null));
    }

    /**
     * Verify that it is getParameterList method works as intended
     */
    @Test
    public void testGetCategoryListMethod(){
        Parameter p1 = ps.createParameter("12327", "Covid", "add description", "hemograms");
        Parameter p2 = ps.createParameter("12321", "Covid-19", "no description", "hemograms");
        ps.saveParameter(p1);
        ps.saveParameter(p2);
        assertTrue(ps.getParameterList().contains(p1) && ps.getParameterList().contains(p2));
    }


}