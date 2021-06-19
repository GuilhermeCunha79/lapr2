package app.domain.model;

import app.domain.store.*;
import app.ui.console.utils.Utils;
import auth.AuthFacade;
import app.domain.store.ClientStore;
import app.domain.store.ParameterCategoryStore;
import app.domain.store.ParameterStore;
import auth.domain.model.User;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;


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


        setEmpStore();
        setPCategoryStore();
        setParameterStore();
        setTotStore();
        setCALabStore();
        setClientStore();
        setTestStore();
        setUserStore();

    }

    private void setUserStore() {
        try (FileInputStream input = new FileInputStream("data\\user.dat"); ObjectInputStream in = new ObjectInputStream(input)){
            Set<User> userList = new HashSet<>((Set<User>) in.readObject());
            this.authFacade.getUsers().setStore(userList);
        }catch (IOException | ClassNotFoundException e){
            e.getLocalizedMessage();
        }
    }

    private void setClientStore() {
        try (FileInputStream input = new FileInputStream("data\\clients.dat"); ObjectInputStream in = new ObjectInputStream(input)) {
            List<Client> lClient = (List<Client>) in.readObject();
            this.clientStore.setClientList(lClient);
        } catch (IOException | ClassNotFoundException e) {
            e.getLocalizedMessage();
        }
    }

    private void setCALabStore() {
        try (FileInputStream input = new FileInputStream("data\\calab.dat"); ObjectInputStream in = new ObjectInputStream(input)){
            List<ClinicalAnalysisLaboratory> lCALab = (List<ClinicalAnalysisLaboratory>) in.readObject();
            this.calStore.setCALabList(lCALab);
        }catch (IOException | ClassNotFoundException e){
            e.getLocalizedMessage();
        }
    }

    private void setEmpStore() {
        try (FileInputStream input = new FileInputStream("data\\employee.dat"); ObjectInputStream in = new ObjectInputStream(input)){
            List<Employee> lEmployee = (List<Employee>) in.readObject();
            this.empStore.setEmployeeList(lEmployee);
        }catch (IOException | ClassNotFoundException e){
            e.getLocalizedMessage();
        }
    }

    private void setPCategoryStore() {
        try (FileInputStream input = new FileInputStream("data\\pcat.dat"); ObjectInputStream in = new ObjectInputStream(input)){
            List<ParameterCategory> lPCategory = (List<ParameterCategory>) in.readObject();
            this.pcStore.setParameterCategoryList(lPCategory);
        }catch (IOException | ClassNotFoundException e){
            e.getLocalizedMessage();
        }
    }

    private void setParameterStore() {
        try (FileInputStream input = new FileInputStream("data\\param.dat"); ObjectInputStream in = new ObjectInputStream(input)){
            List<Parameter> lParameter = (List<Parameter>) in.readObject();
            this.pStore.setParameterList(lParameter);
        }catch (IOException | ClassNotFoundException e){
            e.getLocalizedMessage();
        }
    }

    private void setTestStore() {
        try (FileInputStream input = new FileInputStream("data\\test.dat"); ObjectInputStream in = new ObjectInputStream(input)){
            List<ClinicalTest> lTest = (List<ClinicalTest>) in.readObject();
            this.testStore.setTestList(lTest);
        }catch (IOException | ClassNotFoundException e){
            e.getLocalizedMessage();
        }
    }

    private void setTotStore() {
        try (FileInputStream input = new FileInputStream("data\\tot.dat"); ObjectInputStream in = new ObjectInputStream(input)){
            List<TypeOfTest> lTestType = (List<TypeOfTest>) in.readObject();
            this.totStore.setTypeOfTestList(lTestType);
        }catch (IOException | ClassNotFoundException e){
            e.getLocalizedMessage();
        }
    }

    public Sorting getSortingMethod(String type){
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("config.properties")) {
            props.load(in);
            String sort;
            Class<?> oClass;
            if (type.equalsIgnoreCase("name")) {
                sort = props.getProperty("Company.NameSortingMethod");
            } else {
                sort = props.getProperty("Company.TinNumberSortingMethod");
            }
            oClass = Class.forName(sort);
            return (Sorting) oClass.newInstance();
        } catch (Exception e) {
            Utils.printToConsole(e.getLocalizedMessage());
            return null;
        }
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
