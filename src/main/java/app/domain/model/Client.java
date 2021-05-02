package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/***
 * Client Class
 */
public class Client {

    private String name;
    private long nhsNumber;
    private long tinNumber;
    private String birthDate;
    private String sex;
    private long phoneNumber;
    private String email;
    List<Client> clientList = new ArrayList<>();

    private static int clientCount = 0;

    /***
     * Constructor for class Client
     * @param nhsNumber
     * @param name
     * @param tinNumber
     * @param birthDate
     * @param sex
     * @param phoneNumber
     * @param email
     */
    public Client(int nhsNumber, String name, int tinNumber, String birthDate, String sex, long phoneNumber, String email){
        clientCount++;
        this.nhsNumber=nhsNumber;
        this.name=name;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.sex=sex;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    /***
     * Constructor for class Client
     * @param nhsNumber
     * @param name
     * @param tinNumber
     * @param birthDate
     * @param sex
     * @param email
     */
    public Client(int nhsNumber, String name, int tinNumber, String birthDate, String sex, String email){
        clientCount++;
        this.nhsNumber=nhsNumber;
        this.name=name;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.sex=sex;
        this.email=email;
    }

    /***
     * Method that returns the nhs number of the Client
     * @return
     */
    public long getNhsNumber() {
        return nhsNumber;
    }

    /***
     * Method that sets the nhs number of the Client
     * @param nhsNumber
     */
    public void setNhsNumber(int nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    /***
     * Method that returns the name of the Client
     * @return
     */
    public String getName() {
        return name;
    }

    /***
     * Method that sets the name of the Client
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * Method that returns the tin number of the Client
     * @return
     */
    public long getTinNumber() {
        return tinNumber;
    }

    /***
     * Method that sets the tin number of the Client
     * @param tinNumber
     */
    public void setTinNumber(int tinNumber) {
        this.tinNumber = tinNumber;
    }

    /***
     * Method that returns the birth date of the Client
     * @return
     */
    public String getBirthDate() {
        return birthDate;
    }

    /***
     * Method that sets the birth date of the Client
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /***
     * Method that returns the sex of the Client
     * @return
     */
    public String getSex() {
        return sex;
    }

    /***
     * Method that sets the sex of the Client
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /***
     * Method that returns the phone number of the Client
     * @return
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /***
     * Method that sets the phone number of the Client
     * @param phoneNumber
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /***
     * Method that returns the email of the Client
     * @return
     */
    public String getEmail() {
        return email;
    }

    /***
     * Method that sets the email of the Client
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Validation of instance Client
     *
     * @return true or false
     */
    public boolean validateClient(Client client) {
        return ( client.name != null
                && client.birthDate != null
                && client.tinNumber > 0000000000
                && client.tinNumber <= 9999999999L
                && client.nhsNumber > 0000000000
                && client.nhsNumber <= 9999999999L
                && client.phoneNumber > 00000000000
                && client.phoneNumber <= 99999999999L
                && client.email != null
                && client.sex != null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getPhoneNumber() == client.getPhoneNumber() && getNhsNumber() == client.getNhsNumber() && getTinNumber() == client.getTinNumber() && getName().equals(client.getName()) && getBirthDate().equals(client.getBirthDate()) && getEmail().equals(client.getEmail()) && getSex().equals(client.getSex());
    }

}
