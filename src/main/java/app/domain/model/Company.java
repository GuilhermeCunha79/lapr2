package app.domain.model;

import app.domain.store.TypeOfTestStore;
import auth.AuthFacade;
import app.domain.store.ClientStore;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

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

    private ClientStore ctStore;


    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public ParameterCategoryStore getParameterCategoryStore(){
        return this.pcStore;
    }

    public ParameterStore getParameterStore(){
        return this.pStore;
    }

    public ClientStore getClientStore(){
        return this.clientStore;
    }

    public TypeOfTestStore getTypeOfTestStore() {
        return this.totStore;
    }
}
