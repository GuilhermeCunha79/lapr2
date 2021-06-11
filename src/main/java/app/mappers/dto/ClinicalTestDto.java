package app.mappers.dto;

import app.domain.model.Client;
import app.domain.model.Parameter;
import app.domain.model.TypeOfTest;
import app.domain.shared.DateTime;

import java.util.List;

public class ClinicalTestDto {
    private String nhsCode;
    private Client client;
    private TypeOfTest typeOfTest;
    private List<Parameter> parameterList;
    private String labWhereCreated;
    private DateTime registDateHour;
    private DateTime chemicalDateHour;
    private DateTime sDoctorDateHour;
    private DateTime validationDateHour;

    /**
     * Complete clinical test DTO constructor
     * @param nhsCode of the test
     * @param client that is linked to the test
     * @param typeOfTest which test type is going to be performed
     * @param parameterList list of parameters that are going to be analysed in the test
     * @param labWhereCreated id of the lab where the test was created
     * @param registDateHour registration date and hour of the clinical test
     * @param chemicalDateHour chemical analysis date and hour of the clinical test
     * @param sDoctorDateHour date and hour of the report made by the specialist doctor for the test
     * @param validationDateHour date and hour of when the test validation occurred
     */
    public ClinicalTestDto(String nhsCode, Client client, TypeOfTest typeOfTest, List<Parameter> parameterList, String labWhereCreated, DateTime registDateHour, DateTime chemicalDateHour, DateTime sDoctorDateHour, DateTime validationDateHour) {
        this.nhsCode = nhsCode;
        this.client = client;
        this.typeOfTest = typeOfTest;
        this.parameterList = parameterList;
        this.labWhereCreated = labWhereCreated;
        this.registDateHour = registDateHour;
        this.chemicalDateHour = chemicalDateHour;
        this.sDoctorDateHour = sDoctorDateHour;
        this.validationDateHour = validationDateHour;
    }

    /**
     * Get method for the nhs code
     * @return the nhs code of the test
     */
    public String getNhsCode() {
        return nhsCode;
    }

    /**
     * Get method for the client
     * @return the client linked to the test
     */
    public Client getClient() {
        return client;
    }

    /**
     * Get method for the test type
     * @return the test type of the clinical test
     */
    public TypeOfTest getTypeOfTest() {
        return typeOfTest;
    }

    /**
     * Get method for the list of parameters
     * @return the list of parameters analysed for the test
     */
    public List<Parameter> getParameterList() {
        return parameterList;
    }

    /**
     * Get method for the ID of the lab where the test was first created
     * @return the lab ID
     */
    public String getLabWhereCreated() {
        return labWhereCreated;
    }

    /**
     * Get method for the date and hour of the test registration
     * @return date and hour of the registration
     */
    public DateTime getRegistDateHour() {
        return registDateHour;
    }

    /**
     * Get method for the date and hour of the chemical analysis
     * @return date and hour of the chemical analysis
     */
    public DateTime getChemicalDateHour() {
        return chemicalDateHour;
    }

    /**
     * Get method for the date and hour of when the specialist doctor wrote the report
     * @return date and hour of the report
     */
    public DateTime getsDoctorDateHour() {
        return sDoctorDateHour;
    }

    /**
     * Get method for the date and hour of the test validation
     * @return date and hour of the test validation
     */
    public DateTime getValidationDateHour() {
        return validationDateHour;
    }
}
