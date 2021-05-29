package app.domain.mappers;


import app.controller.App;
import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.store.ClinicalAnalysisLaboratoryStore;
import app.mappers.CalListMapper;
import app.mappers.ParameterCategoryMapper;
import app.mappers.ParameterMapper;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MappersTest {

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
