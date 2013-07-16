package uk.gov.dvla.services.authentication;


import uk.gov.dvla.domain.authentication.Authentication;

import java.util.List;

public interface AuthenticationDetailsSource<A extends Authentication>
{
    public List<A> verify(A authenticationToken) throws AuthenticationException;
}
