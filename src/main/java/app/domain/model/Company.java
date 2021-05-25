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

    private final String designation;
    private final AuthFacade authFacade;

    private final TypeOfTestStore totStore = new TypeOfTestStore();
    private final ClientStore clientStore = new ClientStore();
    private final ParameterCategoryStore pcStore = new ParameterCategoryStore();
    private final ParameterStore pStore = new ParameterStore();
    private final ClinicalAnalysisLaboratoryStore calStore = new ClinicalAnalysisLaboratoryStore();
    private final EmployeeStore empStore = new EmployeeStore();
    private final TestStore testStore = new TestStore();

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

    /**
     * This method returns the CA laboratory store used by the company
     * @return the CA laboratory store
     */
    public ClinicalAnalysisLaboratoryStore getClinicalAnalysisLaboratoryStore(){
        return this.calStore;
    }

    /**
     * This method returns the test store used by the company
     * @return the test store
     */
    public TestStore getTestStore(){
        return this.testStore;
    }
    /**
     * This method returns the employee store used by the company
     * @return the employee store
     */
    public EmployeeStore getEmployeeStore(){
        return this.empStore;
    }
}
