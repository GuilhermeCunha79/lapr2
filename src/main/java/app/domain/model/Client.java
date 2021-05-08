package app.domain.model;

import app.domain.shared.CommonMethods;
import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Objects;

/***
 * Client Class
 */
public class Client {

    static final int CITIZEN_CARD_DIGITS = 16;
    static final int MAX_CHAR_NAME = 35;
    static final int NHSTIN_NUMBER_DIGITS = 10;
    static final int PHONE_NUMBER_DIGITS = 11;
    static final int MAX_AGE = 150;
    static final String SEX_MALE = "male";
    static final String SEX_FEMALE = "female";
    static final String SEX_BY_OMISSION = "Not defined";
    private String name;
    private String citizenCardNumber;
    private String nhsNumber;
    private String tinNumber;
    private String birthDate;
    private String sex;
    private String phoneNumber;
    private String email;

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
        this.sex = SEX_BY_OMISSION;
    }

    /***
     * Method that returns the age of the client "at this moment"
     * @param birthDate
     * @param currentDate
     * @return
     */
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    /***
     * Convert a given string to Date
     * @param birthDate
     * @return
     */

    private LocalDate convertStringToDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.FRENCH);
        return LocalDate.parse(birthDate, formatter);
    }

    /***
     * Verify if the given birth respect the correct format (DD/MM/YYYY)
     * @param birthDate
     * @return
     */

    private boolean checkBirthDateRules(String birthDate) {
        boolean valid;
        try {
            LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
            valid = true;
        } catch (DateTimeParseException e) {
            valid = false;
        }
        return valid;
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
        if (name == null)
            throw new NullPointerException("Name" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name" + Constants.STRING_BLANK_EXEPT);
        if (name.length() > MAX_CHAR_NAME)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");
        if (!(CommonMethods.isValidString(name)))
            throw new IllegalArgumentException("Name" + Constants.NON_ALPHANUM_EXEPT);
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
        if (citizenCardNumber == null)
            throw new NullPointerException("Citizen Card Number" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(citizenCardNumber))
            throw new IllegalArgumentException("Citizen Card Number" + Constants.STRING_BLANK_EXEPT);
        if ((!CommonMethods.checkIfStringJustHaveNumbers(citizenCardNumber) || citizenCardNumber.length() != CITIZEN_CARD_DIGITS))
            throw new IllegalArgumentException("Citizen Card Number must have 10 digit numbers.");
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
        if (nhsNumber == null)
            throw new NullPointerException("NHS number" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(nhsNumber))
            throw new IllegalArgumentException("NHS number" + Constants.STRING_BLANK_EXEPT);
        if ((!CommonMethods.checkIfStringJustHaveNumbers(nhsNumber) || nhsNumber.length() != NHSTIN_NUMBER_DIGITS))
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
        if (tinNumber == null)
            throw new NullPointerException("TIN number" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(tinNumber))
            throw new IllegalArgumentException("TIN number" + Constants.STRING_BLANK_EXEPT);
        if ((!CommonMethods.checkIfStringJustHaveNumbers(tinNumber)) || tinNumber.length() != NHSTIN_NUMBER_DIGITS)
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
        LocalDate date = LocalDate.now();
        if (birthDate == null)
            throw new NullPointerException("Birth Date" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(birthDate))
            throw new IllegalArgumentException("Birth Date" + Constants.STRING_BLANK_EXEPT);

        if (!(checkBirthDateRules(birthDate)))
            throw new IllegalArgumentException("The Birth Date provided is in an incorrect format. Correct format: DD/MM/YYYY");

        if (calculateAge(convertStringToDate(birthDate), date) > MAX_AGE)
            throw new IllegalArgumentException("It is not possible to register a client older than 150 years.");


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
        if (sex == null)
            throw new NullPointerException("Sex" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(sex))
            throw new IllegalArgumentException("Sex" + Constants.STRING_BLANK_EXEPT);
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
        if (phoneNumber == null)
            throw new NullPointerException("Phone Number" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone Number" + Constants.STRING_BLANK_EXEPT);
        if (!(CommonMethods.checkIfStringJustHaveNumbers(phoneNumber)) || phoneNumber.length() != PHONE_NUMBER_DIGITS)
            throw new IllegalArgumentException("Phone Number must have 11 digit numbers.");
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
        if (email == null)
            throw new NullPointerException("Email" + Constants.STRING_NULL_EXEPT);
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Email" + Constants.STRING_BLANK_EXEPT);
        if (!CommonMethods.isValidEmail(email))
            throw new IllegalArgumentException("The introduced email is not valid.");
        this.email = email;
    }
    /***
     * Validate a client if he is not null
     * @param client
     * @return
     */
    public static boolean validateClient(Client client) {
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
