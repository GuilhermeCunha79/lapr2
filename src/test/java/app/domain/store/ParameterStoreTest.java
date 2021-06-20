package app.domain.store;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ParameterStoreTest {

    ParameterCategoryStore pcs = new ParameterCategoryStore();
    ParameterStore ps = new ParameterStore();
    List<ParameterCategory> pcList = new ArrayList<>();


/**
     * Creates a category to be used in other tests that need it
     */


    @Before
    public void createCategoryList(){
        ParameterCategory pc2 = pcs.createParameterCategory("12345", "hemograms");
        ParameterCategory pc1 = pcs.createParameterCategory("34232", "Covid");
        pcs.saveParameterCategory(pc2);
        pcs.saveParameterCategory(pc1);

        pcList.add(pc1);
        pcList.add(pc2);
    }

/**
     * Verify that it is not possible to add the same parameter twice(saveParameter method)
*/

    @Test
    public void ensureCannotAddSameParameterTwice(){
        Parameter p1 = ps.createParameter("12345", "Cells", "Whatever", "12345");
        Parameter p2 = ps.createParameter("12345", "Cells", "Whatever", "12345");
        ps.saveParameter(p1);
        assertFalse(ps.saveParameter(p2));
    }

/**
     * Ensures that it is possible to add two different parameters to the system
*/


    @Test
    public void ensureAdd2differentParametersWorks(){
        Parameter p1 = ps.createParameter("12322", "Blood", "addText", "12345");
        Parameter p2 = ps.createParameter("12321", "Cel", "descriptions", "12345");
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
        Parameter p1 = ps.createParameter("12327", "Covid", "add description", "12345");
        Parameter p2 = ps.createParameter("12321", "Covid-19", "no description", "12345");
        ps.saveParameter(p1);
        ps.saveParameter(p2);
        assertTrue(ps.getParameterList().contains(p1) && ps.getParameterList().contains(p2));
    }

    @Test
    public void testGetParameterListByCodeMethod(){
        Parameter p1 = ps.createParameter("12327", "Covid", "add description", "12345");
        Parameter p2 = ps.createParameter("12321", "Covid-19", "no description", "12345");
        ps.saveParameter(p1);
        ps.saveParameter(p2);
        assertEquals(p1, ps.getParameterByCode("12327"));
    }

    @Test
    public void testGetParameterByCodeMethod(){
        Parameter p1 = ps.createParameter("12327", "Covid", "add description", "34232");
        Parameter p2 = ps.createParameter("12321", "Covid-19", "no description", "12345");

        ps.saveParameter(p1);
        ps.saveParameter(p2);

        assertEquals(p1, ps.getParameterByCode("12327"));
    }

    @Test
    public void testGetParameterByCodeGetNullMethod(){
        Parameter p1 = ps.createParameter("12327", "Covid", "add description", "34232");
        Parameter p2 = ps.createParameter("12321", "Covid-19", "no description", "12345");

        ps.saveParameter(p1);
        ps.saveParameter(p2);

        assertNull(ps.getParameterByCode("23232"));
    }

    @Test
    public void testGetParameterListByTheCategory() {
        Parameter p1 = ps.createParameter("12345", "Covid", "add description", "12345");
        Parameter p2 = ps.createParameter("12321", "Covid-19", "no description", "12345");
        ps.saveParameter(p1);
        ps.saveParameter(p2);
        assertEquals(p1.getCategory().getCode(), ps.getParameterListByTheCategory(pcList).get(0).getCode());
    }
}
