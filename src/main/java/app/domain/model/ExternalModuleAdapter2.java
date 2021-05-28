package app.domain.model;

import com.example1.ExternalModule3API;
import com.example2.EMRefValue;
import com.example2.ExternalModule2API;

public class ExternalModuleAdapter2 implements ExternalModule{
    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {
        ExternalModule3API em3 = new ExternalModule3API();
        return new ReferenceValue(em3.getMinReferenceValue(parameter.getCode(), 12345), em3.getMaxReferenceValue(parameter.getCode(),
                12345), em3.usedMetric(parameter.getCode(), 12345));
    }
}
