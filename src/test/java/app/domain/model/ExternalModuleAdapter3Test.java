package app.domain.model;

import junit.framework.TestCase;

public class ExternalModuleAdapter3Test extends TestCase {

    public void testGetReferenceValue() {
        Parameter parameter = new Parameter("14234", "Ola", "Ola", new ParameterCategory("Blood", "Hemogram"));
        ExternalModuleAdapter3 externalModuleAdapter3 = new ExternalModuleAdapter3();
        assertNotNull(externalModuleAdapter3.getReferenceValue(parameter));
    }
}