package uk.gov.dvla.services.transform;

import org.junit.Assert;
import org.junit.Test;
import uk.gov.dvla.domain.*;
import uk.gov.dvla.domain.mib.MibDTO;

import java.util.ArrayList;
import java.util.List;

public class TestMibDriverTransformLicenceStatus {

    @Test
    public void testFullLicence() {

        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResult("F"));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("FC", driverResult.getLicence().getStatus());
    }

    @Test
    public void testProvLicence() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResult("A"));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("PC", driverResult.getLicence().getStatus());
    }

    @Test
    public void testExpiredFullLicence() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResult("G"));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("FE", driverResult.getLicence().getStatus());
    }

    @Test
    public void testExpiredProvLicence() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResult("B"));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("PE", driverResult.getLicence().getStatus());
    }

    @Test
    public void testDisqualifiedLicence() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResult("E"));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("DQ", driverResult.getLicence().getStatus());
    }

    @Test
    public void testDisqualifiedUntilGivenDate() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResultWithMessage(Message.DISQUALIFIED_UNTIL_DATE));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("DD", driverResult.getLicence().getStatus());
    }

    @Test
    public void testDisqualifiedForLife() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResultWithMessage(Message.DISQUALIFIED_FOR_LIFE));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("DX", driverResult.getLicence().getStatus());
    }

    @Test
    public void testDisqualifiedUntilDateWithTestPassRequired() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResultWithMessage(Message.DISQUALIFIED_REAPPLY_WITH_DATE));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("DP", driverResult.getLicence().getStatus());
    }

    @Test
    public void testDisqualifiedUntilDateWithTestPassRequired2() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResultWithMessage(Message.NOT_DISQUALIFIED_UNTIL_DATE));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("DP", driverResult.getLicence().getStatus());
    }

    @Test
    public void testLicenceRevoked() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResultWithMessage(Message.LICENCE_REVOKED));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("RV", driverResult.getLicence().getStatus());
    }

    @Test
    public void testDisqualifiedUntilSentencing() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResultWithMessage(Message.DISQUALIFIED_UNTIL_SENTENCING));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("DS", driverResult.getLicence().getStatus());
    }

    @Test
    public void testLicenceRevoked2() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResultWithMessage(Message.LICENCE_REVOKED));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("RV", driverResult.getLicence().getStatus());
    }

    @Test
    public void testLicenceDisqualified() {
        MibDriverTransformService transformService = new MibDriverTransformService();
        MibDTO result = transformService.transform(buildServiceResultWithMessage(Message.DISQUALIFIED));
        MibDTO.Driver driverResult = result.getDriver();

        // Test correct licence status is returned
        Assert.assertNotNull(driverResult);
        Assert.assertEquals("DQ", driverResult.getLicence().getStatus());
    }

    private Driver buildDriver(String statusCode) {
        Driver driver = new Driver();
        DriverStatus driverStatus = new DriverStatus();
        driverStatus.setCode(statusCode);

        driver.setStatus(driverStatus);

        driver.setLicence(new Licence());
        return driver;
    }

    private ServiceResult<Driver> buildServiceResult(String statusCode) {
        return new ServiceResult<Driver>(buildDriver(statusCode));
    }

    private ServiceResult<Driver> buildServiceResultWithMessage(String message) {
        List<String> messages = new ArrayList<String>();
        messages.add(message);
        return new ServiceResult<Driver>(buildDriver("F"), messages);
    }
}
