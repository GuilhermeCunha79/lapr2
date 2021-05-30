package app.domain.model;

public class ReferenceValue {

    private double minValue;
    private double maxValue;
    private String metric;

    /**
     * Reference value constructor, receives a minimum value, a maximum value and the metric
     * @param minValue
     * @param maxValue
     * @param metric
     */
    public ReferenceValue(double minValue, double maxValue, String metric) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.metric = metric;
    }

    /**
     * This method returns a string with all the data of this reference value
     * @return a string
     */
    @Override
    public String toString() {
        return String.format("Reference Values -> min. value: %f %s | max. value: %f %s", minValue, metric, maxValue, metric);
    }
}
