package uk.gov.dvla.domain.portal;

import uk.gov.dvla.domain.mib.EntitlementType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class portalDTO {

    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public static class Driver {
        private String currentDriverNumber;
        private Name name;
        private Licence licence;
        private Integer gender;

        public Licence getLicence() {
            return this.licence;
        }

        public void setLicence(Licence licence) {
            this.licence = licence;
        }
    }

    public static class Person {
        private Name name;
        private Address address;
    }

    public static class Name {
        private String title = null;
        private List<String> givenName = null;
        private String familyName = null;

        public void addGivenName(String gn) {
            if (null == givenName) {
                givenName = new ArrayList<String>();
            }
            givenName.add(gn);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getGivenName() {
            return givenName;
        }

        public void setGivenName(List<String> givenName) {
            this.givenName = givenName;
        }

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }
    }

    public static class Address {

        private String buildingName;
        private String ddtfare;
        private String postTown;
        private String postCode;
        private String type;
        private List<String> uLine;
        private String uPostCode;

        public String getBuildingName() {
            return buildingName;
        }

        public void setBuildingName(String buildingName) {
            this.buildingName = buildingName;
        }

        public String getDdtfare() {
            return ddtfare;
        }

        public void setDdtfare(String ddtfare) {
            this.ddtfare = ddtfare;
        }

        public String getPostTown() {
            return postTown;
        }

        public void setPostTown(String postTown) {
            this.postTown = postTown;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<String> getuLine() {
            return uLine;
        }

        public void setuLine(List<String> uLine) {
            this.uLine = uLine;
        }

        public String getuPostCode() {
            return uPostCode;
        }

        public void setuPostCode(String uPostCode) {
            this.uPostCode = uPostCode;
        }
    }

    public static class BirthDetails {
        private Date date;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }

    public static class Licence {

        private Date validFrom;
        private Date validTo;
        private Integer directiveStatus;
        private List<Entitlement> entitlements;
        private List<Endorsement> endorsements;

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

