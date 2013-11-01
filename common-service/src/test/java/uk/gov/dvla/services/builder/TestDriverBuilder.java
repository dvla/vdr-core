package uk.gov.dvla.services.builder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.gov.dvla.services.builder.DriverBuilder;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.DriverFlag;
import uk.gov.dvla.services.randomise.DriverRandomiser;

public class TestDriverBuilder{

    private DriverBuilder db_i;
    private Driver driver_i;

    @Before
    public void setup(){

        db_i = new DriverBuilder();
        List<String> names = new ArrayList<String>();
        names.add("TEST");
        names.add("USER");
        
        db_i.age(30);
        db_i.gender(DriverRandomiser.MALE);
        db_i.nino("AA123456A");
        db_i.passport("12345678");
        db_i.stopMarker(1);
        db_i.stopMarker(2);
        db_i.title("MR");
        db_i.forename(names);
        db_i.surname("JUNIT");

        driver_i = db_i.build();
    }
    
    @Test
    public void testTitle()
    {
    	Assert.assertEquals("MR", driver_i.getName().getTitle());
    }
    
    @Test
    public void testStopMarkers()
    {
        List<DriverFlag> flags = driver_i.getFlags();
        for(DriverFlag flag : flags)
        {
            Assert.assertTrue(Arrays.asList("1","2").contains(flag.getFlag()));
        }
    }
    
    @Test
    public void testPassport()
    {
    	Assert.assertEquals("12345678", driver_i.getPassport().getNumber());
    }
    
    @Test
    public void testNino()
    {
    	Assert.assertEquals("AA123456A", driver_i.getNino());
    }
    
    @Test
    public void testGender()
    {
    	Assert.assertEquals(DriverRandomiser.MALE, driver_i.getGender());
    }
    

    @Test
    public void testForenamesAndInitials()
    {
        Assert.assertFalse(driver_i.getName().getGivenName().isEmpty());
        Assert.assertEquals(2, driver_i.getName().getGivenName().size());
        
        Assert.assertEquals("TU", driver_i.getName().getInitials());
    }
    
    @Test
    public void testSurname()
    {
    	Assert.assertEquals("JUNIT", driver_i.getName().getFamilyName());
    }

    
    @Test
    public void testAge()
    {
    	Calendar cal = Calendar.getInstance();
    	cal.roll(Calendar.YEAR, -30);
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");   	
    	
    	Assert.assertEquals(sdf.format(cal.getTime()), sdf.format(driver_i.getBirthDetails().getDate()));
    }
}