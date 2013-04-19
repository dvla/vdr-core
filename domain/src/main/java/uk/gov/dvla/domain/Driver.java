package uk.gov.dvla.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.annotations.Property;

@Entity(value = "drivers", noClassnameStored = true)
public class Driver extends Person {

    private List<DriverNumber> dlnHistory;
    private List<DriverFlag> flag;
    private List<Licence> licence;
    private List<Integer> stopMarker;
    private List<Integer> restrictionKey;
    private List<String> caseType;
    private List<String> errorCode;
    private Boolean endorsementAmountExcess;
    private Boolean carHireEnqPmt = null;
    private String statusCode = null;
    private Date photoExpiryDate;
    private List<String> disqualificationStatusCodes;
    private boolean nslInCorruptedRange;
    @Property("dln")
    @Indexed(unique = true)
    private String currentDriverNumber = null;

    public void addLicence(Licence lic) {
        if (null == licence) {
            licence = new ArrayList<Licence>();
        }
        licence.add(lic);
    }

    public void addStopMarker(Integer marker) {
        if (null == stopMarker) {
            stopMarker = new ArrayList<Integer>();
        }
        stopMarker.add(marker);
    }

    public void addRestrictionKey(Integer key) {
        if (null == restrictionKey) {
            restrictionKey = new ArrayList<Integer>();
        }
        restrictionKey.add(key);
    }

    public void addCaseType(String key) {
        if (null == caseType) {
            caseType = new ArrayList<String>();
        }
        caseType.add(key);
    }

    public void addErrorCode(String code) {
        if (null == errorCode) {
            errorCode = new ArrayList<String>();
        }
        errorCode.add(code);
    }

    public void setLicence(List<Licence> lics) {
        licence = lics;
    }

    public List<Licence> getLicence() {
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

    public void setCurrentDriverNumber(String dln) {
        this.currentDriverNumber = dln;
    }

    public String getCurrentDriverNumber() {
        return this.currentDriverNumber;
    }

    public List<DriverNumber> getDriverNumberHistory() {
        return dlnHistory;
    }

    public void setDriverNumberHistory(List<DriverNumber> driverNumber) {
        this.dlnHistory = driverNumber;
    }

    public List<DriverFlag> getFlag() {
        return flag;
    }

    public void setFlag(List<DriverFlag> flag) {
        this.flag = flag;
    }

    public Boolean getCarHireEnqPmt() {
        return carHireEnqPmt;
    }

    public void setCarHireEnqPmt(Boolean carHireEnqPmt) {
        this.carHireEnqPmt = carHireEnqPmt;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Date getPhotoExpiryDate() {
        return photoExpiryDate;
    }

    public void setPhotoExpiryDate(Date photoExpiryDate) {
        this.photoExpiryDate = photoExpiryDate;
    }

    public List<String> getDisqualificationStatusCodes() {
        return disqualificationStatusCodes;
    }

    public void setDisqualificationStatusCodes(List<String> disqualificationStatusCodes) {
        this.disqualificationStatusCodes = disqualificationStatusCodes;
    }

    public Boolean getNslInCorruptedRange() {
        return nslInCorruptedRange;
    }

    public void setNslInCorruptedRange(Boolean nslInCorruptedRange) {
        this.nslInCorruptedRange = nslInCorruptedRange;
    }

    public Boolean getEndorsementAmountExcess() {
        return endorsementAmountExcess;
    }

    public void setEndorsementAmountExcess(Boolean endorsmentAmountExcess) {
        this.endorsementAmountExcess = endorsmentAmountExcess;
    }
}
