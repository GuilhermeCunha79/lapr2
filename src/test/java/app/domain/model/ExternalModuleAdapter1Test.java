package app.domain.model;

import junit.framework.TestCase;

public class ExternalModuleAdapter1Test extends TestCase {

    public void testGetReferenceValue() {
        Parameter parameter = new Parameter("14234", "Ola", "Ola", new ParameterCategory("Blood", "Hemogram"));
        ExternalModuleAdapter1 externalModuleAdapter1 = new ExternalModuleAdapter1();
        assertNotNull(externalModuleAdapter1.getReferenceValue(parameter));
    }
}