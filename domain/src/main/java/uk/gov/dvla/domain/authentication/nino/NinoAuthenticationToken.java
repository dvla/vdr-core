package uk.gov.dvla.domain.authentication.nino;

import uk.gov.dvla.domain.authentication.AuthenticationToken;

import java.util.Date;

public class NinoAuthenticationToken extends AuthenticationToken
{
    private String dln;
    private String postcode;
    private String nino;
    private Date dob;
    private String surname;
    private Boolean isDeceased;
    private Boolean isCoreMatch;
    private Boolean hasWarning;

    public NinoAuthenticationToken() {}

    public NinoAuthenticationToken(String dln, String postcode, String nino, Date dob, String surname) {

        this.dln = dln;
        this.postcode = postcode;
        this.nino = nino;
        this.dob = dob;
        this.surname = surname;
    }

    public NinoAuthenticationToken(String dln, String postcode, String nino, Date dob, String surname,
                                    Boolean isDeceased, Boolean isCoreMatch, Boolean hasWarning) {

        this.dln = dln;
        this.postcode = postcode;
        this.nino = nino;
        this.dob = dob;
        this.surname = surname;
        this.isDeceased = isDeceased;
        this.isCoreMatch = isCoreMatch;
        this.hasWarning = hasWarning;
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

    public Boolean getIsDeceased() {
        return isDeceased;
    }

    public void setIsDeceased(Boolean isDeceased) {
        this.isDeceased = isDeceased;
    }

    public Boolean getIsCoreMatch() {
        return isCoreMatch;
    }

    public void setIsCoreMatch(Boolean isCoreMatch) {
        this.isCoreMatch = isCoreMatch;
    }

    public Boolean getHasWarning() {
        return hasWarning;
    }

    public void setHasWarning(Boolean hasWarning) {
        this.hasWarning = hasWarning;
    }
}
