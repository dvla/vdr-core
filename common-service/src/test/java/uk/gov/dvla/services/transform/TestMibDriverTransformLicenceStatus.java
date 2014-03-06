package uk.gov.dvla.services.transform;

import org.junit.Assert;
import org.junit.Test;
import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.MibDTO;
import uk.gov.dvla.services.common.disqualifications.DisqualificationStatus;
import static uk.gov.dvla.services.common.disqualifications.DisqualificationStatus.*;
import uk.gov.dvla.services.mib.MibDriverTransformService;

import java.util.ArrayList;
import java.util.List;

public class TestMibDriverTransformLicenceStatus {

    @Test
    public void testFullLicence() {

        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriver("F"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("FC", licenceResult.getStatus());
    }

    @Test
    public void testProvLicence() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriver("A"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("PC", licenceResult.getStatus());
    }

    @Test
    public void testExpiredFullLicence() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriver("G"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("FE", licenceResult.getStatus());
    }

    @Test
    public void testExpiredProvLicence() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriver("B"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("PE", licenceResult.getStatus());
    }

    @Test
    public void testDisqualifiedLicence() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriver("E"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DQ", licenceResult.getStatus());
    }

    @Test
    public void testDisqualifiedUntilGivenDate() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithDisqualification("F", DISQ_UNTIL_DATE));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DD", licenceResult.getStatus());
    }

    @Test
    public void testDisqualifiedForLife() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithDisqualification("F", DISQ_FOR_LIFE));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DX", licenceResult.getStatus());
    }

    @Test
     public void testLicenceRevoked() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithDisqualification("E", REVOKED_TEST_PASS));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("RV", licenceResult.getStatus());
    }

    @Test
    public void testLicenceRevokedFE() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithDisqualification("G", REVOKED_FULL));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("FE", licenceResult.getStatus());
    }

    @Test
    public void testLicenceRevokedPE() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithDisqualification("B", REVOKED_PROV));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("PE", licenceResult.getStatus());
    }

    @Test
    public void testDisqualifiedUntilSentencing() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithDisqualification("F", DISQ_UNTIL_SENTENCING));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DS", licenceResult.getStatus());
    }

    @Test
    public void testLicenceDisqualifiedUntilTestsPass() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithDisqualification("F", DISQ_TEST_PASS));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DT", licenceResult.getStatus());
    }

    private Driver buildDriver(String statusCode) {
        Driver driver = new Driver();
        DriverStatus driverStatus = new DriverStatus();
        driverStatus.setCode(statusCode);

        driver.setStatus(driverStatus);

        driver.setLicence(new Licence());
        return driver;
    }

    private RulesDriver buildRulesDriver(String statusCode) {
        RulesDriver driver = new RulesDriver();
        driver.setDriver(buildDriver(statusCode));
        return driver;
    }

    private List<Message> buildMessage(String message, Object extra) {
        List<Message> messages = new ArrayList<Message>();
        messages.add(new Message(message, MessageType.LicenceStatusModified, extra));
        return messages;
    }

    private RulesDriver buildRulesDriverWithMessage(String statusCode, String message) {
        return buildRulesDriverWithMessage(statusCode, message, null);
    }

    private RulesDriver buildRulesDriverWithDisqualification(String statusCode, DisqualificationStatus disq) {
        return buildRulesDriverWithMessage(statusCode, disq.portalBanner, disq);
    }

    private RulesDriver buildRulesDriverWithMessage(String statusCode, String message, Object extra) {
        RulesDriver driver = buildRulesDriver(statusCode);
        driver.setMessages(buildMessage(message, extra));
        return driver;
    }
}
