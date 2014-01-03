package uk.gov.dvla.domain;

import org.mongodb.morphia.annotations.Embedded;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

@Embedded
public class Disqualification {

    private Date disqDate;
    private Date disqFromDate;
    private Date disqToDate;
    private Boolean forLife;
    private Integer endorsementID;
    private Boolean concurrent;
    private String type;
    private Date validFrom;
    private Date validTo;

    public Date getDisqDate() {
        return disqDate;
    }

    public void setDisqDate(Date disqDate) {
        this.disqDate = disqDate;
    }

    public Date getDisqFromDate() {
        return disqFromDate;
    }

    public void setDisqFromDate(Date disqFromDate) {
        this.disqFromDate = disqFromDate;
    }

    public Date getDisqToDate() {
        return disqToDate;
    }

    public void setDisqToDate(Date disqToDate) {
        this.disqToDate = disqToDate;
    }

    public Boolean getForLife() {
        return forLife;
    }

    public void setForLife(Boolean forLife) {
        this.forLife = forLife;
    }

    public Integer getEndorsementID() {
        return endorsementID;
    }

    public void setEndorsementID(Integer endorsementID) {
        this.endorsementID = endorsementID;
    }

    public Boolean getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(Boolean concurrent) {
        this.concurrent = concurrent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }
}
