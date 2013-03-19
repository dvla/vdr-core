package uk.gov.dvla.services.enquiry;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;
import uk.gov.dvla.services.ManagedService;
import uk.gov.dvla.services.NamedService;

public interface DriverEnquiry extends ManagedService
{
    public static final String DRIVER_URI = "/driver/";

	public Driver get(String dln);
	
	public Driver get(Person person);
}
