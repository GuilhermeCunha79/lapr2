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
        Date initialIntervalDate = new Date(initialDate.getDate());
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
            for (initialIntervalTime = new Date(initialDate.getTime());
                 initialIntervalTime.before(endWorkingDay);
                 initialIntervalTime.setTime(initialIntervalDate.getMinutes() + 30)) {

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

        intervalTime(clinicalTests, inicialDate, endDate);

        for (int i = 0; i <= intervalTime.size() - 3; i++) {
            for (int j = i + 1; j <= intervalTime.size() - 2; ) {
                for (int k = i + 2; k <= intervalTime.size() - 1; ) {
                    for (int l = i + 3; l <= intervalTime.size(); ) {
                        possibleBestPerformance.clear();
                        possibleSum = 0;

                        if (bestPerformance.isEmpty()) {
                            bestPerformance.add(clinicalTests.get(i));
                            bestPerformance.add(clinicalTests.get(j));
                            bestPerformance.add(clinicalTests.get(k));
                            bestPerformance.add(clinicalTests.get(l));

                            if (clinicalTests.get(i).getValidationStatus()) {
                                bestSum++;
                            }

                            if (clinicalTests.get(j).getValidationStatus()) {
                                bestSum++;
                            }

                            if (clinicalTests.get(k).getValidationStatus()) {
                                bestSum++;
                            }

                            if (clinicalTests.get(l).getValidationStatus()) {
                                bestSum++;
                            }
                        }
                        possibleBestPerformance.add(clinicalTests.get(i));
                        possibleBestPerformance.add(clinicalTests.get(j));
                        possibleBestPerformance.add(clinicalTests.get(k));
                        possibleBestPerformance.add(clinicalTests.get(l));

                        if (clinicalTests.get(i).getValidationStatus()) {
                            possibleSum++;
                        }

                        if (clinicalTests.get(j).getValidationStatus()) {
                            possibleSum++;
                        }

                        if (clinicalTests.get(k).getValidationStatus()) {
                            possibleSum++;
                        }

                        if (clinicalTests.get(l).getValidationStatus()) {
                            possibleSum++;
                        }

                        if (bestSum < possibleSum) {
                            bestPerformance = possibleBestPerformance;
                            bestSum = possibleSum;
                        }

                    }
                }
            }
        }
        return statistic;
    }
}
