package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.lang.String;
import java.util.Date;

@Embedded
public class EntitlementRestriction {

    private String code;
    private String text;
    private String categoryCode;
    private Date validTo;

    public EntitlementRestriction() {
    }

    public EntitlementRestriction(String code, String categoryCode) {
        if (code == null) {
            throw new RuntimeException("code must be specified");
        }
        
        this.code = code;
        this.categoryCode = categoryCode;

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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }
}
