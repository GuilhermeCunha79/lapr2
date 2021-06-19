package app.domain.model;

import java.io.Serializable;

public class TestParameterResult implements Serializable {

    private final double value;
    private final String metric;
    private final ReferenceValue refValue;

    /**
     * Constructor of this class
     * @param value of the test
     * @param metric used
     * @param refValue for the parameter tested
     */
    public TestParameterResult(double value, String metric, ReferenceValue refValue) {
        this.value=value;
        this.metric = metric;
        this.refValue = refValue;
    }

    /**
     * To string method
     * @return return important data about the result of the parameter tested
     */
    @Override
    public String toString() {
        return String.format("Results -> value: %f %s | %s", value, metric, refValue.toString());
    }
}
