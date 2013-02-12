package uk.gov.dvla.domain;

import java.util.Date;
import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Endorsement {

    public Boolean isDisqualification;
    //Both Penalty Points AND Disqualifications
    public String offenceCode;
    public String convictingCourtCode;
    public Date offenceDate;
    public Date expiryDate;
    public Date removedFromLicence;
    //Disqualification Only
    public Date convictionDate;
    public Date sentencingDate;
    public String period;
    public Number fine;
    //Penalty Points Only
    public Integer numberOfPoints;

    public Boolean getDisqualification() {
        return isDisqualification;
    }

    public void setDisqualification(Boolean disqualification) {
        isDisqualification = disqualification;
    }

    public String getOffenceCode() {
        return offenceCode;
    }

    public void setOffenceCode(String offenceCode) {
        this.offenceCode = offenceCode;
    }

    public String getConvictingCourtCode() {
        return convictingCourtCode;
    }

    public void setConvictingCourtCode(String convictingCourtCode) {
        this.convictingCourtCode = convictingCourtCode;
    }

    public Date getOffenceDate() {
        return offenceDate;
    }

    public void setOffenceDate(Date offenceDate) {
        this.offenceDate = offenceDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getRemovedFromLicence() {
        return removedFromLicence;
    }

    public void setRemovedFromLicence(Date removedFromLicence) {
        this.removedFromLicence = removedFromLicence;
    }

    public Date getConvictionDate() {
        return convictionDate;
    }

    public void setConvictionDate(Date convictionDate) {
        this.convictionDate = convictionDate;
    }

    public Date getSentencingDate() {
        return sentencingDate;
    }

    public void setSentencingDate(Date sentencingDate) {
        this.sentencingDate = sentencingDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Number getFine() {
        return fine;
    }

    public void setFine(Number fine) {
        this.fine = fine;
    }

    public Integer getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }
}

