package app.domain.store;

import app.domain.model.ParameterCategory;
import org.junit.Test;

import static org.junit.Assert.*;


public class ParameterCategoryStoreTest {

    ParameterCategoryStore pcs = new ParameterCategoryStore();
    @Test
    public void ensureCannotAddSameCategoryTwice(){
        ParameterCategory pc1 = pcs.createParameterCategory("12345", "hemograms");
        ParameterCategory pc2 = pcs.createParameterCategory("12345", "hemograms");
        pcs.saveParameterCategory(pc1);
        assertFalse(pcs.saveParameterCategory(pc2));
    }

    @Test
    public void ensureAdd2differentCategoryWorks(){
        ParameterCategory pc1 = pcs.createParameterCategory("12345", "hemograms");
        ParameterCategory pc2 = pcs.createParameterCategory("12325", "urine");
        pcs.saveParameterCategory(pc1);
        assertTrue(pcs.saveParameterCategory(pc2));
    }

    @Test
    public void ensureAddNullCategoryDontWork(){
        assertFalse(pcs.addParameterCategory(null));
    }



}