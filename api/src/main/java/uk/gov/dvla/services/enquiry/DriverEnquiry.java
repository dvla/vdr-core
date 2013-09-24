package uk.gov.dvla.services.enquiry;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;
import uk.gov.dvla.services.ManagedService;

public interface DriverEnquiry extends ManagedService
{
    public static final String EXTERNAL_DRIVER_URI = "/external/driver/";
    public static final String DRIVER_URI = "/driver/";
    public static final String DLN_SEARCH = "dlnSearch";
    public static final String PERSONAL_DETAILS_SEARCH = "personalDetailsSearch";
    public static final String CUSTOMER_PORTAL = "customer.portal";
    public static final String MIB = "mib";

    public static final String DLN_PARAM = "dln";
    public static final String ENQUIRY_ID_PARAM = "id";

    public static final String FORENAME_PARAM = "fn";
    public static final String SURNAME_PARAM = "sn";
    public static final String DOB_PARAM = "d";
    public static final String GENDER_PARAM = "g";
    public static final String POSTCODE_PARAM = "p";

    public static final String SERVICE_TYPE_PARAM = "type";

    public static final String CONTACT_CHANNEL_PARAM = "cc";
    public static final String ENQUIRY_REASON_PARAM = "er";

    public Driver get(String dln);

    public Driver get(Person person);

    public Driver get(String forename, String surname, String dob,
                      String gender, String postCode);
}
