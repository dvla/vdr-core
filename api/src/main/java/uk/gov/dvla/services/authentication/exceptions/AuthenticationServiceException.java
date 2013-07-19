package uk.gov.dvla.services.authentication.exceptions;

import uk.gov.dvla.services.authentication.exceptions.AuthenticationException;

public class AuthenticationServiceException extends AuthenticationException {

    public AuthenticationServiceException(String msg) {
        super(msg);
    }

    public AuthenticationServiceException(String msg, Throwable t) {
        super(msg, t);
    }
}