package app.domain.store;

import app.domain.model.*;
import app.mappers.dto.ClientDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestStoreTest {

    TestStore testStore = new TestStore();

    @Before
    public void createTest() {
        Client client = new Client(new ClientDTO("Sara", "2222227777777272", "1111112222", "3232343535", "04/05/2000","female" ,"24242350121","sara@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("40026", "10121", "639", new ParameterCategory("77007", "ji"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("66767", "qb", "191919", new ParameterCategory("00177", "fff")));
        CATest caTest = testStore.createTest("110121202021", client, typeOfTest, lparameter, "11919");
        testStore.saveTest(caTest);
    }

    TestStore ts = new TestStore();

    @Test
    public void ensureCannotAddSameTestTwice() {
        Client client1 = new Client(new ClientDTO("Diogo", "0010165410141012", "0001412541", "0011014541", "22/02/2021", "male" , "77470147985", "diogo@isep.ipp.pt"));
        Client client2 = new Client(new ClientDTO("Diogo", "0010165410141012", "0001412541", "0011014541", "22/02/2021","male" , "77470147985", "diogo@isep.ipp.pt"));
        TypeOfTest typeOfTest1 = new TypeOfTest("22120", "7","2101", new ParameterCategory("01009", "lço"));
        TypeOfTest typeOfTest2 = new TypeOfTest("22120", "7","2101", new ParameterCategory("01009", "lço"));
        List<Parameter> lparameter1 = new ArrayList<>();
        lparameter1.add(new Parameter("11711", "aza", "44", new ParameterCategory("88770", "kkj")));
        List<Parameter> lparameter2 = new ArrayList<>();
        lparameter2.add(new Parameter("11711", "aza", "44", new ParameterCategory("88770", "kkj")));
        CATest catest1 = ts.createTest("111014541454", client1, typeOfTest1, lparameter1, "55000");
        CATest catest2 = ts.createTest("111014541454", client2, typeOfTest2, lparameter2, "55000");
    }


    @Test
    public void ensureAddNullTestDontWork() {
        assertFalse(ts.saveTest(null));
    }




}
