package app.domain.model;

import org.apache.commons.lang3.StringUtils;

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

    private static final int NHS_NUMBER_DIGITS=10;
    private static final int TIN_NUMBER_DIGITS=10;
    private static final int PHONE_NUMBER_DIGITS=11;
    private static final int BIRTH_DATE_DIGITS=8;
    private static final String UPPER_FIRST_LETTERSEX_MALE="Male";
    private static final String LOWER_SEX_MALE="male";
    private static final String UPPER_FIRST_LETTER_SEX_FEMALE="Female";
    private static final String LOWER_SEX_FEMALE="female";

    /***
     * Constructor for class Client, complete
     * @param nhsNumber
     * @param name
     * @param tinNumber
     * @param birthDate
     * @param sex
     * @param phoneNumber
     * @param email
     */
    public Client(long nhsNumber, String name, long tinNumber, String birthDate, String sex, long phoneNumber, String email){
        clientCount++;
        checkNhsNumberRules(nhsNumber);
        checkTinNumberRules(tinNumber);
        checkBirthDateRules(birthDate);
        checkSexRules(sex);
        checkPhoneNumberRules(phoneNumber);
        this.nhsNumber=nhsNumber;
        this.name=name;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.sex=sex;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    /***
     * Constructor for class Client, without phoneNumber
     * @param nhsNumber
     * @param name
     * @param tinNumber
     * @param birthDate
     * @param sex
     * @param email
     */
    public Client(long nhsNumber, String name, long tinNumber, String birthDate, String sex, String email){
        clientCount++;
        checkNhsNumberRules(nhsNumber);
        checkTinNumberRules(tinNumber);
        checkBirthDateRules(birthDate);
        checkSexRules(sex);
        this.nhsNumber=nhsNumber;
        this.name=name;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.sex=sex;
        this.email=email;
    }

    /***
     * Constructor for class Client, without sex and with phoneNumber
     * @param nhsNumber
     * @param name
     * @param tinNumber
     * @param birthDate
     * @param phoneNumber
     * @param email
     */
    public Client(long nhsNumber, String name, long tinNumber, String birthDate, long phoneNumber, String email){
        clientCount++;
        checkNhsNumberRules(nhsNumber);
        checkTinNumberRules(tinNumber);
        checkBirthDateRules(birthDate);
        checkPhoneNumberRules(phoneNumber);
        this.nhsNumber=nhsNumber;
        this.name=name;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    /***
     * Constructor for Client, without sex and phoneNumber
     * @param nhsNumber
     * @param name
     * @param tinNumber
     * @param birthDate
     * @param email
     */
    public Client(long nhsNumber, String name, long tinNumber, String birthDate, String email){
        clientCount++;
        checkNhsNumberRules(nhsNumber);
        checkTinNumberRules(tinNumber);
        checkBirthDateRules(birthDate);
        checkSexRules(sex);
        this.nhsNumber=nhsNumber;
        this.name=name;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.email=email;
    }

    /***
     * Verify if the nhsNumber respect the imposed rules
     * @param nhsNumber
     */
    private void checkNhsNumberRules(long nhsNumber) { //10 digit numbers
        if (nhsNumber==0)
            throw new IllegalArgumentException("NHS number cannot be blank.");
        if ( (nhsNumber < NHS_NUMBER_DIGITS ) || (nhsNumber > NHS_NUMBER_DIGITS))
            throw new IllegalArgumentException("NHS number must have 10 digit numbers.");
    }

    /***
     * Verify if the tinNumber respect the imposed rules
     * @param tinNumber
     */
    private void checkTinNumberRules(long tinNumber) { //10 digit numbers
        if (tinNumber==0)
            throw new IllegalArgumentException("TIN number cannot be blank.");
        if ( (tinNumber < TIN_NUMBER_DIGITS) || (tinNumber > TIN_NUMBER_DIGITS))
            throw new IllegalArgumentException("TIN number must have 10 digit numbers.");
    }

    /***
     * Verify if the phoneNumber respect the imposed rules
     * @param phoneNumber
     */
    private void checkPhoneNumberRules(long phoneNumber) { //11 digit numbers
        if (phoneNumber==0)
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if ( (phoneNumber < PHONE_NUMBER_DIGITS) || (phoneNumber > PHONE_NUMBER_DIGITS))
            throw new IllegalArgumentException("Phone number must have 11 digit numbers.");
    }

    /***
     * Verify if the birthDate respect the imposed rules
     * @param birthDate
     */
    private void checkBirthDateRules(String birthDate) { // DD/MM/YY format
        if (StringUtils.isBlank(birthDate))
            throw new IllegalArgumentException("Birth date cannot be blank.");
        if ( (birthDate.length() < BIRTH_DATE_DIGITS) || (birthDate.length() > BIRTH_DATE_DIGITS))
            throw new IllegalArgumentException("Birth date must have 4 to 8 chars.");
    }

    /***
     * Verify if the sex respect the imposed rules
     * @param sex
     */
    private void checkSexRules(String sex) { //Male or Female
        if (StringUtils.isBlank(sex))
            throw new IllegalArgumentException("Sex cannot be blank.");
        if ( (sex != LOWER_SEX_MALE) || (sex != LOWER_SEX_FEMALE) || (sex != UPPER_FIRST_LETTERSEX_MALE) || (sex != UPPER_FIRST_LETTER_SEX_FEMALE))
            throw new IllegalArgumentException("Sex must be Male or Female.");
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

    /***
     * Verify if the data of two Client's are equal
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getPhoneNumber() == client.getPhoneNumber() && getNhsNumber() == client.getNhsNumber() && getTinNumber() == client.getTinNumber() && getName().equals(client.getName()) && getBirthDate().equals(client.getBirthDate()) && getEmail().equals(client.getEmail()) && getSex().equals(client.getSex());
    }

}
