package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;

import java.lang.String;
import java.util.Date;

@Embedded
public class DeathDetails {

    private Date date;
    private @Property("vlDeathDateCode") String verificationLevelDeathDateCode;
    private @Property("vlDeathDateName") String verificationLevelDeathDateName;

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

    public String getVerificationLevelDeathDateName() {
        return verificationLevelDeathDateName;
    }

    public void setVerificationLevelDeathDateName(String verificationLevelDeathDateName) {
        this.verificationLevelDeathDateName = verificationLevelDeathDateName;
    }
}
