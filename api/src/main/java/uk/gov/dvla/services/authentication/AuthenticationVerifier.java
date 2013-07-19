package uk.gov.dvla.services.authentication;


import uk.gov.dvla.domain.authentication.AuthenticationToken;
import uk.gov.dvla.services.authentication.exceptions.AuthenticationException;

import java.util.List;

public interface AuthenticationVerifier<A extends AuthenticationToken>
{
    public List<A> verify(A authToken) throws AuthenticationException;
}
