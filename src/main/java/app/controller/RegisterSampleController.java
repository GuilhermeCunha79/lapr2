package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.CATest;
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

    private CATest test;

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
        List<CATest> lTestNoSample = testStore.getTestWithoutSample();
        if (lTestNoSample != null) {
            TestListMapper tlm = new TestListMapper();
            return tlm.toDto(lTestNoSample);
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
     * @param code internal code to be used
     * @return gerated barcod
     * @throws OutputException prevents error
     * @throws IOException prevents error
     */
    public static String createUPCA (String code) throws OutputException, IOException, BarcodeException {
        Barcode barcode = BarcodeFactory.createUPCA(code);
        barcode.setPreferredBarHeight(100);
        File imgFile = new File(String.format("Barcode_%s.jpg",code));
        BarcodeImageHandler.saveJPEG(barcode, imgFile);
        return barcode.getData();
    }

    /**
     * This method turns the Arraylist received to
     * @param barcode
     * @return sample
     */
    public Sample createSample(String barcode) {
        this.sample = new Sample(barcode);
        return sample;
    }

    /**
     * When everything is confirmed by the user, this method saves the samples created as an attribute of its test
     */
    public boolean addSample(){
        return this.test.addSample(this.sample);
    }



}


