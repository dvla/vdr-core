package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;
import java.util.Date;

@Embedded
public class EntitlementRestriction {

    private String code;
    private String text;
    private Date validFrom;
    private Date validTo;
    private String categoryCode;

    public EntitlementRestriction() {
    }

    public EntitlementRestriction(String code, String categoryCode) {
        if (code == null) {
            throw new RuntimeException("code must be specified");
        }
        
        this.code = code;
        this.categoryCodes = categoryCodes;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
