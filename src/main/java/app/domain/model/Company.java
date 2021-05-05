package app.domain.model;

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

    private ParameterCategoryStore pcStore;
    private ParameterStore pStore;

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

    public List<ParameterCategory> getParameterCategoryStore(){
        return this.pcStore.getParameterCategoryList();
    }

    public List<Parameter> getParameterStore(){
        return this.pStore.getParameterList();
    }

    public List<Client> getClientStore() {
        return this.ctStore.getClientList();
    }
}
