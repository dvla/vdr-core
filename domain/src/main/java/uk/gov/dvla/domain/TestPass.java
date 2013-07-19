package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;
import org.joda.time.DateTime;

import java.lang.Boolean;
import java.lang.String;
import java.util.Date;

@Embedded
public class TestPass implements Comparable<TestPass> {
    private String entitlementType;
    private String statusType;
    private Date testPassDate;
    private Boolean extended;
    private Boolean harmonised;
    private Boolean automatic;
    private Boolean lessThanEqual25kw;

    public Date getExpiryDate()
    {
        Integer unclaimedTestPassValidityInMonths = DomainConfiguration.getInstance().getUnclaimedTestPassValidity();
        if(getTestPassDate() != null)
        {
            return new DateTime(getTestPassDate()).plusMonths(unclaimedTestPassValidityInMonths).toDate();
        }
        else
        {
            return null;
        }

    }

    public int compareTo(TestPass other)
    {
        return this.getTestPassDate().compareTo(other.getTestPassDate());
    }

    public String getEntitlementType() {
        return entitlementType;
    }

    public void setEntitlementType(String entitlementType) {
        this.entitlementType = entitlementType;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Date getTestPassDate() {
        return testPassDate;
    }

    public void setTestPassDate(Date testPassDate) {
        this.testPassDate = testPassDate;
    }

    public Boolean getExtended() {
        return extended;
    }

    public void setExtended(Boolean extended) {
        this.extended = extended;
    }

    public Boolean getHarmonised() {
        return harmonised;
    }

    public void setHarmonised(Boolean harmonised) {
        this.harmonised = harmonised;
    }

    public Boolean getAutomatic() {
        return automatic;
    }

    public void setAutomatic(Boolean automatic) {
        this.automatic = automatic;
    }

    public Boolean getLessThanEqual25kw() {
        return lessThanEqual25kw;
    }

    public void setLessThanEqual25kw(Boolean lessThanEqual25kw) {
        this.lessThanEqual25kw = lessThanEqual25kw;
    }
}
