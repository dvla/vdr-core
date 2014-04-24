package uk.gov.dvla.domain;

import org.mongodb.morphia.annotations.Embedded;

import java.lang.Integer;
import java.lang.Number;
import java.lang.String;
import java.util.Date;

@Embedded
public class DriverQualificationCard {
    private Integer communityCode;
    private Integer dispatchedToAddressID;
    private Integer photoImageID;
    private String reasonRequested;
    private Integer signatureImageID;
    private String driverNumber;
    private String firstName;
    private String surname;
    private Date dob;
    private String birthPlace;

    public Integer getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(Integer communityCode) {
        this.communityCode = communityCode;
    }

    public Number getDispatchedToAddressID() { //TODO: Why is this a number, not an Integer?
        return dispatchedToAddressID;
    }

    public void setDispatchedToAddressID(Integer dispatchedToAddressID) {
        this.dispatchedToAddressID = dispatchedToAddressID;
    }

    public Integer getPhotoImageID() {
        return photoImageID;
    }

    public void setPhotoImageID(Integer photoImageID) {
        this.photoImageID = photoImageID;
    }

    public String getReasonRequested() {
        return reasonRequested;
    }

    public void setReasonRequested(String reasonRequested) {
        this.reasonRequested = reasonRequested;
    }

    public Integer getSignatureImageID() {
        return signatureImageID;
    }

    public void setSignatureImageID(Integer signatureImageID) {
        this.signatureImageID = signatureImageID;
    }

    public String getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(String driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
}
