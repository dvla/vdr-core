package uk.gov.dvla.services.auth;

import uk.gov.dvla.domain.authentication.DriverAuthToken;
import uk.gov.dvla.services.ManagedService;

public interface DriverAuth extends ManagedService {
    public static final String AUTH_PORTAL_SERVICE_ENDPOINT = "/auth/";

    public DriverAuthToken authenticate(String dln);

    public DriverAuthToken authenticate(String forename, String surname, String dob,
                                        String gender, String postCode);
}
