package uk.gov.dvla.domain.mib;

import java.util.Date;
import java.util.List;

public class MibResponse {

    private MibDriver driver;

    public MibResponse(){};

    public MibDriver getDriver() {
        return driver;
    }

    public void setDriver(MibDriver driver) {
        this.driver = driver;
    }

    public static class MibDriver {

        private MibLicence licence;

        public MibLicence getLicence() {
            return this.licence;
        }

        public void setLicence(MibLicence licence) {
            this.licence = licence;
        }
    }

    public static class MibLicence {

        private Date validFrom;
        private Date validTo;
        private Integer directiveStatus;
        private List<MibEntitlement> entitlements;
        private List<MibEndorsement> endorsements;

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

        public List<MibEntitlement> getEntitlements() {
            return entitlements;
        }

        public void setEntitlements(List<MibEntitlement> entitlements) {
            this.entitlements = entitlements;
        }

        public List<MibEndorsement> getEndorsements() {
            return endorsements;
        }

        public void setEndorsements(List<MibEndorsement> endorsements) {
            this.endorsements = endorsements;
        }
    }

    public static class MibEntitlement {

        private String code;
        private Date validFrom;
        private Date validTo;
        private EntitlementType type;

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

        public EntitlementType getType() {
            return type;
        }

        public void setType(EntitlementType entitlementType) {
            this.type = entitlementType;
        }
    }

    public static class MibEndorsement {

        private String code;
        private Date offenceDate;
        private Date convictionDate;
        private Date sentencingDate;
        private Number fine;
        private Integer noOfPoints;
        private Boolean isDisqual;
        private String disqualPeriod;

        public Boolean getIsDisqual() {
            return isDisqual;
        }

        public void setIsDisqual(Boolean isDisqual) {
            this.isDisqual = isDisqual;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Date getOffenceDate() {
            return offenceDate;
        }

        public void setOffenceDate(Date offenceDate) {
            this.offenceDate = offenceDate;
        }

        public Date getConvictionDate() {
            return convictionDate;
        }

        public void setConvictionDate(Date convictionDate) {
            this.convictionDate = convictionDate;
        }

        public Date getSentencingDate() {
            return sentencingDate;
        }

        public void setSentencingDate(Date sentencingDate) {
            this.sentencingDate = sentencingDate;
        }

        public String getDisqualPeriod() {
            return disqualPeriod;
        }

        public void setDisqualPeriod(String disqualPeriod) {
            this.disqualPeriod = disqualPeriod;
        }

        public Number getFine() {
            return fine;
        }

        public void setFine(Number fine) {
            this.fine = fine;
        }

        public Integer getNoOfPoints() {
            return noOfPoints;
        }

        public void setNoOfPoints(Integer noOfPoints) {
            this.noOfPoints = noOfPoints;
        }
    }
}