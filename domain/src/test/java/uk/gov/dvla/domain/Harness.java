package uk.gov.dvla.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.code.morphia.query.Query;

public class Harness extends AbstractMongoParent {

	
	public void testInsert() {

		int iteration = 1;
		int batchSize = 10000;
		
		for (int j = 1; j <= iteration; j++) 
		{
			List<Driver> drivers = new ArrayList<Driver>();
			for (int i = 0; i < batchSize; i++) 
			{
				Driver dr = new Driver();
				Name name = new Name();
				Licence lic = new Licence();
				lic.setValidFrom(new Date());
				lic.setValidTo(new Date());
				lic.addEntitlement("B1");
				lic.addEntitlement("C3");
				if (i % 10 == 0) {
					lic.addEntitlement("FG");
				}
				name.addGivenName("John");
				name.setFamilyName("Smith");
				name.setTitle("Mr");
				dr.setName(name);
				dr.addLicence(lic);
				dr.setDob(new Date());
				dr.setNationalInsuranceNumber("AA12345678A");
				dr.addDriverNumber();
				if (i % 10 == 0) {
					dr.addDriverNumber();
				}

				drivers.add(dr);
			}

			getDs().save(drivers);
			System.out.println("Added batch: #" + iteration + " Total Records " + iteration*batchSize);
		}
	}

	@Test	
	public void testFindEndts() throws Exception
	{
		
		List<Driver> drivers = getDs().find(Driver.class).field("licence.entitlements.code").equal("A").asList();
		
		Assert.assertFalse(drivers.isEmpty());
		
	}

}
