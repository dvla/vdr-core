package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

import java.lang.Boolean;
import java.lang.String;

@Embedded
public class DriverStatedFlags {

    private Boolean duplicateOfLicence;
    private Boolean exchangeOfLicence;
    private Boolean higherFeePaid;
    private Boolean onYoungDriverScheme;
    private Boolean lifeFeePaid;
    private Boolean medicalInvestigationRequiredForLicenceIssue;
    private Boolean ordinaryMedicalInvestigationInProgress;
    private Boolean ordinaryMedicalDeclarationMade;
    private Boolean ordinaryMedicalPapersHeld;
    private String photoInvitationSent;
    private Boolean receivesMobilityAllowance;
    private Boolean restrictedAsSpecifiedinSecretaryofStateNotice;
    private Boolean sightCorrectionRequired;
    private Boolean vocationalMedicalPapersHeld;
    private Boolean vocationalMedicalInvestigationInProgress;
    private Boolean excessEndorsements;

    public Boolean getDuplicateOfLicence() {
        return duplicateOfLicence;
    }

    public void setDuplicateOfLicence(Boolean duplicateOfLicence) {
        this.duplicateOfLicence = duplicateOfLicence;
    }

    public Boolean getExchangeOfLicence() {
        return exchangeOfLicence;
    }

    public void setExchangeOfLicence(Boolean exchangeOfLicence) {
        this.exchangeOfLicence = exchangeOfLicence;
    }

    public Boolean getHigherFeePaid() {
        return higherFeePaid;
    }

    public void setHigherFeePaid(Boolean higherFeePaid) {
        this.higherFeePaid = higherFeePaid;
    }

    public Boolean getOnYoungDriverScheme() {
        return onYoungDriverScheme;
    }

    public void setOnYoungDriverScheme(Boolean onYoungDriverScheme) {
        this.onYoungDriverScheme = onYoungDriverScheme;
    }

    public Boolean getLifeFeePaid() {
        return lifeFeePaid;
    }

    public void setLifeFeePaid(Boolean lifeFeePaid) {
        this.lifeFeePaid = lifeFeePaid;
    }

    public Boolean getMedicalInvestigationRequiredForLicenceIssue() {
        return medicalInvestigationRequiredForLicenceIssue;
    }

    public void setMedicalInvestigationRequiredForLicenceIssue(Boolean medicalInvestigationRequiredForLicenceIssue) {
        this.medicalInvestigationRequiredForLicenceIssue = medicalInvestigationRequiredForLicenceIssue;
    }

    public Boolean getOrdinaryMedicalInvestigationInProgress() {
        return ordinaryMedicalInvestigationInProgress;
    }

    public void setOrdinaryMedicalInvestigationInProgress(Boolean ordinaryMedicalInvestigationInProgress) {
        this.ordinaryMedicalInvestigationInProgress = ordinaryMedicalInvestigationInProgress;
    }

    public Boolean getOrdinaryMedicalDeclarationMade() {
        return ordinaryMedicalDeclarationMade;
    }

    public void setOrdinaryMedicalDeclarationMade(Boolean ordinaryMedicalDeclarationMade) {
        this.ordinaryMedicalDeclarationMade = ordinaryMedicalDeclarationMade;
    }

    public Boolean getOrdinaryMedicalPapersHeld() {
        return ordinaryMedicalPapersHeld;
    }

    public void setOrdinaryMedicalPapersHeld(Boolean ordinaryMedicalPapersHeld) {
        this.ordinaryMedicalPapersHeld = ordinaryMedicalPapersHeld;
    }

    public String getPhotoInvitationSent() {
        return photoInvitationSent;
    }

    public void setPhotoInvitationSent(String photoInvitationSent) {
        this.photoInvitationSent = photoInvitationSent;
    }

    public Boolean getReceivesMobilityAllowance() {
        return receivesMobilityAllowance;
    }

    public void setReceivesMobilityAllowance(Boolean receivesMobilityAllowance) {
        this.receivesMobilityAllowance = receivesMobilityAllowance;
    }

    public Boolean getRestrictedAsSpecifiedinSecretaryofStateNotice() {
        return restrictedAsSpecifiedinSecretaryofStateNotice;
    }

    public void setRestrictedAsSpecifiedinSecretaryofStateNotice(Boolean restrictedAsSpecifiedinSecretaryofStateNotice) {
        this.restrictedAsSpecifiedinSecretaryofStateNotice = restrictedAsSpecifiedinSecretaryofStateNotice;
    }

    public Boolean getSightCorrectionRequired() {
        return sightCorrectionRequired;
    }

    public void setSightCorrectionRequired(Boolean sightCorrectionRequired) {
        this.sightCorrectionRequired = sightCorrectionRequired;
    }

    public Boolean getVocationalMedicalPapersHeld() {
        return vocationalMedicalPapersHeld;
    }

    public void setVocationalMedicalPapersHeld(Boolean vocationalMedicalPapersHeld) {
        this.vocationalMedicalPapersHeld = vocationalMedicalPapersHeld;
    }

    public Boolean getVocationalMedicalInvestigationInProgress() {
        return vocationalMedicalInvestigationInProgress;
    }

    public void setVocationalMedicalInvestigationInProgress(Boolean vocationalMedicalInvestigationInProgress) {
        this.vocationalMedicalInvestigationInProgress = vocationalMedicalInvestigationInProgress;
    }

    public Boolean getExcessEndorsements() {
        return excessEndorsements;
    }

    public void setExcessEndorsements(Boolean excessEndorsements) {
        this.excessEndorsements = excessEndorsements;
    }
}
