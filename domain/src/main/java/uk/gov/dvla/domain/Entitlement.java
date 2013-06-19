package uk.gov.dvla.domain;

import java.util.Date;
import java.util.List;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;

@Embedded
public class Entitlement {

    private String code;
    private Date validFrom;
    private Date validTo;
    private Date datePassed;

    @Property("provisional")
    private Boolean isProvisional = null;
    private Boolean isPriorTo = null;
    private Boolean isStated = null;
    private List<EntitlementRestriction> restrictions;

    // TODO - This should be removed when the TestPass class has been created
    private Integer unclaimedTestPass = 0;

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

    public Integer getUnclaimedTestPass() {
        return unclaimedTestPass;
    }

    public void setUnclaimedTestPass(Integer unclaimedTestPass) {
        this.unclaimedTestPass = unclaimedTestPass;
    }
}
