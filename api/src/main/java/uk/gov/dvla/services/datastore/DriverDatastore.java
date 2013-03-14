package uk.gov.dvla.services.datastore;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;

public interface DriverDatastore extends Datastore
{
	public Driver findByDln(String dln);
	
	public Driver findByPersonalDetails(Person person);

}
