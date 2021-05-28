package app.domain.model;

public class TestParameter {

    private Parameter parameter;
    private TestParameterResult testParameterResult;

    public void addTestResult(double value, String metric, ReferenceValue refValue){
        this.testParameterResult = new TestParameterResult(value, metric, refValue);
    }

    public Parameter getParameter(){
        return this.parameter;
    }

    @Override
    public String toString() {
        return String.format("- Parameter tested: %s | %s \n", parameter, testParameterResult);
    }
}
