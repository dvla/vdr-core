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
    private List<String> categoryCodes;

    public EntitlementRestriction() {
    }

    public EntitlementRestriction(String restrictionType, List<String> categoryCodes) {
        if (restrictionType == null) {
            throw new RuntimeException("restrictionType must be specified");
        }
        
        this.restrictionType = restrictionType;
        if (categoryCodes == null) {
            this.categoryCodes = new ArrayList();
        } else {
            this.categoryCodes = categoryCodes;
        }

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

    public List<String> getCategoryCodes() {
        return categoryCodes;
    }

    public void setCategoryCodes(List<String> categoryCodes) {
        this.categoryCodes = categoryCodes;
    }
}
