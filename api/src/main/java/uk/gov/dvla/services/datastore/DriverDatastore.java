package uk.gov.dvla.services.datastore;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;
import uk.gov.dvla.services.ManagedService;
import uk.gov.dvla.services.NamedService;

import java.util.Date;
import java.util.List;

public interface DriverDatastore extends Datastore, ManagedService
{
	public Driver findByDln(String dln);
	
	public Driver findByPersonalDetails(List<String> forenames, String surname, Date dob, int gender, String postCode);

}
