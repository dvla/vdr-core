package uk.gov.dvla.domain.mib;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.dvla.domain.*;

import java.util.Date;
import java.util.List;

public class MibResponse {

    private MibDriver driver;
    private List<Message> messages;
    private String ruleApplied;

    public MibResponse(){};

    public MibResponse(Driver driver) {
        this.driver = new MibDriver(driver);
    }

    public class MibDriver {

        private MibLicence licence;
        private List<Integer> stopMarker;
        private List<Integer> restrictionKey;
        private List<String> caseType;
        private List<String> errorCode;
        private String statusCode = null;

        public MibDriver(){};

        public MibDriver(Driver driver) {
            licence = new MibLicence(driver.getLicence().get(0));
            stopMarker = driver.getStopMarker();
            restrictionKey = driver.getRestrictionKey();
            caseType = driver.getCaseType();
            errorCode = driver.getErrorCode();
        }

        public MibLicence getLicence() {
            return this.licence;
        }

        public List<Integer> getStopMarker() {
            return stopMarker;
        }

        public void setStopMarker(List<Integer> markers) {
            this.stopMarker = markers;
        }

        public List<Integer> getRestrictionKey() {
            return restrictionKey;
        }

        public void setRestrictionKey(List<Integer> keys) {
            this.restrictionKey = keys;
        }

        public List<String> getCaseType() {
            return this.caseType;
        }

        public void setCaseType(List<String> caseTypes) {
            this.caseType = caseTypes;
        }

        public List<String> getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(List<String> errorCodes) {
            this.errorCode = errorCodes;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }
    }

    public class MibLicence {

        public Date validFrom;
        public Date validTo;
        public String status;
        public Integer directiveStatus;
        private List<Entitlement> entitlements;
        private List<Endorsement> endorsements;

        public MibLicence(){};

        public MibLicence(Licence licence) {
//            this.driver = new MibDriver(driver);
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

    public class MibEntitlement {

        private String code;
        private Date validFrom;
        private Date validTo;
        private Boolean isProvisional = null;
        private List<EntitlementRestriction> restrictions;
        private TestPassStatus testPassStatus;
        private Date datePassed;

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

        public List<EntitlementRestriction> getRestrictions() {
            return restrictions;
        }

        public void setRestrictions(List<EntitlementRestriction> restrictions) {
            this.restrictions = restrictions;
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

    public class MibEndorsement {

        public Boolean isDisqualification;
        public String offenceCode;
        public Date offenceDate;

        //Disqualification Only
        public Date convictionDate;
        public Date sentencingDate;
        public String period;
        public double fine;

        //Penalty Points Only
        public Integer numberOfPoints;

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

        public void setFine(double fine) {
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