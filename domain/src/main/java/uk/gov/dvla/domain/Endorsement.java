package uk.gov.dvla.domain;

import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;

@Embedded
public class Endorsement {

    public Number id;
    @Property("disqual")
    public Boolean isDisqualification;
    //Both Penalty Points AND Disqualifications
    @Property("code")
    public String offenceCode;
    @Property("court")
    public String convictingCourtCode;
    @Property("offDate")
    public Date offenceDate;
    @Property("expDate")
    public Date expiryDate;
    @Property("removed")
    public Date removedFromLicence;
    //Disqualification Only
    @Property("conviction")
    public Date convictionDate;
    @Property("sentencing")
    public Date sentencingDate;
    public String disqualificationDuration;
    public Number fine;
    public String fineCurrency;
    public String rehabilitated;
    //Penalty Points Only
    @Property("noPoints")
    public Integer numberOfPoints;
    public OtherSentence otherSentence;

    public String alcoholLevel;
    public String alcoholTestType;
    public String appealCourtCode;
    public String sentencingCourtCode;
    @Property("susPrisonSentenceDur")
    public String suspendedPrisonSentenceDuration;

    @Property("disqualReimp")
    public Date disqualificationReimposed;
    @Property("disqualRemov")
    public Date disqualificationRemoved;
    @Property("disqualSusPA")
    public Date disqualificationSuspendedPendingAppeal;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

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

    public String getDisqualificationDuration() {
        return disqualificationDuration;
    }

    public void setDisqualificationDuration(String disqualificationDuration) {
        this.disqualificationDuration = disqualificationDuration;
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

    public String getFineCurrency() {
        return fineCurrency;
    }

    public void setFineCurrency(String fineCurrency) {
        this.fineCurrency = fineCurrency;
    }

    public String getRehabilitated() {
        return rehabilitated;
    }

    public void setRehabilitated(String rehabilitated) {
        this.rehabilitated = rehabilitated;
    }

    public String getAlcoholLevel() {
        return alcoholLevel;
    }

    public void setAlcoholLevel(String alcoholLevel) {
        this.alcoholLevel = alcoholLevel;
    }

    public String getAlcoholTestType() {
        return alcoholTestType;
    }

    public void setAlcoholTestType(String alcoholTestType) {
        this.alcoholTestType = alcoholTestType;
    }

    public String getAppealCourtCode() {
        return appealCourtCode;
    }

    public void setAppealCourtCode(String appealCourtCode) {
        this.appealCourtCode = appealCourtCode;
    }

    public String getSentencingCourtCode() {
        return sentencingCourtCode;
    }

    public void setSentencingCourtCode(String sentencingCourtCode) {
        this.sentencingCourtCode = sentencingCourtCode;
    }

    public String getSuspendedPrisonSentenceDuration() {
        return suspendedPrisonSentenceDuration;
    }

    public void setSuspendedPrisonSentenceDuration(String suspendedPrisonSentenceDuration) {
        this.suspendedPrisonSentenceDuration = suspendedPrisonSentenceDuration;
    }

    public Date getDisqualificationReimposed() {
        return disqualificationReimposed;
    }

    public void setDisqualificationReimposed(Date disqualificationReimposed) {
        this.disqualificationReimposed = disqualificationReimposed;
    }

    public Date getDisqualificationRemoved() {
        return disqualificationRemoved;
    }

    public void setDisqualificationRemoved(Date disqualificationRemoved) {
        this.disqualificationRemoved = disqualificationRemoved;
    }

    public Date getDisqualificationSuspendedPendingAppeal() {
        return disqualificationSuspendedPendingAppeal;
    }

    public void setDisqualificationSuspendedPendingAppeal(Date disqualificationSuspendedPendingAppeal) {
        this.disqualificationSuspendedPendingAppeal = disqualificationSuspendedPendingAppeal;
    }
}

