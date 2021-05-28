package app.domain.model;

import com.example2.EMRefValue;
import com.example2.ExternalModule2API;

public class ExternalModuleAdapter1 implements ExternalModule{
    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {
        ExternalModule2API em2 = new ExternalModule2API();
        EMRefValue refValue = em2.getReferenceFor(parameter.getCode());
        return new ReferenceValue(refValue.getMinValue(), refValue.getMaxValue(), refValue.getMetric());
    }
}
