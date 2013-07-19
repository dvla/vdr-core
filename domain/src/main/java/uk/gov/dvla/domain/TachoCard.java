package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.lang.Integer;
import java.lang.String;
import java.util.List;

@Embedded
public class TachoCard {
    private List<String> dispatchAddressLines;
    private String dispatchPostCode;
    private Integer foreignDrivingLicenceID;
    private String MSCode;
    private String MSTachoNumber;
    private String number;
    private Integer postalAddressID;
    private String cardType;
    private Integer VOSAPartyID;
    private Integer workshopID;
    private String workshopNameOnCard;

    public List<String> getDispatchAddressLines() {
        return dispatchAddressLines;
    }

    public void setDispatchAddressLines(List<String> dispatchAddressLines) {
        this.dispatchAddressLines = dispatchAddressLines;
    }

    public String getDispatchPostCode() {
        return dispatchPostCode;
    }

    public void setDispatchPostCode(String dispatchPostCode) {
        this.dispatchPostCode = dispatchPostCode;
    }

    public Integer getForeignDrivingLicenceID() {
        return foreignDrivingLicenceID;
    }

    public void setForeignDrivingLicenceID(Integer foreignDrivingLicenceID) {
        this.foreignDrivingLicenceID = foreignDrivingLicenceID;
    }

    public String getMSCode() {
        return MSCode;
    }

    public void setMSCode(String MSCode) {
        this.MSCode = MSCode;
    }

    public String getMSTachoNumber() {
        return MSTachoNumber;
    }

    public void setMSTachoNumber(String MSTachoNumber) {
        this.MSTachoNumber = MSTachoNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getPostalAddressID() {
        return postalAddressID;
    }

    public void setPostalAddressID(Integer postalAddressID) {
        this.postalAddressID = postalAddressID;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getVOSAPartyID() {
        return VOSAPartyID;
    }

    public void setVOSAPartyID(Integer VOSAPartyID) {
        this.VOSAPartyID = VOSAPartyID;
    }

    public Integer getWorkshopID() {
        return workshopID;
    }

    public void setWorkshopID(Integer workshopID) {
        this.workshopID = workshopID;
    }

    public String getWorkshopNameOnCard() {
        return workshopNameOnCard;
    }

    public void setWorkshopNameOnCard(String workshopNameOnCard) {
        this.workshopNameOnCard = workshopNameOnCard;
    }
}
