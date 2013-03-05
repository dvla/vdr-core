package uk.gov.dvla.services.enquiry;

import uk.gov.dvla.entity.Person;
import uk.gov.dvla.entity.drivers.Driver;

public interface DriverEnquiry 
{
	public Driver get(String dln);
	
	public Driver get(Person person);
}
