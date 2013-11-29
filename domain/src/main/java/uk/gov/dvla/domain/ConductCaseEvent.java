package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.util.Date;

@Embedded
public class ConductCaseEvent {

    private Date eventDate;
    private String eventType;
    private String nonEndorsableOffence;

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

    public String getNonEndorsableOffence() {
        return nonEndorsableOffence;
    }

    public void setNonEndorsableOffence(String nonEndorsableOffence) {
        this.nonEndorsableOffence = nonEndorsableOffence;
    }
}
