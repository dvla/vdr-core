package uk.gov.dvla.services.authentication;


import uk.gov.dvla.domain.authentication.AuthenticationToken;
import uk.gov.dvla.services.ManagedService;
import uk.gov.dvla.services.authentication.exceptions.AuthenticationException;

import java.util.List;

public interface AuthenticationProvider<A extends AuthenticationToken> extends ManagedService
{
    public static final String AUTHENTICATION_URI = "/auth/";
    public static final String DLN_SEARCH = "/dln/";
    public static final String DETAILS_SEARCH = "/details/";
    public static final String DLN_PARAM = "dln";
    public static final String SURNAME_PARAM = "sn";
    public static final String DOB_PARAM = "d";
    public static final String NINO_PARAM = "n";
    public static final String POSTCODE_PARAM = "p";

    public List<A> authenticate(A authToken) throws AuthenticationException;
}
