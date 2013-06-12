package uk.gov.dvla.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Entitlement {

    private String code;
    private Date validFrom;
    private Date validTo;
    private Date datePassed;
    private Boolean isProvisional = null;
    private Boolean isPriorTo = null;
    private Boolean isStated = null;
    private List<EntitlementRestriction> restrictions;
    private TestPassStatus testPassStatus;

    public Date getDatePassed() {
        return datePassed;
    }

    public void setDatePassed(Date datePassed) {
        this.datePassed = datePassed;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Boolean getIsProvisional() {
        return isProvisional;
    }

    public void setIsProvisional(Boolean provisional) {
        this.isProvisional = provisional;
    }

    public Boolean getIsPriorTo() {
        return isPriorTo;
    }

    public void setIsPriorTo(Boolean priorTo) {
        this.isPriorTo = priorTo;
    }

    public Boolean getIsStated() {
        return isStated;
    }

    public void setIsStated(Boolean isStated) {
        this.isStated = isStated;
    }

    public List<EntitlementRestriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<EntitlementRestriction> restrictions) {
        this.restrictions = restrictions;
    }

    public TestPassStatus getTestPassStatus() {
        return this.testPassStatus;
    }

    public void setTestPassStatus(TestPassStatus testPassStatus) {
        this.testPassStatus = testPassStatus;
    }

    // Calculated field used to simplify data sent to the MIB
    @JsonProperty("entitlementType")
    public EntitlementType getEntitlementType() {
        EntitlementType entitlementType = EntitlementType.Full;

        if (isProvisional) {
            if (testPassStatus == TestPassStatus.Unclaimed) {
                entitlementType = EntitlementType.UnclaimedTestPass;
            }else {
                entitlementType = EntitlementType.Provisional;
            }
        }

        return entitlementType;
    }
}
