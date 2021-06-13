package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.ClinicalTest;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RegisterSampleController {

    private TestStore testStore;

    private ClinicalTest test;

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
        List<ClinicalTest> lTestNoSample = testStore.getTestWithoutSample();
        if (!lTestNoSample.isEmpty()) {
            return TestListMapper.toDto(lTestNoSample);
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


    /**
     * This method  uses the internal code to generate the bar code
     * @param data internal code to be used
     * @return gerated barcod
     * @throws OutputException prevents error
     * @throws IOException prevents error
     */
    public  Barcode createUPCA (String data) throws  OutputException, IOException {
        Barcode barcode = null;
        try {
            barcode = BarcodeFactory.createUPCA(data);
        } catch (BarcodeException e) {
            e.printStackTrace();
        }
        File imgFile = new File("UPCA.jpg");
        BarcodeImageHandler.saveJPEG(barcode, imgFile);
        return barcode ;
    }

    /**
     * This method turns the Arraylist received to
     * @param sampleList list to be added
     * @return sample
     */
    public Sample createSample(List<Sample> sampleList) {
        this.sample = new Sample(sampleList);
        return sample;
    }

    /**
     * When everything is confirmed by the user, this method saves the samples created as an attribute of its test
     */
    public boolean addSample(){
        return this.test.addSample(this.sample);
    }


}


