package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.CATest;
import app.domain.store.SampleStore;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterSampleController {

    private TestStore testStore;

    private CATest test;

    private List<Sample> s;

    private SampleStore ss;

    private Sample sample;

    /**
     * This constructor finds the instance of the company being used by the app
     */
    public RegisterSampleController() {
        this(App.getInstance().getCompany());
    }

    /**
     * This constructor finds the testStore used by the company
     */
    public RegisterSampleController(Company company) {
        this.testStore = company.getTestStore();
    }

    /**
     * This method returns a list with the main information about each test available without a sample
     *
     * @return a list of Strings holding the data for each test
     */
    public List<String> getTestWithoutSample() {
        List<CATest> testList = testStore.getTestWithoutSample();
        if (!testList.isEmpty()) {
            TestListMapper tlm = new TestListMapper();
            return tlm.toDto(testList);
        }
        return null;
    }

    /**
     * This method receives an internal code and finds the test that has it from the test store, then, returns all of its test codes
     * @param testCode internal code to be used
     * @return all the parameter tested results
     */
    public String getData(String testCode){
        this.test = testStore.getTestByCode(testCode);
        return test.getInternalCode();
    }

    public  Barcode createUPCA (String data) throws BarcodeException, OutputException, IOException {
        Barcode barcode = BarcodeFactory.createUPCA(data);
        File imgFile = new File("UPCA.jpg");
        BarcodeImageHandler.saveJPEG(barcode, imgFile);
        return barcode ;
    }

    public Sample createSample(ArrayList sampleList) {
        Sample sample = new Sample(sampleList);
        return sample;
    }

    /**
     * When everything is confirmed by the user, this method saves the samples created as an attribute of its test
     */
    public boolean addSample(){
        return this.test.addSample(this.sample);
    }


}


