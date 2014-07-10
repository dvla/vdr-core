package uk.gov.dvla.services.authentication;


import uk.gov.dvla.domain.authentication.AuthenticationToken;
import uk.gov.dvla.services.ManagedService;
import uk.gov.dvla.services.authentication.exceptions.AuthenticationException;

import java.util.List;

public interface AuthenticationProvider<A extends AuthenticationToken> extends ManagedService {
    public static final String yes = "y";
    public static final String no = "n";
    public static final String AUTHENTICATION_URI = "/auth/";
    public static final String PARTY_ID_AUTHENTICATION_URI = "auth/party/";


    public A authenticate(A authToken) throws AuthenticationException;
}
