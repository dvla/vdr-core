package uk.gov.dvla.domain.mib;

import com.fasterxml.jackson.annotation.JsonProperty;

import uk.gov.dvla.domain.EntitlementRestriction;
import uk.gov.dvla.domain.EntitlementType;
import uk.gov.dvla.domain.Message;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MibResponse {

//    private UUID requestId;
    private MibDriver driver;
//    private List<Message> messages;

    public MibResponse(){};

//    public MibResponse(UUID requestId, List<Message> messages)
//    {
//        this.requestId = requestId;
//        this.messages = messages;
//    }

    public MibDriver getDriver() {
        return driver;
    }

    public void setDriver(MibDriver driver) {
        this.driver = driver;
    }
//
//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }
//
//    public MibResponse(Driver driver) {
//        this.driver = new MibDriver(driver);
//    }

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
        private String status;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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
//
//        public MibLicence(){};
//
//        public MibLicence(Licence licence) {
//            validFrom = licence.getValidFrom();
//            validTo = licence.getValidTo();
//            status = null;  // TODO - US166
//            directiveStatus = licence.getDirectiveStatus();
//            entitlements = licence.getEntitlements()
//        }
//
//        private void setEntitlements(List<Entitlement> entitlements) {
//            for (Endorsement ent : entitlements) {
//                this.entitlements.add(new MibEntitlement(ent));
//            }
//        }
    }

    public class MibEntitlement {

        private String code;
        private Date validFrom;
        private Date validTo;
        private Boolean isProvisional;
        private List<MibRestriction> restrictions;
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

        public void setIsProvisional(Boolean isProvisional) {
            this.isProvisional = isProvisional;
        }

        public List<MibRestriction> getRestrictions() {
            return restrictions;
        }

        public void setRestrictions(List<MibRestriction> restrictions) {
            this.restrictions = restrictions;
        }

        public TestPassStatus getTestPassStatus() {
            return testPassStatus;
        }

        public void setTestPassStatus(TestPassStatus testPassStatus) {
            this.testPassStatus = testPassStatus;
        }

        public Date getDatePassed() {
            return datePassed;
        }

        public void setDatePassed(Date datePassed) {
            this.datePassed = datePassed;
        }
//
//        public MibEntitlement(){};
//
//        public MibLicence(Licence licence) {
//            validFrom = licence.getValidFrom();
//            validTo = licence.getValidTo();
//            status = null;  // TODO - US166
//            directiveStatus = licence.getDirectiveStatus();
//            entitlements = licence.getEntitlements()
//        }

        // Calculated field used to simplify data sent to the MIB
//        @JsonProperty("entitlementType")
//        public EntitlementType getEntitlementType() {
//            EntitlementType entitlementType = EntitlementType.Full;
//
//            if (isProvisional) {
//                if (testPassStatus == TestPassStatus.Unclaimed) {
//                    entitlementType = EntitlementType.UnclaimedTestPass;
//                }else {
//                    entitlementType = EntitlementType.Provisional;
//                }
//            }
//
//            return entitlementType;
//        }
    }

    public class MibEndorsement {

        private Boolean isDisqualification;
        private String offenceCode;
        private Date offenceDate;
        private Date convictionDate;
        private Date sentencingDate;
        private String period;
        private double fine;
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

        public double getFine() {
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

    public class MibRestriction {

        private String type;
        private String info;

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