package app.domain.model;

import com.example1.ExternalModule3API;

public class ExternalModuleAdapter2 implements ExternalModule{

    /**
     * Adapter for the external module 2
     * @param parameter used to get the reference values
     * @return the reference values
     */
    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {
        ExternalModule3API em3 = new ExternalModule3API();
        return new ReferenceValue(em3.getMinReferenceValue(parameter.getCode(), 12345), em3.getMaxReferenceValue(parameter.getCode(),
                12345), em3.usedMetric(parameter.getCode(), 12345));
    }
}
