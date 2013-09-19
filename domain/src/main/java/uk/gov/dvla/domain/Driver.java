package uk.gov.dvla.domain;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;

@Entity(value = "drivers", noClassnameStored = true)
public class Driver extends Person {

    @Indexed(unique = true)
    private String currentDriverNumber = null;
    private List<DriverNumber> driverNumberHistory;
    private List<DriverFlag> flags;
    private Licence licence;
    private DriverStatus status;
    private DriverStatedFlags driverStatedFlags;
    private Date firstProvisionalDate;
    private Date disqualifiedUntilDate;
    private String HROType;
    private List<ConductCase> conductCases;
    private List<Disqualification> disqualifications;

    private List<TachoCard> tachoCards;
    private List<CertificateOfProfessionalCompetence> CPCs;
    private List<DriverQualificationCard> DQCs;
    private List<TestPass> testPasses;
    private List<String> errorCodes;
    private boolean nslInCorruptedRange;
    private List<LicenceToken> licenceTokens;

    // TODO: Remove once Meirion's code is pushed to master
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addErrorCode(String code) {
        if (null == errorCodes) {
            errorCodes = new ArrayList<String>();
        }
        errorCodes.add(code);
    }

    public void addDriverFlag(DriverFlag flag)
    {
        if(null == flags)
        {
            flags = new ArrayList<DriverFlag>();
        }
        flags.add(flag);
    }

    public void addTestPass(TestPass testPass)
    {
        if(null == testPasses)
        {
            testPasses = new ArrayList<TestPass>();
        }
        testPasses.add(testPass);
    }

    public String getCurrentDriverNumber() {
        return currentDriverNumber;
    }

    public void setCurrentDriverNumber(String currentDriverNumber) {
        this.currentDriverNumber = currentDriverNumber;
    }

    public List<DriverNumber> getDriverNumberHistory() {
        return driverNumberHistory;
    }

    public void setDriverNumberHistory(List<DriverNumber> driverNumberHistory) {
        this.driverNumberHistory = driverNumberHistory;
    }

    public List<DriverFlag> getFlags() {
        return flags;
    }

    public void setFlags(List<DriverFlag> flags) {
        this.flags = flags;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
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

    public List<TestPass> getTestPasses() {
        return testPasses;
    }

    public void setTestPasses(List<TestPass> testPasses) {
        this.testPasses = testPasses;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    public boolean isNslInCorruptedRange() {
        return nslInCorruptedRange;
    }

    public void setNslInCorruptedRange(boolean nslInCorruptedRange) {
        this.nslInCorruptedRange = nslInCorruptedRange;
    }

    public TestPass getTestPassForEntitlement(Entitlement ent)
    {
        ArrayList<TestPass> possibleTestPasses = new ArrayList<TestPass>();

        if(testPasses == null)
        {
            return null;
        }
        for(TestPass testPass : testPasses)
        {
            if(testPass.getEntitlementType().equals(ent.getCode()))
            {
                possibleTestPasses.add(testPass);
            }
        }

        if(possibleTestPasses.size() == 0)
        {
            return null;
        }
        else
        {
            //Ensure the most recent is returned
            Collections.reverse(possibleTestPasses);
            return possibleTestPasses.get(0);
        }
    }

    public List<LicenceToken> getLicenceTokens() {
        return licenceTokens;
    }

    public void setLicenceTokens(List<LicenceToken> licenceTokens) {
        this.licenceTokens = licenceTokens;
    }
}
