package uk.gov.dvla.domain;

import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Property;

@Embedded
public class Licence {

    public Date validFrom;
    public Date validTo;
    public Integer directiveStatus;
    private @Property("avpStartDate") Date administrativeValidityPeriodStartDate;
    private Date cardExpiryDate;
    private Integer numEndorsements;
    private Date originalPhotoExpiryDate;
    private Date photoExpiryDate;
    private String regimeType;
    private String currentIssueNum;
    private List<Entitlement> entitlements;
    private List<Endorsement> endorsements;
    private List<LicenceInformation> information;
    private List<LicenceToken> tokens;

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

    public Integer getDirectiveStatus() {
        return directiveStatus;
    }

    public void setDirectiveStatus(Integer directiveStatus) {
        this.directiveStatus = directiveStatus;
    }

    public Date getAdministrativeValidityPeriodStartDate() {
        return administrativeValidityPeriodStartDate;
    }

    public void setAdministrativeValidityPeriodStartDate(Date administrativeValidityPeriodStartDate) {
        this.administrativeValidityPeriodStartDate = administrativeValidityPeriodStartDate;
    }

    public Date getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(Date cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public Integer getNumEndorsements() {
        return numEndorsements;
    }

    public void setNumEndorsements(Integer numEndorsements) {
        this.numEndorsements = numEndorsements;
    }

    public Date getOriginalPhotoExpiryDate() {
        return originalPhotoExpiryDate;
    }

    public void setOriginalPhotoExpiryDate(Date originalPhotoExpiryDate) {
        this.originalPhotoExpiryDate = originalPhotoExpiryDate;
    }

    public Date getPhotoExpiryDate() {
        return photoExpiryDate;
    }

    public void setPhotoExpiryDate(Date photoExpiryDate) {
        this.photoExpiryDate = photoExpiryDate;
    }

    public String getRegimeType() {
        return regimeType;
    }

    public void setRegimeType(String regimeType) {
        this.regimeType = regimeType;
    }

    public String getCurrentIssueNum() {
        return currentIssueNum;
    }

    public void setCurrentIssueNum(String currentIssueNum) {
        this.currentIssueNum = currentIssueNum;
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

    public List<LicenceInformation> getInformation() {
        return information;
    }

    public void setInformation(List<LicenceInformation> information) {
        this.information = information;
    }

    public List<LicenceToken> getTokens() {
        return tokens;
    }

    public void setTokens(List<LicenceToken> tokens) {
        this.tokens = tokens;
    }
}
