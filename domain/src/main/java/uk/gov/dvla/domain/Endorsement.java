package uk.gov.dvla.domain;

import java.util.Date;
import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Endorsement {

    public Boolean disqual;
    //Both Penalty Points AND Disqualifications
    public String code; // offenceCode
    public String court; //convictingCourtCode
    public Date offDate; //offenceDate
    public Date expDate; //expiryDate
    public Date removed; //removedFromLicence
    //Disqualification Only
    public Date conviction; // convictionDate
    public Date sentencing; // sentencingDate
    public String period;
    public double fine;
    //Penalty Points Only
    public Integer noPoints; //numberOfPoints
    public OtherSentence otherSentence;

    public Boolean getDisqual() {
        return disqual;
    }

    public void setDisqual(Boolean disqual) {
        this.disqual = disqual;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public Date getOffDate() {
        return offDate;
    }

    public void setOffDate(Date offDate) {
        this.offDate = offDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getRemoved() {
        return removed;
    }

    public void setRemoved(Date removed) {
        this.removed = removed;
    }

    public Date getConviction() {
        return conviction;
    }

    public void setConviction(Date conviction) {
        this.conviction = conviction;
    }

    public Date getSentencing() {
        return sentencing;
    }

    public void setSentencing(Date sentencing) {
        this.sentencing = sentencing;
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

    public Integer getNoPoints() {
        return noPoints;
    }

    public void setNoPoints(Integer noPoints) {
        this.noPoints = noPoints;
    }

    public OtherSentence getOtherSentence() {
        return otherSentence;
    }

    public void setOtherSentence(OtherSentence otherSentence){
        this.otherSentence = otherSentence;
    }
}

