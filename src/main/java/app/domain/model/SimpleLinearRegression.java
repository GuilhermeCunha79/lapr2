package app.domain.model;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SimpleLinearRegression {

    private double meanY;
    private double meanX;

    private double[] valuesY;
    private double[] valuesX;

    private double sxx;
    private double syy;
    private double sxy;

    private double r2;
    private double r2adjusted;


    private double aValue;
    private double bValue;

    private double ic;

    private String regressionLineEquation;

    private double s2;

    private List<LocalDate> lDates;

    public SimpleLinearRegression(List<LocalDate> lDates, double[] valuesX, double[] valuesY, double ic) {
        if (valuesX.length == valuesY.length) {
            this.lDates = lDates;
            this.ic = ic;
            this.valuesX = valuesX;
            this.valuesY = valuesY;
            meanX = calculateMean(valuesX);
            meanY = calculateMean(valuesY);
            sxx = calculateS(valuesX, meanX);
            syy = calculateS(valuesY, meanY);
            sxy = calculateSxy(valuesX, valuesY);
            bValue = calculateBValue();
            aValue = calculateAValue();
            regressionLineEquation = createEquation(aValue, bValue);
            r2 = calculateR2();
            r2adjusted = calculateR2Adjusted();
        } else {
            throw new IllegalArgumentException("X count is different than Y count");
        }
    }

    public double getR2() {
        return r2;
    }

    private double calculateR2Adjusted() {
        return 1 - (((valuesY.length - 1.0) * (1 - r2)) / (valuesY.length - 2));
    }

    private double calculateR2() {
        return (sxy * sxy) / (sxx * syy);
    }

    private String createEquation(double aValue, double bValue) {
        if (bValue > 0)
            return String.format("^y=%f+%fx", aValue, bValue);
        if (bValue < 0)
            return String.format("^y=%f%fx", aValue, bValue);
        return String.format("^y=%f", aValue);
    }

    private double calculateBValue() {
        return sxy / sxx;
    }

    private double calculateAValue() {
        return meanY - bValue * meanX;
    }

    private double calculateSxy(double[] valuesX, double[] valuesY) {
        double sxy = 0;
        for (int i = 0; i < valuesX.length; i++) {
            sxy += (valuesX[i] - meanX) * (valuesY[i] - meanY);
        }
        return sxy;
    }

    private double calculateS(double[] values, double mean) {
        double s = 0;
        for (double x : values) {
            s += Math.pow(x - mean, 2);
        }
        return s;
    }

    private double calculateMean(double[] values) {
        double sum = 0;
        for (double x : values) {
            sum += x;
        }
        if (values.length != 0) {
            return sum / values.length;
        }
        return 0;
    }

    public void s2Calculator() {
        double sum = 0;
        for (int i = 0; i < valuesY.length; i++) {
            sum += Math.pow(valuesY[i] - (aValue + bValue * i), 2);
        }
        if (valuesY.length - 2 != 0)
            this.s2 = sum / (valuesY.length - 2);
        else
            this.s2 = 0;
    }

    private String tHypothesis() {
        s2Calculator();
        double tObs = aValue / (Math.sqrt(s2) * Math.sqrt((1.0 / valuesY.length + Math.pow(meanX, 2) / sxx)));
        double t = tCalculator(ic, valuesY);
        if (Math.abs(tObs) > t)
            return String.format("\nt_obs = %.2f\nDecision:\nThe null hypothesis is rejected because %f > %f%n", tObs, Math.abs(tObs), t);
        return String.format("The null hypothesis is accepted because %f < %f%n", Math.abs(tObs), t);
    }

    private double tCalculator(double ic, double[] yMatrix) {
        double alphaDivBy2 = ic / 2;
        TDistribution td = new TDistribution(yMatrix.length - 2);
        return td.inverseCumulativeProbability(alphaDivBy2);
    }

    private String fHypothesis() {
        double f0 = calculateSR() / (calculateST() - calculateSR());
        FDistribution fd = new FDistribution(2, valuesY.length - 2);
        double f = fd.inverseCumulativeProbability(1 - ic);
        if (f0 > f)
            return String.format("%.4f > f%.2f,(1,%d)=%.4f%nReject H0%nThe regression model is significant", f0, 1 - ic, ((valuesY.length) - 2), f);
        else
            return String.format("%.4f < f%.2f,(1,%d)=%.4f%nAccept H0%nThe regression model is not significant", f0, 1 - ic, ((valuesY.length) - 2), f);
    }

    private String predictionTable() {
        StringBuilder table = new StringBuilder();
        for (int i = 0; i < valuesY.length; i++) {
            double prevision = doPrevision(i);
            table.append(String.format("%s%20.0f %45.2f %35s%n", getDate(i), valuesY[i], prevision, getConfidenceInterval(i, prevision)));
        }
        return table.toString();
    }

    private String getConfidenceInterval(int i, double prevision) {
        TDistribution t = new TDistribution(ic);
        double tc = -t.inverseCumulativeProbability(ic / 2);
        double s = Math.sqrt(this.s2);
        double sqrtContent = 1 + (1.0 / valuesY.length) + (Math.pow(valuesX[i] - meanX, 2) / sxx);
        return String.format("%.2f-%.2f", prevision - tc * s * Math.sqrt(sqrtContent), prevision + tc * s * Math.sqrt(sqrtContent));
    }

    private String getDate(int i) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return lDates.get(i).format(formatter);
    }

    private double doPrevision(int i) {
        return aValue + bValue * valuesX[i];
    }

    private double calculateST() {
        double sr = 0;
        for (int i = 0; i < valuesY.length; i++) {
            sr += Math.pow((valuesY[i] - meanY), 2);
        }
        return sr;
    }

    private double calculateSR() {
        double sr = 0;
        for (int i = 0; i < valuesX.length; i++) {
            sr += Math.pow((bValue * valuesX[i] + aValue - meanY), 2);
        }
        return sr;
    }

    @Override
    public String toString() {
        StringBuilder nhsReport = new StringBuilder();
        nhsReport.append("The regression model fitted using data from the interval\n");
        nhsReport.append(String.format("%s%n", this.regressionLineEquation));
        nhsReport.append("//\nOther statistics\n");
        nhsReport.append(String.format("R2 = %f%n", r2));
        nhsReport.append(String.format("R2adjusted = %f%n", r2adjusted));
        nhsReport.append(String.format("R = %f%n//%n", Math.sqrt(r2)));
        nhsReport.append("\nHypothesis tests for regression coefficients\nHO:b=0 (a=0) H1: b<>0 (a<>0)");
        nhsReport.append(tHypothesis());
        nhsReport.append("\n//");
        nhsReport.append("\nSignificance model with anova");
        nhsReport.append("\nH0: b=0  H1:b<>0 ");
        nhsReport.append(String.format("%n%15s%10s%20s%20s", "df", "SS", "MS", "F"));
        nhsReport.append(String.format("%nRegression%4d%18.4f%19.4f%20.4f", 1, calculateSR(), calculateSR(), calculateSR() / (calculateST() - calculateSR())));
        nhsReport.append(String.format("%nResidual%6d%18.4f%19.4f", valuesY.length - 2, calculateST() - calculateSR(), (calculateST() - calculateSR()) / (valuesY.length - 2)));
        nhsReport.append(String.format("%nTotal%9d%18.4f", valuesY.length - 1, calculateST()));
        nhsReport.append("\n\nDecision: f\n");
        nhsReport.append(fHypothesis());
        nhsReport.append("\n\n// Prediction Values\n");
        nhsReport.append(String.format("Date           Number of OBSERVED positive cases          Number of ESTIMATED positive cases \t\t%.0f%% intervals\n", ic * 100));
        nhsReport.append(predictionTable());
        return nhsReport.toString();
    }
}
