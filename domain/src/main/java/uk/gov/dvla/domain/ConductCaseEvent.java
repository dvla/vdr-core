package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.util.Date;

@Embedded
public class ConductCaseEvent {

    private Date date;
    private String type;
    private String nonEndorseableOffence;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNonEndorseableOffence() {
        return nonEndorseableOffence;
    }

    public void setNonEndorseableOffence(String nonEndorseableOffence) {
        this.nonEndorseableOffence = nonEndorseableOffence;
    }
}
