package app.domain.model;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MultipleLinearRegressionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testRegressionModelWithDifferentArraySizes(){
        List<LocalDate> lDates = new ArrayList<>();
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        double[] yData = {23, 32, 43, 23, 25, 27};
        double[] x1Data = {50, 53, 43, 34, 55};
        double[] x2Data = {50, 53, 43, 34, 55};
        new MultipleLinearRegression(lDates, yData, x1Data, x2Data, 0.95);
    }

    @Test
    public void testReport(){
        List<LocalDate> lDates = new ArrayList<>();
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        lDates.add(LocalDate.now());
        double[] yData = {23, 32, 43, 23, 25, 43};
        double[] x1Data = {50, 53, 43, 34, 55, 32};
        double[] x2Data = {60, 73, 93, 24, 35, 30};
        MultipleLinearRegression mlr = new MultipleLinearRegression(lDates, yData, x1Data, x2Data, 0.95);
        StringBuilder expected = new StringBuilder();
        expected.append("The regression model fitted using data from the interval\n");
        expected.append(String.format("^Y = 48.0129 + -0.6437X1 + 0.2311X2%n"));
        expected.append("//\nOther statistics\n");
        expected.append(String.format("R2 = 0.520909%n"));
        expected.append(String.format("R2adjusted = 0.201514%n"));
        expected.append(String.format("R = 0.721740%n//%n"));
        expected.append("Hypothesis tests for regression coefficients\nHO:b=0 (a=0) H1: b<>0 (a<>0)\n");
        expected.append(String.format("For ^B%d the null hypothesis is rejected because %f > %f%n", 0, 2.733091, -3.182446));
        expected.append(String.format("For ^B%d the null hypothesis is rejected because %f > %f%n", 1, 1.516444, -3.182446));
        expected.append(String.format("For ^B%d the null hypothesis is rejected because %f > %f%n", 2, 1.517402, -3.182446));
        expected.append("//");
        expected.append("\nSignificance model with anova");
        expected.append("\nH0: b=0  H1:b<>0 ");
        expected.append(String.format("%n%15s%10s%20s%20s", "df", "SS", "MS", "F"));
        expected.append(String.format("%nRegression%4d%18.4f%19.4f%20.4f", 2, 235.1902, 117.5951, 1.6309));
        expected.append(String.format("%nResidual%6d%18.4f%19.4f", 3, 216.3098, 72.1033));
        expected.append(String.format("%nTotal%9d%18.4f", 5, 451.5000));
        expected.append("\n\nDecision: f");
        expected.append(String.format("%n1.6309 > f0.05,(2,3)=0.0522%nReject H0%nThe regression model is significant"));
        expected.append("\n\n// Prediction Values\n");
        expected.append(String.format("Date           Number of OBSERVED positive cases          Number of ESTIMATED positive cases \t\t%.0f%% intervals%n", 95.0));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 23.0, 29.69, "-0.28-59.66"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 32.0, 30.77, "-0.68-62.21"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 43.0, 41.82, "6.13-77.52"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 23.0, 31.67, "-1.23-64.58"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 25.0, 20.70, "-14.29-55.68"));
        expected.append(String.format("%s%20.0f %45.2f %35s%n", "20/06/2021", 43.0, 34.35, "1.11-67.58"));

        assertEquals(expected.toString(), mlr.toString());
    }
}
