package app.controller;

import app.domain.model.*;
import app.domain.store.*;
import app.domain.model.Company;

import java.util.ArrayList;
import java.util.List;

import app.domain.model.Client;
import app.domain.store.ClientStore;
import app.mappers.ParameterMapper;

import app.mappers.TestTypeMapper;


public class CreateTestController {


    private String nhsCode;
    private String labId;
    private ClinicalTest test;
    private TypeOfTest typeOfTest;
    private Parameter parameter;
    private Client client;
    private ClientStore cs;
    private TypeOfTestStore tots;
    private TestStore testStore;
    private ParameterStore ps;
    private List<Parameter> pList = new ArrayList<>();
    private List<TypeOfTest> ttList = new ArrayList<>();



    /**
     * This constructor finds the instance of the company being used by the app
     */
    public CreateTestController() {
        this(App.getInstance().getCompany());
    }

    /**
     * This constructor finds the testStore used by the company
     */
    public CreateTestController(Company company) {
        this.testStore = company.getTestStore();
        this.tots = company.getTypeOfTestStore();
        this.ps = company.getParameterStore();
        this.cs = company.getClientStore();
    }

    public void createTest() {
        this.test = testStore.createTest(nhsCode, client, typeOfTest, pList, labId);
    }

    public boolean saveTest() {
        return this.testStore.saveTest(this.test);
    }

    public void setLabId(String labId){
        this.labId = labId;
    }
    /**
     * Method to get a client by tin
     *
     * @param tin object
     * @return true if the client exist false if not
     */
    public String getClientByTINAndSaveNhsCode(String tin, String nhsCode) {
        this.nhsCode = nhsCode;

        this.client = cs.getClientByTIN(tin);
        if (client != null)
            return client.toString();
        else
            return null;
    }

    /**
     * This method returns a list with the main information about each types of test available
     *
     * @return a list of Strings holding the data for each test
     */

    public List<String> getTypeOfTestList() {
        List<TypeOfTest> lTypeOfTest = tots.getTypeOfTestList();
        if (lTypeOfTest != null) {
            return TestTypeMapper.toDto(lTypeOfTest);
        }
        return null;
    }


    public void addTypeOfTest(String code) {
        this.typeOfTest = tots.getTestType(code);
    }

    public List<String> getParameterList() {
        List<Parameter> lParameter = ps.getParameterListByTheCategory(typeOfTest.getCategoryListByTheTypeOfTest());
        return ParameterMapper.toDto(lParameter);
    }

    public boolean addParameter(String code) {
        this.parameter = ps.getParameterByCode(code);
        return this.pList.add(parameter);
    }



}







