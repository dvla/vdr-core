package uk.gov.dvla.domain.authentication;

import uk.gov.dvla.domain.Driver;

import java.util.Date;

public class DriverAuthToken extends AuthenticationToken {
    protected String dln;
    protected String postCode;
    protected Date dob;
    protected String surname;
    protected String forename1;
    protected String forename2;
    protected int gender;
    protected String[] address;


    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String getForename1() {
        return forename1;
    }

    public void setForename1(String forename1) {
        this.forename1 = forename1;
    }

    public String getForename2() {
        return forename2;
    }

    public void setForename2(String forename2) {
        this.forename2 = forename2;
    }

    public String getDln() {
        return dln;
    }

    public void setDln(String dln) {
        this.dln = dln;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postcode) {
        this.postCode = postcode;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public static DriverAuthToken fromDriver(Driver driver) {
        DriverAuthToken driverAuthToken = new DriverAuthToken();
        driverAuthToken.setDln(driver.getCurrentDriverNumber());
        driverAuthToken.setDob(driver.getBirthDetails().getDate());
        driverAuthToken.setPostCode(driver.getAddress().getPostCode());
        driverAuthToken.setSurname(driver.getName().getFamilyName());
        driverAuthToken.setForename1(driver.getName().getGivenName().get(0));
        if (driver.getName().getGivenName().size() > 1) {
            driverAuthToken.setForename1(driver.getName().getGivenName().get(1));
        }

        String[] addressArray = new String[1];

        addressArray[0] = driver.getAddress().getBuildingName() + driver.getAddress().getDdtfare();
        driverAuthToken.setAddress(addressArray);

        driverAuthToken.setGender(driver.getGender());
        return driverAuthToken;
    }


    public boolean isValid() {
        return !(surname == null || dob == null || postCode == null || dln == null);
    }
}
