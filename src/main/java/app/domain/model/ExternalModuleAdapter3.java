package app.domain.model;

import com.example2.EMRefValue;
import com.example2.ExternalModule2API;
import com.example3.CovidReferenceValues1API;

public class ExternalModuleAdapter3 implements ExternalModule{
    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {
        CovidReferenceValues1API em3 = new CovidReferenceValues1API();
        return new ReferenceValue(em3.getMinReferenceValue(parameter.getCode(), 12345),
                em3.getMaxReferenceValue(parameter.getCode(), 12345), em3.usedMetric(parameter.getCode(), 12345));
        }
}
