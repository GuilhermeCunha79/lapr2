package app.domain.model;

import   app.domain.shared.DateTime;
import org.apache.commons.lang3.NotImplementedException;

public class TestParameterResult {

    private DateTime createdAt;
    private double value;
    private String metric;
    private ReferenceValue refValue;

    public TestParameterResult(double value, String metric, ReferenceValue refValue) {
        this.value=value;
        this.metric = metric;
        this.refValue = refValue;
    }


    @Override
    public String toString() {
        return String.format("Results -> value: %f %s | %s", value, metric, refValue.toString());
    }
}
