package uk.gov.dvla.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Licence {

    public Date validFrom;
    public Date validTo;
    public EntitlementType type;
    public Integer directiveStatus;
    public String issueNumber;
    private List<Entitlement> entitlements;
    private List<Endorsement> endorsements;

    public void addEntitlement(String code) {
        if (null == entitlements) {
            entitlements = new ArrayList<Entitlement>();
        }
        Entitlement ent = new Entitlement();
        ent.setCode(code);
        ent.setValidFrom(new Date());
        ent.setValidTo(new Date());
        entitlements.add(ent);
    }

    public void addEndorsement(Endorsement end) {
        if (null == endorsements) {
            endorsements = new ArrayList<Endorsement>();
        }
        endorsements.add(end);
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setDirectiveStatus(Integer directiveStatus) {
        this.directiveStatus = directiveStatus;
    }

    public Integer getDirectiveStatus() {
        return directiveStatus;
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

    public EntitlementType getType() {
        return type;
    }

    public void setType(EntitlementType type) {
        this.type = type;
    }

    public List<Entitlement> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(List<Entitlement> entitlements) {
        this.entitlements = entitlements;
    }

    public List<Endorsement> getEndorsements() {
        return endorsements;
    }

    public void setEndorsements(List<Endorsement> endorsements) {
        this.endorsements = endorsements;
    }
}
