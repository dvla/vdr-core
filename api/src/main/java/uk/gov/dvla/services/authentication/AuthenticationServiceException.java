package uk.gov.dvla.services.authentication;

public class AuthenticationServiceException extends AuthenticationException {

    public AuthenticationServiceException(String msg) {
        super(msg);
    }

    public AuthenticationServiceException(String msg, Throwable t) {
        super(msg, t);
    }
}