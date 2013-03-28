package uk.gov.dvla.services.enquiry;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;
import uk.gov.dvla.domain.ServiceResult;
import uk.gov.dvla.services.ManagedService;
import uk.gov.dvla.services.NamedService;

public interface DriverEnquiry extends ManagedService
{
    public static final String DRIVER_URI = "/driver/";

    public static final String FORENAME_PARAM = "fn";
    public static final String SURNAME_PARAM = "sn";
    public static final String DOB_PARAM = "d";
    public static final String GENDER_PARAM = "g";
    public static final String POSTCODE_PARAM = "p";

	public Driver get(String dln);
	
	public Driver get(Person person);

    public Driver get(String forename, String surname, String dob,
                      String gender, String postCode);
}
