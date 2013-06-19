package uk.gov.dvla.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.annotations.Property;

@Entity(value = "drivers", noClassnameStored = true)
public class Driver extends Person {

    private List<DriverNumber> driverNumberHistory;
    private List<DriverFlag> flags;
    private Licence licence;
    private List<Integer> restrictionKeys;
    private List<String> errorCodes;
    private DriverStatus status;
    private Date photoExpiryDate;
    private List<String> disqualificationStatusCodes;
    private boolean nslInCorruptedRange;
    private DriverStatedFlags driverStatedFlags;
    @Property("dln")
    @Indexed(unique = true)
    private String currentDriverNumber = null;
    private Date firstProvisionalDate;
    private Date disqualifiedUntilDate;
    private String HROType;
    private List<ConductCase> conductCases;
    private List<Disqualification> disqualifications;
    private List<TachoCard> tachoCards;
    private List<CertificateOfProfessionalCompetence> CPCs;
    private List<DriverQualificationCard> DQCs;
    private List<TestPass> testPasses;

    public void addRestrictionKey(Integer key) {
        if (null == restrictionKeys) {
            restrictionKeys = new ArrayList<Integer>();
        }
        restrictionKeys.add(key);
    }

    public void addErrorCode(String code) {
        if (null == errorCodes) {
            errorCodes = new ArrayList<String>();
        }
        errorCodes.add(code);
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    public Licence getLicence() {
        return this.licence;
    }

    public List<Integer> getRestrictionKeys() {
        return restrictionKeys;
    }

    public void setRestrictionKeys(List<Integer> keys) {
        this.restrictionKeys = keys;
    }

    public List<String> getErrorCodes() {
        return this.errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    public void setCurrentDriverNumber(String dln) {
        this.currentDriverNumber = dln;
    }

    public String getCurrentDriverNumber() {
        return this.currentDriverNumber;
    }

    public List<DriverNumber> getDriverNumberHistory() {
        return driverNumberHistory;
    }

    public void setDriverNumberHistory(List<DriverNumber> driverNumber) {
        this.driverNumberHistory = driverNumber;
    }

    public List<DriverFlag> getFlags() {
        return flags;
    }

    public void setFlags(List<DriverFlag> flags) {
        this.flags = flags;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public boolean isNslInCorruptedRange() {
        return nslInCorruptedRange;
    }

    public void setNslInCorruptedRange(boolean nslInCorruptedRange) {
        this.nslInCorruptedRange = nslInCorruptedRange;
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

    public List<TestPass> getTestPasses() {
        return testPasses;
    }

    public void setTestPasses(List<TestPass> testPasses) {
        this.testPasses = testPasses;
    }

    public DriverStatedFlags getDriverStatedFlags() {
        return driverStatedFlags;
    }

    public void setDriverStatedFlags(DriverStatedFlags driverStatedFlags) {
        this.driverStatedFlags = driverStatedFlags;
    }

    public Date getFirstProvisionalDate() {
        return firstProvisionalDate;
    }

    public void setFirstProvisionalDate(Date firstProvisionalDate) {
        this.firstProvisionalDate = firstProvisionalDate;
    }

    public Date getDisqualifiedUntilDate() {
        return disqualifiedUntilDate;
    }

    public void setDisqualifiedUntilDate(Date disqualifiedUntilDate) {
        this.disqualifiedUntilDate = disqualifiedUntilDate;
    }

    public String getHROType() {
        return HROType;
    }

    public void setHROType(String HROType) {
        this.HROType = HROType;
    }

    public List<ConductCase> getConductCases() {
        return conductCases;
    }

    public void setConductCases(List<ConductCase> conductCases) {
        this.conductCases = conductCases;
    }

    public List<Disqualification> getDisqualifications() {
        return disqualifications;
    }

    public void setDisqualifications(List<Disqualification> disqualifications) {
        this.disqualifications = disqualifications;
    }

    public List<TachoCard> getTachoCards() {
        return tachoCards;
    }

    public void setTachoCards(List<TachoCard> tachoCards) {
        this.tachoCards = tachoCards;
    }

    public List<CertificateOfProfessionalCompetence> getCPCs() {
        return CPCs;
    }

    public void setCPCs(List<CertificateOfProfessionalCompetence> CPCs) {
        this.CPCs = CPCs;
    }

    public List<DriverQualificationCard> getDQCs() {
        return DQCs;
    }

    public void setDQCs(List<DriverQualificationCard> DQCs) {
        this.DQCs = DQCs;
    }
}
