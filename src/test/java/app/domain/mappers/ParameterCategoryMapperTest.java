package app.domain.mappers;


import app.domain.model.ParameterCategory;
import app.mappers.ParameterCategoryMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryMapperTest {
    @Test
    public void testParameterCategoryMapper(){
        ParameterCategory pc = new ParameterCategory("12345", "abcd");
        ParameterCategory pc2 = new ParameterCategory("54321", "adaca");
        List<ParameterCategory> lpc = new ArrayList<>();
        lpc.add(pc);
        lpc.add(pc2);
        List<String> expected = new ArrayList<>();
        expected.add(String.format("Parameter Category -> Name: abcd | Code: 12345 |%n"));
        expected.add(String.format("Parameter Category -> Name: adaca | Code: 54321 |%n"));
        assertEquals(expected, ParameterCategoryMapper.toDTO(lpc));
    }

    @Test
    public void testMapperWithoutPCategories(){
        List<ParameterCategory> lpc = new ArrayList<>();
        assertNotNull(ParameterCategoryMapper.toDTO(lpc));
    }

    @Test(expected = IllegalStateException.class)
    public void testConstructorMapper(){
        new ParameterCategoryMapper();
    }
}
