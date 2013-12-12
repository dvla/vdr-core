package uk.gov.dvla.services.enquiry;

import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Person;
import uk.gov.dvla.services.ManagedService;

public interface DriverEnquiry extends ManagedService {
    public static final String MIB_SERVICE_ENDPOINT = "/iiadd/api/v1/driver";
    public static final String MIB_SERVICE_VERSION_NUMBER = "1";
    public static final String CUSTOMER_PORTAL_SERVICE_ENDPOINT = "/driver/";
    public static final String CUSTOMER_PORTAL_SERVICE_ENDPOINT_PARTY_SEARCH = "/driver/party";
    public static final String HEALTH_CHECK_ENDPOINT = "/healthcheck";
    public static final String DCS_SERVICE_ENDPOINT = "/search";
    public static final String DLN_SEARCH = "dlnSearch";
    public static final String PERSONAL_DETAILS_SEARCH = "personalDetailsSearch";
    public static final String PARTY_ID = "partyIdSearch";
    public static final String CUSTOMER_PORTAL = "customer.portal";
    public static final String MIB = "mib";
    public static final String NINO_PARAM = "n";

    public static final String MESSAGE_ENQUEUER_ENDPOINT = "/enqueue/";

    public static final String DLN_PARAM = "dln";
    public static final String PARTY_ID_PARAM = "id";
    public static final String ENQUIRY_ID_PARAM = "guid";

    public static final String FORENAME_PARAM = "fn";
    public static final String SURNAME_PARAM = "sn";
    public static final String DOB_PARAM = "d";
    public static final String GENDER_PARAM = "g";
    public static final String POSTCODE_PARAM = "pc";

    public static final String VEHICLE_REGISTRATION_MARK_PARAM = "vrm";

    public static final String SERVICE_TYPE_PARAM = "type";

    public static final String CONTACT_CHANNEL_PARAM = "cc";
    public static final String ENQUIRY_REASON_PARAM = "er";

    public Driver get(String dln);

    public Driver get(Person person);

    public Driver get(String forename, String surname, String dob,
                      String gender, String postCode);

    public Driver getByPartyId(String partyId);
}
