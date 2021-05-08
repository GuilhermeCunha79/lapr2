package app.domain.store;

import app.domain.model.TypeOfTest;
import app.domain.model.ParameterCategory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TypeOfTestStoreTest  {


    ParameterCategoryStore pcs = new ParameterCategoryStore();
    @Before
    public void createCategoryList(){
        ParameterCategory pc2 = pcs.createParameterCategory("52815", "Src");
        pcs.saveParameterCategory(pc2);
    }

   TypeOfTestStore tots = new TypeOfTestStore();

    @Test
    public void ensureCannotAddSameTypeOfTestTwice(){
        TypeOfTest tot1 = tots.createTypeOfTest("34567", "RNA remnants", "cotton swab", "Scr");
        TypeOfTest tot2 = tots.createTypeOfTest("34567", "RNA remnants", "cotton swab", "Scr");
        tots.saveTypeOfTest(tot1);
        assertFalse(tots.saveTypeOfTest(tot2));
    }

    @Test
    public void ensureCannotAddSameTypeOfTestTwiceTest2AddNewTypeOfTest(){
        TypeOfTest tot1 = tots.createTypeOfTest("14567", "RNA remnants", "saliva bottle", "Scr");
        TypeOfTest tot2 = tots.createTypeOfTest("14567", "RNA remnants", "saliva bottle", "Scr");
        tots.addTypeOfTest(tot1);
        assertFalse(tots.addTypeOfTest(tot2));
    }

    @Test
    public void ensureAdd2differentTypeOfTestWorks(){
        TypeOfTest tot1 = tots.createTypeOfTest("13567", "RNA remnants", "cotton swab", "Scr");
        TypeOfTest tot2 = tots.createTypeOfTest("13557", "DNA remnants", "saliva bottle", "Scr");
        tots.addTypeOfTest(tot1);
        assertTrue(tots.addTypeOfTest(tot2));
    }

    @Test
    public void ensureAddNullTypeOfTestDontWork(){
        assertFalse(tots.addTypeOfTest(null));
    }

    @Test
    public void testGetCategoryListMethod(){
        TypeOfTest tot1 = tots.createTypeOfTest("13599", "Sangue", "urine", "Scr");
        TypeOfTest tot2 = tots.createTypeOfTest("13591", "HNS", "Thoot", "Scr");
        tots.saveTypeOfTest(tot1);
        tots.saveTypeOfTest(tot2);
        assertTrue(tots.getTypeOfTestList().contains(tot1) && tots.getTypeOfTestList().contains(tot2));
    }
}