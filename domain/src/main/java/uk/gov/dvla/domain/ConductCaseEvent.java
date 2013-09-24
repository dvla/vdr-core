package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.util.Date;

@Embedded
public class ConductCaseEvent {

    private Date eventDate;
    private String eventType;
    private String nonEndorseableOffence;

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getNonEndorseableOffence() {
        return nonEndorseableOffence;
    }

    public void setNonEndorseableOffence(String nonEndorseableOffence) {
        this.nonEndorseableOffence = nonEndorseableOffence;
    }
}
