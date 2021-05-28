package app.domain.model;

public class ReferenceValue {

    private double minValue;
    private double maxValue;
    private String metric;

    public ReferenceValue(double minValue, double maxValue, String metric) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.metric = metric;
    }

    @Override
    public String toString() {
        return String.format("Reference Values -> min. value: %f %s | max. value: %f %s", minValue, metric, maxValue, metric);
    }
}
