package app.domain.model;//This file is an example on how to use the benchmark
//algorithm that finds the contiguous subsequence with maximum sum


import app.domain.shared.DateTime;
import com.isep.mdis.Sum;
import javafx.scene.canvas.GraphicsContext;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Performance {
    private GraphicsContext statistic;

    private List<ClinicalTest> bestPerformance = new ArrayList<>();
    private List<ClinicalTest> intervalTime = new ArrayList<>();
    private List<ClinicalTest> possibleBestPerformance = new ArrayList<>();

    private int bestSum = 0;
    private int possibleSum = 0;

    public Performance(){

    }

    public GraphicsContext getStatistic() {
        return statistic;
    }

    public static void main(String[] args) {
        int[] example = new int[]{29, -32, -9, -25, 44, 12, -61, 51, -9, 44, 74, 4};
        int[] result = Sum.Max(example);
        System.out.println(Arrays.toString(result)); // should print [51, -9, 44, 74, 4]

    }

    public GraphicsContext bruteForceAlgorithm(List<ClinicalTest> clinicalTests, DateTime inicialDate, DateTime endDate){
        for(ClinicalTest test : clinicalTests){
            if(inicialDate.getDate().compareTo(test.getValidationDate().getDate())<=0
                    && inicialDate.getTime().compareTo(test.getValidationDate().getTime())<=0
                    && test.getValidationDate().getDate().compareTo(endDate.getDate())<=0
                    && test.getValidationDate().getTime().compareTo(endDate.getTime())<=0){
                intervalTime.add(test);
            }
        }
        for (int i=0;i<=intervalTime.size()-3;i++){
            for (int j=i+1;j<=intervalTime.size()-2;){
                for (int k=i+2;k<=intervalTime.size()-1;){
                   for (int l=i+3;l<=intervalTime.size();){
                       possibleBestPerformance.clear();
                       possibleSum = 0;

                       if(bestPerformance.isEmpty()){
                           bestPerformance.add(clinicalTests.get(i));
                           bestPerformance.add(clinicalTests.get(j));
                           bestPerformance.add(clinicalTests.get(k));
                           bestPerformance.add(clinicalTests.get(l));

                           if (clinicalTests.get(i).getValidationStatus()){
                               bestSum++;
                           }

                           if (clinicalTests.get(j).getValidationStatus()){
                               bestSum++;
                           }

                           if (clinicalTests.get(k).getValidationStatus()){
                               bestSum++;
                           }

                           if (clinicalTests.get(l).getValidationStatus()){
                               bestSum++;
                           }
                       }
                       possibleBestPerformance.add(clinicalTests.get(i));
                       possibleBestPerformance.add(clinicalTests.get(j));
                       possibleBestPerformance.add(clinicalTests.get(k));
                       possibleBestPerformance.add(clinicalTests.get(l));

                       if (clinicalTests.get(i).getValidationStatus()){
                           possibleSum++;
                       }

                       if (clinicalTests.get(j).getValidationStatus()){
                           possibleSum++;
                       }

                       if (clinicalTests.get(k).getValidationStatus()){
                           possibleSum++;
                       }

                       if (clinicalTests.get(l).getValidationStatus()){
                           possibleSum++;
                       }

                       if(bestSum<possibleSum){
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
