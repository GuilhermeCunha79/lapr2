package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.domain.shared.DateTime;
import app.domain.store.SampleStore;
import app.domain.store.TestStore;
import app.mappers.TestListMapper;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

import java.util.List;

public class RegisterSampleController {

    private TestStore testStore;

    private Test test;

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
        List<Test> testList = testStore.getTestWithoutSample();
        if (!testList.isEmpty()) {
            TestListMapper tlm = new TestListMapper();
            return tlm.toDto(testList);
        }
        return null;
    }

    public  Barcode createUPCA (DateTime data) throws BarcodeException {
        data=test.getChemicalAnalysisDate();
        return BarcodeFactory.createUPCA(String.valueOf(data));
    }



    /**
     * When everything is confirmed by the user, this method saves the report created as an attribute of its test
     */
    public boolean saveSample(){
        return this.test.addSample(this.sample);
    }

}


