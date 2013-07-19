package uk.gov.dvla.domain;

import java.lang.String;
import java.util.Date;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class DriverFlag {
	
	private String flag;
	private Date validFrom;
	private Date validTo;
	private boolean manual;
	private boolean caseType;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public boolean isCaseType() {
        return caseType;
    }

    public void setCaseType(boolean caseType) {
        this.caseType = caseType;
    }
}
