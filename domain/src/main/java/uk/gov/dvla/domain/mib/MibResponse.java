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

    public class MibDriver {

        private MibLicence licence;

        public MibLicence getLicence() {
            return this.licence;
        }

        public void setLicence(MibLicence licence) {
            this.licence = licence;
        }
    }

    public class MibLicence {

        private Date validFrom;
        private Date validTo;
        private Integer directiveStatus;
        private List<MibEntitlement> entitlements;
        private List<MibEndorsement> endorsements;

        public MibLicence(){};

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

    public class MibEntitlement {

        private String code;
        private Date validFrom;
        private Date validTo;
        private Boolean isProvisional;
        private EntitlementType entitlementType;

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

        public void setIsProvisional(Boolean isProvisional) {
            this.isProvisional = isProvisional;
        }

        public EntitlementType getEntitlementType() {
            return entitlementType;
        }

        public void setEntitlementType(EntitlementType entitlementType) {
            this.entitlementType = entitlementType;
        }
    }

    public class MibEndorsement {

        private Boolean isDisqualification;
        private String offenceCode;
        private Date offenceDate;
        private Date convictionDate;
        private Date sentencingDate;
        private String period;
        private Number fine;
        private Integer numberOfPoints;

        public Boolean getDisqualification() {
            return isDisqualification;
        }

        public void setDisqualification(Boolean disqualification) {
            isDisqualification = disqualification;
        }

        public String getOffenceCode() {
            return offenceCode;
        }

        public void setOffenceCode(String offenceCode) {
            this.offenceCode = offenceCode;
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

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public Number getFine() {
            return fine;
        }

        public void setFine(Number fine) {
            this.fine = fine;
        }

        public Integer getNumberOfPoints() {
            return numberOfPoints;
        }

        public void setNumberOfPoints(Integer numberOfPoints) {
            this.numberOfPoints = numberOfPoints;
        }
    }
}