package uk.gov.dvla.services.datastore;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;
import uk.gov.dvla.services.ManagedService;
import uk.gov.dvla.services.NamedService;

public interface DriverDatastore extends Datastore, ManagedService
{
	public Driver findByDln(String dln);
	
	public Driver findByPersonalDetails(Person person);

}
