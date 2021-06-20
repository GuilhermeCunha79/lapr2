package app.domain.model;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ExternalModuleAdapter2Test {

    @Test
    public void testGetReferenceValue() {
        Parameter parameter = new Parameter("14234", "Ola", "Ola", new ParameterCategory("Blood", "Hemogram"));
        ExternalModuleAdapter2 externalModuleAdapter2 = new ExternalModuleAdapter2();
        assertNotNull(externalModuleAdapter2.getReferenceValue(parameter));
    }
}