package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.util.Date;

@Embedded
public class EntitlementStatus {

    private String code;
    private String name;
    private Date validFrom;
    private Date validTo;
    private Boolean priorTo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getPriorTo() {
        return priorTo;
    }

    public void setPriorTo(Boolean priorTo) {
        this.priorTo = priorTo;
    }
}
