package app.domain.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
public class SimpleRegressionModel {

    private int numberOfDays;
    private final List<Date> datesList;
    private List <Float>independentVariables ;
    private List<Float> testWhitPositiveCases;
    private final List<Float> predictedValuesList;
    private final List <String> trustIntervalsList;


    public SimpleRegressionModel(List<Date> datesList, List<Float> testWhitPositiveCasesList , List <Float>independentVariables, List<Float> predictedValuesList, List <String> trustIntervalsList, int numberOfDays) {
        this.datesList = datesList;
        this.testWhitPositiveCases = testWhitPositiveCasesList;
        this.predictedValuesList=setPredictedValuesList(testWhitPositiveCases,independentVariables,predictedValuesList,numberOfDays);
        this.trustIntervalsList=setTrustIntervalsList(testWhitPositiveCases,this.predictedValuesList,trustIntervalsList);
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public List<Date> getDatesList() {
        return datesList;
    }

    public List<Float> getIndependentVariables() {
        return independentVariables;
    }

    public List<Float> getTestWhitPositiveCases() {
        return testWhitPositiveCases;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setIndependentVariables(List<Float> independentVariables) {
        this.independentVariables = independentVariables;
    }

    public void setTestWhitPositiveCases(List<Float> testWhitPositiveCases) {
        this.testWhitPositiveCases = testWhitPositiveCases;
    }

    @Override
    public String toString() {
        String[] columns= new String[] { "Date ", " Number of OBSERVED positive cases " ," Number of ESTIMATED positive cases "," 95% intervals ",};
        String[][] table = tableCreation(columns);
        return Arrays.deepToString(table);
    }

    private String[][] tableCreation(String[] columns) {
        String[][] table = new String[datesList.size()+1][columns.length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (i==0){
                    table[i][0]=columns[0];
                    table[i][1]=columns[1];
                    table[i][2]=columns[2];
                    table[i][3]=columns[3];
                }else{
                    String date= String.valueOf(datesList.get(i-1));
                    String opc= String.valueOf(testWhitPositiveCases.get(i-1));
                    String epc= String.valueOf(predictedValuesList.get(i-1));
                    String ti= String.valueOf(trustIntervalsList.get(i-1));
                    table[i][0]=date;
                    table[i][1]=opc;
                    table[i][2]=epc;
                    table[i][3]=ti;
                }
            }
        }
        return table;
    }

    public List<String> getTrustIntervalsList() {
        return trustIntervalsList;
    }

    public List<Float> getPredictedValuesList() {
        return predictedValuesList;
    }

    private List<String> setTrustIntervalsList(List<Float> testWhitPositiveCases, List<Float> predictedValuesList, List<String> trustIntervalsList) {
        float ay = calculateAverage(testWhitPositiveCases);
        List<Float> erroList =new ArrayList<>();
        for (int i=0; i< testWhitPositiveCases.size(); i++) {
            float x = testWhitPositiveCases.get(i);
            float y;
            if(x>=ay){
                y=x-ay;
            }else {
                y=ay-x;
            }
            erroList.add(y);
        }
        int e= erroList.size();
        float v=calculateVariance(erroList,e);
        float er=calculateError(v,e);
        for (int i=0; i< predictedValuesList.size(); i++) {
            float x=predictedValuesList.get(i)+er;
            float y=predictedValuesList.get(i)-er;
            String ent = String.format("%f-%f",x,y);
            trustIntervalsList.add(ent);
        }
        return trustIntervalsList;
    }



    private List<Float> setPredictedValuesList(List<Float> testWhitPositiveCases, List<Float> independentVariables, List<Float> predictedValuesList, int numberOfDays) {
        float sx=calculateSum(independentVariables);
        float sy=calculateSum(testWhitPositiveCases);
        float sxx=calculateSxx(independentVariables);
        float sxy=calculateSxy(testWhitPositiveCases,independentVariables);
        float a = calculateA(sxx, sx,  sy,  sxy, numberOfDays);
        float ax = calculateAverage(independentVariables);
        float ay = calculateAverage(testWhitPositiveCases);
        float b = calculateB(a,ax,ay);
        for (int i=0; i< independentVariables.size(); i++) {
            float x = independentVariables.get(i);
            float y=calculateY(x,a,b);
            predictedValuesList.add(y);
        }
        return predictedValuesList;
    }





    private float calculateAverage(List<Float> Variables) {
        float sum = 0;
        for (int i=0; i< Variables.size(); i++) {
            sum += i;
        }
        return sum / Variables.size();
    }


    private float calculateSum(List<Float> Variables) {
        float sum = 0;
        for (float i : Variables)
            sum = sum + i;

        return sum;
    }

    private float calculateSxy(List<Float> depeVariables,List<Float> indVariables){
        float sxy = 0.0F;
        for (int i=0; i< depeVariables.size(); i++) {
            float x = indVariables.get(i);
            float y = depeVariables.get(i);
            sxy += x * y ;
        }
        return sxy;
    }

    private float calculateSxx(List<Float> indVariables){
        float sxx = 0.0F;
        for (int i=0; i< indVariables.size(); i++) {
            float x = indVariables.get(i);
            sxx += x * x ;
        }
        return sxx;
    }

    private float calculateVariance(List<Float> errolist,int e){
        float ae= calculateSxx(errolist);
        float v=ae/e;
        return (float) Math.sqrt(v);
    }

    private float calculateError(float v,int e) {
        float zc = (float) 1.96;
        float re= (float) Math.sqrt(e);
        return zc*(v/re);
    }

    private float calculateA(  float sxx, float sx, float sy, float sxy,float n){
        return ((n*sxy-sx*sy)/(n*sxx-sx*sx));
    }

    private float calculateB(  float a, float ax, float ay){
        return (ay-a*ax);
    }

    private float calculateY(  float x, float a, float b){
        return (x*a+b);
    }


}
