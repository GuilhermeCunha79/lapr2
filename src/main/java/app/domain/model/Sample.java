package app.domain.model;


import java.util.ArrayList;
import java.util.List;


public class Sample {
    private List<Sample> sampleList ;

    /**
     * creates a list of class sample list
     * @param sampleList
     */
    public Sample(ArrayList sampleList) {
        this.sampleList = new ArrayList<>(sampleList);
    }

    /**
     * method to get the sample list
     * @return sampleList
     */
    public List<Sample> getSampleList() { return sampleList; }

    /**
     * to String method to show the
     * @return a String
     */
    @Override
    public String toString() {
        return "Sample:"+sampleList;
    }
}

