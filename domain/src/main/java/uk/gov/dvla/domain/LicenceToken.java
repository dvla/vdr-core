package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;

import java.lang.Boolean;
import java.lang.String;
import java.util.Date;

@Embedded
public class LicenceToken {

    @Property("cntptIssNumSuffix")
    private String counterpartIssueNumberSuffix;
    private LicenceTokenStatus currentStatus;
    private Date dateOfIssue;
    private String issueNumber;
    private String issuingAuthority;
    private String languageType;
    @Property("pprDocNum")
    private String paperDocumentNumber;
    @Property("photoBarNum")
    private String photocardBarcodeNumber;
    private String typeCode;
    private String type;
    private Boolean cancelled;
    private Boolean claimed;
    private String cardNum;

    public String getCounterpartIssueNumberSuffix() {
        return counterpartIssueNumberSuffix;
    }

    public void setCounterpartIssueNumberSuffix(String counterpartIssueNumberSuffix) {
        this.counterpartIssueNumberSuffix = counterpartIssueNumberSuffix;
    }

    public LicenceTokenStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(LicenceTokenStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public String getLanguageType() {
        return languageType;
    }

    public void setLanguageType(String languageType) {
        this.languageType = languageType;
    }

    public String getPaperDocumentNumber() {
        return paperDocumentNumber;
    }

    public void setPaperDocumentNumber(String paperDocumentNumber) {
        this.paperDocumentNumber = paperDocumentNumber;
    }

    public String getPhotocardBarcodeNumber() {
        return photocardBarcodeNumber;
    }

    public void setPhotocardBarcodeNumber(String photocardBarcodeNumber) {
        this.photocardBarcodeNumber = photocardBarcodeNumber;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Boolean getClaimed() {
        return claimed;
    }

    public void setClaimed(Boolean claimed) {
        this.claimed = claimed;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
