package uk.gov.dvla.services.randomise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.gov.dvla.domain.Driver;

/**
 * Created with IntelliJ IDEA.
 * User: emerr
 * Date: 03/04/13
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */
public class TestDriverRandomiser
{
    DriverRandomiser randomiser = null;
    public static String[] checkChar = {"A","B","C","E","G","H","J","K","L","M","N","O","P",
            "R", "S", "T", "W", "X", "Y", "Z"};

    @Before
    public void setup()
    {
        randomiser = new DriverRandomiser();
    }

    @Test
    public void testDriverRandomiserWithErrorCodesBatch0()
    {
        Driver driver = randomiser.randomiseWithErrorCodes(0, false);
        Assert.assertNotNull(driver);
        Assert.assertNotNull(driver.getErrorCodes());
        Assert.assertEquals(5, driver.getErrorCodes().size());
        Assert.assertEquals("4005", driver.getErrorCodes().get(0));
        Assert.assertEquals("4069", driver.getErrorCodes().get(1));
        Assert.assertEquals("4206", driver.getErrorCodes().get(2));
        Assert.assertEquals("0101", driver.getErrorCodes().get(3));
        Assert.assertEquals("0201", driver.getErrorCodes().get(4));
    }

    @Test
    public void testDriverRandomiserWithErrorCodesBatch1()
    {
        Driver driver = randomiser.randomiseWithErrorCodes(1, false);
        Assert.assertNotNull(driver);
        Assert.assertNotNull(driver.getErrorCodes());
        Assert.assertEquals(5, driver.getErrorCodes().size());
        Assert.assertEquals("0301", driver.getErrorCodes().get(0));
        Assert.assertEquals("0601", driver.getErrorCodes().get(1));
        Assert.assertEquals("0602", driver.getErrorCodes().get(2));
        Assert.assertEquals("0701", driver.getErrorCodes().get(3));
        Assert.assertEquals("0702", driver.getErrorCodes().get(4));
    }

    @Test
    public void testDriverRandomiserWithErrorCodesBatch281()
    {
        Driver driver = randomiser.randomiseWithErrorCodes(281, false);
        Assert.assertNotNull(driver);
        Assert.assertNotNull(driver.getErrorCodes());
        Assert.assertEquals(2, driver.getErrorCodes().size());
        Assert.assertEquals("2705", driver.getErrorCodes().get(0));
        Assert.assertEquals("2701", driver.getErrorCodes().get(1));
    }

    @Test
    public void testDriverRandomiserWithReleaseErrorCodes()
    {
        Driver driver = randomiser.randomiseWithErrorCodes(1, true);
        Assert.assertNotNull(driver);
        Assert.assertNotNull(driver.getErrorCodes());
    }



    @Test
    public void testDLNCheckDigit()
    {
        Driver driver = randomiser.randomise();
        Assert.assertNotNull(driver);
        String dlnCheckChar1 = driver.getCurrentDriverNumber().substring(14,15);
        String dlnCheckChar2 = driver.getCurrentDriverNumber().substring(15);
        boolean foundChar1 = false;
        boolean foundChar2 = false;
        for (int i=0; i<checkChar.length; i++)
        {
            if (dlnCheckChar1.equals(checkChar[i]))
            {
                foundChar1 = true;
            }
            if (dlnCheckChar2.equals(checkChar[i]))
            {
                foundChar2 = true;
            }
        }

        Assert.assertTrue(foundChar1);
        Assert.assertTrue(foundChar2);

    }
}
