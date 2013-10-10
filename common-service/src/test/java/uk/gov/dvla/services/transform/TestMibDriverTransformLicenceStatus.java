package uk.gov.dvla.services.transform;

import org.junit.Assert;
import org.junit.Test;
import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.MibDTO;
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
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.disqualified.until.date"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DD", licenceResult.getStatus());
    }

    @Test
    public void testDisqualifiedForLife() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.disqualified.for.life"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DX", licenceResult.getStatus());
    }

    @Test
    public void testDisqualifiedUntilDateWithTestPassRequired() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.disqualified.reapply.with.date"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DP", licenceResult.getStatus());
    }

    @Test
    public void testDisqualifiedUntilDateWithTestPassRequired2() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.not.disqualified.reapply.with.date"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DP", licenceResult.getStatus());
    }

    @Test
    public void testLicenceRevoked() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.revoked.reapply"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("RV", licenceResult.getStatus());
    }

    @Test
    public void testDisqualifiedUntilSentencing() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.disqualified.until.sentencing"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DS", licenceResult.getStatus());
    }

    @Test
    public void testLicenceRevoked2() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.revoked"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("RV", licenceResult.getStatus());
    }

    @Test
    public void testLicenceDisqualified() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.disqualified"));
        MibDTO.Licence licenceResult = result.getLicence();

        // Test correct licence status is returned
        Assert.assertNotNull(licenceResult);
        Assert.assertEquals("DQ", licenceResult.getStatus());
    }

    @Test
    public void testLicenceDisqualifiedReapply() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildRulesDriverWithMessage("F", "licence.status.disqualified.reapply"));
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

    private List<Message> buildMessage(String message) {
        List<Message> messages = new ArrayList<Message>();
        messages.add(new Message((message)));
        return messages;
    }

    private RulesDriver buildRulesDriverWithMessage(String statusCode, String message) {
        RulesDriver driver = buildRulesDriver(statusCode);
        driver.setMessages(buildMessage(message));
        return driver;
    }
}
