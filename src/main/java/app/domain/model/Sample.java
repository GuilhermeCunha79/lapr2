package app.domain.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Sample implements Serializable {
    private List<Sample> sampleList ;

    /**
     * creates a list of class sample list
     * @param sampleList
     */
    public Sample(List<Sample> sampleList) {
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

