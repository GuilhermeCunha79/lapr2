package app.domain.mappers;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.mappers.ParameterMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParameterMapperTest {
    @Test
    public void testParameterMapper(){
        ParameterCategory pc1 = new ParameterCategory("54321", "adaca");
        Parameter p1 = new Parameter("12345", "abcd", "adsavaa", pc1);
        Parameter p2 = new Parameter("45345", "adsfa", "asdfsdfsd", pc1);
        List<Parameter> lp = new ArrayList<>();
        lp.add(p1);
        lp.add(p2);
        List<String> expected = new ArrayList<>();
        expected.add("Parameter -> Code: 12345 | Name: abcd | Description: adsavaa");
        expected.add("Parameter -> Code: 45345 | Name: adsfa | Description: asdfsdfsd");
        assertEquals(expected, ParameterMapper.toDto(lp));
    }

    @Test
    public void testMapperWithoutParameters(){
        List<Parameter> lp = new ArrayList<>();
        assertNotNull(ParameterMapper.toDto(lp));
    }
}
