package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private App()
    {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {

        }
        return props;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_LAB_COORDINATOR,Constants.ROLE_LAB_COORDINATOR);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST,Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_CLIENT,Constants.ROLE_CLIENT);
        this.authFacade.addUserRole(Constants.ROLE_SPECIALIST_DOCTOR,Constants.ROLE_SPECIALIST_DOCTOR);
        this.authFacade.addUserRole(Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST,Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Receptionist", "recep@lei.sem2.pt", "123456",Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserWithRole("Clinical chemistry technologist", "cct@lei.sem2.pt", "123456",Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST);
        this.authFacade.addUserWithRole("Lab Coordinator", "lab@lei.sem2.pt", "123456",Constants.ROLE_LAB_COORDINATOR);
        this.authFacade.addUserWithRole("Specialist doctor", "sp@lei.sem2.pt", "123456",Constants.ROLE_SPECIALIST_DOCTOR);

        this.getCompany().getParameterCategoryStore().saveParameterCategory(new ParameterCategory("12345", "Blood"));
        this.getCompany().getParameterStore().saveParameter(new Parameter("WBC00", "WBC", "White blood count", new ParameterCategory("12345", "Blood")));
        this.getCompany().getParameterStore().saveParameter(new Parameter("RBC00", "RBC", "Red blood count", new ParameterCategory("12345", "Blood")));
        this.getCompany().getTypeOfTestStore().saveTypeOfTest(new TypeOfTest("09090", "blood test", "seringe", new ParameterCategory("12345", "Blood")));
        this.getCompany().getClinicalAnalysisLaboratoryStore().saveClinicalAnalysisLaboratory(new ClinicalAnalysisLaboratory("l0001", "lab 1", "street 1", "90909090909", "8978787878"));
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance()
    {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }
}
