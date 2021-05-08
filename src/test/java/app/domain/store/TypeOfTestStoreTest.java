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

    @Test
    public void ensureCannotAddSameTypeOfTestTwice(){
        Listpc.add(pc);
        TypeOfTest tot1 = tots.createTypeOfTest("34567", "RNA remnants", "cotton swab",Listpc );
        TypeOfTest tot2 = tots.createTypeOfTest("34567", "RNA remnants", "cotton swab", Listpc);
        tots.saveTypeOfTest(tot1);
        assertFalse(tots.saveTypeOfTest(tot2));
    }

    @Test
    public void ensureCannotAddSameTypeOfTestTwiceTest2AddNewTypeOfTest(){
        Listpc.add(pc);
        TypeOfTest tot1 = tots.createTypeOfTest("14567", "RNA remnants", "saliva bottle",  Listpc);
        TypeOfTest tot2 = tots.createTypeOfTest("14567", "RNA remnants", "saliva bottle", Listpc);
        tots.addTypeOfTest(tot1);
        assertFalse(tots.addTypeOfTest(tot2));
    }

    @Test
    public void ensureAdd2differentTypeOfTestWorks(){
        Listpc.add(pc);
        TypeOfTest tot1 = tots.createTypeOfTest("13567", "RNA remnants", "cotton swab",  Listpc);
        TypeOfTest tot2 = tots.createTypeOfTest("13557", "DNA remnants", "saliva bottle", Listpc);
        tots.addTypeOfTest(tot1);
        assertTrue(tots.addTypeOfTest(tot2));
    }

    @Test
    public void ensureAddNullTypeOfTestDontWork(){
        assertFalse(tots.addTypeOfTest(null));
    }

    @Test
    public void testGetCategoryListMethod(){
        Listpc.add(pc);
        TypeOfTest tot1 = tots.createTypeOfTest("13599", "Sangue", "urine", Listpc);
        TypeOfTest tot2 = tots.createTypeOfTest("13591", "HNS", "Thoot", Listpc);
        tots.saveTypeOfTest(tot1);
        tots.saveTypeOfTest(tot2);
        assertTrue(tots.getTypeOfTestList().contains(tot1) && tots.getTypeOfTestList().contains(tot2));
    }
}