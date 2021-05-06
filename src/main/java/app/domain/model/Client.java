package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

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
    List<Client> clientList = new ArrayList<>();
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

    /***
     * Verify if the given string just have numbers
     * @param number
     * @return
     */
    private boolean checkIfStringJustHaveNumbers(String number) {
        int numberq = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                numberq++;
            } else {
                return false;
            }
        }
        if (numberq == number.length())
            return true;
        return false;
    }

    /***
     * Verify if the email given is a valid one
     * @param email
     * @return
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
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
            throw new NullPointerException("Name cannot be null");
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > MAX_CHAR_NAME)
            throw new IllegalArgumentException("Name cannot have more than 35 characters");

        for (int i = 0; i < name.length(); i++) {
            String c = String.valueOf(name.charAt(i));
            if (!c.matches("[A-Za-zÁ-Úá-úã-õ]"))
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
        if (citizenCardNumber == null)
            throw new NullPointerException("Citizen Card Number cannot be null");
        if (StringUtils.isBlank(citizenCardNumber))
            throw new IllegalArgumentException("Citizen card number cannot be blank.");
        if ((!checkIfStringJustHaveNumbers(citizenCardNumber) || citizenCardNumber.length() != CITIZEN_CARD_DIGITS))
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
        if (nhsNumber == null)
            throw new NullPointerException("NHS number cannot be null");
        if (StringUtils.isBlank(nhsNumber))
            throw new IllegalArgumentException("NHS number cannot be blank.");
        if ((!checkIfStringJustHaveNumbers(nhsNumber) || nhsNumber.length() != NHSTIN_NUMBER_DIGITS))
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
            throw new NullPointerException("TIN number cannot be null");
        if (StringUtils.isBlank(tinNumber))
            throw new IllegalArgumentException("TIN number cannot be blank.");
        if ((!checkIfStringJustHaveNumbers(tinNumber) || tinNumber.length() != NHSTIN_NUMBER_DIGITS))
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
            throw new NullPointerException("Birth date cannot be null");
        if (StringUtils.isBlank(birthDate))
            throw new IllegalArgumentException("Data cannot be blank.");

        if (!(checkBirthDateRules(birthDate)))
            throw new IllegalArgumentException("The date of birth provided is in an incorrect format. Correct format: DD/MM/YYYY");

        if (calculateAge(convertStringToDate(birthDate), date) >= MAX_AGE)
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
            throw new NullPointerException("Sex cannot be null");
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
        if (phoneNumber == null)
            throw new NullPointerException("Phone number cannot be null");
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if (!(checkIfStringJustHaveNumbers(phoneNumber)) || phoneNumber.length() != PHONE_NUMBER_DIGITS)
            throw new IllegalArgumentException("Phone number must have 11 digit numbers.");
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
            throw new NullPointerException("Email cannot be null");
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Email cannot be blank.");
        if (!isValidEmail(email))
            throw new IllegalArgumentException("The introduced email is not valid.");
        this.email = email;
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
                && Objects.equals(name, client.name)
                && Objects.equals(citizenCardNumber, client.citizenCardNumber)
                && Objects.equals(nhsNumber, client.nhsNumber)
                && Objects.equals(tinNumber, client.tinNumber)
                && Objects.equals(email, client.email);
    }
}
