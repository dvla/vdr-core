package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Embedded
public class EntitlementRestriction {

    private String restrictionType;
    private String text;
    private Date validFrom;
    private Date validTo;
    private String categoryCodes;

    public EntitlementRestriction() {
    }

    public EntitlementRestriction(String restrictionType, String categoryCodes) {
        if (restrictionType == null) {
            throw new RuntimeException("restrictionType must be specified");
        }
        
        this.restrictionType = restrictionType;
        this.categoryCodes = categoryCodes;

    }

    public String getRestrictionType() {
        return restrictionType;
    }

    public void setRestrictionType(String restrictionType) {
        this.restrictionType = restrictionType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getCategoryCodes() {
        return categoryCodes;
    }

    public void setCategoryCodes(String categoryCodes) {
        this.categoryCodes = categoryCodes;
    }
}
