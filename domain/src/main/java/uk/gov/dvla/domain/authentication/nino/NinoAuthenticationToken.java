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
    private List<String> warningCodes = new ArrayList<String>();


    private static final String yes = "Y";
    private static final String no = "N";

    public NinoAuthenticationToken() {
    }

    public NinoAuthenticationToken(String dln, String postcode, String nino, Date dob, String surname, String forename1, String forename2) {

        this.dln = dln;
        this.postCode = postcode;
        this.nino = nino;
        this.dob = dob;
        this.surname = surname;
        this.forename1 = forename1;
        this.forename2 = forename2;

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
        this.warningCodes = warningCodes;
    }

    public NinoAuthenticationToken(DriverAuthToken driverAuthToken) {
        this(driverAuthToken.getDln(), driverAuthToken.getPostCode(), null, driverAuthToken.getDob(), driverAuthToken.getSurname(), driverAuthToken.getForename1(), driverAuthToken.getForename2());
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

    public List<String> getWarningCodes() {
        return warningCodes;
    }

    public void setWarningCodes(List<String> warningCodes) {
        this.warningCodes = warningCodes;
    }

    public boolean isNotDeceased() {
        return isNullOrNullLiteral(getDeceasedIndicator()) || getDeceasedIndicator().equalsIgnoreCase(no);
    }

    public boolean isCoreMatch() {
        return isNullOrNullLiteral(getCoreMatchIndicator()) || getCoreMatchIndicator().equalsIgnoreCase(yes);
    }

    public boolean isAddressMatch() {
        return isNullOrNullLiteral(getAddressMatchIndicator()) || getAddressMatchIndicator().equalsIgnoreCase(yes);
    }

    public boolean hasNoWarningCodes() {
        return getWarningCodes() != null && getWarningCodes().isEmpty();
    }

    public String getAddressMatchIndicator() {
        return addressMatchIndicator;
    }

    public void setAddressMatchIndicator(String addressMatchIndicator) {
        this.addressMatchIndicator = addressMatchIndicator;
    }

    public String getSecretMatchIndicator() {
        return secretMatchIndicator;
    }

    public void setSecretMatchIndicator(String secretMatchIndicator) {
        this.secretMatchIndicator = secretMatchIndicator;
    }

    private static boolean isNullOrNullLiteral(String indicator) {
        return indicator == null || indicator.equalsIgnoreCase("null");
    }

}


