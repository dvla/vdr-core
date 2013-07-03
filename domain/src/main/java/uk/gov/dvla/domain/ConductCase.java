package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

@Embedded
public class ConductCase {

    private Date decisionDate;
    private String letterType;
    private String letter;
    private String LGVAppealResult;
    private String LGVOutcome;
    private Date LGVRevocationValidFrom;
    private Date LGVRevocationValidTo;
    private String PCVAppealResult;
    private String PCVOutcome;
    private Date PCVRevocationValidFrom;
    private Date PCVRevocationValidTo;
    private String publicEnquiryStatusType;
    private Date startDate;
    private String statusType;
    private Integer TAOPartyID;
    private List<ConductCaseEvent> events;

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getLetterType() {
        return letterType;
    }

    public void setLetterType(String letterType) {
        this.letterType = letterType;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLGVAppealResult() {
        return LGVAppealResult;
    }

    public void setLGVAppealResult(String LGVAppealResult) {
        this.LGVAppealResult = LGVAppealResult;
    }

    public String getLGVOutcome() {
        return LGVOutcome;
    }

    public void setLGVOutcome(String LGVOutcome) {
        this.LGVOutcome = LGVOutcome;
    }

    public Date getLGVRevocationValidFrom() {
        return LGVRevocationValidFrom;
    }

    public void setLGVRevocationValidFrom(Date LGVRevocationValidFrom) {
        this.LGVRevocationValidFrom = LGVRevocationValidFrom;
    }

    public Date getLGVRevocationValidTo() {
        return LGVRevocationValidTo;
    }

    public void setLGVRevocationValidTo(Date LGVRevocationValidTo) {
        this.LGVRevocationValidTo = LGVRevocationValidTo;
    }

    public String getPCVAppealResult() {
        return PCVAppealResult;
    }

    public void setPCVAppealResult(String PCVAppealResult) {
        this.PCVAppealResult = PCVAppealResult;
    }

    public String getPCVOutcome() {
        return PCVOutcome;
    }

    public void setPCVOutcome(String PCVOutcome) {
        this.PCVOutcome = PCVOutcome;
    }

    public Date getPCVRevocationValidFrom() {
        return PCVRevocationValidFrom;
    }

    public void setPCVRevocationValidFrom(Date PCVRevocationValidFrom) {
        this.PCVRevocationValidFrom = PCVRevocationValidFrom;
    }

    public Date getPCVRevocationValidTo() {
        return PCVRevocationValidTo;
    }

    public void setPCVRevocationValidTo(Date PCVRevocationValidTo) {
        this.PCVRevocationValidTo = PCVRevocationValidTo;
    }

    public String getPublicEnquiryStatusType() {
        return publicEnquiryStatusType;
    }

    public void setPublicEnquiryStatusType(String publicEnquiryStatusType) {
        this.publicEnquiryStatusType = publicEnquiryStatusType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Integer getTAOPartyID() {
        return TAOPartyID;
    }

    public void setTAOPartyID(Integer TAOPartyID) {
        this.TAOPartyID = TAOPartyID;
    }

    public List<ConductCaseEvent> getEvents() {
        return events;
    }

    public void setEvents(List<ConductCaseEvent> events) {
        this.events = events;
    }
}
