package uk.gov.dvla.services.enquiry;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;

public interface DriverEnquiry 
{
	public Driver get(String dln);
	
	public Driver get(Person person);
}
