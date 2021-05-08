package app.domain.model;

import app.domain.store.*;
import auth.AuthFacade;
import app.domain.store.ClientStore;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;

    private TypeOfTestStore totStore = new TypeOfTestStore();
    private ClientStore clientStore = new ClientStore();
    private ParameterCategoryStore pcStore = new ParameterCategoryStore();
    private ParameterStore pStore = new ParameterStore();
    private ClinicalAnalysisLaboratoryStore calStore = new ClinicalAnalysisLaboratoryStore();
    private EmployeeStore empStore = new EmployeeStore();

    /**
     * Constructor of the company class assigning a designation to it
     * @param designation of the company
     */
    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
    }

    /**
     * Method that returns the designation of the company
     * @return the designation of the company
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * This method returns the authentication facade of the company
     * @return the authentication facade
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * This method returns the parameter category store used by the company
     * @return the parameter category store
     */
    public ParameterCategoryStore getParameterCategoryStore(){
        return this.pcStore;
    }

    /**
     * This method returns the parameter store used by the company
     * @return the parameter store
     */
    public ParameterStore getParameterStore(){
        return this.pStore;
    }

    /**
     * This method returns the client store used by the company
     * @return the client store
     */
    public ClientStore getClientStore(){
        return this.clientStore;
    }

    /**
     * This method returns the type of test store used by the company
     * @return the type of test store
     */
    public TypeOfTestStore getTypeOfTestStore() {
        return this.totStore;
    }

    public ClinicalAnalysisLaboratoryStore getClinicalAnalysisLaboratoryStore(){
        return this.calStore;
    }

    /**
     * This method returns the employee store used by the company
     * @return the employee store
     */
    public EmployeeStore getEmpStore(){
        return this.empStore;
    }
}
