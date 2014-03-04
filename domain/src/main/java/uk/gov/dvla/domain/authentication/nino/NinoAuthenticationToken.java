package uk.gov.dvla.domain.authentication.nino;

import uk.gov.dvla.domain.authentication.DriverAuthToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NinoAuthenticationToken extends DriverAuthToken {
    private String nino;
    private String deceasedIndicator;
    private String coreMatchIndicator;
    private String addressMatchIndicator;

    private String secretMatchIndicator;


    private static final String yes = "Y";
    private static final String no = "N";

    public NinoAuthenticationToken() {
    }

    public NinoAuthenticationToken(String dln, String postcode, String nino, Date dob, String surname, String forename1, String forename2, int gender) {

        this.dln = dln;
        this.postCode = postcode;
        this.nino = nino;
        this.dob = dob;
        this.surname = surname;
        this.forename1 = forename1;
        this.forename2 = forename2;
        this.gender = gender;

    }

    public NinoAuthenticationToken(String dln, String postcode, String nino, Date dob, String surname,
                                   String deceasedIndicator, String coreMatchIndicator, List<String> warningCodes) {

        this.dln = dln;
        this.postCode = postcode;
        this.nino = nino;
        this.dob = dob;
        this.surname = surname;
        this.deceasedIndicator = deceasedIndicator;
        this.coreMatchIndicator = coreMatchIndicator;

    }

    public NinoAuthenticationToken(DriverAuthToken driverAuthToken) {
        this(driverAuthToken.getDln(), driverAuthToken.getPostCode(), null, driverAuthToken.getDob(), driverAuthToken.getSurname(), driverAuthToken.getForename1(), driverAuthToken.getForename2(), driverAuthToken.getGender());
    }

    public String getNino() {
        return nino;
    }

    public void setNino(String nino) {
        this.nino = nino;
    }

    public String getDeceasedIndicator() {
        return deceasedIndicator;
    }

    public void setDeceasedIndicator(String deceasedIndicator) {
        this.deceasedIndicator = deceasedIndicator;
    }

    public String getCoreMatchIndicator() {
        return coreMatchIndicator;
    }

    public void setCoreMatchIndicator(String coreMatchIndicator) {
        this.coreMatchIndicator = coreMatchIndicator;
    }

    public boolean isNotDeceased() {
        return isNullOrNullLiteral(getDeceasedIndicator()) || getDeceasedIndicator().equalsIgnoreCase(no);
    }

    public boolean isCoreMatch() {
        return isNullOrNullLiteral(getCoreMatchIndicator()) || getCoreMatchIndicator().equalsIgnoreCase(yes);
    }

    public String getAddressMatchIndicator() {
        return addressMatchIndicator;
    }

    public void setAddressMatchIndicator(String addressMatchIndicator) {
        this.addressMatchIndicator = addressMatchIndicator;
    }

    private static boolean isNullOrNullLiteral(String indicator) {
        return indicator == null || indicator.equalsIgnoreCase("null");
    }

}


