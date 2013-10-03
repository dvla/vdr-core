package uk.gov.dvla.domain.authentication.nino;

import uk.gov.dvla.domain.authentication.DriverAuthToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NinoAuthenticationToken extends DriverAuthToken {
    private String nino;
    private String deceasedIndicator;
    private String coreMatchIndicator;
    private List<String> warningCodes = new ArrayList<String>();

    private static final String yes = "Y";
    private static final String no = "N";

    public NinoAuthenticationToken() {
    }

    public NinoAuthenticationToken(String dln, String postcode, String nino, Date dob, String surname) {

        this.dln = dln;
        this.postcode = postcode;
        this.nino = nino;
        this.dob = dob;
        this.surname = surname;
    }

    public NinoAuthenticationToken(String dln, String postcode, String nino, Date dob, String surname,
                                   String deceasedIndicator, String coreMatchIndicator, List<String> warningCodes) {

        this.dln = dln;
        this.postcode = postcode;
        this.nino = nino;
        this.dob = dob;
        this.surname = surname;
        this.deceasedIndicator = deceasedIndicator;
        this.coreMatchIndicator = coreMatchIndicator;
        this.warningCodes = warningCodes;
    }

    public NinoAuthenticationToken(DriverAuthToken driverAuthToken) {
        this(driverAuthToken.getDln(), driverAuthToken.getPostCode(), null, driverAuthToken.getDob(), driverAuthToken.getSurname());
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
        return getDeceasedIndicator() != null && getDeceasedIndicator().equalsIgnoreCase(no);
    }

    public boolean isCoreMatch() {
        return getCoreMatchIndicator() != null && getCoreMatchIndicator().equalsIgnoreCase(yes);
    }

    public boolean hasNoWarningCodes() {
        return getWarningCodes() != null && getWarningCodes().isEmpty();
    }
}


