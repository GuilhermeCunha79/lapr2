package app.domain.model;

import   app.domain.shared.DateTime;
import org.apache.commons.lang3.NotImplementedException;

public class TestParameterResult {

    private DateTime createdAt;
    private String value;
    private String metric;
    private Parameter testParameter;
    private String parameterResult;

    public TestParameterResult(Parameter parameter, String result) {
        setParameter(parameter);
        setResult(result);
    }

    public void setParameter(Parameter parameter){
        this.testParameter = parameter;
    }

    public void setResult(String result){
        this.parameterResult = result;
    }

    @Override
    public String toString() {
        return String.format("Test Parameter of %s has the following result :", testParameter, parameterResult);
    }
}
