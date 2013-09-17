package uk.gov.dvla.domain.mib;

import java.util.Date;
import java.util.List;

public class MibDTO {

    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public static class Driver {

        private Licence licence;

        public Licence getLicence() {
            return this.licence;
        }

        public void setLicence(Licence licence) {
            this.licence = licence;
        }
    }

    public static class Licence {

        private String status;
        private Date validFrom;
        private Date validTo;
        private Integer directiveStatus;
        private List<Entitlement> entitlements;
        private List<Endorsement> endorsements;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

    public static class Entitlement {

        private String code;
        private Date validFrom;
        private Date validTo;
        private Boolean priorTo;
        private EntitlementType type;
        private List<EntitlementRestriction> restrictions;

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

        public Boolean getPriorTo() {
            return priorTo;
        }

        public void setPriorTo(Boolean priorTo) {
            this.priorTo = priorTo;
        }

        public EntitlementType getType() {
            return type;
        }

        public void setType(EntitlementType entitlementType) {
            this.type = entitlementType;
        }

        public List<EntitlementRestriction> getRestrictions() {
            return restrictions;
        }

        public void setRestrictions(List<EntitlementRestriction> restrictions) {
            this.restrictions = restrictions;
        }
    }

    public static class Endorsement {

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

    public static class EntitlementRestriction {

        private String type;
        private String info;

        public EntitlementRestriction() {
        }

        public EntitlementRestriction(String type, String info) {
            this.type = type;
            this.info = info;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}