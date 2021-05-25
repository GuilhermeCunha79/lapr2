package app.domain.mappers;

import app.domain.model.ParameterCategory;
import app.mappers.ParameterCategoryMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
        expected.add("(12345) abcd");
        expected.add("(54321) adaca");
        assertEquals(expected, ParameterCategoryMapper.toDTO(lpc));
    }
}
