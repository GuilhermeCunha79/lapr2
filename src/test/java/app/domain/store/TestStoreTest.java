package app.domain.store;

import app.domain.model.*;
import app.mappers.dto.ClientDTO;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class TestStoreTest {

    TestStore testStore = new TestStore();

    @Before
    public void createTest() {
        Client client = new Client(new ClientDTO("Sara", "2222227777777272", "1111112222", "3232343535", "04/05/1555","female" ,"2424250121","sara@isep.ipp.pt"));
        TypeOfTest typeOfTest = new TypeOfTest("40026", "10121", "639", new ParameterCategory("77007", "ji"));
        List<Parameter> lparameter = new ArrayList<>();
        lparameter.add(new Parameter("66767", "qb", "191919", new ParameterCategory("00177", "fff")));
        CATest caTest = testStore.createTest("110121202021", client, typeOfTest, lparameter, "11919");
        testStore.saveTest(caTest);
    }




}
