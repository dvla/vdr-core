package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.lang.Integer;
import java.lang.Number;
import java.lang.String;
import java.util.Date;

@Embedded
public class DriverQualificationCard {
    private Number communityCode;
    private Number dispatchedToAddressID;
    private Integer photoImageID;
    private String reasonRequested;
    private Integer signatureImageID;
    private Integer driverNumber;
    private String firstName;
    private String surname;
    private Date dob;
    private String birthPlace;

    public Number getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(Number communityCode) {
        this.communityCode = communityCode;
    }

    public Number getDispatchedToAddressID() {
        return dispatchedToAddressID;
    }

    public void setDispatchedToAddressID(Number dispatchedToAddressID) {
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

    public Integer getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Integer driverNumber) {
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
