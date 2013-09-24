package uk.gov.dvla.services.enquiry;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;
import uk.gov.dvla.services.ManagedService;

public interface DriverEnquiry extends ManagedService
{
    public static final String CUSTOMER_PORTAL_SERVICE_ENDPOINT = "/driver/";
    public static final String MIB_SERVICE_ENDPOINT = "/iiadd/api/v1/driver";
    public static final String MIB_SERVICE_VERSION_NUMBER = "1";
    public static final String CUSTOMER_PORTAL = "customer.portal";
    public static final String MIB = "mib";

    public Driver get(String dln);

    public Driver get(Person person);

    public Driver get(String forename, String surname, String dob,
                      String gender, String postCode);
}
