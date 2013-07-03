package uk.gov.dvla.services.transform;

import org.joda.time.DateTime;
import org.junit.Test;
import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.EntitlementType;
import uk.gov.dvla.domain.mib.MibDTO;
import uk.gov.dvla.domain.mib.TestPassStatus;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TestMibDriverTransformService {

    private final Date validFrom = new DateTime().minusMonths(13).toDate();
    private final Date validTo = new DateTime().minusMonths(13).plusYears(10).toDate();
    private final Date datePassed = new DateTime().minusMonths(6).toDate();
    private final Date dateUnclaimedExpires = new DateTime().minusMonths(6).plusYears(2).toDate();
    private final Date defaultOffenceDate = new DateTime().minusMonths(8).toDate();
    private final Date defaultSentencingDate = new DateTime().minusMonths(7).toDate();
    private final Date defaultConvictionDate = new DateTime().minusMonths(7).toDate();
    private final String defaultPeriod = "P12M";
    private final Double defaultFine = 123.99;

    @Test
    public void transform_contains_all_expected_fields() throws ParseException {
        Driver driver = new Driver();
        Licence lic = new Licence();
        final Integer directiveStatus2 = 2;
        final UUID enquiryId = UUID.randomUUID();

        List<Message> messages = new ArrayList<Message>();
        Message message1 = new Message("Message Description1", false);
        Message message2 = new Message("Message Description2", true);
        messages.add(message1);
        messages.add(message2);

        lic.setValidFrom(validFrom);
        lic.setValidTo(validTo);
        lic.setDirectiveStatus(directiveStatus2);

        Entitlement unclaimedTestPassEntitlement = createSampleEntitlement("abc", true);
        Entitlement claimedTestPassEntitlement = createSampleEntitlement("def", false);
        Entitlement cancelledTestPassEntitlement = createSampleEntitlement("ghi", true);

        List<Entitlement> entitlements = new ArrayList<Entitlement>();
        entitlements.add(unclaimedTestPassEntitlement);
        entitlements.add(claimedTestPassEntitlement);
        entitlements.add(cancelledTestPassEntitlement);
        lic.setEntitlements(entitlements);

        TestPass unclaimedTestPass = createSampleTestPass("abc", datePassed, uk.gov.dvla.domain.TestPassStatus.NotYetClaimed);
        TestPass claimedTestPass = createSampleTestPass("def", datePassed, uk.gov.dvla.domain.TestPassStatus.OnLicence);
        TestPass cancelledTestPass = createSampleTestPass("ghi", datePassed, uk.gov.dvla.domain.TestPassStatus.Cancelled);

        List<TestPass> testPasses = new ArrayList<TestPass>();
        testPasses.add(unclaimedTestPass);
        testPasses.add(claimedTestPass);
        testPasses.add(cancelledTestPass);
        driver.setTestPasses(testPasses);

        Endorsement endorsement1 = createSampleDisqualificationEndorsement("CU20");
        Endorsement endorsement2 = createSampleDisqualificationEndorsement("CU21");
        List<Endorsement> endorsements = new ArrayList<Endorsement>();
        endorsements.add(endorsement1);
        endorsements.add(endorsement2);
        lic.setEndorsements(endorsements);

        driver.setLicence(lic);

        MibDriverTransformService transformService = new MibDriverTransformService();
        ServiceResult<MibDTO> result = transformService.transform(new ServiceResult<Driver>(enquiryId, driver, messages));
        MibDTO.Driver driverResult = result.getResult().getDriver();

        assertEquals("Licence Valid From returned", validFrom, driverResult.getLicence().getValidFrom());
        assertEquals("Licence Valid To returned", validTo, driverResult.getLicence().getValidTo());
        assertEquals("Directive Status returned", directiveStatus2, driverResult.getLicence().getDirectiveStatus());

        List<MibDTO.Entitlement> entResult = driverResult.getLicence().getEntitlements();
        assertEquals("3 Entitlements returned", 3, entResult.size());
        AssertExpectedEntitlementFieldsReturned(entResult.get(0), "abc", datePassed, dateUnclaimedExpires, EntitlementType.UnclaimedTestPass);
        AssertExpectedEntitlementFieldsReturned(entResult.get(1), "def", validFrom, validTo, EntitlementType.Full);
        AssertExpectedEntitlementFieldsReturned(entResult.get(2), "ghi", validFrom, validTo, EntitlementType.Provisional);

        List<MibDTO.Endorsement> endResult = driverResult.getLicence().getEndorsements();
        assertEquals("2 Endorsements returned", 2, endResult.size());
        AssertExpectedEndorsementFieldsReturned(endResult.get(0), "CU20");
        AssertExpectedEndorsementFieldsReturned(endResult.get(1), "CU21");
    }

    private void AssertExpectedEntitlementFieldsReturned(MibDTO.Entitlement entitlement, String code, Date validFrom,
                                                           Date validTo, EntitlementType type) throws ParseException {
        assertEquals("Entitlement Code returned", code, entitlement.getCode());
        assertEquals("Entitlement Valid From Date returned", validFrom, entitlement.getValidFrom());
        assertEquals("Entitlement Valid To Date returned", validTo, entitlement.getValidTo());
        assertEquals("Entitlement Type returned", type, entitlement.getType());
    }

    private void AssertExpectedEndorsementFieldsReturned(MibDTO.Endorsement endorsement, String code) throws ParseException {
        assertEquals("Endorsement Code returned", code, endorsement.getCode());
        assertEquals("Endorsement Offence Date returned", defaultOffenceDate, endorsement.getOffenceDate());
        assertEquals("Endorsement Conviction Date returned", defaultConvictionDate, endorsement.getConvictionDate());
        assertEquals("Endorsement Sentencing Date returned", defaultSentencingDate, endorsement.getSentencingDate());
        assertEquals("Endorsement Period returned", defaultPeriod, endorsement.getDisqualPeriod());
        assertEquals("Endorsement Fine returned", defaultFine, endorsement.getFine());
    }

    private Entitlement createSampleEntitlement(String code, Boolean isProvisional) throws ParseException {

        Entitlement sample = new Entitlement();
        sample.setCode(code);
        sample.setValidFrom(validFrom);
        sample.setValidTo(validTo);
        sample.setProvisional(isProvisional);

        return sample;
    }

    private Endorsement createSampleDisqualificationEndorsement(String offenceCode) throws ParseException {
        Endorsement sample = new Endorsement();
        sample.setCode(offenceCode);
        sample.setOffence(defaultOffenceDate);
        sample.setDisqual(true);
        sample.setConviction(defaultConvictionDate);
        sample.setSentencing(defaultSentencingDate);
        sample.setDuration(defaultPeriod);
        sample.setFine(defaultFine);

        return sample;
    }

    private TestPass createSampleTestPass(String entitlementType, Date datePassed, uk.gov.dvla.domain.TestPassStatus status)
    {
        TestPass testPass = new TestPass();
        testPass.setEntitlementType(entitlementType);
        testPass.setTestPassDate(datePassed);
        testPass.setStatusType(status.getTestPassStatus());
        return testPass;
    }

}
