package uk.gov.dvla.services.datastore;

import uk.gov.dvla.entity.Person;
import uk.gov.dvla.entity.drivers.Driver;

public interface DriversDataStore 
{
	public Driver findByDln(String dln);
	
	public Driver findByPersonalDetails(Person person);
	
	public boolean isAlive() throws Exception;
}
