package uk.gov.dvla.domain;

import java.util.Date;
import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Endorsement {

    public Boolean isDisqualification;
    //Both Penalty Points AND Disqualifications
    public String offenceCode; // offenceCode
    public String convictingCourtCode; //convictingCourtCode
    public Date offenceDate; //offenceDate
    public Date expiryDate; //expiryDate
    public Date removedFromLicence; //removedFromLicence
    //Disqualification Only
    public Date convictionDate; // convictionDate
    public Date sentencingDate; // sentencingDate
    public String period;
    public double fine;
    //Penalty Points Only
    public Integer numberOfPoints; //numberOfPoints
    public OtherSentence otherSentence;

    public Boolean getDisqualification() {
        return isDisqualification;
    }

    public void setDisqualification(Boolean disqualification) {
        this.isDisqualification = disqualification;
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

    public void setFine(double fine) {
        this.fine = fine;
    }

    public Integer getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public OtherSentence getOtherSentence() {
        return otherSentence;
    }

    public void setOtherSentence(OtherSentence otherSentence){
        this.otherSentence = otherSentence;
    }
}

