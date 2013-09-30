package uk.gov.dvla.domain.authentication.nino;

import uk.gov.dvla.domain.authentication.AuthenticationToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NinoAuthenticationToken extends AuthenticationToken
{
    private String dln;
    private String postcode;
    private String nino;
    private Date dob;
    private String surname;
    private String deceasedIndicator;
    private String coreMatchIndicator;
    private List<String> warningCodes = new ArrayList<String>();

    public NinoAuthenticationToken() {}

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

    public String getDln() {
        return dln;
    }

    public void setDln(String dln) {
        this.dln = dln;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getNino() {
        return nino;
    }

    public void setNino(String nino) {
        this.nino = nino;
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

    @Override
    public String toString() {

        return String.format("Dln - %s, Postcode - %s, Nino - %s, DOB - %s, Surname - %s, " +
                                "IsDeceased - %s, IsCoreMatch - %s, Warning Codes - %s",
                                dln, postcode, nino, dob, surname, deceasedIndicator, coreMatchIndicator,
                                    warningCodes == null ? null : Arrays.toString(warningCodes.toArray()));
    }
}
