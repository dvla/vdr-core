package uk.gov.dvla.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Property;

import java.lang.String;
import java.util.Date;

@Embedded
public class BirthDetails {
    private Date date;
    private Country country;
    private @Property("vlBirthDateCode") String verificationLevelBirthDateCode;
    private @Property("vlBirthDateName") String verificationLevelBirthDateName;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getVerificationLevelBirthDateCode() {
        return verificationLevelBirthDateCode;
    }

    public void setVerificationLevelBirthDateCode(String verificationLevelBirthDateCode) {
        this.verificationLevelBirthDateCode = verificationLevelBirthDateCode;
    }

    public String getVerificationLevelBirthDateName() {
        return verificationLevelBirthDateName;
    }

    public void setVerificationLevelBirthDateName(String verificationLevelBirthDateName) {
        this.verificationLevelBirthDateName = verificationLevelBirthDateName;
    }
}
