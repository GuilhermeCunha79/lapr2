package app.domain.model;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimpleLinearRegressionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testRegressionModelWithDifferentArraySizes(){
        List<LocalDate> lDates = new ArrayList<>();
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        double[] yData = {23, 32, 43, 23, 25, 27};
        double[] xData = {50, 53, 43, 34, 55};
        new SimpleLinearRegression(lDates, xData, yData, 0.95);
    }

    @Test
    public void testGetR2Method(){
        List<LocalDate> lDates = new ArrayList<>();
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        double[] yData = {23, 32, 43, 23, 25};
        double[] xData = {50, 53, 43, 34, 55};
        SimpleLinearRegression slr = new SimpleLinearRegression(lDates, xData, yData, 0.95);
        double expected = 0.001162;
        assertEquals(expected, slr.getR2(), 0.001);
    }

    @Test
    public void testReport(){
        List<LocalDate> lDates = new ArrayList<>();
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        double[] yData = {23, 32, 43, 23, 25};
        double[] xData = {50, 53, 43, 34, 55};
        SimpleLinearRegression slr = new SimpleLinearRegression(lDates, xData, yData, 0.95);
        StringBuilder expected = new StringBuilder();
        expected.append("The regression model fitted using data from the interval\n");
        expected.append(String.format("^y=30.798639-0.034014x%n"));
        expected.append("//\nOther statistics\n");
        expected.append(String.format("R2 = 0.001162%n"));
        expected.append(String.format("R2adjusted = -0.331784%n"));
        expected.append(String.format("R = 0.034083%n//%n"));
        expected.append("\nHypothesis tests for regression coefficients\nHO:b=0 (a=0) H1: b<>0 (a<>0)");
        expected.append(String.format("\nt_obs = %.2f\nDecision:\nThe null hypothesis is rejected because 1.101271 > -0.068088%n", 1.10));
        expected.append("\n//");
        expected.append("\nSignificance model with anova");
        expected.append("\nH0: b=0  H1:b<>0 ");
        expected.append(String.format("%n%15s%10s%20s%20s", "df", "SS", "MS", "F"));
        expected.append(String.format("%nRegression%4d%18.4f%19.4f%20.4f", 1, 0.3401, 0.3401, 0.0012));
        expected.append(String.format("%nResidual%6d%18.4f%19.4f", 3, 292.4599, 97.4866));
        expected.append(String.format("%nTotal%9d%18.4f", 4, 292.8000));
        expected.append("\n\nDecision: f\n");
        expected.append(String.format("0.0012 < f0.05,(1,3)=0.0522%nAccept H0%nThe regression model is not significant"));
        expected.append("\n\n// Prediction Values\n");
        expected.append(String.format("Date           Number of OBSERVED positive cases          Number of ESTIMATED positive cases \t\t%.0f%% intervals\n", 95.0));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 23.0, 29.10, "28.21-29.99"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 32.0, 29.00, "28.08-29.92"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 43.0, 29.34, "28.44-30.23"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 23.0, 29.64, "28.58-30.71"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 25.0, 28.93, "27.97-29.88"));

        assertEquals(expected.toString(), slr.toString());
    }
}
