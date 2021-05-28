package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class TestSample {
    private boolean sampleDone;
    private List<Sample> sampleList = new ArrayList<>();

    /**
     * this method returns if this test already has a sample or not using the sampleDone boolean variable
     *
     * @return true or false
     */
    public boolean getSampleStatus() {
        return this.sampleDone;
    }

    /**
     * This method receives a Sample and assigns it to the test it's related to
     *
     * @param sample the instance of a Report
     * @return if it was added or not
     */
    public boolean addSample(Sample sample) {
        if(!sampleDone) {
            this.sampleList = (List<Sample>) sample;
            changeStateToSampleDone();
        }
        return this.sampleDone;
    }

    /**
     * The only purpose of this method is to change the state of the test to inform that the sample is done
     */
    private void changeStateToSampleDone() {
        sampleDone = true;
    }
}
