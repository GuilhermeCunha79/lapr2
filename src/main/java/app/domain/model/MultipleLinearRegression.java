package app.domain.model;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MultipleLinearRegression {

    private double[][] yData;
    private double[] x1Data;
    private double[] x2Data;

    private double[][] xMatrix;
    private double[][] xMatrixTrans;

    private double[][] xTransposedByX;
    private double[][] xTransposedByXInv;
    private double[] xTransposedByY;
    private double[] regressionModelMatrix;

    private double r2;
    private double r2adjusted;
    private double r;

    private String regressionModel;

    private List<LocalDate> lDates;

    private double ic;

    private double sqt;
    private double sqr;
    private double sqe;

    public MultipleLinearRegression(List<LocalDate> lDates, double[] yData, double[] x1Data, double[] x2Data, double ic) {
        if (yData.length == x2Data.length && x2Data.length == x1Data.length) {
            this.lDates = new ArrayList<>(lDates);
            this.yData = arrayToMatrixConverter(yData);
            this.x1Data = x1Data;
            this.x2Data = x2Data;
            this.ic = ic;
            this.xMatrix = matrixConcat(this.x1Data, this.x2Data);
            this.xMatrixTrans = transposeMatrix(xMatrix);
            calculateRegressionModel();
            createStringRegressionModel();
            r2 = calculateR2();
            r2adjusted = calculateR2adjusted();
            r = Math.sqrt(r2);
            calculateSqe();
        }else{
            throw new IllegalArgumentException("X1 count or X2 count is different than Y count");
        }
    }



    private double calculateR2adjusted() {
        return 1 - ((yData.length) - 1.0) / (yData.length - 3) * (1 - r2);
    }

    private double[][] arrayToMatrixConverter(double[] array) {
        double[][] result = new double[array.length][1];
        for (int i = 0; i < array.length; i++) {
            result[i][0] = array[i];
        }
        return result;
    }

    private String hypothesisTestTObs(int bn) {
        double t0 = t0Calculator(regressionModelMatrix[bn], getStdErrorB(bn, matrixMultiplierByNumber(xTransposedByXInv, sqe / ((yData.length) - 3))));
        if (Math.abs(t0) > tCalculator(ic, yData)[0])
            return String.format("For ^B%d the null hypothesis is rejected because %f > %f%n", bn, Math.abs(t0), tCalculator(ic, yData)[0]);
        return String.format("For ^B%d the null hypothesis is accepted because %f < %f%n", bn, Math.abs(t0), tCalculator(ic, yData)[0]);
    }

    private double getStdErrorB(int bn, double[][] matrix) {
        return Math.sqrt(matrix[bn][bn]);
    }

    private double t0Calculator(double bnValue, double stdErrorBnValue) {
        return bnValue / stdErrorBnValue;
    }

    private double[] tCalculator(double ic, double[][] yMatrix) {
        double alphaDivBy2 = (1 - ic) / 2;
        TDistribution td = new TDistribution(yMatrix.length - 3);
        double[] results = new double[2];
        results[0] = td.inverseCumulativeProbability(alphaDivBy2);
        results[1] = -td.inverseCumulativeProbability(alphaDivBy2);
        return results;
    }

    private String fHypothesis() {
        double f0 = (sqr / 2) / (sqe / ((yData.length) - 3));
        FDistribution fd = new FDistribution(2, yData.length - 3);
        double f = fd.inverseCumulativeProbability(1 - ic);
        if (f0 > f)
            return String.format("%.4f > f%.2f,(2,%d)=%.4f%nReject H0%nThe regression model is significant", f0, 1 - ic, ((yData.length) - 3), f);
        else
            return String.format("%.4f < f%.2f,(2,%d)=%.4f%nAccept H0%nThe regression model is not significant", f0, 1 - ic, ((yData.length) - 3), f);
    }

    private double[][] matrixMultiplierByNumber(double[][] matrix, double number) {
        double[][] result = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = matrix[i][j] * number;
            }
        }
        return result;
    }

    private double calculateR2() {
        return calculateSqr() / calculateSqt();
    }

    private double calculateSqt() {
        this.sqt = matrixMultiplier1NbyN1(transposeMatrixNby1(yData), yData) - yData.length * (averageYdata() * averageYdata());
        return sqt;
    }

    private double calculateSqr() {
        this.sqr = matrixMultiplier1NbyN1(transposeMatrixNby1(arrayToMatrixConverter(this.regressionModelMatrix)), arrayToMatrixConverter(xTransposedByY)) - yData.length * averageYdata() * averageYdata();
        return sqr;
    }

    private double calculateSqe() {
        this.sqe = sqt - sqr;
        return sqe;
    }

    private double averageYdata() {
        double sum = 0;
        for (int i = 0; i < yData.length; i++) {
            sum += yData[i][0];
        }
        if (sum != 0)
            return sum / yData.length;
        else
            return 0;
    }

    private void createStringRegressionModel() {
        this.regressionModel = String.format("^Y = %.4f + %.4fX1 + %.4fX2", regressionModelMatrix[0], regressionModelMatrix[1], regressionModelMatrix[2]);
    }

    private void calculateRegressionModel() {
        this.xTransposedByX = matricesMultiplier3NByN3(xMatrix, xMatrixTrans);
        this.xTransposedByXInv = invert(xTransposedByX);
        this.xTransposedByY = matricesMultiplier3NbyN1(this.yData, this.xMatrixTrans);
        this.regressionModelMatrix = matricesMultiplier3NbyN1(arrayToMatrixConverter(xTransposedByY), xTransposedByXInv);
    }

    private double[][] matricesMultiplier3NByN3(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < x2Data.length; k++) {
                    result[i][j] += matrix2[i][k] * matrix1[k][j];
                }

            }

        }
        return result;
    }

    private double matrixMultiplier1NbyN1(double[][] matrix1N, double[][] matrixN1) {
        double result = 0;
        for (int i = 0; i < matrixN1.length; i++) {
            result += matrix1N[0][i] * matrixN1[i][0];
        }
        return result;
    }

    private double[] matricesMultiplier3NbyN1(double[][] matrixN1, double[][] matrix3N) {
        double[] result = new double[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < matrixN1.length; j++) {
                result[i] += matrixN1[j][0] * matrix3N[i][j];
            }
        }
        return result;
    }

    private double[][] matrixConcat(double[] matrix1, double[] matrix2) {
        double[][] matrixResult = new double[matrix1.length][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                if (i == 0)
                    matrixResult[j][i] = 1;
                if (i == 1)
                    matrixResult[j][i] = matrix1[j];
                if (i == 2)
                    matrixResult[j][i] = matrix2[j];
            }
        }
        return matrixResult;
    }

    private double[][] transposeMatrix(double[][] originalMatrix) {
        double[][] transposedMatrix = new double[3][originalMatrix.length];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < originalMatrix.length; j++) {
                transposedMatrix[i][j] = originalMatrix[j][i];
            }
        }
        return transposedMatrix;
    }

    private double[][] transposeMatrixNby1(double[][] originalMatrix) {
        double[][] transposedMatrix = new double[1][originalMatrix.length];
        for (int i = 0; i < originalMatrix.length; i++) {
            transposedMatrix[0][i] = originalMatrix[i][0];

        }
        return transposedMatrix;
    }

    //Extracted from https://www.sanfoundry.com/java-program-find-inverse-matrix/
    private double[][] invert(double a[][])
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    private void gaussian(double a[][], int index[])
    {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i=0; i<n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            for (int j=0; j<n; ++j)
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    public String toString() {
        StringBuilder nhsReport = new StringBuilder();
        nhsReport.append("The regression model fitted using data from the interval\n");
        nhsReport.append(String.format("%s%n", this.regressionModel));
        nhsReport.append("//\nOther statistics\n");
        nhsReport.append(String.format("R2 = %f%n", r2));
        nhsReport.append(String.format("R2adjusted = %f%n", r2adjusted));
        nhsReport.append(String.format("R = %f%n//%n", r));
        nhsReport.append("Hypothesis tests for regression coefficients\nHO:b=0 (a=0) H1: b<>0 (a<>0)\n");
        nhsReport.append(String.format("%s", hypothesisTestTObs(0)));
        nhsReport.append(String.format("%s", hypothesisTestTObs(1)));
        nhsReport.append(String.format("%s", hypothesisTestTObs(2)));
        nhsReport.append("//");
        nhsReport.append("\nSignificance model with anova");
        nhsReport.append("\nH0: b=0  H1:b<>0 ");
        nhsReport.append(String.format("%n%15s%10s%20s%20s", "df", "SS", "MS", "F"));
        nhsReport.append(String.format("%nRegression%4d%18.4f%19.4f%20.4f", 2, sqr, sqr / 2, (sqr / 2) / (sqe / ((yData.length) - 3))));
        nhsReport.append(String.format("%nResidual%6d%18.4f%19.4f", yData.length - 3, sqe, sqe / ((yData.length) - 3)));
        nhsReport.append(String.format("%nTotal%9d%18.4f", yData.length - 1, sqt));
        nhsReport.append("\n\nDecision: f");
        nhsReport.append(String.format("%n%s", fHypothesis()));
        nhsReport.append("\n\n// Prediction Values\n");
        nhsReport.append(String.format("Date           Number of OBSERVED positive cases          Number of ESTIMATED positive cases \t\t%.0f%% intervals%n", ic*100));
        nhsReport.append(predictionTable());
        return nhsReport.toString();
    }

    private String predictionTable() {
        StringBuilder table = new StringBuilder();
        for (int i = 0; i < yData.length; i++) {
            table.append(String.format("%s%20.0f %45.2f %35s%n", getDate(i), yData[i][0], doPrevision(i), getConfidenceInterval(i)));
        }
        return table.toString();
    }

    private double[][] convertArray1DToMatrix(double[] array){
        double[][] result = new double[1][array.length];
        for (int i = 0; i < array.length; i++) {
            result[0][i] = array[i];
        }
        return result;
    }

    private String getConfidenceInterval(int i) {
        double[] xt0 = {1, x1Data[i], x2Data[i]};
        double y0 = matrixMultiplier1NbyN1(convertArray1DToMatrix(xt0), arrayToMatrixConverter(regressionModelMatrix));
        double t = tCalculator(ic, yData)[1];
        double o2 = sqe / ((yData.length) - 3);
        double sqrtContent = o2 * (1+ matrixMultiplier1NbyN1(convertArray1DToMatrix(xt0), arrayToMatrixConverter(matricesMultiplier3NbyN1(arrayToMatrixConverter(xt0), xTransposedByXInv))));
        double x = y0 - t * Math.sqrt(sqrtContent);
        double y = y0 + t * Math.sqrt(sqrtContent);
        return String.format("%.2f-%.2f", x, y);
    }



    private double doPrevision(int i) {
        double[] xt0 = {1, x1Data[i], x2Data[i]};
        return regressionModelMatrix[0] + regressionModelMatrix[1] * xt0[1] + regressionModelMatrix[2] * xt0[2];
    }

    private String getDate(int i) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return lDates.get(i).format(formatter);
    }
}
