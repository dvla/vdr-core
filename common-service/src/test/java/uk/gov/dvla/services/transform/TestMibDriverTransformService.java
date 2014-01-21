package uk.gov.dvla.services.transform;

import org.joda.time.DateTime;
import org.junit.Test;
import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.EntitlementType;
import uk.gov.dvla.domain.mib.MibDTO;
import uk.gov.dvla.services.mib.MibDriverTransformService;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        List<String> messages = new ArrayList<String>();
        messages.add("Message Description1");
        messages.add("Message Description2");

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
        RulesDriver rulesDriver = new RulesDriver();
        rulesDriver.setDriver(driver);
        MibDTO result = transformService.transform(rulesDriver);
        MibDTO.Licence licenceResult = result.getLicence();

        assertEquals("Licence Valid From returned", validFrom, licenceResult.getValidFrom());
        assertEquals("Licence Valid To returned", validTo, licenceResult.getValidTo());
        assertEquals("Directive Status returned", directiveStatus2, licenceResult.getDirectiveIndicator());

        List<MibDTO.Entitlement> entResult = licenceResult.getEntitlements();
        assertEquals("3 Entitlements returned", 3, entResult.size());
        AssertExpectedEntitlementFieldsReturned(entResult.get(0), "abc", datePassed, dateUnclaimedExpires, EntitlementType.UnclaimedTestPass);
        AssertExpectedEntitlementFieldsReturned(entResult.get(1), "def", validFrom, validTo, EntitlementType.Full);
        AssertExpectedEntitlementFieldsReturned(entResult.get(2), "ghi", validFrom, validTo, EntitlementType.Provisional);

        List<MibDTO.Endorsement> endResult = licenceResult.getEndorsements();
        assertEquals("2 Endorsements returned", 2, endResult.size());
        AssertExpectedEndorsementFieldsReturned(endResult.get(0), "CU20");
        AssertExpectedEndorsementFieldsReturned(endResult.get(1), "CU21");
    }

    private void AssertExpectedEntitlementFieldsReturned(MibDTO.Entitlement entitlement, String code, Date validFrom,
                                                           Date validTo, EntitlementType type) throws ParseException {
        assertEquals("Entitlement Code returned", code, entitlement.getCode());
        assertEqualDates("Entitlement Valid From Date returned", validFrom, entitlement.getValidFrom());
        assertEqualDates("Entitlement Valid To Date returned", validTo, entitlement.getValidTo());
        assertEquals("Entitlement Type returned", type, entitlement.getType());
        assertEquals("2 Entitlement Restrictions returned", 2, entitlement.getRestrictions().size());
        assertEquals("1st Entitlement Restriction type returned", "79", entitlement.getRestrictions().get(0).getType());
        assertEquals("1st Entitlement Restriction info returned", "(tri)", entitlement.getRestrictions().get(0).getInfo());
        assertEquals("2nd Entitlement Restriction type returned", "45", entitlement.getRestrictions().get(1).getType());
        assertEquals("2nd Entitlement Restriction info returned", "", entitlement.getRestrictions().get(1).getInfo());
    }

    private void AssertExpectedEndorsementFieldsReturned(MibDTO.Endorsement endorsement, String code) throws ParseException {
        assertEquals("Endorsement Code returned", code, endorsement.getCode());
        assertEquals("Endorsement Offence Date returned", defaultOffenceDate, endorsement.getOffenceDate());
        assertEquals("Endorsement Conviction Date returned", defaultConvictionDate, endorsement.getConvictionDate());
        assertEquals("Endorsement Period returned", defaultPeriod, endorsement.getDisqualPeriod());

        //According to MIB specification v0.11 fines should be integers
        assertEquals("Endorsement Fine returned", defaultFine.intValue(), endorsement.getFine());
    }

    private Entitlement createSampleEntitlement(String code, Boolean isProvisional) throws ParseException {

        Entitlement sample = new Entitlement();
        sample.setCode(code);
        sample.setValidFrom(validFrom);
        sample.setValidTo(validTo);
        sample.setProvisional(isProvisional);

        List<EntitlementRestriction> restrictions = new ArrayList<EntitlementRestriction>();
        restrictions.add(new EntitlementRestriction("79", "(tri)"));
        restrictions.add(new EntitlementRestriction("45", ""));
        sample.setRestrictions(restrictions);

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

    private void assertEqualDates(String message, Date expectedDate, Date actualDate ){
        assertEquals(message, new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(expectedDate), new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(actualDate));
    }


}
