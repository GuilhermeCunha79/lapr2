package app.domain.store;

import app.domain.model.TypeOfTest;
import app.domain.model.ParameterCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TypeOfTestStoreTest  {


    ParameterCategoryStore pcs = new ParameterCategoryStore();
    @Before
    public void createCategoryList(){
        ParameterCategory pc2 = pcs.createParameterCategory("52815", "Src");
        pcs.saveParameterCategory(pc2);
    }

    ArrayList<ParameterCategory> Listpc = new ArrayList<ParameterCategory>();

    ParameterCategory pc = new ParameterCategory("34567", "Src");

   TypeOfTestStore tots = new TypeOfTestStore();


    /**
     * Verify that it is not possible to add the same Type of Test twice(saveTypeOfTest method)
     */
    @Test
    public void ensureCannotAddSameTypeOfTestTwice(){
        Listpc.add(pc);
        TypeOfTest tot1 = tots.createTypeOfTest("34567", "RNA remnants", "cotton swab",pc );
        TypeOfTest tot2 = tots.createTypeOfTest("34567", "RNA remnants", "cotton swab", pc);
        tots.saveTypeOfTest(tot1);
        assertFalse(tots.saveTypeOfTest(tot2));
    }

    /**
     * Verify that it is not possible to add the same type of test twice (tests addTYpeofTest method)
     */
    @Test
    public void ensureCannotAddSameTypeOfTestTwiceTest2AddNewTypeOfTest(){
        Listpc.add(pc);
        TypeOfTest tot1 = tots.createTypeOfTest("14567", "RNA remnants", "saliva bottle",  pc);
        TypeOfTest tot2 = tots.createTypeOfTest("14567", "RNA remnants", "saliva bottle", pc);
        tots.saveTypeOfTest(tot1);
        assertFalse(tots.saveTypeOfTest(tot2));
    }

    /**
     * Ensures that it is possible to add two different Types of Test to the system
     */
    @Test
    public void ensureAdd2differentTypeOfTestWorks(){
        Listpc.add(pc);
        TypeOfTest tot1 = tots.createTypeOfTest("13567", "RNA remnants", "cotton swab",  pc);
        TypeOfTest tot2 = tots.createTypeOfTest("13557", "DNA remnants", "saliva bottle", pc);
        tots.saveTypeOfTest(tot1);
        assertTrue(tots.saveTypeOfTest(tot2));
    }

    /**
     * Verify that it is not possible to add a null Types of Test
     */
    @Test
    public void ensureAddNullTypeOfTestDontWork(){
        assertFalse(tots.saveTypeOfTest(null));
    }

    /**
     * Verify that it is getTypeOfTestList method works as intended
     */
    public void testGetTypeofTestListMethod(){
        Listpc.add(pc);
        TypeOfTest tot1 = tots.createTypeOfTest("13599", "Sangue", "urine", pc);
        TypeOfTest tot2 = tots.createTypeOfTest("13591", "HNS", "Thoot", pc);
        tots.saveTypeOfTest(tot1);
        tots.saveTypeOfTest(tot2);
        assertTrue(tots.getTypeOfTestList().contains(tot1) && tots.getTypeOfTestList().contains(tot2));
    }
}