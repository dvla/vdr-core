package uk.gov.dvla.domain;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Number;
import java.lang.String;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Endorsement {

    public Integer id;
    public Boolean disqual;
    public String code;
    public String convictingCourt;
    public Date offence;
    public Date expires;
    public Date removed;
    public Date conviction;
    public Date sentencing;
    public String duration;
    public Double fine;
    public String fineCurrency;
    public String rehabilitated;
    public Integer noPoints;
    public OtherSentence otherSentence;
    public String alcoholLevel;
    public String alcoholTestType;
    public String appealCourt;
    public Date disqualReimp;
    public Date disqualRemov;
    public Date disqualSusPA;
    public String sentencingCourt;
    public String susPrisonSentenceDur;
    public Boolean nonEndorseableOffence;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getConvictingCourt() {
        return convictingCourt;
    }

    public void setConvictingCourt(String convictingCourt) {
        this.convictingCourt = convictingCourt;
    }

    public Date getOffence() {
        return offence;
    }

    public void setOffence(Date offence) {
        this.offence = offence;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
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

    public Integer getNoPoints() {
        return noPoints;
    }

    public void setNoPoints(Integer noPoints) {
        this.noPoints = noPoints;
    }

    public OtherSentence getOtherSentence() {
        return otherSentence;
    }

    public void setOtherSentence(OtherSentence otherSentence) {
        this.otherSentence = otherSentence;
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

    public String getAppealCourt() {
        return appealCourt;
    }

    public void setAppealCourt(String appealCourt) {
        this.appealCourt = appealCourt;
    }

    public Date getDisqualReimp() {
        return disqualReimp;
    }

    public void setDisqualReimp(Date disqualReimp) {
        this.disqualReimp = disqualReimp;
    }

    public Date getDisqualRemov() {
        return disqualRemov;
    }

    public void setDisqualRemov(Date disqualRemov) {
        this.disqualRemov = disqualRemov;
    }

    public Date getDisqualSusPA() {
        return disqualSusPA;
    }

    public void setDisqualSusPA(Date disqualSusPA) {
        this.disqualSusPA = disqualSusPA;
    }

    public String getSentencingCourt() {
        return sentencingCourt;
    }

    public void setSentencingCourt(String sentencingCourt) {
        this.sentencingCourt = sentencingCourt;
    }

    public String getSusPrisonSentenceDur() {
        return susPrisonSentenceDur;
    }

    public void setSusPrisonSentenceDur(String susPrisonSentenceDur) {
        this.susPrisonSentenceDur = susPrisonSentenceDur;
    }

    public Boolean getNonEndorseableOffence() {
        return nonEndorseableOffence;
    }

    public void setNonEndorseableOffence(Boolean nonEndorseableOffence) {
        this.nonEndorseableOffence = nonEndorseableOffence;
    }
}

