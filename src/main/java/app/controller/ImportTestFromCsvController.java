package app.controller;

import app.domain.model.*;
import app.domain.shared.DateTime;
import app.domain.store.*;
import app.mappers.dto.ClientDTO;
import app.mappers.dto.ClinicalTestDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ImportTestFromCsvController {

    private TestStore testStore;
    private ClinicalAnalysisLaboratoryStore calStore;
    private ClientStore clientStore;
    private TypeOfTestStore typeOfTestStore;
    private ParameterStore parameterStore;
    List<String> testsAdded = new ArrayList<>();
    List<String> testsFailed = new ArrayList<>();
    private String[] firstLine;

    private BufferedReader br;

    public ImportTestFromCsvController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Main constructor of this controller used to get all the needed store instances being used by the system
     *
     * @param company
     */
    public ImportTestFromCsvController(Company company) {
        this.testStore = company.getTestStore();
        this.calStore = company.getClinicalAnalysisLaboratoryStore();
        this.clientStore = company.getClientStore();
        this.typeOfTestStore = company.getTypeOfTestStore();
        this.parameterStore = company.getParameterStore();
    }

    /**
     * Get method for the temporary list of added tests via a CSV file
     *
     * @return
     */
    public List<String> getTestsAddedList() {
        return new ArrayList<>(testsAdded);
    }

    /**
     * Get method for the temporary list of failed tests created via a CSV file
     *
     * @return
     */
    public List<String> getTestsFailedList() {
        return new ArrayList<>(testsFailed);
    }

    /**
     * This method is responsible for creating new tests from a csv file with the help of other methods
     *
     * @return
     */
    public boolean createTestFromCsvFile(String path) {
        String line;
        String divider = ";";
        try {
            br = new BufferedReader(new FileReader(path));
            line = this.br.readLine();
            this.firstLine = line.split(divider);
            while ((line = this.br.readLine()) != null) {
                String[] testData = line.split(divider);
                ClinicalAnalysisLaboratory lab = checkLab(testData[2]);
                if (lab != null) {
                    Client client = registerClient(testData);
                    if (client != null) {
                        ClinicalTest test = createTest(testData, client, lab.getLaboratoryID());
                        if (test != null) {
                            if (testStore.saveTest(test)) {
                                if (addParameterResults(test, testData)) {
                                    testsAdded.add(test.toString());
                                    continue;
                                }
                            }
                        }
                    }
                }
                testsFailed.add("Test with NHS Code " + testData[1] + " was not imported");
            }
            this.br.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method adds test parameter results to a test by getting the values from a CSV file
     *
     * @param test
     * @param testData
     * @return if all the parameters received results or not
     * @throws ParseException
     */
    private boolean addParameterResults(ClinicalTest test, String[] testData) throws ParseException {
        boolean status = true;
        for (Parameter parameter : test.getParameterList()) {
            status = test.addTestParameterResult(parameter.getCode(), NumberFormat.getNumberInstance(Locale.ENGLISH).parse(testData[getColumnByKeyWord(parameter.getCode())]).doubleValue(), "");
        }
        return status;
    }

    /**
     * This method creates the test and returns it
     *
     * @param testData
     * @param client
     * @param labID
     * @return
     */
    private ClinicalTest createTest(String[] testData, Client client, String labID) {
        TypeOfTest clinicalTestType = typeOfTestStore.getTestTypeByDescription(testData[getColumnByKeyWord("TestType")]);
        List<Parameter> parameterList = getParameterList(testData);
        if (parameterList != null && !parameterList.isEmpty()) {
            ClinicalTestDto testDto = new ClinicalTestDto(testData[1], client, clinicalTestType, parameterList, labID, castToDateTime(testData[getColumnByKeyWord("Test_Reg_DateHour")]), castToDateTime(testData[getColumnByKeyWord("Test_Chemical_DateHour")])
                    , castToDateTime(testData[getColumnByKeyWord("Test_Doctor_DateHour")]), castToDateTime(testData[getColumnByKeyWord("Test_Validation_DateHour")]));
            return testStore.createTestWithDates(testDto);


        }
        return null;
    }

    /**
     * This method creates a parameter list based of the data available for each test in the csv file
     *
     * @param testData
     * @return the list of parameters
     */
    private List<Parameter> getParameterList(String[] testData) {
        List<Parameter> lParameter = new ArrayList<>();
        for (int i = getColumnByKeyWord("TestType") + 1; i < getColumnByKeyWord("Test_Reg_DateHour"); i++) {
            if (!testData[i].equals("NA") && getKeyWordByColumn(i).equals("Category")) {
                List<ParameterCategory> lPC = typeOfTestStore.getTestTypeByDescription(testData[getColumnByKeyWord("TestType")]).getCategoryListByTheTypeOfTest();
                if (!checkCategoryExist(testData[i], lPC))
                    return null;
            }
            if (!testData[i].equals("NA") && !getKeyWordByColumn(i).equals("Category")) {
                lParameter.add(parameterStore.getParameterByCode(getKeyWordByColumn(i)));
            }
        }
        return lParameter;
    }

    /**
     * This method converts the Dates and hours found in the csv file as strings to a DateTime object
     *
     * @param dateTime
     * @return the new DateTime object instance
     */
    private DateTime castToDateTime(String dateTime) {
        String[] dateAndTime = dateTime.split(" ");
        return new DateTime(dateAndTime[0], dateAndTime[1]);
    }

    /**
     * This method checks if it can find one specific parameter category in a list of Parameter categories received by parameter
     *
     * @param categoryName
     * @param lPC
     * @return if the parameter category exists or not in the given list
     */
    private boolean checkCategoryExist(String categoryName, List<ParameterCategory> lPC) {
        for (ParameterCategory pc : lPC) {
            if (pc.getName().equalsIgnoreCase(categoryName))
                return true;
        }
        return false;
    }

    /**
     * This method with the help of the lab store, checks if a specific labID exists in the system
     *
     * @param labId
     * @return if there is a clinical analysis laboratory with the given LabID in the system
     */
    private ClinicalAnalysisLaboratory checkLab(String labId) {
        return this.calStore.checkLab(labId);
    }

    /**
     * The sole purpose of this method is create a new client based of data available
     * in the csv file and return it. In case the client is already registered in the system returns the client.
     *
     * @param clientData
     * @return the client
     */
    private Client registerClient(String[] clientData) {
        try {
            ClientDTO clientDTO = new ClientDTO(clientData[8], clientData[3], clientData[4], clientData[5], clientData[6], clientData[7], clientData[9], clientData[10]);
            Client client = this.clientStore.newClient(clientDTO);
            if (client != null) {
                if (this.clientStore.saveClient(client))
                    return client;
                else
                    return this.clientStore.getClientByTIN(clientData[5]);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * This method returns the column number where the its name is the same as the keyword received by parameter
     *
     * @param keyword
     * @return
     */
    private int getColumnByKeyWord(String keyword) {
        for (int i = 0; i < this.firstLine.length; i++) {
            if (firstLine[i].equals(keyword))
                return i;
        }
        return -1;
    }

    /**
     * This method receives a column number and returns the respective name of the column
     *
     * @param column
     * @return
     */
    private String getKeyWordByColumn(int column) {
        return firstLine[column];
    }
}
