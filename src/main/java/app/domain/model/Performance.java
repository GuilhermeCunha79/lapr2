package app.domain.model;//This file is an example on how to use the benchmark
//algorithm that finds the contiguous subsequence with maximum sum


import app.domain.shared.DateTime;
import app.domain.store.TestStore;
import com.isep.mdis.Sum;
import javafx.scene.canvas.GraphicsContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Performance {
    private GraphicsContext statistic;

    private List<ClinicalTest> bestPerformance;
    private List<ClinicalTest> possibleBestPerformance;
    private final List<ClinicalTest> intervalTime = new ArrayList<>();

    private int bestSum = 0;

    public Performance(DateTime inicialDate, DateTime endDate) {
        this.statistic = bruteForceAlgorithm(inicialDate, endDate);
    }

    public Performance() {
    }


    public String subsequenceMaxSum() {
        var example = new int[]{29, -32, -9, -25, 44, 12, -61, 51, -9, 44, 74, 4};
        int[] result = Sum.Max(example);
        return Arrays.toString(result); // should print [51, -9, 44, 74, 4]
    }

    public GraphicsContext getStatistic() {
        return statistic;
    }

    public List<List<ClinicalTest>> intervalTime(List<ClinicalTest> clinicalTests, DateTime initialDate, DateTime endDate) {

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withLocale(Locale.FRENCH);
        String inicialTime = initialDate.getDate() + " " + initialDate.getTime();
        String endTime = endDate.getDate() + " " + endDate.getTime();

        LocalDateTime initialDateTime;
        var endDateTime = LocalDateTime.parse(endTime, formatter);

        LocalDateTime backupInitialDateTime;
        var backupEndDateTime = LocalDateTime.parse(endTime, formatter);


        LocalDateTime actualHour;

        List<List<ClinicalTest>> intervalTimeChosen = new ArrayList<>();

        Collections.sort(clinicalTests);

        for (initialDateTime = LocalDateTime.parse(inicialTime, formatter);
             initialDateTime.isBefore(endDateTime);
             initialDateTime = initialDateTime.plusDays(1)) {

            for (backupInitialDateTime = LocalDateTime.parse(inicialTime, formatter);
                 backupInitialDateTime.isBefore(backupEndDateTime);
                 backupInitialDateTime = backupInitialDateTime.plusMinutes(30)) {

                var begin = initialDate.getDate() + " " + "08:00";
                var end = endDate.getDate() + " " + "20:00";
                var beginLocalDate = LocalDateTime.parse(begin, formatter);
                var endLocalDate = LocalDateTime.parse(end, formatter);
                actualHour = LocalDateTime.parse(begin,formatter);

                if (backupInitialDateTime != initialDateTime && backupInitialDateTime != endLocalDate) {
                    while (actualHour.isAfter(beginLocalDate) && actualHour.isBefore(endLocalDate)) {
                        for (ClinicalTest test : clinicalTests) {
                            var actualTest = test.getValidationDate().getDate() + " " + test.getValidationDate().getTime();
                            var testDate = LocalDateTime.parse(actualTest, formatter);
                            if (backupInitialDateTime.isBefore(testDate) && endLocalDate.isAfter(testDate)){
                                intervalTime.add(test);
                            }
                        }
                        actualHour = actualHour.plusMinutes(30);
                    }
                }
                intervalTimeChosen.add(intervalTime);
            }
        }
        return intervalTimeChosen;
    }


    public GraphicsContext bruteForceAlgorithm(DateTime inicialDate, DateTime endDate) {
        TestStore tStore = new TestStore();

        List<ClinicalTest> clinicalTests = tStore.getTestList();

        List<List<ClinicalTest>> sortedClinicalTests= intervalTime(clinicalTests, inicialDate, endDate);

        for(List<ClinicalTest> list : sortedClinicalTests) {
            int possibleSum = 0;
            possibleBestPerformance.clear();

            for (ClinicalTest test : list){

                if(test.getValidationStatus()){
                    possibleBestPerformance.add(test);
                    possibleSum++;
                }

                if(bestSum < possibleSum){
                    bestSum = possibleSum;
                    bestPerformance = possibleBestPerformance;
                }
            }
        }
        return statistic;
    }
}
