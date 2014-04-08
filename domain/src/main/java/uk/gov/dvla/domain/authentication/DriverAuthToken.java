package uk.gov.dvla.domain.authentication;

import org.apache.commons.lang.StringUtils;
import uk.gov.dvla.domain.Address;
import uk.gov.dvla.domain.Driver;

import java.util.Date;

public class DriverAuthToken extends AuthenticationToken {
    private static final String UNSTRUCTURED_ADDRESS_MARKER = "UN";
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
        driverAuthToken.setGender(driver.getGender());
        driverAuthToken.setSurname(driver.getName().getFamilyName());
        driverAuthToken.setForename1(driver.getName().getGivenName().get(0));
        if (driver.getName().getGivenName().size() > 1) {
            driverAuthToken.setForename1(driver.getName().getGivenName().get(1));
        }

        Address address = driver.getAddress();

        if (address == null) {
            throw new NullPointerException("Address is missing from driver object");
        }

        String[] addressArray = new String[1];
        String postcode;
        if (isUnstructured(address)) {
            postcode = address
                    .getuPostCode();
            if (address.getuLine() == null || address.getuLine().size() == 0) {
                throw new NullPointerException("Address is unstructured but has no uLines set");
            }

            addressArray[0] = address
                    .getuLine()
                    .get(0);
        } else {
            postcode = address
                    .getPostCode();
            addressArray[0] = address.getBuildingName() + " " + address.getDdtfare();
        }
        driverAuthToken.setPostCode(postcode);
        driverAuthToken.setAddress(addressArray);


        return driverAuthToken;
    }

    public boolean isValid() {
        setIsValid(!(surname == null || dob == null || postCode == null || dln == null));
        return getIsValid();
    }

    private static boolean isUnstructured(Address address) {
        return StringUtils.equalsIgnoreCase(address.getType(), UNSTRUCTURED_ADDRESS_MARKER);
    }
}
