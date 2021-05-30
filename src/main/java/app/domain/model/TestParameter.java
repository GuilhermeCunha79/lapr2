package app.domain.model;

public class TestParameter {

    private Parameter parameter;
    private TestParameterResult testParameterResult;

    /**
     * Constructor of this class
     * @param parameter receives the parameter to be tested
     */
    public TestParameter (Parameter parameter) {
        this.parameter = parameter;
    }

    /**
     * This method is responsible for adding a test result
     * @param value of the result
     * @param metric of the result
     * @param refValue reference values for the parameter tested
     */
    public void addTestResult(double value, String metric, ReferenceValue refValue){
        this.testParameterResult = new TestParameterResult(value, metric, refValue);
    }

    /**
     * Get method for the parameter of this test
     * @return the parameter
     */
    public Parameter getParameter(){
        return this.parameter;
    }

    /**
     * Get method for the result of the parameter tested
     * @return the result
     */
    public TestParameterResult getTestParameterResult(){
        return this.testParameterResult;
    }

    /**
     * To string method
     * @return a string
     */
    @Override
    public String toString() {
        return String.format("- Parameter tested: %s | %s %n", parameter, testParameterResult);
    }
}
