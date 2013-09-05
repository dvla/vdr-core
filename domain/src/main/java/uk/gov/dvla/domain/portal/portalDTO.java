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
        private BirthDetails birthDetails;

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
        private Date photoExpiryDate;


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

        public Date getPhotoExpiryDate() {
            return photoExpiryDate;
        }

        public void setPhotoExpiryDate(Date photoExpiryDate) {
            this.photoExpiryDate = photoExpiryDate;
        }
    }

    public static class Entitlement {

        private String code;
        private Date validFrom;
        private Date validTo;
        private Boolean provisional;
        private Boolean priorTo;
        private EntitlementType type;
        private List<EntitlementRestriction> restrictions;
        private Boolean vocational;

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

        public Boolean getProvisional() {
            return provisional;
        }

        public void setProvisional(Boolean provisional) {
            this.provisional = provisional;
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

        public Boolean getVocational() {
            return vocational;
        }

        public void setVocational(Boolean vocational) {
            this.vocational = vocational;
        }
    }

    public class Endorsement {

        public Integer id;
        public Boolean disqual;
        public String code;
        public String convictingCourt;
        public Date offence;
        public Date expires;
        public Date removed;
        public Date conviction;
        public Date sentencing;
        public String duration;
        public Double fine;
        public Integer noPoints;
        public OtherSentence otherSentence;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getDisqual() {
            return disqual;
        }

        public void setDisqual(Boolean disqual) {
            this.disqual = disqual;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getConvictingCourt() {
            return convictingCourt;
        }

        public void setConvictingCourt(String convictingCourt) {
            this.convictingCourt = convictingCourt;
        }

        public Date getOffence() {
            return offence;
        }

        public void setOffence(Date offence) {
            this.offence = offence;
        }

        public Date getExpires() {
            return expires;
        }

        public void setExpires(Date expires) {
            this.expires = expires;
        }

        public Date getRemoved() {
            return removed;
        }

        public void setRemoved(Date removed) {
            this.removed = removed;
        }

        public Date getConviction() {
            return conviction;
        }

        public void setConviction(Date conviction) {
            this.conviction = conviction;
        }

        public Date getSentencing() {
            return sentencing;
        }

        public void setSentencing(Date sentencing) {
            this.sentencing = sentencing;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public Double getFine() {
            return fine;
        }

        public void setFine(Double fine) {
            this.fine = fine;
        }

        public Integer getNoPoints() {
            return noPoints;
        }

        public void setNoPoints(Integer noPoints) {
            this.noPoints = noPoints;
        }

        public OtherSentence getOtherSentence() {
            return otherSentence;
        }

        public void setOtherSentence(OtherSentence otherSentence) {
            this.otherSentence = otherSentence;
        }
    }
    public static class OtherSentence {
        private String code;
        private String name;
        private String duration;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
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

