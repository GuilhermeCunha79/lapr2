package app.domain.model;//This file is an example on how to use the benchmark
//algorithm that finds the contiguous subsequence with maximum sum


import app.domain.shared.DateTime;
import com.isep.mdis.Sum;
import javafx.scene.canvas.GraphicsContext;

import java.util.*;

public class Performance {
    private GraphicsContext statistic;

    private List<ClinicalTest> bestPerformance = new ArrayList<>();
    private final List<ClinicalTest> intervalTime = new ArrayList<>();
    private final List<ClinicalTest> possibleBestPerformance = new ArrayList<>();

    private int bestSum = 0;
    private int possibleSum = 0;

    public Performance() {

    }


    public static void main(String[] args) {
        int[] example = new int[]{29, -32, -9, -25, 44, 12, -61, 51, -9, 44, 74, 4};
        int[] result = Sum.Max(example);
        System.out.println(Arrays.toString(result)); // should print [51, -9, 44, 74, 4]

    }

    public GraphicsContext getStatistic() {
        return statistic;
    }

    public List<List<ClinicalTest>> intervalTime(List<ClinicalTest> clinicalTests, DateTime initialDate, DateTime endDate) {
        Date initialIntervalDate;
        Date backupInitialIntervalDate = new Date(initialDate.getDate());
        Date endIntervalDate = new Date(initialDate.getDate());
        Date initialIntervalTime = new Date(initialDate.getTime());
        Date endIntervalTime = new Date(initialDate.getTime());
        Date initialWorkingDay = new Date("08:00");
        Date endWorkingDay = new Date("20:00");
        Date actualHour;
        List<List<ClinicalTest>> intervalTimeChosen = new ArrayList<>();

        Collections.sort(clinicalTests);

        for (initialIntervalDate = new Date(initialDate.getDate());
             initialIntervalDate.before(endIntervalDate);
             initialIntervalDate.setDate(initialIntervalDate.getDay() + 1)) {
            for (initialIntervalTime = new Date(initialIntervalTime.getTime());
                 initialIntervalTime.before(endWorkingDay);
                 initialIntervalTime.setTime(initialIntervalTime.getMinutes() + 30)) {

                actualHour = new Date("08:00");
                if (backupInitialIntervalDate != initialIntervalDate && initialIntervalDate != endIntervalDate) {
                    while (actualHour.after(initialWorkingDay) && actualHour.before(endWorkingDay)) {
                        for (ClinicalTest test : clinicalTests) {
                            Date testDate = new Date(test.getValidationDate().toString());
                            if (initialIntervalTime.before(testDate) && endWorkingDay.after(testDate)){
                                intervalTime.add(test);
                            }
                        }
                        actualHour.setTime(actualHour.getMinutes() + 30);

                    }
                }
                intervalTimeChosen.add(intervalTime);
            }
        }
        return intervalTimeChosen;
    }


    public GraphicsContext bruteForceAlgorithm(List<ClinicalTest> clinicalTests, DateTime inicialDate, DateTime endDate) {

        List<List<ClinicalTest>> sortedClinicalTests= intervalTime(clinicalTests, inicialDate, endDate);

        for(List<ClinicalTest> list : sortedClinicalTests) {
            possibleSum = 0;
            possibleBestPerformance.clear();

            for (ClinicalTest test : list){

                if(test.getValidationStatus()){
                    possibleBestPerformance.add(test);
                    possibleSum++;
                }

                if(bestSum<possibleSum){
                    bestSum = possibleSum;
                    bestPerformance = possibleBestPerformance;
                }
            }
        }
        return statistic;
    }
}
