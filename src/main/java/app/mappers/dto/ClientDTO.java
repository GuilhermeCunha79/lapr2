package app.mappers.dto;

public class ClientDTO {
    private String name;
    private String citizenCardNumber;
    private String nhsNumber;
    private String tinNumber;
    private String birthDate;
    private String sex;
    private String phoneNumber;
    private String email;

    public static  String SEX_BY_OMISSION = "Not defined";

    public ClientDTO(String name, String citizenCardNumber, String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email) {
        this.name=name;
        this.citizenCardNumber=citizenCardNumber;
        this.nhsNumber=nhsNumber;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.sex=sex;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    public ClientDTO(String name, String citizenCardNumber, String nhsNumber, String tinNumber, String birthDate, String phoneNumber, String email) {
        this.name=name;
        this.citizenCardNumber=citizenCardNumber;
        this.nhsNumber=nhsNumber;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.sex=SEX_BY_OMISSION;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }



    /***
     * Method that returns the name of the Client
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /***
     * Method that returns the citizen card number of the Client
     * @return citizenCardNumber
     */
    public String getCitizenCardNumber() {
        return this.citizenCardNumber;
    }

    /***
     * Method that returns the nhs number of the Client
     * @return nhsNumber
     */
    public String getNhsNumber() {
        return this.nhsNumber;
    }

    /***
     * Method that returns the tin number of the Client
     * @return tinNumber
     */
    public String getTinNumber() {
        return this.tinNumber;
    }

    /***
     * Method that returns the birth date of the Client
     * @return birthDate
     */
    public String getBirthDate() {
        return this.birthDate;
    }

    /***
     * Method that returns the sex of the Client
     * @return sex
     */
    public String getSex() {
        return this.sex;
    }

    /***
     * Method that returns the phone number of the Client
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /***
     * Method that returns the email of the Client
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return String.format("Client:%nName: %s%nCitizen Card Number: %s%nNHS number: %s%nTIN number: %s%nBirth date: %s%nSex: %s%nPhone number: %s%nEmail: %s",
                this.name, this.citizenCardNumber, this.nhsNumber, this.tinNumber, this.birthDate, this.sex, this.phoneNumber, this.email);
    }
}
