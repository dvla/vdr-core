package uk.gov.dvla.services.authentication.exceptions;


import uk.gov.dvla.services.authentication.exceptions.AuthenticationException;

public class BadCredentialsException extends AuthenticationException {

    public BadCredentialsException(String msg) {
        super(msg);
    }

    public BadCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }
}
