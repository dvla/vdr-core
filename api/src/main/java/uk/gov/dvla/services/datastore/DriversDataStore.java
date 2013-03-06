package uk.gov.dvla.services.datastore;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;

public interface DriversDataStore 
{
	public Driver findByDln(String dln);
	
	public Driver findByPersonalDetails(Person person);
	
	public boolean isAlive() throws Exception;
}
