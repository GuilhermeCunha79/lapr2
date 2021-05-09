package app.domain.store;

import app.domain.model.ParameterCategory;
import org.junit.Test;

import static org.junit.Assert.*;


public class ParameterCategoryStoreTest {

    ParameterCategoryStore pcs = new ParameterCategoryStore();

    /**
     * Checks that it is not possible to add the same parameter category twice
     */
    @Test
    public void ensureCannotAddSameCategoryTwice(){
        ParameterCategory pc1 = pcs.createParameterCategory("12345", "hemograms");
        ParameterCategory pc2 = pcs.createParameterCategory("12345", "hemograms");
        pcs.saveParameterCategory(pc1);
        assertFalse(pcs.saveParameterCategory(pc2));
    }
    /**
     * Checks that it is possible to add two different parameter category
     */
    @Test
    public void ensureAdd2differentCategoryWorks(){
        ParameterCategory pc1 = pcs.createParameterCategory("12345", "hemograms");
        ParameterCategory pc2 = pcs.createParameterCategory("12325", "urine");
        pcs.saveParameterCategory(pc1);
        assertTrue(pcs.saveParameterCategory(pc2));
    }
    /**
     * Checks that it is not possible to add a null parameter category
     */
    @Test
    public void ensureAddNullCategoryDontWork(){
        assertFalse(pcs.saveParameterCategory(null));
    }
    /**
     * Verify that it is getParameterCategoryList method works as intended
     */
    @Test
    public void testGetCategoryListMethod(){
        ParameterCategory pc1 = pcs.createParameterCategory("12345", "hemograms");
        ParameterCategory pc2 = pcs.createParameterCategory("12325", "urine");
        pcs.saveParameterCategory(pc1);
        pcs.saveParameterCategory(pc2);
        assertTrue(pcs.getParameterCategoryList().contains(pc1) && pcs.getParameterCategoryList().contains(pc2));
    }


}