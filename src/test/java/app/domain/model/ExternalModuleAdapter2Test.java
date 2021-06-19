package app.domain.model;

import junit.framework.TestCase;

public class ExternalModuleAdapter2Test extends TestCase {

    public void testGetReferenceValue() {
        Parameter parameter = new Parameter("14234", "Ola", "Ola", new ParameterCategory("Blood", "Hemogram"));
        ExternalModuleAdapter2 externalModuleAdapter2 = new ExternalModuleAdapter2();
        assertNotNull(externalModuleAdapter2.getReferenceValue(parameter));
    }
}