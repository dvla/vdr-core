package uk.gov.dvla.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Property;

import java.lang.String;
import java.util.Date;

@Embedded
public class DeathDetails {

    private Date date;
    private @Property("vlDeathDateCode") String verificationLevelDeathDateCode;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVerificationLevelDeathDateCode() {
        return verificationLevelDeathDateCode;
    }

    public void setVerificationLevelDeathDateCode(String verificationLevelDeathDateCode) {
        this.verificationLevelDeathDateCode = verificationLevelDeathDateCode;
    }
}
