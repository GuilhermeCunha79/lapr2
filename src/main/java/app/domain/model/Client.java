package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/***
 * Client Class
 */
public class Client {

    private String name;
    private String citizenCardNumber;
    private String nhsNumber;
    private String tinNumber;
    private String birthDate;
    private String sex;
    private String phoneNumber;
    private String email;
    List<Client> clientList = new ArrayList<>();

    static final int CITIZEN_CARD_DIGITS = 16;
    static final int MAX_CHAR_NAME = 35;
    static final int NHSTIN_NUMBER_DIGITS = 10;
    static final int PHONE_NUMBER_DIGITS = 11;
    static final String SEX_MALE = "male";
    static final String SEX_FEMALE = "female";

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
    public Client(String name, String citizenCardNumber, String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email) {
        setName(name);
        setCitizenCardNumber(citizenCardNumber);
        setNhsNumber(nhsNumber);
        setTinNumber(tinNumber);
        setBirthDate(birthDate);
        setSex(sex);
        setPhoneNumber(phoneNumber);
        setEmail(email);
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
    public Client(String name, String citizenCardNumber, String nhsNumber, String tinNumber, String birthDate, String phoneNumber, String email) {
        setName(name);
        setCitizenCardNumber(citizenCardNumber);
        setNhsNumber(nhsNumber);
        setTinNumber(tinNumber);
        setBirthDate(birthDate);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }


    private boolean checkIfStringJustHaveJustNumbers(String number, int n) {

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(number.charAt(i))) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    /***
     * Verify if the email given is a valid one
     * @param email
     * @return
     */
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public boolean checkBirthDateRules(String birthDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        sdf.setLenient(false);
        try {
            Date javaDate = sdf.parse(birthDate);
            System.out.println(birthDate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    //private void calcula CALCULAR IDADEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE


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
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > MAX_CHAR_NAME)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");

        for (int i = 0; i < name.length(); i++) {
            String c = String.valueOf(name.charAt(i));
            if (!c.matches("[A-Za-zÁ-Úá-ú]"))
                throw new IllegalArgumentException("Name has non alphanumeric chars.");
        }
        this.name = name;
    }

    /***
     * Method that returns the citizen card number of the Client
     * @return
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /***
     * Method that sets the name of the Client
     * @param citizenCardNumber
     */
    public void setCitizenCardNumber(String citizenCardNumber) {
        if (StringUtils.isBlank(citizenCardNumber))
            throw new IllegalArgumentException("Citizen card number must have 10 digit numbers.");
        if (!(checkIfStringJustHaveJustNumbers(citizenCardNumber,citizenCardNumber.length())) || citizenCardNumber.length() > CITIZEN_CARD_DIGITS || citizenCardNumber.length() < CITIZEN_CARD_DIGITS)
            throw new IllegalArgumentException("Citizen card number must have 10 digit numbers.");
        this.citizenCardNumber = citizenCardNumber;
    }

    /***
     * Method that returns the nhs number of the Client
     * @return
     */
    public String getNhsNumber() {
        return nhsNumber;
    }

    /***
     * Method that sets the nhs number of the Client
     * @param nhsNumber
     */

    public void setNhsNumber(String nhsNumber) {
        if (StringUtils.isBlank(nhsNumber))
            throw new IllegalArgumentException("NHS number cannot be blank.");
        if (!(checkIfStringJustHaveJustNumbers(nhsNumber,nhsNumber.length())) || nhsNumber.length()>NHSTIN_NUMBER_DIGITS || nhsNumber.length()<NHSTIN_NUMBER_DIGITS)
            throw new IllegalArgumentException("NHS number must have 10 digit numbers.");
        this.nhsNumber = nhsNumber;
    }

    /***
     * Method that returns the tin number of the Client
     * @return
     */
    public String getTinNumber() {
        return tinNumber;
    }

    /***
     * Method that sets the tin number of the Client
     * @param tinNumber
     */
    public void setTinNumber(String tinNumber) {
        if (StringUtils.isBlank(tinNumber))
            throw new IllegalArgumentException("TIN number must have 10 digit numbers.");
        if (!(checkIfStringJustHaveJustNumbers(tinNumber, tinNumber.length())) || tinNumber.length()>NHSTIN_NUMBER_DIGITS || tinNumber.length()<NHSTIN_NUMBER_DIGITS)
            throw new IllegalArgumentException("TIN number must have 10 digit numbers.");
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
        if (StringUtils.isBlank(birthDate))
            throw new IllegalArgumentException("Data cannot be blank");

        if(!(checkBirthDateRules(birthDate)))
            throw new IllegalArgumentException("The date of birth provided is in an incorrect format");
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
        if (StringUtils.isBlank(sex))
            throw new IllegalArgumentException("Sex cannot be blank.");
        if (!(sex.equalsIgnoreCase(SEX_FEMALE) || sex.equalsIgnoreCase(SEX_MALE)))
            throw new IllegalArgumentException("Sex must be Male or Female.");
        this.sex = sex;
    }

    /***
     * Method that returns the phone number of the Client
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /***
     * Method that sets the phone number of the Client
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if (!(checkIfStringJustHaveJustNumbers(phoneNumber,phoneNumber.length())) || phoneNumber.length()>PHONE_NUMBER_DIGITS || phoneNumber.length()< PHONE_NUMBER_DIGITS)
            throw new IllegalArgumentException("Phone number must have 11 digit numbers.");
        this.phoneNumber=phoneNumber;
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
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Email cannot be blank.");
        if (!isValidEmail(email))
            throw new IllegalArgumentException("The introduced email is not valid.");
        this.email = email;
    }

    /**
     * Validation of instance Client
     *
     * @return true or false
     */
    public boolean validateClient(Client client) {
        return (client.name != null
                && client.tinNumber != null
                && client.birthDate != null
                && client.nhsNumber != null
                && client.phoneNumber != null
                && client.email != null
                && client.sex != null);
    }

    @Override
    public String toString() {
        return String.format("Client:%nName: %s%nCitizen Card Number: %s%nNHS number: %s%nTIN number: %s%nBirth date: %s%nSex: %s%nPhone number: %s%nEmail: %s",
                this.name, this.citizenCardNumber, this.nhsNumber, this.tinNumber, this.birthDate, this.sex, this.phoneNumber, this.email);
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
                && Objects.equals(citizenCardNumber, client.citizenCardNumber)
                && Objects.equals(nhsNumber, client.nhsNumber)
                && Objects.equals(tinNumber, client.tinNumber)
                && Objects.equals(email, client.email);
    }
}
