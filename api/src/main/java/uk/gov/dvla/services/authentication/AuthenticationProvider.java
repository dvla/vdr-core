package uk.gov.dvla.services.authentication;


import uk.gov.dvla.domain.authentication.Authentication;
import uk.gov.dvla.services.ManagedService;

public interface AuthenticationProvider<A extends Authentication> extends ManagedService
{
    public A authenticate(A authToken) throws AuthenticationException;
}
