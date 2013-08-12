package uk.gov.dvla.services.authentication;

import uk.gov.dvla.domain.authentication.AuthenticationToken;
import uk.gov.dvla.services.authentication.exceptions.AuthenticationException;

public interface AuthenticationMatcher<A extends AuthenticationToken>
{
    public Boolean match(A authToken) throws AuthenticationException;
}