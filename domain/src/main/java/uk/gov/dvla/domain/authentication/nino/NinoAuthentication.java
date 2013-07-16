package uk.gov.dvla.domain.authentication.nino;

import uk.gov.dvla.domain.authentication.Authentication;

import java.util.Date;

public class NinoAuthentication extends Authentication
{
    private String dln;
    private String postcode;
    private String nino;
    private Date dob;
    private String surname;

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
}
