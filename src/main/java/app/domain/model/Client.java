package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private static final int NHSTIN_NUMBER_DIGITS = 10;
    private static final int PHONE_NUMBER_DIGITS = 11;
    private static final int BIRTH_DATE_DIGITS = 8;
    private static final String SEX_MALE = "Male";
    private static final String SEX_FEMALE = "Female";

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
    public Client(String name, long nhsNumber, long tinNumber, String birthDate, String sex, long phoneNumber, String email) {
        clientCount++;
        checkNhsTinNumberRules(nhsNumber);
        checkNhsTinNumberRules(tinNumber);
        checkBirthDateRules(birthDate);
        checkSexRules(sex);
        checkPhoneNumberRules(phoneNumber);
        this.nhsNumber = nhsNumber;
        this.name = name;
        this.tinNumber = tinNumber;
        this.birthDate = birthDate;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
    public Client(String name, long nhsNumber, long tinNumber, String birthDate, String sex, String email) {
        clientCount++;
        checkNhsTinNumberRules(nhsNumber);
        checkNhsTinNumberRules(tinNumber);
        checkBirthDateRules(birthDate);
        checkSexRules(sex);
        this.nhsNumber = nhsNumber;
        this.name = name;
        this.tinNumber = tinNumber;
        this.birthDate = birthDate;
        this.sex = sex;
        this.email = email;
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
    public Client(String name, long nhsNumber, long tinNumber, String birthDate, long phoneNumber, String email) {
        clientCount++;
        checkNhsTinNumberRules(nhsNumber);
        checkNhsTinNumberRules(tinNumber);
        checkBirthDateRules(birthDate);
        checkPhoneNumberRules(phoneNumber);
        this.nhsNumber = nhsNumber;
        this.name = name;
        this.tinNumber = tinNumber;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /***
     * Constructor for Client, without sex and phoneNumber
     * @param nhsNumber
     * @param name
     * @param tinNumber
     * @param birthDate
     * @param email
     */
    public Client(String name, long nhsNumber, long tinNumber, String birthDate, String email) {
        clientCount++;
        checkNhsTinNumberRules(nhsNumber);
        checkNhsTinNumberRules(tinNumber);
        checkBirthDateRules(birthDate);
        checkSexRules(sex);
        this.nhsNumber = nhsNumber;
        this.name = name;
        this.tinNumber = tinNumber;
        this.birthDate = birthDate;
        this.email = email;
    }

    /***
     * Verify if the nhsNumber respect the imposed rules
     * @param nhsTinNumber
     */
    private void checkNhsTinNumberRules(long nhsTinNumber) { //10 digit numbers
        if (nhsTinNumber == 0)
            throw new IllegalArgumentException("NHS number cannot be blank.");
        if (((int) Math.floor(Math.log10(nhsTinNumber) + 1) < NHSTIN_NUMBER_DIGITS) || ((int) Math.floor(Math.log10(nhsTinNumber) + 1) > NHSTIN_NUMBER_DIGITS))
            throw new IllegalArgumentException("NHS number must have 10 digit numbers.");
    }

    /***
     * Verify if the phoneNumber respect the imposed rules
     * @param phoneNumber
     */
    private void checkPhoneNumberRules(long phoneNumber) { //11 digit numbers
        if (phoneNumber == 0)
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if (((int) Math.floor(Math.log10(phoneNumber) + 1) < PHONE_NUMBER_DIGITS) || ((int) Math.floor(Math.log10(phoneNumber) + 1) > PHONE_NUMBER_DIGITS))
            throw new IllegalArgumentException("Phone number must have 11 digit numbers.");
    }

    /***
     * Verify if the birthDate respect the imposed rules
     * @param birthDate
     */
    private void checkBirthDateRules(String birthDate) { // DD/MM/YY format
        if (StringUtils.isBlank(birthDate))
            throw new IllegalArgumentException("Birth date cannot be blank.");
        if ((birthDate.length() < BIRTH_DATE_DIGITS) || (birthDate.length() > BIRTH_DATE_DIGITS))
            throw new IllegalArgumentException("Birth date must have 4 to 8 chars.");
    }

    /***
     * Verify if the sex respect the imposed rules
     * @param sex
     */
    private void checkSexRules(String sex) { //Male or Female
        if (StringUtils.isBlank(sex))
            throw new IllegalArgumentException("Sex cannot be blank.");
        if (sex.equalsIgnoreCase(SEX_FEMALE) || sex.equalsIgnoreCase(SEX_MALE))
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
        return (client.name != null
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
        if (o == null || getClass() != o.getClass())
            return false;


        Client client = (Client) o;
        return Objects.equals(phoneNumber, client.phoneNumber)
                && Objects.equals(nhsNumber, client.nhsNumber)
                && Objects.equals(tinNumber, client.tinNumber)
                && Objects.equals(email, client.email);
    }

}
