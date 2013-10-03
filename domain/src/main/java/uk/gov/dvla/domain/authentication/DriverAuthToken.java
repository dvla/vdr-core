package uk.gov.dvla.domain.authentication;

import uk.gov.dvla.domain.Driver;

import java.util.Date;

public class DriverAuthToken extends AuthenticationToken {
    protected String dln;
    protected String postcode;
    protected Date dob;
    protected String surname;

    public String getDln() {
        return dln;
    }

    public void setDln(String dln) {
        this.dln = dln;
    }

    public String getPostCode() {
        return postcode;
    }

    public void setPostCode(String postcode) {
        this.postcode = postcode;
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

    public static DriverAuthToken fromDriver(Driver driver) {
        DriverAuthToken driverAuthToken = new DriverAuthToken();
        driverAuthToken.setDln(driver.getCurrentDriverNumber());
        driverAuthToken.setDob(driver.getBirthDetails().getDate());
        driverAuthToken.setPostCode(driver.getAddress().getPostCode());
        driverAuthToken.setSurname(driver.getName().getFamilyName());
        return driverAuthToken;
    }


    public boolean isValid() {
        return !(surname == null || dob == null || postcode == null || dln == null);
    }


}
